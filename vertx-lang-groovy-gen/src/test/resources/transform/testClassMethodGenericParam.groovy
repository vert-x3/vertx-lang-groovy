package transform

import io.vertx.groovy.core.eventbus.Message
import io.vertx.core.AbstractVerticle

class testClassMethodGenericParam extends AbstractVerticle {

  @Override
  void start() throws Exception {
    method(null)
    vertx.eventBus().send("the-address", true)
  }

  private void method(Message<String> msg2) {
  }
}

