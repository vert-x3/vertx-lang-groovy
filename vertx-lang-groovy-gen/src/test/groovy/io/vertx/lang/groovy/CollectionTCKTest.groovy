package io.vertx.lang.groovy

import io.vertx.codegen.testmodel.CollectionTCKImpl
import io.vertx.codegen.testmodel.RefedInterface1Impl
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.core.json.Json
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.groovy.codegen.testmodel.CollectionTCK
import io.vertx.groovy.codegen.testmodel.RefedInterface1
import io.vertx.groovy.codegen.testmodel.RefedInterface2
import org.junit.Test

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.Set

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNull
import static org.junit.Assert.assertTrue

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class CollectionTCKTest {

  final CollectionTCK obj = new CollectionTCKImpl()

  @Test
  void testListStringReturn() {
    assertEquals(["foo", "bar", "wibble"], obj.methodWithListStringReturn())
  }

  @Test
  void testListLongReturn() {
    assertEquals([123l, 456l], obj.methodWithListLongReturn())
  }

  @Test
  void testListJsonObjectReturn() {
    List<JsonObject> list = obj.methodWithListJsonObjectReturn()
    assertEquals(2, list.size())
    JsonObject json1 = list.get(0)
    assertEquals("bar", json1.getValue("foo"))
    JsonObject json2 = list.get(1)
    assertEquals("eek", json2.getValue("blah"))
  }

  @Test
  void testListComplexJsonObjectReturn() {
    JsonObject jo = new JsonObject().put("socks", "tartan")
    JsonArray ja = new JsonArray(["yellow","blue"])
    JsonObject jo2 = new JsonObject().put("outer",jo).put("list",ja)
    List<JsonObject> list = obj.methodWithListComplexJsonObjectReturn()
    assertEquals(1, list.size())
    JsonObject json1 = list.get(0)
    assertEquals(jo2, json1)
  }

  @Test
  void testListJsonArrayReturn() {
    List<JsonArray> list = obj.methodWithListJsonArrayReturn()
    assertEquals(2, list.size())
    JsonArray json1 = list.get(0)
    assertEquals("foo", json1.getValue(0))
    JsonArray json2 = list.get(1)
    assertEquals("blah", json2.getValue(0))
  }

  @Test
  void testListComplexJsonArrayReturn() {
    List<JsonArray> list = obj.methodWithListComplexJsonArrayReturn()
    assertEquals(2, list.size())
    JsonArray json1 = list.get(0)
    assertEquals(new JsonArray().add(new JsonObject().put("foo","hello")), json1)
    JsonArray json2 = list.get(1)
    assertEquals(new JsonArray().add(new JsonObject().put("bar","bye")), json2)
  }

  @Test
  void testListVertxGenReturn() {
    List<io.vertx.groovy.codegen.testmodel.RefedInterface1> list = obj.methodWithListVertxGenReturn()
    assertEquals(2, list.size())
    RefedInterface1 refed1 = list.get(0)
    assertTrue(refed1 instanceof io.vertx.groovy.codegen.testmodel.RefedInterface1)
    RefedInterface1 refed2 = list.get(1)
    assertEquals("foo", refed1.getString())
    assertEquals("bar", refed2.getString())
  }

  @Test
  void testListDataObjectReturn() {
    List<TestDataObject> list = obj.methodWithListDataObjectReturn()
    assertTrue(list[0] instanceof TestDataObject)
    assertEquals("String 1", list[0].foo)
    assertEquals(1, list[0].bar)
    assertEquals(1.1, list[0].wibble, 0)
    assertTrue(list[1] instanceof TestDataObject)
    assertEquals("String 2", list[1].foo)
    assertEquals(2, list[1].bar)
    assertEquals(2.2, list[1].wibble, 0)
  }

  @Test
  void testSetStringReturn() {
    assertEquals(["foo", "bar", "wibble"] as Set, obj.methodWithSetStringReturn())
  }

  @Test
  void testSetLongReturn() {
    assertEquals([123l, 456l] as Set, obj.methodWithSetLongReturn())
  }

  @Test
  void testSetJsonObjectReturn() {
    Set<JsonObject> set = obj.methodWithSetJsonObjectReturn()
    assertEquals(2, set.size())
    JsonObject json1 = new JsonObject()
    json1.put("foo", "bar")
    assertTrue(set.contains(json1))
    JsonObject json2 = new JsonObject()
    json2.put("blah", "eek")
    assertTrue(set.contains(json2))
  }

  @Test
  void testSetComplexJsonObjectReturn() {
    Set<JsonObject> set = obj.methodWithSetComplexJsonObjectReturn()
    JsonObject jo = new JsonObject().put("socks", "tartan")
    JsonArray ja = new JsonArray(["yellow","blue"])
    JsonObject jo2 = new JsonObject().put("outer",jo).put("list",ja)
    assertEquals(1, set.size())
    assertTrue(set.contains(jo2))
  }

  @Test
  void testSetJsonArrayReturn() {
    Set<JsonArray> set = obj.methodWithSetJsonArrayReturn()
    assertEquals(2, set.size())
    JsonArray json1 = new JsonArray()
    json1.add("foo")
    assertTrue(set.contains(json1))
    JsonArray json2 = new JsonArray()
    json2.add("blah")
    assertTrue(set.contains(json2))
  }

  @Test
  void testSetComplexJsonArrayReturn() {
    Set<JsonArray> set = obj.methodWithSetComplexJsonArrayReturn()
    JsonArray ja = new JsonArray().add(new JsonObject().put("foo","hello"))
    JsonArray ja2 = new JsonArray().add(new JsonObject().put("bar","bye"))
    assertEquals(2, set.size())
    assertTrue(set.contains(ja))
    assertTrue(set.contains(ja2))
  }

  @Test
  void testSetVertxGenReturn() {
    Set<io.vertx.groovy.codegen.testmodel.RefedInterface1> set = obj.methodWithSetVertxGenReturn()
    assertEquals(2, set.size())
    RefedInterface1 refed1 = new RefedInterface1Impl()
    refed1.setString("foo")
    RefedInterface1 refed2 = new RefedInterface1Impl()
    refed2.setString("bar")
    List<RefedInterface1> list = new ArrayList<>(set)
    assertTrue((list.get(0).getString().equals("foo") && list.get(1).getString().equals("bar")) || (list.get(0).getString().equals("bar") && list.get(1).getString().equals("foo")))
  }

  @Test
  void testSetDataObjectReturn() {
    def set = obj.methodWithSetDataObjectReturn()
    def tdo = new TestDataObject([foo:"String 1",bar: 1,wibble: 1.1d])
    def tdo2 = new TestDataObject([foo:"String 2",bar: 2,wibble: 2.2d])
    System.out.println(set)
    System.out.println(tdo)
    System.out.println(tdo2)
    assertEquals(2, set.size())
    assertTrue(set.contains(tdo))
    assertTrue(set.contains(tdo2))
  }

  @Test
  void testMapStringReturn() {
    Map<String, String> map = obj.methodWithMapStringReturn({})
    assertEquals("bar", map.get("foo"))
  }

  @Test
  void testMapLongReturn() {
    Map<String, Long> map = obj.methodWithMapLongReturn({})
    assertEquals(123l, map.get("foo"))
  }

  @Test
  void testMapJsonObjectReturn() {
    Map<String, JsonObject> map = obj.methodWithMapJsonObjectReturn({})
    JsonObject m = map.get("foo")
    assertEquals("eek", m.getValue(("wibble")))
  }

  @Test
  void testMapComplexJsonObjectReturn() {
    Map<String, JsonObject> map = obj.methodWithMapComplexJsonObjectReturn({})
    JsonObject jo = new JsonObject().put("socks", "tartan")
    JsonArray ja = new JsonArray(["yellow","blue"])
    JsonObject jo2 = new JsonObject().put("outer",jo).put("list",ja)
    JsonObject m = map.get("foo")
    assertEquals(jo2, m)
  }

  @Test
  void testMapJsonArrayReturn() {
    Map<String, JsonArray> map = obj.methodWithMapJsonArrayReturn({})
    JsonArray m = map.get("foo")
    assertEquals("wibble", m.getValue(0))
  }

  @Test
  void testMapComplexJsonArrayReturn() {
    Map<String, JsonArray> map = obj.methodWithMapComplexJsonArrayReturn({})
    JsonArray m = map.get("foo")
    assertEquals(new JsonArray().add(new JsonObject().put("foo", "hello")).add(new JsonObject().put("bar", "bye")), m)
  }

  @Test
  void testMethodWithHandlerListAndSet() {
    def count = 0
    obj.methodWithHandlerListAndSet(
        { assertEquals(["foo", "bar", "wibble"], it); count++ },
        { assertEquals([5, 12, 100], it); count++ },
        { assertEquals(["foo", "bar", "wibble"] as Set, it); count++ },
        { assertEquals([5, 12, 100] as Set, it); count++ },
    )
    assertEquals(4, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultListAndSet() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultListString({ checker.assertAsyncResult(["foo", "bar", "wibble"], it) })
    obj.methodWithHandlerAsyncResultListInteger({ checker.assertAsyncResult([5, 12, 100], it) })
    obj.methodWithHandlerAsyncResultSetString({ checker.assertAsyncResult(["foo", "bar", "wibble"] as Set, it) })
    obj.methodWithHandlerAsyncResultSetInteger({ checker.assertAsyncResult([5, 12, 100] as Set, it) })
    assertEquals(4, checker.count)
  }

  @Test
  void testMethodWithHandlerListVertxGen() {
    def count = 0
    obj.methodWithHandlerListVertxGen({
      assertEquals(["foo","bar"], it.collect({it.string}))
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerListAbstractVertxGen() {
    def count = 0
    obj.methodWithHandlerListAbstractVertxGen({
      assertEquals(["abstractfoo","abstractbar"], it.collect({it.string}))
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultListVertxGen() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultListVertxGen({ result ->
      checker.assertAsyncResult(["foo","bar"], result, { list -> list.collect({ RefedInterface1 r -> r.string }) })
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerAsyncResultListAbstractVertxGen() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultListAbstractVertxGen({ result ->
      checker.assertAsyncResult(["abstractfoo","abstractbar"], result, { list -> list.collect({ RefedInterface2 r -> r.string }) })
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerSetVertxGen() {
    def count = 0
    obj.methodWithHandlerSetVertxGen({
      assertEquals(["bar","foo"], it.collect({it.string}).sort())
      count++
    })
  }

  @Test
  void testMethodWithHandlerSetAbstractVertxGen() {
    def count = 0
    obj.methodWithHandlerSetAbstractVertxGen({
      assertEquals(["abstractbar","abstractfoo"], it.collect({it.string}).sort())
      count++
    })
  }

  @Test
  void testMethodWithHandlerAsyncResultSetVertxGen() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultSetVertxGen({ result ->
      checker.assertAsyncResult(["foo","bar"] as Set, result, { set -> set.collect({ RefedInterface1 r -> r.string }) as Set })
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerAsyncResultSetAbstractVertxGen() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultSetAbstractVertxGen({ result ->
      checker.assertAsyncResult(["abstractfoo","abstractbar"] as Set, result, { set -> set.collect({ RefedInterface2 r -> r.string }) as Set })
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerListJsonObject() {
    def count = 0
    JsonObject jo = new JsonObject().put("cheese", "stilton")
    JsonObject jo2 = new JsonObject().put("socks", "tartan")
    obj.methodWithHandlerListJsonObject({
      assertEquals([jo,jo2], it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerListComplexJsonObject() {
    def count = 0
    JsonObject jo = new JsonObject().put("socks", "tartan")
    JsonArray ja = new JsonArray(["yellow","blue"])
    JsonObject jo2 = new JsonObject().put("outer",jo).put("list",ja)
    obj.methodWithHandlerListComplexJsonObject({
      assertEquals([jo2], it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultListJsonObject() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultListJsonObject({
      checker.assertAsyncResult([new JsonObject().put("cheese", "stilton"), new JsonObject().put("socks", "tartan")], it)
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerAsyncResultListComplexJsonObject() {
    def checker = new AsyncResultChecker()
    JsonObject jo = new JsonObject().put("socks", "tartan")
    JsonArray ja = new JsonArray(["yellow","blue"])
    JsonObject jo2 = new JsonObject().put("outer",jo).put("list",ja)
    obj.methodWithHandlerAsyncResultListComplexJsonObject({
      checker.assertAsyncResult([jo2], it)
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerSetJsonObject() {
    def count = 0
    JsonObject jo = new JsonObject().put("cheese", "stilton")
    JsonObject jo2 = new JsonObject().put("socks", "tartan")
    obj.methodWithHandlerSetJsonObject({
      assertEquals([jo,jo2] as Set, it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerSetComplexJsonObject() {
    def count = 0
    JsonObject jo = new JsonObject().put("socks", "tartan")
    JsonArray ja = new JsonArray(["yellow","blue"])
    JsonObject jo2 = new JsonObject().put("outer",jo).put("list",ja)
    obj.methodWithHandlerSetComplexJsonObject({
      assertEquals([jo2] as Set, it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultSetJsonObject() {
    def checker = new AsyncResultChecker()
    JsonObject jo = new JsonObject().put("cheese", "stilton")
    JsonObject jo2 = new JsonObject().put("socks", "tartan")
    obj.methodWithHandlerAsyncResultSetJsonObject({
      checker.assertAsyncResult([jo,jo2] as Set, it)
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerAsyncResultSetComplexJsonObject() {
    def checker = new AsyncResultChecker()
    JsonObject jo = new JsonObject().put("socks", "tartan")
    JsonArray ja = new JsonArray(["yellow","blue"])
    JsonObject jo2 = new JsonObject().put("outer",jo).put("list",ja)
    obj.methodWithHandlerAsyncResultSetComplexJsonObject({
      checker.assertAsyncResult([jo2] as Set, it)
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerListJsonArray() {
    def count = 0
    obj.methodWithHandlerListJsonArray({
      assertEquals([new JsonArray(["green","blue"]),new JsonArray(["yellow","purple"])], it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerListComplexJsonArray() {
    def count = 0
    obj.methodWithHandlerListComplexJsonArray({
      assertEquals([new JsonArray().add(new JsonObject().put("foo", "hello")), new JsonArray().add(new JsonObject().put("bar", "bye"))], it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerListDataObject() {
    def count = 0
    obj.methodWithHandlerListDataObject({
      assertTrue(it[0] instanceof TestDataObject)
      assertEquals("String 1", it[0].foo)
      assertEquals(1, it[0].bar)
      assertEquals(1.1, it[0].wibble, 0)
      assertTrue(it[1] instanceof TestDataObject)
      assertEquals("String 2", it[1].foo)
      assertEquals(2, it[1].bar)
      assertEquals(2.2, it[1].wibble, 0)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerSetDataObject() {
    def count = 0
    obj.methodWithHandlerSetDataObject({
      assertEquals(2, it.size())
      assertTrue(it.contains(new TestDataObject().setFoo("String 1").setBar(1).setWibble(1.1d)))
      assertTrue(it.contains(new TestDataObject().setFoo("String 2").setBar(2).setWibble(2.2d)))
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultListJsonArray() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultListJsonArray({
      checker.assertAsyncResult([new JsonArray(["green","blue"]),new JsonArray(["yellow","purple"])], it)
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerAsyncResultListComplexJsonArray() {
    def checker = new AsyncResultChecker()
    JsonArray ja = new JsonArray().add(new JsonObject().put("foo","hello"))
    JsonArray ja2 = new JsonArray().add(new JsonObject().put("bar","bye"))
    obj.methodWithHandlerAsyncResultListComplexJsonArray({
      checker.assertAsyncResult([ja, ja2], it)
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerSetJsonArray() {
    def count = 0
    JsonArray ja = new JsonArray(["green","blue"])
    JsonArray ja2 = new JsonArray(["yellow","purple"])
    obj.methodWithHandlerSetJsonArray({
      assertEquals([ja,ja2] as Set, it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerSetComplexJsonArray() {
    def count = 0
    JsonArray ja = new JsonArray().add(new JsonObject().put("foo","hello"))
    JsonArray ja2 = new JsonArray().add(new JsonObject().put("bar","bye"))
    obj.methodWithHandlerSetComplexJsonArray({
      assertEquals([ja,ja2] as Set, it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultSetJsonArray() {
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultSetJsonArray({
      checker.assertAsyncResult([new JsonArray(["green","blue"]),new JsonArray(["yellow","purple"])] as Set, it)
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerAsyncResultSetComplexJsonArray() {
    JsonArray ja = new JsonArray().add(new JsonObject().put("foo","hello"))
    JsonArray ja2 = new JsonArray().add(new JsonObject().put("bar","bye"))
    def checker = new AsyncResultChecker()
    obj.methodWithHandlerAsyncResultSetComplexJsonArray({
      checker.assertAsyncResult([ja,ja2] as Set, it)
    })
    assertEquals(1, checker.count)
  }

  @Test
  void testMethodWithHandlerAsyncResultListDataObject() {
    def count = 0
    obj.methodWithHandlerAsyncResultListDataObject({
      List<TestDataObject> result = it.result()
      assertTrue(result[0] instanceof TestDataObject)
      assertEquals("String 1", result[0].foo)
      assertEquals(1, result[0].bar)
      assertEquals(1.1, result[0].wibble, 0)
      assertTrue(result[1] instanceof TestDataObject)
      assertEquals("String 2", result[1].foo)
      assertEquals(2, result[1].bar)
      assertEquals(2.2, result[1].wibble, 0)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultSetDataObject() {
    def count = 0
    obj.methodWithHandlerAsyncResultSetDataObject({
      assertEquals(2, it.result().size())
      assertTrue(it.result().contains([foo:"String 1",bar: 1,wibble: 1.1d] as TestDataObject))
      assertTrue(it.result().contains([foo:"String 2",bar: 2,wibble: 2.2d] as TestDataObject))
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodListParams() {
    RefedInterface1 refed1 = new RefedInterface1Impl()
    refed1.setString("foo")
    RefedInterface1 refed2 = new RefedInterface1Impl()
    refed2.setString("bar")
    JsonObject jo = new JsonObject().put("foo", "bar")
    JsonObject jo2 = new JsonObject().put("eek", "wibble")
    def tdo = new TestDataObject([foo:"String 1",bar: 1,wibble: 1.1 as Double])
    def tdo2 = new TestDataObject([foo:"String 2",bar: 2,wibble: 2.2 as Double])
    obj.methodWithListParams((List<String>)["foo", "bar"], (List<Byte>)[(byte)2, (byte)3], (List<Short>)[(short)12, (short)13],
        (List<Integer>)[1234, 1345], (List<Long>)[123l, 456l], (List<JsonObject>)[jo, jo2],
        (List<List<Object>>)[["foo"] as JsonArray, ["blah"] as JsonArray], (List<RefedInterface1>)[refed1, refed2],
        (List<TestDataObject>)[[foo:"String 1",bar:1,wibble:1.1] as TestDataObject, [foo:"String 2",bar: 2,wibble: 2.2] as TestDataObject], (List<TestEnum>)[TestEnum.JULIEN, TestEnum.TIM],
        (List<Object>)["foo",4,3.4,true,[wibble: "eek"] as JsonObject,["one", 2] as JsonArray]
    )
  }

  @Test
  void testMethodSetParams() {
    RefedInterface1 refed1 = new RefedInterface1Impl()
    refed1.setString("foo")
    RefedInterface1 refed2 = new RefedInterface1Impl()
    refed2.setString("bar")
    obj.methodWithSetParams((Set<String>)["foo", "bar"], (Set<Byte>)[(byte)2, (byte)3], (Set<Short>)[(short)12, (short)13],
        (Set<Integer>)[1234, 1345], (Set<Long>)[123l, 456l], (Set<Map<String, Object>>)[[foo:"bar"] as JsonObject, [eek: "wibble"] as JsonObject],
        (Set<List<Object>>)[["foo"] as JsonArray, ["blah"] as JsonArray], (Set<RefedInterface1>)[refed1, refed2],
        (Set<TestDataObject>)[[foo:"String 1",bar:1,wibble:1.1] as TestDataObject, [foo:"String 2",bar: 2,wibble: 2.2] as TestDataObject], (Set<TestEnum>)[TestEnum.TIM,TestEnum.JULIEN],
        (Set<Object>)["foo",4,3.4,true,[wibble: "eek"] as JsonObject,["one", 2] as JsonArray]
    )
  }

  @Test
  void testMethodMapParams() {
    RefedInterface1 refed1 = new RefedInterface1Impl()
    refed1.setString("foo")
    RefedInterface1 refed2 = new RefedInterface1Impl()
    refed2.setString("bar")
    obj.methodWithMapParams(
        (Map<String, String>)[foo: "bar", eek: "wibble"],
        (Map<String, Byte>)[foo: (byte)2, eek: (byte)3],
        (Map<String, Short>)[foo: (short)12, eek: (short)13],
        (Map<String, Integer>)[foo: 1234, eek: 1345],
        (Map<String, Long>)[foo: 123l, eek: 456l],
        (Map<String, Map<String, Object>>)[foo: [foo:"bar"] as JsonObject, eek: [eek: "wibble"] as JsonObject],
        (Map<String, List<Object>>)[foo: ["foo"] as JsonArray, eek: ["blah"] as JsonArray],
        (Map<String, RefedInterface1>)[foo: refed1, eek: refed2],
        (Map<String, Object>)[string:"foo", integer:4, float:3.4, boolean: true, object: [wibble: "eek"] as JsonObject, array: ["one", 2] as JsonArray]
    )
  }

  @Test
  void testMethodWithHandlerListEnum() {
    def count = 0
    obj.methodWithHandlerListEnum({
      assertEquals([TestEnum.TIM, TestEnum.JULIEN], it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerSetEnum() {
    def count = 0
    obj.methodWithHandlerSetEnum({
      assertEquals([TestEnum.TIM, TestEnum.JULIEN] as Set, it)
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultListEnum() {
    def count = 0
    obj.methodWithHandlerAsyncResultListEnum({
      assertEquals([TestEnum.TIM, TestEnum.JULIEN], it.result())
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithHandlerAsyncResultSetEnum() {
    def count = 0
    obj.methodWithHandlerAsyncResultSetEnum({
      assertEquals([TestEnum.TIM, TestEnum.JULIEN] as Set, it.result())
      count++
    })
    assertEquals(1, count)
  }

  @Test
  void testMethodWithListEnumReturn() {
    assertEquals([TestEnum.JULIEN,TestEnum.TIM], obj.methodWithListEnumReturn())
  }

  @Test
  void testMethodWithSetEnumReturn() {
    assertEquals([TestEnum.JULIEN,TestEnum.TIM] as Set, obj.methodWithSetEnumReturn())
  }
}
