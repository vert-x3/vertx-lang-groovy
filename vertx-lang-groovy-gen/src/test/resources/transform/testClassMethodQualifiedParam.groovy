package transform

import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx

class testClassMethodQualifiedParam extends AbstractVerticle {

  @Override
  void start() throws Exception {
    method(vertx)
  }

  private void method(Vertx vertx_) {
    vertx_.eventBus().send("the-address", true)
  }
}

