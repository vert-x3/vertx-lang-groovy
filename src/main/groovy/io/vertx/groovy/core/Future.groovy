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
 * Represents the result of an action that may, or may not, have occurred yet.
 * <p>
*/
@CompileStatic
public class Future<T> {
  private final def io.vertx.core.Future delegate;
  public Future(Object delegate) {
    this.delegate = (io.vertx.core.Future) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Create a future that hasn't completed yet
   * @return the future
   */
  public static <T> Future<T> future() {
    def ret= InternalHelper.safeCreate(io.vertx.core.Future.future(), io.vertx.groovy.core.Future.class);
    return ret;
  }
  /**
   * Create a succeeded future with a null result
   * @return the future
   */
  public static <T> Future<T> succeededFuture() {
    def ret= InternalHelper.safeCreate(io.vertx.core.Future.succeededFuture(), io.vertx.groovy.core.Future.class);
    return ret;
  }
  /**
   * Created a succeeded future with the specified result.
   * @param result the result
   * @return the future
   */
  public static <T> Future<T> succeededFuture(T result) {
    def ret= InternalHelper.safeCreate(io.vertx.core.Future.succeededFuture(InternalHelper.unwrapObject(result)), io.vertx.groovy.core.Future.class);
    return ret;
  }
  /**
   * Create a failed future with the specified failure message.
   * @param failureMessage the failure message
   * @return the future
   */
  public static <T> Future<T> failedFuture(String failureMessage) {
    def ret= InternalHelper.safeCreate(io.vertx.core.Future.failedFuture(failureMessage), io.vertx.groovy.core.Future.class);
    return ret;
  }
  /**
   * Has the future completed?
   * <p>
   * It's completed if it's either succeeded or failed.
   * @return true if completed, false if not
   */
  public boolean isComplete() {
    def ret = this.delegate.isComplete();
    return ret;
  }
  /**
   * Set a handler for the result.
   * <p>
   * If the future has already been completed it will be called immediately. Otherwise it will be called when the
   * future is completed.
   * @param handler the Handler that will be called with the result
   */
  public void setHandler(Handler<AsyncResult<T>> handler) {
    this.delegate.setHandler(new Handler<AsyncResult<Object>>() {
      public void handle(AsyncResult<Object> event) {
        AsyncResult<Object> f
        if (event.succeeded()) {
          f = InternalHelper.<Object>result(InternalHelper.wrapObject(event.result()))
        } else {
          f = InternalHelper.<Object>failure(event.cause())
        }
        handler.handle(f)
      }
    });
  }
  /**
   * Set the result. Any handler will be called, if there is one, and the future will be marked as completed.
   * @param result the result
   */
  public void complete(T result) {
    this.delegate.complete(InternalHelper.unwrapObject(result));
  }
  /**
   * Set a null result. Any handler will be called, if there is one, and the future will be marked as completed.
   */
  public void complete() {
    this.delegate.complete();
  }
  /**
   * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.
   * @param failureMessage the failure message
   */
  public void fail(String failureMessage) {
    this.delegate.fail(failureMessage);
  }
}
