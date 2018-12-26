package transform

import io.vertx.core.AbstractVerticle

class testClassQualifiedField extends AbstractVerticle {

  io.vertx.core.Vertx vertx_

  @Override
  void start() throws Exception {
    vertx_ = vertx
    vertx_.eventBus().send("the-address", true)
  }
}

