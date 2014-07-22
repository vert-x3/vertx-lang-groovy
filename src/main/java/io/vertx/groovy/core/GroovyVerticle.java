package io.vertx.groovy.core;

/**
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
}
