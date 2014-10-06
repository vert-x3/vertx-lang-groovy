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
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class SharedData {
  final def io.vertx.core.shareddata.SharedData delegate;
  public SharedData(io.vertx.core.shareddata.SharedData delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public <K, V> void getClusterWideMap(String name, Handler<AsyncResult<AsyncMap<K,V>>> resultHandler) {
    this.delegate.getClusterWideMap(name, new Handler<AsyncResult<io.vertx.core.shareddata.AsyncMap<java.lang.Object,java.lang.Object>>>() {
      public void handle(AsyncResult<io.vertx.core.shareddata.AsyncMap<java.lang.Object,java.lang.Object>> event) {
        AsyncResult<AsyncMap<Object,Object>> f
        if (event.succeeded()) {
          f = InternalHelper.<AsyncMap<Object,Object>>result(new AsyncMap<Object,Object>(event.result()))
        } else {
          f = InternalHelper.<AsyncMap<Object,Object>>failure(event.cause())
        }
        resultHandler.handle(f)
      }
    });
  }
  public void getLock(String name, Handler<AsyncResult<Lock>> resultHandler) {
    this.delegate.getLock(name, new Handler<AsyncResult<io.vertx.core.shareddata.Lock>>() {
      public void handle(AsyncResult<io.vertx.core.shareddata.Lock> event) {
        AsyncResult<Lock> f
        if (event.succeeded()) {
          f = InternalHelper.<Lock>result(new Lock(event.result()))
        } else {
          f = InternalHelper.<Lock>failure(event.cause())
        }
        resultHandler.handle(f)
      }
    });
  }
  public void getLockWithTimeout(String name, long timeout, Handler<AsyncResult<Lock>> resultHandler) {
    this.delegate.getLockWithTimeout(name, timeout, new Handler<AsyncResult<io.vertx.core.shareddata.Lock>>() {
      public void handle(AsyncResult<io.vertx.core.shareddata.Lock> event) {
        AsyncResult<Lock> f
        if (event.succeeded()) {
          f = InternalHelper.<Lock>result(new Lock(event.result()))
        } else {
          f = InternalHelper.<Lock>failure(event.cause())
        }
        resultHandler.handle(f)
      }
    });
  }
  public void getCounter(String name, Handler<AsyncResult<Counter>> resultHandler) {
    this.delegate.getCounter(name, new Handler<AsyncResult<io.vertx.core.shareddata.Counter>>() {
      public void handle(AsyncResult<io.vertx.core.shareddata.Counter> event) {
        AsyncResult<Counter> f
        if (event.succeeded()) {
          f = InternalHelper.<Counter>result(new Counter(event.result()))
        } else {
          f = InternalHelper.<Counter>failure(event.cause())
        }
        resultHandler.handle(f)
      }
    });
  }
  /**
   * Return a {@code Map} with the specific {@code name}. All invocations of this method with the same value of {@code name}
   * are guaranteed to return the same {@code Map} instance. <p>
   */
  public <K, V> LocalMap<K,V> getLocalMap(String name) {
    def ret= LocalMap.FACTORY.apply(this.delegate.getLocalMap(name));
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.shareddata.SharedData, SharedData> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.shareddata.SharedData arg -> new SharedData(arg);
  };
}
