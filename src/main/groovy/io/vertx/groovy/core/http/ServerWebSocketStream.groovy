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
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.Handler
/**
 * A {@link io.vertx.groovy.core.streams.ReadStream} of {@link io.vertx.groovy.core.http.ServerWebSocket}, used for
 * notifying web socket connections to a {@link io.vertx.groovy.core.http.HttpServer}.
*/
@CompileStatic
public class ServerWebSocketStream implements ReadStream<ServerWebSocket> {
  private final def io.vertx.core.http.ServerWebSocketStream delegate;
  public ServerWebSocketStream(Object delegate) {
    this.delegate = (io.vertx.core.http.ServerWebSocketStream) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public ServerWebSocketStream exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.streams.StreamBase) delegate).exceptionHandler(handler);
    return this;
  }
  public ServerWebSocketStream handler(Handler<ServerWebSocket> handler) {
    ((io.vertx.core.streams.ReadStream) delegate).handler(handler != null ? new Handler<io.vertx.core.http.ServerWebSocket>(){
      public void handle(io.vertx.core.http.ServerWebSocket event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.http.ServerWebSocket.class));
      }
    } : null);
    return this;
  }
  public ServerWebSocketStream pause() {
    ((io.vertx.core.streams.ReadStream) delegate).pause();
    return this;
  }
  public ServerWebSocketStream resume() {
    ((io.vertx.core.streams.ReadStream) delegate).resume();
    return this;
  }
  public ServerWebSocketStream endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.streams.ReadStream) delegate).endHandler(endHandler);
    return this;
  }
}
