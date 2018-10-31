package transform

import io.vertx.core.Vertx

Vertx theMethod() {
  return vertx
}

theMethod().eventBus().send("the-address", true)
