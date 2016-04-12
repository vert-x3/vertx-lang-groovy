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
import io.vertx.groovy.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * A Vert.x event-bus is a light-weight distributed messaging system which allows different parts of your application,
 * or different applications and services to communicate with each in a loosely coupled way.
 * <p>
 * An event-bus supports publish-subscribe messaging, point-to-point messaging and request-response messaging.
 * <p>
 * Message delivery is best-effort and messages can be lost if failure of all or part of the event bus occurs.
 * <p>
 * Please refer to the documentation for more information on the event bus.
*/
@CompileStatic
public class EventBus implements Measured {
  private final def io.vertx.core.eventbus.EventBus delegate;
  public EventBus(Object delegate) {
    this.delegate = (io.vertx.core.eventbus.EventBus) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Whether the metrics are enabled for this measured object
   * @return true if the metrics are enabled
   */
  public boolean isMetricsEnabled() {
    def ret = ((io.vertx.core.metrics.Measured) this.delegate).isMetricsEnabled();
    return ret;
  }
  /**
   * Sends a message.
   * <p>
   * The message will be delivered to at most one of the handlers registered to the address.
   * @param address the address to send it to
   * @param message the message, may be <code>null</code>
   * @return a reference to this, so the API can be used fluently
   */
  public EventBus send(String address, Object message) {
    this.delegate.send(address != null ? address : null, message != null ? InternalHelper.unwrapObject(message) : null);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.eventbus.EventBus#send} but specifying a <code>replyHandler</code> that will be called if the recipient
   * subsequently replies to the message.
   * @param address the address to send it to
   * @param message the message, may be <code>null</code>
   * @param replyHandler reply handler will be called when any reply from the recipient is received, may be <code>null</code>
   * @return a reference to this, so the API can be used fluently
   */
  public <T> EventBus send(String address, Object message, Handler<AsyncResult<Message<T>>> replyHandler) {
    this.delegate.send(address != null ? address : null, message != null ? InternalHelper.unwrapObject(message) : null, replyHandler != null ? new Handler<AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>>>(){
    public void handle(AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>> ar) {
      replyHandler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.eventbus.EventBus#send} but specifying <code>options</code> that can be used to configure the delivery.
   * @param address the address to send it to
   * @param message the message, may be <code>null</code>
   * @param options delivery options (see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>)
   * @return a reference to this, so the API can be used fluently
   */
  public EventBus send(String address, Object message, Map<String, Object> options) {
    this.delegate.send(address != null ? address : null, message != null ? InternalHelper.unwrapObject(message) : null, options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.eventbus.EventBus#send} but specifying a <code>replyHandler</code> that will be called if the recipient
   * subsequently replies to the message.
   * @param address the address to send it to
   * @param message the message, may be <code>null</code>
   * @param options delivery options (see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>)
   * @param replyHandler reply handler will be called when any reply from the recipient is received, may be <code>null</code>
   * @return a reference to this, so the API can be used fluently
   */
  public <T> EventBus send(String address, Object message, Map<String, Object> options, Handler<AsyncResult<Message<T>>> replyHandler) {
    this.delegate.send(address != null ? address : null, message != null ? InternalHelper.unwrapObject(message) : null, options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null, replyHandler != null ? new Handler<AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>>>(){
    public void handle(AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>> ar) {
      replyHandler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Publish a message.<p>
   * The message will be delivered to all handlers registered to the address.
   * @param address the address to publish it to
   * @param message the message, may be <code>null</code>
   * @return a reference to this, so the API can be used fluently
   */
  public EventBus publish(String address, Object message) {
    this.delegate.publish(address != null ? address : null, message != null ? InternalHelper.unwrapObject(message) : null);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.eventbus.EventBus#publish} but specifying <code>options</code> that can be used to configure the delivery.
   * @param address the address to publish it to
   * @param message the message, may be <code>null</code>
   * @param options the delivery options (see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>)
   * @return a reference to this, so the API can be used fluently
   */
  public EventBus publish(String address, Object message, Map<String, Object> options) {
    this.delegate.publish(address != null ? address : null, message != null ? InternalHelper.unwrapObject(message) : null, options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null);
    return this;
  }
  /**
   * Create a message consumer against the specified address.
   * <p>
   * The returned consumer is not yet registered
   * at the address, registration will be effective when {@link io.vertx.groovy.core.eventbus.MessageConsumer#handler}
   * is called.
   * @param address the address that it will register it at
   * @return the event bus message consumer
   */
  public <T> MessageConsumer<T> consumer(String address) {
    def ret= InternalHelper.safeCreate(this.delegate.consumer(address != null ? address : null), io.vertx.groovy.core.eventbus.MessageConsumer.class);
    return ret;
  }
  /**
   * Create a consumer and register it against the specified address.
   * @param address the address that will register it at
   * @param handler the handler that will process the received messages
   * @return the event bus message consumer
   */
  public <T> MessageConsumer<T> consumer(String address, Handler<Message<T>> handler) {
    def ret= InternalHelper.safeCreate(this.delegate.consumer(address != null ? address : null, handler != null ? new Handler<io.vertx.core.eventbus.Message<java.lang.Object>>(){
    public void handle(io.vertx.core.eventbus.Message<java.lang.Object> event) {
      handler.handle(null);
    }
  }
 : null), io.vertx.groovy.core.eventbus.MessageConsumer.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.eventbus.EventBus#consumer} but the address won't be propagated across the cluster.
   * @param address the address to register it at
   * @return the event bus message consumer
   */
  public <T> MessageConsumer<T> localConsumer(String address) {
    def ret= InternalHelper.safeCreate(this.delegate.localConsumer(address != null ? address : null), io.vertx.groovy.core.eventbus.MessageConsumer.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.eventbus.EventBus#consumer} but the address won't be propagated across the cluster.
   * @param address the address that will register it at
   * @param handler the handler that will process the received messages
   * @return the event bus message consumer
   */
  public <T> MessageConsumer<T> localConsumer(String address, Handler<Message<T>> handler) {
    def ret= InternalHelper.safeCreate(this.delegate.localConsumer(address != null ? address : null, handler != null ? new Handler<io.vertx.core.eventbus.Message<java.lang.Object>>(){
    public void handle(io.vertx.core.eventbus.Message<java.lang.Object> event) {
      handler.handle(null);
    }
  }
 : null), io.vertx.groovy.core.eventbus.MessageConsumer.class);
    return ret;
  }
  /**
   * Create a message sender against the specified address.
   * <p>
   * The returned sender will invoke the {@link io.vertx.groovy.core.eventbus.EventBus#send}
   * method when the stream {@link io.vertx.groovy.core.streams.WriteStream#write} method is called with the sender
   * address and the provided data.
   * @param address the address to send it to
   * @return The sender
   */
  public <T> MessageProducer<T> sender(String address) {
    def ret= InternalHelper.safeCreate(this.delegate.sender(address != null ? address : null), io.vertx.groovy.core.eventbus.MessageProducer.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.eventbus.EventBus#sender} but specifying delivery options that will be used for configuring the delivery of
   * the message.
   * @param address the address to send it to
   * @param options the delivery options (see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>)
   * @return The sender
   */
  public <T> MessageProducer<T> sender(String address, Map<String, Object> options) {
    def ret= InternalHelper.safeCreate(this.delegate.sender(address != null ? address : null, options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null), io.vertx.groovy.core.eventbus.MessageProducer.class);
    return ret;
  }
  /**
   * Create a message publisher against the specified address.
   * <p>
   * The returned publisher will invoke the {@link io.vertx.groovy.core.eventbus.EventBus#publish}
   * method when the stream {@link io.vertx.groovy.core.streams.WriteStream#write} method is called with the publisher
   * address and the provided data.
   * @param address The address to publish it to
   * @return The publisher
   */
  public <T> MessageProducer<T> publisher(String address) {
    def ret= InternalHelper.safeCreate(this.delegate.publisher(address != null ? address : null), io.vertx.groovy.core.eventbus.MessageProducer.class);
    return ret;
  }
  /**
   * Like {@link io.vertx.groovy.core.eventbus.EventBus#publisher} but specifying delivery options that will be used for configuring the delivery of
   * the message.
   * @param address the address to publish it to
   * @param options the delivery options (see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>)
   * @return The publisher
   */
  public <T> MessageProducer<T> publisher(String address, Map<String, Object> options) {
    def ret= InternalHelper.safeCreate(this.delegate.publisher(address != null ? address : null, options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null), io.vertx.groovy.core.eventbus.MessageProducer.class);
    return ret;
  }
  /**
   * Add an interceptor that will be called whenever a message is sent from Vert.x
   * @param interceptor the interceptor
   * @return a reference to this, so the API can be used fluently
   */
  public EventBus addInterceptor(Handler<SendContext> interceptor) {
    def ret= InternalHelper.safeCreate(this.delegate.addInterceptor(interceptor != null ? new Handler<io.vertx.core.eventbus.SendContext>(){
    public void handle(io.vertx.core.eventbus.SendContext event) {
      interceptor.handle(null);
    }
  }
 : null), io.vertx.groovy.core.eventbus.EventBus.class);
    return ret;
  }
  /**
   * Remove an interceptor
   * @param interceptor the interceptor
   * @return a reference to this, so the API can be used fluently
   */
  public EventBus removeInterceptor(Handler<SendContext> interceptor) {
    def ret= InternalHelper.safeCreate(this.delegate.removeInterceptor(interceptor != null ? new Handler<io.vertx.core.eventbus.SendContext>(){
    public void handle(io.vertx.core.eventbus.SendContext event) {
      interceptor.handle(null);
    }
  }
 : null), io.vertx.groovy.core.eventbus.EventBus.class);
    return ret;
  }
}
