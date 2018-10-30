package transform

import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx

class testClassInnerClassQualifiedTypeArg extends AbstractVerticle {

  @Override
  void start() throws Exception {
    new Inner([vertx] as List).vertx_[0].eventBus().send("the-address", true)
  }

  class Inner {
    final List<Vertx> vertx_

    Inner(List<Vertx> v) {
      vertx_ = v
    }
  }
}

