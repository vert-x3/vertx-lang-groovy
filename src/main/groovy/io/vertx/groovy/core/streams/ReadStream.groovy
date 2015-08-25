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
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler
/**
 * Represents a stream of items that can be read from.
 * <p>
 * Any class that implements this interface can be used by a {@link io.vertx.groovy.core.streams.Pump} to pump data from it
 * to a {@link io.vertx.groovy.core.streams.WriteStream}.
*/
@CompileStatic
public interface ReadStream<T> extends StreamBase {
  public Object getDelegate();
  ReadStream<T> exceptionHandler(Handler<Throwable> handler);
  ReadStream<T> handler(Handler<T> handler);
  ReadStream<T> pause();
  ReadStream<T> resume();
  ReadStream<T> endHandler(Handler<Void> endHandler);
}

@CompileStatic
class ReadStreamImpl<T> implements ReadStream<T> {
  private final def io.vertx.core.streams.ReadStream delegate;
  public ReadStreamImpl(Object delegate) {
    this.delegate = (io.vertx.core.streams.ReadStream) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Set an exception handler on the read stream.
   * @param handler the exception handler
   * @return a reference to this, so the API can be used fluently
   */
  public ReadStream<T> exceptionHandler(Handler<Throwable> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.streams.StreamBase) this.delegate).exceptionHandler(handler);
    return this;
  }
  /**
   * Set a data handler. As data is read, the handler will be called with the data.
   * @param handler 
   * @return a reference to this, so the API can be used fluently
   */
  public ReadStream<T> handler(Handler<T> handler) {
    ((io.vertx.core.streams.ReadStream) this.delegate).handler(new Handler<Object>() {
      public void handle(Object event) {
        handler.handle(InternalHelper.wrapObject(event))
      }
    });
    return this;
  }
  /**
   * Pause the <code>ReadSupport</code>. While it's paused, no data will be sent to the <code>dataHandler</code>
   * @return a reference to this, so the API can be used fluently
   */
  public ReadStream<T> pause() {
    ((io.vertx.core.streams.ReadStream) this.delegate).pause();
    return this;
  }
  /**
   * Resume reading. If the <code>ReadSupport</code> has been paused, reading will recommence on it.
   * @return a reference to this, so the API can be used fluently
   */
  public ReadStream<T> resume() {
    ((io.vertx.core.streams.ReadStream) this.delegate).resume();
    return this;
  }
  /**
   * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.
   * @param endHandler 
   * @return a reference to this, so the API can be used fluently
   */
  public ReadStream<T> endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.streams.ReadStream) this.delegate).endHandler(endHandler);
    return this;
  }
}
