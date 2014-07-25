package io.vertx.lang.groovy

import io.vertx.codegen.testmodel.RefedInterface1Impl;
import io.vertx.codegen.testmodel.TestInterfaceImpl;
import io.vertx.core.Handler
import io.vertx.groovy.codegen.testmodel.RefedInterface1;
import io.vertx.groovy.codegen.testmodel.TestInterface;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ApiTest {

  final TestInterface obj = new TestInterface(new TestInterfaceImpl());

  @Test
  public void methodWithBasicParams() {
    obj.methodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, "foobar");
  }

  @Test
  public void methodWithBasicBoxedParams() {
    obj.methodWithBasicBoxedParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char);
  }

  @Test
  public void methodWithHandlerBasicTypes() {
    AtomicInteger count = new AtomicInteger();
    obj.methodWithHandlerBasicTypes(
      { assertEquals(123, (byte) it); count.incrementAndGet(); },
      { assertEquals(12345, (short) it); count.incrementAndGet(); },
      { assertEquals(1234567, (int) it); count.incrementAndGet(); },
      { assertEquals(1265615234l, (long) it); count.incrementAndGet(); },
      { assertEquals(12.345f, (float) it, 0); count.incrementAndGet(); },
      { assertEquals(12.34566d, (double) it, 0); count.incrementAndGet(); },
      { assertEquals(true, it); count.incrementAndGet(); },
      { assertEquals('X' as char, (char) it); count.incrementAndGet(); },
      { assertEquals("quux!", it); count.incrementAndGet(); }
    );
    assertEquals(9, count.get());
  }

  @Test
  public void methodWithHandlerAsyncResultBasicTypes() {
    AtomicInteger count = new AtomicInteger();
    obj.methodWithHandlerAsyncResultBasicTypes(false,
      { assertTrue(it.succeeded()); assertFalse(it.failed()); assertEquals(123, (byte) it.result()); assertNull(it.cause()); count.incrementAndGet(); },
      { assertTrue(it.succeeded()); assertFalse(it.failed()); assertEquals(12345, (short) it.result()); assertNull(it.cause()); count.incrementAndGet(); },
      { assertTrue(it.succeeded()); assertFalse(it.failed()); assertEquals(1234567, (int) it.result()); assertNull(it.cause()); count.incrementAndGet(); },
      { assertTrue(it.succeeded()); assertFalse(it.failed()); assertEquals(1265615234l, (long) it.result()); assertNull(it.cause()); count.incrementAndGet(); },
      { assertTrue(it.succeeded()); assertFalse(it.failed()); assertEquals(12.345f, (float) it.result(), 0); assertNull(it.cause()); count.incrementAndGet(); },
      { assertTrue(it.succeeded()); assertFalse(it.failed()); assertEquals(12.34566d, (double) it.result(), 0); assertNull(it.cause()); count.incrementAndGet(); },
      { assertTrue(it.succeeded()); assertFalse(it.failed()); assertEquals(true, it.result()); assertNull(it.cause()); count.incrementAndGet(); },
      { assertTrue(it.succeeded()); assertFalse(it.failed()); assertEquals('X' as char, (char) it.result()); assertNull(it.cause()); count.incrementAndGet(); },
      { assertTrue(it.succeeded()); assertFalse(it.failed()); assertEquals("quux!", it.result()); assertNull(it.cause()); count.incrementAndGet(); }
    );
    assertEquals(9, count.get());
    count.set(0);
    obj.methodWithHandlerAsyncResultBasicTypes(true,
        { assertNull(it.result()); assertFalse(it.succeeded()); assertTrue(it.failed()); assertEquals("foobar!", it.cause().getMessage()); count.incrementAndGet(); },
        { assertNull(it.result()); assertFalse(it.succeeded()); assertTrue(it.failed()); assertEquals("foobar!", it.cause().getMessage()); count.incrementAndGet(); },
        { assertNull(it.result()); assertFalse(it.succeeded()); assertTrue(it.failed()); assertEquals("foobar!", it.cause().getMessage()); count.incrementAndGet(); },
        { assertNull(it.result()); assertFalse(it.succeeded()); assertTrue(it.failed()); assertEquals("foobar!", it.cause().getMessage()); count.incrementAndGet(); },
        { assertNull(it.result()); assertFalse(it.succeeded()); assertTrue(it.failed()); assertEquals("foobar!", it.cause().getMessage()); count.incrementAndGet(); },
        { assertNull(it.result()); assertFalse(it.succeeded()); assertTrue(it.failed()); assertEquals("foobar!", it.cause().getMessage()); count.incrementAndGet(); },
        { assertNull(it.result()); assertFalse(it.succeeded()); assertTrue(it.failed()); assertEquals("foobar!", it.cause().getMessage()); count.incrementAndGet(); },
        { assertNull(it.result()); assertFalse(it.succeeded()); assertTrue(it.failed()); assertEquals("foobar!", it.cause().getMessage()); count.incrementAndGet(); },
        { assertNull(it.result()); assertFalse(it.succeeded()); assertTrue(it.failed()); assertEquals("foobar!", it.cause().getMessage()); count.incrementAndGet(); }
    );
    assertEquals(9, count.get());
  }

  @Test
  public void methodWithUserTypes() {
    RefedInterface1 refed = new RefedInterface1(new RefedInterface1Impl());
    refed.setString("aardvarks");
    obj.methodWithUserTypes(refed);
  }
}
