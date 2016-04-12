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
/**
 *
 * Encapsulates a message being sent from Vert.x. Used with event bus interceptors
*/
@CompileStatic
public class SendContext<T> {
  private final def io.vertx.core.eventbus.SendContext delegate;
  public SendContext(Object delegate) {
    this.delegate = (io.vertx.core.eventbus.SendContext) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * @return  The message being sent
   * @return 
   */
  public Message<T> message() {
    def ret = InternalHelper.safeCreate(delegate.message(), io.vertx.groovy.core.eventbus.Message.class);
    return ret;
  }
  /**
   * Call the next interceptor
   */
  public void next() {
    delegate.next();
  }
  /**
   * @return true if the message is being sent (point to point) or False if the message is being published
   */
  public boolean send() {
    def ret = delegate.send();
    return ret;
  }
}
