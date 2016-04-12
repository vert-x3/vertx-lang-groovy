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

package io.vertx.groovy.core.http;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.core.Handler
import io.vertx.groovy.core.net.SocketAddress
/**
 * Represents a client-side WebSocket.
*/
@CompileStatic
public class WebSocket implements WebSocketBase {
  private final def io.vertx.core.http.WebSocket delegate;
  public WebSocket(Object delegate) {
    this.delegate = (io.vertx.core.http.WebSocket) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.WebSocketBase#end} but writes some data to the stream before ending.
   * @param t 
   */
  public void end(Buffer t) {
    ((io.vertx.core.streams.WriteStream) this.delegate).end(t != null ? (io.vertx.core.buffer.Buffer)t.getDelegate() : null);
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.http.WebSocket#setWriteQueueMaxSize}
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) this.delegate).writeQueueFull();
    return ret;
  }
  /**
   * When a <code>Websocket</code> is created it automatically registers an event handler with the event bus - the ID of that
   * handler is given by this method.
   * <p>
   * Given this ID, a different event loop can send a binary frame to that event handler using the event bus and
   * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
   * allows you to write data to other WebSockets which are owned by different event loops.
   * @return the binary handler id
   */
  public String binaryHandlerID() {
    def ret = ((io.vertx.core.http.WebSocketBase) this.delegate).binaryHandlerID();
    return ret;
  }
  /**
   * When a <code>Websocket</code> is created it automatically registers an event handler with the eventbus, the ID of that
   * handler is given by <code>textHandlerID</code>.
   * <p>
   * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
   * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
   * allows you to write data to other WebSockets which are owned by different event loops.
   * @return 
   */
  public String textHandlerID() {
    def ret = ((io.vertx.core.http.WebSocketBase) this.delegate).textHandlerID();
    return ret;
  }
  /**
   * Calls {@link io.vertx.groovy.core.http.WebSocketBase#close}
   */
  public void end() {
    ((io.vertx.core.http.WebSocketBase) this.delegate).end();
  }
  /**
   * Close the WebSocket.
   */
  public void close() {
    ((io.vertx.core.http.WebSocketBase) this.delegate).close();
  }
  /**
   * @return the remote address for this socket
   * @return 
   */
  public SocketAddress remoteAddress() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret= InternalHelper.safeCreate(((io.vertx.core.http.WebSocketBase) this.delegate).remoteAddress(), io.vertx.groovy.core.net.SocketAddress.class);
    cached_0 = ret;
    return ret;
  }
  /**
   * @return the local address for this socket
   * @return 
   */
  public SocketAddress localAddress() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret= InternalHelper.safeCreate(((io.vertx.core.http.WebSocketBase) this.delegate).localAddress(), io.vertx.groovy.core.net.SocketAddress.class);
    cached_1 = ret;
    return ret;
  }
  public WebSocket exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).exceptionHandler(handler != null ? new Handler<java.lang.Throwable>(){
    public void handle(java.lang.Throwable event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  public WebSocket handler(Handler<Buffer> handler) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).handler(handler != null ? new Handler<io.vertx.core.buffer.Buffer>(){
    public void handle(io.vertx.core.buffer.Buffer event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  public WebSocket pause() {
    ((io.vertx.core.http.WebSocketBase) this.delegate).pause();
    return this;
  }
  public WebSocket resume() {
    ((io.vertx.core.http.WebSocketBase) this.delegate).resume();
    return this;
  }
  public WebSocket endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).endHandler(endHandler != null ? new Handler<java.lang.Void>(){
    public void handle(java.lang.Void event) {
      endHandler.handle(null);
    }
  }
 : null);
    return this;
  }
  public WebSocket write(Buffer data) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).write(data != null ? (io.vertx.core.buffer.Buffer)data.getDelegate() : null);
    return this;
  }
  public WebSocket setWriteQueueMaxSize(int maxSize) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).setWriteQueueMaxSize(maxSize != null ? maxSize : null);
    return this;
  }
  public WebSocket drainHandler(Handler<Void> handler) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).drainHandler(handler != null ? new Handler<java.lang.Void>(){
    public void handle(java.lang.Void event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  public WebSocket writeFrame(WebSocketFrame frame) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).writeFrame(frame != null ? (io.vertx.core.http.WebSocketFrame)frame.getDelegate() : null);
    return this;
  }
  public WebSocket writeFinalTextFrame(String text) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).writeFinalTextFrame(text != null ? text : null);
    return this;
  }
  public WebSocket writeFinalBinaryFrame(Buffer data) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).writeFinalBinaryFrame(data != null ? (io.vertx.core.buffer.Buffer)data.getDelegate() : null);
    return this;
  }
  public WebSocket writeBinaryMessage(Buffer data) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).writeBinaryMessage(data != null ? (io.vertx.core.buffer.Buffer)data.getDelegate() : null);
    return this;
  }
  public WebSocket closeHandler(Handler<Void> handler) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).closeHandler(handler != null ? new Handler<java.lang.Void>(){
    public void handle(java.lang.Void event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  public WebSocket frameHandler(Handler<WebSocketFrame> handler) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).frameHandler(handler != null ? new Handler<io.vertx.core.http.WebSocketFrame>(){
    public void handle(io.vertx.core.http.WebSocketFrame event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  private SocketAddress cached_0;
  private SocketAddress cached_1;
}
