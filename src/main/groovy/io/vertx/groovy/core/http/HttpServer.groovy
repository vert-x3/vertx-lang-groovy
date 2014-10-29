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
import java.util.Map
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * An HTTP and WebSockets server<p>
 * If an instance is instantiated from an event loop then the handlers
 * of the instance will always be called on that same event loop.
 * If an instance is instantiated from some other arbitrary Java thread then
 * an event loop will be assigned to the instance and used when any of its handlers
 * are called.<p>
 * Instances of HttpServer are thread-safe.<p>
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
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
   * The metric base name
   *
   * @return the metric base name
   */
  public String metricBaseName() {
    def ret = ((io.vertx.core.metrics.Measured) this.delegate).metricBaseName();
    return ret;
  }
  /**
   * Will return the metrics that correspond with this measured object.
   *
   * @return the map of metrics where the key is the name of the metric (excluding the base name) and the value is
   * the json data representing that metric
   */
  public Map<String,JsonObject> metrics() {
    def ret = ((io.vertx.core.metrics.Measured) this.delegate).metrics();
    return ret;
  }
  /**
   * Return the request stream for the server. As HTTP requests are received by the server,
   * instances of {@link HttpServerRequest} will be created and passed to this stream {@link io.vertx.core.streams.ReadStream#handler(io.vertx.core.Handler)}.
   *
   * @return the request stream
   */
  public HttpServerRequestStream requestStream() {
    def ret= HttpServerRequestStream.FACTORY.apply(this.delegate.requestStream());
    return ret;
  }
  /**
   * Set the request handler for the server to {@code requestHandler}. As HTTP requests are received by the server,
   * instances of {@link HttpServerRequest} will be created and passed to this handler.
   *
   * @return a reference to this, so methods can be chained.
   */
  public HttpServer requestHandler(Handler<HttpServerRequest> handler) {
    def ret= HttpServer.FACTORY.apply(this.delegate.requestHandler(new Handler<io.vertx.core.http.HttpServerRequest>() {
      public void handle(io.vertx.core.http.HttpServerRequest event) {
        handler.handle(HttpServerRequest.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  /**
   * Return the websocket stream for the server. If a websocket connect handshake is successful a
   * new {@link ServerWebSocket} instance will be created and passed to this stream {@link io.vertx.core.streams.ReadStream#handler(io.vertx.core.Handler)}.
   *
   * @return the websocket stream
   */
  public ServerWebSocketStream websocketStream() {
    def ret= ServerWebSocketStream.FACTORY.apply(this.delegate.websocketStream());
    return ret;
  }
  /**
   * Set the websocket handler for the server to {@code wsHandler}. If a websocket connect handshake is successful a
   * new {@link ServerWebSocket} instance will be created and passed to the handler.
   *
   * @return a reference to this, so methods can be chained.
   */
  public HttpServer websocketHandler(Handler<ServerWebSocket> handler) {
    def ret= HttpServer.FACTORY.apply(this.delegate.websocketHandler(new Handler<io.vertx.core.http.ServerWebSocket>() {
      public void handle(io.vertx.core.http.ServerWebSocket event) {
        handler.handle(ServerWebSocket.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpServer listen() {
    this.delegate.listen();
    return this;
  }
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
   */
  public void close() {
    this.delegate.close();
  }
  /**
   * Close the server. Any open HTTP connections will be closed. The {@code completionHandler} will be called when the close
   * is complete.
   */
  public void close(Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.close(completionHandler);
  }

  static final java.util.function.Function<io.vertx.core.http.HttpServer, HttpServer> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.http.HttpServer arg -> new HttpServer(arg);
  };
}
