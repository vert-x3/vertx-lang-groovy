package io.vertx.lang.groovy;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.codehaus.groovy.runtime.typehandling.GroovyCastException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class VertxExtensionModule {

  public static Object asType(Map map, Class clazz) throws Throwable {
    if (clazz == JsonObject.class) {
      return new JsonObject(map);
    } else if (clazz.getAnnotation(DataObject.class) != null) {
      try {
        Constructor ctor = clazz.getConstructor(JsonObject.class);
        JsonObject json = new JsonObject(map);
        return ctor.newInstance(json);
      } catch (NoSuchMethodException e) {
        throw new GroovyCastException("Cannot cast JsonObject to class '" + clazz + "'");
      } catch (InvocationTargetException e) {
        throw e.getCause();
      } catch (Exception e) {
        throw e;
      }
    }
    return null;
  }

  public static Object getAt(JsonObject json, String key) {
    return json.getValue(key);
  }

  public static Object putAt(JsonObject json, String key, Object value) {
    Object prev = json.getValue(key);
    json.put(key, value);
    return prev;
  }

  public static Object getAt(JsonArray json, int idx) {
    int size = json.size();
    if (idx < 0) {
      idx += size;
      if (idx < 0) {
        throw new ArrayIndexOutOfBoundsException("Invalid array index " + (idx - size));
      }
    }
    if (idx < size) {
      return json.getValue(idx);
    } else {
      return null;
    }
  }

  public static void leftShift(JsonArray json, Object value) {
    json.add(value);
  }
}
