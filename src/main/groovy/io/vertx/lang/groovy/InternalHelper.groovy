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

import groovy.transform.CompileStatic;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.groovy.core.buffer.Buffer

import java.lang.reflect.Constructor;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@CompileStatic
public class InternalHelper {

  public static Object unwrapObject(Object obj) {
    if (obj instanceof Map) {
      return new JsonObject((Map) obj);
    } else if (obj instanceof List) {
      return new JsonArray((List<Object>) obj);
    } else if (obj instanceof Buffer) {
      return ((Buffer) obj).getDelegate();
    } else if (obj instanceof GString) {
      return ((GString) obj).toString();
    }
    return obj;
  }

  public static Object wrapObject(Object obj) {
    if (obj instanceof JsonObject) {
      return ((JsonObject) obj).getMap().collectEntries { k, v ->
        [k, wrapObject(v)]
      }
    } else if (obj instanceof JsonArray) {
      return ((JsonArray) obj).toList().collect {
        wrapObject(it)
      }
    } else if (obj instanceof io.vertx.core.buffer.Buffer) {
      return new Buffer((io.vertx.core.buffer.Buffer) obj);
    }
    return obj;
  }

  public static <V> AsyncResult<V> result(V value) {
    return Future.succeededFuture(value);
  }

  public static <V> AsyncResult<V> failure(Throwable t) {
    return Future.failedFuture(t);
  }

  public static <T, D> T safeCreate(D delegate, Class<T> type) {
    if (delegate != null) {
      Constructor<T> ctor = type.getConstructor(Object.class)
      return ctor.newInstance(delegate)
    }
    return null
  }

  public static JsonObject toJsonObject(Map<String, Object> map) {
    adaptMap(map);
    return new JsonObject(map)
  }

  private static void adaptMap(Map<String, Object> map) {
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      Object  val = entry.getValue();
      if (val instanceof Buffer) {
        entry.setValue(Base64.getEncoder().encodeToString(((io.vertx.core.buffer.Buffer)val.getDelegate()).getBytes()));
      } else if (val instanceof Map) {
        adaptMap(val);
      } else if (val instanceof List) {
        adaptList(val);
      }
    }
  }

  private static void adaptList(List list) {
    for (int i = 0;i < list.size();i++) {
      Object val = list[i];
      if (val instanceof Buffer) {
        list[i] = Base64.getEncoder().encodeToString(((io.vertx.core.buffer.Buffer)val.getDelegate()).getBytes());
      } else if (val instanceof Map) {
        adaptMap(val);
      } else if (val instanceof List) {
        adaptList(val);
      }
    }
  }
}
