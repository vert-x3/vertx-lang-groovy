package transform;

while (true) {
  def io.vertx.groovy.core.Vertx vertx_ = vertx;
  vertx_.eventBus().send("the-address", true)
  break;
}
