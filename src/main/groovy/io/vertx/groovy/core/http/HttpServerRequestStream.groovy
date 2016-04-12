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
 * A {@link io.vertx.groovy.core.streams.ReadStream} of {@link io.vertx.groovy.core.http.HttpServerRequest}, used for
 * notifying http request to a {@link io.vertx.groovy.core.http.HttpServer}.
*/
@CompileStatic
public class HttpServerRequestStream implements ReadStream<HttpServerRequest> {
  private final def io.vertx.core.http.HttpServerRequestStream delegate;
  public HttpServerRequestStream(Object delegate) {
    this.delegate = (io.vertx.core.http.HttpServerRequestStream) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public HttpServerRequestStream exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.http.HttpServerRequestStream) delegate).exceptionHandler(handler != null ? new Handler<java.lang.Throwable>(){
      public void handle(java.lang.Throwable event) {
        handler.handle(event);
      }
    } : null);
    return this;
  }
  public HttpServerRequestStream handler(Handler<HttpServerRequest> handler) {
    ((io.vertx.core.http.HttpServerRequestStream) delegate).handler(handler != null ? new Handler<io.vertx.core.http.HttpServerRequest>(){
      public void handle(io.vertx.core.http.HttpServerRequest event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.http.HttpServerRequest.class));
      }
    } : null);
    return this;
  }
  public HttpServerRequestStream pause() {
    ((io.vertx.core.http.HttpServerRequestStream) delegate).pause();
    return this;
  }
  public HttpServerRequestStream resume() {
    ((io.vertx.core.http.HttpServerRequestStream) delegate).resume();
    return this;
  }
  public HttpServerRequestStream endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.http.HttpServerRequestStream) delegate).endHandler(endHandler != null ? new Handler<java.lang.Void>(){
      public void handle(java.lang.Void event) {
        endHandler.handle(event);
      }
    } : null);
    return this;
  }
}
