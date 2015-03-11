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
import io.vertx.core.Handler
/**
 * A {@link io.vertx.groovy.core.streams.ReadStream} of {@link io.vertx.groovy.core.net.NetSocket}, used for notifying
 * socket connections to a {@link io.vertx.groovy.core.net.NetServer}.
*/
@CompileStatic
public class NetSocketStream implements ReadStream<NetSocket> {
  final def io.vertx.core.net.NetSocketStream delegate;
  public NetSocketStream(io.vertx.core.net.NetSocketStream delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public NetSocketStream exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler);
    return this;
  }
  public NetSocketStream handler(Handler<NetSocket> handler) {
    this.delegate.handler(new Handler<io.vertx.core.net.NetSocket>() {
      public void handle(io.vertx.core.net.NetSocket event) {
        handler.handle(NetSocket.FACTORY.apply(event));
      }
    });
    return this;
  }
  public NetSocketStream pause() {
    this.delegate.pause();
    return this;
  }
  public NetSocketStream resume() {
    this.delegate.resume();
    return this;
  }
  public NetSocketStream endHandler(Handler<Void> endHandler) {
    this.delegate.endHandler(endHandler);
    return this;
  }

  static final java.util.function.Function<io.vertx.core.net.NetSocketStream, NetSocketStream> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.net.NetSocketStream arg -> new NetSocketStream(arg);
  };
}
