package transform;

import io.vertx.lang.groovy.GroovyVerticle;

public class testClassQualifiedTypeArgField extends GroovyVerticle {

  List<io.vertx.groovy.core.Vertx> vertx_;

  @Override
  void start() throws Exception {
    vertx_ = [vertx] as List;
    vertx_[0].eventBus().send("the-address", true);
  }
}

