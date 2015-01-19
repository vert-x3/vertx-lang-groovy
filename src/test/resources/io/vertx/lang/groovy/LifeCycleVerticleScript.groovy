package io.vertx.lang.groovy

void vertxStart() {
  DeploymentTest.started.set(true);
}

void vertxStop() {
  DeploymentTest.stopped.set(true);
}