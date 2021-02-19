package io.vertx.lang.groovy;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.codehaus.groovy.runtime.typehandling.GroovyCastException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Extension module for integrating Vert.x common types with Groovy.
 */
public class VertxExtensionModule {

  /**
   * Convert a JSON like map data structure to a Vert.x data object or a {@link JsonObject}.
   *
   * <p> The data object is a class annotated by {@link DataObject} that provides a public constructor
   * with a {@link JsonObject} argument.
   *
   * @param map the JSON like map like data structure
   * @param clazz the target type which can be a Java class annotated with {@link DataObject} and provides a {@link JsonObject}
   *              constructor, or {@link JsonObject}
   * @return an instance of the specified {@code clazz}
   */
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

  /**
   * Subscript operator for {@link JsonObject}, the read part.
   *
   * @param json the json object
   * @param key the key
   * @return the json value for {@code key}
   */
  public static Object getAt(JsonObject json, String key) {
    return json.getValue(key);
  }

  /**
   * Subscript operator for {@link JsonObject}, the write part.
   *
   * @param json the json object
   * @param key the key
   * @param value the json value
   * @return the previous json value for {@code key}
   */
  public static Object putAt(JsonObject json, String key, Object value) {
    Object prev = json.getValue(key);
    json.put(key, value);
    return prev;
  }

  /**
   * Subscript operator for {@link JsonArray}, the read part.
   *
   * @param json the json array
   * @param idx the idx
   * @return the json value for {@code idx}
   */
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

  /**
   * {@code <<} operator for {@link JsonObject}.
   *
   * @param json the json object
   * @param value the json value
   */
  public static void leftShift(JsonArray json, Object value) {
    json.add(value);
  }
  
 /**
   * Coerces an {@link AsyncResult} as a boolean value according to Groovy-Truth.
   *
   * @param self the {@link AsyncResult} instance
   * @return true if succeeded
   */
  public static boolean asBoolean( final AsyncResult self ) {
    return self.succeeded();
  }
}
