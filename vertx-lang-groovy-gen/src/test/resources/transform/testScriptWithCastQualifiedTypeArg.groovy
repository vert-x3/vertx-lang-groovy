package transform

def list = [vertx] as List

((List<io.vertx.core.Vertx>)list)[0].eventBus().send("the-address", true)
