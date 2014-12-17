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

package io.vertx.groovy.core.shareddata;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 *
 * An asynchronous map.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>

 */
@CompileStatic
public class AsyncMap<K,V> {
  final def io.vertx.core.shareddata.AsyncMap delegate;
  public AsyncMap(io.vertx.core.shareddata.AsyncMap delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Get a value from the map, asynchronously.
   * @param k The key
   * @param resultHandler - this will be called some time later with the async result.
   */
  public void get(K k, Handler<AsyncResult<V>> resultHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).get(InternalHelper.unwrapObject(k), new Handler<AsyncResult<Object>>() {
      public void handle(AsyncResult<Object> event) {
        AsyncResult<Object> f
        if (event.succeeded()) {
          f = InternalHelper.<Object>result(InternalHelper.wrapObject(event.result()))
        } else {
          f = InternalHelper.<Object>failure(event.cause())
        }
        resultHandler.handle(f)
      }
    });
  }
  /**
   * Put a value in the map, asynchronously.
   * @param k The key
   * @param v The value
   * @param completionHandler - this will be called some time later to signify the value has been put
   */
  public void put(K k, V v, Handler<AsyncResult<Void>> completionHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).put(InternalHelper.unwrapObject(k), InternalHelper.unwrapObject(v), completionHandler);
  }
  public void put(K k, V v, long timeout, Handler<AsyncResult<Void>> completionHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).put(InternalHelper.unwrapObject(k), InternalHelper.unwrapObject(v), timeout, completionHandler);
  }
  public void putIfAbsent(K k, V v, Handler<AsyncResult<V>> completionHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).putIfAbsent(InternalHelper.unwrapObject(k), InternalHelper.unwrapObject(v), new Handler<AsyncResult<Object>>() {
      public void handle(AsyncResult<Object> event) {
        AsyncResult<Object> f
        if (event.succeeded()) {
          f = InternalHelper.<Object>result(InternalHelper.wrapObject(event.result()))
        } else {
          f = InternalHelper.<Object>failure(event.cause())
        }
        completionHandler.handle(f)
      }
    });
  }
  public void putIfAbsent(K k, V v, long timeout, Handler<AsyncResult<V>> completionHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).putIfAbsent(InternalHelper.unwrapObject(k), InternalHelper.unwrapObject(v), timeout, new Handler<AsyncResult<Object>>() {
      public void handle(AsyncResult<Object> event) {
        AsyncResult<Object> f
        if (event.succeeded()) {
          f = InternalHelper.<Object>result(InternalHelper.wrapObject(event.result()))
        } else {
          f = InternalHelper.<Object>failure(event.cause())
        }
        completionHandler.handle(f)
      }
    });
  }
  /**
   * Remove a value from the map, asynchronously.
   * @param k The key
   * @param resultHandler - this will be called some time later to signify the value has been removed
   */
  public void remove(K k, Handler<AsyncResult<V>> resultHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).remove(InternalHelper.unwrapObject(k), new Handler<AsyncResult<Object>>() {
      public void handle(AsyncResult<Object> event) {
        AsyncResult<Object> f
        if (event.succeeded()) {
          f = InternalHelper.<Object>result(InternalHelper.wrapObject(event.result()))
        } else {
          f = InternalHelper.<Object>failure(event.cause())
        }
        resultHandler.handle(f)
      }
    });
  }
  public void removeIfPresent(K k, V v, Handler<AsyncResult<Boolean>> resultHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).removeIfPresent(InternalHelper.unwrapObject(k), InternalHelper.unwrapObject(v), resultHandler);
  }
  public void replace(K k, V v, Handler<AsyncResult<V>> resultHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).replace(InternalHelper.unwrapObject(k), InternalHelper.unwrapObject(v), new Handler<AsyncResult<Object>>() {
      public void handle(AsyncResult<Object> event) {
        AsyncResult<Object> f
        if (event.succeeded()) {
          f = InternalHelper.<Object>result(InternalHelper.wrapObject(event.result()))
        } else {
          f = InternalHelper.<Object>failure(event.cause())
        }
        resultHandler.handle(f)
      }
    });
  }
  public void replaceIfPresent(K k, V oldValue, V newValue, Handler<AsyncResult<Boolean>> resultHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).replaceIfPresent(InternalHelper.unwrapObject(k), InternalHelper.unwrapObject(oldValue), InternalHelper.unwrapObject(newValue), resultHandler);
  }
  public void clear(Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).clear(resultHandler);
  }
  public void size(Handler<AsyncResult<Integer>> resultHandler) {
    ((io.vertx.core.shareddata.AsyncMap) this.delegate).size(resultHandler);
  }

  static final java.util.function.Function<io.vertx.core.shareddata.AsyncMap, AsyncMap> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.shareddata.AsyncMap arg -> new AsyncMap(arg);
  };
}
