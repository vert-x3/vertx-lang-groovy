/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.vertx.lang.groovy;

import groovy.lang.GroovyClassLoader;
import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.ConstructorNode;
import org.codehaus.groovy.ast.FieldNode;
import org.codehaus.groovy.ast.GenericsType;
import org.codehaus.groovy.ast.ImportNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.ModuleNode;
import org.codehaus.groovy.ast.Parameter;
import org.codehaus.groovy.ast.expr.CastExpression;
import org.codehaus.groovy.ast.expr.ClassExpression;
import org.codehaus.groovy.ast.expr.ClosureExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.ExpressionTransformer;
import org.codehaus.groovy.ast.expr.PropertyExpression;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
import org.codehaus.groovy.ast.stmt.ForStatement;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.GenericsVisitor;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@GroovyASTTransformation(phase= CompilePhase.CONVERSION)
public class VertxTransformation implements ASTTransformation {

  private GroovyClassLoader loader;
  private final Map<String, Boolean> relocatedTypes = new HashMap<>();

  @Override
  public void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
    loader = sourceUnit.getClassLoader();
    try {
      Stream.of(astNodes).forEach(this::visit);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void visit(ASTNode node) {
    if (node instanceof ModuleNode) {
      visit((ModuleNode)node);
    }
  }

  private void visit(ModuleNode moduleNode) {
    for (ImportNode importNode : moduleNode.getImports()) {
      if (shouldTransformClass(importNode.getType())) {
        moduleNode.addImport(importNode.getAlias(), rewriteType(importNode.getType()));
      }
    }
    for (MethodNode methodNode : moduleNode.getMethods()) {
      visit(moduleNode, methodNode);
    }
    for (ClassNode classNode : moduleNode.getClasses()) {
      for (ConstructorNode constructorNode : classNode.getDeclaredConstructors()) {
        visit(moduleNode, constructorNode);
      }
      for (FieldNode fieldNode : classNode.getFields()) {
        visit(fieldNode);
      }
      for (MethodNode methodNode : classNode.getMethods()) {
        visit(moduleNode, methodNode);
      }
    }
  }

  private void visit(FieldNode fieldNode) {
    fieldNode.setType(handleType(fieldNode.getType()));
    fieldNode.setOriginType(handleType(fieldNode.getOriginType()));
  }

  private void visit(ModuleNode moduleNode, MethodNode methodNode) {
    for (Parameter param : methodNode.getParameters()) {
      handleParam(param);
    }
    methodNode.setReturnType(handleType(methodNode.getReturnType()));
    Statement code = methodNode.getCode();
    if (code != null) {
      visit(moduleNode, code);
    }
  }

  private void visit(ModuleNode module, Statement statement) {
    statement.visit(new GenericsVisitor(module.getContext()) {
      @Override
      public void visitForLoop(ForStatement forLoop) {
        forLoop.setCollectionExpression(forLoop.getCollectionExpression().transformExpression(transformer));
        forLoop.getLoopBlock().visit(this);
      }
      @Override
      public void visitExpressionStatement(ExpressionStatement statement) {
        statement.setExpression(statement.getExpression().transformExpression(transformer));
      }
    });
  }

  private final ExpressionTransformer transformer = new ExpressionTransformer() {
    @Override
    public Expression transform(Expression expr) {
      if (expr instanceof PropertyExpression) {
        PropertyExpression objectPropExpr = (PropertyExpression) expr;
        if (objectPropExpr.isDynamic()) {
          String name = objectPropExpr.getText();
          int idx = name.indexOf(".groovy.");
          if (idx != -1 && shouldTransformClass(name)) {
            return rewrite(objectPropExpr);
          }
        }
      } else if (expr instanceof VariableExpression) {
        VariableExpression variableExpression = (VariableExpression) expr;
        variableExpression.setType(handleType(variableExpression.getType()));
        ClassNode originType = handleType(variableExpression.getOriginType());
        if (originType != variableExpression.getOriginType()) {
          return new VariableExpression(variableExpression.getName(), rewriteType(variableExpression.getOriginType()));
        }
      } else if (expr instanceof ClassExpression) {
        ClassExpression classExpression = (ClassExpression) expr;
        classExpression.setType(handleType(classExpression.getType()));
      } else if (expr instanceof ClosureExpression) {
        ClosureExpression closureExpr = (ClosureExpression) expr;
        for (Parameter param : closureExpr.getParameters()) {
          handleParam(param);
        }
      } else if (expr instanceof CastExpression) {
        CastExpression castExpr = (CastExpression) expr;
        castExpr.setType(handleType(castExpr.getType()));
      }
      return expr.transformExpression(this);
    }
  };

  private ClassNode handleType(ClassNode type) {
    GenericsType[] genericsTypes = type.getGenericsTypes();
    if (genericsTypes != null) {
      for (GenericsType genericsType : genericsTypes) {
        if (shouldTransformClass(genericsType.getType())) {
          genericsType.setType(rewriteType(genericsType.getType()));
        }
      }
    }
    if (shouldTransformClass(type)) {
      return rewriteType(type);
    }
    return type;
  }

  private void handleParam(Parameter param) {
    param.setType(handleType(param.getType()));
    param.setOriginType(handleType(param.getOriginType()));
  }

  private boolean shouldTransformClass(ClassNode clazz) {
    return !(clazz == null || clazz.getName() == null) && shouldTransformClass(clazz.getName());
  }

  private boolean shouldTransformClass(String fqn) {
    Boolean cached = relocatedTypes.get(fqn);
    if (cached != null) {
      return cached;
    }
    String translateNamed = translateClassFqn(fqn);
    if (translateNamed != null) {
      try {
        loader.loadClass(translateNamed);
        relocatedTypes.put(fqn, true);
        return true;
      } catch (ClassNotFoundException ignore) {
      }
    }
    relocatedTypes.put(fqn, false);
    return false;
  }

  private String translateClassFqn(String fqn) {
    int index = fqn.indexOf(".groovy.");
    if (index == -1) {
      return null;
    }
    return fqn.substring(0, index) + fqn.substring(index + 7);
  }

  private ClassNode rewriteType(ClassNode type) {
    int index = type.getName().indexOf(".groovy.");
    String name = type.getName().substring(0, index) + type.getName().substring(index + 7);
    try {
      Field f = ClassNode.class.getDeclaredField("name");
      f.setAccessible(true);
      f.set(type, name);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return type;
  }

  private PropertyExpression rewrite(PropertyExpression expr) {
    if (expr.getProperty() instanceof ConstantExpression && expr.getObjectExpression() instanceof PropertyExpression) {
      ConstantExpression property = (ConstantExpression) expr.getProperty();
      PropertyExpression objectExpr = (PropertyExpression) expr.getObjectExpression();
      if (objectExpr != null) {
        if (property.getValue().equals("groovy")) {
          return objectExpr;
        } else {
          objectExpr = rewrite(objectExpr);
          if (objectExpr != null) {
            return new PropertyExpression(objectExpr, property);
          }
        }
      } else {
        return expr;
      }
    }
    return null;
  }

}



