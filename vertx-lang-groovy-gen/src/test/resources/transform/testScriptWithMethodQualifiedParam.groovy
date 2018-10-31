package transform

void theMethod(io.vertx.core.Vertx vertx_) {
  vertx_.eventBus().send("the-address", true)
}

theMethod(vertx)
