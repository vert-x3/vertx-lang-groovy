package io.vertx.lang.groovy

import io.vertx.core.AbstractVerticle

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ResolveVertxGroovyVerticleClass extends AbstractVerticle {

  @Override
  void start() throws Exception {
    boolean started = vertx != null && vertx.currentContext().deploymentID() != null && vertx.currentContext().config() != null
    System.setProperty("started", "${started}");
  }
}
