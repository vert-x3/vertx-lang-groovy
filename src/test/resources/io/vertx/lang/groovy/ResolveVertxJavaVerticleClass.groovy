package io.vertx.lang.groovy

import io.vertx.core.AbstractVerticle

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ResolveVertxJavaVerticleClass extends AbstractVerticle {

  @Override
  void start() throws Exception {
    boolean started = vertx != null && vertx.getOrCreateContext().deploymentID() != null && vertx.getOrCreateContext().config() != null
    System.setProperty("started", "${started}");
  }
}
