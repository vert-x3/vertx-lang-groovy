package transform

def closure = { io.vertx.core.Vertx vertx_ ->
  vertx_.eventBus().send("the-address", true)
}

closure(vertx)
