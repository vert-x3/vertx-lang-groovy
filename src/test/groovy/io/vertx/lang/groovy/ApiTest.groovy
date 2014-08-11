/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

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
    obj.methodWithHandlerAsyncResultByte(false, { checker.assertAsyncResult((byte) 123, it); });
    obj.methodWithHandlerAsyncResultShort(false, { checker.assertAsyncResult((short) 12345, it); });
    obj.methodWithHandlerAsyncResultInteger(false, { checker.assertAsyncResult(1234567, it); });
    obj.methodWithHandlerAsyncResultLong(false, { checker.assertAsyncResult(1265615234l, it); });
    obj.methodWithHandlerAsyncResultFloat(false, { checker.assertAsyncResult(12.345f, it); });
    obj.methodWithHandlerAsyncResultDouble(false, { checker.assertAsyncResult(12.34566d, it); });
    obj.methodWithHandlerAsyncResultBoolean(false, { checker.assertAsyncResult(true, it); });
    obj.methodWithHandlerAsyncResultCharacter(false, { checker.assertAsyncResult('X' as char, it); });
    obj.methodWithHandlerAsyncResultString(false, { checker.assertAsyncResult("quux!", it); });
    assertEquals(9, checker.count);
    checker.count = 0;
    obj.methodWithHandlerAsyncResultByte(true, { checker.assertAsyncFailure("foobar!", it); });
    obj.methodWithHandlerAsyncResultShort(true, { checker.assertAsyncFailure("foobar!", it); });
    obj.methodWithHandlerAsyncResultInteger(true, { checker.assertAsyncFailure("foobar!", it); });
    obj.methodWithHandlerAsyncResultLong(true, { checker.assertAsyncFailure("foobar!", it); });
    obj.methodWithHandlerAsyncResultFloat(true, { checker.assertAsyncFailure("foobar!", it); });
    obj.methodWithHandlerAsyncResultDouble(true, { checker.assertAsyncFailure("foobar!", it); });
    obj.methodWithHandlerAsyncResultBoolean(true, { checker.assertAsyncFailure("foobar!", it); });
    obj.methodWithHandlerAsyncResultCharacter(true, { checker.assertAsyncFailure("foobar!", it); });
    obj.methodWithHandlerAsyncResultString(true, { checker.assertAsyncFailure("foobar!", it); });
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
  public void testNullOptionsParam() {
    obj.methodWithNullOptionsParam(null);
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
    obj.methodWithHandlerAsyncResultListString({ checker.assertAsyncResult(["foo", "bar", "wibble"], it) });
    obj.methodWithHandlerAsyncResultListInteger({ checker.assertAsyncResult([5, 12, 100], it) });
    obj.methodWithHandlerAsyncResultSetString({ checker.assertAsyncResult(["foo", "bar", "wibble"] as Set, it) });
    obj.methodWithHandlerAsyncResultSetInteger({ checker.assertAsyncResult([5, 12, 100] as Set, it) });
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
  public void testMethodWithHandlerListNullJsonObject() {
    def count = 0;
    obj.methodWithHandlerListNullJsonObject({
      assertEquals([null], it);
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
  public void testMethodWithHandlerAsyncResultListNullJsonObject() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultListNullJsonObject({
      checker.assertAsyncResult([null], it)
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
  public void testMethodWithHandlerSetNullJsonObject() {
    def count = 0;
    obj.methodWithHandlerSetNullJsonObject({
      assertEquals([null] as Set, it);
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
  public void testMethodWithHandlerAsyncResultSetNullJsonObject() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultSetNullJsonObject({
      checker.assertAsyncResult([null] as Set, it)
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
  public void testMethodWithHandlerListNullJsonArray() {
    def count = 0;
    obj.methodWithHandlerListNullJsonArray({
      assertEquals([null], it);
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
  public void testMethodWithHandlerAsyncResultListNullJsonArray() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultListNullJsonArray({
      checker.assertAsyncResult([null], it)
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
  public void testMethodWithHandlerSetNullJsonArray() {
    def count = 0;
    obj.methodWithHandlerSetNullJsonArray({
      assertEquals([null] as Set, it);
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
  public void testMethodWithHandlerAsyncResultNullSetJsonArray() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultSetNullJsonArray({
      checker.assertAsyncResult([null] as Set, it)
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
  public void testMethodWithGenericParam() {
    obj.methodWithGenericParam("String", "foo")
    obj.methodWithGenericParam("Ref", new RefedInterface1Impl().setString("foo"))
    obj.methodWithGenericParam("JsonObject", [foo:"hello","bar":123])
    obj.methodWithGenericParam("JsonArray", ["foo", "bar", "wib"])
  }

  @Test
  public void testMethodWithGenericHandler() {
    def count = 0;
    obj.methodWithGenericHandler("String", {
      assertEquals("handlerFoo", it)
      count++
    })
    assertEquals(1, count);
    count = 0;
    obj.methodWithGenericHandler("Ref", {
      io.vertx.codegen.testmodel.RefedInterface1 ref = (io.vertx.codegen.testmodel.RefedInterface1) it;
      assertEquals("bar", ref.string)
      count++
    })
    assertEquals(1, count);
    count = 0;
    obj.methodWithGenericHandler("JsonObject", {
      assertEquals([foo:"hello","bar":123], it)
      count++
    })
    assertEquals(1, count);
    count = 0;
    obj.methodWithGenericHandler("JsonArray", {
      assertEquals(["foo", "bar", "wib"], it)
      count++
    })
    assertEquals(1, count);
  }

  @Test
  public void testMethodWithGenericHandlerAsyncResult() {
    def checker = new AsyncResultChecker();
    obj.methodWithGenericHandlerAsyncResult("String", {
      checker.assertAsyncResult("asyncResultHandlerFoo", it)
    })
    assertEquals(1, checker.count);
    checker = new AsyncResultChecker();
    obj.methodWithGenericHandlerAsyncResult("Ref", {
      AsyncResult<io.vertx.codegen.testmodel.RefedInterface1> asyncRef = (AsyncResult<io.vertx.codegen.testmodel.RefedInterface1>) it;
      checker.assertAsyncResult("bar", asyncRef, { it.string })
    })
    assertEquals(1, checker.count);
    checker = new AsyncResultChecker();
    obj.methodWithGenericHandlerAsyncResult("JsonObject", {
      checker.assertAsyncResult([foo:"hello","bar":123], it)
    })
    assertEquals(1, checker.count);
    checker = new AsyncResultChecker();
    obj.methodWithGenericHandlerAsyncResult("JsonArray", {
      checker.assertAsyncResult(["foo", "bar", "wib"], it)
    })
    assertEquals(1, checker.count);
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

  @Test
  public void testSetStringReturn() {
    assertEquals(["foo", "bar", "wibble"] as Set, obj.methodWithSetStringReturn())
  }

  @Test
  public void testOverloadedMethods() {
    RefedInterface1 refed = new RefedInterface1(new RefedInterface1Impl())
    refed.setString("dog")
    assertEquals("meth1", obj.overloadedMethod("cat", refed))
    assertEquals("meth2", obj.overloadedMethod("cat", refed, 12345))
    def called = false
    assertEquals("meth3", obj.overloadedMethod("cat", refed, 12345, { assertEquals("giraffe", it); called = true }))
    assertTrue(called)
  }

  @Test
  public void testSuperInterfaces() {
    obj.superMethodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, 'foobar')
    obj.otherSuperMethodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, 'foobar');
  }

  @Test
  public void testMethodWithGenericReturn() {
    def ret = obj.methodWithGenericReturn(true);
    assertTrue("Was expecting " + ret + " to implement Map", ret instanceof Map);
    assertEquals([foo:"bar"], ret);
    ret = obj.methodWithGenericReturn(false);
    assertTrue("Was expecting " + ret + " to implement List", ret instanceof List);
    assertEquals(["foo","bar"], ret);
  }

  @Test
  public void testFluentMethod() {
    def ret = obj.fluentMethod("bar");
    assertSame(obj, ret)
  }

  @Test
  public void testStaticFactoryMethod() {
    def ret = TestInterface.staticFactoryMethod("bar");
    assertEquals("bar", ret.string);
  }

  @Test
  public void testMethodWithCachedReturn() {
    def ret1 = obj.methodWithCachedReturn("bar");
    assertEquals("bar", ret1.string);
    def ret2 = obj.methodWithCachedReturn("bar");
    assertSame(ret1, ret2);
    def ret3 = obj.methodWithCachedReturn("bar");
    assertSame(ret1, ret3);
  }

  @Test
  public void testJsonReturns() {
    def ret = obj.methodwithJsonObjectReturn();
    assertEquals([cheese:"stilton"], ret);
    ret = obj.methodWithJsonArrayReturn();
    assertEquals(["socks", "shoes"], ret);
  }

  @Test
  public void testNullJsonReturns() {
    def ret = obj.methodWithNullJsonObjectReturn();
    assertEquals(null, ret);
    ret = obj.methodWithNullJsonArrayReturn();
    assertEquals(null, ret);
  }

  @Test
  public void testJsonParams() {
    obj.methodWithJsonParams([cat:"lion",cheese:"cheddar"], ["house","spider"]);
  }

  @Test
  public void testNullJsonParams() {
    obj.methodWithNullJsonParams(null, null);
  }

  @Test
  public void testJsonHandlerParams() {
    def count = 0;
    obj.methodWithHandlerJson({
      assertEquals([cheese:"stilton"], it)
      count++;
    }, {
      assertEquals(["socks","shoes"], it)
      count++;
    });
    assertEquals(2, count);
  }

  @Test
  public void testNullJsonHandlerParams() {
    def count = 0;
    obj.methodWithHandlerNullJson({
      assertEquals(null, it)
      count++;
    }, {
      assertEquals(null, it)
      count++;
    });
    assertEquals(2, count);
  }

  @Test
  public void testJsonHandlerAsyncResultParams() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultJsonObject({
      checker.assertAsyncResult([cheese:"stilton"], it)
    });
    obj.methodWithHandlerAsyncResultJsonArray({
      checker.assertAsyncResult(["socks","shoes"], it)
    });
    assertEquals(2, checker.count);
  }

  @Test
  public void testNullJsonHandlerAsyncResultParams() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultNullJsonObject({
      checker.assertAsyncResult(null, it)
    });
    obj.methodWithHandlerAsyncResultNullJsonArray({
      checker.assertAsyncResult(null, it)
    });
    assertEquals(2, checker.count);
  }
}
