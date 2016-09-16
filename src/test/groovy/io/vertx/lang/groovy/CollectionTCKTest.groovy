package io.vertx.lang.groovy;

import io.vertx.codegen.testmodel.CollectionTCKImpl;
import io.vertx.codegen.testmodel.RefedInterface1Impl
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.TestEnum;
import io.vertx.groovy.codegen.testmodel.CollectionTCK;
import io.vertx.groovy.codegen.testmodel.RefedInterface1
import io.vertx.groovy.codegen.testmodel.RefedInterface2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class CollectionTCKTest {

  final CollectionTCK obj = new CollectionTCK(new CollectionTCKImpl());

  @Test
  public void testListStringReturn() {
    assertEquals(["foo", "bar", "wibble"], obj.methodWithListStringReturn())
  }

  @Test
  public void testListLongReturn() {
    assertEquals([123l, 456l], obj.methodWithListLongReturn())
  }

  @Test
  public void testListJsonObjectReturn() {
    List<Map<String, Object>> list = obj.methodWithListJsonObjectReturn();
    assertEquals(2, list.size());
    Map<String, Object> json1 = list.get(0);
    assertEquals("bar", json1.get("foo"));
    Map<String, Object> json2 = list.get(1);
    assertEquals("eek", json2.get("blah"));
  }

  @Test
  public void testListComplexJsonObjectReturn() {
    List<Map<String, Object>> list = obj.methodWithListComplexJsonObjectReturn();
    assertEquals(1, list.size());
    Map<String, Object> json1 = list.get(0);
    assertEquals([outer: [socks: "tartan"], list: ["yellow", "blue"]], json1);
  }

  @Test
  public void testListJsonArrayReturn() {
    List<List<Object>> list = obj.methodWithListJsonArrayReturn();
    assertEquals(2, list.size());
    List<Object> json1 = list.get(0);
    assertEquals("foo", json1.get(0));
    List<Object> json2 = list.get(1);
    assertEquals("blah", json2.get(0));
  }

  @Test
  public void testListComplexJsonArrayReturn() {
    List<List<Object>> list = obj.methodWithListComplexJsonArrayReturn();
    assertEquals(2, list.size());
    List<Object> json1 = list.get(0);
    assertEquals([[foo: "hello"]], json1);
    List<Object> json2 = list.get(1);
    assertEquals([[bar: "bye"]], json2);
  }

  @Test
  public void testListVertxGenReturn() {
    List<io.vertx.groovy.codegen.testmodel.RefedInterface1> list = obj.methodWithListVertxGenReturn();
    assertEquals(2, list.size());
    RefedInterface1 refed1 = list.get(0);
    assertTrue(refed1 instanceof io.vertx.groovy.codegen.testmodel.RefedInterface1);
    RefedInterface1 refed2 = list.get(1);
    assertEquals("foo", refed1.getString());
    assertEquals("bar", refed2.getString());
  }

  @Test
  public void testListDataObjectReturn() {
    List<Map<String, Object>> list = obj.methodWithListDataObjectReturn();
    assertTrue(list[0] instanceof Map);
    assertEquals("String 1", list[0].foo);
    assertEquals(1, list[0].bar);
    assertEquals(1.1, list[0].wibble, 0);
    assertTrue(list[1] instanceof Map);
    assertEquals("String 2", list[1].foo);
    assertEquals(2, list[1].bar);
    assertEquals(2.2, list[1].wibble, 0);
  }

  @Test
  public void testSetStringReturn() {
    assertEquals(["foo", "bar", "wibble"] as Set, obj.methodWithSetStringReturn())
  }

  @Test
  public void testSetLongReturn() {
    assertEquals([123l, 456l] as Set, obj.methodWithSetLongReturn())
  }

  @Test
  public void testSetJsonObjectReturn() {
    Set<Map<String, Object>> set = obj.methodWithSetJsonObjectReturn();
    assertEquals(2, set.size());
    Map<String, Object> json1 = new HashMap<>();
    json1.put("foo", "bar");
    assertTrue(set.contains(json1));
    Map<String, Object> json2 = new HashMap<>();
    json2.put("blah", "eek");
    assertTrue(set.contains(json2));
  }

  @Test
  public void testSetComplexJsonObjectReturn() {
    Set<Map<String, Object>> set = obj.methodWithSetComplexJsonObjectReturn();
    assertEquals(1, set.size());
    assertTrue(set.contains([outer: [socks: "tartan"], list: ["yellow", "blue"]]));
  }

  @Test
  public void testSetJsonArrayReturn() {
    Set<List<Object>> set = obj.methodWithSetJsonArrayReturn();
    assertEquals(2, set.size());
    List<Object> json1 = new ArrayList<>();
    json1.add("foo");
    assertTrue(set.contains(json1));
    List<Object> json2 = new ArrayList<>();
    json2.add("blah");
    assertTrue(set.contains(json2));
  }

  @Test
  public void testSetComplexJsonArrayReturn() {
    Set<List<Object>> set = obj.methodWithSetComplexJsonArrayReturn();
    assertEquals(2, set.size());
    assertTrue(set.contains([[foo: "hello"]]));
    assertTrue(set.contains([[bar: "bye"]]));
  }

  @Test
  public void testSetVertxGenReturn() {
    Set<io.vertx.groovy.codegen.testmodel.RefedInterface1> set = obj.methodWithSetVertxGenReturn();
    assertEquals(2, set.size());
    RefedInterface1 refed1 = new RefedInterface1(new RefedInterface1Impl());
    refed1.setString("foo");
    RefedInterface1 refed2 = new RefedInterface1(new RefedInterface1Impl());
    refed2.setString("bar");
    List<RefedInterface1> list = new ArrayList<>(set);
    assertTrue((list.get(0).getString().equals("foo") && list.get(1).getString().equals("bar")) || (list.get(0).getString().equals("bar") && list.get(1).getString().equals("foo")))
  }

  @Test
  public void testSetDataObjectReturn() {
    Set<Map<String, Object>> set = obj.methodWithSetDataObjectReturn();
    assertEquals(2, set.size());
    assertTrue(set.contains([foo:"String 1",bar: 1,wibble: 1.1d]));
    assertTrue(set.contains([foo:"String 2",bar: 2,wibble: 2.2d]));
  }

  @Test
  public void testMapStringReturn() {
    Map<String, String> map = obj.methodWithMapStringReturn({});
    assertEquals("bar", map.get("foo"));
  }

  @Test
  public void testMapLongReturn() {
    Map<String, Long> map = obj.methodWithMapLongReturn({});
    assertEquals(123l, map.get("foo"));
  }

  @Test
  public void testMapJsonObjectReturn() {
    Map<String, Map<String, Object>> map = obj.methodWithMapJsonObjectReturn({});
    Map<String, Object> m = map.get("foo");
    assertEquals("eek", m.get("wibble"));
  }

  @Test
  public void testMapComplexJsonObjectReturn() {
    Map<String, Map<String, Object>> map = obj.methodWithMapComplexJsonObjectReturn({});
    Map<String, Object> m = map.get("foo");
    assertEquals([outer: [socks: "tartan"], list: ["yellow", "blue"]], m);
  }

  @Test
  public void testMapJsonArrayReturn() {
    Map<String, List<Object>> map = obj.methodWithMapJsonArrayReturn({});
    List<Object> m = map.get("foo");
    assertEquals("wibble", m.get(0));
  }

  @Test
  public void testMapComplexJsonArrayReturn() {
    Map<String, List<Object>> map = obj.methodWithMapComplexJsonArrayReturn({});
    List<Object> m = map.get("foo");
    assertEquals([[foo: "hello"], [bar: "bye"]], m);
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
  public void testMethodWithHandlerListAbstractVertxGen() {
    def count = 0;
    obj.methodWithHandlerListAbstractVertxGen({
      assertEquals(["abstractfoo","abstractbar"], it.collect({it.string}))
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
  public void testMethodWithHandlerAsyncResultListAbstractVertxGen() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultListAbstractVertxGen({ result ->
      checker.assertAsyncResult(["abstractfoo","abstractbar"], result, { list -> list.collect({ RefedInterface2 r -> r.string }) })
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
  public void testMethodWithHandlerSetAbstractVertxGen() {
    def count = 0;
    obj.methodWithHandlerSetAbstractVertxGen({
      assertEquals(["abstractbar","abstractfoo"], it.collect({it.string}).sort())
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
  public void testMethodWithHandlerAsyncResultSetAbstractVertxGen() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultSetAbstractVertxGen({ result ->
      checker.assertAsyncResult(["abstractfoo","abstractbar"] as Set, result, { set -> set.collect({ RefedInterface2 r -> r.string }) as Set })
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
  public void testMethodWithHandlerListComplexJsonObject() {
    def count = 0;

    obj.methodWithHandlerListComplexJsonObject({
      assertEquals([[outer: [socks: "tartan"], list: ["yellow", "blue"]]], it);
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
  public void testMethodWithHandlerAsyncResultListComplexJsonObject() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultListComplexJsonObject({
      checker.assertAsyncResult([[outer: [socks: "tartan"], list: ["yellow", "blue"]]], it)
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
  public void testMethodWithHandlerSetComplexJsonObject() {
    def count = 0;
    obj.methodWithHandlerSetComplexJsonObject({
      assertEquals([[outer: [socks: "tartan"], list: ["yellow", "blue"]]] as Set, it);
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
  public void testMethodWithHandlerAsyncResultSetComplexJsonObject() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultSetComplexJsonObject({
      checker.assertAsyncResult([[outer: [socks: "tartan"], list: ["yellow", "blue"]]] as Set, it)
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
  public void testMethodWithHandlerListComplexJsonArray() {
    def count = 0;
    obj.methodWithHandlerListComplexJsonArray({
      assertEquals([[[foo: "hello"]], [[bar: "bye"]]], it);
      count++;
    });
    assertEquals(1, count)
  }

  @Test
  public void testMethodWithHandlerListDataObject() {
    def count = 0
    obj.methodWithHandlerListDataObject({
      assertTrue(it[0] instanceof Map);
      assertEquals("String 1", it[0].foo);
      assertEquals(1, it[0].bar);
      assertEquals(1.1, it[0].wibble, 0);
      assertTrue(it[1] instanceof Map);
      assertEquals("String 2", it[1].foo);
      assertEquals(2, it[1].bar);
      assertEquals(2.2, it[1].wibble, 0);
      count++;
    });
    assertEquals(1, count);
  }

  @Test
  public void testMethodWithHandlerSetDataObject() {
    def count = 0
    obj.methodWithHandlerSetDataObject({
      assertEquals(2, it.size());
      assertTrue(it.contains([foo:"String 1",bar: 1,wibble: 1.1d]));
      assertTrue(it.contains([foo:"String 2",bar: 2,wibble: 2.2d]));
      count++;
    });
    assertEquals(1, count);
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
  public void testMethodWithHandlerAsyncResultListComplexJsonArray() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultListComplexJsonArray({
      checker.assertAsyncResult([[[foo: "hello"]], [[bar: "bye"]]], it)
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
  public void testMethodWithHandlerSetComplexJsonArray() {
    def count = 0;
    obj.methodWithHandlerSetComplexJsonArray({
      assertEquals([[[foo: "hello"]], [[bar: "bye"]]] as Set, it);
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
  public void testMethodWithHandlerAsyncResultSetComplexJsonArray() {
    def checker = new AsyncResultChecker();
    obj.methodWithHandlerAsyncResultSetComplexJsonArray({
      checker.assertAsyncResult([[[foo: "hello"]], [[bar: "bye"]]] as Set, it)
    });
    assertEquals(1, checker.count);
  }

  @Test
  public void testMethodWithHandlerAsyncResultListDataObject() {
    def count = 0
    obj.methodWithHandlerAsyncResultListDataObject({
      List<TestDataObject> result = it.result();
      assertTrue(result[0] instanceof Map);
      assertEquals("String 1", result[0].foo);
      assertEquals(1, result[0].bar);
      assertEquals(1.1, result[0].wibble, 0);
      assertTrue(result[1] instanceof Map);
      assertEquals("String 2", result[1].foo);
      assertEquals(2, result[1].bar);
      assertEquals(2.2, result[1].wibble, 0);
      count++;
    });
    assertEquals(1, count);
  }

  @Test
  public void testMethodWithHandlerAsyncResultSetDataObject() {
    def count = 0
    obj.methodWithHandlerAsyncResultSetDataObject({
      assertEquals(2, it.result().size());
      assertTrue(it.result().contains([foo:"String 1",bar: 1,wibble: 1.1d]));
      assertTrue(it.result().contains([foo:"String 2",bar: 2,wibble: 2.2d]));
      count++;
    });
    assertEquals(1, count);
  }

  @Test
  public void testMethodListParams() {
    RefedInterface1 refed1 = new RefedInterface1(new RefedInterface1Impl())
    refed1.setString("foo")
    RefedInterface1 refed2 = new RefedInterface1(new RefedInterface1Impl())
    refed2.setString("bar")
    obj.methodWithListParams((List<String>)["foo", "bar"], (List<Byte>)[(byte)2, (byte)3], (List<Short>)[(short)12, (short)13],
        (List<Integer>)[1234, 1345], (List<Long>)[123l, 456l], (List<Map<String, Object>>)[[foo:"bar"], [eek: "wibble"]],
        (List<List<Object>>)[["foo"], ["blah"]], (List<RefedInterface1>)[refed1, refed2],
        (List<TestDataObject>)[[foo:"String 1",bar:1,wibble:1.1], [foo:"String 2",bar: 2,wibble: 2.2]], (List<TestEnum>)[TestEnum.JULIEN, TestEnum.TIM])
  }

  @Test
  public void testMethodSetParams() {
    RefedInterface1 refed1 = new RefedInterface1(new RefedInterface1Impl())
    refed1.setString("foo")
    RefedInterface1 refed2 = new RefedInterface1(new RefedInterface1Impl())
    refed2.setString("bar")
    obj.methodWithSetParams((Set<String>)["foo", "bar"], (Set<Byte>)[(byte)2, (byte)3], (Set<Short>)[(short)12, (short)13],
        (Set<Integer>)[1234, 1345], (Set<Long>)[123l, 456l], (Set<Map<String, Object>>)[[foo:"bar"], [eek: "wibble"]],
        (Set<List<Object>>)[["foo"], ["blah"]], (Set<RefedInterface1>)[refed1, refed2],
        (Set<TestDataObject>)[[foo:"String 1",bar:1,wibble:1.1], [foo:"String 2",bar: 2,wibble: 2.2]], (Set<TestEnum>)[TestEnum.TIM,TestEnum.JULIEN])
  }

  @Test
  public void testMethodMapParams() {
    RefedInterface1 refed1 = new RefedInterface1(new RefedInterface1Impl())
    refed1.setString("foo")
    RefedInterface1 refed2 = new RefedInterface1(new RefedInterface1Impl())
    refed2.setString("bar")
    obj.methodWithMapParams(
        (Map<String, String>)[foo: "bar", eek: "wibble"],
        (Map<String, Byte>)[foo: (byte)2, eek: (byte)3],
        (Map<String, Short>)[foo: (short)12, eek: (short)13],
        (Map<String, Integer>)[foo: 1234, eek: 1345],
        (Map<String, Long>)[foo: 123l, eek: 456l],
        (Map<String, Map<String, Object>>)[foo: [foo:"bar"], eek: [eek: "wibble"]],
        (Map<String, List<Object>>)[foo: ["foo"], eek: ["blah"]],
        (Map<String, RefedInterface1>)[foo: refed1, eek: refed2]
    )
  }

  @Test
  public void testMethodWithHandlerListEnum() {
    def count = 0
    obj.methodWithHandlerListEnum({
      assertEquals([TestEnum.TIM, TestEnum.JULIEN], it);
      count++;
    });
    assertEquals(1, count);
  }

  @Test
  public void testMethodWithHandlerSetEnum() {
    def count = 0
    obj.methodWithHandlerSetEnum({
      assertEquals([TestEnum.TIM, TestEnum.JULIEN] as Set, it);
      count++;
    });
    assertEquals(1, count);
  }

  @Test
  public void testMethodWithHandlerAsyncResultListEnum() {
    def count = 0
    obj.methodWithHandlerAsyncResultListEnum({
      assertEquals([TestEnum.TIM, TestEnum.JULIEN], it.result());
      count++;
    });
    assertEquals(1, count);
  }

  @Test
  public void testMethodWithHandlerAsyncResultSetEnum() {
    def count = 0
    obj.methodWithHandlerAsyncResultSetEnum({
      assertEquals([TestEnum.TIM, TestEnum.JULIEN] as Set, it.result());
      count++;
    });
    assertEquals(1, count);
  }

  @Test
  public void testMethodWithListEnumReturn() {
    assertEquals([TestEnum.JULIEN,TestEnum.TIM], obj.methodWithListEnumReturn());
  }

  @Test
  public void testMethodWithSetEnumReturn() {
    assertEquals([TestEnum.JULIEN,TestEnum.TIM] as Set, obj.methodWithSetEnumReturn());
  }
}
