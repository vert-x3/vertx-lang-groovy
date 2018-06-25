package transform;

import io.vertx.lang.groovy.GroovyVerticle;

public class testClassQualifiedField extends GroovyVerticle {

  io.vertx.groovy.core.Vertx vertx_;

  @Override
  void start() throws Exception {
    vertx_ = vertx;
    vertx_.eventBus().send("the-address", true);
  }
}

