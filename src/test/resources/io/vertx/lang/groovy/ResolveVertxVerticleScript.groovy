import io.vertx.lang.groovy.DeploymentTest

def vertx = vertx;
def deploymentID = deploymentID
def config = config

if (vertx != null && deploymentID != null && config != null) {
  DeploymentTest.started.set(true);
}