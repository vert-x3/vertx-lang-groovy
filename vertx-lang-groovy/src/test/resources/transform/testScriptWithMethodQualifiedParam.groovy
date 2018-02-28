package transform;

void theMethod(io.vertx.groovy.core.Vertx vertx_) {
  vertx_.eventBus().send("the-address", true);
}

theMethod(vertx)
