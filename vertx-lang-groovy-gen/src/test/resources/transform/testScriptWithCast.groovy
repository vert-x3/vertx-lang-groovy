package transform

import io.vertx.core.Vertx

((Vertx)vertx).eventBus().send("the-address", true)
