package io.vertx.groovy.core;

import groovy.lang.Binding;
import groovy.lang.MissingMethodException;
import groovy.lang.Script;
import io.vertx.core.AbstractVerticle;

/**
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
