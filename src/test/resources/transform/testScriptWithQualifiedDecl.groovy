package transform;

def io.vertx.groovy.core.Vertx vertx_ = vertx;

vertx_.eventBus().send("the-address", true);
