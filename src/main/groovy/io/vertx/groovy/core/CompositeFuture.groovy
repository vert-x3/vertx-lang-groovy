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
import java.util.function.Function
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
   * Set the result. Any handler will be called, if there is one, and the future will be marked as completed.
   * @param result the result
   */
  public void complete(CompositeFuture result) {
    ((io.vertx.core.Future) delegate).complete(result != null ? (io.vertx.core.CompositeFuture)result.getDelegate() : null);
  }
  /**
   * The result of the operation. This will be null if the operation failed.
   * @return the result or null if the operation failed.
   */
  public CompositeFuture result() {
    def ret = InternalHelper.safeCreate(((io.vertx.core.Future) delegate).result(), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Compose this future with a provided <code>next</code> future.<p>
   *
   * When this (the one on which <code>compose</code> is called) future succeeds, the <code>handler</code> will be called with
   * the completed value, this handler should complete the next future.<p>
   *
   * If the <code>handler</code> throws an exception, the returned future will be failed with this exception.<p>
   *
   * When this future fails, the failure will be propagated to the <code>next</code> future and the <code>handler</code>
   * will not be called.
   * @param handler the handler
   * @param next the next future
   * @return the next future, used for chaining
   */
  public <U> Future<U> compose(Handler<CompositeFuture> handler, Future<U> next) {
    def ret = InternalHelper.safeCreate(((io.vertx.core.Future) delegate).compose(handler != null ? new Handler<io.vertx.core.CompositeFuture>(){
      public void handle(io.vertx.core.CompositeFuture event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.CompositeFuture.class));
      }
    } : null, next != null ? (io.vertx.core.Future<U>)next.getDelegate() : null), io.vertx.groovy.core.Future.class);
    return ret;
  }
  /**
   * Compose this future with a <code>mapper</code> function.<p>
   *
   * When this future (the one on which <code>compose</code> is called) succeeds, the <code>mapper</code> will be called with
   * the completed value and this mapper returns another future object. This returned future completion will complete
   * the future returned by this method call.<p>
   *
   * If the <code>mapper</code> throws an exception, the returned future will be failed with this exception.<p>
   *
   * When this future fails, the failure will be propagated to the returned future and the <code>mapper</code>
   * will not be called.
   * @param mapper the mapper function
   * @return the composed future
   */
  public <U> Future<U> compose(java.util.function.Function<CompositeFuture, Future<U>> mapper) {
    def ret = InternalHelper.safeCreate(((io.vertx.core.Future) delegate).compose(mapper != null ? new java.util.function.Function<io.vertx.core.CompositeFuture, io.vertx.core.Future<java.lang.Object>>(){
      public io.vertx.core.Future<java.lang.Object> apply(io.vertx.core.CompositeFuture arg_) {
        def ret = mapper.apply(InternalHelper.safeCreate(arg_, io.vertx.groovy.core.CompositeFuture.class));
        return ret != null ? (io.vertx.core.Future<java.lang.Object>)ret.getDelegate() : null;
      }
    } : null), io.vertx.groovy.core.Future.class);
    return ret;
  }
  /**
   * Apply a <code>mapper</code> function on this future.<p>
   *
   * When this future succeeds, the <code>mapper</code> will be called with the completed value and this mapper
   * returns a value. This value will complete the future returned by this method call.<p>
   *
   * If the <code>mapper</code> throws an exception, the returned future will be failed with this exception.<p>
   *
   * When this future fails, the failure will be propagated to the returned future and the <code>mapper</code>
   * will not be called.
   * @param mapper the mapper function
   * @return the mapped future
   */
  public <U> Future<U> map(java.util.function.Function<CompositeFuture, U> mapper) {
    def ret = InternalHelper.safeCreate(((io.vertx.core.Future) delegate).map(mapper != null ? new java.util.function.Function<io.vertx.core.CompositeFuture, java.lang.Object>(){
      public java.lang.Object apply(io.vertx.core.CompositeFuture arg_) {
        def ret = mapper.apply(InternalHelper.safeCreate(arg_, io.vertx.groovy.core.CompositeFuture.class));
        return ret != null ? InternalHelper.unwrapObject(ret) : null;
      }
    } : null), io.vertx.groovy.core.Future.class);
    return ret;
  }
  /**
   * @return an handler completing this future
   */
  public Handler<AsyncResult<CompositeFuture>> completer() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret = new Handler<AsyncResult<CompositeFuture>>() {
      public void handle(AsyncResult<CompositeFuture> ar_) {
        if (ar_.succeeded()) {
          ((io.vertx.core.Future) delegate).completer().handle(io.vertx.core.Future.succeededFuture((io.vertx.core.CompositeFuture)ar_.result().getDelegate()));
        } else  {
          ((io.vertx.core.Future) delegate).completer().handle(io.vertx.core.Future.failedFuture(ar_.cause()));
        }
      }
    };
    cached_0 = ret;
    return ret;
  }
  /**
   * Return a composite future, succeeded when all futures are succeeded, failed when any future is failed.
   * <p/>
   * The returned future fails as soon as one of <code>f1</code> or <code>f2</code> fails.
   * @param f1 future
   * @param f2 future
   * @return the composite future
   */
  public static <T1, T2> CompositeFuture all(Future<T1> f1, Future<T2> f2) {
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
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
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
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
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
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
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null, f5 != null ? (io.vertx.core.Future<T5>)f5.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
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
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null, f5 != null ? (io.vertx.core.Future<T5>)f5.getDelegate() : null, f6 != null ? (io.vertx.core.Future<T6>)f6.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#all} but with a list of futures.<p>
   *
   * When the list is empty, the returned future will be already completed.
   * @param futures 
   * @return 
   */
  public static CompositeFuture all(List<Future> futures) {
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.all(futures != null ? (List)futures.collect({(io.vertx.core.Future)it.getDelegate()}) : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Return a composite future, succeeded when any futures is succeeded, failed when all futures are failed.
   * <p/>
   * The returned future succeeds as soon as one of <code>f1</code> or <code>f2</code> succeeds.
   * @param f1 future
   * @param f2 future
   * @return the composite future
   */
  public static <T1, T2> CompositeFuture any(Future<T1> f1, Future<T2> f2) {
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
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
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
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
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
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
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null, f5 != null ? (io.vertx.core.Future<T5>)f5.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
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
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null, f5 != null ? (io.vertx.core.Future<T5>)f5.getDelegate() : null, f6 != null ? (io.vertx.core.Future<T6>)f6.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#any} but with a list of futures.<p>
   *
   * When the list is empty, the returned future will be already completed.
   * @param futures 
   * @return 
   */
  public static CompositeFuture any(List<Future> futures) {
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.any(futures != null ? (List)futures.collect({(io.vertx.core.Future)it.getDelegate()}) : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Return a composite future completed when all the futures are completed.
   * <p/>
   * Succeeded when all futures are succeeded, failed when any future is failed.
   * @param f1 future
   * @param f2 future
   * @return the composite future
   */
  public static <T1, T2> CompositeFuture join(Future<T1> f1, Future<T2> f2) {
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.join(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#join} but with 3 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @return 
   */
  public static <T1, T2, T3> CompositeFuture join(Future<T1> f1, Future<T2> f2, Future<T3> f3) {
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.join(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#join} but with 4 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @param f4 
   * @return 
   */
  public static <T1, T2, T3, T4> CompositeFuture join(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4) {
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.join(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#join} but with 5 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @param f4 
   * @param f5 
   * @return 
   */
  public static <T1, T2, T3, T4, T5> CompositeFuture join(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5) {
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.join(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null, f5 != null ? (io.vertx.core.Future<T5>)f5.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#join} but with 6 futures.
   * @param f1 
   * @param f2 
   * @param f3 
   * @param f4 
   * @param f5 
   * @param f6 
   * @return 
   */
  public static <T1, T2, T3, T4, T5, T6> CompositeFuture join(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5, Future<T6> f6) {
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.join(f1 != null ? (io.vertx.core.Future<T1>)f1.getDelegate() : null, f2 != null ? (io.vertx.core.Future<T2>)f2.getDelegate() : null, f3 != null ? (io.vertx.core.Future<T3>)f3.getDelegate() : null, f4 != null ? (io.vertx.core.Future<T4>)f4.getDelegate() : null, f5 != null ? (io.vertx.core.Future<T5>)f5.getDelegate() : null, f6 != null ? (io.vertx.core.Future<T6>)f6.getDelegate() : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.CompositeFuture#join} but with a list of futures.<p>
   *
   * When the list is empty, the returned future will be already completed.
   * @param futures 
   * @return 
   */
  public static CompositeFuture join(List<Future> futures) {
    def ret = InternalHelper.safeCreate(io.vertx.core.CompositeFuture.join(futures != null ? (List)futures.collect({(io.vertx.core.Future)it.getDelegate()}) : null), io.vertx.groovy.core.CompositeFuture.class);
    return ret;
  }
  public CompositeFuture setHandler(Handler<AsyncResult<CompositeFuture>> handler) {
    ((io.vertx.core.CompositeFuture) delegate).setHandler(handler != null ? new Handler<AsyncResult<io.vertx.core.CompositeFuture>>() {
      public void handle(AsyncResult<io.vertx.core.CompositeFuture> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.CompositeFuture.class)));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns a cause of a wrapped future
   * @param index the wrapped future index
   * @return 
   */
  public Throwable cause(int index) {
    def ret = delegate.cause(index);
    return ret;
  }
  /**
   * Returns true if a wrapped future is succeeded
   * @param index the wrapped future index
   * @return 
   */
  public boolean succeeded(int index) {
    def ret = delegate.succeeded(index);
    return ret;
  }
  /**
   * Returns true if a wrapped future is failed
   * @param index the wrapped future index
   * @return 
   */
  public boolean failed(int index) {
    def ret = delegate.failed(index);
    return ret;
  }
  /**
   * Returns true if a wrapped future is completed
   * @param index the wrapped future index
   * @return 
   */
  public boolean isComplete(int index) {
    def ret = delegate.isComplete(index);
    return ret;
  }
  /**
   * Returns the result of a wrapped future
   * @param index the wrapped future index
   * @return 
   */
  public <T> T resultAt(int index) {
    def ret = (T) InternalHelper.wrapObject(delegate.resultAt(index));
    return ret;
  }
  /**
   * @return the number of wrapped future
   */
  public int size() {
    def ret = delegate.size();
    return ret;
  }
  private Handler<AsyncResult<CompositeFuture>> cached_0;
}
