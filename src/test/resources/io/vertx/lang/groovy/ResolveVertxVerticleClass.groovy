package io.vertx.lang.groovy;

import io.vertx.groovy.core.GroovyVerticle

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ResolveVertxVerticleClass extends GroovyVerticle {

  @Override
  void start() throws Exception {
    DeploymentTest.started.set(vertx != null && config != null && deploymentID != null)
  }
}
