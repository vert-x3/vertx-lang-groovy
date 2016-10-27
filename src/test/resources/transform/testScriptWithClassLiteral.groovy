package transform;

import io.vertx.groovy.core.Vertx;

def literal = Vertx

vertx.eventBus().send("the-address", true);
