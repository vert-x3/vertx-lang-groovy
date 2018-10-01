package io.vertx.groovy.unit;

import groovy.lang.GroovyShell;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.collect.EventBusCollector;
import io.vertx.test.core.VertxTestBase;
import org.junit.Test;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class LangTest extends VertxTestBase {

  @Test
  public void testGroovy() throws Exception {
    GroovyShell shell = new GroovyShell();
    shell.setVariable("done", (Runnable) () -> {
      testComplete();
    });
    shell.evaluate(LangTest.class.getResource("/unit/plain/timer.groovy").toURI());
    await();
  }

  @Test
  public void testAssertionsGroovy() throws Exception {
    testAssertions("groovy:unit/verticle/assertions.groovy");
  }

  private void testAssertions(String verticle) throws Exception {
    vertx.eventBus().<JsonObject>consumer("assert_tests").bodyStream().handler(msg -> {
      String type = msg.getString("type");
      switch (type) {
        case EventBusCollector.EVENT_TEST_CASE_END:
          String name = msg.getString("name");
          if (name.startsWith("fail_")) {
            assertNotNull(msg.getValue("failure"));
          } else {
            assertEquals(null, msg.getValue("failure"));
          }
          break;
        case EventBusCollector.EVENT_TEST_SUITE_END:
          testComplete();
          break;
      }
    });
    vertx.deployVerticle(verticle, ar -> {
      assertTrue(ar.succeeded());
    });
    await();
  }

  @Test
  public void testGroovyTimer() {
    vertx.deployVerticle("unit/verticle/timer.groovy", ar -> {
      assertTrue(ar.succeeded());
      testComplete();
    });
    await();
  }

  @Test
  public void testGroovyFailure() {
    vertx.deployVerticle("unit/verticle/failing.groovy", ar -> {
      assertTrue(ar.failed());
      assertEquals("the_failure", ar.cause().getMessage());
      testComplete();
    });
    await();
  }

  @Test
  public void testGroovyExceptionHandler() {
    vertx.deployVerticle("unit/verticle/exceptionHandler.groovy", ar -> {
      assertTrue(ar.failed());
      assertEquals("the_failure", ar.cause().getMessage());
      testComplete();
    });
    await();
  }
}
