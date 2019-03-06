package io.vertx.lang.groovy

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import io.vertx.core.json.Json
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class JsonTest {

  @Test
  public void testFoo() {

    Json.prettyMapper.registerModule(new SimpleModule().addSerializer(GString.class, new StdSerializer<GString>(GString.class) {
      @Override
      void serialize(GString value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString());
      }
    }));

    def x = 12
    def y = 5
    def m = [val: "$x:$y"]
    JsonObject obj = new JsonObject(m);
    String s = obj.encodePrettily();
    println "s = $s"

  }

  @Test
  void testMapAsJsonObject() {
    def map = ["foo":"bar"]
    def json = map as JsonObject
    assertEquals(json.class, JsonObject.class)
    assertEquals("bar", json.getString("foo"))
  }

  @Test
  void testJsonObjectGet() {
    def json = new JsonObject().put("foo", "bar")
    assertEquals("bar", json["foo"])
    assertNull(json["absent"])
  }

  @Test
  void testJsonObjectPut() {
    def json = new JsonObject()
    json["foo"] = "bar";
    assertEquals("bar", json.getString("foo"))
    json["foo"] = null;
    assertEquals(null, json.getString("foo"))
    assertTrue(json.containsKey("foo"))
  }

  @Test
  void testJsonArrayGet() {
    def json = new JsonArray().add(1).add("two")
    assertEquals(1, json[0])
    assertEquals("two", json[1])
    assertEquals(null, json[2])
    assertEquals("two", json[-1])
    assertEquals(1, json[-2])
    try {
      assertEquals(1, json[-3])
      fail();
    } catch (ArrayIndexOutOfBoundsException ignore) {
    }
  }

  @Test
  void testJsonArrayLeftShift() {
    def json = new JsonArray()
    json << 1
    json << "two"
    assertEquals(1, json[0])
    assertEquals("two", json[1])
  }
}
