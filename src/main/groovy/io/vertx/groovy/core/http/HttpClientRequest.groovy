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
import io.vertx.groovy.core.MultiMap
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.groovy.core.streams.WriteStream
import io.vertx.core.http.HttpMethod
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.Handler
/**
 * Represents a client-side HTTP request.
 * <p>
 * Instances are created by an {@link io.vertx.groovy.core.http.HttpClient} instance, via one of the methods corresponding to the
 * specific HTTP methods, or the generic request methods. On creation the request will not have been written to the
 * wire.
 * <p>
 * Once a request has been obtained, headers can be set on it, and data can be written to its body if required. Once
 * you are ready to send the request, one of the {@link io.vertx.groovy.core.http.HttpClientRequest#end} methods should be called.
 * <p>
 * Nothing is actually sent until the request has been internally assigned an HTTP connection.
 * <p>
 * The {@link io.vertx.groovy.core.http.HttpClient} instance will return an instance of this class immediately, even if there are no HTTP
 * connections available in the pool. Any requests sent before a connection is assigned will be queued
 * internally and actually sent when an HTTP connection becomes available from the pool.
 * <p>
 * The headers of the request are queued for writing either when the {@link io.vertx.groovy.core.http.HttpClientRequest#end} method is called, or, when the first
 * part of the body is written, whichever occurs first.
 * <p>
 * This class supports both chunked and non-chunked HTTP.
 * <p>
 * It implements {@link io.vertx.groovy.core.streams.WriteStream} so it can be used with
 * {@link io.vertx.groovy.core.streams.Pump} to pump data with flow control.
 * <p>
 * An example of using this class is as follows:
 * <p>
*/
@CompileStatic
public class HttpClientRequest implements WriteStream<Buffer>,  ReadStream<HttpClientResponse> {
  private final def io.vertx.core.http.HttpClientRequest delegate;
  public HttpClientRequest(Object delegate) {
    this.delegate = (io.vertx.core.http.HttpClientRequest) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.http.HttpClientRequest#setWriteQueueMaxSize}
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) delegate).writeQueueFull();
    return ret;
  }
  public HttpClientRequest exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.http.HttpClientRequest) delegate).exceptionHandler(handler);
    return this;
  }
  /**
   * @throws java.lang.IllegalStateException when no response handler is set
   * @param data 
   * @return 
   */
  public HttpClientRequest write(Buffer data) {
    ((io.vertx.core.http.HttpClientRequest) delegate).write(data != null ? (io.vertx.core.buffer.Buffer)data.getDelegate() : null);
    return this;
  }
  public HttpClientRequest setWriteQueueMaxSize(int maxSize) {
    ((io.vertx.core.http.HttpClientRequest) delegate).setWriteQueueMaxSize(maxSize);
    return this;
  }
  public HttpClientRequest drainHandler(Handler<Void> handler) {
    ((io.vertx.core.http.HttpClientRequest) delegate).drainHandler(handler);
    return this;
  }
  public HttpClientRequest handler(Handler<HttpClientResponse> handler) {
    ((io.vertx.core.http.HttpClientRequest) delegate).handler(handler != null ? new Handler<io.vertx.core.http.HttpClientResponse>(){
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.http.HttpClientResponse.class));
      }
    } : null);
    return this;
  }
  public HttpClientRequest pause() {
    ((io.vertx.core.http.HttpClientRequest) delegate).pause();
    return this;
  }
  public HttpClientRequest resume() {
    ((io.vertx.core.http.HttpClientRequest) delegate).resume();
    return this;
  }
  public HttpClientRequest endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.http.HttpClientRequest) delegate).endHandler(endHandler);
    return this;
  }
  /**
   * If chunked is true then the request will be set into HTTP chunked mode
   * @param chunked true if chunked encoding
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest setChunked(boolean chunked) {
    delegate.setChunked(chunked);
    return this;
  }
  /**
   * @return Is the request chunked?
   * @return 
   */
  public boolean isChunked() {
    def ret = delegate.isChunked();
    return ret;
  }
  /**
   * The HTTP method for the request.
   * @return 
   */
  public HttpMethod method() {
    def ret = delegate.method();
    return ret;
  }
  /**
   * @return The URI of the request.
   * @return 
   */
  public String uri() {
    def ret = delegate.uri();
    return ret;
  }
  /**
   * @return The path part of the uri. For example /somepath/somemorepath/someresource.foo
   * @return 
   */
  public String path() {
    def ret = delegate.path();
    return ret;
  }
  /**
   * @return the query part of the uri. For example someparam=32&amp;someotherparam=x
   * @return 
   */
  public String query() {
    def ret = delegate.query();
    return ret;
  }
  /**
   * Set the request host.<p/>
   *
   * For HTTP2 it sets the  pseudo header otherwise it sets the  header
   * @param host 
   * @return 
   */
  public HttpClientRequest setHost(String host) {
    delegate.setHost(host);
    return this;
  }
  /**
   * @return the request host. For HTTP2 it returns the  pseudo header otherwise it returns the  header
   * @return 
   */
  public String getHost() {
    def ret = delegate.getHost();
    return ret;
  }
  /**
   * @return The HTTP headers
   * @return 
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
   * Put an HTTP header
   * @param name The header name
   * @param value The header value
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest putHeader(String name, String value) {
    delegate.putHeader(name, value);
    return this;
  }
  /**
   * Write a {@link java.lang.String} to the request body, encoded as UTF-8.
   * @param chunk 
   * @return @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest write(String chunk) {
    delegate.write(chunk);
    return this;
  }
  /**
   * Write a {@link java.lang.String} to the request body, encoded using the encoding <code>enc</code>.
   * @param chunk 
   * @param enc 
   * @return @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest write(String chunk, String enc) {
    delegate.write(chunk, enc);
    return this;
  }
  /**
   * If you send an HTTP request with the header <code>Expect</code> set to the value <code>100-continue</code>
   * and the server responds with an interim HTTP response with a status code of <code>100</code> and a continue handler
   * has been set using this method, then the <code>handler</code> will be called.
   * <p>
   * You can then continue to write data to the request body and later end it. This is normally used in conjunction with
   * the {@link io.vertx.groovy.core.http.HttpClientRequest#sendHead} method to force the request header to be written before the request has ended.
   * @param handler 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest continueHandler(Handler<Void> handler) {
    delegate.continueHandler(handler);
    return this;
  }
  /**
   * Forces the head of the request to be written before {@link io.vertx.groovy.core.http.HttpClientRequest#end} is called on the request or any data is
   * written to it.
   * <p>
   * This is normally used to implement HTTP 100-continue handling, see  for
   * more information.
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest sendHead() {
    delegate.sendHead();
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpClientRequest#sendHead} but with an handler after headers have been sent. The handler will be called with
   * the {@link io.vertx.groovy.core.http.HttpVersion} if it can be determined or null otherwise.<p>
   * @param completionHandler 
   * @return 
   */
  public HttpClientRequest sendHead(Handler<HttpVersion> completionHandler) {
    delegate.sendHead(completionHandler);
    return this;
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpClientRequest#end} but writes a String in UTF-8 encoding
   * @param chunk 
   */
  public void end(String chunk) {
    delegate.end(chunk);
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpClientRequest#end} but writes a String with the specified encoding
   * @param chunk 
   * @param enc 
   */
  public void end(String chunk, String enc) {
    delegate.end(chunk, enc);
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpClientRequest#end} but writes some data to the request body before ending. If the request is not chunked and
   * no other data has been written then the <code>Content-Length</code> header will be automatically set
   * @param chunk 
   */
  public void end(Buffer chunk) {
    ((io.vertx.core.http.HttpClientRequest) delegate).end(chunk != null ? (io.vertx.core.buffer.Buffer)chunk.getDelegate() : null);
  }
  /**
   * Ends the request. If no data has been written to the request body, and {@link io.vertx.groovy.core.http.HttpClientRequest#sendHead} has not been called then
   * the actual request won't get written until this method gets called.
   * <p>
   * Once the request has ended, it cannot be used any more,
   */
  public void end() {
    ((io.vertx.core.http.HttpClientRequest) delegate).end();
  }
  /**
   * Set's the amount of time after which if the request does not return any data within the timeout period an
   * {@link java.util.concurrent.TimeoutException} will be passed to the exception handler (if provided) and
   * the request will be closed.
   * <p>
   * Calling this method more than once has the effect of canceling any existing timeout and starting
   * the timeout from scratch.
   * @param timeoutMs The quantity of time in milliseconds.
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest setTimeout(long timeoutMs) {
    delegate.setTimeout(timeoutMs);
    return this;
  }
  /**
   * Set a push handler for this request.<p/>
   *
   * The handler is called when the client receives a <i>push promise</i> from the server. The handler can be called
   * multiple times, for each push promise.<p/>
   *
   * The handler is called with a <i>read-only</i> {@link io.vertx.groovy.core.http.HttpClientRequest}, the following methods can be called:<p/>
   *
   * <ul>
   *   <li>{@link io.vertx.groovy.core.http.HttpClientRequest#method}</li>
   *   <li>{@link io.vertx.groovy.core.http.HttpClientRequest#uri}</li>
   *   <li>{@link io.vertx.groovy.core.http.HttpClientRequest#headers}</li>
   *   <li>{@link io.vertx.groovy.core.http.HttpClientRequest#getHost}</li>
   * </ul>
   *
   * In addition the handler should call the {@link io.vertx.groovy.core.http.HttpClientRequest#handler} method to set an handler to
   * process the response.<p/>
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest pushHandler(Handler<HttpClientRequest> handler) {
    delegate.pushHandler(handler != null ? new Handler<io.vertx.core.http.HttpClientRequest>(){
      public void handle(io.vertx.core.http.HttpClientRequest event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.http.HttpClientRequest.class));
      }
    } : null);
    return this;
  }
  /**
   * Reset this stream with the error code <code>0</code>.
   */
  public void reset() {
    delegate.reset();
  }
  /**
   * Reset this stream with the error <code>code</code>.
   * @param code the error code
   */
  public void reset(long code) {
    delegate.reset(code);
  }
  /**
   * @return the {@link io.vertx.groovy.core.http.HttpConnection} associated with this request when it is an HTTP/2 connection, null otherwise
   * @return 
   */
  public HttpConnection connection() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret = InternalHelper.safeCreate(delegate.connection(), io.vertx.groovy.core.http.HttpConnection.class);
    cached_1 = ret;
    return ret;
  }
  /**
   * Set a connection handler called when an HTTP/2 connection has been established.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest connectionHandler(Handler<HttpConnection> handler) {
    delegate.connectionHandler(handler != null ? new Handler<io.vertx.core.http.HttpConnection>(){
      public void handle(io.vertx.core.http.HttpConnection event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.http.HttpConnection.class));
      }
    } : null);
    return this;
  }
  /**
   * Write an HTTP/2 frame to the request, allowing to extend the HTTP/2 protocol.<p>
   *
   * The frame is sent immediatly and is not subject to flow control.<p>
   *
   * This method must be called after the request headers have been sent and only for the protocol HTTP/2.
   * The {@link io.vertx.groovy.core.http.HttpClientRequest#sendHead} should be used for this purpose.
   * @param type the 8-bit frame type
   * @param flags the 8-bit frame flags
   * @param payload the frame payload
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest writeFrame(int type, int flags, Buffer payload) {
    delegate.writeFrame(type, flags, payload != null ? (io.vertx.core.buffer.Buffer)payload.getDelegate() : null);
    return this;
  }
  /**
   * @return the id of the stream of this response,  when it is not yet determined, i.e
   *         the request has not been yet sent or it is not supported HTTP/1.x
   * @return 
   */
  public int streamId() {
    def ret = delegate.streamId();
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpClientRequest#writeFrame} but with an {@link io.vertx.groovy.core.http.HttpFrame}.
   * @param frame the frame to write
   * @return 
   */
  public HttpClientRequest writeFrame(HttpFrame frame) {
    delegate.writeFrame(frame != null ? (io.vertx.core.http.HttpFrame)frame.getDelegate() : null);
    return this;
  }
  private MultiMap cached_0;
  private HttpConnection cached_1;
}
