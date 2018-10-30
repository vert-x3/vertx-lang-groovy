package transform

import io.vertx.core.Vertx
import io.vertx.core.AbstractVerticle

class testClassMethodParam extends AbstractVerticle {

  @Override
  void start() throws Exception {
    method(vertx)
  }

  private void method(Vertx vertx_) {
    vertx_.eventBus().send("the-address", true)
  }
}

