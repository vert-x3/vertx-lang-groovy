package io.vertx.lang.groovy

import io.vertx.codegen.testmodel.RefedInterface1Impl;
import io.vertx.codegen.testmodel.TestInterfaceImpl
import io.vertx.core.AsyncResult
import io.vertx.core.VertxException
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

  @Test
  public void testMethodWithHandlerListVertxGen() {
    def count = 0;
    obj.methodWithHandlerListVertxGen({
      assertEquals(["foo","bar"], it.collect({it.string}))
      count++
    });
    assertEquals(1, count);
  }

  @Test
  public void testMethodWithHandlerAsyncResultListVertxGen() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultListVertxGen({ result ->
      checker.assertAsyncResult(["foo","bar"], result, { list -> list.collect({ RefedInterface1 r -> r.string }) })
    });
    assertEquals(1, checker.count);
  }

  @Test
  public void testMethodWithHandlerSetVertxGen() {
    def count = 0;
    obj.methodWithHandlerSetVertxGen({
      assertEquals(["bar","foo"], it.collect({it.string}).sort())
      count++
    });
  }

  @Test
  public void testMethodWithHandlerAsyncResultSetVertxGen() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultSetVertxGen({ result ->
      checker.assertAsyncResult(["foo","bar"] as Set, result, { set -> set.collect({ RefedInterface1 r -> r.string }) as Set })
    });
    assertEquals(1, checker.count);
  }

  @Test
  public void testMethodWithHandlerListJsonObject() {
    def count = 0;
    obj.methodWithHandlerListJsonObject({
      assertEquals([[cheese:"stilton"],[socks:"tartan"]], it);
      count++;
    });
    assertEquals(1, count)
  }

  @Test
  public void testMethodWithHandlerAsyncResultListJsonObject() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultListJsonObject({
      checker.assertAsyncResult([[cheese:"stilton"],[socks:"tartan"]], it)
    })
    assertEquals(1, checker.count);
  }

  @Test
  public void testMethodWithHandlerSetJsonObject() {
    def count = 0;
    obj.methodWithHandlerSetJsonObject({
      assertEquals([[cheese:"stilton"],[socks:"tartan"]] as Set, it);
      count++;
    });
    assertEquals(1, count)
  }

  @Test
  public void testMethodWithHandlerAsyncResultSetJsonObject() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultSetJsonObject({
      checker.assertAsyncResult([[cheese:"stilton"],[socks:"tartan"]] as Set, it)
    })
    assertEquals(1, checker.count);
  }

  @Test
  public void testMethodWithHandlerListJsonArray() {
    def count = 0;
    obj.methodWithHandlerListJsonArray({
      assertEquals([["green","blue"],["yellow","purple"]], it);
      count++;
    });
    assertEquals(1, count)
  }

  @Test
  public void testMethodWithHandlerAsyncResultListJsonArray() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultListJsonArray({
      checker.assertAsyncResult([["green","blue"],["yellow","purple"]], it)
    });
    assertEquals(1, checker.count);
  }

  @Test
  public void testMethodWithHandlerSetJsonArray() {
    def count = 0;
    obj.methodWithHandlerSetJsonArray({
      assertEquals([["green","blue"],["yellow","purple"]] as Set, it);
      count++;
    });
    assertEquals(1, count)
  }

  @Test
  public void testMethodWithHandlerAsyncResultSetJsonArray() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultSetJsonArray({
      checker.assertAsyncResult([["green","blue"],["yellow","purple"]] as Set, it)
    });
    assertEquals(1, checker.count);
  }

  @Test
  public void testMethodWithHandlerUserTypes() {
    def count = 0;
    obj.methodWithHandlerUserTypes({
      assertEquals("echidnas", it.string)
      count++
    });
    assertEquals(1, count)
  }

  @Test
  public void testMethodWithHandlerAsyncResultUserTypes() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultUserTypes({
      checker.assertAsyncResult("cheetahs", it, { it.string })
    })
    assertEquals(1, checker.count);
  }

  @Test
  public void testMethodWithHandlerVoid() {
    def count = 0;
    obj.methodWithHandlerVoid({
      assertNull(it);
      count++
    })
    assertEquals(1, count);
  }

  @Test
  public void testMethodWithHandlerAsyncResultVoid() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultVoid(false, {
      checker.assertAsyncResult(null, it);
    })
    assertEquals(1, checker.count);
  }

  @Test
  public void testMethodWithHandlerAsyncResultVoidFails() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultVoid(true, {
      checker.assertAsyncFailure("foo!", it);
    })
    assertEquals(1, checker.count);
  }

  @Test
  public void testMethodWithHandlerThrowable() {
    def count = 0;
    obj.methodWithHandlerThrowable({
      assertTrue(it instanceof VertxException)
      assertEquals("cheese!", it.message);
      count++
    })
    assertEquals(1, count);
  }

  @Test
  public void testBasicReturns() {
    assertEquals(123, obj.methodWithByteReturn())
    assertEquals(12345, obj.methodWithShortReturn())
    assertEquals(12345464, obj.methodWithIntReturn())
    assertEquals(65675123, obj.methodWithLongReturn())
    assertEquals(1.23f, obj.methodWithFloatReturn(), 0)
    assertEquals(3.34535, obj.methodWithDoubleReturn(), 0)
    assertEquals(true, obj.methodWithBooleanReturn())
    assertEquals('Y' as char, obj.methodWithCharReturn())
    assertEquals("orangutan", obj.methodWithStringReturn())
  }

  @Test
  public void testVertxGenReturn() {
    RefedInterface1 r = obj.methodWithVertxGenReturn();
    assertEquals("chaffinch", r.string)
  }

  @Test
  public void testListStringReturn() {
    assertEquals(["foo", "bar", "wibble"], obj.methodWithListStringReturn())
  }
}
