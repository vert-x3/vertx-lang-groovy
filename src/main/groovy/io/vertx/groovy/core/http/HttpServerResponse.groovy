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
 * Represents a server-side HTTP response.
 * <p>
 * An instance of this is created and associated to every instance of
 * link that.
 * <p>
 * It allows the developer to control the HTTP response that is sent back to the
 * client for a particular HTTP request.
 * <p>
 * It contains methods that allow HTTP headers and trailers to be set, and for a body to be written out to the response.
 * <p>
 * It also allows files to be streamed by the kernel directly from disk to the
 * outgoing HTTP connection, bypassing user space altogether (where supported by
 * the underlying operating system). This is a very efficient way of
 * serving files from the server since buffers do not have to be read one by one
 * from the file and written to the outgoing socket.
 * <p>
 * It implements link so it can be used with
 * link to pump data with flow control.
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
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using link
   * @return true if write queue is full
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
   * @return the HTTP status code of the response. The default is <code>200</code> representing <code>OK</code>.
   * @return 
   */
  public int getStatusCode() {
    def ret = this.delegate.getStatusCode();
    return ret;
  }
  /**
   * Set the status code. If the status message hasn't been explicitly set, a default status message corresponding
   * to the code will be looked-up and used.
   * @param statusCode 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse setStatusCode(int statusCode) {
    this.delegate.setStatusCode(statusCode);
    return this;
  }
  /**
   * @return the HTTP status message of the response. If this is not specified a default value will be used depending on what
   * link has been set to.
   * @return 
   */
  public String getStatusMessage() {
    def ret = this.delegate.getStatusMessage();
    return ret;
  }
  /**
   * Set the status message
   * @param statusMessage 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse setStatusMessage(String statusMessage) {
    this.delegate.setStatusMessage(statusMessage);
    return this;
  }
  /**
   * If <code>chunked</code> is <code>true</code>, this response will use HTTP chunked encoding, and each call to write to the body
   * will correspond to a new HTTP chunk sent on the wire.
   * <p>
   * If chunked encoding is used the HTTP header <code>Transfer-Encoding</code> with a value of <code>Chunked</code> will be
   * automatically inserted in the response.
   * <p>
   * If <code>chunked</code> is <code>false</code>, this response will not use HTTP chunked encoding, and therefore the total size
   * of any data that is written in the respone body must be set in the <code>Content-Length</code> header <b>before</b> any
   * data is written out.
   * <p>
   * An HTTP chunked response is typically used when you do not know the total size of the request body up front.
   * @param chunked 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse setChunked(boolean chunked) {
    this.delegate.setChunked(chunked);
    return this;
  }
  /**
   * @return is the response chunked?
   * @return 
   */
  public boolean isChunked() {
    def ret = this.delegate.isChunked();
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
   * @param name the header name
   * @param value the header value.
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse putHeader(String name, String value) {
    this.delegate.putHeader(name, value);
    return this;
  }
  /**
   * @return The HTTP trailers
   * @return 
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
   * Put an HTTP trailer
   * @param name the trailer name
   * @param value the trailer value
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse putTrailer(String name, String value) {
    this.delegate.putTrailer(name, value);
    return this;
  }
  /**
   * Set a close handler for the response. This will be called if the underlying connection closes before the response
   * is complete.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse closeHandler(Handler<Void> handler) {
    this.delegate.closeHandler(handler);
    return this;
  }
  /**
   * Write a  to the response body, encoded using the encoding <code>enc</code>.
   * @param chunk the string to write
   * @param enc the encoding to use
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse write(String chunk, String enc) {
    this.delegate.write(chunk, enc);
    return this;
  }
  /**
   * Write a  to the response body, encoded in UTF-8.
   * @param chunk the string to write
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse write(String chunk) {
    this.delegate.write(chunk);
    return this;
  }
  /**
   * Same as link but writes a String in UTF-8 encoding before ending the response.
   * @param chunk the string to write before ending the response
   */
  public void end(String chunk) {
    this.delegate.end(chunk);
  }
  /**
   * Same as link but writes a String with the specified encoding before ending the response.
   * @param chunk the string to write before ending the response
   * @param enc the encoding to use
   */
  public void end(String chunk, String enc) {
    this.delegate.end(chunk, enc);
  }
  /**
   * Same as link but writes some data to the response body before ending. If the response is not chunked and
   * no other data has been written then the @code{Content-Length} header will be automatically set.
   * @param chunk the buffer to write before ending the response
   */
  public void end(Buffer chunk) {
    this.delegate.end((io.vertx.core.buffer.Buffer)chunk.getDelegate());
  }
  /**
   * Ends the response. If no data has been written to the response body,
   * the actual response won't get written until this method gets called.
   * <p>
   * Once the response has ended, it cannot be used any more.
   */
  public void end() {
    this.delegate.end();
  }
  /**
   * Ask the OS to stream a file as specified by <code>filename</code> directly
   * from disk to the outgoing connection, bypassing userspace altogether
   * (where supported by the underlying operating system.
   * This is a very efficient way to serve files.<p>
   * The actual serve is asynchronous and may not complete until some time after this method has returned.
   * @param filename path to the file to serve
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse sendFile(String filename) {
    this.delegate.sendFile(filename);
    return this;
  }
  /**
   * Like link but providing a handler which will be notified once the file has been completely
   * written to the wire.
   * @param filename path to the file to serve
   * @param resultHandler handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse sendFile(String filename, Handler<AsyncResult<Void>> resultHandler) {
    this.delegate.sendFile(filename, resultHandler);
    return this;
  }
  /**
   * Close the underlying TCP connection corresponding to the request.
   */
  public void close() {
    this.delegate.close();
  }
  /**
   * @return has the response already ended?
   * @return 
   */
  public boolean ended() {
    def ret = this.delegate.ended();
    return ret;
  }
  /**
   * @return have the headers for the response already been written?
   * @return 
   */
  public boolean headWritten() {
    def ret = this.delegate.headWritten();
    return ret;
  }
  /**
   * Provide a handler that will be called just before the headers are written to the wire.<p>
   * This provides a hook allowing you to add any more headers or do any more operations before this occurs.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse headersEndHandler(Handler<Void> handler) {
    this.delegate.headersEndHandler(handler);
    return this;
  }
  /**
   * Provide a handler that will be called just before the last part of the body is written to the wire
   * and the response is ended.<p>
   * This provides a hook allowing you to do any more operations before this occurs.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse bodyEndHandler(Handler<Void> handler) {
    this.delegate.bodyEndHandler(handler);
    return this;
  }
  private MultiMap cached_0;
  private MultiMap cached_1;

  static final java.util.function.Function<io.vertx.core.http.HttpServerResponse, HttpServerResponse> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.http.HttpServerResponse arg -> new HttpServerResponse(arg);
  };
}
