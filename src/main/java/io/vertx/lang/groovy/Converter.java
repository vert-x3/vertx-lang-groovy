package io.vertx.lang.groovy;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class Converter {

  public static Object unwrapObject(Object obj) {
    if (obj instanceof Map) {
      return new JsonObject((Map) obj);
    } else if (obj instanceof List) {
      return new JsonArray((List<Object>) obj);
    }
    return obj;
  }

  public static Object wrapObject(Object obj) {
    if (obj instanceof JsonObject) {
      return ((JsonObject) obj).toMap();
    } else if (obj instanceof JsonArray) {
      return ((JsonArray) obj).toList();
    }
    return obj;
  }
}
