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
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * An event bus consumer object representing a stream of message to an {@link EventBus} address that can
 * be read from.
 * <p>
 * The {@link EventBus#consumer(String)} or {@link EventBus#localConsumer(String)}
 * creates a new consumer, the returned consumer is not yet registered against the event bus. Registration
 * is effective after the {@link #handler(io.vertx.core.Handler)} method is invoked.<p>
 *
 * The consumer is unregistered from the event bus using the {@link #unregister()} method or by calling the
 * {@link #handler(io.vertx.core.Handler)} with a null value..
 *
 * @author <a href="mailto:nscavell@redhat.com">Nick Scavelli</a>
 */
@CompileStatic
public class MessageConsumer<T> implements ReadStream<Message<T>> {
  final def io.vertx.core.eventbus.MessageConsumer delegate;
  public MessageConsumer(io.vertx.core.eventbus.MessageConsumer delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public MessageConsumer<T> exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.eventbus.MessageConsumer) this.delegate).exceptionHandler(handler);
    return this;
  }
  public MessageConsumer<T> handler(Handler<Message<T>> handler) {
    ((io.vertx.core.eventbus.MessageConsumer) this.delegate).handler(new Handler<io.vertx.core.eventbus.Message<java.lang.Object>>() {
      public void handle(io.vertx.core.eventbus.Message<java.lang.Object> event) {
        handler.handle(Message.FACTORY.apply(event));
      }
    });
    return this;
  }
  public MessageConsumer<T> pause() {
    ((io.vertx.core.eventbus.MessageConsumer) this.delegate).pause();
    return this;
  }
  public MessageConsumer<T> resume() {
    ((io.vertx.core.eventbus.MessageConsumer) this.delegate).resume();
    return this;
  }
  public MessageConsumer<T> endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.eventbus.MessageConsumer) this.delegate).endHandler(endHandler);
    return this;
  }
  /**
   * @return a read stream for the body of the message stream.
   */
  public ReadStream<T> bodyStream() {
    def ret= ReadStream.FACTORY.apply(((io.vertx.core.eventbus.MessageConsumer) this.delegate).bodyStream());
    return ret;
  }
  /**
   * @return true if the current consumer is registered
   */
  public boolean isRegistered() {
    def ret = ((io.vertx.core.eventbus.MessageConsumer) this.delegate).isRegistered();
    return ret;
  }
  /**
   * @return The address the handler was registered with.
   */
  public String address() {
    def ret = ((io.vertx.core.eventbus.MessageConsumer) this.delegate).address();
    return ret;
  }
  /**
   * Set the number of messages this registration will buffer when this stream is paused. The default
   * value is <code>0</code>. When a new value is set, buffered messages may be discarded to reach
   * the new value.
   *
   * @param maxBufferedMessages the maximum number of messages that can be buffered
   * @return this registration
   */
  public MessageConsumer<T> setMaxBufferedMessages(int maxBufferedMessages) {
    def ret= MessageConsumer.FACTORY.apply(((io.vertx.core.eventbus.MessageConsumer) this.delegate).setMaxBufferedMessages(maxBufferedMessages));
    return ret;
  }
  /**
   * @return the maximum number of messages that can be buffered when this stream is paused
   */
  public int getMaxBufferedMessages() {
    def ret = ((io.vertx.core.eventbus.MessageConsumer) this.delegate).getMaxBufferedMessages();
    return ret;
  }
  /**
   * Optional method which can be called to indicate when the registration has been propagated across the cluster.
   *
   * @param completionHandler the completion handler
   */
  public void completionHandler(Handler<AsyncResult<Void>> completionHandler) {
    ((io.vertx.core.eventbus.MessageConsumer) this.delegate).completionHandler(completionHandler);
  }
  /**
   * Unregisters the handler which created this registration
   */
  public void unregister() {
    ((io.vertx.core.eventbus.MessageConsumer) this.delegate).unregister();
  }
  /**
   * Unregisters the handler which created this registration
   *
   * @param completionHandler the handler called when the unregister is done. For example in a cluster when all nodes of the
   * event bus have been unregistered.
   */
  public void unregister(Handler<AsyncResult<Void>> completionHandler) {
    ((io.vertx.core.eventbus.MessageConsumer) this.delegate).unregister(completionHandler);
  }

  static final java.util.function.Function<io.vertx.core.eventbus.MessageConsumer, MessageConsumer> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.eventbus.MessageConsumer arg -> new MessageConsumer(arg);
  };
}
