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
import io.vertx.core.json.JsonObject
/**
 * Pumps data from a {@link io.vertx.groovy.core.streams.ReadStream} to a {@link io.vertx.groovy.core.streams.WriteStream} and performs flow control where necessary to
 * prevent the write stream buffer from getting overfull.
 * <p>
 * Instances of this class read items from a {@link io.vertx.groovy.core.streams.ReadStream} and write them to a {@link io.vertx.groovy.core.streams.WriteStream}. If data
 * can be read faster than it can be written this could result in the write queue of the {@link io.vertx.groovy.core.streams.WriteStream} growing
 * without bound, eventually causing it to exhaust all available RAM.
 * <p>
 * To prevent this, after each write, instances of this class check whether the write queue of the {@link io.vertx.groovy.core.streams.WriteStream} is full, and if so, the {@link io.vertx.groovy.core.streams.ReadStream} is paused, and a <code>drainHandler</code> is set on the
 * {@link io.vertx.groovy.core.streams.WriteStream}.
 * <p>
 * When the {@link io.vertx.groovy.core.streams.WriteStream} has processed half of its backlog, the <code>drainHandler</code> will be
 * called, which results in the pump resuming the {@link io.vertx.groovy.core.streams.ReadStream}.
 * <p>
 * This class can be used to pump from any {@link io.vertx.groovy.core.streams.ReadStream} to any {@link io.vertx.groovy.core.streams.WriteStream},
 * e.g. from an {@link io.vertx.groovy.core.http.HttpServerRequest} to an {@link io.vertx.groovy.core.file.AsyncFile},
 * or from {@link io.vertx.groovy.core.net.NetSocket} to a {@link io.vertx.groovy.core.http.WebSocket}.
 * <p>
 * Please see the documentation for more information.
*/
@CompileStatic
public class Pump {
  private final def io.vertx.core.streams.Pump delegate;
  public Pump(Object delegate) {
    this.delegate = (io.vertx.core.streams.Pump) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Create a new <code>Pump</code> with the given <code>ReadStream</code> and <code>WriteStream</code>
   * @param rs the read stream
   * @param ws the write stream
   * @return the pump
   */
  public static <T> Pump pump(ReadStream<T> rs, WriteStream<T> ws) {
    def ret= InternalHelper.safeCreate(io.vertx.core.streams.Pump.pump((io.vertx.core.streams.ReadStream<T>)rs.getDelegate(), (io.vertx.core.streams.WriteStream<T>)ws.getDelegate()), io.vertx.groovy.core.streams.Pump.class);
    return ret;
  }
  /**
   * Create a new <code>Pump</code> with the given <code>ReadStream</code> and <code>WriteStream</code> and
   * <code>writeQueueMaxSize</code>
   * @param rs the read stream
   * @param ws the write stream
   * @param writeQueueMaxSize the max size of the write queue
   * @return the pump
   */
  public static <T> Pump pump(ReadStream<T> rs, WriteStream<T> ws, int writeQueueMaxSize) {
    def ret= InternalHelper.safeCreate(io.vertx.core.streams.Pump.pump((io.vertx.core.streams.ReadStream<T>)rs.getDelegate(), (io.vertx.core.streams.WriteStream<T>)ws.getDelegate(), writeQueueMaxSize), io.vertx.groovy.core.streams.Pump.class);
    return ret;
  }
  /**
   * Set the write queue max size to <code>maxSize</code>
   * @param maxSize the max size
   * @return a reference to this, so the API can be used fluently
   */
  public Pump setWriteQueueMaxSize(int maxSize) {
    this.delegate.setWriteQueueMaxSize(maxSize);
    return this;
  }
  /**
   * Start the Pump. The Pump can be started and stopped multiple times.
   * @return a reference to this, so the API can be used fluently
   */
  public Pump start() {
    this.delegate.start();
    return this;
  }
  /**
   * Stop the Pump. The Pump can be started and stopped multiple times.
   * @return a reference to this, so the API can be used fluently
   */
  public Pump stop() {
    this.delegate.stop();
    return this;
  }
  /**
   * Return the total number of items pumped by this pump.
   * @return 
   */
  public int numberPumped() {
    def ret = this.delegate.numberPumped();
    return ret;
  }
}
