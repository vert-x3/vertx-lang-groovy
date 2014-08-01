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
    Binding binding = new Binding();
    binding.setVariable("vertx", new Vertx(vertx));
    binding.setVariable("deploymentID", deploymentID);
    binding.setVariable("config", config != null ? config.toMap() : null);
    script.setBinding(binding);
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
