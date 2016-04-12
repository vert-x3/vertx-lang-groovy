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
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.groovy.core.streams.WriteStream
import io.vertx.core.Handler
/**
 * A {@link io.vertx.groovy.core.streams.WriteStream} for sending packets to a {@link io.vertx.groovy.core.net.SocketAddress}.
 * The stream  is called when the write fails.
*/
@CompileStatic
public class PacketWritestream implements WriteStream<Buffer> {
  private final def io.vertx.core.datagram.PacketWritestream delegate;
  public PacketWritestream(Object delegate) {
    this.delegate = (io.vertx.core.datagram.PacketWritestream) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Ends the stream.
   * <p>
   * Once the stream has ended, it cannot be used any more.
   */
  public void end() {
    ((io.vertx.core.streams.WriteStream) delegate).end();
  }
  /**
   * Same as {@link io.vertx.groovy.core.streams.WriteStream#end} but writes some data to the stream before ending.
   * @param t 
   */
  public void end(Buffer t) {
    ((io.vertx.core.streams.WriteStream) delegate).end(t != null ? (io.vertx.core.buffer.Buffer)t.getDelegate() : null);
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.datagram.PacketWritestream#setWriteQueueMaxSize}
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) delegate).writeQueueFull();
    return ret;
  }
  public PacketWritestream exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.datagram.PacketWritestream) delegate).exceptionHandler(handler != null ? new Handler<java.lang.Throwable>(){
      public void handle(java.lang.Throwable event) {
        handler.handle(event);
      }
    } : null);
    return this;
  }
  public PacketWritestream write(Buffer data) {
    ((io.vertx.core.datagram.PacketWritestream) delegate).write(data != null ? (io.vertx.core.buffer.Buffer)data.getDelegate() : null);
    return this;
  }
  public PacketWritestream setWriteQueueMaxSize(int maxSize) {
    ((io.vertx.core.datagram.PacketWritestream) delegate).setWriteQueueMaxSize(maxSize);
    return this;
  }
  public PacketWritestream drainHandler(Handler<Void> handler) {
    ((io.vertx.core.datagram.PacketWritestream) delegate).drainHandler(handler != null ? new Handler<java.lang.Void>(){
      public void handle(java.lang.Void event) {
        handler.handle(event);
      }
    } : null);
    return this;
  }
}
