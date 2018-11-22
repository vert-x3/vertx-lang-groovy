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

import io.vertx.core.Future

import com.acme.groovy.pkg.MyInterface
import com.acme.groovy.pkg.sub.SubInterface

import io.vertx.codegen.testmodel.RefedInterface1Impl
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.TestInterfaceImpl
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.core.AsyncResult
import io.vertx.core.VertxException
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.ConcreteHandlerUserTypeExtension
import io.vertx.codegen.testmodel.GenericRefedInterface
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.codegen.testmodel.RefedInterface2
import io.vertx.codegen.testmodel.TestInterface
import io.vertx.codegen.testmodel.Factory
import org.junit.Test

import static org.junit.Assert.*
/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class ApiTCKTest {

  final TestInterface obj = new TestInterfaceImpl()

  @Test
  void testMethodWithBasicParams() {
    obj.methodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, "foobar")
  }

  @Test
  void testMethodWithBasicBoxedParams() {
    obj.methodWithBasicBoxedParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char)
  }

  @Test
  void testMethodWithHandlerBasicTypes() {
    def count = 0
    obj.methodWithHandlerBasicTypes(
      { assertEquals(123, (byte) it); count++ },
      { assertEquals(12345, (short) it); count++ },
      { assertEquals(1234567, (int) it); count++ },
      { assertEquals(1265615234l, (long) it); count++ },
      { assertEquals(12.345f, (float) it, 0); count++ },
      { assertEquals(12.34566d, (double) it, 0); count++ },
      { assertEquals(true, it); count++ },
      { assertEquals('X' as char, (char) it); count++ },
      { assertEquals("quux!", it); count++ }
    )
    assertEquals(9, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultBasicTypes() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultByte(false, { checker.assertAsyncResult((byte) 123, it) })
    obj.methodWithHandlerAsyncResultShort(false, { checker.assertAsyncResult((short) 12345, it) })
    obj.methodWithHandlerAsyncResultInteger(false, { checker.assertAsyncResult(1234567, it) })
    obj.methodWithHandlerAsyncResultLong(false, { checker.assertAsyncResult(1265615234l, it) })
    obj.methodWithHandlerAsyncResultFloat(false, { checker.assertAsyncResult(12.345f, it) })
    obj.methodWithHandlerAsyncResultDouble(false, { checker.assertAsyncResult(12.34566d, it) })
    obj.methodWithHandlerAsyncResultBoolean(false, { checker.assertAsyncResult(true, it) })
    obj.methodWithHandlerAsyncResultCharacter(false, { checker.assertAsyncResult('X' as char, it) })
    obj.methodWithHandlerAsyncResultString(false, { checker.assertAsyncResult("quux!", it) })
    assertEquals(9, checker.count)
    checker.count = 0
    obj.methodWithHandlerAsyncResultByte(true, { checker.assertAsyncFailure("foobar!", it) })
    obj.methodWithHandlerAsyncResultShort(true, { checker.assertAsyncFailure("foobar!", it) })
    obj.methodWithHandlerAsyncResultInteger(true, { checker.assertAsyncFailure("foobar!", it) })
    obj.methodWithHandlerAsyncResultLong(true, { checker.assertAsyncFailure("foobar!", it) })
    obj.methodWithHandlerAsyncResultFloat(true, { checker.assertAsyncFailure("foobar!", it) })
    obj.methodWithHandlerAsyncResultDouble(true, { checker.assertAsyncFailure("foobar!", it) })
    obj.methodWithHandlerAsyncResultBoolean(true, { checker.assertAsyncFailure("foobar!", it) })
    obj.methodWithHandlerAsyncResultCharacter(true, { checker.assertAsyncFailure("foobar!", it) })
    obj.methodWithHandlerAsyncResultString(true, { checker.assertAsyncFailure("foobar!", it) })
    assertEquals(9, checker.count)
  }

  @Test
  void testMethodWithUserTypes() {
    RefedInterface1 refed = new RefedInterface1Impl()
    refed.setString("aardvarks")
    obj.methodWithUserTypes(refed)
  }

  @Test
  void testObjectParam() {
    JsonObject jobj = new JsonObject()
    jobj.put("foo","hello")
    jobj.put("bar",123)
    obj.methodWithObjectParam('null', null)
    obj.methodWithObjectParam('string', 'wibble')
    obj.methodWithObjectParam('true', true)
    obj.methodWithObjectParam('false', false)
    obj.methodWithObjectParam('long', 123)
    obj.methodWithObjectParam('double', 123.456)
    obj.methodWithObjectParam("JsonObject", jobj)
    def hell = "hell"
    def hello = "${hell}o"
    assertTrue(hello instanceof GString)
    obj.methodWithObjectParam("JsonObject", jobj)
    def oo = "oo"
    def foo = "f${oo}"
    assertTrue(foo instanceof GString)
    obj.methodWithObjectParam("JsonArray", new JsonArray([foo, "bar", "wib"]))
  }

  @Test
  void testDataObjectParam() {

    def dataObject = [
      foo: "hello",
      bar: 123,
      wibble: 1.23
    ] as TestDataObject
    obj.methodWithDataObjectParam(dataObject)
    def hell = "hell"

    dataObject = [
        foo: "${hell}o",
        bar: 123,
        wibble: 1.23
    ] as TestDataObject
    obj.methodWithDataObjectParam(dataObject)
  }

  @Test
  void testMethodWithHandlerDataObject() {
    def dataObject = new TestDataObject()
    dataObject.foo = "foo"
    dataObject.bar = 123
    def count = 0
    obj.methodWithHandlerDataObject({
      assertEquals(dataObject.foo, it.foo)
      assertEquals(dataObject.bar, it.bar)
      //assertNull(it.wibble)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultDataObject() {
    def dataObject = new TestDataObject()
    dataObject.foo = "foo"
    dataObject.bar = 123
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultDataObject(false, { result ->
      assertTrue(result.succeeded())
      assertFalse(result.failed())
      def res = result.result()
      assertEquals(dataObject.foo, res.foo)
      assertEquals(dataObject.bar, res.bar)
      assertNull(result.cause())
      checker.count++
    })
    obj.methodWithHandlerAsyncResultDataObject(true, { checker.assertAsyncFailure("foobar!", it) })
    assertEquals(2, checker.count)
  }

  @Test
  void testMethodWithHandlerStringReturn() {
    def handler = obj.methodWithHandlerStringReturn("the-result")
    handler.handle("the-result")
    def failed = false
    try {
      handler.handle("not-expected")
    }  catch (Throwable ignore) {
      failed = true
    }
    assertTrue(failed)
  }

  @Test
  void testMethodWithHandlerGenericReturn() {
    Object result = null
    def handler = obj.methodWithHandlerGenericReturn({ res ->
      result = res
    })
    handler.handle("the-result")
    assertEquals("the-result", result)
    handler.handle(obj)
    assertEquals(obj, result)
  }

  @Test
  void testMethodWithHandlerVertxGenReturn() {
    def handler = obj.methodWithHandlerVertxGenReturn("wibble")
    handler.handle(new RefedInterface1Impl().setString("wibble"))
  }

  @Test
  void testMethodWithHandlerAsyncResultStringReturn() {
    def succeedingHandler = obj.methodWithHandlerAsyncResultStringReturn("the-result", false)
    succeedingHandler.handle(Future.succeededFuture("the-result"))
    def failed = false
    try {
      succeedingHandler.handle(Future.succeededFuture("not-expected"))
    }  catch (Throwable ignore) {
      failed = true
    }
    assertTrue(failed)
    def failingHandler = obj.methodWithHandlerAsyncResultStringReturn("an-error", true)
    failingHandler.handle(Future.failedFuture("an-error"))
    failed = false
    try {
      failingHandler.handle(Future.succeededFuture("whatever"))
    } catch (Throwable ignore) {
      failed = true
    }
    assertTrue(failed)
  }

  @Test
  void testMethodWithHandlerAsyncResultGenericReturn() {
    Object result = null
    def succeedingHandler = obj.methodWithHandlerAsyncResultGenericReturn({ ar ->
      result = ar.succeeded() ? ar.result() : ar.cause()
    })
    succeedingHandler.handle(Future.succeededFuture("the-result"))
    assertEquals("the-result", result)
    succeedingHandler.handle(Future.succeededFuture(obj))
    assertEquals(obj, result)
  }

  @Test
  void testMethodWithHandlerAsyncResultVertxGenReturn() {
    def handler = obj.methodWithHandlerAsyncResultVertxGenReturn("wibble", false)
    handler.handle(Future.succeededFuture(new RefedInterface1Impl().setString("wibble")))
    handler = obj.methodWithHandlerAsyncResultVertxGenReturn("oh-no", true)
    handler.handle(Future.failedFuture("oh-no"))
  }

  @Test
  void testMethodWithHandlerUserTypes() {
    def count = 0
    obj.methodWithHandlerUserTypes({
      assertEquals("echidnas", it.string)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultUserTypes() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultUserTypes({
      checker.assertAsyncResult("cheetahs", it, { it.string })
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithConcreteHandlerUserTypesSubtype() {
    def count = 0
    obj.methodWithConcreteHandlerUserTypeSubtype(Factory.createConcreteHandlerUserType({
      assertEquals("echidnas", it.string)
      count++
    }))
    assertEquals(1, count)
  }

  @Test
  void testMethodWithAbstractHandlerUserTypesSubtype() {
    def count = 0
    obj.methodWithAbstractHandlerUserTypeSubtype(Factory.createAbstractHandlerUserType({
      assertEquals("echidnas", it.string)
      count++
    }))
    assertEquals(1, count)
  }

  @Test
  void testMethodWithConcreteHandlerUserTypesSubtypeExtension() {
    def count = 0
    obj.methodWithConcreteHandlerUserTypeSubtypeExtension(
        new io.vertx.codegen.testmodel.ConcreteHandlerUserTypeExtension() {
          @Override
          void handle(io.vertx.codegen.testmodel.RefedInterface1 event) {
            assertEquals("echidnas", event.string)
            count++
          }
        })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerVoid() {
    def count = 0
    obj.methodWithHandlerVoid({
      assertNull(it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultVoid() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultVoid(false, {
      checker.assertAsyncResult(null, it)
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerAsyncResultVoidFails() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultVoid(true, {
      checker.assertAsyncFailure("foo!", it)
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerThrowable() {
    def count = 0
    obj.methodWithHandlerThrowable({
      assertTrue(it instanceof VertxException)
      assertEquals("cheese!", it.message)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerGenericUserType() {
    def count = 0
    obj.methodWithHandlerGenericUserType("string_value", { s ->
      assertTrue(s instanceof GenericRefedInterface)
      assertEquals("string_value", s.value); count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultGenericUserType() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultGenericUserType("string_value_2", {
      checker.assertAsyncResult("string_value_2", it, { r -> ((GenericRefedInterface)r).value })
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithGenericParam() {
    JsonObject jobj = new JsonObject()
    jobj.put("foo","hello")
    jobj.put("bar",123)
    JsonArray ja = new JsonArray(["foo", "bar", "wib"])
    obj.methodWithGenericParam("String", "foo")
    obj.methodWithGenericParam("Ref", new RefedInterface1Impl().setString("bar"))
    obj.methodWithGenericParam("JsonObject", jobj)
    obj.methodWithGenericParam("JsonArray", ja)
  }

  @Test
  void testMethodWithGenericHandler() {
    JsonObject jobj = new JsonObject()
    jobj.put("foo","hello")
    jobj.put("bar",123)
    JsonArray ja = new JsonArray(["foo", "bar", "wib"])
    JsonObject jobjc = new JsonObject()
    jobjc.put("outer",[foo: "hello"])
    jobjc.put("bar",["this", "that"])
    def count = 0
    obj.methodWithGenericHandler("String", {
      assertEquals("foo", it)
      count++
    })
    assertEquals(1, count)
    count = 0
    obj.methodWithGenericHandler("Ref", {
      io.vertx.codegen.testmodel.RefedInterface1 ref = (io.vertx.codegen.testmodel.RefedInterface1) it
      assertEquals("bar", ref.string)
      count++
    })
    assertEquals(1, count)
    count = 0
    obj.methodWithGenericHandler("JsonObject", {
      assertEquals(jobj, it)
      count++
    })
    assertEquals(1, count)
    count = 0
    obj.methodWithGenericHandler("JsonArray", {
      assertEquals(ja, it)
      count++
    })
    count = 0
    obj.methodWithGenericHandler("JsonObjectComplex", {
      assertEquals(jobjc, it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithGenericHandlerAsyncResult() {
    JsonObject jobj = new JsonObject()
    jobj.put("foo","hello")
    jobj.put("bar",123)
    JsonArray ja = new JsonArray(["foo", "bar", "wib"])
    JsonObject jobjc = new JsonObject()
    jobjc.put("outer",[foo: "hello"])
    jobjc.put("bar",["this", "that"])
    def checker = new AsyncResultChecker()
    obj.methodWithGenericHandlerAsyncResult("String", {
      checker.assertAsyncResult("foo", it)
    })
    assertEquals(1, checker.count)
    checker = new AsyncResultChecker()
    obj.methodWithGenericHandlerAsyncResult("Ref", {
      AsyncResult<io.vertx.codegen.testmodel.RefedInterface1> asyncRef = (AsyncResult<io.vertx.codegen.testmodel.RefedInterface1>) it
      checker.assertAsyncResult("bar", asyncRef, { it.string })
    })
    assertEquals(1, checker.count)
    checker = new AsyncResultChecker()
    obj.methodWithGenericHandlerAsyncResult("JsonObject", {
      checker.assertAsyncResult(jobj, it)
    })
    assertEquals(1, checker.count)
    checker = new AsyncResultChecker()
    obj.methodWithGenericHandlerAsyncResult("JsonObjectComplex", {
      checker.assertAsyncResult(jobjc, it)
    })
    assertEquals(1, checker.count)
    checker = new AsyncResultChecker()
    obj.methodWithGenericHandlerAsyncResult("JsonArray", {
      checker.assertAsyncResult(ja, it)
    })
    assertEquals(1, checker.count)
  }

  // Returns

  // FIXME - currently missing tests for returns of all List<T>, Set<T>, Map<T> types

  @Test
  void testBasicReturns() {
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
  void testVertxGenReturn() {
    RefedInterface1 r = obj.methodWithVertxGenReturn()
    assertEquals("chaffinch", r.string)
  }

  @Test
  void testVertxGenNullReturn() {
    RefedInterface1 r = obj.methodWithVertxGenNullReturn()
    assertEquals(null, r)
  }

  @Test
  void testVertxAbstractGenReturn() {
    RefedInterface2 r = obj.methodWithAbstractVertxGenReturn()
    assertEquals("abstractchaffinch", r.string)
  }

  @Test
  void testDataObjectReturn() {
    TestDataObject r = obj.methodWithDataObjectReturn()
    assertEquals("foo", r.foo)
    assertEquals(123, r.bar)
  }

  @Test
  void testDataObjectNullReturn() {
    Map<String, Object> r = obj.methodWithDataObjectNullReturn()
    assertEquals(null, r)
  }

  @Test
  void testOverloadedMethods() {
    RefedInterface1 refed = new RefedInterface1Impl()
    refed.setString("dog")
    assertEquals("meth1", obj.overloadedMethod("cat", refed))
    def called = false
    assertEquals("meth2", obj.overloadedMethod("cat", refed, 12345) { assertEquals("giraffe", it); called = true })
    assertTrue(called)
    called = false
    assertEquals("meth3", obj.overloadedMethod("cat", { assertEquals("giraffe", it); called = true }))
    assertTrue(called)
    called = false
    assertEquals("meth4", obj.overloadedMethod("cat", refed, { assertEquals("giraffe", it); called = true }))
    assertTrue(called)
  }

  @Test
  void testSuperInterfaces() {
    obj.superMethodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, 'foobar')
    obj.otherSuperMethodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, 'foobar')
  }

  @Test
  void testMethodWithGenericReturn() {
    JsonObject jobj = new JsonObject()
    jobj.put("foo","hello")
    jobj.put("bar",123)
    JsonArray ja = new JsonArray(["foo","bar","wib"])
    def ret = obj.methodWithGenericReturn("JsonObject")
    assertTrue("Was expecting " + ret + " to implement Map", ret instanceof JsonObject)
    assertEquals(jobj, ret)
    ret = obj.methodWithGenericReturn("JsonArray")
    assertTrue("Was expecting " + ret + " to implement List", ret instanceof JsonArray)
    assertEquals(ja, ret)
  }

  @Test
  void testFluentMethod() {
    def ret = obj.fluentMethod("bar")
    assertSame(obj, ret)
  }

  @Test
  void testStaticFactoryMethod() {
    def ret = TestInterface.staticFactoryMethod("bar")
    assertEquals("bar", ret.string)
  }

  @Test
  void testJsonReturns() {
    JsonObject jobj = new JsonObject()
    jobj.put("cheese","stilton")
    JsonArray ja = new JsonArray(["socks","shoes"])
    def ret = obj.methodWithJsonObjectReturn()
    assertEquals(jobj, ret)
    ret = obj.methodWithJsonArrayReturn()
    assertEquals(ja, ret)
  }

  @Test
  void testNullJsonReturns() {
    def ret = obj.methodWithNullJsonObjectReturn()
    assertEquals(null, ret)
    ret = obj.methodWithNullJsonArrayReturn()
    assertEquals(null, ret)
  }

  @Test
  void testComplexJsonReturns() {
    JsonObject jobj = new JsonObject()
    jobj.put("outer",[socks: "tartan"])
    jobj.put("list",["yellow", "blue"])
    JsonArray ja = new JsonArray([[foo: "hello"], [bar: "bye"]])
    def ret = obj.methodWithComplexJsonObjectReturn()
    //assertEquals([outer: [socks: "tartan"], list: ["yellow", "blue"]], ret)
    assertEquals(jobj, ret)
    ret = obj.methodWithComplexJsonArrayReturn()
    //assertEquals([[foo: "hello"], [bar: "bye"]], ret)
    assertEquals(ja, ret)
  }

  @Test
  void testJsonParams() {
    JsonObject jobj = new JsonObject()
    jobj.put("cat","lion")
    jobj.put("cheese","cheddar")
    JsonArray ja = new JsonArray(["house","spider"])
    obj.methodWithJsonParams(jobj, ja)
  }

  @Test
  void testNullJsonParams() {
    obj.methodWithNullJsonParams(null, null)
  }

  @Test
  void testJsonHandlerParams() {
    def count = 0
    JsonObject jobj = new JsonObject()
    jobj.put("cheese","stilton")
    JsonArray ja = new JsonArray(["socks","shoes"])
    obj.methodWithHandlerJson({
      //assertEquals([cheese:"stilton"], it)
      assertEquals(jobj, it)
      count++
    }, {
      //assertEquals(["socks","shoes"], it)
      assertEquals(ja, it)
      count++
    })
    assertEquals(2, count)
  }

  @Test
  void testComplexJsonHandlerParams() {
    def count = 0
    JsonObject jobj = new JsonObject()
    jobj.put("outer",[socks: "tartan"])
    jobj.put("list",["yellow", "blue"])
    JsonArray ja = new JsonArray([[[foo: "hello"]], [[bar: "bye"]]])
    obj.methodWithHandlerComplexJson({
      assertEquals(jobj, it)
      count++
    }, {
      assertEquals(ja, it)
      count++
    })
    assertEquals(2, count)
  }

  @Test
  void testJsonHandlerAsyncResultParams() {
    JsonObject jobj = new JsonObject()
    JsonArray ja = new JsonArray(["socks","shoes"])
    jobj.put("cheese","stilton")
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultJsonObject({
      checker.assertAsyncResult(jobj, it)
    })
    obj.methodWithHandlerAsyncResultJsonArray({
      checker.assertAsyncResult(ja, it)
    })
    assertEquals(2, checker.count)
  }

  @Test
  void testNullJsonHandlerAsyncResultParams() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultNullJsonObject({
      checker.assertAsyncResult(null, it)
    })
    obj.methodWithHandlerAsyncResultNullJsonArray({
      checker.assertAsyncResult(null, it)
    })
    assertEquals(2, checker.count)
  }

  @Test
  void testComplexJsonHandlerAsyncResultParams() {
    JsonObject jobj = new JsonObject()
    JsonArray ja = new JsonArray([[foo: "hello"], [bar: "bye"]])
    jobj.put("outer",[socks: "tartan"])
    jobj.put("list",["yellow", "blue"])
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultComplexJsonObject({
      //checker.assertAsyncResult([outer: [socks: "tartan"], list: ["yellow", "blue"]], it)
      checker.assertAsyncResult(jobj, it)
    })
    obj.methodWithHandlerAsyncResultComplexJsonArray({
      //checker.assertAsyncResult([[foo: "hello"], [bar: "bye"]], it)
      checker.assertAsyncResult(ja, it)
    })
    assertEquals(2, checker.count)
  }

  @Test
  void testMethodWithEnumParam() {
    def ret = obj.methodWithEnumParam("cabbages", TestEnum.JULIEN)
    assertEquals("cabbagesJULIEN", ret)
  }

  @Test
  void testMethodWithThrowableParam() {
    def ret = obj.methodWithThrowableParam(new Exception("the_exception"))
    assertEquals("the_exception", ret)
  }

  @Test
  void testMethodWithEnumReturn() {
    TestEnum ret = obj.methodWithEnumReturn("JULIEN")
    assertEquals(TestEnum.JULIEN, ret)
  }

  @Test
  void testMethodWithThrowableReturn() {
    Throwable ret = obj.methodWithThrowableReturn("bogies")
    assertEquals("bogies", ret.getMessage())
  }

  @Test
  void testCustomModule() {
    MyInterface my = MyInterface.create()
    TestInterface testInterface = my.method()
    testInterface.methodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, "foobar")
    SubInterface sub = my.sub()
    assertEquals("olleh", sub.reverse("hello"))
  }
}
