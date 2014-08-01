package verticles.compile

import io.vertx.lang.groovy.DeploymentTest

DeploymentTest.started.set(true);

void vertxStop() {
  DeploymentTest.stopped.set(true);
}