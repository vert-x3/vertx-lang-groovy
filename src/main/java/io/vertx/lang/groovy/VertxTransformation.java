package io.vertx.lang.groovy;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.GenericsType;
import org.codehaus.groovy.ast.ImportNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.ModuleNode;
import org.codehaus.groovy.ast.expr.ClassExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.ExpressionTransformer;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.BlockStatement;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
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
    } else if (node instanceof BlockStatement) {
      visit((BlockStatement) node);
    }
  }

  private void visit(ModuleNode moduleNode) {

    for (ImportNode importNode : moduleNode.getImports()) {
      if (shouldTransform(importNode.getType())) {
        moduleNode.addImport(importNode.getAlias(), rewriteType(importNode.getType()));
      }
    }

    for (ClassNode classNode : moduleNode.getClasses()) {
      for (MethodNode methodNode : classNode.getMethods()) {
        visit(moduleNode, methodNode);
      }
    }

    for (MethodNode methodNode : moduleNode.getMethods()) {
      visit(moduleNode, methodNode);
    }

//    visit(node.getStatementBlock());
//    node.getMethods().forEach(this::visit);
  }

  private void visit(ModuleNode moduleNode, MethodNode methodNode) {
    methodNode.getCode().visit(new GenericsVisitor(moduleNode.getContext()) {
      @Override
      public void visitExpressionStatement(ExpressionStatement statement) {
        statement.setExpression(statement.getExpression().transformExpression(new ExpressionTransformer() {
          @Override
          public Expression transform(Expression expression) {
            if (expression instanceof VariableExpression) {
              VariableExpression variableExpression = (VariableExpression) expression;
              GenericsType[] genericsTypes = variableExpression.getType().getGenericsTypes();
              if (genericsTypes != null) {
                for (int i = 0; i < genericsTypes.length;i++) {
                  GenericsType genericsType = genericsTypes[i];
                  if (shouldTransform(genericsType.getType())) {
                    genericsType.setType(rewriteType(genericsType.getType()));
                  }
                }
              }
            } else if (expression instanceof ClassExpression) {
              ClassExpression classExpression = (ClassExpression) expression;
              if (shouldTransform(classExpression.getType())) {
                classExpression.setType(rewriteType(classExpression.getType()));
              }
            }
            return expression.transformExpression(this);
          }
        }));
      }
    });
  }


/*
  private void visit(MethodNode method) {
    for (Parameter parameter : method.getParameters()) {
      ClassNode type = parameter.getType();
      if (type.getPackageName().startsWith("io.vertx.groovy.")) {
        ClassNode newType = rewriteType(type);
        parameter.setType(newType);
      }
    }
    visit(method.getCode());
  }

  private void visit(Statement statement) {
    if (statement instanceof ExpressionStatement) {
      ExpressionStatement exprStatement = (ExpressionStatement) statement;
      visit(exprStatement);
    } else if (statement instanceof BlockStatement) {
      BlockStatement blockStatement = (BlockStatement) statement;
      blockStatement.getStatements().forEach(this::visit);
      visit(blockStatement.getVariableScope());
    }
  }

  private void visit(VariableScope variableScope) {
  }

  private void visit(ExpressionStatement statement) {
    Expression expression = statement.getExpression();
    expression = expression.transformExpression(new ExpressionTransformer() {
      @Override
      public Expression transform(Expression expression) {
        if (expression instanceof VariableExpression) {
          VariableExpression varEx = (VariableExpression) expression;
          ClassNode type = varEx.getType();
          if (type.getPackageName().startsWith("io.vertx.groovy.")) {
            ClassNode newType = rewriteType(type);
            VariableExpression variableExpression = new VariableExpression(varEx.getName(), newType);
            variableExpression.setSourcePosition(varEx);
            variableExpression.copyNodeMetaData(varEx);
            System.out.println("replaced");
            return variableExpression;
          }
        }
        return expression.transformExpression(this);
      }
    });
    statement.setExpression(expression);
  }
*/

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
