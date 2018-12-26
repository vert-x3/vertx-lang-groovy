package io.vertx.lang.groovy

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import io.vertx.core.json.Json
import io.vertx.core.json.JsonObject
import org.junit.Test

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class JsonTest {

  @Test
  void testFoo() {

    Json.prettyMapper.registerModule(new SimpleModule().addSerializer(GString.class, new StdSerializer<GString>(GString.class) {
      @Override
      void serialize(GString value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString())
      }
    }))

    def x = 12
    def y = 5
    def m = [val: "$x:$y"]
    JsonObject obj = new JsonObject(m)
    String s = obj.encodePrettily()
    println "s = $s"

  }


}
