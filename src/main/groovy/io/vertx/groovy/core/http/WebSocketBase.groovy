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
import io.vertx.groovy.core.streams.WriteStream
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.Handler
import io.vertx.groovy.core.net.SocketAddress
/**
 * Base WebSocket implementation.
 * <p>
 * It implements both  and  so it can be used with
 * {@link io.vertx.groovy.core.streams.Pump} to pump data with flow control.
*/
@CompileStatic
public interface WebSocketBase extends ReadStream<Buffer>,  WriteStream<Buffer> {
  public Object getDelegate();
  void end(Buffer t);
  boolean writeQueueFull();
  WebSocketBase exceptionHandler(Handler<Throwable> handler);
  WebSocketBase handler(Handler<Buffer> handler);
  WebSocketBase pause();
  WebSocketBase resume();
  WebSocketBase endHandler(Handler<Void> endHandler);
  WebSocketBase write(Buffer data);
  WebSocketBase setWriteQueueMaxSize(int maxSize);
  WebSocketBase drainHandler(Handler<Void> handler);
  String binaryHandlerID();
  String textHandlerID();
  WebSocketBase writeFrame(WebSocketFrame frame);
  WebSocketBase writeFinalTextFrame(String text);
  WebSocketBase writeFinalBinaryFrame(Buffer data);
  WebSocketBase writeBinaryMessage(Buffer data);
  WebSocketBase closeHandler(Handler<Void> handler);
  WebSocketBase frameHandler(Handler<WebSocketFrame> handler);
  void end();
  void close();
  SocketAddress remoteAddress();
  SocketAddress localAddress();
}

@CompileStatic
class WebSocketBaseImpl implements WebSocketBase {
  private final def io.vertx.core.http.WebSocketBase delegate;
  public WebSocketBaseImpl(Object delegate) {
    this.delegate = (io.vertx.core.http.WebSocketBase) delegate;
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
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.http.WebSocketBase#setWriteQueueMaxSize}
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) this.delegate).writeQueueFull();
    return ret;
  }
  public WebSocketBase exceptionHandler(Handler<Throwable> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.WebSocketBase) this.delegate).exceptionHandler(handler);
    return this;
  }
  public WebSocketBase handler(Handler<Buffer> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.WebSocketBase) this.delegate).handler(new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        handler.handle(new io.vertx.groovy.core.buffer.Buffer(event));
      }
    });
    return this;
  }
  public WebSocketBase pause() {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.WebSocketBase) this.delegate).pause();
    return this;
  }
  public WebSocketBase resume() {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.WebSocketBase) this.delegate).resume();
    return this;
  }
  public WebSocketBase endHandler(Handler<Void> endHandler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.WebSocketBase) this.delegate).endHandler(endHandler);
    return this;
  }
  public WebSocketBase write(Buffer data) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.WebSocketBase) this.delegate).write((io.vertx.core.buffer.Buffer)data.getDelegate());
    return this;
  }
  public WebSocketBase setWriteQueueMaxSize(int maxSize) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.WebSocketBase) this.delegate).setWriteQueueMaxSize(maxSize);
    return this;
  }
  public WebSocketBase drainHandler(Handler<Void> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.WebSocketBase) this.delegate).drainHandler(handler);
    return this;
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
   * Write a WebSocket frame to the connection
   * @param frame the frame to write
   * @return a reference to this, so the API can be used fluently
   */
  public WebSocketBase writeFrame(WebSocketFrame frame) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).writeFrame((io.vertx.core.http.WebSocketFrame)frame.getDelegate());
    return this;
  }
  /**
   * Write a final WebSocket text frame to the connection
   * @param text The text to write
   * @return a reference to this, so the API can be used fluently
   */
  public WebSocketBase writeFinalTextFrame(String text) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).writeFinalTextFrame(text);
    return this;
  }
  /**
   * Write a final WebSocket binary frame to the connection
   * @param data The data to write
   * @return a reference to this, so the API can be used fluently
   */
  public WebSocketBase writeFinalBinaryFrame(Buffer data) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).writeFinalBinaryFrame((io.vertx.core.buffer.Buffer)data.getDelegate());
    return this;
  }
  /**
   * Writes a (potentially large) piece of binary data to the connection. This data might be written as multiple frames
   * if it exceeds the maximum WebSocket frame size.
   * @param data the data to write
   * @return a reference to this, so the API can be used fluently
   */
  public WebSocketBase writeBinaryMessage(Buffer data) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).writeBinaryMessage((io.vertx.core.buffer.Buffer)data.getDelegate());
    return this;
  }
  /**
   * Set a close handler. This will be called when the WebSocket is closed.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public WebSocketBase closeHandler(Handler<Void> handler) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).closeHandler(handler);
    return this;
  }
  /**
   * Set a frame handler on the connection. This handler will be called when frames are read on the connection.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public WebSocketBase frameHandler(Handler<WebSocketFrame> handler) {
    ((io.vertx.core.http.WebSocketBase) this.delegate).frameHandler(new Handler<io.vertx.core.http.WebSocketFrame>() {
      public void handle(io.vertx.core.http.WebSocketFrame event) {
        handler.handle(new io.vertx.groovy.core.http.WebSocketFrame(event));
      }
    });
    return this;
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
  private SocketAddress cached_0;
  private SocketAddress cached_1;
}
