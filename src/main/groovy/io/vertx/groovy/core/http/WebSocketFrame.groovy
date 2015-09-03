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
 * A WebSocket frame that represents either text or binary data.
 * <p>
 * A WebSocket message is composed of one or more WebSocket frames.
 * <p>
 * If there is a just a single frame in the message then a single text or binary frame should be created with final = true.
 * <p>
 * If there are more than one frames in the message, then the first frame should be a text or binary frame with
 * final = false, followed by one or more continuation frames. The last continuation frame should have final = true.
*/
@CompileStatic
public class WebSocketFrame {
  private final def io.vertx.core.http.WebSocketFrame delegate;
  public WebSocketFrame(Object delegate) {
    this.delegate = (io.vertx.core.http.WebSocketFrame) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Create a binary WebSocket frame.
   * @param data the data for the frame
   * @param isFinal true if it's the final frame in the WebSocket message
   * @return the frame
   */
  public static WebSocketFrame binaryFrame(Buffer data, boolean isFinal) {
    def ret= InternalHelper.safeCreate(io.vertx.core.http.WebSocketFrame.binaryFrame((io.vertx.core.buffer.Buffer)data.getDelegate(), isFinal), io.vertx.groovy.core.http.WebSocketFrame.class);
    return ret;
  }
  /**
   * Create a text WebSocket frame.
   * @param str the string for the frame
   * @param isFinal true if it's the final frame in the WebSocket message
   * @return the frame
   */
  public static WebSocketFrame textFrame(String str, boolean isFinal) {
    def ret= InternalHelper.safeCreate(io.vertx.core.http.WebSocketFrame.textFrame(str, isFinal), io.vertx.groovy.core.http.WebSocketFrame.class);
    return ret;
  }
  /**
   * Create a continuation frame
   * @param data the data for the frame
   * @param isFinal true if it's the final frame in the WebSocket message
   * @return the frame
   */
  public static WebSocketFrame continuationFrame(Buffer data, boolean isFinal) {
    def ret= InternalHelper.safeCreate(io.vertx.core.http.WebSocketFrame.continuationFrame((io.vertx.core.buffer.Buffer)data.getDelegate(), isFinal), io.vertx.groovy.core.http.WebSocketFrame.class);
    return ret;
  }
  /**
   * @return true if it's a text frame
   * @return 
   */
  public boolean isText() {
    def ret = this.delegate.isText();
    return ret;
  }
  /**
   * @return true if it's a binary frame
   * @return 
   */
  public boolean isBinary() {
    def ret = this.delegate.isBinary();
    return ret;
  }
  /**
   * @return true if it's a continuation frame
   * @return 
   */
  public boolean isContinuation() {
    def ret = this.delegate.isContinuation();
    return ret;
  }
  /**
   * @return the content of this frame as a UTF-8 string and returns the
   * converted string. Only use this for text frames.
   * @return 
   */
  public String textData() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret = this.delegate.textData();
    cached_0 = ret;
    return ret;
  }
  /**
   * @return the data of the frame
   * @return 
   */
  public Buffer binaryData() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret= InternalHelper.safeCreate(this.delegate.binaryData(), io.vertx.groovy.core.buffer.Buffer.class);
    cached_1 = ret;
    return ret;
  }
  /**
   * @return true if this is the final frame.
   * @return 
   */
  public boolean isFinal() {
    def ret = this.delegate.isFinal();
    return ret;
  }
  private String cached_0;
  private Buffer cached_1;
}
