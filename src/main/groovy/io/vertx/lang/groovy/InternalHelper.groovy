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
import io.vertx.groovy.core.buffer.Buffer;

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
    }
    return obj;
  }

  public static Object wrapObject(Object obj) {
    if (obj instanceof JsonObject) {
      return ((JsonObject) obj).getMap();
    } else if (obj instanceof JsonArray) {
      return ((JsonArray) obj).toList();
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
}
