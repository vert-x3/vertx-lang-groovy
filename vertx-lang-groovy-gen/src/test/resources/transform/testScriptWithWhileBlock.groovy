package transform

while (true) {
  io.vertx.core.Vertx vertx_ = vertx
  vertx_.eventBus().send("the-address", true)
  break
}
