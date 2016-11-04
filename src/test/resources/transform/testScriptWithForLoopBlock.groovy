package transform;

for (int i = 0;i < 1;i++) {
  def io.vertx.groovy.core.Vertx vertx_ = vertx;
  vertx_.eventBus().send("the-address", true)
}
