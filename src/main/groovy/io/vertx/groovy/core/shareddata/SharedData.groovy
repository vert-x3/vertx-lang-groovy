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
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Shared data allows you to share data safely between different parts of your application in a safe way.
 * <p>
 * Shared data provides:
 * <ul>
 *   <li>Cluster wide maps which can be accessed from any node of the cluster</li>
 *   <li>Cluster wide locks which can be used to give exclusive access to resources across the cluster</li>
 *   <li>Cluster wide counters used to maintain counts consistently across the cluster</li>
 *   <li>Local maps for sharing data safely in the same Vert.x instance</li>
 * </ul>
 * <p>
 * Please see the documentation for more information.
*/
@CompileStatic
public class SharedData {
  private final def io.vertx.core.shareddata.SharedData delegate;
  public SharedData(Object delegate) {
    this.delegate = (io.vertx.core.shareddata.SharedData) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Get the cluster wide map with the specified name. The map is accessible to all nodes in the cluster and data
   * put into the map from any node is visible to to any other node.
   * @param name the name of the map
   * @param resultHandler the map will be returned asynchronously in this handler
   */
  public <K, V> void getClusterWideMap(String name, Handler<AsyncResult<AsyncMap<K,V>>> resultHandler) {
    delegate.getClusterWideMap(name, resultHandler != null ? new Handler<AsyncResult<io.vertx.core.shareddata.AsyncMap<java.lang.Object,java.lang.Object>>>() {
      public void handle(AsyncResult<io.vertx.core.shareddata.AsyncMap<java.lang.Object,java.lang.Object>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.shareddata.AsyncMap.class)));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  /**
   * Get a cluster wide lock with the specified name. The lock will be passed to the handler when it is available.
   * @param name the name of the lock
   * @param resultHandler the handler
   */
  public void getLock(String name, Handler<AsyncResult<Lock>> resultHandler) {
    delegate.getLock(name, resultHandler != null ? new Handler<AsyncResult<io.vertx.core.shareddata.Lock>>() {
      public void handle(AsyncResult<io.vertx.core.shareddata.Lock> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.shareddata.Lock.class)));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  /**
   * Like {@link io.vertx.groovy.core.shareddata.SharedData#getLock} but specifying a timeout. If the lock is not obtained within the timeout
   * a failure will be sent to the handler
   * @param name the name of the lock
   * @param timeout the timeout in ms
   * @param resultHandler the handler
   */
  public void getLockWithTimeout(String name, long timeout, Handler<AsyncResult<Lock>> resultHandler) {
    delegate.getLockWithTimeout(name, timeout, resultHandler != null ? new Handler<AsyncResult<io.vertx.core.shareddata.Lock>>() {
      public void handle(AsyncResult<io.vertx.core.shareddata.Lock> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.shareddata.Lock.class)));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  /**
   * Get a cluster wide counter. The counter will be passed to the handler.
   * @param name the name of the counter.
   * @param resultHandler the handler
   */
  public void getCounter(String name, Handler<AsyncResult<Counter>> resultHandler) {
    delegate.getCounter(name, resultHandler != null ? new Handler<AsyncResult<io.vertx.core.shareddata.Counter>>() {
      public void handle(AsyncResult<io.vertx.core.shareddata.Counter> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.shareddata.Counter.class)));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  /**
   * Return a <code>LocalMap</code> with the specific <code>name</code>.
   * @param name the name of the map
   * @return the msp
   */
  public <K, V> LocalMap<K,V> getLocalMap(String name) {
    def ret = InternalHelper.safeCreate(delegate.getLocalMap(name), io.vertx.groovy.core.shareddata.LocalMap.class);
    return ret;
  }
}
