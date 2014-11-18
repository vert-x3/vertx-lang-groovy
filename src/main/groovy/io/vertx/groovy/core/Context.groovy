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
import java.util.List
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler
/**
 * Represents the execution context of a Verticle.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class Context {
  final def io.vertx.core.Context delegate;
  public Context(io.vertx.core.Context delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public void runOnContext(Handler<Void> action) {
    this.delegate.runOnContext(action);
  }
  public String deploymentID() {
    def ret = this.delegate.deploymentID();
    return ret;
  }
  public Map<String, Object> config() {
    def ret = this.delegate.config()?.getMap();
    return ret;
  }
  public List<String> processArgs() {
    def ret = this.delegate.processArgs();
    return ret;
  }
  public boolean isEventLoopContext() {
    def ret = this.delegate.isEventLoopContext();
    return ret;
  }
  public boolean isWorker() {
    def ret = this.delegate.isWorker();
    return ret;
  }
  public boolean isMultiThreaded() {
    def ret = this.delegate.isMultiThreaded();
    return ret;
  }
  public <T> T get(String key) {
    // This cast is cleary flawed
    def ret = (T) InternalHelper.wrapObject(this.delegate.get(key));
    return ret;
  }
  public void put(String key, Object value) {
    this.delegate.put(key, InternalHelper.unwrapObject(value));
  }
  public boolean remove(String key) {
    def ret = this.delegate.remove(key);
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.Context, Context> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.Context arg -> new Context(arg);
  };
}
