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

package io.vertx.lang.groovy

import groovy.transform.CompileStatic;
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Verticle;
import io.vertx.groovy.core.Vertx;
import io.vertx.groovy.core.Context;

/**
 * The base class for Groovy verticles.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@CompileStatic
public class GroovyVerticle {

  protected Vertx vertx;
  protected Context context

  public void start() throws Exception {
  }

  public void stop() throws Exception {
  }

  // TODO implement async stop and start!

  public void start(Future<Void> startFuture) throws Exception {
    start();
    startFuture.complete();
  }

  public void stop(Future<Void> stopFuture) throws Exception {
    stop();
    stopFuture.complete();
  }

  /**
   * @return the Java {@link Verticle} adapter for this Groovy Verticle
   */
  public Verticle asJavaVerticle() {
    return new AbstractVerticle() {

      @Override
      void start(Future<Void> startFuture) throws Exception {
        GroovyVerticle.this.vertx = new Vertx(super.vertx);
        GroovyVerticle.this.context = new Context(super.context);
        GroovyVerticle.this.start(startFuture);
      }

      @Override
      void stop(Future<Void> stopFuture) throws Exception {
        GroovyVerticle.this.stop(stopFuture)
      }
    };
  }
}
