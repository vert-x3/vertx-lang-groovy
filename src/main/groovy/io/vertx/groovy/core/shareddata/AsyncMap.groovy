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
 *
 * An asynchronous map.
*/
@CompileStatic
public class AsyncMap<K,V> {
  private final def io.vertx.core.shareddata.AsyncMap delegate;
  public AsyncMap(Object delegate) {
    this.delegate = (io.vertx.core.shareddata.AsyncMap) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Get a value from the map, asynchronously.
   * @param k the key
   * @param resultHandler - this will be called some time later with the async result.
   */
  public void get(K k, Handler<AsyncResult<V>> resultHandler) {
    this.delegate.get(k != null ? InternalHelper.unwrapObject(k) : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Object>>(){
    public void handle(AsyncResult<java.lang.Object> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Put a value in the map, asynchronously.
   * @param k the key
   * @param v the value
   * @param completionHandler - this will be called some time later to signify the value has been put
   */
  public void put(K k, V v, Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.put(k != null ? InternalHelper.unwrapObject(k) : null, v != null ? InternalHelper.unwrapObject(v) : null, completionHandler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      completionHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Like {@link io.vertx.groovy.core.shareddata.AsyncMap#put} but specifying a timeout. If the value cannot be put within the timeout a
   * failure will be passed to the handler
   * @param k the key
   * @param v the value
   * @param ttl The time to live (in ms) for the entry
   * @param completionHandler the handler
   */
  public void put(K k, V v, long ttl, Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.put(k != null ? InternalHelper.unwrapObject(k) : null, v != null ? InternalHelper.unwrapObject(v) : null, ttl != null ? ttl : null, completionHandler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      completionHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Put the entry only if there is no entry with the key already present. If key already present then the existing
   * value will be returned to the handler, otherwise null.
   * @param k the key
   * @param v the value
   * @param completionHandler the handler
   */
  public void putIfAbsent(K k, V v, Handler<AsyncResult<V>> completionHandler) {
    this.delegate.putIfAbsent(k != null ? InternalHelper.unwrapObject(k) : null, v != null ? InternalHelper.unwrapObject(v) : null, completionHandler != null ? new Handler<AsyncResult<java.lang.Object>>(){
    public void handle(AsyncResult<java.lang.Object> ar) {
      completionHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Link {@link io.vertx.groovy.core.shareddata.AsyncMap#putIfAbsent} but specifying a timeout. If the value cannot be put within the timeout a
   * failure will be passed to the handler
   * @param k the key
   * @param v the value
   * @param ttl The time to live (in ms) for the entry
   * @param completionHandler the handler
   */
  public void putIfAbsent(K k, V v, long ttl, Handler<AsyncResult<V>> completionHandler) {
    this.delegate.putIfAbsent(k != null ? InternalHelper.unwrapObject(k) : null, v != null ? InternalHelper.unwrapObject(v) : null, ttl != null ? ttl : null, completionHandler != null ? new Handler<AsyncResult<java.lang.Object>>(){
    public void handle(AsyncResult<java.lang.Object> ar) {
      completionHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Remove a value from the map, asynchronously.
   * @param k the key
   * @param resultHandler - this will be called some time later to signify the value has been removed
   */
  public void remove(K k, Handler<AsyncResult<V>> resultHandler) {
    this.delegate.remove(k != null ? InternalHelper.unwrapObject(k) : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Object>>(){
    public void handle(AsyncResult<java.lang.Object> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Remove a value from the map, only if entry already exists with same value.
   * @param k the key
   * @param v the value
   * @param resultHandler - this will be called some time later to signify the value has been removed
   */
  public void removeIfPresent(K k, V v, Handler<AsyncResult<Boolean>> resultHandler) {
    this.delegate.removeIfPresent(k != null ? InternalHelper.unwrapObject(k) : null, v != null ? InternalHelper.unwrapObject(v) : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Boolean>>(){
    public void handle(AsyncResult<java.lang.Boolean> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Replace the entry only if it is currently mapped to some value
   * @param k the key
   * @param v the new value
   * @param resultHandler the result handler will be passed the previous value
   */
  public void replace(K k, V v, Handler<AsyncResult<V>> resultHandler) {
    this.delegate.replace(k != null ? InternalHelper.unwrapObject(k) : null, v != null ? InternalHelper.unwrapObject(v) : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Object>>(){
    public void handle(AsyncResult<java.lang.Object> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Replace the entry only if it is currently mapped to a specific value
   * @param k the key
   * @param oldValue the existing value
   * @param newValue the new value
   * @param resultHandler the result handler
   */
  public void replaceIfPresent(K k, V oldValue, V newValue, Handler<AsyncResult<Boolean>> resultHandler) {
    this.delegate.replaceIfPresent(k != null ? InternalHelper.unwrapObject(k) : null, oldValue != null ? InternalHelper.unwrapObject(oldValue) : null, newValue != null ? InternalHelper.unwrapObject(newValue) : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Boolean>>(){
    public void handle(AsyncResult<java.lang.Boolean> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Clear all entries in the map
   * @param resultHandler called on completion
   */
  public void clear(Handler<AsyncResult<Void>> resultHandler) {
    this.delegate.clear(resultHandler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Provide the number of entries in the map
   * @param resultHandler handler which will receive the number of entries
   */
  public void size(Handler<AsyncResult<Integer>> resultHandler) {
    this.delegate.size(resultHandler != null ? new Handler<AsyncResult<java.lang.Integer>>(){
    public void handle(AsyncResult<java.lang.Integer> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
  }
}
