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
 * An executor for executing blocking code in Vert.x .<p>
 *
 * It provides the same <code>executeBlocking</code> operation than {@link io.vertx.groovy.core.Context} and
 * {@link io.vertx.groovy.core.Vertx} but on a separate worker pool.<p>
*/
@CompileStatic
public class WorkerExecutor {
  private final def io.vertx.core.WorkerExecutor delegate;
  public WorkerExecutor(Object delegate) {
    this.delegate = (io.vertx.core.WorkerExecutor) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Safely execute some blocking code.
   * <p>
   * Executes the blocking code in the handler <code>blockingCodeHandler</code> using a thread from the worker pool.
   * <p>
   * When the code is complete the handler <code>resultHandler</code> will be called with the result on the original context
   * (e.g. on the original event loop of the caller).
   * <p>
   * A <code>Future</code> instance is passed into <code>blockingCodeHandler</code>. When the blocking code successfully completes,
   * the handler should call the {@link io.vertx.groovy.core.Future#complete} or {@link io.vertx.groovy.core.Future#complete} method, or the {@link io.vertx.groovy.core.Future#fail}
   * method if it failed.
   * <p>
   * In the <code>blockingCodeHandler</code> the current context remains the original context and therefore any task
   * scheduled in the <code>blockingCodeHandler</code> will be executed on the this context and not on the worker thread.
   * @param blockingCodeHandler handler representing the blocking code to run
   * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
   * @param resultHandler handler that will be called when the blocking code is complete
   */
  public <T> void executeBlocking(Handler<Future<T>> blockingCodeHandler, boolean ordered, Handler<AsyncResult<T>> resultHandler) {
    delegate.executeBlocking(blockingCodeHandler != null ? new Handler<io.vertx.core.Future<java.lang.Object>>(){
      public void handle(io.vertx.core.Future<java.lang.Object> event) {
        blockingCodeHandler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.Future.class));
      }
    } : null, ordered, resultHandler != null ? new Handler<AsyncResult<java.lang.Object>>() {
      public void handle(AsyncResult<java.lang.Object> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Object) InternalHelper.wrapObject(ar.result())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  /**
   * Like {@link io.vertx.groovy.core.WorkerExecutor#executeBlocking} called with ordered = true.
   * @param blockingCodeHandler 
   * @param resultHandler 
   */
  public <T> void executeBlocking(Handler<Future<T>> blockingCodeHandler, Handler<AsyncResult<T>> resultHandler) {
    delegate.executeBlocking(blockingCodeHandler != null ? new Handler<io.vertx.core.Future<java.lang.Object>>(){
      public void handle(io.vertx.core.Future<java.lang.Object> event) {
        blockingCodeHandler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.Future.class));
      }
    } : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Object>>() {
      public void handle(AsyncResult<java.lang.Object> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Object) InternalHelper.wrapObject(ar.result())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  /**
   * Close the executor.
   */
  public void close() {
    delegate.close();
  }
}
