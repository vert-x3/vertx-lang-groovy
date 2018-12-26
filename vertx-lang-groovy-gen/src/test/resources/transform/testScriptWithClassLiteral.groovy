package transform

import io.vertx.core.Vertx

def literal = Vertx

vertx.eventBus().send("the-address", true)
