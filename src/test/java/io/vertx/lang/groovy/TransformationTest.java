package io.vertx.lang.groovy;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class TransformationTest {

  @Test
  public void testTransformation() throws Exception {

/*
    VertxTransformation.ENABLED = true;

    CountDownLatch latch = new CountDownLatch(2);

    Vertx vertx = Vertx.vertx();

    vertx.eventBus().localConsumer("the-address", msg -> {
      latch.countDown();
    });

    vertx.deployVerticle("io/vertx/lang/groovy/TestGroovy.groovy", ar -> {
      if (!ar.succeeded()) {
        ar.cause().printStackTrace();
      }
      latch.countDown();
    });

    latch.await();
*/

  }

}
