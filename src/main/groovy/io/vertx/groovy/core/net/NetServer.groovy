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
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents a TCP or SSL server<p>
 * If an instance is instantiated from an event loop then the handlers
 * of the instance will always be called on that same event loop.
 * If an instance is instantiated from some other arbitrary Java thread (i.e. when running embedded) then
 * and event loop will be assigned to the instance and used when any of its handlers
 * are called.<p>
 * Instances of this class are thread-safe.<p>
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class NetServer {
  final def io.vertx.core.net.NetServer delegate;
  public NetServer(io.vertx.core.net.NetServer delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Return the connect stream for this server. The server can only have at most one handler at any one time.
   * As the server accepts TCP or SSL connections it creates an instance of {@link NetSocket} and passes it to the
   * connect stream {@link ReadStream#handler(io.vertx.core.Handler)}.
   *
   * @return the connect stream
   */
  public ReadStream<NetSocket> connectStream() {
    def ret= ReadStream.FACTORY.apply(this.delegate.connectStream());
    return ret;
  }
  /**
   * Supply a connect handler for this server. The server can only have at most one connect handler at any one time.
   * As the server accepts TCP or SSL connections it creates an instance of {@link NetSocket} and passes it to the
   * connect handler.
   * @return a reference to this so multiple method calls can be chained together
   */
  public NetServer connectHandler(Handler<NetSocket> handler) {
    def ret= NetServer.FACTORY.apply(this.delegate.connectHandler(new Handler<io.vertx.core.net.NetSocket>() {
      public void handle(io.vertx.core.net.NetSocket event) {
        handler.handle(NetSocket.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public NetServer listen() {
    this.delegate.listen();
    return this;
  }
  /**
   * Instruct the server to listen for incoming connections on the specified {@code port} and all available interfaces.
   */
  public NetServer listen(Handler<AsyncResult<NetServer>> listenHandler) {
    this.delegate.listen(new Handler<AsyncResult<io.vertx.core.net.NetServer>>() {
      public void handle(AsyncResult<io.vertx.core.net.NetServer> event) {
        AsyncResult<NetServer> f
        if (event.succeeded()) {
          f = InternalHelper.<NetServer>result(new NetServer(event.result()))
        } else {
          f = InternalHelper.<NetServer>failure(event.cause())
        }
        listenHandler.handle(f)
      }
    });
    return this;
  }
  /**
   * Close the server. This will close any currently open connections.
   */
  public void close() {
    this.delegate.close();
  }
  /**
   * Close the server. This will close any currently open connections. The event handler {@code done} will be called
   * when the close is complete.
   */
  public void close(Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.close(completionHandler);
  }
  /**
   * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
   * signifying an ephemeral port
   */
  public int actualPort() {
    def ret = this.delegate.actualPort();
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.net.NetServer, NetServer> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.net.NetServer arg -> new NetServer(arg);
  };
}
