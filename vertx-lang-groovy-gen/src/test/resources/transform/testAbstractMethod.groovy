package transform

import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx

class testAbstractMethod extends AbstractVerticle {

  @Override
  void start() throws Exception {
    AbstractSender obj = new Sender()
    obj.send(vertx)
  }
}

abstract class AbstractSender {
  abstract void send(Vertx vertx);
}

class Sender extends AbstractSender {
  @Override
  void send(Vertx vertx) {
    vertx.eventBus().send("the-address", true)
  }
}
