import io.vertx.groovy.core.Vertx
import io.vertx.lang.groovy.DeploymentTest

// Make sure they have the correct type
Vertx vertx = (Vertx) vertx;
String deploymentID = vertx.context().deploymentID()
Map<String, Object> config = vertx.context().config()
DeploymentTest.started.set(vertx != null && deploymentID != null && config != null);
