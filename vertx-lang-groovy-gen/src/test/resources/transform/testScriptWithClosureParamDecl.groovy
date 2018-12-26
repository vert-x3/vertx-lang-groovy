package transform

import io.vertx.core.Vertx

def closure = { Vertx vertx_ ->
  vertx_.eventBus().send("the-address", true)
}

closure(vertx)
