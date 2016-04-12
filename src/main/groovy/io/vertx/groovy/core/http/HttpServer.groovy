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
  private final def io.vertx.core.http.HttpServer delegate;
  public HttpServer(Object delegate) {
    this.delegate = (io.vertx.core.http.HttpServer) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Whether the metrics are enabled for this measured object
   * @return true if the metrics are enabled
   */
  public boolean isMetricsEnabled() {
    def ret = ((io.vertx.core.metrics.Measured) delegate).isMetricsEnabled();
    return ret;
  }
  /**
   * Return the request stream for the server. As HTTP requests are received by the server,
   * instances of {@link io.vertx.groovy.core.http.HttpServerRequest} will be created and passed to the stream .
   * @return the request stream
   */
  public HttpServerRequestStream requestStream() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret = InternalHelper.safeCreate(delegate.requestStream(), io.vertx.groovy.core.http.HttpServerRequestStream.class);
    cached_0 = ret;
    return ret;
  }
  /**
   * Set the request handler for the server to <code>requestHandler</code>. As HTTP requests are received by the server,
   * instances of {@link io.vertx.groovy.core.http.HttpServerRequest} will be created and passed to this handler.
   * @param handler 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServer requestHandler(Handler<HttpServerRequest> handler) {
    delegate.requestHandler(handler != null ? new Handler<io.vertx.core.http.HttpServerRequest>(){
      public void handle(io.vertx.core.http.HttpServerRequest event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.http.HttpServerRequest.class));
      }
    } : null);
    return this;
  }
  /**
   * Set a connection handler for the server. The connection handler is called after an HTTP2 connection has
   * been negociated.
   * @param handler 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServer connectionHandler(Handler<HttpConnection> handler) {
    delegate.connectionHandler(handler != null ? new Handler<io.vertx.core.http.HttpConnection>(){
      public void handle(io.vertx.core.http.HttpConnection event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.http.HttpConnection.class));
      }
    } : null);
    return this;
  }
  /**
   * Return the websocket stream for the server. If a websocket connect handshake is successful a
   * new {@link io.vertx.groovy.core.http.ServerWebSocket} instance will be created and passed to the stream .
   * @return the websocket stream
   */
  public ServerWebSocketStream websocketStream() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret = InternalHelper.safeCreate(delegate.websocketStream(), io.vertx.groovy.core.http.ServerWebSocketStream.class);
    cached_1 = ret;
    return ret;
  }
  /**
   * Set the websocket handler for the server to <code>wsHandler</code>. If a websocket connect handshake is successful a
   * new {@link io.vertx.groovy.core.http.ServerWebSocket} instance will be created and passed to the handler.
   * @param handler 
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServer websocketHandler(Handler<ServerWebSocket> handler) {
    delegate.websocketHandler(handler != null ? new Handler<io.vertx.core.http.ServerWebSocket>(){
      public void handle(io.vertx.core.http.ServerWebSocket event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.http.ServerWebSocket.class));
      }
    } : null);
    return this;
  }
  /**
   * Tell the server to start listening. The server will listen on the port and host specified in the
   * <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
   * <p>
   * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServer listen() {
    delegate.listen();
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
    delegate.listen(port, host);
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
    delegate.listen(port, host, listenHandler != null ? new Handler<AsyncResult<io.vertx.core.http.HttpServer>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpServer> ar) {
        if (ar.succeeded()) {
          listenHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.http.HttpServer.class)));
        } else {
          listenHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServer#listen} but the server will listen on host "0.0.0.0" and port specified here ignoring
   * any value in the <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
   * @param port the port to listen on
   * @return a reference to this, so the API can be used fluently
   */
  public HttpServer listen(int port) {
    delegate.listen(port);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServer#listen} but supplying a handler that will be called when the server is actually listening (or has failed).
   * @param port the port to listen on
   * @param listenHandler the listen handler
   * @return 
   */
  public HttpServer listen(int port, Handler<AsyncResult<HttpServer>> listenHandler) {
    delegate.listen(port, listenHandler != null ? new Handler<AsyncResult<io.vertx.core.http.HttpServer>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpServer> ar) {
        if (ar.succeeded()) {
          listenHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.http.HttpServer.class)));
        } else {
          listenHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServer#listen} but supplying a handler that will be called when the server is actually listening (or has failed).
   * @param listenHandler the listen handler
   * @return 
   */
  public HttpServer listen(Handler<AsyncResult<HttpServer>> listenHandler) {
    delegate.listen(listenHandler != null ? new Handler<AsyncResult<io.vertx.core.http.HttpServer>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpServer> ar) {
        if (ar.succeeded()) {
          listenHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.http.HttpServer.class)));
        } else {
          listenHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Close the server. Any open HTTP connections will be closed.
   * <p>
   * The close happens asynchronously and the server may not be closed until some time after the call has returned.
   */
  public void close() {
    delegate.close();
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpServer#close} but supplying a handler that will be called when the server is actually closed (or has failed).
   * @param completionHandler the handler
   */
  public void close(Handler<AsyncResult<Void>> completionHandler) {
    delegate.close(completionHandler != null ? new Handler<AsyncResult<java.lang.Void>>() {
      public void handle(AsyncResult<java.lang.Void> ar) {
        if (ar.succeeded()) {
          completionHandler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          completionHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  /**
   * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
   * signifying an ephemeral port
   * @return the actual port the server is listening on.
   */
  public int actualPort() {
    def ret = delegate.actualPort();
    return ret;
  }
  private HttpServerRequestStream cached_0;
  private ServerWebSocketStream cached_1;
}
