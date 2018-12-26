package transform

List<io.vertx.core.Vertx> vertx_ = [vertx] as List

vertx_[0].eventBus().send("the-address", true)
