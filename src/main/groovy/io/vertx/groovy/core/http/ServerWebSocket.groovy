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
import io.vertx.groovy.core.MultiMap
import io.vertx.core.Handler
import io.vertx.groovy.core.net.SocketAddress
/**
 * Represents a server side WebSocket.
 * <p>
 * Instances of this class are passed into a {@link io.vertx.groovy.core.http.HttpServer#websocketHandler} or provided
 * when a WebSocket handshake is manually {@link io.vertx.groovy.core.http.HttpServerRequest#upgrade}ed.
*/
@CompileStatic
public class ServerWebSocket implements WebSocketBase {
  private final def io.vertx.core.http.ServerWebSocket delegate;
  public ServerWebSocket(Object delegate) {
    this.delegate = (io.vertx.core.http.ServerWebSocket) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.WebSocketBase#end} but writes some data to the stream before ending.
   * @param t 
   */
  public void end(Buffer t) {
    ((io.vertx.core.streams.WriteStream) this.delegate).end((io.vertx.core.buffer.Buffer)t.getDelegate());
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.http.ServerWebSocket#setWriteQueueMaxSize}
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
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.WebSocketBase) this.delegate).end();
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
  public ServerWebSocket exceptionHandler(Handler<Throwable> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).exceptionHandler(handler);
    return this;
  }
  public ServerWebSocket handler(Handler<Buffer> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).handler(new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        handler.handle(new io.vertx.groovy.core.buffer.Buffer(event));
      }
    });
    return this;
  }
  public ServerWebSocket pause() {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).pause();
    return this;
  }
  public ServerWebSocket resume() {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).resume();
    return this;
  }
  public ServerWebSocket endHandler(Handler<Void> endHandler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).endHandler(endHandler);
    return this;
  }
  public ServerWebSocket write(Buffer data) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).write((io.vertx.core.buffer.Buffer)data.getDelegate());
    return this;
  }
  public ServerWebSocket setWriteQueueMaxSize(int maxSize) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).setWriteQueueMaxSize(maxSize);
    return this;
  }
  public ServerWebSocket drainHandler(Handler<Void> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).drainHandler(handler);
    return this;
  }
  public ServerWebSocket writeFrame(WebSocketFrame frame) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).writeFrame((io.vertx.core.http.WebSocketFrame)frame.getDelegate());
    return this;
  }
  public ServerWebSocket writeFinalTextFrame(String text) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).writeFinalTextFrame(text);
    return this;
  }
  public ServerWebSocket writeFinalBinaryFrame(Buffer data) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).writeFinalBinaryFrame((io.vertx.core.buffer.Buffer)data.getDelegate());
    return this;
  }
  public ServerWebSocket writeBinaryMessage(Buffer data) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).writeBinaryMessage((io.vertx.core.buffer.Buffer)data.getDelegate());
    return this;
  }
  public ServerWebSocket closeHandler(Handler<Void> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).closeHandler(handler);
    return this;
  }
  public ServerWebSocket frameHandler(Handler<WebSocketFrame> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.ServerWebSocket) this.delegate).frameHandler(new Handler<io.vertx.core.http.WebSocketFrame>() {
      public void handle(io.vertx.core.http.WebSocketFrame event) {
        handler.handle(new io.vertx.groovy.core.http.WebSocketFrame(event));
      }
    });
    return this;
  }
  public String uri() {
    def ret = this.delegate.uri();
    return ret;
  }
  /**
   * @return the WebSocket handshake path.
   * @return 
   */
  public String path() {
    def ret = this.delegate.path();
    return ret;
  }
  /**
   * @return the WebSocket handshake query string.
   * @return 
   */
  public String query() {
    def ret = this.delegate.query();
    return ret;
  }
  /**
   * @return the headers in the WebSocket handshake
   * @return 
   */
  public MultiMap headers() {
    if (cached_2 != null) {
      return cached_2;
    }
    def ret= InternalHelper.safeCreate(this.delegate.headers(), io.vertx.groovy.core.MultiMap.class);
    cached_2 = ret;
    return ret;
  }
  /**
   * Reject the WebSocket.
   * <p>
   * Calling this method from the websocket handler when it is first passed to you gives you the opportunity to reject
   * the websocket, which will cause the websocket handshake to fail by returning
   * a 404 response code.
   * <p>
   * You might use this method, if for example you only want to accept WebSockets with a particular path.
   */
  public void reject() {
    this.delegate.reject();
  }
  private SocketAddress cached_0;
  private SocketAddress cached_1;
  private MultiMap cached_2;
}
