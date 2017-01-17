package transform;

import io.vertx.lang.groovy.GroovyVerticle;
import io.vertx.groovy.core.Vertx

public class testAbstractMethod extends GroovyVerticle {

  @Override
  void start() throws Exception {
    AbstractSender obj = new Sender();
    obj.send(vertx);
  }
}

public abstract class AbstractSender {
  public abstract void send(Vertx vertx);
}

public class Sender extends AbstractSender {
  @Override
  void send(Vertx vertx) {
    vertx.eventBus().send("the-address", true);
  }
}
