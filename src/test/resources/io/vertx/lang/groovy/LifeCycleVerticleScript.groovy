package io.vertx.lang.groovy

DeploymentTest.started.set(true);

void vertxStop() {
  DeploymentTest.stopped.set(true);
}