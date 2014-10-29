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

package io.vertx.groovy.core.streams;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
/**
 * Pumps data from a {@link ReadStream} to a {@link WriteStream} and performs flow control where necessary to
 * prevent the write stream buffer from getting overfull.<p>
 * Instances of this class read bytes from a {@link ReadStream} and write them to a {@link WriteStream}. If data
 * can be read faster than it can be written this could result in the write queue of the {@link WriteStream} growing
 * without bound, eventually causing it to exhaust all available RAM.<p>
 * To prevent this, after each write, instances of this class check whether the write queue of the {@link
 * WriteStream} is full, and if so, the {@link ReadStream} is paused, and a {@code drainHandler} is set on the
 * {@link WriteStream}. When the {@link WriteStream} has processed half of its backlog, the {@code drainHandler} will be
 * called, which results in the pump resuming the {@link ReadStream}.<p>
 * This class can be used to pump from any {@link ReadStream} to any {@link WriteStream},
 * e.g. from an {@link io.vertx.core.http.HttpServerRequest} to an {@link io.vertx.core.file.AsyncFile},
 * or from {@link io.vertx.core.net.NetSocket} to a {@link io.vertx.core.http.WebSocket}.<p>
 *
 * Instances of this class are not thread-safe.<p>
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class Pump {
  final def io.vertx.core.streams.Pump delegate;
  public Pump(io.vertx.core.streams.Pump delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Create a new {@code Pump} with the given {@code ReadStream} and {@code WriteStream}
   */
  public static <T> Pump pump(ReadStream<T> rs, WriteStream<T> ws) {
    def ret= Pump.FACTORY.apply(io.vertx.core.streams.Pump.pump((io.vertx.core.streams.ReadStream<T>)rs.getDelegate(), (io.vertx.core.streams.WriteStream<T>)ws.getDelegate()));
    return ret;
  }
  /**
   * Create a new {@code Pump} with the given {@code ReadStream} and {@code WriteStream} and
   * {@code writeQueueMaxSize}
   */
  public static <T> Pump pump(ReadStream<T> rs, WriteStream<T> ws, int writeQueueMaxSize) {
    def ret= Pump.FACTORY.apply(io.vertx.core.streams.Pump.pump((io.vertx.core.streams.ReadStream<T>)rs.getDelegate(), (io.vertx.core.streams.WriteStream<T>)ws.getDelegate(), writeQueueMaxSize));
    return ret;
  }
  /**
   * Set the write queue max size to {@code maxSize}
   */
  public Pump setWriteQueueMaxSize(int maxSize) {
    this.delegate.setWriteQueueMaxSize(maxSize);
    return this;
  }
  /**
   * Start the Pump. The Pump can be started and stopped multiple times.
   */
  public Pump start() {
    this.delegate.start();
    return this;
  }
  /**
   * Stop the Pump. The Pump can be started and stopped multiple times.
   */
  public Pump stop() {
    this.delegate.stop();
    return this;
  }
  /**
   * Return the total number of items pumped by this pump.
   */
  public int numberPumped() {
    def ret = this.delegate.numberPumped();
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.streams.Pump, Pump> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.streams.Pump arg -> new Pump(arg);
  };
}
