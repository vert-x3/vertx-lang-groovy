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

package io.vertx.groovy.core.net;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.groovy.core.streams.WriteStream
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents a socket-like interface to a TCP connection on either the
 * client or the server side.
 * <p>
 * Instances of this class are created on the client side by an {@link io.vertx.groovy.core.net.NetClient}
 * when a connection to a server is made, or on the server side by a {@link io.vertx.groovy.core.net.NetServer}
 * when a server accepts a connection.
 * <p>
 * It implements both  and  so it can be used with
 * {@link io.vertx.groovy.core.streams.Pump} to pump data with flow control.
*/
@CompileStatic
public class NetSocket implements ReadStream<Buffer>,  WriteStream<Buffer> {
  private final def io.vertx.core.net.NetSocket delegate;
  public NetSocket(Object delegate) {
    this.delegate = (io.vertx.core.net.NetSocket) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Same as {@link io.vertx.groovy.core.net.NetSocket#end} but writes some data to the stream before ending.
   * @param t 
   */
  public void end(Buffer t) {
    ((io.vertx.core.streams.WriteStream) this.delegate).end(t != null ? (io.vertx.core.buffer.Buffer)t.getDelegate() : null);
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.net.NetSocket#setWriteQueueMaxSize}
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) this.delegate).writeQueueFull();
    return ret;
  }
  public NetSocket exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.streams.WriteStream) this.delegate).exceptionHandler(handler != null ? new Handler<java.lang.Throwable>(){
    public void handle(java.lang.Throwable event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  public NetSocket handler(Handler<Buffer> handler) {
    ((io.vertx.core.streams.ReadStream) this.delegate).handler(handler != null ? new Handler<io.vertx.core.buffer.Buffer>(){
    public void handle(io.vertx.core.buffer.Buffer event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  public NetSocket pause() {
    ((io.vertx.core.streams.ReadStream) this.delegate).pause();
    return this;
  }
  public NetSocket resume() {
    ((io.vertx.core.streams.ReadStream) this.delegate).resume();
    return this;
  }
  public NetSocket endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.streams.ReadStream) this.delegate).endHandler(endHandler != null ? new Handler<java.lang.Void>(){
    public void handle(java.lang.Void event) {
      endHandler.handle(null);
    }
  }
 : null);
    return this;
  }
  public NetSocket write(Buffer data) {
    ((io.vertx.core.streams.WriteStream) this.delegate).write(data != null ? (io.vertx.core.buffer.Buffer)data.getDelegate() : null);
    return this;
  }
  public NetSocket setWriteQueueMaxSize(int maxSize) {
    ((io.vertx.core.streams.WriteStream) this.delegate).setWriteQueueMaxSize(maxSize != null ? maxSize : null);
    return this;
  }
  public NetSocket drainHandler(Handler<Void> handler) {
    ((io.vertx.core.streams.WriteStream) this.delegate).drainHandler(handler != null ? new Handler<java.lang.Void>(){
    public void handle(java.lang.Void event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * When a <code>NetSocket</code> is created it automatically registers an event handler with the event bus, the ID of that
   * handler is given by <code>writeHandlerID</code>.
   * <p>
   * Given this ID, a different event loop can send a buffer to that event handler using the event bus and
   * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
   * allows you to write data to other connections which are owned by different event loops.
   * @return the write handler ID
   */
  public String writeHandlerID() {
    def ret = this.delegate.writeHandlerID();
    return ret;
  }
  /**
   * Write a {@link java.lang.String} to the connection, encoded in UTF-8.
   * @param str the string to write
   * @return a reference to this, so the API can be used fluently
   */
  public NetSocket write(String str) {
    this.delegate.write(str != null ? str : null);
    return this;
  }
  /**
   * Write a {@link java.lang.String} to the connection, encoded using the encoding <code>enc</code>.
   * @param str the string to write
   * @param enc the encoding to use
   * @return a reference to this, so the API can be used fluently
   */
  public NetSocket write(String str, String enc) {
    this.delegate.write(str != null ? str : null, enc != null ? enc : null);
    return this;
  }
  /**
   * Tell the operating system to stream a file as specified by <code>filename</code> directly from disk to the outgoing connection,
   * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.
   * @param filename file name of the file to send
   * @return a reference to this, so the API can be used fluently
   */
  public NetSocket sendFile(String filename) {
    this.delegate.sendFile(filename != null ? filename : null);
    return this;
  }
  /**
   * Tell the operating system to stream a file as specified by <code>filename</code> directly from disk to the outgoing connection,
   * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.
   * @param filename file name of the file to send
   * @param offset offset
   * @return a reference to this, so the API can be used fluently
   */
  public NetSocket sendFile(String filename, long offset) {
    this.delegate.sendFile(filename != null ? filename : null, offset != null ? offset : null);
    return this;
  }
  /**
   * Tell the operating system to stream a file as specified by <code>filename</code> directly from disk to the outgoing connection,
   * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.
   * @param filename file name of the file to send
   * @param offset offset
   * @param length length
   * @return a reference to this, so the API can be used fluently
   */
  public NetSocket sendFile(String filename, long offset, long length) {
    this.delegate.sendFile(filename != null ? filename : null, offset != null ? offset : null, length != null ? length : null);
    return this;
  }
  /**
   * Same as {@link io.vertx.groovy.core.net.NetSocket#sendFile} but also takes a handler that will be called when the send has completed or
   * a failure has occurred
   * @param filename file name of the file to send
   * @param resultHandler handler
   * @return a reference to this, so the API can be used fluently
   */
  public NetSocket sendFile(String filename, Handler<AsyncResult<Void>> resultHandler) {
    this.delegate.sendFile(filename != null ? filename : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Same as {@link io.vertx.groovy.core.net.NetSocket#sendFile} but also takes a handler that will be called when the send has completed or
   * a failure has occurred
   * @param filename file name of the file to send
   * @param offset offset
   * @param resultHandler handler
   * @return a reference to this, so the API can be used fluently
   */
  public NetSocket sendFile(String filename, long offset, Handler<AsyncResult<Void>> resultHandler) {
    this.delegate.sendFile(filename != null ? filename : null, offset != null ? offset : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Same as {@link io.vertx.groovy.core.net.NetSocket#sendFile} but also takes a handler that will be called when the send has completed or
   * a failure has occurred
   * @param filename file name of the file to send
   * @param offset offset
   * @param length length
   * @param resultHandler handler
   * @return a reference to this, so the API can be used fluently
   */
  public NetSocket sendFile(String filename, long offset, long length, Handler<AsyncResult<Void>> resultHandler) {
    this.delegate.sendFile(filename != null ? filename : null, offset != null ? offset : null, length != null ? length : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * @return the remote address for this socket
   * @return 
   */
  public SocketAddress remoteAddress() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret= InternalHelper.safeCreate(this.delegate.remoteAddress(), io.vertx.groovy.core.net.SocketAddress.class);
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
    def ret= InternalHelper.safeCreate(this.delegate.localAddress(), io.vertx.groovy.core.net.SocketAddress.class);
    cached_1 = ret;
    return ret;
  }
  /**
   * Calls {@link io.vertx.groovy.core.net.NetSocket#close}
   */
  public void end() {
    ((io.vertx.core.streams.WriteStream) this.delegate).end();
  }
  /**
   * Close the NetSocket
   */
  public void close() {
    this.delegate.close();
  }
  /**
   * Set a handler that will be called when the NetSocket is closed
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public NetSocket closeHandler(Handler<Void> handler) {
    this.delegate.closeHandler(handler != null ? new Handler<java.lang.Void>(){
    public void handle(java.lang.Void event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Upgrade channel to use SSL/TLS. Be aware that for this to work SSL must be configured.
   * @param handler the handler will be notified when it's upgraded
   * @return a reference to this, so the API can be used fluently
   */
  public NetSocket upgradeToSsl(Handler<Void> handler) {
    this.delegate.upgradeToSsl(handler != null ? new Handler<java.lang.Void>(){
    public void handle(java.lang.Void event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * @return true if this {@link io.vertx.groovy.core.net.NetSocket} is encrypted via SSL/TLS.
   * @return 
   */
  public boolean isSsl() {
    def ret = this.delegate.isSsl();
    return ret;
  }
  private SocketAddress cached_0;
  private SocketAddress cached_1;
}
