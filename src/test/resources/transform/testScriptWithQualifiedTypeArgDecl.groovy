package transform;

def List<io.vertx.groovy.core.Vertx> vertx_ = [vertx] as List;

vertx_[0].eventBus().send("the-address", true);
