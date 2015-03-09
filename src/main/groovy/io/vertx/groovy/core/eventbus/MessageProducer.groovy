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

package io.vertx.groovy.core.eventbus;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.groovy.core.streams.WriteStream
import io.vertx.core.Handler
/**
 * Represents a stream of message that can be written to.
 * <p>
*/
@CompileStatic
public class MessageProducer<T> implements WriteStream<T> {
  final def io.vertx.core.eventbus.MessageProducer delegate;
  public MessageProducer(io.vertx.core.eventbus.MessageProducer delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using link
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) this.delegate).writeQueueFull();
    return ret;
  }
  public MessageProducer<T> exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.eventbus.MessageProducer) this.delegate).exceptionHandler(handler);
    return this;
  }
  public MessageProducer<T> write(T data) {
    ((io.vertx.core.eventbus.MessageProducer) this.delegate).write(InternalHelper.unwrapObject(data));
    return this;
  }
  public MessageProducer<T> setWriteQueueMaxSize(int maxSize) {
    ((io.vertx.core.eventbus.MessageProducer) this.delegate).setWriteQueueMaxSize(maxSize);
    return this;
  }
  public MessageProducer<T> drainHandler(Handler<Void> handler) {
    ((io.vertx.core.eventbus.MessageProducer) this.delegate).drainHandler(handler);
    return this;
  }
  /**
   * Update the delivery options of this producer.
   * @param options the new options (see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>)
   * @return this producer object
   */
  public MessageProducer<T> deliveryOptions(Map<String, Object> options = [:]) {
    ((io.vertx.core.eventbus.MessageProducer) this.delegate).deliveryOptions(options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null);
    return this;
  }
  /**
   * @return The address to which the producer produces messages.
   * @return 
   */
  public String address() {
    def ret = ((io.vertx.core.eventbus.MessageProducer) this.delegate).address();
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.eventbus.MessageProducer, MessageProducer> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.eventbus.MessageProducer arg -> new MessageProducer(arg);
  };
}
