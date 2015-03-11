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
import io.vertx.groovy.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents a message that is received from the event bus in a handler.
 * <p>
 * Messages have a {@link io.vertx.groovy.core.eventbus.Message#body}, which can be null, and also {@link io.vertx.groovy.core.eventbus.Message#headers}, which can be empty.
 * <p>
 * If the message was sent specifying a reply handler it will also have a {@link io.vertx.groovy.core.eventbus.Message#replyAddress}. In that case the message
 * can be replied to using that reply address, or, more simply by just using {@link io.vertx.groovy.core.eventbus.Message#reply}.
 * <p>
 * If you want to notify the sender that processing failed, then {@link io.vertx.groovy.core.eventbus.Message#fail} can be called.
*/
@CompileStatic
public class Message<T> {
  final def io.vertx.core.eventbus.Message delegate;
  public Message(io.vertx.core.eventbus.Message delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * The address the message was sent to
   * @return 
   */
  public String address() {
    def ret = ((io.vertx.core.eventbus.Message) this.delegate).address();
    return ret;
  }
  /**
   * Multi-map of message headers. Can be empty
   * @return the headers
   */
  public MultiMap headers() {
    def ret= MultiMap.FACTORY.apply(((io.vertx.core.eventbus.Message) this.delegate).headers());
    return ret;
  }
  /**
   * The body of the message. Can be null.
   * @return the body, or null.
   */
  public T body() {
    if (cached_0 != null) {
      return cached_0;
    }
    // This cast is cleary flawed
    def ret = (T) InternalHelper.wrapObject(((io.vertx.core.eventbus.Message) this.delegate).body());
    cached_0 = ret;
    return ret;
  }
  /**
   * The reply address. Can be null.
   * @return the reply address, or null, if message was sent without a reply handler.
   */
  public String replyAddress() {
    def ret = ((io.vertx.core.eventbus.Message) this.delegate).replyAddress();
    return ret;
  }
  /**
   * Reply to this message.
   * <p>
   * If the message was sent specifying a reply handler, that handler will be
   * called when it has received a reply. If the message wasn't sent specifying a receipt handler
   * this method does nothing.
   * @param message the message to reply with.
   */
  public void reply(Object message) {
    ((io.vertx.core.eventbus.Message) this.delegate).reply(InternalHelper.unwrapObject(message));
  }
  /**
   * The same as <code>reply(R message)</code> but you can specify handler for the reply - i.e.
   * to receive the reply to the reply.
   * @param message the message to reply with.
   * @param replyHandler the reply handler for the reply.
   */
  public <R> void reply(Object message, Handler<AsyncResult<Message<R>>> replyHandler) {
    ((io.vertx.core.eventbus.Message) this.delegate).reply(InternalHelper.unwrapObject(message), new Handler<AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>>>() {
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
  }
  /**
   * Link {@link io.vertx.groovy.core.eventbus.Message#reply} but allows you to specify delivery options for the reply.
   * @param message the reply message
   * @param options the delivery options (see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>)
   */
  public void reply(Object message, Map<String, Object> options) {
    ((io.vertx.core.eventbus.Message) this.delegate).reply(InternalHelper.unwrapObject(message), options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null);
  }
  /**
   * The same as <code>reply(R message, DeliveryOptions)</code> but you can specify handler for the reply - i.e.
   * to receive the reply to the reply.
   * @param message the reply message
   * @param options the delivery options (see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>)
   * @param replyHandler the reply handler for the reply.
   */
  public <R> void reply(Object message, Map<String, Object> options, Handler<AsyncResult<Message<R>>> replyHandler) {
    ((io.vertx.core.eventbus.Message) this.delegate).reply(InternalHelper.unwrapObject(message), options != null ? new io.vertx.core.eventbus.DeliveryOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<AsyncResult<io.vertx.core.eventbus.Message<java.lang.Object>>>() {
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
  }
  /**
   * Signal to the sender that processing of this message failed.
   * <p>
   * If the message was sent specifying a result handler
   * the handler will be called with a failure corresponding to the failure code and message specified here.
   * @param failureCode A failure code to pass back to the sender
   * @param message A message to pass back to the sender
   */
  public void fail(int failureCode, String message) {
    ((io.vertx.core.eventbus.Message) this.delegate).fail(failureCode, message);
  }
  private T cached_0;

  static final java.util.function.Function<io.vertx.core.eventbus.Message, Message> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.eventbus.Message arg -> new Message(arg);
  };
}
