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
import io.vertx.groovy.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents a server-side HTTP response.<p>
 * Instances of this class are created and associated to every instance of
 * {@link HttpServerRequest} that is created.<p>
 * It allows the developer to control the HTTP response that is sent back to the
 * client for a particular HTTP request. It contains methods that allow HTTP
 * headers and trailers to be set, and for a body to be written out to the response.<p>
 * It also allows files to be streamed by the kernel directly from disk to the
 * outgoing HTTP connection, bypassing user space altogether (where supported by
 * the underlying operating system). This is a very efficient way of
 * serving files from the server since buffers do not have to be read one by one
 * from the file and written to the outgoing socket.<p>
 * It implements {@link io.vertx.core.streams.WriteStream} so it can be used with
 * {@link io.vertx.core.streams.Pump} to pump data with flow control.<p>
 * Instances of this class are not thread-safe<p>
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class HttpServerResponse implements WriteStream<Buffer> {
  final def io.vertx.core.http.HttpServerResponse delegate;
  public HttpServerResponse(io.vertx.core.http.HttpServerResponse delegate) {
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
  public HttpServerResponse exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler);
    return this;
  }
  public HttpServerResponse write(Buffer data) {
    this.delegate.write((io.vertx.core.buffer.Buffer)data.getDelegate());
    return this;
  }
  public HttpServerResponse setWriteQueueMaxSize(int maxSize) {
    this.delegate.setWriteQueueMaxSize(maxSize);
    return this;
  }
  public HttpServerResponse drainHandler(Handler<Void> handler) {
    this.delegate.drainHandler(handler);
    return this;
  }
  /**
   * The HTTP status code of the response. The default is {@code 200} representing {@code OK}.
   */
  public int getStatusCode() {
    def ret = this.delegate.getStatusCode();
    return ret;
  }
  /**
   * Set the status code
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpServerResponse setStatusCode(int statusCode) {
    this.delegate.setStatusCode(statusCode);
    return this;
  }
  /**
   * The HTTP status message of the response. If this is not specified a default value will be used depending on what
   * {@link #setStatusCode} has been set to.
   */
  public String getStatusMessage() {
    def ret = this.delegate.getStatusMessage();
    return ret;
  }
  /**
   * Set the status message
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpServerResponse setStatusMessage(String statusMessage) {
    this.delegate.setStatusMessage(statusMessage);
    return this;
  }
  /**
   * If {@code chunked} is {@code true}, this response will use HTTP chunked encoding, and each call to write to the body
   * will correspond to a new HTTP chunk sent on the wire.<p>
   * If chunked encoding is used the HTTP header {@code Transfer-Encoding} with a value of {@code Chunked} will be
   * automatically inserted in the response.<p>
   * If {@code chunked} is {@code false}, this response will not use HTTP chunked encoding, and therefore if any data is written the
   * body of the response, the total size of that data must be set in the {@code Content-Length} header <b>before</b> any
   * data is written to the response body.<p>
   * An HTTP chunked response is typically used when you do not know the total size of the request body up front.
   *
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpServerResponse setChunked(boolean chunked) {
    this.delegate.setChunked(chunked);
    return this;
  }
  /**
   * Is the response chunked?
   */
  public boolean isChunked() {
    def ret = this.delegate.isChunked();
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
   * @param value The header value.
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpServerResponse putHeader(String name, String value) {
    this.delegate.putHeader(name, value);
    return this;
  }
  /**
   * @return The HTTP trailers
   */
  public MultiMap trailers() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret= MultiMap.FACTORY.apply(this.delegate.trailers());
    cached_1 = ret;
    return ret;
  }
  /**
   * Put an HTTP trailer - fluent API
   * @param name The trailer name
   * @param value The trailer value
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpServerResponse putTrailer(String name, String value) {
    this.delegate.putTrailer(name, value);
    return this;
  }
  /**
   * Set a close handler for the response. This will be called if the underlying connection closes before the response
   * is complete.
   * @param handler
   */
  public HttpServerResponse closeHandler(Handler<Void> handler) {
    this.delegate.closeHandler(handler);
    return this;
  }
  /**
   * Write a {@link String} to the response body, encoded using the encoding {@code enc}.
   *
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpServerResponse write(String chunk, String enc) {
    this.delegate.write(chunk, enc);
    return this;
  }
  /**
   * Write a {@link String} to the response body, encoded in UTF-8.
   *
   * @return A reference to this, so multiple method calls can be chained.
   */
  public HttpServerResponse write(String chunk) {
    this.delegate.write(chunk);
    return this;
  }
  /**
   * Same as {@link #end(Buffer)} but writes a String with the default encoding before ending the response.
   */
  public void end(String chunk) {
    this.delegate.end(chunk);
  }
  /**
   * Same as {@link #end(Buffer)} but writes a String with the specified encoding before ending the response.
   */
  public void end(String chunk, String enc) {
    this.delegate.end(chunk, enc);
  }
  /**
   * Same as {@link #end()} but writes some data to the response body before ending. If the response is not chunked and
   * no other data has been written then the Content-Length header will be automatically set
   */
  public void end(Buffer chunk) {
    this.delegate.end((io.vertx.core.buffer.Buffer)chunk.getDelegate());
  }
  /**
   * Ends the response. If no data has been written to the response body,
   * the actual response won't get written until this method gets called.<p>
   * Once the response has ended, it cannot be used any more.
   */
  public void end() {
    this.delegate.end();
  }
  /**
   * Tell the kernel to stream a file as specified by {@code filename} directly
   * from disk to the outgoing connection, bypassing userspace altogether
   * (where supported by the underlying operating system.
   * This is a very efficient way to serve files.<p>
   */
  public HttpServerResponse sendFile(String filename) {
    this.delegate.sendFile(filename);
    return this;
  }
  /**
   * Same as {@link #sendFile(String)} but also takes the path to a resource to serve if the resource is not found
   */
  public HttpServerResponse sendFile(String filename, String notFoundFile) {
    this.delegate.sendFile(filename, notFoundFile);
    return this;
  }
  public HttpServerResponse sendFile(String filename, Handler<AsyncResult<Void>> resultHandler) {
    this.delegate.sendFile(filename, resultHandler);
    return this;
  }
  /**
   * Same as {@link #sendFile(String, String)} but also takes a handler that will be called when the send has completed or
   * a failure has occurred
   */
  public HttpServerResponse sendFile(String filename, String notFoundFile, Handler<AsyncResult<Void>> resultHandler) {
    this.delegate.sendFile(filename, notFoundFile, resultHandler);
    return this;
  }
  /**
   * Close the underlying TCP connection
   */
  public void close() {
    this.delegate.close();
  }
  public boolean ended() {
    def ret = this.delegate.ended();
    return ret;
  }
  public boolean headWritten() {
    def ret = this.delegate.headWritten();
    return ret;
  }
  private MultiMap cached_0;
  private MultiMap cached_1;

  static final java.util.function.Function<io.vertx.core.http.HttpServerResponse, HttpServerResponse> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.http.HttpServerResponse arg -> new HttpServerResponse(arg);
  };
}
