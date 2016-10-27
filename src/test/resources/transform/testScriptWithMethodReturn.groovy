package transform;

import io.vertx.groovy.core.Vertx

Vertx theMethod() {
  return vertx;
}

theMethod().eventBus().send("the-address", true);
