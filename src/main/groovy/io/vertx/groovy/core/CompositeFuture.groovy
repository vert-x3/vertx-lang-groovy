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
import java.util.List
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * The composite future wraps a list of {@link io.vertx.groovy.core.Future futures}, it is useful when several futures
 * needs to be coordinated.
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
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#all} but with 3 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @return 
   */
  public static <T1, T2, T3> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#all} but with 4 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @param f4 
   * @return 
   */
  public static <T1, T2, T3, T4> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#all} but with 5 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @param f4 
   * @param f5 
   * @return 
   */
  public static <T1, T2, T3, T4, T5> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null, f5 != null ? (io.vertx.core.Future<T5>)f5.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#all} but with 6 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @param f4 
   * @param f5 
   * @param f6 
   * @return 
   */
  public static <T1, T2, T3, T4, T5, T6> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5, Future<T6> f6) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null, f5 != null ? (io.vertx.core.Future<T5>)f5.getDelegate() : null, f6 != null ? (io.vertx.core.Future<T6>)f6.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#all} but with a list of futures.
   * @param futures 
   * @return 
   */
  public static CompositeFuture all(List<Future> futures) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(futures != null ? futures.collect({(io.vertx.core.Future)it.getDelegate()}) : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Return a composite future, succeeded when any futures is succeeded, failed when all futures are failed.
   * @param f1 future
   * @param f2 future
   * @return the composite future
   */
  public static <T1, T2> CompositeFuture any(Future<T1> f1, Future<T2> f2) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#any} but with 3 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @return 
   */
  public static <T1, T2, T3> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#any} but with 4 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @param f4 
   * @return 
   */
  public static <T1, T2, T3, T4> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#any} but with 5 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @param f4 
   * @param f5 
   * @return 
   */
  public static <T1, T2, T3, T4, T5> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null, f5 != null ? (io.vertx.core.Future<T5>)f5.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#any} but with 6 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @param f4 
   * @param f5 
   * @param f6 
   * @return 
   */
  public static <T1, T2, T3, T4, T5, T6> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5, Future<T6> f6) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null, f5 != null ? (io.vertx.core.Future<T5>)f5.getDelegate() : null, f6 != null ? (io.vertx.core.Future<T6>)f6.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#any} but with a list of futures.
   * @param futures 
   * @return 
   */
  public static CompositeFuture any(List<Future> futures) {
    def ret= InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(futures != null ? futures.collect({(io.vertx.core.Future)it.getDelegate()}) : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public CompositeFuture setHandler(Handler<AsyncResult<CompositeFuture>> handler) {
    ((io.vertx.core.CompositeFuture) this.delegate).setHandler(handler != null ? new Handler<AsyncResult<io.vertx.core.CompositeFuture>>(){
    public void handle(AsyncResult<io.vertx.core.CompositeFuture> ar) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Returns a cause of a wrapped future
   * @param index the wrapped future index
   * @return 
   */
  public Throwable cause(int index) {
    def ret = this.delegate.cause(index != null ? index : null);
    return ret;
  }
  /**
   * Returns true if a wrapped future is succeeded
   * @param index the wrapped future index
   * @return 
   */
  public boolean succeeded(int index) {
    def ret = this.delegate.succeeded(index != null ? index : null);
    return ret;
  }
  /**
   * Returns true if a wrapped future is failed
   * @param index the wrapped future index
   * @return 
   */
  public boolean failed(int index) {
    def ret = this.delegate.failed(index != null ? index : null);
    return ret;
  }
  /**
   * Returns true if a wrapped future is completed
   * @param index the wrapped future index
   * @return 
   */
  public boolean isComplete(int index) {
    def ret = this.delegate.isComplete(index != null ? index : null);
    return ret;
  }
  /**
   * Returns the result of a wrapped future
   * @param index the wrapped future index
   * @return 
   */
  public <T> T result(int index) {
    // This cast is cleary flawed
    def ret = (T) InternalHelper.wrapObject(this.delegate.result(index != null ? index : null));
    return ret;
  }
  /**
   * @return the number of wrapped future
   * @return 
   */
  public int size() {
    def ret = this.delegate.size();
    return ret;
  }
}
