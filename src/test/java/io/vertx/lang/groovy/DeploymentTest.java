package io.vertx.lang.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.Script;
import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.groovy.core.GroovyVerticle;
import io.vertx.groovy.core.ScriptVerticle;
import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class DeploymentTest {

  public static final AtomicBoolean started = new AtomicBoolean();
  public static final AtomicBoolean stopped = new AtomicBoolean();

  private static <T>  T assertResult(AsyncResult<T> asyncResult) {
    if (asyncResult.succeeded()) {
      return asyncResult.result();
    } else {
      AssertionFailedError afe = new AssertionFailedError();
      afe.initCause(asyncResult.cause());
      throw afe;
    }
  }

  private Class assertScript(String script) {
    GroovyClassLoader loader = new GroovyClassLoader(getClass().getClassLoader());
    try {
      return loader.loadClass(getClass().getPackage().getName() + "." + script);
    } catch (ClassNotFoundException e) {
      AssertionFailedError afe = new AssertionFailedError();
      afe.initCause(e);
      throw afe;
    }
  }

  @Before
  public void before() {
    started.set(false);
    stopped.set(false);
  }

  @Test
  public void testDeployVerticleGroovyClass() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "groovy:io/vertx/lang/groovy/LifeCycleVerticleClass.groovy",
            DeploymentOptions.options(),
            onDeploy));
  }

  @Test
  public void testDeployVerticleClassInstance() throws Exception {
    Class clazz = assertScript("LifeCycleVerticleClass");
    GroovyVerticle verticle = (GroovyVerticle) clazz.newInstance();
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticleInstance(
            verticle.asJavaVerticle(),
            DeploymentOptions.options(),
            onDeploy));
  }

  @Test
  public void testDeployVerticleScriptInstance() throws Exception {
    Class clazz = assertScript("LifeCycleVerticleScript");
    Script script = (Script) clazz.newInstance();
    ScriptVerticle verticle = new ScriptVerticle(script);
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticleInstance(
            verticle,
            DeploymentOptions.options(),
            onDeploy));
  }

  @Test
  public void testDeployVerticleGroovyScript() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "groovy:io/vertx/lang/groovy/LifeCycleVerticleScript.groovy",
            DeploymentOptions.options(),
            onDeploy));
  }

  @Test
  public void testDeployVerticleGroovyScriptNoStop() throws Exception {
    Vertx vertx = Vertx.vertx();
    try {
      BlockingQueue<AsyncResult<String>> deployed = new ArrayBlockingQueue<>(1);
      vertx.deployVerticle("groovy:io/vertx/lang/groovy//NoStopVerticleScript.groovy", DeploymentOptions.options(), deployed::add);
      AsyncResult<String> deployment = deployed.poll(10, TimeUnit.SECONDS);
      String deploymentId = assertResult(deployment);
      BlockingQueue<AsyncResult<Void>> undeployed = new ArrayBlockingQueue<>(1);
      vertx.undeployVerticle(deploymentId, undeployed::add);
      AsyncResult<?> undeployment = undeployed.poll(10, TimeUnit.SECONDS);
      assertResult(undeployment);
    } finally {
      vertx.close();
    }
  }

  @FunctionalInterface
  static interface Deployer {
    void deploy(Vertx vertx, Handler<AsyncResult<String>> onDeploy);
  }

  private void assertDeploy(Deployer deployer) throws Exception {
    Vertx vertx = Vertx.vertx();
    try {
      BlockingQueue<AsyncResult<String>> deployed = new ArrayBlockingQueue<>(1);
      deployer.deploy(vertx, deployed::add);
      AsyncResult<String> deployment = deployed.poll(10, TimeUnit.SECONDS);
      String deploymentId = assertResult(deployment);
      assertTrue(started.get());
      BlockingQueue<AsyncResult<Void>> undeployed = new ArrayBlockingQueue<>(1);
      vertx.undeployVerticle(deploymentId, undeployed::add);
      AsyncResult<?> undeployment = undeployed.poll(10, TimeUnit.SECONDS);
      assertResult(undeployment);
      assertTrue(stopped.get());
    } finally {
      vertx.close();
    }
  }
}
