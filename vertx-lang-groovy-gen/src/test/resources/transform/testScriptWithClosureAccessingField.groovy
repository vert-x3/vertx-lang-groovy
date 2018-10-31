package transform

import io.vertx.core.Vertx

Vertx vertx_ = vertx

def closure = {
  def v = vertx
  vertx = v
  vertx_.eventBus().send("the-address", true)
}

closure()
