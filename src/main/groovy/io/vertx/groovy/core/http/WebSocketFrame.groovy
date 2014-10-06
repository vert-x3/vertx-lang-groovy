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
import io.vertx.groovy.core.buffer.Buffer
/**
 * A Web Socket frame that represents either text or binary data.
 *
 * @author <a href="http://www.jboss.org/netty/">The Netty Project</a>
 * @author <a href="http://gleamynode.net/">Trustin Lee</a>
 * @author <a href="http://tfox.org">Tim Fox</a>
 * @version $Rev: 2080 $, $Date: 2010-01-26 18:04:19 +0900 (Tue, 26 Jan 2010) $
 */
@CompileStatic
public class WebSocketFrame {
  final def io.vertx.core.http.WebSocketFrame delegate;
  public WebSocketFrame(io.vertx.core.http.WebSocketFrame delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public static WebSocketFrame binaryFrame(Buffer data, boolean isFinal) {
    def ret= WebSocketFrame.FACTORY.apply(io.vertx.core.http.WebSocketFrame.binaryFrame((io.vertx.core.buffer.Buffer)data.getDelegate(), isFinal));
    return ret;
  }
  public static WebSocketFrame textFrame(String str, boolean isFinal) {
    def ret= WebSocketFrame.FACTORY.apply(io.vertx.core.http.WebSocketFrame.textFrame(str, isFinal));
    return ret;
  }
  public static WebSocketFrame continuationFrame(Buffer data, boolean isFinal) {
    def ret= WebSocketFrame.FACTORY.apply(io.vertx.core.http.WebSocketFrame.continuationFrame((io.vertx.core.buffer.Buffer)data.getDelegate(), isFinal));
    return ret;
  }
  /**
   * Returns {@code true} if and only if the content of this frame is a string
   * encoded in UTF-8.
   */
  public boolean isText() {
    def ret = this.delegate.isText();
    return ret;
  }
  /**
   * Returns {@code true} if and only if the content of this frame is an
   * arbitrary binary data.
   */
  public boolean isBinary() {
    def ret = this.delegate.isBinary();
    return ret;
  }
  public boolean isContinuation() {
    def ret = this.delegate.isContinuation();
    return ret;
  }
  /**
   * Converts the content of this frame into a UTF-8 string and returns the
   * converted string.
   */
  public String textData() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret = this.delegate.textData();
    cached_0 = ret;
    return ret;
  }
  public Buffer binaryData() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret= Buffer.FACTORY.apply(this.delegate.binaryData());
    cached_1 = ret;
    return ret;
  }
  /**
   * Returns {@code true} if this is the final frame.  This should be {@code true} unless a number of 
   * coninuation frames are expected to follow this frame.
   */
  public boolean isFinal() {
    def ret = this.delegate.isFinal();
    return ret;
  }
  private java.lang.String cached_0;
  private Buffer cached_1;

  static final java.util.function.Function<io.vertx.core.http.WebSocketFrame, WebSocketFrame> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.http.WebSocketFrame arg -> new WebSocketFrame(arg);
  };
}
