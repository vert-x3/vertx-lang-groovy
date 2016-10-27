package transform;

import io.vertx.lang.groovy.GroovyVerticle;

public class testClassMethodQualifiedTypeArgParam extends GroovyVerticle {

  @Override
  void start() throws Exception {
    method([vertx] as List)
  }

  private void method(List<io.vertx.groovy.core.Vertx> vertx_) {
    vertx_[0].eventBus().send("the-address", true)
  }
}

