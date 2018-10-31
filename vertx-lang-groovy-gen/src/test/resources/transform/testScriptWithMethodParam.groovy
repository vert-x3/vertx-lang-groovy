package transform

import io.vertx.core.Vertx

void theMethod(Vertx vertx_) {
  vertx_.eventBus().send("the-address", true)
}

theMethod(vertx)
