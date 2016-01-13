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

package io.vertx.groovy.core;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
*/
@CompileStatic
public class CompositeFuture extends Future<CompositeFuture> {
  private final def io.vertx.core.CompositeFuture delegate;
  public CompositeFuture(Object delegate) {
    super((io.vertx.core.CompositeFuture) delegate);
    this.delegate = (io.vertx.core.CompositeFuture) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public static <T1, T2> CompositeFuture and(Future<T1> f1, Future<T2> f2) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.and((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public CompositeFuture setHandler(Handler<AsyncResult<CompositeFuture>> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.CompositeFuture) this.delegate).setHandler(new Handler<AsyncResult<io.vertx.core.CompositeFuture>>() {
      public void handle(AsyncResult<io.vertx.core.CompositeFuture> event) {
        AsyncResult<CompositeFuture> f
        if (event.succeeded()) {
          f = InternalHelper.<CompositeFuture>result(new CompositeFuture(event.result()))
        } else {
          f = InternalHelper.<CompositeFuture>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  public Throwable cause(int index) {
    def ret = this.delegate.cause(index);
    return ret;
  }
  public boolean succeeded(int index) {
    def ret = this.delegate.succeeded(index);
    return ret;
  }
  public boolean failed(int index) {
    def ret = this.delegate.failed(index);
    return ret;
  }
  public boolean isComplete(int index) {
    def ret = this.delegate.isComplete(index);
    return ret;
  }
  public <T> T result(int index) {
    // This cast is cleary flawed
    def ret = (T) InternalHelper.wrapObject(this.delegate.result(index));
    return ret;
  }
  public int size() {
    def ret = this.delegate.size();
    return ret;
  }
}
