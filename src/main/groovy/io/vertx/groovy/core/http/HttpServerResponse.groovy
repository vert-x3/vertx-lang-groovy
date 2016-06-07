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
import io.vertx.core.http.HttpMethod
import io.vertx.groovy.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents a server-side HTTP response.
 * <p>
 * An instance of this is created and associated to every instance of
 * {@link io.vertx.groovy.core.http.HttpServerRequest} that.
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
 * It implements {@link io.vertx.groovy.core.streams.WriteStream} so it can be used with
 * {@link io.vertx.groovy.core.streams.Pump} to pump data with flow control.
*/
@CompileStatic
public class HttpServerResponse implements WriteStream<Buffer> {
  private final def io.vertx.core.http.HttpServerResponse delegate;
  public HttpServerResponse(Object delegate) {
    this.delegate = (io.vertx.core.http.HttpServerResponse) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.http.HttpServerResponse#setWriteQueueMaxSize}
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) delegate).writeQueueFull();
    return ret;
  }
  public HttpServerResponse exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.http.HttpServerResponse) delegate).exceptionHandler(handler);
    return this;
  }
  public HttpServerResponse write(Buffer data) {
    ((io.vertx.core.http.HttpServerResponse) delegate).write(data != null ? (io.vertx.core.buffer.Buffer)data.getDelegate() : null);
    return this;
  }
  public HttpServerResponse setWriteQueueMaxSize(int maxSize) {
    ((io.vertx.core.http.HttpServerResponse) delegate).setWriteQueueMaxSize(maxSize);
    return this;
  }
  public HttpServerResponse drainHandler(Handler<Void> handler) {
    ((io.vertx.core.http.HttpServerResponse) delegate).drainHandler(handler);
    return this;
  }
  /**
   * @return the HTTP status code of the response. The default is <code>200</code> representing <code>OK</code>.
   * @return 
   */
  public int getStatusCode() {
    def ret = delegate.getStatusCode();
    return ret;
  }
  /**
   * Set the status code. If the status message hasn't been explicitly set, a default status message corresponding
   * to the code will be looked-up and used.
   * @param statusCode 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse setStatusCode(int statusCode) {
    delegate.setStatusCode(statusCode);
    return this;
  }
  /**
   * @return the HTTP status message of the response. If this is not specified a default value will be used depending on what
   * {@link io.vertx.groovy.core.http.HttpServerResponse#setStatusCode} has been set to.
   * @return 
   */
  public String getStatusMessage() {
    def ret = delegate.getStatusMessage();
    return ret;
  }
  /**
   * Set the status message
   * @param statusMessage 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse setStatusMessage(String statusMessage) {
    delegate.setStatusMessage(statusMessage);
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
    delegate.setChunked(chunked);
    return this;
  }
  /**
   * @return is the response chunked?
   * @return 
   */
  public boolean isChunked() {
    def ret = delegate.isChunked();
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
   * @param name the header name
   * @param value the header value.
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse putHeader(String name, String value) {
    delegate.putHeader(name, value);
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
    def ret = InternalHelper.safeCreate(delegate.trailers(), io.vertx.groovy.core.MultiMap.class);
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
    delegate.putTrailer(name, value);
    return this;
  }
  /**
   * Set a close handler for the response. This will be called if the underlying connection closes before the response
   * is complete.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse closeHandler(Handler<Void> handler) {
    delegate.closeHandler(handler);
    return this;
  }
  /**
   * Write a {@link java.lang.String} to the response body, encoded using the encoding <code>enc</code>.
   * @param chunk the string to write
   * @param enc the encoding to use
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse write(String chunk, String enc) {
    delegate.write(chunk, enc);
    return this;
  }
  /**
   * Write a {@link java.lang.String} to the response body, encoded in UTF-8.
   * @param chunk the string to write
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse write(String chunk) {
    delegate.write(chunk);
    return this;
  }
  /**
   * Used to write an interim 100 Continue response to signify that the client should send the rest of the request.
   * Must only be used if the request contains an "Expect:100-Continue" header
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse writeContinue() {
    delegate.writeContinue();
    return this;
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpServerResponse#end} but writes a String in UTF-8 encoding before ending the response.
   * @param chunk the string to write before ending the response
   */
  public void end(String chunk) {
    delegate.end(chunk);
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpServerResponse#end} but writes a String with the specified encoding before ending the response.
   * @param chunk the string to write before ending the response
   * @param enc the encoding to use
   */
  public void end(String chunk, String enc) {
    delegate.end(chunk, enc);
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpServerResponse#end} but writes some data to the response body before ending. If the response is not chunked and
   * no other data has been written then the @code{Content-Length} header will be automatically set.
   * @param chunk the buffer to write before ending the response
   */
  public void end(Buffer chunk) {
    ((io.vertx.core.http.HttpServerResponse) delegate).end(chunk != null ? (io.vertx.core.buffer.Buffer)chunk.getDelegate() : null);
  }
  /**
   * Ends the response. If no data has been written to the response body,
   * the actual response won't get written until this method gets called.
   * <p>
   * Once the response has ended, it cannot be used any more.
   */
  public void end() {
    ((io.vertx.core.http.HttpServerResponse) delegate).end();
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpServerResponse#sendFile} using offset @code{0} which means starting from the beginning of the file.
   * @param filename path to the file to serve
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse sendFile(String filename) {
    delegate.sendFile(filename);
    return this;
  }
  /**
   * Same as {@link io.vertx.groovy.core.http.HttpServerResponse#sendFile} using length @code{Long.MAX_VALUE} which means until the end of the
   * file.
   * @param filename path to the file to serve
   * @param offset offset to start serving from
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse sendFile(String filename, long offset) {
    delegate.sendFile(filename, offset);
    return this;
  }
  /**
   * Ask the OS to stream a file as specified by <code>filename</code> directly
   * from disk to the outgoing connection, bypassing userspace altogether
   * (where supported by the underlying operating system.
   * This is a very efficient way to serve files.<p>
   * The actual serve is asynchronous and may not complete until some time after this method has returned.
   * @param filename path to the file to serve
   * @param offset offset to start serving from
   * @param length length to serve to
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse sendFile(String filename, long offset, long length) {
    delegate.sendFile(filename, offset, length);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServerResponse#sendFile} but providing a handler which will be notified once the file has been completely
   * written to the wire.
   * @param filename path to the file to serve
   * @param resultHandler handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse sendFile(String filename, Handler<AsyncResult<Void>> resultHandler) {
    delegate.sendFile(filename, resultHandler);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServerResponse#sendFile} but providing a handler which will be notified once the file has been completely
   * written to the wire.
   * @param filename path to the file to serve
   * @param offset the offset to serve from
   * @param resultHandler handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse sendFile(String filename, long offset, Handler<AsyncResult<Void>> resultHandler) {
    delegate.sendFile(filename, offset, resultHandler);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServerResponse#sendFile} but providing a handler which will be notified once the file has been
   * completely written to the wire.
   * @param filename path to the file to serve
   * @param offset the offset to serve from
   * @param length the length to serve to
   * @param resultHandler handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse sendFile(String filename, long offset, long length, Handler<AsyncResult<Void>> resultHandler) {
    delegate.sendFile(filename, offset, length, resultHandler);
    return this;
  }
  /**
   * Close the underlying TCP connection corresponding to the request.
   */
  public void close() {
    delegate.close();
  }
  /**
   * @return has the response already ended?
   * @return 
   */
  public boolean ended() {
    def ret = delegate.ended();
    return ret;
  }
  /**
   * @return has the underlying TCP connection corresponding to the request already been closed?
   * @return 
   */
  public boolean closed() {
    def ret = delegate.closed();
    return ret;
  }
  /**
   * @return have the headers for the response already been written?
   * @return 
   */
  public boolean headWritten() {
    def ret = delegate.headWritten();
    return ret;
  }
  /**
   * Provide a handler that will be called just before the headers are written to the wire.<p>
   * This provides a hook allowing you to add any more headers or do any more operations before this occurs.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse headersEndHandler(Handler<Void> handler) {
    delegate.headersEndHandler(handler);
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
    delegate.bodyEndHandler(handler);
    return this;
  }
  /**
   * @return the total number of bytes written for the body of the response.
   * @return 
   */
  public long bytesWritten() {
    def ret = delegate.bytesWritten();
    return ret;
  }
  /**
   * @return the id of the stream of this response,  for HTTP/1.x
   * @return 
   */
  public int streamId() {
    def ret = delegate.streamId();
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServerResponse#push} with no headers.
   * @param method 
   * @param host 
   * @param path 
   * @param handler 
   * @return 
   */
  public HttpServerResponse push(HttpMethod method, String host, String path, Handler<AsyncResult<HttpServerResponse>> handler) {
    def ret = InternalHelper.safeCreate(delegate.push(method, host, path, handler != null ? new Handler<AsyncResult<io.vertx.core.http.HttpServerResponse>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpServerResponse> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.http.HttpServerResponse.class)));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null), io.vertx.groovy.core.http.HttpServerResponse.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServerResponse#push} with the host copied from the current request.
   * @param method 
   * @param path 
   * @param headers 
   * @param handler 
   * @return 
   */
  public HttpServerResponse push(HttpMethod method, String path, MultiMap headers, Handler<AsyncResult<HttpServerResponse>> handler) {
    def ret = InternalHelper.safeCreate(delegate.push(method, path, headers != null ? (io.vertx.core.MultiMap)headers.getDelegate() : null, handler != null ? new Handler<AsyncResult<io.vertx.core.http.HttpServerResponse>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpServerResponse> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.http.HttpServerResponse.class)));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null), io.vertx.groovy.core.http.HttpServerResponse.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServerResponse#push} with the host copied from the current request.
   * @param method 
   * @param path 
   * @param handler 
   * @return 
   */
  public HttpServerResponse push(HttpMethod method, String path, Handler<AsyncResult<HttpServerResponse>> handler) {
    delegate.push(method, path, handler != null ? new Handler<AsyncResult<io.vertx.core.http.HttpServerResponse>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpServerResponse> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.http.HttpServerResponse.class)));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Push a response to the client.<p/>
   *
   * The <code>handler</code> will be notified with a <i>success</i> when the push can be sent and with
   * a <i>failure</i> when the client has disabled push or reset the push before it has been sent.<p/>
   *
   * The <code>handler</code> may be queued if the client has reduced the maximum number of streams the server can push
   * concurrently.<p/>
   *
   * Push can be sent only for peer initiated streams and if the response is not ended.
   * @param method the method of the promised request
   * @param host the host of the promised request
   * @param path the path of the promised request
   * @param headers the headers of the promised request
   * @param handler the handler notified when the response can be written
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse push(HttpMethod method, String host, String path, MultiMap headers, Handler<AsyncResult<HttpServerResponse>> handler) {
    delegate.push(method, host, path, headers != null ? (io.vertx.core.MultiMap)headers.getDelegate() : null, handler != null ? new Handler<AsyncResult<io.vertx.core.http.HttpServerResponse>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpServerResponse> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.http.HttpServerResponse.class)));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Reset this HTTP/2 stream with the error code <code>0</code>.
   */
  public void reset() {
    delegate.reset();
  }
  /**
   * Reset this HTTP/2 stream with the error <code>code</code>.
   * @param code the error code
   */
  public void reset(long code) {
    delegate.reset(code);
  }
  /**
   * Write an HTTP/2 frame to the response, allowing to extend the HTTP/2 protocol.<p>
   *
   * The frame is sent immediatly and is not subject to flow control.
   * @param type the 8-bit frame type
   * @param flags the 8-bit frame flags
   * @param payload the frame payload
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServerResponse writeCustomFrame(int type, int flags, Buffer payload) {
    delegate.writeCustomFrame(type, flags, payload != null ? (io.vertx.core.buffer.Buffer)payload.getDelegate() : null);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServerResponse#writeCustomFrame} but with an {@link io.vertx.groovy.core.http.HttpFrame}.
   * @param frame the frame to write
   * @return 
   */
  public HttpServerResponse writeCustomFrame(HttpFrame frame) {
    delegate.writeCustomFrame(frame != null ? (io.vertx.core.http.HttpFrame)frame.getDelegate() : null);
    return this;
  }
  private MultiMap cached_0;
  private MultiMap cached_1;
}
