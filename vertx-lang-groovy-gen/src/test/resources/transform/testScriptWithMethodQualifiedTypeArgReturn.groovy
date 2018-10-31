package transform

List<io.vertx.core.Vertx> theMethod() {
  return [vertx] as List
}

theMethod()[0].eventBus().send("the-address", true)
