package verticles.compile

import io.vertx.lang.groovy.DeploymentTest

DeploymentTest.started.await();

void vertxStop() {
  DeploymentTest.stopped.await()
}