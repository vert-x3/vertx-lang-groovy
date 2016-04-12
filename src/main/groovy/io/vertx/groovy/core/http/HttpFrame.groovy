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

package io.vertx.groovy.core.http;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.buffer.Buffer
/**
 * An HTTP/2 frame.
*/
@CompileStatic
public class HttpFrame {
  private final def io.vertx.core.http.HttpFrame delegate;
  public HttpFrame(Object delegate) {
    this.delegate = (io.vertx.core.http.HttpFrame) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * @return the 8-bit type of the frame
   * @return 
   */
  public int type() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret = delegate.type();
    cached_0 = ret;
    return ret;
  }
  /**
   * @return the 8-bit flags specific to the frame
   * @return 
   */
  public int flags() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret = delegate.flags();
    cached_1 = ret;
    return ret;
  }
  /**
   * @return the frame payload
   * @return 
   */
  public Buffer payload() {
    if (cached_2 != null) {
      return cached_2;
    }
    def ret = InternalHelper.safeCreate(delegate.payload(), io.vertx.groovy.core.buffer.Buffer.class);
    cached_2 = ret;
    return ret;
  }
  private int cached_0;
  private int cached_1;
  private Buffer cached_2;
}
