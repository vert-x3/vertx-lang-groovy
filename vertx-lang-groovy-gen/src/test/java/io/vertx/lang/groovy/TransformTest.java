package io.vertx.lang.groovy;

import groovy.lang.GroovyClassLoader;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class TransformTest {

  @Rule
  public final TestName name = new TestName();

  @Test
  public void testScriptWithClassLiteral() throws Exception {
    runTest();
  }

  @Test
  public void testClassField() throws Exception {
    runTest();
  }

  @Test
  public void testClassQualifiedField() throws Exception {
    runTest();
  }

  @Test
  public void testClassQualifiedStaticClassLiteral() throws Exception {
    runTest();
  }

  @Test
  public void testClassQualifiedStaticMethodCall() throws Exception {
    runTest();
  }

  @Test
  public void testClassQualifiedTypeArgField() throws Exception {
    runTest();
  }

  @Test
  public void testClassInnerClass() throws Exception {
    runTest();
  }

  @Test
  public void testClassInnerClassQualified() throws Exception {
    runTest();
  }

  @Test
  public void testClassInnerClassQualifiedTypeArg() throws Exception {
    runTest();
  }

  @Test
  public void testClassMethodParam() throws Exception {
    runTest();
  }

  @Test
  public void testClassMethodQualifiedParam() throws Exception {
    runTest();
  }

  @Test
  public void testClassMethodQualifiedTypeArgParam() throws Exception {
    runTest();
  }

  @Test
  public void testClassMethodGenericParam() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithCast() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithCastQualified() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithCastQualifiedTypeArg() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithQualifiedParameterizedDecl() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithMethodParam() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithMethodQualifiedParam() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithMethodQualifiedTypeArgParam() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithDecl() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithQualifiedDecl() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithQualifiedTypeArgDecl() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithMethodReturn() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithMethodQualifiedReturn() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithMethodQualifiedTypeArgReturn() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithClosureAccessingField() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithClosureParamDecl() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithClosureQualifiedParamDecl() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithClosureQualifiedTypeArgParamDecl() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithClosureWithNoParameters() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithForLoopQualifiedDecl() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithForLoopBlock() throws Exception {
    runTest();
  }

  @Test
  public void testScriptWithWhileBlock() throws Exception {
    runTest();
  }

  @Test
  public void testAbstractMethod() throws Exception {
    runTest();
  }

  private void runTest() throws Exception {
    Vertx vertx = Vertx.vertx();
    CompletableFuture<Void> fut = new CompletableFuture<>();
    vertx.eventBus().localConsumer("the-address", msg -> {
      fut.complete(null);
    });

    if(name.getMethodName().contains("Script")) {
      vertx.deployVerticle("transform/" + name.getMethodName() + ".groovy", ar -> {

        if (ar.failed()) {
          fut.completeExceptionally(ar.cause());
        }
      });
      fut.get(20, TimeUnit.SECONDS);
    } else {
      Class clazz = new GroovyClassLoader().loadClass(("transform." + name.getMethodName()));
      Verticle verticle = (AbstractVerticle) clazz.newInstance();
      vertx.deployVerticle(verticle, ar -> {

        if (ar.failed()) {
          fut.completeExceptionally(ar.cause());
        }
      });
      fut.get(20, TimeUnit.SECONDS);
    }
  }

}
