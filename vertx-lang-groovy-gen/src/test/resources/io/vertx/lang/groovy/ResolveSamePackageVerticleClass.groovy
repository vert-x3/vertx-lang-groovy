package io.vertx.lang.groovy

import io.vertx.core.AbstractVerticle
/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class ResolveSamePackageVerticleClass extends AbstractVerticle {

  @Override
  void start() throws Exception {
    InSamePackage o = new InSamePackage()
    System.setProperty("started", "true")
  }

  @Override
  void stop() throws Exception {
    System.setProperty("stopped", "true")
  }
}
