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
public class Lock {
  final def io.vertx.core.shareddata.Lock delegate;
  public Lock(io.vertx.core.shareddata.Lock delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public void release() {
    this.delegate.release();
  }

  static final java.util.function.Function<io.vertx.core.shareddata.Lock, Lock> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.shareddata.Lock arg -> new Lock(arg);
  };
}
