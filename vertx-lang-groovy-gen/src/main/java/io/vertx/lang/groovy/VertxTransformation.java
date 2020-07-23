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

import groovy.inspect.swingui.AstNodeToScriptVisitor;
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
import org.codehaus.groovy.classgen.GeneratorContext;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.GenericsVisitor;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

import java.io.PrintWriter;
import java.io.StringWriter;
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
  private boolean modified;

  @Override
  public void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
    loader = sourceUnit.getClassLoader();
    try {
      //Stream.of(astNodes).forEach(n -> visit(n, sourceUnit));
      for (int i = 0; i < astNodes.length; i++) {        
        visit(astnodes[i], sourceUnit);
      }
    } catch (Exception e) {
      // Don't prevent compilation with a failure
      e.printStackTrace();
    }
  }

  private void visit(ASTNode node, SourceUnit sourceUnit) {
    if (node instanceof ModuleNode) {
      visit((ModuleNode)node, sourceUnit);
    }
  }

  private void visit(ModuleNode moduleNode, SourceUnit sourceUnit) {
    for (ImportNode importNode : moduleNode.getImports()) {
      if (shouldTransformClass(importNode.getType())) {
        moduleNode.addImport(importNode.getAlias(), rewriteType(importNode.getType()));
      }
    }
    for (MethodNode methodNode : moduleNode.getMethods()) {
      visit(moduleNode, methodNode);
    }
    for (ClassNode classNode : moduleNode.getClasses()) {
      boolean prev = modified;
      for (ConstructorNode constructorNode : classNode.getDeclaredConstructors()) {
        visit(moduleNode, constructorNode);
      }
      for (FieldNode fieldNode : classNode.getFields()) {
        visit(fieldNode);
      }
      for (MethodNode methodNode : classNode.getMethods()) {
        visit(moduleNode, methodNode);
      }
      if (modified) {
        StringWriter buffer = new StringWriter();
        PrintWriter writer = new PrintWriter(buffer);
        writer.append("The class ").append(classNode.getName()).println(" uses the legacy Vert.x for Groovy " +
          "API (io.vertx.groovy.XYZ classes) and should be migrated. Here is the migrated source code:");
        writer.append("// -------- BEGIN ").append(classNode.getName()).println(" --------");
        AstNodeToScriptVisitor visitor = new AstNodeToScriptVisitor(writer, true, false);
        GeneratorContext ctx = new GeneratorContext(moduleNode.getUnit());
        visitor.call(sourceUnit, ctx, classNode);
        writer.append("// -------- END ").append(classNode.getName()).println(" --------");
        System.out.println(buffer.toString());
      }
      modified = prev;
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
        Parameter[] parameters = closureExpr.getParameters();
        if (parameters != null) {
          for (Parameter param : parameters) {
            handleParam(param);
          }
        }
      } else if (expr instanceof CastExpression) {
        CastExpression castExpr = (CastExpression) expr;
        castExpr.setType(handleType(castExpr.getType()));
      }
      return expr.transformExpression(this);
    }
  };

  private ClassNode handleType(ClassNode classType) {
    GenericsType[] genericsTypes = classType.getGenericsTypes();
    String s = classType.toString();
    if (genericsTypes != null) {
      for (int j = 0;j < genericsTypes.length;j++) {
        GenericsType genericsType = genericsTypes[j];
        if (shouldTransformGenericsType(genericsType)) {
          ClassNode[] upperBounds = null;
          if (genericsType.getUpperBounds() != null) {
            upperBounds = genericsType.getUpperBounds().clone();
            for (int i = 0;i < upperBounds.length;i++) {
              if (shouldTransformClass(upperBounds[i])) {
                upperBounds[i] = rewriteType(upperBounds[i]);
              }
            }
          }
          ClassNode lowerBound = genericsType.getLowerBound();
          if (lowerBound != null && shouldTransformClass(lowerBound)) {
            lowerBound = rewriteType(lowerBound);
          }
          ClassNode type = genericsType.getType();
          if (shouldTransformClass(type)) {
            type = rewriteType(type);
          }
          genericsTypes[j] = new GenericsType(type, upperBounds, lowerBound);
        }
      }
    }
    if (shouldTransformClass(classType)) {
      return rewriteType(classType);
    }
    return classType;
  }

  private void handleParam(Parameter param) {
    param.setType(handleType(param.getType()));
    param.setOriginType(handleType(param.getOriginType()));
  }

  private boolean shouldTransformGenericsType(GenericsType type) {
    if (shouldTransformClass(type.getType())) {
      return true;
    }
    if (type.getLowerBound() != null && shouldTransformClass(type.getLowerBound())) {
      return true;
    }
    if (type.getUpperBounds() != null) {
      for (ClassNode upperBound : type.getUpperBounds()) {
        if (shouldTransformClass(upperBound)) {
          return true;
        }
      }
    }
    return false;
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
    modified = true;
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



