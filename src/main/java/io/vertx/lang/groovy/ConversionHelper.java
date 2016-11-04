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

  @SuppressWarnings("unchecked")
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

  @SuppressWarnings("unchecked")
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

  @SuppressWarnings("unchecked")
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
