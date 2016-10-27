package transform;

def closure = { io.vertx.groovy.core.Vertx vertx_ ->
  vertx_.eventBus().send("the-address", true)
}

closure(vertx)
