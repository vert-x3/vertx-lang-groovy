package transform;

import io.vertx.groovy.core.Vertx
import io.vertx.lang.groovy.GroovyVerticle;

public class testClassMethodParam extends GroovyVerticle {

  @Override
  void start() throws Exception {
    method(vertx)
  }

  private void method(Vertx vertx_) {
    vertx_.eventBus().send("the-address", true)
  }
}

