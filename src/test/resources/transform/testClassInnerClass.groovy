package transform;

import io.vertx.groovy.core.Vertx
import io.vertx.lang.groovy.GroovyVerticle;

public class testClassInnerClass extends GroovyVerticle {

  @Override
  void start() throws Exception {
    new Inner(vertx).vertx_.eventBus().send("the-address", true);
  }

  class Inner {
    final Vertx vertx_;
    Inner(Vertx v) {
      vertx_ = v;
    }
  }
}

