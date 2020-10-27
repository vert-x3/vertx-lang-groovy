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
package io.vertx.lang.groovy;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Promise;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;

/**
 * A base class for Groovy verticles.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 * @deprecated use {@link AbstractVerticle} instead
 */
public class GroovyVerticle {

  protected Vertx vertx;
  protected Context context;

  /**
   * If your verticle does a simple, synchronous start-up then override this method and put your start-up
   * code in there.
   * @throws Exception
   */
  public void start() throws Exception {
  }

  /**
   * If your verticle has simple synchronous clean-up tasks to complete then override this method and put your clean-up
   * code in there.
   * @throws Exception
   */
  public void stop() throws Exception {
  }

  /**
   * Start the verticle instance.
   * <p>
   * Vert.x calls this method when deploying the instance. You do not call it yourself.
   * <p>
   * A future is passed into the method, and when deployment is complete the verticle should either call
   * {@link io.vertx.core.Future#complete} or {@link io.vertx.core.Future#fail} the future.
   *
   * @param startFuture  the future
   */
  public void start(Promise<Void> startPromise) throws Exception {
    start();
    startPromise.complete();
  }

  /**
   * Stop the verticle instance.
   * <p>
   * Vert.x calls this method when un-deploying the instance. You do not call it yourself.
   * <p>
   * A future is passed into the method, and when un-deployment is complete the verticle should either call
   * {@link io.vertx.core.Future#complete} or {@link io.vertx.core.Future#fail} the future.
   *
   * @param stopFuture  the future
   */
  public void stop(Promise<Void> stopPromise) throws Exception {
    stop();
    stopPromise.complete();
  }

  /**
   * @return the Java {@link Verticle} adapter for this Groovy Verticle
   */
  public Verticle asJavaVerticle() {
    return new AbstractVerticle() {

      @Override
      public void start(Promise<Void> startPromise) throws Exception {
        GroovyVerticle.this.vertx = super.vertx;
        GroovyVerticle.this.context = super.context;
        GroovyVerticle.this.start(startPromise);
      }

      @Override
      public void stop(Promise<Void> stopPromise) throws Exception {
        GroovyVerticle.this.stop(stopPromise);
      }
    };
  }
}
