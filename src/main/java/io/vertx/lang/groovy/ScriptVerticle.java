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

import groovy.lang.Binding;
import groovy.lang.MetaMethod;
import groovy.lang.Script;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;

/**
 * A Vert.x native verticle wrapping a Groovy script, the script will be executed when the Verticle starts.
 * When the script defines a no arg accessible <code>vertxStop</code> method, this method will be invoked
 * when the verticle stops. Before the script starts the following objects are bound in the script binding:
 * <ul>
 *   <li><code>vertx</code>: the {@link io.vertx.core.Vertx} object</li>
 *   <li><code>deploymentID</code>: the deploymentID of this Verticle</li>
 *   <li><code>config</code>: the Verticle config as a <code>Map&lt;String, Object&gt;</code></li>
 * </ul>
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ScriptVerticle extends AbstractVerticle {

  private final Script script;

  public ScriptVerticle(Script script) {
    this.script = script;
  }

  private static final Class[] EMPTY_PARAMS = {};
  private static final Class[] FUTURE_PARAMS = {io.vertx.core.Future.class};

  /**
   * Start the verticle instance.
   * <p>
   * Vert.x calls this method when deploying the instance. You do not call it yourself.
   * <p>
   * A future is passed into the method, and when deployment is complete the verticle should either call
   * {@link io.vertx.core.Promise#complete} or {@link io.vertx.core.Promise#fail} the future.
   *
   * @param startFuture  the future
   */
  @Override
  public void start(Promise<Void> startFuture) throws Exception {
    Binding binding = script.getBinding();
    if (script.getBinding() == null) {
      script.setBinding(binding = new Binding());
    }
    binding.setVariable("vertx", vertx);
    script.run();
    handleLifecycle("vertxStart", startFuture);
  }

  /**
   * Stop the verticle instance.
   * <p>
   * Vert.x calls this method when un-deploying the instance. You do not call it yourself.
   * <p>
   * A future is passed into the method, and when un-deployment is complete the verticle should either call
   * {@link io.vertx.core.Promise#complete} or {@link io.vertx.core.Promise#fail} the future.
   *
   * @param stopFuture  the future
   */
  @Override
  public void stop(Promise<Void> stopFuture) throws Exception {
    handleLifecycle("vertxStop", stopFuture);
  }

  private void handleLifecycle(String methodName, Promise<Void> future) {
    MetaMethod method = script.getMetaClass().getMetaMethod(methodName, EMPTY_PARAMS);
    if (method != null) {
      if (method.isValidMethod(FUTURE_PARAMS)) {
        method.invoke(script, new Object[]{future});
      } else if (method.isValidMethod(EMPTY_PARAMS)) {
        method.invoke(script, EMPTY_PARAMS);
        future.complete();
      }
    } else {
      future.complete();
    }
  }
}
