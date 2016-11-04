package transform;

void theMethod(List<io.vertx.groovy.core.Vertx> vertx_) {
  vertx_[0].eventBus().send("the-address", true);
}

theMethod([vertx] as List)
