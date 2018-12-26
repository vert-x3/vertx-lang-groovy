package transform

import io.vertx.core.AbstractVerticle

class testClassQualifiedTypeArgField extends AbstractVerticle {

  List<io.vertx.core.Vertx> vertx_

  @Override
  void start() throws Exception {
    vertx_ = [vertx] as List
    vertx_[0].eventBus().send("the-address", true)
  }
}

