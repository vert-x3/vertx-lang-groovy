package transform

import io.vertx.core.Vertx
import io.vertx.core.AbstractVerticle

class testClassField extends AbstractVerticle {

  Vertx vertx_

  @Override
  void start() throws Exception {
    vertx_ = vertx
    vertx_.eventBus().send("the-address", true)
  }
}

