package transform;

import io.vertx.lang.groovy.GroovyVerticle;

public class testClassMethodQualifiedParam extends GroovyVerticle {

  @Override
  void start() throws Exception {
    method(vertx)
  }

  private void method(io.vertx.groovy.core.Vertx vertx_) {
    vertx_.eventBus().send("the-address", true)
  }
}

