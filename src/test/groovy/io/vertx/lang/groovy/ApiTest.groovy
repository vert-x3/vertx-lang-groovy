package io.vertx.lang.groovy

import io.vertx.codegen.testmodel.RefedInterface1Impl;
import io.vertx.codegen.testmodel.TestInterfaceImpl
import io.vertx.groovy.codegen.testmodel.RefedInterface1;
import io.vertx.groovy.codegen.testmodel.TestInterface;
import org.junit.Test

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ApiTest {

  final TestInterface obj = new TestInterface(new TestInterfaceImpl());

  @Test
  public void testMethodWithBasicParams() {
    obj.methodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, "foobar");
  }

  @Test
  public void testMethodWithBasicBoxedParams() {
    obj.methodWithBasicBoxedParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char);
  }

  @Test
  public void testMethodWithHandlerBasicTypes() {
    def count = 0;
    obj.methodWithHandlerBasicTypes(
      { assertEquals(123, (byte) it); count++; },
      { assertEquals(12345, (short) it); count++; },
      { assertEquals(1234567, (int) it); count++; },
      { assertEquals(1265615234l, (long) it); count++; },
      { assertEquals(12.345f, (float) it, 0); count++; },
      { assertEquals(12.34566d, (double) it, 0); count++; },
      { assertEquals(true, it); count++; },
      { assertEquals('X' as char, (char) it); count++; },
      { assertEquals("quux!", it); count++; }
    );
    assertEquals(9, count);
  }

  @Test
  public void testMethodWithHandlerAsyncResultBasicTypes() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultBasicTypes(false,
      { checker.assertAsyncResult((byte) 123, it); },
      { checker.assertAsyncResult((short) 12345, it); },
      { checker.assertAsyncResult(1234567, it); },
      { checker.assertAsyncResult(1265615234l, it); },
      { checker.assertAsyncResult(12.345f, it); },
      { checker.assertAsyncResult(12.34566d, it); },
      { checker.assertAsyncResult(true, it); },
      { checker.assertAsyncResult('X' as char, it); },
      { checker.assertAsyncResult("quux!", it); },
    );
    assertEquals(9, checker.count);
    checker.count = 0;
    obj.methodWithHandlerAsyncResultBasicTypes(true,
      { checker.assertAsyncFailure("foobar!", it); },
      { checker.assertAsyncFailure("foobar!", it); },
      { checker.assertAsyncFailure("foobar!", it); },
      { checker.assertAsyncFailure("foobar!", it); },
      { checker.assertAsyncFailure("foobar!", it); },
      { checker.assertAsyncFailure("foobar!", it); },
      { checker.assertAsyncFailure("foobar!", it); },
      { checker.assertAsyncFailure("foobar!", it); },
      { checker.assertAsyncFailure("foobar!", it); }
    );
    assertEquals(9, checker.count);
  }

  @Test
  public void testMethodWithUserTypes() {
    RefedInterface1 refed = new RefedInterface1(new RefedInterface1Impl());
    refed.setString("aardvarks");
    obj.methodWithUserTypes(refed);
  }

  @Test
  public void testObjectParam() {
    obj.methodWithObjectParam("JsonObject", [foo: "hello", bar: 123]);
    def hell = "hell";
    def hello = "${hell}o"
    assertTrue(hello instanceof GString)
    obj.methodWithObjectParam("JsonObject", [foo: hello, bar: 123]);
    def oo = "oo";
    def foo = "f${oo}"
    assertTrue(foo instanceof GString)
    obj.methodWithObjectParam("JsonArray", [foo, "bar", "wib"]);
  }

  @Test
  public void testOptionsParam() {
    def options = [
      foo: "hello",
      bar: 123,
      wibble: 1.23
    ];
    obj.methodWithOptionsParam(options);
    def hell = "hell"
    options = [
        foo: "${hell}o",
        bar: 123,
        wibble: 1.23
    ];
    obj.methodWithOptionsParam(options);
  }

  @Test
  public void testMethodWithHandlerListAndSet() {
    def count = 0;
    obj.methodWithHandlerListAndSet(
      { assertEquals(["foo", "bar", "wibble"], it); count++ },
      { assertEquals([5, 12, 100], it); count++ },
      { assertEquals(["foo", "bar", "wibble"] as Set, it); count++ },
      { assertEquals([5, 12, 100] as Set, it); count++ },
    );
    assertEquals(4, count);
  }

  @Test
  public void testMethodWithHandlerAsyncResultListAndSet() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultListAndSet(
      { checker.assertAsyncResult(["foo", "bar", "wibble"], it) },
      { checker.assertAsyncResult([5, 12, 100], it) },
      { checker.assertAsyncResult(["foo", "bar", "wibble"] as Set, it) },
      { checker.assertAsyncResult([5, 12, 100] as Set, it) }
    );
    assertEquals(4, checker.count);
  }
}
