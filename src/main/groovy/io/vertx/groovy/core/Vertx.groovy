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
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.datagram.DatagramSocket
import io.vertx.groovy.core.http.HttpServer
import io.vertx.groovy.core.shareddata.SharedData
import io.vertx.groovy.core.eventbus.EventBus
import io.vertx.core.AsyncResult
import io.vertx.core.http.HttpClientOptions
import io.vertx.core.datagram.DatagramSocketOptions
import io.vertx.groovy.core.net.NetClient
import io.vertx.core.VertxOptions
import java.util.Set
import io.vertx.core.net.NetClientOptions
import io.vertx.groovy.core.dns.DnsClient
import io.vertx.core.net.NetServerOptions
import io.vertx.groovy.core.metrics.Measured
import io.vertx.groovy.core.net.NetServer
import io.vertx.core.DeploymentOptions
import io.vertx.groovy.core.file.FileSystem
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.Handler
import io.vertx.groovy.core.http.HttpClient
/**
 * The entry point into the Vert.x Core API.
 * <p>
 * You use an instance of this class for functionality including:
 * <ul>
 *   <li>Creating TCP clients and servers</li>
 *   <li>Creating HTTP clients and servers</li>
 *   <li>Creating DNS clients</li>
 *   <li>Creating Datagram sockets</li>
 *   <li>Setting and cancelling periodic and one-shot timers</li>
 *   <li>Getting a reference to the event bus API</li>
 *   <li>Getting a reference to the file system API</li>
 *   <li>Getting a reference to the shared data API</li>
 *   <li>Deploying and undeploying verticles</li>
 * </ul>
 * <p>
 * Most functionality in Vert.x core is fairly low level.
 * <p>
 * To create an instance of this class you can use the static factory methods: {@link io.vertx.groovy.core.Vertx#vertx},
 * {@link io.vertx.groovy.core.Vertx#vertx} and {@link io.vertx.groovy.core.Vertx#clusteredVertx}.
 * <p>
 * Please see the user manual for more detailed usage information.
*/
@CompileStatic
public class Vertx implements Measured {
  private final def io.vertx.core.Vertx delegate;
  public Vertx(Object delegate) {
    this.delegate = (io.vertx.core.Vertx) delegate;
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
   * Creates a non clustered instance using default options.
   * @return the instance
   */
  public static Vertx vertx() {
    def ret= InternalHelper.safeCreate(io.vertx.core.Vertx.vertx(), io.vertx.groovy.core.Vertx.class);
    return ret;
  }
  /**
   * Creates a non clustered instance using the specified options
   * @param options the options to use (see <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>)
   * @return the instance
   */
  public static Vertx vertx(Map<String, Object> options) {
    def ret= InternalHelper.safeCreate(io.vertx.core.Vertx.vertx(options != null ? new io.vertx.core.VertxOptions(new io.vertx.core.json.JsonObject(options)) : null), io.vertx.groovy.core.Vertx.class);
    return ret;
  }
  /**
   * Creates a clustered instance using the specified options.
   * <p>
   * The instance is created asynchronously and the resultHandler is called with the result when it is ready.
   * @param options the options to use (see <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>)
   * @param resultHandler the result handler that will receive the result
   */
  public static void clusteredVertx(Map<String, Object> options = [:], Handler<AsyncResult<Vertx>> resultHandler) {
    io.vertx.core.Vertx.clusteredVertx(options != null ? new io.vertx.core.VertxOptions(new io.vertx.core.json.JsonObject(options)) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.core.Vertx>>(){
    public void handle(AsyncResult<io.vertx.core.Vertx> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Gets the current context
   * @return The current context or null if no current context
   */
  public static Context currentContext() {
    def ret= InternalHelper.safeCreate(io.vertx.core.Vertx.currentContext(), io.vertx.groovy.core.Context.class);
    return ret;
  }
  /**
   * Gets the current context, or creates one if there isn't one
   * @return The current context (created if didn't exist)
   */
  public Context getOrCreateContext() {
    def ret= InternalHelper.safeCreate(this.delegate.getOrCreateContext(), io.vertx.groovy.core.Context.class);
    return ret;
  }
  /**
   * Create a TCP/SSL server using the specified options
   * @param options the options to use (see <a href="../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a>)
   * @return the server
   */
  public NetServer createNetServer(Map<String, Object> options) {
    def ret= InternalHelper.safeCreate(this.delegate.createNetServer(options != null ? new io.vertx.core.net.NetServerOptions(new io.vertx.core.json.JsonObject(options)) : null), io.vertx.groovy.core.net.NetServer.class);
    return ret;
  }
  /**
   * Create a TCP/SSL server using default options
   * @return the server
   */
  public NetServer createNetServer() {
    def ret= InternalHelper.safeCreate(this.delegate.createNetServer(), io.vertx.groovy.core.net.NetServer.class);
    return ret;
  }
  /**
   * Create a TCP/SSL client using the specified options
   * @param options the options to use (see <a href="../../../../../../cheatsheet/NetClientOptions.html">NetClientOptions</a>)
   * @return the client
   */
  public NetClient createNetClient(Map<String, Object> options) {
    def ret= InternalHelper.safeCreate(this.delegate.createNetClient(options != null ? new io.vertx.core.net.NetClientOptions(new io.vertx.core.json.JsonObject(options)) : null), io.vertx.groovy.core.net.NetClient.class);
    return ret;
  }
  /**
   * Create a TCP/SSL client using default options
   * @return the client
   */
  public NetClient createNetClient() {
    def ret= InternalHelper.safeCreate(this.delegate.createNetClient(), io.vertx.groovy.core.net.NetClient.class);
    return ret;
  }
  /**
   * Create an HTTP/HTTPS server using the specified options
   * @param options the options to use (see <a href="../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a>)
   * @return the server
   */
  public HttpServer createHttpServer(Map<String, Object> options) {
    def ret= InternalHelper.safeCreate(this.delegate.createHttpServer(options != null ? new io.vertx.core.http.HttpServerOptions(new io.vertx.core.json.JsonObject(options)) : null), io.vertx.groovy.core.http.HttpServer.class);
    return ret;
  }
  /**
   * Create an HTTP/HTTPS server using default options
   * @return the server
   */
  public HttpServer createHttpServer() {
    def ret= InternalHelper.safeCreate(this.delegate.createHttpServer(), io.vertx.groovy.core.http.HttpServer.class);
    return ret;
  }
  /**
   * Create a HTTP/HTTPS client using the specified options
   * @param options the options to use (see <a href="../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>)
   * @return the client
   */
  public HttpClient createHttpClient(Map<String, Object> options) {
    def ret= InternalHelper.safeCreate(this.delegate.createHttpClient(options != null ? new io.vertx.core.http.HttpClientOptions(new io.vertx.core.json.JsonObject(options)) : null), io.vertx.groovy.core.http.HttpClient.class);
    return ret;
  }
  /**
   * Create a HTTP/HTTPS client using default options
   * @return the client
   */
  public HttpClient createHttpClient() {
    def ret= InternalHelper.safeCreate(this.delegate.createHttpClient(), io.vertx.groovy.core.http.HttpClient.class);
    return ret;
  }
  /**
   * Create a datagram socket using the specified options
   * @param options the options to use (see <a href="../../../../../../cheatsheet/DatagramSocketOptions.html">DatagramSocketOptions</a>)
   * @return the socket
   */
  public DatagramSocket createDatagramSocket(Map<String, Object> options) {
    def ret= InternalHelper.safeCreate(this.delegate.createDatagramSocket(options != null ? new io.vertx.core.datagram.DatagramSocketOptions(new io.vertx.core.json.JsonObject(options)) : null), io.vertx.groovy.core.datagram.DatagramSocket.class);
    return ret;
  }
  /**
   * Create a datagram socket using default options
   * @return the socket
   */
  public DatagramSocket createDatagramSocket() {
    def ret= InternalHelper.safeCreate(this.delegate.createDatagramSocket(), io.vertx.groovy.core.datagram.DatagramSocket.class);
    return ret;
  }
  /**
   * Get the filesystem object. There is a single instance of FileSystem per Vertx instance.
   * @return the filesystem object
   */
  public FileSystem fileSystem() {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret= InternalHelper.safeCreate(this.delegate.fileSystem(), io.vertx.groovy.core.file.FileSystem.class);
    cached_0 = ret;
    return ret;
  }
  /**
   * Get the event bus object. There is a single instance of EventBus per Vertx instance.
   * @return the event bus object
   */
  public EventBus eventBus() {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret= InternalHelper.safeCreate(this.delegate.eventBus(), io.vertx.groovy.core.eventbus.EventBus.class);
    cached_1 = ret;
    return ret;
  }
  /**
   * Create a DNS client to connect to a DNS server at the specified host and port
   * @param port the port
   * @param host the host
   * @return the DNS client
   */
  public DnsClient createDnsClient(int port, String host) {
    def ret= InternalHelper.safeCreate(this.delegate.createDnsClient(port != null ? port : null, host != null ? host : null), io.vertx.groovy.core.dns.DnsClient.class);
    return ret;
  }
  /**
   * Get the shared data object. There is a single instance of SharedData per Vertx instance.
   * @return the shared data object
   */
  public SharedData sharedData() {
    if (cached_2 != null) {
      return cached_2;
    }
    def ret= InternalHelper.safeCreate(this.delegate.sharedData(), io.vertx.groovy.core.shareddata.SharedData.class);
    cached_2 = ret;
    return ret;
  }
  /**
   * Set a one-shot timer to fire after <code>delay</code> milliseconds, at which point <code>handler</code> will be called with
   * the id of the timer.
   * @param delay the delay in milliseconds, after which the timer will fire
   * @param handler the handler that will be called with the timer ID when the timer fires
   * @return the unique ID of the timer
   */
  public long setTimer(long delay, Handler<Long> handler) {
    def ret = this.delegate.setTimer(delay != null ? delay : null, handler != null ? new Handler<java.lang.Long>(){
    public void handle(java.lang.Long event) {
      handler.handle(null);
    }
  }
 : null);
    return ret;
  }
  /**
   * Returns a one-shot timer as a read stream. The timer will be fired after <code>delay</code> milliseconds after
   * the  has been called.
   * @param delay the delay in milliseconds, after which the timer will fire
   * @return the timer stream
   */
  public TimeoutStream timerStream(long delay) {
    def ret= InternalHelper.safeCreate(this.delegate.timerStream(delay != null ? delay : null), io.vertx.groovy.core.TimeoutStream.class);
    return ret;
  }
  /**
   * Set a periodic timer to fire every <code>delay</code> milliseconds, at which point <code>handler</code> will be called with
   * the id of the timer.
   * @param delay the delay in milliseconds, after which the timer will fire
   * @param handler the handler that will be called with the timer ID when the timer fires
   * @return the unique ID of the timer
   */
  public long setPeriodic(long delay, Handler<Long> handler) {
    def ret = this.delegate.setPeriodic(delay != null ? delay : null, handler != null ? new Handler<java.lang.Long>(){
    public void handle(java.lang.Long event) {
      handler.handle(null);
    }
  }
 : null);
    return ret;
  }
  /**
   * Returns a periodic timer as a read stream. The timer will be fired every <code>delay</code> milliseconds after
   * the  has been called.
   * @param delay the delay in milliseconds, after which the timer will fire
   * @return the periodic stream
   */
  public TimeoutStream periodicStream(long delay) {
    def ret= InternalHelper.safeCreate(this.delegate.periodicStream(delay != null ? delay : null), io.vertx.groovy.core.TimeoutStream.class);
    return ret;
  }
  /**
   * Cancels the timer with the specified <code>id</code>.
   * @param id The id of the timer to cancel
   * @return true if the timer was successfully cancelled, or false if the timer does not exist.
   */
  public boolean cancelTimer(long id) {
    def ret = this.delegate.cancelTimer(id != null ? id : null);
    return ret;
  }
  /**
   * Puts the handler on the event queue for the current context so it will be run asynchronously ASAP after all
   * preceeding events have been handled.
   * @param action - a handler representing the action to execute
   */
  public void runOnContext(Handler<Void> action) {
    this.delegate.runOnContext(action != null ? new Handler<java.lang.Void>(){
    public void handle(java.lang.Void event) {
      action.handle(null);
    }
  }
 : null);
  }
  /**
   * Stop the the Vertx instance and release any resources held by it.
   * <p>
   * The instance cannot be used after it has been closed.
   * <p>
   * The actual close is asynchronous and may not complete until after the call has returned.
   */
  public void close() {
    this.delegate.close();
  }
  /**
   * Like {@link io.vertx.groovy.core.Vertx#close} but the completionHandler will be called when the close is complete
   * @param completionHandler The handler will be notified when the close is complete.
   */
  public void close(Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.close(completionHandler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      completionHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Deploy a verticle instance given a name.
   * <p>
   * Given the name, Vert.x selects a  instance to use to instantiate the verticle.
   * <p>
   * For the rules on how factories are selected please consult the user manual.
   * @param name the name.
   */
  public void deployVerticle(String name) {
    this.delegate.deployVerticle(name != null ? name : null);
  }
  /**
   * Like {@link io.vertx.groovy.core.Vertx#deployVerticle} but the completionHandler will be notified when the deployment is complete.
   * <p>
   * If the deployment is successful the result will contain a String representing the unique deployment ID of the
   * deployment.
   * <p>
   * This deployment ID can subsequently be used to undeploy the verticle.
   * @param name The identifier
   * @param completionHandler a handler which will be notified when the deployment is complete
   */
  public void deployVerticle(String name, Handler<AsyncResult<String>> completionHandler) {
    this.delegate.deployVerticle(name != null ? name : null, completionHandler != null ? new Handler<AsyncResult<java.lang.String>>(){
    public void handle(AsyncResult<java.lang.String> ar) {
      completionHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Like {@link io.vertx.groovy.core.Vertx#deployVerticle} but <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a> are provided to configure the
   * deployment.
   * @param name the name
   * @param options the deployment options. (see <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a>)
   */
  public void deployVerticle(String name, Map<String, Object> options) {
    this.delegate.deployVerticle(name != null ? name : null, options != null ? new io.vertx.core.DeploymentOptions(new io.vertx.core.json.JsonObject(options)) : null);
  }
  /**
   * Like {@link io.vertx.groovy.core.Vertx#deployVerticle} but <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a> are provided to configure the
   * deployment.
   * @param name the name
   * @param options the deployment options. (see <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a>)
   * @param completionHandler a handler which will be notified when the deployment is complete
   */
  public void deployVerticle(String name, Map<String, Object> options, Handler<AsyncResult<String>> completionHandler) {
    this.delegate.deployVerticle(name != null ? name : null, options != null ? new io.vertx.core.DeploymentOptions(new io.vertx.core.json.JsonObject(options)) : null, completionHandler != null ? new Handler<AsyncResult<java.lang.String>>(){
    public void handle(AsyncResult<java.lang.String> ar) {
      completionHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Undeploy a verticle deployment.
   * <p>
   * The actual undeployment happens asynchronously and may not complete until after the method has returned.
   * @param deploymentID the deployment ID
   */
  public void undeploy(String deploymentID) {
    this.delegate.undeploy(deploymentID != null ? deploymentID : null);
  }
  /**
   * Like {@link io.vertx.groovy.core.Vertx #undeploy(String)} but the completionHandler will be notified when the undeployment is complete.
   * @param deploymentID the deployment ID
   * @param completionHandler a handler which will be notified when the undeployment is complete
   */
  public void undeploy(String deploymentID, Handler<AsyncResult<Void>> completionHandler) {
    this.delegate.undeploy(deploymentID != null ? deploymentID : null, completionHandler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      completionHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Return a Set of deployment IDs for the currently deployed deploymentIDs.
   * @return Set of deployment IDs
   */
  public Set<String> deploymentIDs() {
    def ret = this.delegate.deploymentIDs();
    return ret;
  }
  /**
   * Is this Vert.x instance clustered?
   * @return true if clustered
   */
  public boolean isClustered() {
    def ret = this.delegate.isClustered();
    return ret;
  }
  /**
   * Safely execute some blocking code.
   * <p>
   * Executes the blocking code in the handler <code>blockingCodeHandler</code> using a thread from the worker pool.
   * <p>
   * When the code is complete the handler <code>resultHandler</code> will be called with the result on the original context
   * (e.g. on the original event loop of the caller).
   * <p>
   * A <code>Future</code> instance is passed into <code>blockingCodeHandler</code>. When the blocking code successfully completes,
   * the handler should call the {@link io.vertx.groovy.core.Future#complete} or {@link io.vertx.groovy.core.Future#complete} method, or the {@link io.vertx.groovy.core.Future#fail}
   * method if it failed.
   * <p>
   * In the <code>blockingCodeHandler</code> the current context remains the original context and therefore any task
   * scheduled in the <code>blockingCodeHandler</code> will be executed on the this context and not on the worker thread.
   * @param blockingCodeHandler handler representing the blocking code to run
   * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
   * @param resultHandler handler that will be called when the blocking code is complete
   */
  public <T> void executeBlocking(Handler<Future<T>> blockingCodeHandler, boolean ordered, Handler<AsyncResult<T>> resultHandler) {
    this.delegate.executeBlocking(blockingCodeHandler != null ? new Handler<io.vertx.core.Future<java.lang.Object>>(){
    public void handle(io.vertx.core.Future<java.lang.Object> event) {
      blockingCodeHandler.handle(null);
    }
  }
 : null, ordered != null ? ordered : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Object>>(){
    public void handle(AsyncResult<java.lang.Object> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Like {@link io.vertx.groovy.core.Vertx#executeBlocking} called with ordered = true.
   * @param blockingCodeHandler 
   * @param resultHandler 
   */
  public <T> void executeBlocking(Handler<Future<T>> blockingCodeHandler, Handler<AsyncResult<T>> resultHandler) {
    this.delegate.executeBlocking(blockingCodeHandler != null ? new Handler<io.vertx.core.Future<java.lang.Object>>(){
    public void handle(io.vertx.core.Future<java.lang.Object> event) {
      blockingCodeHandler.handle(null);
    }
  }
 : null, resultHandler != null ? new Handler<AsyncResult<java.lang.Object>>(){
    public void handle(AsyncResult<java.lang.Object> ar) {
      resultHandler.handle(null);
    }
  }
 : null);
  }
  /**
   * Set a default exception handler for {@link io.vertx.groovy.core.Context}, set on  at creation.
   * @param handler the exception handler
   * @return a reference to this, so the API can be used fluently
   */
  public Vertx exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler != null ? new Handler<java.lang.Throwable>(){
    public void handle(java.lang.Throwable event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  private FileSystem cached_0;
  private EventBus cached_1;
  private SharedData cached_2;
}
