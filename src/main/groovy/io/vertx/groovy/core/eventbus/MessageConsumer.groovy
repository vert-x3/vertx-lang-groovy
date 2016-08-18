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
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * An event bus consumer object representing a stream of message to an {@link io.vertx.groovy.core.eventbus.EventBus} address that can
 * be read from.
 * <p>
 * The {@link io.vertx.groovy.core.eventbus.EventBus#consumer} or {@link io.vertx.groovy.core.eventbus.EventBus#localConsumer}
 * creates a new consumer, the returned consumer is not yet registered against the event bus. Registration
 * is effective after the {@link io.vertx.groovy.core.eventbus.MessageConsumer#handler} method is invoked.<p>
 *
 * The consumer is unregistered from the event bus using the {@link io.vertx.groovy.core.eventbus.MessageConsumer#unregister} method or by calling the
 * {@link io.vertx.groovy.core.eventbus.MessageConsumer#handler} with a null value..
*/
@CompileStatic
public class MessageConsumer<T> implements ReadStream<Message<T>> {
  private final def io.vertx.core.eventbus.MessageConsumer delegate;
  public MessageConsumer(Object delegate) {
    this.delegate = (io.vertx.core.eventbus.MessageConsumer) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public MessageConsumer<T> exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.streams.StreamBase) delegate).exceptionHandler(handler);
    return this;
  }
  public MessageConsumer<T> handler(Handler<Message<T>> handler) {
    ((io.vertx.core.streams.ReadStream) delegate).handler(handler != null ? new Handler<io.vertx.core.eventbus.Message<java.lang.Object>>(){
      public void handle(io.vertx.core.eventbus.Message<java.lang.Object> event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.eventbus.Message.class));
      }
    } : null);
    return this;
  }
  public MessageConsumer<T> pause() {
    ((io.vertx.core.streams.ReadStream) delegate).pause();
    return this;
  }
  public MessageConsumer<T> resume() {
    ((io.vertx.core.streams.ReadStream) delegate).resume();
    return this;
  }
  public MessageConsumer<T> endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.streams.ReadStream) delegate).endHandler(endHandler);
    return this;
  }
  /**
   * @return a read stream for the body of the message stream.
   */
  public ReadStream<T> bodyStream() {
    def ret = InternalHelper.safeCreate(delegate.bodyStream(), io.vertx.groovy.core.streams.ReadStreamImpl.class);
    return ret;
  }
  /**
   * @return true if the current consumer is registered
   */
  public boolean isRegistered() {
    def ret = delegate.isRegistered();
    return ret;
  }
  /**
   * @return The address the handler was registered with.
   */
  public String address() {
    def ret = delegate.address();
    return ret;
  }
  /**
   * Set the number of messages this registration will buffer when this stream is paused. The default
   * value is <code>0</code>. When a new value is set, buffered messages may be discarded to reach
   * the new value.
   * @param maxBufferedMessages the maximum number of messages that can be buffered
   * @return this registration
   */
  public MessageConsumer<T> setMaxBufferedMessages(int maxBufferedMessages) {
    def ret = InternalHelper.safeCreate(delegate.setMaxBufferedMessages(maxBufferedMessages), io.vertx.groovy.core.eventbus.MessageConsumer.class);
    return ret;
  }
  /**
   * @return the maximum number of messages that can be buffered when this stream is paused
   */
  public int getMaxBufferedMessages() {
    def ret = delegate.getMaxBufferedMessages();
    return ret;
  }
  /**
   * Optional method which can be called to indicate when the registration has been propagated across the cluster.
   * @param completionHandler the completion handler
   */
  public void completionHandler(Handler<AsyncResult<Void>> completionHandler) {
    delegate.completionHandler(completionHandler);
  }
  /**
   * Unregisters the handler which created this registration
   */
  public void unregister() {
    delegate.unregister();
  }
  /**
   * Unregisters the handler which created this registration
   * @param completionHandler the handler called when the unregister is done. For example in a cluster when all nodes of the event bus have been unregistered.
   */
  public void unregister(Handler<AsyncResult<Void>> completionHandler) {
    delegate.unregister(completionHandler);
  }
}
