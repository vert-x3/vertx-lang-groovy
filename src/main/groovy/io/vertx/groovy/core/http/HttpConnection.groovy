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
 * Represents an HTTP/2 connection.<p/>
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
   * Like {@link io.vertx.groovy.core.http.HttpConnection#goAway} with a last stream id <code>2^31-1</code>.
   * @param errorCode 
   * @return 
   */
  public HttpConnection goAway(long errorCode) {
    this.delegate.goAway(errorCode);
    return this;
  }
  /**
   * Like {@link io.vertx.groovy.core.http.HttpConnection#goAway} with no buffer.
   * @param errorCode 
   * @param lastStreamId 
   * @return 
   */
  public HttpConnection goAway(long errorCode, int lastStreamId) {
    this.delegate.goAway(errorCode, lastStreamId);
    return this;
  }
  /**
   * Send a go away frame to the remote endpoint of the connection.<p/>
   *
   * <ul>
   *   <li>a  frame is sent to the to the remote endpoint with the <code>errorCode</code> and {@@code debugData}</li>
   *   <li>any stream created after the stream identified by <code>lastStreamId</code> will be closed</li>
   *   <li>for an  is different than  when all the remaining streams are closed this connection will be closed automatically</li>
   * </ul>
   * @param errorCode the  error code
   * @param lastStreamId the last stream id
   * @param debugData additional debug data sent to the remote endpoint
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection goAway(long errorCode, int lastStreamId, Buffer debugData) {
    this.delegate.goAway(errorCode, lastStreamId, (io.vertx.core.buffer.Buffer)debugData.getDelegate());
    return this;
  }
  /**
   * Set an handler called when a  frame is received.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection goAwayHandler(Handler<Map<String, Object>> handler) {
    this.delegate.goAwayHandler(new Handler<GoAway>() {
      public void handle(GoAway event) {
        handler.handle((Map<String, Object>)InternalHelper.wrapObject(event?.toJson()));
      }
    });
    return this;
  }
  /**
   * Set an handler called when a  frame has been sent or received and all connections are closed.
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection shutdownHandler(Handler<Void> handler) {
    this.delegate.shutdownHandler(handler);
    return this;
  }
  /**
   * Initiate a connection shutdown, a go away frame is sent and the connection is closed when all current active streams
   * are closed or after a time out of 30 seconds.
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection shutdown() {
    this.delegate.shutdown();
    return this;
  }
  /**
   * Initiate a connection shutdown, a go away frame is sent and the connection is closed when all current streams
   * will be closed or the <code>timeout</code> is fired.
   * @param timeoutMs the timeout in milliseconds
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection shutdown(long timeoutMs) {
    this.delegate.shutdown(timeoutMs);
    return this;
  }
  /**
   * Set a close handler. The handler will get notified when the connection is closed.
   * @param handler the handler to be notified
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection closeHandler(Handler<Void> handler) {
    this.delegate.closeHandler(handler);
    return this;
  }
  /**
   * Close the connection and all the currently active streams. A  frame will be sent before.<p/>
   */
  public void close() {
    this.delegate.close();
  }
  /**
   * @return the latest server settings acknowledged by the remote endpoint
   * @return  (see <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>)
   */
  public Map<String, Object> settings() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(this.delegate.settings()?.toJson());
    return ret;
  }
  /**
   * Send to the remote endpoint an update of the server settings.
   * @param settings the new settings (see <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>)
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection updateSettings(Map<String, Object> settings = [:]) {
    this.delegate.updateSettings(settings != null ? new io.vertx.core.http.Http2Settings(new io.vertx.core.json.JsonObject(settings)) : null);
    return this;
  }
  /**
   * Send to the remote endpoint an update of this endpoint settings.<p/>
   *
   * The <code>completionHandler</code> will be notified when the remote endpoint has acknowledged the settings.
   * @param settings the new settings (see <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>)
   * @param completionHandler the handler notified when the settings have been acknowledged by the remote endpoint
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection updateSettings(Map<String, Object> settings = [:], Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.updateSettings(settings != null ? new io.vertx.core.http.Http2Settings(new io.vertx.core.json.JsonObject(settings)) : null, completionHandler);
    return this;
  }
  /**
   * @return the current remote endpoint settings for this connection
   * @return  (see <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>)
   */
  public Map<String, Object> remoteSettings() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(this.delegate.remoteSettings()?.toJson());
    return ret;
  }
  /**
   * Set an handler that is called when remote endpoint <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a> are updated.
   * @param handler the handler for remote endpoint settings
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection remoteSettingsHandler(Handler<Map<String, Object>> handler) {
    this.delegate.remoteSettingsHandler(new Handler<Http2Settings>() {
      public void handle(Http2Settings event) {
        handler.handle((Map<String, Object>)InternalHelper.wrapObject(event?.toJson()));
      }
    });
    return this;
  }
  /**
   * Send a  frame to the remote endpoint.
   * @param data the 8 bytes data of the frame
   * @param pongHandler an async result handler notified with pong reply or the failure
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection ping(Buffer data, Handler<AsyncResult<Buffer>> pongHandler) {
    this.delegate.ping((io.vertx.core.buffer.Buffer)data.getDelegate(), new Handler<AsyncResult<io.vertx.core.buffer.Buffer>>() {
      public void handle(AsyncResult<io.vertx.core.buffer.Buffer> event) {
        AsyncResult<Buffer> f
        if (event.succeeded()) {
          f = InternalHelper.<Buffer>result(new Buffer(event.result()))
        } else {
          f = InternalHelper.<Buffer>failure(event.cause())
        }
        pongHandler.handle(f)
      }
    });
    return this;
  }
  /**
   * Set an handler notified when a  frame is received from the remote endpoint.
   * @param handler the handler to be called when a  is received
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection pingHandler(Handler<Buffer> handler) {
    this.delegate.pingHandler(new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        handler.handle(new io.vertx.groovy.core.buffer.Buffer(event));
      }
    });
    return this;
  }
  /**
   * Set an handler called when a connection error happens
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  public HttpConnection exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler);
    return this;
  }
}
