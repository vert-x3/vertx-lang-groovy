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
  final def io.vertx.core.http.HttpClientRequest delegate;
  public HttpClientRequest(io.vertx.core.http.HttpClientRequest delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.http.HttpClientRequest#setWriteQueueMaxSize}
   * @return true if write queue is full
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
   * @param data 
   * @return 
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
   * @param chunked true if chunked encoding
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest setChunked(boolean chunked) {
    this.delegate.setChunked(chunked);
    return this;
  }
  /**
   * @return Is the request chunked?
   * @return 
   */
  public boolean isChunked() {
    def ret = this.delegate.isChunked();
    return ret;
  }
  /**
   * The HTTP method for the request.
   * @return 
   */
  public HttpMethod method() {
    def ret = this.delegate.method();
    return ret;
  }
  /**
   * @return The URI of the request.
   * @return 
   */
  public String uri() {
    def ret = this.delegate.uri();
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
    def ret= MultiMap.FACTORY.apply(this.delegate.headers());
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
    this.delegate.putHeader(name, value);
    return this;
  }
  /**
   * Write a  to the request body, encoded as UTF-8.
   * @param chunk 
   * @return @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest write(String chunk) {
    this.delegate.write(chunk);
    return this;
  }
  /**
   * Write a  to the request body, encoded using the encoding <code>enc</code>.
   * @param chunk 
   * @param enc 
   * @return @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest write(String chunk, String enc) {
    this.delegate.write(chunk, enc);
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
    this.delegate.continueHandler(handler);
    return this;
  }
  /**
   * Forces the head of the request to be written before {@link io.vertx.groovy.core.http.HttpClientRequest#end} is called on the request or any data is
   * written to it.
   * <p>
   * This is normally used to implement HTTP 100-continue handling, see {@link io.vertx.groovy.core.http.HttpClientRequest#continueHandler} for
   * more information.
   * @return a reference to this, so the API can be used fluently
   */
  public HttpClientRequest sendHead() {
    this.delegate.sendHead();
    return this;
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpClientRequest#end} but writes a String in UTF-8 encoding
   * @param chunk 
   */
  public void end(String chunk) {
    this.delegate.end(chunk);
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpClientRequest#end} but writes a String with the specified encoding
   * @param chunk 
   * @param enc 
   */
  public void end(String chunk, String enc) {
    this.delegate.end(chunk, enc);
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpClientRequest#end} but writes some data to the request body before ending. If the request is not chunked and
   * no other data has been written then the <code>Content-Length</code> header will be automatically set
   * @param chunk 
   */
  public void end(Buffer chunk) {
    this.delegate.end((io.vertx.core.buffer.Buffer)chunk.getDelegate());
  }
  /**
   * Ends the request. If no data has been written to the request body, and {@link io.vertx.groovy.core.http.HttpClientRequest#sendHead} has not been called then
   * the actual request won't get written until this method gets called.
   * <p>
   * Once the request has ended, it cannot be used any more,
   */
  public void end() {
    this.delegate.end();
  }
  /**
   * Set's the amount of time after which if a response is not received TimeoutException
   * will be sent to the exception handler of this request.
   * <p>
   *  Calling this method more than once
   * has the effect of canceling any existing timeout and starting the timeout from scratch.
   * @param timeoutMs The quantity of time in milliseconds.
   * @return a reference to this, so the API can be used fluently
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
