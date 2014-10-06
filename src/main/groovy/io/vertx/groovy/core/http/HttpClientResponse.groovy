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
import java.util.List
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.groovy.core.MultiMap
import io.vertx.core.Handler
import io.vertx.groovy.core.net.NetSocket
/**
 * Represents a client-side HTTP response.<p>
 * An instance is provided to the user via a {@link io.vertx.core.Handler}
 * instance that was specified when one of the HTTP method operations, or the
 * generic {@link HttpClient#request(String, String, io.vertx.core.Handler)}
 * method was called on an instance of {@link HttpClient}.<p>
 * It implements {@link io.vertx.core.streams.ReadStream} so it can be used with
 * {@link io.vertx.core.streams.Pump} to pump data with flow control.<p>
 * Instances of this class are not thread-safe.<p>
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class HttpClientResponse implements ReadStream<Buffer> {
  final def io.vertx.core.http.HttpClientResponse delegate;
  public HttpClientResponse(io.vertx.core.http.HttpClientResponse delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public HttpClientResponse resume() {
    this.delegate.resume();
    return this;
  }
  public HttpClientResponse exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler);
    return this;
  }
  public HttpClientResponse handler(Handler<Buffer> handler) {
    this.delegate.handler(new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        handler.handle(Buffer.FACTORY.apply(event));
      }
    });
    return this;
  }
  public HttpClientResponse pause() {
    this.delegate.pause();
    return this;
  }
  public HttpClientResponse endHandler(Handler<Void> endHandler) {
    this.delegate.endHandler(endHandler);
    return this;
  }
  /**
   * The HTTP status code of the response
   */
  public int statusCode() {
    def ret = this.delegate.statusCode();
    return ret;
  }
  /**
   * The HTTP status message of the response
   */
  public String statusMessage() {
    def ret = this.delegate.statusMessage();
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
   * @return The Set-Cookie headers (including trailers)
   */
  public List<String> cookies() {
    if (cached_2 != null) {
      return cached_2;
    }
    def ret = this.delegate.cookies();
    cached_2 = ret;
    return ret;
  }
  /**
   * Convenience method for receiving the entire request body in one piece. This saves the user having to manually
   * set a data and end handler and append the chunks of the body until the whole body received.
   * Don't use this if your request body is large - you could potentially run out of RAM.
   *
   * @param bodyHandler This handler will be called after all the body has been received
   */
  public HttpClientResponse bodyHandler(Handler<Buffer> bodyHandler) {
    this.delegate.bodyHandler(new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        bodyHandler.handle(Buffer.FACTORY.apply(event));
      }
    });
    return this;
  }
  /**
   * Get a net socket for the underlying connection of this request. USE THIS WITH CAUTION!
   * Writing to the socket directly if you don't know what you're doing can easily break the HTTP protocol
   *
   * One valid use-case for calling this is to receive the {@link io.vertx.core.net.NetSocket} after a HTTP CONNECT was issued to the
   * remote peer and it responded with a status code of 200.
   *
   * @return the net socket
   */
  public NetSocket netSocket() {
    if (cached_3 != null) {
      return cached_3;
    }
    def ret= NetSocket.FACTORY.apply(this.delegate.netSocket());
    cached_3 = ret;
    return ret;
  }
  private MultiMap cached_0;
  private MultiMap cached_1;
  private java.util.List<java.lang.String> cached_2;
  private NetSocket cached_3;

  static final java.util.function.Function<io.vertx.core.http.HttpClientResponse, HttpClientResponse> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.http.HttpClientResponse arg -> new HttpClientResponse(arg);
  };
}
