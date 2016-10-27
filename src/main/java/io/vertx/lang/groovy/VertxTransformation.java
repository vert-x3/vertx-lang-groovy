package io.vertx.lang.groovy;

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
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.ExpressionTransformer;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
import org.codehaus.groovy.ast.stmt.ForStatement;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.GenericsVisitor;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

import java.util.stream.Stream;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@GroovyASTTransformation(phase= CompilePhase.CONVERSION)
public class VertxTransformation implements ASTTransformation {

  public static volatile boolean ENABLED = true;

  @Override
  public void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
    if (!ENABLED) {
      return;
    }
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
      if (shouldTransform(importNode.getType())) {
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
    visit(moduleNode, methodNode.getCode());
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
    public Expression transform(Expression expression) {
      if (expression instanceof VariableExpression) {
        VariableExpression variableExpression = (VariableExpression) expression;
        variableExpression.setType(handleType(variableExpression.getType()));
        ClassNode originType = handleType(variableExpression.getOriginType());
        if (originType != variableExpression.getOriginType()) {
          return new VariableExpression(variableExpression.getName(), rewriteType(variableExpression.getOriginType()));
        }
      } else if (expression instanceof ClassExpression) {
        ClassExpression classExpression = (ClassExpression) expression;
        classExpression.setType(handleType(classExpression.getType()));
      } else if (expression instanceof ClosureExpression) {
        ClosureExpression closureExpr = (ClosureExpression) expression;
        for (Parameter param : closureExpr.getParameters()) {
          handleParam(param);
        }
      } else if (expression instanceof CastExpression) {
        CastExpression castExpr = (CastExpression) expression;
        castExpr.setType(handleType(castExpr.getType()));
      }
      return expression.transformExpression(this);
    }
  };

  private ClassNode handleType(ClassNode type) {
    GenericsType[] genericsTypes = type.getGenericsTypes();
    if (genericsTypes != null) {
      for (GenericsType genericsType : genericsTypes) {
        if (shouldTransform(genericsType.getType())) {
          genericsType.setType(rewriteType(genericsType.getType()));
        }
      }
    }
    if (shouldTransform(type)) {
      return rewriteType(type);
    }
    return type;
  }

  private void handleParam(Parameter param) {
    param.setType(handleType(param.getType()));
    param.setOriginType(handleType(param.getOriginType()));
  }

  private boolean shouldTransform(ClassNode type) {
    return type != null && (type.getName().startsWith("io.vertx.groovy.") || type.getName().startsWith("com.acme.groovy."));
  }

  private ClassNode rewriteType(ClassNode type) {
    int index = type.getName().indexOf(".groovy.");
    return new ClassNode(
      type.getName().substring(0, index) + type.getName().substring(index + 7),
      type.getModifiers(),
      type.getSuperClass(),
      type.getInterfaces(),
      type.getMixins()
    );
  }
}
