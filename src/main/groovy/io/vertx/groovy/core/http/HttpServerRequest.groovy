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
import io.vertx.groovy.core.MultiMap
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.core.http.HttpMethod
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.Handler
import io.vertx.groovy.core.net.SocketAddress
import io.vertx.groovy.core.net.NetSocket
/**
 * Represents a server-side HTTP request.<p>
 * Instances are created for each request that is handled by the server
 * and is passed to the user via the {@link io.vertx.core.Handler} instance
 * registered with the {@link HttpServer} using the request stream {@link io.vertx.core.http.HttpServer#requestStream()}.<p>
 * Each instance of this class is associated with a corresponding {@link HttpServerResponse} instance via
 * the {@code response} field.<p>
 * It implements {@link io.vertx.core.streams.ReadStream} so it can be used with
 * {@link io.vertx.core.streams.Pump} to pump data with flow control.<p>
 * Instances of this class are not thread-safe<p>
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class HttpServerRequest implements ReadStream<Buffer> {
  final def io.vertx.core.http.HttpServerRequest delegate;
  public HttpServerRequest(io.vertx.core.http.HttpServerRequest delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public HttpServerRequest exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler);
    return this;
  }
  public HttpServerRequest handler(Handler<Buffer> handler) {
    this.delegate.handler(new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        handler.handle(Buffer.FACTORY.apply(event));
      }
    });
    return this;
  }
  public HttpServerRequest pause() {
    this.delegate.pause();
    return this;
  }
  public HttpServerRequest resume() {
    this.delegate.resume();
    return this;
  }
  public HttpServerRequest endHandler(Handler<Void> endHandler) {
    this.delegate.endHandler(endHandler);
    return this;
  }
  /**
   * The HTTP version of the request
   */
  public HttpVersion version() {
    def ret = this.delegate.version();
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
   * The path part of the uri. For example /somepath/somemorepath/someresource.foo
   */
  public String path() {
    def ret = this.delegate.path();
    return ret;
  }
  /**
   * The query part of the uri. For example someparam=32&amp;someotherparam=x
   */
  public String query() {
    def ret = this.delegate.query();
    return ret;
  }
  /**
   * The response. Each instance of this class has an {@link HttpServerResponse} instance attached to it. This is used
   * to send the response back to the client.
   */
  public HttpServerResponse response() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret= HttpServerResponse.FACTORY.apply(this.delegate.response());
    cached_0 = ret;
    return ret;
  }
  /**
   * A map of all headers in the request, If the request contains multiple headers with the same key, the values
   * will be concatenated together into a single header with the same key value, with each value separated by a comma,
   * as specified <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec4.html#sec4.2">here</a>.
   * The headers will be automatically lower-cased when they reach the server
   */
  public MultiMap headers() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret= MultiMap.FACTORY.apply(this.delegate.headers());
    cached_1 = ret;
    return ret;
  }
  /**
   * Returns a map of all the parameters in the request
   */
  public MultiMap params() {
    if (cached_2 != null) {
      return cached_2;
    }
    def ret= MultiMap.FACTORY.apply(this.delegate.params());
    cached_2 = ret;
    return ret;
  }
  /**
   * Return the remote (client side) address of the request
   */
  public SocketAddress remoteAddress() {
    if (cached_3 != null) {
      return cached_3;
    }
    def ret= SocketAddress.FACTORY.apply(this.delegate.remoteAddress());
    cached_3 = ret;
    return ret;
  }
  /**
   * Return the local (server side) address of the server that handles the request
   */
  public SocketAddress localAddress() {
    if (cached_4 != null) {
      return cached_4;
    }
    def ret= SocketAddress.FACTORY.apply(this.delegate.localAddress());
    cached_4 = ret;
    return ret;
  }
  /**
   * Get the absolute URI corresponding to the the HTTP request
   * @return the URI
   */
  public String absoluteURI() {
    def ret = this.delegate.absoluteURI();
    return ret;
  }
  /**
   * Convenience method for receiving the entire request body in one piece. This saves the user having to manually
   * set a data and end handler and append the chunks of the body until the whole body received.
   * Don't use this if your request body is large - you could potentially run out of RAM.
   *
   * @param bodyHandler This handler will be called after all the body has been received
   */
  public HttpServerRequest bodyHandler(Handler<Buffer> bodyHandler) {
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
   * @return the net socket
   */
  public NetSocket netSocket() {
    if (cached_5 != null) {
      return cached_5;
    }
    def ret= NetSocket.FACTORY.apply(this.delegate.netSocket());
    cached_5 = ret;
    return ret;
  }
  /**
   * Call this with true if you are expecting a multi-part form to be submitted in the request
   * This must be called before the body of the request has been received
   * @param expect
   */
  public HttpServerRequest setExpectMultipart(boolean expect) {
    this.delegate.setExpectMultipart(expect);
    return this;
  }
  public boolean isExpectMultipart() {
    def ret = this.delegate.isExpectMultipart();
    return ret;
  }
  /**
   * Set the upload handler. The handler will get notified once a new file upload was received and so allow to
   * get notified by the upload in progress.
   */
  public HttpServerRequest uploadHandler(Handler<HttpServerFileUpload> uploadHandler) {
    this.delegate.uploadHandler(new Handler<io.vertx.core.http.HttpServerFileUpload>() {
      public void handle(io.vertx.core.http.HttpServerFileUpload event) {
        uploadHandler.handle(HttpServerFileUpload.FACTORY.apply(event));
      }
    });
    return this;
  }
  /**
   * Returns a map of all form attributes which was found in the request. Be aware that this message should only get
   * called after the endHandler was notified as the map will be filled on-the-fly.
   * {@link #setExpectMultipart(boolean)} must be called first before trying to get the formAttributes
   */
  public MultiMap formAttributes() {
    if (cached_6 != null) {
      return cached_6;
    }
    def ret= MultiMap.FACTORY.apply(this.delegate.formAttributes());
    cached_6 = ret;
    return ret;
  }
  private HttpServerResponse cached_0;
  private MultiMap cached_1;
  private MultiMap cached_2;
  private SocketAddress cached_3;
  private SocketAddress cached_4;
  private NetSocket cached_5;
  private MultiMap cached_6;

  static final java.util.function.Function<io.vertx.core.http.HttpServerRequest, HttpServerRequest> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.http.HttpServerRequest arg -> new HttpServerRequest(arg);
  };
}
