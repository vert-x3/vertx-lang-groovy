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
/**
 * Local maps can be used to share data safely in a single Vert.x instance.
 * <p>
 * The map only allows immutable keys and values in the map, OR certain mutable objects such as {@link io.vertx.groovy.core.buffer.Buffer}
 * instances which will be copied when they are added to the map.
 * <p>
 * This ensures there is no shared access to mutable state from different threads (e.g. different event loops) in the
 * Vert.x instance, and means you don't have to protect access to that state using synchronization or locks.
*/
@CompileStatic
public class LocalMap<K,V> {
  private final def io.vertx.core.shareddata.LocalMap delegate;
  public LocalMap(Object delegate) {
    this.delegate = (io.vertx.core.shareddata.LocalMap) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Get a value from the map
   * @param key the key
   * @return the value, or null if none
   */
  public V get(K key) {
    def ret = (V) InternalHelper.wrapObject(delegate.get(key != null ? InternalHelper.unwrapObject(key) : null));
    return ret;
  }
  /**
   * Put an entry in the map
   * @param key the key
   * @param value the value
   * @return return the old value, or null if none
   */
  public V put(K key, V value) {
    def ret = (V) InternalHelper.wrapObject(delegate.put(key != null ? InternalHelper.unwrapObject(key) : null, value != null ? InternalHelper.unwrapObject(value) : null));
    return ret;
  }
  /**
   * Remove an entry from the map
   * @param key the key
   * @return the old value
   */
  public V remove(K key) {
    def ret = (V) InternalHelper.wrapObject(delegate.remove(key != null ? InternalHelper.unwrapObject(key) : null));
    return ret;
  }
  /**
   * Clear all entries in the map
   */
  public void clear() {
    delegate.clear();
  }
  /**
   * Get the size of the map
   * @return the number of entries in the map
   */
  public int size() {
    def ret = delegate.size();
    return ret;
  }
  /**
   * @return true if there are zero entries in the map
   */
  public boolean isEmpty() {
    def ret = delegate.isEmpty();
    return ret;
  }
  /**
   * Put the entry only if there is no existing entry for that key
   * @param key the key
   * @param value the value
   * @return the old value or null, if none
   */
  public V putIfAbsent(K key, V value) {
    def ret = (V) InternalHelper.wrapObject(delegate.putIfAbsent(key != null ? InternalHelper.unwrapObject(key) : null, value != null ? InternalHelper.unwrapObject(value) : null));
    return ret;
  }
  /**
   * Remove the entry only if there is an entry with the specified key and value
   * @param key the key
   * @param value the value
   * @return true if removed
   */
  public boolean removeIfPresent(K key, V value) {
    def ret = delegate.removeIfPresent(key != null ? InternalHelper.unwrapObject(key) : null, value != null ? InternalHelper.unwrapObject(value) : null);
    return ret;
  }
  /**
   * Replace the entry only if there is an existing entry with the specified key and value
   * @param key the key
   * @param oldValue the old value
   * @param newValue the new value
   * @return true if removed
   */
  public boolean replaceIfPresent(K key, V oldValue, V newValue) {
    def ret = delegate.replaceIfPresent(key != null ? InternalHelper.unwrapObject(key) : null, oldValue != null ? InternalHelper.unwrapObject(oldValue) : null, newValue != null ? InternalHelper.unwrapObject(newValue) : null);
    return ret;
  }
  /**
   * Replace the entry only if there is an existing entry with the key
   * @param key the key
   * @param value the new value
   * @return the old value
   */
  public V replace(K key, V value) {
    def ret = (V) InternalHelper.wrapObject(delegate.replace(key != null ? InternalHelper.unwrapObject(key) : null, value != null ? InternalHelper.unwrapObject(value) : null));
    return ret;
  }
  /**
   * Close and release the map
   */
  public void close() {
    delegate.close();
  }
}
