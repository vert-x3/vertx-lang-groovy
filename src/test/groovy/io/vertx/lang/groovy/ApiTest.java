package io.vertx.lang.groovy;

import io.vertx.codegen.testmodel.TestInterfaceImpl;
import io.vertx.core.Handler;
import io.vertx.groovy.codegen.testmodel.TestInterface;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ApiTest {

  final TestInterface obj = new TestInterface(new TestInterfaceImpl());

  @Test
  public void methodWithBasicParams() {
    obj.methodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X', "foobar");
  }

  @Test
  public void methodWithBasicBoxedParams() {
    obj.methodWithBasicBoxedParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X');
  }

  @Test
  public void methodWithHandlerBasicTypes() {
    AtomicInteger count = new AtomicInteger();
    obj.methodWithHandlerBasicTypes(
        event -> {
          assertEquals(123, (byte) event);
          count.incrementAndGet();
        },
        event -> {
          assertEquals(12345, (short) event);
          count.incrementAndGet();
        },
        event -> {
          assertEquals(1234567, (int) event);
          count.incrementAndGet();
        },
        event -> {
          assertEquals(1265615234l, (long) event);
          count.incrementAndGet();
        },
        event -> {
          assertEquals(12.345f, (float) event, 0);
          count.incrementAndGet();
        },
        event -> {
          assertEquals(12.34566d, (double) event, 0);
          count.incrementAndGet();
        },
        event -> {
          assertEquals(true, event);
          count.incrementAndGet();
        },
        event -> {
          assertEquals('X', (char) event);
          count.incrementAndGet();
        },
        event -> {
          assertEquals("quux!", event);
          count.incrementAndGet();
        }
    );
    assertEquals(9, count.get());
  }
}
