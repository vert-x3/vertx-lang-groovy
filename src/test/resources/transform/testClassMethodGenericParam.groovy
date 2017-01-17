package transform;

import io.vertx.groovy.core.eventbus.Message

public class testClassMethodGenericParam extends io.vertx.lang.groovy.GroovyVerticle {

  @Override
  void start() throws Exception {
    method(null);
    vertx.eventBus().send("the-address", true)
  }

  private void method(Message<String> msg2) {
  }
}

