package io.vertx.groovy.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;

/**
 * The base class for Groovy verticles.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class GroovyVerticle {

  protected Vertx vertx;
  protected String deploymentID;

  public void setDeploymentID(String deploymentID) {
    this.deploymentID = deploymentID;
  }

  public void setVertx(Vertx vertx) {
    this.vertx = vertx;
  }

  public void start() throws Exception {
  }

  public void stop() throws Exception {
  }

  /**
   * @return the Java {@link Verticle} adapter for this Groovy Verticle
   */
  public Verticle asJavaVerticle() {
    return new AbstractVerticle() {

      @Override
      public void setDeploymentID(String deploymentID) {
        super.setDeploymentID(deploymentID);
        GroovyVerticle.this.setDeploymentID(deploymentID);
      }

      @Override
      public void setVertx(io.vertx.core.Vertx vertx) {
        super.setVertx(vertx);
        GroovyVerticle.this.setVertx(new io.vertx.groovy.core.Vertx(vertx));
      }

      @Override
      public void start() throws Exception {
        GroovyVerticle.this.start();
      }

      @Override
      public void stop() throws Exception {
        GroovyVerticle.this.stop();
      }
    };
  }
}
