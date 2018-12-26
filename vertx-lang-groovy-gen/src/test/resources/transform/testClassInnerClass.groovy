package transform

import io.vertx.core.Vertx
import io.vertx.core.AbstractVerticle

class testClassInnerClass extends AbstractVerticle {

  @Override
  void start() throws Exception {
    new Inner(vertx).vertx_.eventBus().send("the-address", true)
  }

  class Inner {
    final Vertx vertx_

    Inner(Vertx v) {
      vertx_ = v
    }
  }
}

