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

import groovy.lang.Binding;
import groovy.lang.MissingMethodException;
import groovy.lang.Script;
import io.vertx.core.AbstractVerticle;

/**
 * A Vert.x native verticle wrapping a Groovy script, the script will be executed when the Verticle starts.
 * When the script defines a no arg accessible <code>vertxStop</code> method, this method will be invoked
 * when the verticle stops. Before the script starts the following objects are bound in the script binding:
 * <ul>
 *   <li><code>vertx</code>: the {@link Vertx} object</li>
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

  @Override
  public void start() throws Exception {
    Binding binding = script.getBinding();
    if (script.getBinding() == null) {
      script.setBinding(binding = new Binding());
    }
    binding.setVariable("vertx", new Vertx(vertx));
    script.run();
  }

  @Override
  public void stop() throws Exception {
    try {
      script.invokeMethod("vertxStop", null);
    } catch (MissingMethodException ignore) {
    }
  }
}
