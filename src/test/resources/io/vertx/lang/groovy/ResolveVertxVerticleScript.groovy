import io.vertx.groovy.core.Vertx
import io.vertx.lang.groovy.DeploymentTest

// Make sure they have the correct type
Vertx vertx = (Vertx) vertx;
String deploymentID = vertx.currentContext().deploymentID()
Map<String, Object> config = vertx.currentContext().config()
DeploymentTest.started.set(vertx != null && deploymentID != null && config != null);
