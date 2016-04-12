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

package io.vertx.groovy.core.net;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents a TCP server
*/
@CompileStatic
public class NetServer implements Measured {
  private final def io.vertx.core.net.NetServer delegate;
  public NetServer(Object delegate) {
    this.delegate = (io.vertx.core.net.NetServer) delegate;
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
   * Return the connect stream for this server. The server can only have at most one handler at any one time.
   * As the server accepts TCP or SSL connections it creates an instance of {@link io.vertx.groovy.core.net.NetSocket} and passes it to the
   * connect stream .
   * @return the connect stream
   */
  public NetSocketStream connectStream() {
    def ret = InternalHelper.safeCreate(delegate.connectStream(), io.vertx.groovy.core.net.NetSocketStream.class);
    return ret;
  }
  /**
   * Supply a connect handler for this server. The server can only have at most one connect handler at any one time.
   * As the server accepts TCP or SSL connections it creates an instance of {@link io.vertx.groovy.core.net.NetSocket} and passes it to the
   * connect handler.
   * @param handler 
   * @return a reference to this, so the API can be used fluently
   */
  public NetServer connectHandler(Handler<NetSocket> handler) {
    def ret = InternalHelper.safeCreate(delegate.connectHandler(handler != null ? new Handler<io.vertx.core.net.NetSocket>(){
      public void handle(io.vertx.core.net.NetSocket event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.net.NetSocket.class));
      }
    } : null), io.vertx.groovy.core.net.NetServer.class);
    return ret;
  }
  /**
   * Start listening on the port and host as configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
   * creating the server.
   * <p>
   * The server may not be listening until some time after the call to listen has returned.
   * @return a reference to this, so the API can be used fluently
   */
  public NetServer listen() {
    delegate.listen();
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.net.NetServer#listen} but providing a handler that will be notified when the server is listening, or fails.
   * @param listenHandler handler that will be notified when listening or failed
   * @return a reference to this, so the API can be used fluently
   */
  public NetServer listen(Handler<AsyncResult<NetServer>> listenHandler) {
    delegate.listen(listenHandler != null ? new Handler<AsyncResult<io.vertx.core.net.NetServer>>() {
      public void handle(AsyncResult<io.vertx.core.net.NetServer> ar) {
        if (ar.succeeded()) {
          listenHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.net.NetServer.class)));
        } else {
          listenHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Start listening on the specified port and host, ignoring post and host configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
   * creating the server.
   * <p>
   * Port <code>0</code> can be specified meaning "choose an random port".
   * <p>
   * Host <code>0.0.0.0</code> can be specified meaning "listen on all available interfaces".
   * <p>
   * The server may not be listening until some time after the call to listen has returned.
   * @param port 
   * @param host 
   * @return a reference to this, so the API can be used fluently
   */
  public NetServer listen(int port, String host) {
    delegate.listen(port, host);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.net.NetServer#listen} but providing a handler that will be notified when the server is listening, or fails.
   * @param port the port to listen on
   * @param host the host to listen on
   * @param listenHandler handler that will be notified when listening or failed
   * @return a reference to this, so the API can be used fluently
   */
  public NetServer listen(int port, String host, Handler<AsyncResult<NetServer>> listenHandler) {
    delegate.listen(port, host, listenHandler != null ? new Handler<AsyncResult<io.vertx.core.net.NetServer>>() {
      public void handle(AsyncResult<io.vertx.core.net.NetServer> ar) {
        if (ar.succeeded()) {
          listenHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.net.NetServer.class)));
        } else {
          listenHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Start listening on the specified port and host "0.0.0.0", ignoring post and host configured in the
   * <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when creating the server.
   * <p>
   * Port <code>0</code> can be specified meaning "choose an random port".
   * <p>
   * The server may not be listening until some time after the call to listen has returned.
   * @param port 
   * @return a reference to this, so the API can be used fluently
   */
  public NetServer listen(int port) {
    delegate.listen(port);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.net.NetServer#listen} but providing a handler that will be notified when the server is listening, or fails.
   * @param port the port to listen on
   * @param listenHandler handler that will be notified when listening or failed
   * @return a reference to this, so the API can be used fluently
   */
  public NetServer listen(int port, Handler<AsyncResult<NetServer>> listenHandler) {
    delegate.listen(port, listenHandler != null ? new Handler<AsyncResult<io.vertx.core.net.NetServer>>() {
      public void handle(AsyncResult<io.vertx.core.net.NetServer> ar) {
        if (ar.succeeded()) {
          listenHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.net.NetServer.class)));
        } else {
          listenHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Close the server. This will close any currently open connections. The close may not complete until after this
   * method has returned.
   */
  public void close() {
    delegate.close();
  }
  /**
   * Like {@link io.vertx.groovy.core.net.NetServer#close} but supplying a handler that will be notified when close is complete.
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
}
