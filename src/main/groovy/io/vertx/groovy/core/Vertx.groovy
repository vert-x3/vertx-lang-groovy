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

package io.vertx.groovy.core;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.groovy.core.datagram.DatagramSocket
import io.vertx.groovy.core.http.HttpServer
import io.vertx.core.VertxOptions
import java.util.Set
import io.vertx.groovy.core.shareddata.SharedData
import io.vertx.core.net.NetClientOptions
import io.vertx.groovy.core.dns.DnsClient
import io.vertx.core.net.NetServerOptions
import io.vertx.groovy.core.eventbus.EventBus
import io.vertx.groovy.core.net.NetServer
import io.vertx.core.DeploymentOptions
import io.vertx.groovy.core.file.FileSystem
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.AsyncResult
import io.vertx.core.http.HttpClientOptions
import io.vertx.core.datagram.DatagramSocketOptions
import io.vertx.core.Handler
import io.vertx.groovy.core.net.NetClient
import io.vertx.groovy.core.http.HttpClient
/**
 * The control centre of the Vert.x Core API.<p>
 * You should normally only use a single instance of this class throughout your application. If you are running in the
 * Vert.x container an instance will be provided to you.<p>
 * If you are using Vert.x embedded, you can create an instance using one of the static {@code VertxFactory.newVertx}
 * methods.<p>
 * This class acts as a factory for TCP/SSL and HTTP/HTTPS servers and clients, SockJS servers, and provides an
 * instance of the event bus, file system and shared data classes, as well as methods for setting and cancelling
 * timers.<p>
 * Instances of this class are thread-safe.<p>
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class Vertx {
  final def io.vertx.core.Vertx delegate;
  public Vertx(io.vertx.core.Vertx delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public static Vertx vertx() {
    def ret= Vertx.FACTORY.apply(io.vertx.core.Vertx.vertx());
    return ret;
  }
  public static Vertx vertx(Map<String, Object> options) {
    def ret= Vertx.FACTORY.apply(io.vertx.core.Vertx.vertx(options != null ? new io.vertx.core.VertxOptions(new io.vertx.core.json.JsonObject(options)) : null));
    return ret;
  }
  public static void vertxAsync(Map<String, Object> options = [:], Handler<AsyncResult<Vertx>> resultHandler) {
    io.vertx.core.Vertx.vertxAsync(options != null ? new io.vertx.core.VertxOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<AsyncResult<io.vertx.core.Vertx>>() {
      public void handle(AsyncResult<io.vertx.core.Vertx> event) {
        AsyncResult<Vertx> f
        if (event.succeeded()) {
          f = InternalHelper.<Vertx>result(new Vertx(event.result()))
        } else {
          f = InternalHelper.<Vertx>failure(event.cause())
        }
        resultHandler.handle(f)
      }
    });
  }
  /**
   * Create a TCP/SSL server
   */
  public NetServer createNetServer(Map<String, Object> options = [:]) {
    def ret= NetServer.FACTORY.apply(this.delegate.createNetServer(options != null ? new io.vertx.core.net.NetServerOptions(new io.vertx.core.json.JsonObject(options)) : null));
    return ret;
  }
  /**
   * Create a TCP/SSL client
   */
  public NetClient createNetClient(Map<String, Object> options = [:]) {
    def ret= NetClient.FACTORY.apply(this.delegate.createNetClient(options != null ? new io.vertx.core.net.NetClientOptions(new io.vertx.core.json.JsonObject(options)) : null));
    return ret;
  }
  /**
   * Create an HTTP/HTTPS server
   */
  public HttpServer createHttpServer(Map<String, Object> options = [:]) {
    def ret= HttpServer.FACTORY.apply(this.delegate.createHttpServer(options != null ? new io.vertx.core.http.HttpServerOptions(new io.vertx.core.json.JsonObject(options)) : null));
    return ret;
  }
  /**
   * Create a HTTP/HTTPS client
   */
  public HttpClient createHttpClient(Map<String, Object> options = [:]) {
    def ret= HttpClient.FACTORY.apply(this.delegate.createHttpClient(options != null ? new io.vertx.core.http.HttpClientOptions(new io.vertx.core.json.JsonObject(options)) : null));
    return ret;
  }
  public DatagramSocket createDatagramSocket(Map<String, Object> options = [:]) {
    def ret= DatagramSocket.FACTORY.apply(this.delegate.createDatagramSocket(options != null ? new io.vertx.core.datagram.DatagramSocketOptions(new io.vertx.core.json.JsonObject(options)) : null));
    return ret;
  }
  /**
   * The File system object
   */
  public FileSystem fileSystem() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret= FileSystem.FACTORY.apply(this.delegate.fileSystem());
    cached_0 = ret;
    return ret;
  }
  /**
   * The event bus
   */
  public EventBus eventBus() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret= EventBus.FACTORY.apply(this.delegate.eventBus());
    cached_1 = ret;
    return ret;
  }
  /**
   * Return the {@link DnsClient}
   */
  public DnsClient createDnsClient(int port, String host) {
    def ret= DnsClient.FACTORY.apply(this.delegate.createDnsClient(port, host));
    return ret;
  }
  /**
   * The shared data object
   */
  public SharedData sharedData() {
    if (cached_2 != null) {
      return cached_2;
    }
    def ret= SharedData.FACTORY.apply(this.delegate.sharedData());
    cached_2 = ret;
    return ret;
  }
  /**
   * Set a one-shot timer to fire after {@code delay} milliseconds, at which point {@code handler} will be called with
   * the id of the timer.
   * @return the unique ID of the timer
   */
  public long setTimer(long delay, Handler<Long> handler) {
    def ret = this.delegate.setTimer(delay, handler);
    return ret;
  }
  /**
   * Set a periodic timer to fire every {@code delay} milliseconds, at which point {@code handler} will be called with
   * the id of the timer.
   * @return the unique ID of the timer
   */
  public long setPeriodic(long delay, Handler<Long> handler) {
    def ret = this.delegate.setPeriodic(delay, handler);
    return ret;
  }
  /**
   * Cancel the timer with the specified {@code id}. Returns {@code} true if the timer was successfully cancelled, or
   * {@code false} if the timer does not exist.
   */
  public boolean cancelTimer(long id) {
    def ret = this.delegate.cancelTimer(id);
    return ret;
  }
  /**
   * @return The current context
   */
  public Context context() {
    def ret= Context.FACTORY.apply(this.delegate.context());
    return ret;
  }
  /**
   * Put the handler on the event queue for the current loop (or worker context) so it will be run asynchronously ASAP after this event has
   * been processed
   */
  public void runOnContext(Handler<Void> action) {
    this.delegate.runOnContext(action);
  }
  /**
   * Stop the eventbus and any resource managed by the eventbus.
   */
  public void close() {
    this.delegate.close();
  }
  /**
   * Stop the eventbus and any resource managed by the eventbus.
   */
  public void close(Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.close(completionHandler);
  }
  public void deployVerticle(String identifier) {
    this.delegate.deployVerticle(identifier);
  }
  public void deployVerticle(String identifier, Handler<AsyncResult<String>> completionHandler) {
    this.delegate.deployVerticle(identifier, completionHandler);
  }
  public void deployVerticle(String identifier, Map<String, Object> options) {
    this.delegate.deployVerticle(identifier, options != null ? new io.vertx.core.DeploymentOptions(new io.vertx.core.json.JsonObject(options)) : null);
  }
  public void deployVerticle(String identifier, Map<String, Object> options, Handler<AsyncResult<String>> completionHandler) {
    this.delegate.deployVerticle(identifier, options != null ? new io.vertx.core.DeploymentOptions(new io.vertx.core.json.JsonObject(options)) : null, completionHandler);
  }
  public void undeployVerticle(String deploymentID) {
    this.delegate.undeployVerticle(deploymentID);
  }
  public void undeployVerticle(String deploymentID, Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.undeployVerticle(deploymentID, completionHandler);
  }
  public Set<String> deployments() {
    def ret = this.delegate.deployments();
    return ret;
  }
  private FileSystem cached_0;
  private EventBus cached_1;
  private SharedData cached_2;

  static final java.util.function.Function<io.vertx.core.Vertx, Vertx> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.Vertx arg -> new Vertx(arg);
  };
}
