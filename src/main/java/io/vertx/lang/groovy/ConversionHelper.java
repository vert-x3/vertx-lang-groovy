package io.vertx.lang.groovy;

import groovy.lang.GString;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ConversionHelper {

  public static Object unwrap(Object obj) {
    if (obj instanceof Map) {
      return toJsonObject((Map<String, Object>) obj);
    } else if (obj instanceof List) {
      return toJsonArray((List<Object>) obj);
    } else if (obj instanceof GString) {
      return obj.toString();
    }
    return obj;
  }

  private static Object toJsonElement(Object obj) {
    if (obj instanceof Map) {
      return toJsonObject((Map<String, Object>) obj);
    } else if (obj instanceof List) {
      return toJsonArray((List<Object>) obj);
    } else if (obj instanceof GString) {
      return obj.toString();
    } else if (obj instanceof Buffer) {
      return Base64.getEncoder().encodeToString(((Buffer)obj).getBytes());
    }
    return obj;
  }

  public static JsonObject toJsonObject(Map<String, Object> obj) {
    return obj == null ? null : new JsonObject(obj.entrySet().stream().collect(Collectors.toMap(
      Map.Entry::getKey, entry -> toJsonElement(entry.getValue())
    )));
  }

  public static JsonArray toJsonArray(List<Object> obj) {
    return obj == null ? null : new JsonArray(obj.stream().map(ConversionHelper::toJsonElement).collect(Collectors.toList()));
  }

  public static <T, R> R applyIfNotNull(T expr, Function<T, R> function) {
    if (expr != null) {
      return function.apply(expr);
    } else {
      return null;
    }
  }

  public static <T, R> R wrap(T t, Function<T, Object> f) {
    if (t != null) {
      return wrap(f.apply(t));
    } else {
      return null;
    }
  }

  public static <T> T wrap(Object obj) {
    if (obj instanceof JsonObject) {
      return (T)fromJsonObject((JsonObject)obj);
    } else if (obj instanceof JsonArray) {
      return (T)fromJsonArray((JsonArray)obj);
    }
    return (T)obj;
  }

  public static Map<String, Object> fromJsonObject(JsonObject obj) {
    return obj == null ? null : obj.getMap().entrySet().stream().collect(Collectors.toMap(
      Map.Entry::getKey, entry -> wrap(entry.getValue())
    ));
  }

  public static List<Object> fromJsonArray(JsonArray obj) {
    return obj == null ? null : obj.stream().map(ConversionHelper::wrap).collect(Collectors.toList());
  }
}
