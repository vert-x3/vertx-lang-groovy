package transform;

io.vertx.groovy.core.Vertx theMethod() {
  return vertx;
}

theMethod().eventBus().send("the-address", true);
