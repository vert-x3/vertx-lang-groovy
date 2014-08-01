package io.vertx.groovy.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.core.json.JsonObject;

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

  public void setDeploymentID(String deploymentID) {
    this.deploymentID = deploymentID;
  }

  public void setVertx(Vertx vertx) {
    this.vertx = vertx;
  }

  public void setConfig(Map<String, Object> config) {
    this.config = config;
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
      public void setConfig(JsonObject config) {
        super.setConfig(config);
        GroovyVerticle.this.setConfig(config != null ? config.toMap() : null);
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
