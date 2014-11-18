package io.vertx.lang.groovy
/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ResolveVertxVerticleClass extends GroovyVerticle {

  @Override
  void start() throws Exception {
    DeploymentTest.started.set(vertx != null && vertx.currentContext().deploymentID() != null && vertx.currentContext().config() != null)
  }
}
