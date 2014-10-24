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
import io.vertx.groovy.core.metrics.Measured
import io.vertx.groovy.core.streams.WriteStream
import java.util.Map
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * A distributed lightweight event bus which can encompass multiple vert.x instances.
 * The event bus implements publish / subscribe, point to point messaging and request-response messaging.<p>
 * Messages sent over the event bus are represented by instances of the {@link io.vertx.core.eventbus.Message} class.<p>
 * For publish / subscribe, messages can be published to an address using one of the {@link #publish} methods. An
 * address is a simple {@code String} instance.<p>
 * Handlers are registered against an address. There can be multiple handlers registered against each address, and a particular handler can
 * be registered against multiple addresses. The event bus will route a sent message to all handlers which are
 * registered against that address.<p>
 * For point to point messaging, messages can be sent to an address using one of the {@link #send} methods.
 * The messages will be delivered to a single handler, if one is registered on that address. If more than one
 * handler is registered on the same address, Vert.x will choose one and deliver the message to that. Vert.x will
 * aim to fairly distribute messages in a round-robin way, but does not guarantee strict round-robin under all
 * circumstances.<p>
 * All messages sent over the bus are transient. On event of failure of all or part of the event bus messages
 * may be lost. Applications should be coded to cope with lost messages, e.g. by resending them, and making application
 * services idempotent.<p>
 * The order of messages received by any specific handler from a specific sender should match the order of messages
 * sent from that sender.<p>
 * When sending a message, a reply handler can be provided. If so, it will be called when the reply from the receiver
 * has been received. Reply messages can also be replied to, etc, ad infinitum<p>
 * Different event bus instances can be clustered together over a network, to give a single logical event bus.<p>
 * Instances of EventBus are thread-safe.<p>
 * If handlers are registered from an event loop, they will be executed using that same event loop. If they are
 * registered from outside an event loop (i.e. when using Vert.x embedded) then Vert.x will assign an event loop
 * to the handler and use it to deliver messages to that handler.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class EventBus implements Measured {
  final def io.vertx.core.eventbus.EventBus delegate;
  public EventBus(io.vertx.core.eventbus.EventBus delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * The metric base name
   *
   * @return the metric base name
   */
  public String metricBaseName() {
    def ret = ((io.vertx.core.metrics.Measured) this.delegate).metricBaseName();
    return ret;
  }
  /**
   * Will return the metrics that correspond with this measured object.
   *
   * @return the map of metrics where the key is the name of the metric (excluding the base name) and the value is
   * the json data representing that metric
   */
  public Map<String,JsonObject> metrics() {
    def ret = ((io.vertx.core.metrics.Measured) this.delegate).metrics();
    return ret;
  }
  /**
   * Close the EventBus and release all resources. 
   * 
   * @param completionHandler
   */
  public void close(Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.close(completionHandler);
  }
  /**
   * Send a message
   * @param address The address to send it to
   * @param message The message
   */
  public EventBus send(String address, Object message) {
    this.delegate.send(address, InternalHelper.unwrapObject(message));
    return this;
  }
  /**
   * Send a message
   * @param address The address to send it to
   * @param message The message
   * @param replyHandler Reply handler will be called when any reply from the recipient is received
   */
  public <T> EventBus send(String address, Object message, Handler<AsyncResult<Message<T>>> replyHandler) {
    this.delegate.send(address, InternalHelper.unwrapObject(message), new Handler<AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>>>() {
      public void handle(AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>> event) {
        AsyncResult<Message<Object>> f
        if (event.succeeded()) {
          f = InternalHelper.<Message<Object>>result(new Message<Object>(event.result()))
        } else {
          f = InternalHelper.<Message<Object>>failure(event.cause())
        }
        replyHandler.handle(f)
      }
    });
    return this;
  }
  public <T> EventBus send(String address, Object message, Map<String, Object> options) {
    this.delegate.send(address, InternalHelper.unwrapObject(message), options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null);
    return this;
  }
  public <T> EventBus send(String address, Object message, Map<String, Object> options, Handler<AsyncResult<Message<T>>> replyHandler) {
    this.delegate.send(address, InternalHelper.unwrapObject(message), options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>>>() {
      public void handle(AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>> event) {
        AsyncResult<Message<Object>> f
        if (event.succeeded()) {
          f = InternalHelper.<Message<Object>>result(new Message<Object>(event.result()))
        } else {
          f = InternalHelper.<Message<Object>>failure(event.cause())
        }
        replyHandler.handle(f)
      }
    });
    return this;
  }
  /**
   * Publish a message
   * @param address The address to publish it to
   * @param message The message
   */
  public EventBus publish(String address, Object message) {
    this.delegate.publish(address, InternalHelper.unwrapObject(message));
    return this;
  }
  public EventBus publish(String address, Object message, Map<String, Object> options) {
    this.delegate.publish(address, InternalHelper.unwrapObject(message), options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null);
    return this;
  }
  /**
   * Create a message consumer against the specified address. The returned consumer is not yet registered
   * at the address, registration will be effective when {@link MessageConsumer#handler(io.vertx.core.Handler)}
   * is called.
   *
   * @param address The address that will register it at
   * @return the event bus message consumer
   */
  public <T> MessageConsumer<T> consumer(String address) {
    def ret= MessageConsumer.FACTORY.apply(this.delegate.consumer(address));
    return ret;
  }
  /**
   * Create a local message consumer against the specified address. The handler info won't
   * be propagated across the cluster. The returned consumer is not yet registered at the
   * address, registration will be effective when {@link MessageConsumer#handler(io.vertx.core.Handler)}
   * is called.
   *
   * @param address The address to register it at
   * @return the event bus message consumer
   */
  public <T> MessageConsumer<T> localConsumer(String address) {
    def ret= MessageConsumer.FACTORY.apply(this.delegate.localConsumer(address));
    return ret;
  }
  /**
   * Create a message sender against the specified address. The returned sender will invoke the {@link #send(String, Object)}
   * method when the stream {@link io.vertx.core.streams.WriteStream#write(Object)} method is called with the sender
   * address and the provided data.
   *
   * @param address The address to send it to
   * @return The sender
   */
  public <T> WriteStream<T> sender(String address) {
    def ret= WriteStream.FACTORY.apply(this.delegate.sender(address));
    return ret;
  }
  /**
   * Create a message sender against the specified address. The returned sender will invoke the {@link #send(String, Object, DeliveryOptions)}
   * method when the stream {@link io.vertx.core.streams.WriteStream#write(Object)} method is called with the sender
   * address, the provided data and the sender delivery options.
   *
   * @param address The address to send it to
   * @return The sender
   */
  public <T> WriteStream<T> sender(String address, Map<String, Object> options) {
    def ret= WriteStream.FACTORY.apply(this.delegate.sender(address, options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null));
    return ret;
  }
  /**
   * Create a message publisher against the specified address. The returned publisher will invoke the {@link #publish(String, Object)}
   * method when the stream {@link io.vertx.core.streams.WriteStream#write(Object)} method is called with the publisher
   * address and the provided data.
   *
   * @param address The address to publish it to
   * @return The publisher
   */
  public <T> WriteStream<T> publisher(String address) {
    def ret= WriteStream.FACTORY.apply(this.delegate.publisher(address));
    return ret;
  }
  /**
   * Create a message publisher against the specified address. The returned publisher will invoke the {@link #publish(String, Object, DeliveryOptions)}
   * method when the stream {@link io.vertx.core.streams.WriteStream#write(Object)} method is called with the publisher
   * address, the provided data and the publisher delivery options.
   *
   * @param address The address to publish it to
   * @return The publisher
   */
  public <T> WriteStream<T> publisher(String address, Map<String, Object> options) {
    def ret= WriteStream.FACTORY.apply(this.delegate.publisher(address, options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null));
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.eventbus.EventBus, EventBus> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.eventbus.EventBus arg -> new EventBus(arg);
  };
}
