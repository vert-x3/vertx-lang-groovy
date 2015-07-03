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

package io.vertx.groovy.core.datagram;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.groovy.core.net.SocketAddress
/**
 * A received datagram packet (UDP) which contains the data and information about the sender of the data itself.
*/
@CompileStatic
public class DatagramPacket {
  private final def io.vertx.core.datagram.DatagramPacket delegate;
  public DatagramPacket(Object delegate) {
    this.delegate = (io.vertx.core.datagram.DatagramPacket) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Returns the {@link io.vertx.groovy.core.net.SocketAddress} of the sender that sent
   * this {@link io.vertx.groovy.core.datagram.DatagramPacket}.
   * @return the address of the sender
   */
  public SocketAddress sender() {
    def ret= InternalHelper.safeCreate(this.delegate.sender(), io.vertx.groovy.core.net.SocketAddress.class);
    return ret;
  }
  /**
   * Returns the data of the {@link io.vertx.groovy.core.datagram.DatagramPacket}
   * @return the data
   */
  public Buffer data() {
    def ret= InternalHelper.safeCreate(this.delegate.data(), io.vertx.groovy.core.buffer.Buffer.class);
    return ret;
  }
}
