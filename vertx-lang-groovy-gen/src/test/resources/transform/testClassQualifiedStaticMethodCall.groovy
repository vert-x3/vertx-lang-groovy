package transform

import io.vertx.core.AbstractVerticle

class testClassQualifiedStaticMethod extends AbstractVerticle {

  @Override
  void start() throws Exception {
    def fut = io.vertx.groovy.core.Future.succeededFuture(true)
    vertx.eventBus().send("the-address", fut.result())
  }
}

