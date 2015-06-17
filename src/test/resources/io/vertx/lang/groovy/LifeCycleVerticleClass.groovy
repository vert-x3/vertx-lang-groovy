package io.vertx.lang.groovy
/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class LifeCycleVerticleClass extends GroovyVerticle {

  @Override
  void start() throws Exception {
    System.setProperty("started", "true");
  }

  @Override
  void stop() throws Exception {
    System.setProperty("stopped", "true");
  }
}
