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
import java.util.List
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.groovy.core.MultiMap
import io.vertx.core.Handler
import io.vertx.groovy.core.net.NetSocket
/**
 * Represents a client-side HTTP response.
 * <p>
 * Vert.x provides you with one of these via the handler that was provided when creating the {@link io.vertx.groovy.core.http.HttpClientRequest}
 * or that was set on the {@link io.vertx.groovy.core.http.HttpClientRequest} instance.
 * <p>
 * It implements {@link io.vertx.groovy.core.streams.ReadStream} so it can be used with
 * {@link io.vertx.groovy.core.streams.Pump} to pump data with flow control.
*/
@CompileStatic
public class HttpClientResponse implements ReadStream<Buffer> {
  private final def io.vertx.core.http.HttpClientResponse delegate;
  public HttpClientResponse(Object delegate) {
    this.delegate = (io.vertx.core.http.HttpClientResponse) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public HttpClientResponse resume() {
    ((io.vertx.core.http.HttpClientResponse) delegate).resume();
    return this;
  }
  public HttpClientResponse exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.http.HttpClientResponse) delegate).exceptionHandler(handler);
    return this;
  }
  public HttpClientResponse handler(Handler<Buffer> handler) {
    ((io.vertx.core.http.HttpClientResponse) delegate).handler(handler != null ? new Handler<io.vertx.core.buffer.Buffer>(){
      public void handle(io.vertx.core.buffer.Buffer event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.buffer.Buffer.class));
      }
    } : null);
    return this;
  }
  public HttpClientResponse pause() {
    ((io.vertx.core.http.HttpClientResponse) delegate).pause();
    return this;
  }
  public HttpClientResponse endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.http.HttpClientResponse) delegate).endHandler(endHandler);
    return this;
  }
  /**
   * @return the version of the response
   */
  public HttpVersion version() {
    def ret = delegate.version();
    return ret;
  }
  /**
   * @return the status code of the response
   */
  public int statusCode() {
    def ret = delegate.statusCode();
    return ret;
  }
  /**
   * @return the status message of the response
   */
  public String statusMessage() {
    def ret = delegate.statusMessage();
    return ret;
  }
  /**
   * @return the headers
   */
  public MultiMap headers() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret = InternalHelper.safeCreate(delegate.headers(), io.vertx.groovy.core.MultiMap.class);
    cached_0 = ret;
    return ret;
  }
  /**
   * Return the first header value with the specified name
   * @param headerName the header name
   * @return the header value
   */
  public String getHeader(String headerName) {
    def ret = delegate.getHeader(headerName);
    return ret;
  }
  /**
   * Return the first trailer value with the specified name
   * @param trailerName the trailer name
   * @return the trailer value
   */
  public String getTrailer(String trailerName) {
    def ret = delegate.getTrailer(trailerName);
    return ret;
  }
  /**
   * @return the trailers
   */
  public MultiMap trailers() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret = InternalHelper.safeCreate(delegate.trailers(), io.vertx.groovy.core.MultiMap.class);
    cached_1 = ret;
    return ret;
  }
  /**
   * @return the Set-Cookie headers (including trailers)
   */
  public List<String> cookies() {
    if (cached_2 != null) {
      return cached_2;
    }
    def ret = delegate.cookies();
    cached_2 = ret;
    return ret;
  }
  /**
   * Convenience method for receiving the entire request body in one piece.
   * <p>
   * This saves you having to manually set a dataHandler and an endHandler and append the chunks of the body until
   * the whole body received. Don't use this if your request body is large - you could potentially run out of RAM.
   * @param bodyHandler This handler will be called after all the body has been received
   * @return 
   */
  public HttpClientResponse bodyHandler(Handler<Buffer> bodyHandler) {
    delegate.bodyHandler(bodyHandler != null ? new Handler<io.vertx.core.buffer.Buffer>(){
      public void handle(io.vertx.core.buffer.Buffer event) {
        bodyHandler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.buffer.Buffer.class));
      }
    } : null);
    return this;
  }
  /**
   * Set an custom frame handler. The handler will get notified when the http stream receives an custom HTTP/2
   * frame. HTTP/2 permits extension of the protocol.
   * @param handler 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientResponse customFrameHandler(Handler<HttpFrame> handler) {
    delegate.customFrameHandler(handler != null ? new Handler<io.vertx.core.http.HttpFrame>(){
      public void handle(io.vertx.core.http.HttpFrame event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.http.HttpFrame.class));
      }
    } : null);
    return this;
  }
  /**
   * Get a net socket for the underlying connection of this request.
   * <p>
   * USE THIS WITH CAUTION! Writing to the socket directly if you don't know what you're doing can easily break the HTTP protocol
   * <p>
   * One valid use-case for calling this is to receive the {@link io.vertx.groovy.core.net.NetSocket} after a HTTP CONNECT was issued to the
   * remote peer and it responded with a status code of 200.
   * @return the net socket
   */
  public NetSocket netSocket() {
    if (cached_3 != null) {
      return cached_3;
    }
    def ret = InternalHelper.safeCreate(delegate.netSocket(), io.vertx.groovy.core.net.NetSocket.class);
    cached_3 = ret;
    return ret;
  }
  private MultiMap cached_0;
  private MultiMap cached_1;
  private List<String> cached_2;
  private NetSocket cached_3;
}
