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
/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class LocalMap<K,V> {
  final def io.vertx.core.shareddata.LocalMap delegate;
  public LocalMap(io.vertx.core.shareddata.LocalMap delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public V get(K key) {
    // This cast is cleary flawed
    def ret = (V) InternalHelper.wrapObject(((io.vertx.core.shareddata.LocalMap) this.delegate).get(InternalHelper.unwrapObject(key)));
    return ret;
  }
  public V put(K key, V value) {
    // This cast is cleary flawed
    def ret = (V) InternalHelper.wrapObject(((io.vertx.core.shareddata.LocalMap) this.delegate).put(InternalHelper.unwrapObject(key), InternalHelper.unwrapObject(value)));
    return ret;
  }
  public V remove(K key) {
    // This cast is cleary flawed
    def ret = (V) InternalHelper.wrapObject(((io.vertx.core.shareddata.LocalMap) this.delegate).remove(InternalHelper.unwrapObject(key)));
    return ret;
  }
  public void clear() {
    ((io.vertx.core.shareddata.LocalMap) this.delegate).clear();
  }
  public int size() {
    def ret = ((io.vertx.core.shareddata.LocalMap) this.delegate).size();
    return ret;
  }
  public boolean isEmpty() {
    def ret = ((io.vertx.core.shareddata.LocalMap) this.delegate).isEmpty();
    return ret;
  }
  public V putIfAbsent(K key, V value) {
    // This cast is cleary flawed
    def ret = (V) InternalHelper.wrapObject(((io.vertx.core.shareddata.LocalMap) this.delegate).putIfAbsent(InternalHelper.unwrapObject(key), InternalHelper.unwrapObject(value)));
    return ret;
  }
  public boolean removeIfPresent(K key, V value) {
    def ret = ((io.vertx.core.shareddata.LocalMap) this.delegate).removeIfPresent(InternalHelper.unwrapObject(key), InternalHelper.unwrapObject(value));
    return ret;
  }
  public boolean replaceIfPresent(K key, V oldValue, V newValue) {
    def ret = ((io.vertx.core.shareddata.LocalMap) this.delegate).replaceIfPresent(InternalHelper.unwrapObject(key), InternalHelper.unwrapObject(oldValue), InternalHelper.unwrapObject(newValue));
    return ret;
  }
  public V replace(K key, V value) {
    // This cast is cleary flawed
    def ret = (V) InternalHelper.wrapObject(((io.vertx.core.shareddata.LocalMap) this.delegate).replace(InternalHelper.unwrapObject(key), InternalHelper.unwrapObject(value)));
    return ret;
  }
  public void close() {
    ((io.vertx.core.shareddata.LocalMap) this.delegate).close();
  }

  static final java.util.function.Function<io.vertx.core.shareddata.LocalMap, LocalMap> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.shareddata.LocalMap arg -> new LocalMap(arg);
  };
}
