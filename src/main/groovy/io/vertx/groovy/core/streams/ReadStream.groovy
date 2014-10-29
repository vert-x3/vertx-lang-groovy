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
 * Represents a stream of data that can be read from.<p>
 * Any class that implements this interface can be used by a {@link Pump} to pump data from it
 * to a {@link WriteStream}.<p>
 * This interface exposes a fluent api and the type T represents the type of the object that implements
 * the interface to allow method chaining
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public interface ReadStream<T> extends StreamBase {
  public Object getDelegate();
  ReadStream<T> exceptionHandler(Handler<Throwable> handler);
  ReadStream<T> handler(Handler<T> handler);
  ReadStream<T> pause();
  ReadStream<T> resume();
  ReadStream<T> endHandler(Handler<Void> endHandler);

  static final java.util.function.Function<io.vertx.core.streams.ReadStream, ReadStream> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.streams.ReadStream arg -> new ReadStreamImpl(arg);
  };
}

@CompileStatic
class ReadStreamImpl<T> implements ReadStream<T> {
  final def io.vertx.core.streams.ReadStream delegate;
  public ReadStreamImpl(io.vertx.core.streams.ReadStream delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public ReadStream<T> exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.streams.ReadStream) this.delegate).exceptionHandler(handler);
    return this;
  }
  /**
   * Set a data handler. As data is read, the handler will be called with the data.
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
   * Pause the {@code ReadSupport}. While it's paused, no data will be sent to the {@code dataHandler}
   */
  public ReadStream<T> pause() {
    ((io.vertx.core.streams.ReadStream) this.delegate).pause();
    return this;
  }
  /**
   * Resume reading. If the {@code ReadSupport} has been paused, reading will recommence on it.
   */
  public ReadStream<T> resume() {
    ((io.vertx.core.streams.ReadStream) this.delegate).resume();
    return this;
  }
  /**
   * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.
   */
  public ReadStream<T> endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.streams.ReadStream) this.delegate).endHandler(endHandler);
    return this;
  }
}
