package transform

import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx

class testClassMethodQualifiedTypeArgParam extends AbstractVerticle {

  @Override
  void start() throws Exception {
    method([vertx] as List)
  }

  private void method(List<Vertx> vertx_) {
    vertx_[0].eventBus().send("the-address", true)
  }
}

