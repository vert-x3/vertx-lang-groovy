package io.vertx.lang.groovy;

import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.lang.groovy.support.VerticleClass;
import io.vertx.test.core.AsyncTestBase;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class DeploymentTest extends AsyncTestBase {

  public static final CyclicBarrier started = new CyclicBarrier(2);
  public static final CyclicBarrier stopped = new CyclicBarrier(2);

  @Before
  public void before() {
    started.reset();
  }

  @Test
  public void testDeployVerticleGroovyClass() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "groovy:verticles/compile/VerticleClass.groovy",
            DeploymentOptions.options(),
            onDeploy));
  }

  @Test
  public void testDeployVerticleInstance() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticleInstance(
            new VerticleClass().asJavaVerticle(),
            DeploymentOptions.options(),
            onDeploy));
  }

  @Test
  public void testDeployVerticleGroovyScript() throws Exception {
    Vertx vertx = Vertx.vertx();
    try {
      vertx.deployVerticle("groovy:verticles/compile/VerticleScript.groovy");
      started.await(10, TimeUnit.SECONDS);
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
      BlockingQueue<String> deployed = new ArrayBlockingQueue<>(1);
      deployer.deploy(vertx, result -> deployed.offer(result.result()));
      started.await(10, TimeUnit.SECONDS);
      String id = deployed.poll(10, TimeUnit.SECONDS);
      vertx.undeployVerticle(id, null);
      stopped.await(10, TimeUnit.SECONDS);
    } finally {
      vertx.close();
    }
  }
}
