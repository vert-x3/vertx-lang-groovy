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
  /**
   * Return a composite future, succeeded when all futures are succeeded, failed when any future is failed.
   * @param f1 future
   * @param f2 future
   * @return the composite future
   */
  public static <T1, T2> CompositeFuture all(Future<T1> f1, Future<T2> f2) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public static <T1, T2, T3> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate(), (io.vertx.core.Future<T3>)f3.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public static <T1, T2, T3, T4> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate(), (io.vertx.core.Future<T3>)f3.getDelegate(), (io.vertx.core.Future<T4>)f4.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public static <T1, T2, T3, T4, T5> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate(), (io.vertx.core.Future<T3>)f3.getDelegate(), (io.vertx.core.Future<T4>)f4.getDelegate(), (io.vertx.core.Future<T5>)f5.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public static <T1, T2, T3, T4, T5, T6> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5, Future<T6> f6) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate(), (io.vertx.core.Future<T3>)f3.getDelegate(), (io.vertx.core.Future<T4>)f4.getDelegate(), (io.vertx.core.Future<T5>)f5.getDelegate(), (io.vertx.core.Future<T6>)f6.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Return a composite future, succeeded when any futures is succeeded, failed when all futures are failed.
   * @param f1 future
   * @param f2 future
   * @return the composite future
   */
  public static <T1, T2> CompositeFuture any(Future<T1> f1, Future<T2> f2) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public static <T1, T2, T3> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate(), (io.vertx.core.Future<T3>)f3.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public static <T1, T2, T3, T4> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate(), (io.vertx.core.Future<T3>)f3.getDelegate(), (io.vertx.core.Future<T4>)f4.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public static <T1, T2, T3, T4, T5> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate(), (io.vertx.core.Future<T3>)f3.getDelegate(), (io.vertx.core.Future<T4>)f4.getDelegate(), (io.vertx.core.Future<T5>)f5.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public static <T1, T2, T3, T4, T5, T6> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5, Future<T6> f6) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any((io.vertx.core.Future<T1>)f1.getDelegate(), (io.vertx.core.Future<T2>)f2.getDelegate(), (io.vertx.core.Future<T3>)f3.getDelegate(), (io.vertx.core.Future<T4>)f4.getDelegate(), (io.vertx.core.Future<T5>)f5.getDelegate(), (io.vertx.core.Future<T6>)f6.getDelegate()), io.vertx.groovy.core.CompositeFuture.class);
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
