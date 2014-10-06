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
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * A TCP/SSL client.<p>
 * Multiple connections to different servers can be made using the same instance.<p>
 * This client supports a configurable number of connection attempts and a configurable
 * delay between attempts.<p>
 * If an instance is instantiated from an event loop then the handlers
 * of the instance will always be called on that same event loop.
 * If an instance is instantiated from some other arbitrary Java thread (i.e. when using embedded) then
 * an event loop will be assigned to the instance and used when any of its handlers
 * are called.<p>
 * Instances of this class are thread-safe.<p>
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class NetClient {
  final def io.vertx.core.net.NetClient delegate;
  public NetClient(io.vertx.core.net.NetClient delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Attempt to open a connection to a server at the specific {@code port} and {@code host}.
   * {@code host} can be a valid host name or IP address. The connect is done asynchronously and on success, a
   * {@link NetSocket} instance is supplied via the {@code connectHandler} instance
   * @return a reference to this so multiple method calls can be chained together
   */
  public NetClient connect(int port, String host, Handler<AsyncResult<NetSocket>> connectHandler) {
    this.delegate.connect(port, host, new Handler<AsyncResult<io.vertx.core.net.NetSocket>>() {
      public void handle(AsyncResult<io.vertx.core.net.NetSocket> event) {
        AsyncResult<NetSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<NetSocket>result(new NetSocket(event.result()))
        } else {
          f = InternalHelper.<NetSocket>failure(event.cause())
        }
        connectHandler.handle(f)
      }
    });
    return this;
  }
  /**
   * Close the client. Any sockets which have not been closed manually will be closed here.
   */
  public void close() {
    this.delegate.close();
  }

  static final java.util.function.Function<io.vertx.core.net.NetClient, NetClient> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.net.NetClient arg -> new NetClient(arg);
  };
}
