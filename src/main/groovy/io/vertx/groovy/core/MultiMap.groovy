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
import java.util.Map.Entry
import java.util.Set
/**
 * This class represents a MultiMap of String keys to a List of String values.
 * <p>
 * It's useful in Vert.x to represent things in Vert.x like HTTP headers and HTTP parameters which allow
 * multiple values for keys.
*/
@CompileStatic
public class MultiMap {
  private final def io.vertx.core.MultiMap delegate;
  public MultiMap(Object delegate) {
    this.delegate = (io.vertx.core.MultiMap) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Create a multi-map implementation with case insensitive keys, for instance it can be used to hold some HTTP headers.
   * @return the multi-map
   */
  public static MultiMap caseInsensitiveMultiMap() {
    def ret = InternalHelper.safeCreate(io.vertx.core.MultiMap.caseInsensitiveMultiMap(), io.vertx.groovy.core.MultiMap.class);
    return ret;
  }
  /**
   * Returns the value of with the specified name.  If there are
   * more than one values for the specified name, the first value is returned.
   * @param name The name of the header to search
   * @return The first header value or <code>null</code> if there is no such entry
   */
  public String get(String name) {
    def ret = delegate.get(name);
    return ret;
  }
  /**
   * Returns the values with the specified name
   * @param name The name to search
   * @return A immutable {@link java.util.List} of values which will be empty if no values are found
   */
  public List<String> getAll(String name) {
    def ret = delegate.getAll(name);
    return ret;
  }
  /**
   * Checks to see if there is a value with the specified name
   * @param name The name to search for
   * @return true if at least one entry is found
   */
  public boolean contains(String name) {
    def ret = delegate.contains(name);
    return ret;
  }
  /**
   * Return true if empty
   * @return 
   */
  public boolean isEmpty() {
    def ret = delegate.isEmpty();
    return ret;
  }
  /**
   * Gets a immutable {@link java.util.Set} of all names
   * @return A {@link java.util.Set} of all names
   */
  public Set<String> names() {
    def ret = delegate.names();
    return ret;
  }
  /**
   * Adds a new value with the specified name and value.
   * @param name The name
   * @param value The value being added
   * @return a reference to this, so the API can be used fluently
   */
  public MultiMap add(String name, String value) {
    delegate.add(name, value);
    return this;
  }
  /**
   * Adds all the entries from another MultiMap to this one
   * @param map 
   * @return a reference to this, so the API can be used fluently
   */
  public MultiMap addAll(MultiMap map) {
    delegate.addAll(map != null ? (io.vertx.core.MultiMap)map.getDelegate() : null);
    return this;
  }
  /**
   * Sets a value under the specified name.
   * <p>
   * If there is an existing header with the same name, it is removed.
   * @param name The name
   * @param value The value
   * @return a reference to this, so the API can be used fluently
   */
  public MultiMap set(String name, String value) {
    delegate.set(name, value);
    return this;
  }
  /**
   * Cleans this instance.
   * @param map 
   * @return a reference to this, so the API can be used fluently
   */
  public MultiMap setAll(MultiMap map) {
    delegate.setAll(map != null ? (io.vertx.core.MultiMap)map.getDelegate() : null);
    return this;
  }
  /**
   * Removes the value with the given name
   * @param name The name of the value to remove
   * @return a reference to this, so the API can be used fluently
   */
  public MultiMap remove(String name) {
    delegate.remove(name);
    return this;
  }
  /**
   * Removes all
   * @return a reference to this, so the API can be used fluently
   */
  public MultiMap clear() {
    delegate.clear();
    return this;
  }
  /**
   * Return the number of keys.
   * @return 
   */
  public int size() {
    def ret = delegate.size();
    return ret;
  }
}
