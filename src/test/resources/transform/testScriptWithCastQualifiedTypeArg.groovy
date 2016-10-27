package transform;

def list = [vertx] as List

((List<io.vertx.groovy.core.Vertx>)list)[0].eventBus().send("the-address", true)
