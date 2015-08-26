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
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.groovy.core.metrics.Measured
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.groovy.core.net.SocketAddress
/**
 * A datagram socket can be used to send {@link io.vertx.groovy.core.datagram.DatagramPacket}'s to remote datagram servers
 * and receive {@link io.vertx.groovy.core.datagram.DatagramPacket}s .
 * <p>
 * Usually you use a datagram socket to send UDP over the wire. UDP is connection-less which means you are not connected
 * to the remote peer in a persistent way. Because of this you have to supply the address and port of the remote peer
 * when sending data.
 * <p>
 * You can send data to ipv4 or ipv6 addresses, which also include multicast addresses.
 * <p>
 * Please consult the documentation for more information on datagram sockets.
*/
@CompileStatic
public class DatagramSocket implements ReadStream<DatagramPacket>,  Measured {
  private final def io.vertx.core.datagram.DatagramSocket delegate;
  public DatagramSocket(Object delegate) {
    this.delegate = (io.vertx.core.datagram.DatagramSocket) delegate;
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
   * Write the given {@link io.vertx.groovy.core.buffer.Buffer} to the {@link io.vertx.groovy.core.net.SocketAddress}.
   * The {@link io.vertx.core.Handler} will be notified once the write completes.
   * @param packet the {@link io.vertx.groovy.core.buffer.Buffer} to write
   * @param port the host port of the remote peer
   * @param host the host address of the remote peer
   * @param handler the {@link io.vertx.core.Handler} to notify once the write completes.
   * @return a reference to this, so the API can be used fluently
   */
  public DatagramSocket send(Buffer packet, int port, String host, Handler<AsyncResult<DatagramSocket>> handler) {
    this.delegate.send((io.vertx.core.buffer.Buffer)packet.getDelegate(), port, host, new Handler<AsyncResult<io.vertx.core.datagram.DatagramSocket>>() {
      public void handle(AsyncResult<io.vertx.core.datagram.DatagramSocket> event) {
        AsyncResult<DatagramSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<DatagramSocket>result(new DatagramSocket(event.result()))
        } else {
          f = InternalHelper.<DatagramSocket>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Returns a {@link io.vertx.groovy.core.datagram.PacketWritestream} able to send  to the
   * {@link io.vertx.groovy.core.net.SocketAddress}.
   * @param port the port of the remote peer
   * @param host the host address of the remote peer
   * @return the write stream for sending packets
   */
  public PacketWritestream sender(int port, String host) {
    def ret= InternalHelper.safeCreate(this.delegate.sender(port, host), io.vertx.groovy.core.datagram.PacketWritestream.class);
    return ret;
  }
  /**
   * Write the given {@link java.lang.String} to the {@link io.vertx.groovy.core.net.SocketAddress} using UTF8 encoding.
   * The  will be notified once the write completes.
   * @param str the {@link java.lang.String} to write
   * @param port the host port of the remote peer
   * @param host the host address of the remote peer
   * @param handler the {@link io.vertx.core.Handler} to notify once the write completes.
   * @return a reference to this, so the API can be used fluently
   */
  public DatagramSocket send(String str, int port, String host, Handler<AsyncResult<DatagramSocket>> handler) {
    this.delegate.send(str, port, host, new Handler<AsyncResult<io.vertx.core.datagram.DatagramSocket>>() {
      public void handle(AsyncResult<io.vertx.core.datagram.DatagramSocket> event) {
        AsyncResult<DatagramSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<DatagramSocket>result(new DatagramSocket(event.result()))
        } else {
          f = InternalHelper.<DatagramSocket>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Write the given {@link java.lang.String} to the {@link io.vertx.groovy.core.net.SocketAddress} using the given encoding.
   * The  will be notified once the write completes.
   * @param str the {@link java.lang.String} to write
   * @param enc the charset used for encoding
   * @param port the host port of the remote peer
   * @param host the host address of the remote peer
   * @param handler the {@link io.vertx.core.Handler} to notify once the write completes.
   * @return a reference to this, so the API can be used fluently
   */
  public DatagramSocket send(String str, String enc, int port, String host, Handler<AsyncResult<DatagramSocket>> handler) {
    this.delegate.send(str, enc, port, host, new Handler<AsyncResult<io.vertx.core.datagram.DatagramSocket>>() {
      public void handle(AsyncResult<io.vertx.core.datagram.DatagramSocket> event) {
        AsyncResult<DatagramSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<DatagramSocket>result(new DatagramSocket(event.result()))
        } else {
          f = InternalHelper.<DatagramSocket>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Closes the {@link io.vertx.groovy.core.datagram.DatagramSocket} implementation asynchronous
   * and notifies the handler once done.
   * @param handler the handler to notify once complete
   */
  public void close(Handler<AsyncResult<Void>> handler) {
    this.delegate.close(handler);
  }
  /**
   * Closes the {@link io.vertx.groovy.core.datagram.DatagramSocket}. The close itself is asynchronous.
   */
  public void close() {
    this.delegate.close();
  }
  /**
   * Return the {@link io.vertx.groovy.core.net.SocketAddress} to which
   * this {@link io.vertx.groovy.core.datagram.DatagramSocket} is bound.
   * @return the socket address
   */
  public SocketAddress localAddress() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret= InternalHelper.safeCreate(this.delegate.localAddress(), io.vertx.groovy.core.net.SocketAddress.class);
    cached_0 = ret;
    return ret;
  }
  /**
   * Joins a multicast group and listens for packets send to it.
   * The  is notified once the operation completes.
   * @param multicastAddress the address of the multicast group to join
   * @param handler then handler to notify once the operation completes
   * @return a reference to this, so the API can be used fluently
   */
  public DatagramSocket listenMulticastGroup(String multicastAddress, Handler<AsyncResult<DatagramSocket>> handler) {
    this.delegate.listenMulticastGroup(multicastAddress, new Handler<AsyncResult<io.vertx.core.datagram.DatagramSocket>>() {
      public void handle(AsyncResult<io.vertx.core.datagram.DatagramSocket> event) {
        AsyncResult<DatagramSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<DatagramSocket>result(new DatagramSocket(event.result()))
        } else {
          f = InternalHelper.<DatagramSocket>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Joins a multicast group and listens for packets send to it on the given network interface.
   * The  is notified once the operation completes.
   * @param multicastAddress the address of the multicast group to join
   * @param networkInterface the network interface on which to listen for packets.
   * @param source the address of the source for which we will listen for multicast packets
   * @param handler then handler to notify once the operation completes
   * @return a reference to this, so the API can be used fluently
   */
  public DatagramSocket listenMulticastGroup(String multicastAddress, String networkInterface, String source, Handler<AsyncResult<DatagramSocket>> handler) {
    this.delegate.listenMulticastGroup(multicastAddress, networkInterface, source, new Handler<AsyncResult<io.vertx.core.datagram.DatagramSocket>>() {
      public void handle(AsyncResult<io.vertx.core.datagram.DatagramSocket> event) {
        AsyncResult<DatagramSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<DatagramSocket>result(new DatagramSocket(event.result()))
        } else {
          f = InternalHelper.<DatagramSocket>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Leaves a multicast group and stops listening for packets send to it.
   * The  is notified once the operation completes.
   * @param multicastAddress the address of the multicast group to leave
   * @param handler then handler to notify once the operation completes
   * @return a reference to this, so the API can be used fluently
   */
  public DatagramSocket unlistenMulticastGroup(String multicastAddress, Handler<AsyncResult<DatagramSocket>> handler) {
    this.delegate.unlistenMulticastGroup(multicastAddress, new Handler<AsyncResult<io.vertx.core.datagram.DatagramSocket>>() {
      public void handle(AsyncResult<io.vertx.core.datagram.DatagramSocket> event) {
        AsyncResult<DatagramSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<DatagramSocket>result(new DatagramSocket(event.result()))
        } else {
          f = InternalHelper.<DatagramSocket>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Leaves a multicast group and stops listening for packets send to it on the given network interface.
   * The  is notified once the operation completes.
   * @param multicastAddress the address of the multicast group to join
   * @param networkInterface the network interface on which to listen for packets.
   * @param source the address of the source for which we will listen for multicast packets
   * @param handler the handler to notify once the operation completes
   * @return a reference to this, so the API can be used fluently
   */
  public DatagramSocket unlistenMulticastGroup(String multicastAddress, String networkInterface, String source, Handler<AsyncResult<DatagramSocket>> handler) {
    this.delegate.unlistenMulticastGroup(multicastAddress, networkInterface, source, new Handler<AsyncResult<io.vertx.core.datagram.DatagramSocket>>() {
      public void handle(AsyncResult<io.vertx.core.datagram.DatagramSocket> event) {
        AsyncResult<DatagramSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<DatagramSocket>result(new DatagramSocket(event.result()))
        } else {
          f = InternalHelper.<DatagramSocket>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Block the given address for the given multicast address and notifies the  once
   * the operation completes.
   * @param multicastAddress the address for which you want to block the source address
   * @param sourceToBlock the source address which should be blocked. You will not receive an multicast packets for it anymore.
   * @param handler the handler to notify once the operation completes
   * @return a reference to this, so the API can be used fluently
   */
  public DatagramSocket blockMulticastGroup(String multicastAddress, String sourceToBlock, Handler<AsyncResult<DatagramSocket>> handler) {
    this.delegate.blockMulticastGroup(multicastAddress, sourceToBlock, new Handler<AsyncResult<io.vertx.core.datagram.DatagramSocket>>() {
      public void handle(AsyncResult<io.vertx.core.datagram.DatagramSocket> event) {
        AsyncResult<DatagramSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<DatagramSocket>result(new DatagramSocket(event.result()))
        } else {
          f = InternalHelper.<DatagramSocket>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Block the given address for the given multicast address on the given network interface and notifies
   * the  once the operation completes.
   * @param multicastAddress the address for which you want to block the source address
   * @param networkInterface the network interface on which the blocking should occur.
   * @param sourceToBlock the source address which should be blocked. You will not receive an multicast packets for it anymore.
   * @param handler the handler to notify once the operation completes
   * @return a reference to this, so the API can be used fluently
   */
  public DatagramSocket blockMulticastGroup(String multicastAddress, String networkInterface, String sourceToBlock, Handler<AsyncResult<DatagramSocket>> handler) {
    this.delegate.blockMulticastGroup(multicastAddress, networkInterface, sourceToBlock, new Handler<AsyncResult<io.vertx.core.datagram.DatagramSocket>>() {
      public void handle(AsyncResult<io.vertx.core.datagram.DatagramSocket> event) {
        AsyncResult<DatagramSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<DatagramSocket>result(new DatagramSocket(event.result()))
        } else {
          f = InternalHelper.<DatagramSocket>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Start listening on the given port and host. The handler will be called when the socket is listening.
   * @param port the port to listen on
   * @param host the host to listen on
   * @param handler the handler will be called when listening
   * @return a reference to this, so the API can be used fluently
   */
  public DatagramSocket listen(int port, String host, Handler<AsyncResult<DatagramSocket>> handler) {
    this.delegate.listen(port, host, new Handler<AsyncResult<io.vertx.core.datagram.DatagramSocket>>() {
      public void handle(AsyncResult<io.vertx.core.datagram.DatagramSocket> event) {
        AsyncResult<DatagramSocket> f
        if (event.succeeded()) {
          f = InternalHelper.<DatagramSocket>result(new DatagramSocket(event.result()))
        } else {
          f = InternalHelper.<DatagramSocket>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  public DatagramSocket pause() {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.datagram.DatagramSocket) this.delegate).pause();
    return this;
  }
  public DatagramSocket resume() {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.datagram.DatagramSocket) this.delegate).resume();
    return this;
  }
  public DatagramSocket endHandler(Handler<Void> endHandler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.datagram.DatagramSocket) this.delegate).endHandler(endHandler);
    return this;
  }
  public DatagramSocket handler(Handler<DatagramPacket> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.datagram.DatagramSocket) this.delegate).handler(new Handler<io.vertx.core.datagram.DatagramPacket>() {
      public void handle(io.vertx.core.datagram.DatagramPacket event) {
        handler.handle(new io.vertx.groovy.core.datagram.DatagramPacket(event));
      }
    });
    return this;
  }
  public DatagramSocket exceptionHandler(Handler<Throwable> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.datagram.DatagramSocket) this.delegate).exceptionHandler(handler);
    return this;
  }
  private SocketAddress cached_0;
}
