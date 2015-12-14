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
import io.vertx.core.json.JsonObject
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.groovy.core.streams.WriteStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents a stream of message that can be written to.
 * <p>
*/
@CompileStatic
public class MessageProducer<T> implements WriteStream<T> {
  private final def io.vertx.core.eventbus.MessageProducer delegate;
  public MessageProducer(Object delegate) {
    this.delegate = (io.vertx.core.eventbus.MessageProducer) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Same as {@link io.vertx.groovy.core.eventbus.MessageProducer#end} but writes some data to the stream before ending.
   * @param t 
   */
  public void end(T t) {
    ((io.vertx.core.streams.WriteStream) this.delegate).end(InternalHelper.unwrapObject(t));
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.eventbus.MessageProducer#setWriteQueueMaxSize}
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) this.delegate).writeQueueFull();
    return ret;
  }
  /**
   * Synonym for {@link io.vertx.groovy.core.eventbus.MessageProducer#write}.
   * @param message the message to send
   * @return reference to this for fluency
   */
  public MessageProducer<T> send(T message) {
    def ret= InternalHelper.safeCreate(this.delegate.send(InternalHelper.unwrapObject(message)), io.vertx.groovy.core.eventbus.MessageProducer.class);
    return ret;
  }
  public <R> MessageProducer<T> send(T message, Handler<AsyncResult<Message<R>>> replyHandler) {
    def ret= InternalHelper.safeCreate(this.delegate.send(InternalHelper.unwrapObject(message), new Handler<AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>>>() {
      public void handle(AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>> event) {
        AsyncResult<Message<Object>> f
        if (event.succeeded()) {
          f = InternalHelper.<Message<Object>>result(new Message<Object>(event.result()))
        } else {
          f = InternalHelper.<Message<Object>>failure(event.cause())
        }
        replyHandler.handle(f)
      }
    }), io.vertx.groovy.core.eventbus.MessageProducer.class);
    return ret;
  }
  public MessageProducer<T> exceptionHandler(Handler<Throwable> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.streams.WriteStream) this.delegate).exceptionHandler(handler);
    return this;
  }
  public MessageProducer<T> write(T data) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.streams.WriteStream) this.delegate).write(InternalHelper.unwrapObject(data));
    return this;
  }
  public MessageProducer<T> setWriteQueueMaxSize(int maxSize) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.streams.WriteStream) this.delegate).setWriteQueueMaxSize(maxSize);
    return this;
  }
  public MessageProducer<T> drainHandler(Handler<Void> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.streams.WriteStream) this.delegate).drainHandler(handler);
    return this;
  }
  /**
   * Update the delivery options of this producer.
   * @param options the new options (see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>)
   * @return this producer object
   */
  public MessageProducer<T> deliveryOptions(Map<String, Object> options = [:]) {
    this.delegate.deliveryOptions(options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null);
    return this;
  }
  /**
   * @return The address to which the producer produces messages.
   * @return 
   */
  public String address() {
    def ret = this.delegate.address();
    return ret;
  }
  /**
   * Closes the producer, calls {@link io.vertx.groovy.core.eventbus.MessageProducer#close}
   */
  public void end() {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.streams.WriteStream) this.delegate).end();
  }
  /**
   * Closes the producer, this method should be called when the message producer is not used anymore.
   */
  public void close() {
    this.delegate.close();
  }
}
