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

package io.vertx.groovy.core.streams;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.Handler
/**
 * Base interface for a stream.
*/
@CompileStatic
public interface StreamBase {
  public Object getDelegate();
  StreamBase exceptionHandler(Handler<Throwable> handler);
}

@CompileStatic
class StreamBaseImpl implements StreamBase {
  private final def io.vertx.core.streams.StreamBase delegate;
  public StreamBaseImpl(Object delegate) {
    this.delegate = (io.vertx.core.streams.StreamBase) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Set an exception handler.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public StreamBase exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.streams.StreamBase) this.delegate).exceptionHandler(handler);
    return this;
  }
}
