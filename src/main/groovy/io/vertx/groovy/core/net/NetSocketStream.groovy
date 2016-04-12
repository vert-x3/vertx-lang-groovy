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
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.Handler
/**
 * A {@link io.vertx.groovy.core.streams.ReadStream} of {@link io.vertx.groovy.core.net.NetSocket}, used for notifying
 * socket connections to a {@link io.vertx.groovy.core.net.NetServer}.
*/
@CompileStatic
public class NetSocketStream implements ReadStream<NetSocket> {
  private final def io.vertx.core.net.NetSocketStream delegate;
  public NetSocketStream(Object delegate) {
    this.delegate = (io.vertx.core.net.NetSocketStream) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public NetSocketStream exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.net.NetSocketStream) delegate).exceptionHandler(handler);
    return this;
  }
  public NetSocketStream handler(Handler<NetSocket> handler) {
    ((io.vertx.core.net.NetSocketStream) delegate).handler(handler != null ? new Handler<io.vertx.core.net.NetSocket>(){
      public void handle(io.vertx.core.net.NetSocket event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.net.NetSocket.class));
      }
    } : null);
    return this;
  }
  public NetSocketStream pause() {
    ((io.vertx.core.net.NetSocketStream) delegate).pause();
    return this;
  }
  public NetSocketStream resume() {
    ((io.vertx.core.net.NetSocketStream) delegate).resume();
    return this;
  }
  public NetSocketStream endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.net.NetSocketStream) delegate).endHandler(endHandler);
    return this;
  }
}
