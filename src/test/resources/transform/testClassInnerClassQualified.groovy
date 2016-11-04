package transform;

import io.vertx.lang.groovy.GroovyVerticle;

public class testClassInnerClassQualified extends GroovyVerticle {

  @Override
  void start() throws Exception {
    new Inner(vertx).vertx_.eventBus().send("the-address", true);
  }

  class Inner {
    final io.vertx.groovy.core.Vertx vertx_;
    Inner(io.vertx.groovy.core.Vertx v) {
      vertx_ = v;
    }
  }
}

