package transform;

import io.vertx.lang.groovy.GroovyVerticle;

public class testClassQualifiedStaticMethod extends GroovyVerticle {

  @Override
  void start() throws Exception {
    def fut = io.vertx.groovy.core.Future.succeededFuture(true);
    vertx.eventBus().send("the-address", fut.result());
  }
}

