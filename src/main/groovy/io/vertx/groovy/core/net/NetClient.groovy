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

package io.vertx.groovy.core.net;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * A TCP client.
 * <p>
 * Multiple connections to different servers can be made using the same instance.
 * <p>
 * This client supports a configurable number of connection attempts and a configurable
 * delay between attempts.
*/
@CompileStatic
public class NetClient implements Measured {
  private final def io.vertx.core.net.NetClient delegate;
  public NetClient(Object delegate) {
    this.delegate = (io.vertx.core.net.NetClient) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Whether the metrics are enabled for this measured object
   * @return true if the metrics are enabled
   */
  public boolean isMetricsEnabled() {
    def ret = ((io.vertx.core.metrics.Measured) this.delegate).isMetricsEnabled();
    return ret;
  }
  /**
   * Open a connection to a server at the specific <code>port</code> and <code>host</code>.
   * <p>
   * <code>host</code> can be a valid host name or IP address. The connect is done asynchronously and on success, a
   * {@link io.vertx.groovy.core.net.NetSocket} instance is supplied via the <code>connectHandler</code> instance
   * @param port the port
   * @param host the host
   * @param connectHandler 
   * @return a reference to this, so the API can be used fluently
   */
  public NetClient connect(int port, String host, Handler<AsyncResult<NetSocket>> connectHandler) {
    this.delegate.connect(port != null ? port : null, host != null ? host : null, connectHandler != null ? new Handler<AsyncResult<io.vertx.core.net.NetSocket>>(){
    public void handle(AsyncResult<io.vertx.core.net.NetSocket> ar) {
      connectHandler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Close the client.
   * <p>
   * Any sockets which have not been closed manually will be closed here. The close is asynchronous and may not
   * complete until some time after the method has returned.
   */
  public void close() {
    this.delegate.close();
  }
}
