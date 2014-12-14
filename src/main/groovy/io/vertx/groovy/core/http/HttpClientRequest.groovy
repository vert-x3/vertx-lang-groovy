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
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.groovy.core.streams.WriteStream
import io.vertx.core.http.HttpMethod
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.groovy.core.MultiMap
import io.vertx.core.Handler
/**
 * Represents a client-side HTTP request.<p>
 * Instances are created by an {@link HttpClient} instance, via one of the methods corresponding to the
 * specific HTTP methods, or the generic {@link HttpClient#request} method.<p>
 * Once a request has been obtained, headers can be set on it, and data can be written to its body if required. Once
 * you are ready to send the request, the {@link #end()} method should be called.<p>
 * Nothing is actually sent until the request has been internally assigned an HTTP connection. The {@link HttpClient}
 * instance will return an instance of this class immediately, even if there are no HTTP connections available in the pool. Any requests
 * sent before a connection is assigned will be queued internally and actually sent when an HTTP connection becomes
 * available from the pool.<p>
 * The headers of the request are actually sent either when the {@link #end()} method is called, or, when the first
 * part of the body is written, whichever occurs first.<p>
 * This class supports both chunked and non-chunked HTTP.<p>
 * It implements {@link io.vertx.core.streams.WriteStream} so it can be used with
 * {@link io.vertx.core.streams.Pump} to pump data with flow control.<p>
 * An example of using this class is as follows:
 * <p>
 * <pre>
 *
 * HttpClientRequest req = httpClient.post("/some-url", new Handler&lt;HttpClientResponse&gt;() {
 *   public void handle(HttpClientResponse response) {
 *     System.out.println("Got response: " + response.statusCode);
 *   }
 * });
 *
 * req.headers().put("some-header", "hello")
 *     .put("Content-Length", 5)
 *     .write(Buffer.newBuffer(new byte[]{1, 2, 3, 4, 5}))
 *     .write(Buffer.newBuffer(new byte[]{6, 7, 8, 9, 10}))
 *     .end();
 *
 * </pre>
 * Instances of HttpClientRequest are not thread-safe
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class HttpClientRequest implements WriteStream<Buffer>,  ReadStream<HttpClientResponse> {
  final def io.vertx.core.http.HttpClientRequest delegate;
  public HttpClientRequest(io.vertx.core.http.HttpClientRequest delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * This will return {@code true} if there are more bytes in the write queue than the value set using {@link
   * #setWriteQueueMaxSize}
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) this.delegate).writeQueueFull();
    return ret;
  }
  public HttpClientRequest exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler);
    return this;
  }
  /**
   * @throws java.lang.IllegalStateException when no response handler is set
   */
  public HttpClientRequest write(Buffer data) {
    this.delegate.write((io.vertx.core.buffer.Buffer)data.getDelegate());
    return this;
  }
  public HttpClientRequest setWriteQueueMaxSize(int maxSize) {
    this.delegate.setWriteQueueMaxSize(maxSize);
    return this;
  }
  public HttpClientRequest drainHandler(Handler<Void> handler) {
    this.delegate.drainHandler(handler);
    return this;
  }
  public HttpClientRequest handler(Handler<HttpClientResponse> handler) {
    this.delegate.handler(new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        handler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    });
    return this;
  }
  public HttpClientRequest pause() {
    this.delegate.pause();
    return this;
  }
  public HttpClientRequest resume() {
    this.delegate.resume();
    return this;
  }
  public HttpClientRequest endHandler(Handler<Void> endHandler) {
    this.delegate.endHandler(endHandler);
    return this;
  }
  /**
   * If chunked is true then the request will be set into HTTP chunked mode
   * @param chunked
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpClientRequest setChunked(boolean chunked) {
    this.delegate.setChunked(chunked);
    return this;
  }
  /**
   *
   * @return Is the request chunked?
   */
  public boolean isChunked() {
    def ret = this.delegate.isChunked();
    return ret;
  }
  /**
   * The HTTP method for the request. One of GET, PUT, POST, DELETE, TRACE, CONNECT, OPTIONS or HEAD
   */
  public HttpMethod method() {
    def ret = this.delegate.method();
    return ret;
  }
  /**
   * The uri of the request. For example
   * http://www.somedomain.com/somepath/somemorepath/someresource.foo?someparam=32&amp;someotherparam=x
   */
  public String uri() {
    def ret = this.delegate.uri();
    return ret;
  }
  /**
   * @return The HTTP headers
   */
  public MultiMap headers() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret= MultiMap.FACTORY.apply(this.delegate.headers());
    cached_0 = ret;
    return ret;
  }
  /**
   * Put an HTTP header - fluent API
   * @param name The header name
   * @param value The header value
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpClientRequest putHeader(String name, String value) {
    this.delegate.putHeader(name, value);
    return this;
  }
  /**
   * Write a {@link String} to the request body, encoded in UTF-8.
   *
   * @return A reference to this, so multiple method calls can be chained.
   * @throws java.lang.IllegalStateException when no response handler is set
   */
  public HttpClientRequest write(String chunk) {
    this.delegate.write(chunk);
    return this;
  }
  /**
   * Write a {@link String} to the request body, encoded using the encoding {@code enc}.
   *
   * @return A reference to this, so multiple method calls can be chained.
   * @throws java.lang.IllegalStateException when no response handler is set
   */
  public HttpClientRequest write(String chunk, String enc) {
    this.delegate.write(chunk, enc);
    return this;
  }
  /**
   * If you send an HTTP request with the header {@code Expect} set to the value {@code 100-continue}
   * and the server responds with an interim HTTP response with a status code of {@code 100} and a continue handler
   * has been set using this method, then the {@code handler} will be called.<p>
   * You can then continue to write data to the request body and later end it. This is normally used in conjunction with
   * the {@link #sendHead()} method to force the request header to be written before the request has ended.
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpClientRequest continueHandler(Handler<Void> handler) {
    this.delegate.continueHandler(handler);
    return this;
  }
  /**
   * Forces the head of the request to be written before {@link #end()} is called on the request or any data is
   * written to it. This is normally used
   * to implement HTTP 100-continue handling, see {@link #continueHandler(io.vertx.core.Handler)} for more information.
   *
   * @return A reference to this, so multiple method calls can be chained.
   * @throws java.lang.IllegalStateException when no response handler is set
   */
  public HttpClientRequest sendHead() {
    this.delegate.sendHead();
    return this;
  }
  /**
   * Same as {@link #end(Buffer)} but writes a String with the default encoding
   *
   * @throws java.lang.IllegalStateException when no response handler is set
   */
  public void end(String chunk) {
    this.delegate.end(chunk);
  }
  /**
   * Same as {@link #end(Buffer)} but writes a String with the specified encoding
   *
   * @throws java.lang.IllegalStateException when no response handler is set
   */
  public void end(String chunk, String enc) {
    this.delegate.end(chunk, enc);
  }
  /**
   * Same as {@link #end()} but writes some data to the request body before ending. If the request is not chunked and
   * no other data has been written then the Content-Length header will be automatically set
   *
   * @throws java.lang.IllegalStateException when no response handler is set
   */
  public void end(Buffer chunk) {
    this.delegate.end((io.vertx.core.buffer.Buffer)chunk.getDelegate());
  }
  /**
   * Ends the request. If no data has been written to the request body, and {@link #sendHead()} has not been called then
   * the actual request won't get written until this method gets called.<p>
   * Once the request has ended, it cannot be used any more, and if keep alive is true the underlying connection will
   * be returned to the {@link HttpClient} pool so it can be assigned to another request.
   *
   * @throws java.lang.IllegalStateException when no response handler is set
   */
  public void end() {
    this.delegate.end();
  }
  /**
   * Set's the amount of time after which if a response is not received TimeoutException()
   * will be sent to the exception handler of this request. Calling this method more than once
   * has the effect of canceling any existing timeout and starting the timeout from scratchpad.
   *
   * @param timeoutMs The quantity of time in milliseconds.
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpClientRequest setTimeout(long timeoutMs) {
    this.delegate.setTimeout(timeoutMs);
    return this;
  }
  private MultiMap cached_0;

  static final java.util.function.Function<io.vertx.core.http.HttpClientRequest, HttpClientRequest> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.http.HttpClientRequest arg -> new HttpClientRequest(arg);
  };
}
