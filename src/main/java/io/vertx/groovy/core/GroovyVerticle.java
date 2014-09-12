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

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;

import java.util.List;
import java.util.Map;

/**
 * The base class for Groovy verticles.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class GroovyVerticle {

  protected Vertx vertx;
  protected String deploymentID;
  protected Map<String, Object> config;
  protected List<String> processArgs;

  public void setVertx(Vertx vertx) {
    this.vertx = vertx;
  }

  public void start() throws Exception {
  }

  public void stop() throws Exception {
  }

  private void initMembers() {
    Context ctx = vertx.currentContext();
    deploymentID = ctx.deploymentID();
    config = ctx.config();
    processArgs = ctx.processArgs();
  }

  // TODO implement async stop and start!

  /**
   * @return the Java {@link Verticle} adapter for this Groovy Verticle
   */
  public Verticle asJavaVerticle() {
    return new AbstractVerticle() {

      @Override
      public void setVertx(io.vertx.core.Vertx vertx) {
        super.setVertx(vertx);
        GroovyVerticle.this.setVertx(new io.vertx.groovy.core.Vertx(vertx));
      }

      @Override
      public void start() throws Exception {
        GroovyVerticle.this.initMembers();
        GroovyVerticle.this.start();
      }

      @Override
      public void stop() throws Exception {
        GroovyVerticle.this.stop();
      }
    };
  }
}
