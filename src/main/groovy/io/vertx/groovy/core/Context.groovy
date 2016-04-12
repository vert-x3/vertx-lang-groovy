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
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * The execution context of a {@link io.vertx.groovy.core.Handler} execution.
 * <p>
 * When Vert.x provides an event to a handler or calls the start or stop methods of a {@link io.vertx.groovy.core.Verticle},
 * the execution is associated with a <code>Context</code>.
 * <p>
 * Usually a context is an *event-loop context* and is tied to a specific event loop thread. So executions for that
 * context always occur on that exact same event loop thread.
 * <p>
 * In the case of worker verticles and running inline blocking code a worker context will be associated with the execution
 * which will use a thread from the worker thread pool.
 * <p>
 * When a handler is set by a thread associated with a specific context, the Vert.x will guarantee that when that handler
 * is executed, that execution will be associated with the same context.
 * <p>
 * If a handler is set by a thread not associated with a context (i.e. a non Vert.x thread). Then a new context will
 * be created for that handler.
 * <p>
 * In other words, a context is propagated.
 * <p>
 * This means that when a verticle is deployed, any handlers it sets will be associated with the same context - the context
 * of the verticle.
 * <p>
 * This means (in the case of a standard verticle) that the verticle code will always be executed with the exact same
 * thread, so you don't have to worry about multi-threaded acccess to the verticle state and you can code your application
 * as single threaded.
 * <p>
 * This class also allows arbitrary data to be {@link io.vertx.groovy.core.Context#put} and {@link io.vertx.groovy.core.Context#get} on the context so it can be shared easily
 * amongst different handlers of, for example, a verticle instance.
 * <p>
 * This class also provides {@link io.vertx.groovy.core.Context#runOnContext} which allows an action to be executed asynchronously using the same context.
*/
@CompileStatic
public class Context {
  private final def io.vertx.core.Context delegate;
  public Context(Object delegate) {
    this.delegate = (io.vertx.core.Context) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Is the current thread a worker thread?
   * <p>
   * NOTE! This is not always the same as calling {@link io.vertx.groovy.core.Context#isWorkerContext}. If you are running blocking code
   * from an event loop context, then this will return true but {@link io.vertx.groovy.core.Context#isWorkerContext} will return false.
   * @return true if current thread is a worker thread, false otherwise
   */
  public static boolean isOnWorkerThread() {
    def ret = io.vertx.core.Context.isOnWorkerThread();
    return ret;
  }
  /**
   * Is the current thread an event thread?
   * <p>
   * NOTE! This is not always the same as calling {@link io.vertx.groovy.core.Context#isEventLoopContext}. If you are running blocking code
   * from an event loop context, then this will return false but {@link io.vertx.groovy.core.Context#isEventLoopContext} will return true.
   * @return true if current thread is a worker thread, false otherwise
   */
  public static boolean isOnEventLoopThread() {
    def ret = io.vertx.core.Context.isOnEventLoopThread();
    return ret;
  }
  /**
   * Is the current thread a Vert.x thread? That's either a worker thread or an event loop thread
   * @return true if current thread is a Vert.x thread, false otherwise
   */
  public static boolean isOnVertxThread() {
    def ret = io.vertx.core.Context.isOnVertxThread();
    return ret;
  }
  /**
   * Run the specified action asynchronously on the same context, some time after the current execution has completed.
   * @param action the action to run
   */
  public void runOnContext(Handler<Void> action) {
    this.delegate.runOnContext(action);
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
   * @param blockingCodeHandler handler representing the blocking code to run
   * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
   * @param resultHandler handler that will be called when the blocking code is complete
   */
  public <T> void executeBlocking(Handler<Future<T>> blockingCodeHandler, boolean ordered, Handler<AsyncResult<T>> resultHandler) {
    this.delegate.executeBlocking(new Handler<io.vertx.core.Future<java.lang.Object>>() {
      public void handle(io.vertx.core.Future<java.lang.Object> event) {
        blockingCodeHandler.handle(new io.vertx.groovy.core.Future(event));
      }
    }, ordered, new Handler<AsyncResult<Object>>() {
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
   * Invoke {@link io.vertx.groovy.core.Context#executeBlocking} with order = true.
   * @param blockingCodeHandler handler representing the blocking code to run
   * @param resultHandler handler that will be called when the blocking code is complete
   */
  public <T> void executeBlocking(Handler<Future<T>> blockingCodeHandler, Handler<AsyncResult<T>> resultHandler) {
    this.delegate.executeBlocking(new Handler<io.vertx.core.Future<java.lang.Object>>() {
      public void handle(io.vertx.core.Future<java.lang.Object> event) {
        blockingCodeHandler.handle(new io.vertx.groovy.core.Future(event));
      }
    }, new Handler<AsyncResult<Object>>() {
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
   * If the context is associated with a Verticle deployment, this returns the deployment ID of that deployment.
   * @return the deployment ID of the deployment or null if not a Verticle deployment
   */
  public String deploymentID() {
    def ret = this.delegate.deploymentID();
    return ret;
  }
  /**
   * If the context is associated with a Verticle deployment, this returns the configuration that was specified when
   * the verticle was deployed.
   * @return the configuration of the deployment or null if not a Verticle deployment
   */
  public Map<String, Object> config() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(this.delegate.config());
    return ret;
  }
  /**
   * The process args
   * @return 
   */
  public List<String> processArgs() {
    def ret = this.delegate.processArgs();
    return ret;
  }
  /**
   * Is the current context an event loop context?
   * <p>
   * NOTE! when running blocking code using {@link io.vertx.groovy.core.Vertx#executeBlocking} from a
   * standard (not worker) verticle, the context will still an event loop context and this 
   * will return true.
   * @return true if false otherwise
   */
  public boolean isEventLoopContext() {
    def ret = this.delegate.isEventLoopContext();
    return ret;
  }
  /**
   * Is the current context a worker context?
   * <p>
   * NOTE! when running blocking code using {@link io.vertx.groovy.core.Vertx#executeBlocking} from a
   * standard (not worker) verticle, the context will still an event loop context and this 
   * will return false.
   * @return true if the current context is a worker context, false otherwise
   */
  public boolean isWorkerContext() {
    def ret = this.delegate.isWorkerContext();
    return ret;
  }
  /**
   * Is the current context a multi-threaded worker context?
   * @return true if the current context is a multi-threaded worker context, false otherwise
   */
  public boolean isMultiThreadedWorkerContext() {
    def ret = this.delegate.isMultiThreadedWorkerContext();
    return ret;
  }
  /**
   * Get some data from the context.
   * @param key the key of the data
   * @return the data
   */
  public <T> T get(String key) {
    // This cast is cleary flawed
    def ret = (T) InternalHelper.wrapObject(this.delegate.get(key));
    return ret;
  }
  /**
   * Put some data in the context.
   * <p>
   * This can be used to share data between different handlers that share a context
   * @param key the key of the data
   * @param value the data
   */
  public void put(String key, Object value) {
    this.delegate.put(key, InternalHelper.unwrapObject(value));
  }
  /**
   * Remove some data from the context.
   * @param key the key to remove
   * @return true if removed successfully, false otherwise
   */
  public boolean remove(String key) {
    def ret = this.delegate.remove(key);
    return ret;
  }
  /**
   * @return The Vertx instance that created the context
   * @return 
   */
  public Vertx owner() {
    def ret= InternalHelper.safeCreate(this.delegate.owner(), io.vertx.groovy.core.Vertx.class);
    return ret;
  }
  /**
   * @return  the number of instances of the verticle that were deployed in the deployment (if any) related
   * to this context
   * @return 
   */
  public int getInstanceCount() {
    def ret = this.delegate.getInstanceCount();
    return ret;
  }
  /**
   * Set an exception handler called when the context runs an action throwing an uncaught throwable.<p/>
   *
   * When this handler is called, {@link io.vertx.groovy.core.Vertx#currentContext} will return this context.
   * @param handler the exception handler
   * @return a reference to this, so the API can be used fluently
   */
  public Context exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler);
    return this;
  }
}
