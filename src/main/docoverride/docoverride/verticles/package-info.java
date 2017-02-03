/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

/**
 * === API changes from previous versions
 *
 * IMPORTANT: this is an important change from previous versions and _Vert.x for Groovy_ users should carefully
 * read this section
 *
 * Vert.x for Groovy has been revamped in Vert.x 3.4.
 *
 * The previous versions were using a code generated Groovy API wrapping the Vert.x Java API, e.g
 * `io.vertx.groovy.core.Vertx` was a Groovy class wrapping `io.vertx.core.Vertx` and changing a few methods
 * to provide a Groovy idiomatic API:
 *
 * - data objects are replaced by maps
 * - `io.vertx.core.json.JsonObject` is replaced by map
 * - `io.vertx.core.json.JsonArray` is replaced by list
 *
 * Creating an `HttpServer` :
 *
 * [source, groovy]
 * ----
 * // call createHttpServer on io.vertx.groovy.core.Vertx
 * def server = vertx.createHttpServer([host:"localhost",port:8080]);
 * // it returned an io.vertx.groovy.core.http.HttpServer instance
 * ----
 *
 * Since 3.4, the Groovy API has become an extension of the Java API based on
 * http://mrhaki.blogspot.fr/2013/01/groovy-goodness-adding-extra-methods.html[Groovy extension methods].
 *
 * [source, groovy]
 * ----
 * // call createHttpServer on io.vertx.core.Vertx
 * def server = vertx.createHttpServer([host:"localhost",port:8080]);
 * // it returned an io.vertx.core.http.HttpServer instance
 * ----
 *
 * The actual method called is `io.vertx.groovy.core.Vertx_GroovyExtension#createHttpServer(io.vertx.core.Vertx, Map<String, Object>)`
 * that transforms the map options into `io.vertx.core.http.HttpServerOptions`.
 *
 * Of course if you like you can call the `createHttpServer(HttpServerOptions)` method directly and pass an `HttpServerOptions`
 * instance.
 *
 * The benefits are:
 *
 * - performance gains since no wrapping occur
 * - an idiomatic Groovy-ish API
 * - full access to the Vert.x Java API, not hidden anymore behind a wrapper
 *
 * ==== Migrating from previous API
 *
 * Existing Groovy Verticles are using `io.vertx.groovy.XYZ` API and should use now `io.vertx.XYZ` Java API.
 *
 * Vert.x for Groovy provides a Groovy compiler transformation that rewrites the compiled classes to unwraps the occurences
 * of legacy classes, i.e it rewrites `io.vertx.groovy.core.Vertx` to `io.vertx.core.Vertx`.
 *
 * To help you, the transformed classes are printed by the compiler on the standard output, for instance if you compile
 * the script:
 *
 * [source, groovy]
 * ----
 * import io.vertx.groovy.core.buffer.Buffer;
 *
 * def content = Buffer.buffer("Hello World");
 *
 * def server = vertx.createHttpServer();
 * server.requestHandler { req
 *   req.response().end("content");
 * }
 * server.listen();
 * ----
 *
 * Something like:
 *
 * [source, groovy]
 * ----
 * // -------- BEGIN HelloWorldServer --------
 * import io.vertx.core.buffer.Buffer as Buffer
 *
 * def content  = Buffer.buffer('Hello World')
 * def server  = vertx.createHttpServer()
 * server.requestHandler({ req ->
 *  req.response().end(content)
 * })
 * server.listen()
 * // -------- END HelloWorldServer --------
 * ----
 *
 * Printed on the console
 *
 * === Writing Verticles
 *
 * There are two alternatives to create verticles in Groovy:
 *
 *  * a plain Groovy script
 *  * a Groovy class implementing the {@link io.vertx.core.Verticle} interface or extending the {@link io.vertx.core.AbstractVerticle} class
 *
 * For example, the next snippet is a valid Groovy verticle:
 *
 * [source, groovy]
 * ----
 * println "Hello from vertx"
 * ----
 *
 * On deployment, by default, Vert.x executes the script. Optionally, your script can provide the `startVertx` and
 * `stopVertx` methods. Theses methods are called respectively when the verticle starts and stops:
 *
 * [source, groovy]
 * ----
 * void vertxStart() {
 *  println "starting"
 * }
 *
 * void vertxStop() {
 *  println "stopping"
 * }
 * ----
 *
 * Alternatively, you can extend the {@link io.vertx.core.AbstractVerticle} class and implement the `start` and
 * `stop` methods:
 *
 * [source, groovy]
 * ----
 * import io.vertx.core.AbstractVerticle;
 *
 * public class HelloWorldHttpVerticle extends AbstractVerticle {
 *
 *  public void start() {
 *   println("Starting")
 *  }
 *
 *  public void stop() {
 *    println("Stopping")
 *  }
 * }
 * ----
 *
 * When Vert.x deploys the verticle it will call the `start` method, and when the method has completed the
 * verticle will be considered started.
 *
 * You can also optionally override the `stop` method. This will be called by Vert.x when the verticle is undeployed
 * and when the method has completed the verticle will be considered stopped.
 *
 * === Accessing the vertx instance from a verticle
 *
 * Regardless the way you use to implement your verticle, you access the vert.x instance using the `vertx` variable /
 * field.
 *
 * .Access to the vert.x instance in a Groovy script
 * [source, groovy]
 * ----
 * vertx.deployVerticle("another_verticle.rb")
 * ----
 *
 * .Access to the vert.x instance in a Groovy class
 * [source, groovy]
 * ----
 * import io.vertx.lang.groovy.GroovyVerticle;
 *
 * public class HelloWorldHttpVerticle extends GroovyVerticle {
 *
 *    public void start() {
 *      vertx.deployVerticle("another_verticle.js")
 *    }
 * }
 * ----
 *
 * === Asynchronous Verticle start and stop
 *
 * Sometimes you want to do something in your verticle start-up which takes some time and you don't want the verticle to
 * be considered deployed until that happens. For example you might want to deploy other verticles in the start method.
 *
 * You can't block waiting for the other verticles to deploy in your start method as that would break the <<golden_rule, Golden Rule>>.
 *
 * So how can you do this?
 *
 * The way to do it is to implement the *asynchronous* start method. This version of the method takes a Future as a parameter.When the method returns the verticle will *not* be considered deployed.
 *
 * Some time later, after you've done everything you need to do (e.g. start other verticles), you can call complete
 * on the Future (or fail) to signal that you're done. Similarly, there is an asynchronous version of the stop method too.
 * You use this if you want to do some verticle cleanup that takes some time.
 *
 * When your verticle is implemented as a script, asynchronous start and stop are implemented as follows:
 *
 * [source, groovy]
 * ----
 * import io.vertx.core.Future
 *
 * void vertxStart(Future<Void> future) {
 *  println "starting"
 *  vertx.deployVerticle("v.rb", { res ->
 *    if (res.succeeded()) {
 *      future.complete()
 *    } else {
 *      future.fail()
 *    }
 *  })
 * }
 *
 * void vertxStop(Future<Void> future) {
 *  println "stopping"
 *  future.complete()
 * }
 * ----
 *
 * If your verticle extends {@link io.vertx.core.AbstractVerticle}, you override the
 * {@link io.vertx.core.AbstractVerticle#start(io.vertx.core.Future)} and
 * {@link io.vertx.core.AbstractVerticle#stop(io.vertx.core.Future)} methods:
 *
 * [source, groovy]
 * ----
 * import io.vertx.core.Future
 * import io.vertx.core.AbstractVerticle
 *
 * public class HelloWorldHttpVerticle extends AbstractVerticle {
 *  public void start(Future<Void> future) {
 *    println "starting"
 *    vertx.deployVerticle("v.rb",
 *    { res ->
 *      if (res.succeeded()) {
 *        future.complete()
 *      } else {
 *        future.fail()
 *      }
 *    })
 *   }
 *
 *  public void stop(Future<Void> future) {
 *   println("stopping")
 *   future.complete()
 *  }
 * }
 * ----
 *
 * NOTE: You don't need to manually undeploy child verticles started by a verticle, in the verticle's stop method.
 * Vert.x will automatically undeploy any child verticles when the parent is undeployed.
 *
 * {@link io.vertx.lang.groovy.GroovyVerticle}
 */
@Document(fileName = "override/verticles.adoc")
package docoverride.verticles;

import io.vertx.docgen.Document;
