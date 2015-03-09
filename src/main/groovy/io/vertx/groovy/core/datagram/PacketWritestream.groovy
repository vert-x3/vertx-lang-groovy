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

package io.vertx.groovy.core.datagram;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.groovy.core.streams.WriteStream
import io.vertx.core.Handler
/**
 * A link for sending packets to a link.
 * The stream  is called when the write fails.
*/
@CompileStatic
public class PacketWritestream implements WriteStream<Buffer> {
  final def io.vertx.core.datagram.PacketWritestream delegate;
  public PacketWritestream(io.vertx.core.datagram.PacketWritestream delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using link
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) this.delegate).writeQueueFull();
    return ret;
  }
  public PacketWritestream exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler);
    return this;
  }
  public PacketWritestream write(Buffer data) {
    this.delegate.write((io.vertx.core.buffer.Buffer)data.getDelegate());
    return this;
  }
  public PacketWritestream setWriteQueueMaxSize(int maxSize) {
    this.delegate.setWriteQueueMaxSize(maxSize);
    return this;
  }
  public PacketWritestream drainHandler(Handler<Void> handler) {
    this.delegate.drainHandler(handler);
    return this;
  }

  static final java.util.function.Function<io.vertx.core.datagram.PacketWritestream, PacketWritestream> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.datagram.PacketWritestream arg -> new PacketWritestream(arg);
  };
}
