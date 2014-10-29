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
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.Handler
/**
 * A {@link io.vertx.core.streams.ReadStream} of {@link io.vertx.core.http.ServerWebSocket}, used for
 * notifying web socket connections to a {@link io.vertx.core.http.HttpServer}.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@CompileStatic
public class ServerWebSocketStream implements ReadStream<ServerWebSocket> {
  final def io.vertx.core.http.ServerWebSocketStream delegate;
  public ServerWebSocketStream(io.vertx.core.http.ServerWebSocketStream delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public ServerWebSocketStream exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler);
    return this;
  }
  public ServerWebSocketStream handler(Handler<ServerWebSocket> handler) {
    this.delegate.handler(new Handler<io.vertx.core.http.ServerWebSocket>() {
      public void handle(io.vertx.core.http.ServerWebSocket event) {
        handler.handle(ServerWebSocket.FACTORY.apply(event));
      }
    });
    return this;
  }
  public ServerWebSocketStream pause() {
    this.delegate.pause();
    return this;
  }
  public ServerWebSocketStream resume() {
    this.delegate.resume();
    return this;
  }
  public ServerWebSocketStream endHandler(Handler<Void> endHandler) {
    this.delegate.endHandler(endHandler);
    return this;
  }

  static final java.util.function.Function<io.vertx.core.http.ServerWebSocketStream, ServerWebSocketStream> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.http.ServerWebSocketStream arg -> new ServerWebSocketStream(arg);
  };
}
