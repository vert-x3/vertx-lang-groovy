package io.vertx.lang.groovy

import io.vertx.lang.groovy.sub.InChildPackage
import io.vertx.core.AbstractVerticle

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class ResolveChildPackageVerticleClass extends AbstractVerticle {

  @Override
  void start() throws Exception {
    InChildPackage o = new InChildPackage()
    System.setProperty("started", "true")
  }

  @Override
  void stop() throws Exception {
    System.setProperty("stopped", "true")
  }
}
