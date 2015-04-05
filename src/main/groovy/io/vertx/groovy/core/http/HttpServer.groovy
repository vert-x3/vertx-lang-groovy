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
import io.vertx.groovy.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * An HTTP and WebSockets server.
 * <p>
 * You receive HTTP requests by providing a {@link io.vertx.groovy.core.http.HttpServer#requestHandler}. As requests arrive on the server the handler
 * will be called with the requests.
 * <p>
 * You receive WebSockets by providing a {@link io.vertx.groovy.core.http.HttpServer#websocketHandler}. As WebSocket connections arrive on the server, the
 * WebSocket is passed to the handler.
*/
@CompileStatic
public class HttpServer implements Measured {
  final def io.vertx.core.http.HttpServer delegate;
  public HttpServer(io.vertx.core.http.HttpServer delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Whether the metrics are enabled for this measured object
   * @return true if the metrics are enabled
   */
  public boolean isMetricsEnabled() {
    def ret = ((io.vertx.core.metrics.Measured) this.delegate).isMetricsEnabled();
    return ret;
  }
  /**
   * Return the request stream for the server. As HTTP requests are received by the server,
   * instances of {@link io.vertx.groovy.core.http.HttpServerRequest} will be created and passed to the stream {@link io.vertx.groovy.core.streams.ReadStream#handler}.
   * @return the request stream
   */
  public HttpServerRequestStream requestStream() {
    def ret= new io.vertx.groovy.core.http.HttpServerRequestStream(this.delegate.requestStream());
    return ret;
  }
  /**
   * Set the request handler for the server to <code>requestHandler</code>. As HTTP requests are received by the server,
   * instances of {@link io.vertx.groovy.core.http.HttpServerRequest} will be created and passed to this handler.
   * @param handler 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServer requestHandler(Handler<HttpServerRequest> handler) {
    def ret= new io.vertx.groovy.core.http.HttpServer(this.delegate.requestHandler(new Handler<io.vertx.core.http.HttpServerRequest>() {
      public void handle(io.vertx.core.http.HttpServerRequest event) {
        handler.handle(new io.vertx.groovy.core.http.HttpServerRequest(event));
      }
    }));
    return ret;
  }
  /**
   * Return the websocket stream for the server. If a websocket connect handshake is successful a
   * new {@link io.vertx.groovy.core.http.ServerWebSocket} instance will be created and passed to the stream {@link io.vertx.groovy.core.streams.ReadStream#handler}.
   * @return the websocket stream
   */
  public ServerWebSocketStream websocketStream() {
    def ret= new io.vertx.groovy.core.http.ServerWebSocketStream(this.delegate.websocketStream());
    return ret;
  }
  /**
   * Set the websocket handler for the server to <code>wsHandler</code>. If a websocket connect handshake is successful a
   * new {@link io.vertx.groovy.core.http.ServerWebSocket} instance will be created and passed to the handler.
   * @param handler 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServer websocketHandler(Handler<ServerWebSocket> handler) {
    def ret= new io.vertx.groovy.core.http.HttpServer(this.delegate.websocketHandler(new Handler<io.vertx.core.http.ServerWebSocket>() {
      public void handle(io.vertx.core.http.ServerWebSocket event) {
        handler.handle(new io.vertx.groovy.core.http.ServerWebSocket(event));
      }
    }));
    return ret;
  }
  /**
   * Tell the server to start listening. The server will listen on the port and host specified in the
   * <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
   * <p>
   * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServer listen() {
    this.delegate.listen();
    return this;
  }
  /**
   * Tell the server to start listening. The server will listen on the port and host specified here,
   * ignoring any value set in the <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
   * <p>
   * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
   * @param port the port to listen on
   * @param host the host to listen on
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServer listen(int port, String host) {
    this.delegate.listen(port, host);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServer#listen} but supplying a handler that will be called when the server is actually
   * listening (or has failed).
   * @param port the port to listen on
   * @param host the host to listen on
   * @param listenHandler the listen handler
   * @return 
   */
  public HttpServer listen(int port, String host, Handler<AsyncResult<HttpServer>> listenHandler) {
    this.delegate.listen(port, host, new Handler<AsyncResult<io.vertx.core.http.HttpServer>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpServer> event) {
        AsyncResult<HttpServer> f
        if (event.succeeded()) {
          f = InternalHelper.<HttpServer>result(new HttpServer(event.result()))
        } else {
          f = InternalHelper.<HttpServer>failure(event.cause())
        }
        listenHandler.handle(f)
      }
    });
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServer#listen} but the server will listen on host "0.0.0.0" and port specified here ignoring
   * any value in the <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
   * @param port the port to listen on
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServer listen(int port) {
    this.delegate.listen(port);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServer#listen} but supplying a handler that will be called when the server is actually listening (or has failed).
   * @param port the port to listen on
   * @param listenHandler the listen handler
   * @return 
   */
  public HttpServer listen(int port, Handler<AsyncResult<HttpServer>> listenHandler) {
    this.delegate.listen(port, new Handler<AsyncResult<io.vertx.core.http.HttpServer>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpServer> event) {
        AsyncResult<HttpServer> f
        if (event.succeeded()) {
          f = InternalHelper.<HttpServer>result(new HttpServer(event.result()))
        } else {
          f = InternalHelper.<HttpServer>failure(event.cause())
        }
        listenHandler.handle(f)
      }
    });
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServer#listen} but supplying a handler that will be called when the server is actually listening (or has failed).
   * @param listenHandler the listen handler
   * @return 
   */
  public HttpServer listen(Handler<AsyncResult<HttpServer>> listenHandler) {
    this.delegate.listen(new Handler<AsyncResult<io.vertx.core.http.HttpServer>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpServer> event) {
        AsyncResult<HttpServer> f
        if (event.succeeded()) {
          f = InternalHelper.<HttpServer>result(new HttpServer(event.result()))
        } else {
          f = InternalHelper.<HttpServer>failure(event.cause())
        }
        listenHandler.handle(f)
      }
    });
    return this;
  }
  /**
   * Close the server. Any open HTTP connections will be closed.
   * <p>
   * The close happens asynchronously and the server may not be closed until some time after the call has returned.
   */
  public void close() {
    this.delegate.close();
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServer#close} but supplying a handler that will be called when the server is actually closed (or has failed).
   * @param completionHandler the handler
   */
  public void close(Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.close(completionHandler);
  }
}
