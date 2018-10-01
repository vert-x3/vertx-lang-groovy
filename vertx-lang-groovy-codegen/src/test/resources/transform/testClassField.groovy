package transform;

import io.vertx.groovy.core.Vertx
import io.vertx.lang.groovy.GroovyVerticle;

public class testClassField extends GroovyVerticle {

  Vertx vertx_;

  @Override
  void start() throws Exception {
    vertx_ = vertx;
    vertx_.eventBus().send("the-address", true);
  }
}

