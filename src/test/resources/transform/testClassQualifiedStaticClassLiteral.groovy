package transform;

import io.vertx.lang.groovy.GroovyVerticle;

public class testClassQualifiedStaticClassLiteral extends GroovyVerticle {

  @Override
  void start() throws Exception {
    def clazz = io.vertx.groovy.core.Future;
    vertx.eventBus().send("the-address", clazz instanceof Class && clazz.getName() == "io.vertx.core.Future");
  }
}

