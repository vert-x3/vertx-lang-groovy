package transform

io.vertx.core.Vertx theMethod() {
  return vertx
}

theMethod().eventBus().send("the-address", true)
