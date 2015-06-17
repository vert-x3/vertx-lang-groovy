package io.vertx.lang.groovy
/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ResolveVertxGroovyVerticleClass extends GroovyVerticle {

  @Override
  void start() throws Exception {
    boolean started = vertx != null && vertx.currentContext().deploymentID() != null && vertx.currentContext().config() != null
    System.setProperty("started", "${started}");
  }
}
