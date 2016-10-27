package transform;

import io.vertx.lang.groovy.GroovyVerticle;

public class testClassInnerClassQualifiedTypeArg extends GroovyVerticle {

  @Override
  void start() throws Exception {
    new Inner([vertx] as List).vertx_[0].eventBus().send("the-address", true);
  }

  class Inner {
    final List<io.vertx.groovy.core.Vertx> vertx_;
    Inner(List<io.vertx.groovy.core.Vertx> v) {
      vertx_ = v;
    }
  }
}

