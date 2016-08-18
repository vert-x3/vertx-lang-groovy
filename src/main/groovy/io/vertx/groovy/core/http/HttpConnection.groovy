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
import io.vertx.core.http.GoAway
import io.vertx.core.http.Http2Settings
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents an HTTP connection.
 * <p/>
 * HTTP/1.x connection provides an limited implementation, the following methods are implemented:
 * <ul>
 *   <li>{@link io.vertx.groovy.core.http.HttpConnection#close}</li>
 *   <li>{@link io.vertx.groovy.core.http.HttpConnection#closeHandler}</li>
 *   <li>{@link io.vertx.groovy.core.http.HttpConnection#exceptionHandler}</li>
 * </ul>
*/
@CompileStatic
public class HttpConnection {
  private final def io.vertx.core.http.HttpConnection delegate;
  public HttpConnection(Object delegate) {
    this.delegate = (io.vertx.core.http.HttpConnection) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * @return the current connection window size or <code>-1</code> for HTTP/1.x
   */
  public int getWindowSize() {
    def ret = delegate.getWindowSize();
    return ret;
  }
  /**
   * Update the current connection wide window size to a new size.
   * <p/>
   * Increasing this value, gives better performance when several data streams are multiplexed
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @param windowSize the new window size
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection setWindowSize(int windowSize) {
    delegate.setWindowSize(windowSize);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpConnection#goAway} with a last stream id <code>2^31-1</code>.
   * @param errorCode 
   * @return 
   */
  public HttpConnection goAway(long errorCode) {
    delegate.goAway(errorCode);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpConnection#goAway} with no buffer.
   * @param errorCode 
   * @param lastStreamId 
   * @return 
   */
  public HttpConnection goAway(long errorCode, int lastStreamId) {
    delegate.goAway(errorCode, lastStreamId);
    return this;
  }
  /**
   * Send a go away frame to the remote endpoint of the connection.
   * <p/>
   * <ul>
   *   <li>a  frame is sent to the to the remote endpoint with the <code>errorCode</code> and <code>debugData</code></li>
   *   <li>any stream created after the stream identified by <code>lastStreamId</code> will be closed</li>
   *   <li>for an  is different than <code>0</code> when all the remaining streams are closed this connection will be closed automatically</li>
   * </ul>
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @param errorCode the  error code
   * @param lastStreamId the last stream id
   * @param debugData additional debug data sent to the remote endpoint
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection goAway(long errorCode, int lastStreamId, Buffer debugData) {
    delegate.goAway(errorCode, lastStreamId, debugData != null ? (io.vertx.core.buffer.Buffer)debugData.getDelegate() : null);
    return this;
  }
  /**
   * Set an handler called when a  frame is received.
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection goAwayHandler(Handler<Map<String, Object>> handler) {
    delegate.goAwayHandler(handler != null ? new Handler<io.vertx.core.http.GoAway>(){
      public void handle(io.vertx.core.http.GoAway event) {
        handler.handle((Map<String, Object>)InternalHelper.wrapObject(event?.toJson()));
      }
    } : null);
    return this;
  }
  /**
   * Set an handler called when a  frame has been sent or received and all connections are closed.
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection shutdownHandler(Handler<Void> handler) {
    delegate.shutdownHandler(handler);
    return this;
  }
  /**
   * Initiate a connection shutdown, a go away frame is sent and the connection is closed when all current active streams
   * are closed or after a time out of 30 seconds.
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection shutdown() {
    delegate.shutdown();
    return this;
  }
  /**
   * Initiate a connection shutdown, a go away frame is sent and the connection is closed when all current streams
   * will be closed or the <code>timeout</code> is fired.
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @param timeoutMs the timeout in milliseconds
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection shutdown(long timeoutMs) {
    delegate.shutdown(timeoutMs);
    return this;
  }
  /**
   * Set a close handler. The handler will get notified when the connection is closed.
   * @param handler the handler to be notified
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection closeHandler(Handler<Void> handler) {
    delegate.closeHandler(handler);
    return this;
  }
  /**
   * Close the connection and all the currently active streams.
   * <p/>
   * An HTTP/2 connection will send a  frame before.
   */
  public void close() {
    delegate.close();
  }
  /**
   * @return the latest server settings acknowledged by the remote endpoint - this is not implemented for HTTP/1.x (see <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>)
   */
  public Map<String, Object> settings() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.settings()?.toJson());
    return ret;
  }
  /**
   * Send to the remote endpoint an update of the server settings.
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @param settings the new settings (see <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>)
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection updateSettings(Map<String, Object> settings = [:]) {
    delegate.updateSettings(settings != null ? new io.vertx.core.http.Http2Settings(io.vertx.lang.groovy.InternalHelper.toJsonObject(settings)) : null);
    return this;
  }
  /**
   * Send to the remote endpoint an update of this endpoint settings
   * <p/>
   * The <code>completionHandler</code> will be notified when the remote endpoint has acknowledged the settings.
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @param settings the new settings (see <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>)
   * @param completionHandler the handler notified when the settings have been acknowledged by the remote endpoint
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection updateSettings(Map<String, Object> settings = [:], Handler<AsyncResult<Void>> completionHandler) {
    delegate.updateSettings(settings != null ? new io.vertx.core.http.Http2Settings(io.vertx.lang.groovy.InternalHelper.toJsonObject(settings)) : null, completionHandler);
    return this;
  }
  /**
   * @return the current remote endpoint settings for this connection - this is not implemented for HTTP/1.x (see <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>)
   */
  public Map<String, Object> remoteSettings() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.remoteSettings()?.toJson());
    return ret;
  }
  /**
   * Set an handler that is called when remote endpoint <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a> are updated.
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @param handler the handler for remote endpoint settings
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection remoteSettingsHandler(Handler<Map<String, Object>> handler) {
    delegate.remoteSettingsHandler(handler != null ? new Handler<io.vertx.core.http.Http2Settings>(){
      public void handle(io.vertx.core.http.Http2Settings event) {
        handler.handle((Map<String, Object>)InternalHelper.wrapObject(event?.toJson()));
      }
    } : null);
    return this;
  }
  /**
   * Send a  frame to the remote endpoint.
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @param data the 8 bytes data of the frame
   * @param pongHandler an async result handler notified with pong reply or the failure
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection ping(Buffer data, Handler<AsyncResult<Buffer>> pongHandler) {
    delegate.ping(data != null ? (io.vertx.core.buffer.Buffer)data.getDelegate() : null, pongHandler != null ? new Handler<AsyncResult<io.vertx.core.buffer.Buffer>>() {
      public void handle(AsyncResult<io.vertx.core.buffer.Buffer> ar) {
        if (ar.succeeded()) {
          pongHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.buffer.Buffer.class)));
        } else {
          pongHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Set an handler notified when a  frame is received from the remote endpoint.
   * <p/>
   * This is not implemented for HTTP/1.x.
   * @param handler the handler to be called when a  is received
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection pingHandler(Handler<Buffer> handler) {
    delegate.pingHandler(handler != null ? new Handler<io.vertx.core.buffer.Buffer>(){
      public void handle(io.vertx.core.buffer.Buffer event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.buffer.Buffer.class));
      }
    } : null);
    return this;
  }
  /**
   * Set an handler called when a connection error happens
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection exceptionHandler(Handler<Throwable> handler) {
    delegate.exceptionHandler(handler);
    return this;
  }
}
