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
 * A stream for {@link io.vertx.groovy.core.http.HttpClient} WebSocket connection.
 * <p>
 * When the connection attempt is successful, the stream handler is called back with the {@link io.vertx.groovy.core.http.WebSocket}
 * argument, immediately followed by a call to the end handler. When the connection attempt fails, the exception handler is invoked.
 * <p>
 * The connection occurs when the {@link io.vertx.groovy.core.http.WebSocketStream#handler} method is called with a non null handler, the other handlers should be
 * set before setting the handler.
*/
@CompileStatic
public class WebSocketStream implements ReadStream<WebSocket> {
  private final def io.vertx.core.http.WebSocketStream delegate;
  public WebSocketStream(Object delegate) {
    this.delegate = (io.vertx.core.http.WebSocketStream) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public WebSocketStream exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.http.WebSocketStream) delegate).exceptionHandler(handler != null ? new Handler<java.lang.Throwable>(){
      public void handle(java.lang.Throwable event) {
        handler.handle(event);
      }
    } : null);
    return this;
  }
  public WebSocketStream handler(Handler<WebSocket> handler) {
    ((io.vertx.core.http.WebSocketStream) delegate).handler(handler != null ? new Handler<io.vertx.core.http.WebSocket>(){
      public void handle(io.vertx.core.http.WebSocket event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.http.WebSocket.class));
      }
    } : null);
    return this;
  }
  public WebSocketStream pause() {
    ((io.vertx.core.http.WebSocketStream) delegate).pause();
    return this;
  }
  public WebSocketStream resume() {
    ((io.vertx.core.http.WebSocketStream) delegate).resume();
    return this;
  }
  public WebSocketStream endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.http.WebSocketStream) delegate).endHandler(endHandler != null ? new Handler<java.lang.Void>(){
      public void handle(java.lang.Void event) {
        endHandler.handle(event);
      }
    } : null);
    return this;
  }
}
