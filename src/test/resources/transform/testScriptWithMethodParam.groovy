package transform;

import io.vertx.groovy.core.Vertx

void theMethod(Vertx vertx_) {
  vertx_.eventBus().send("the-address", true);
}

theMethod(vertx)
