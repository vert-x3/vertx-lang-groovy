import io.vertx.groovy.core.Vertx
import io.vertx.lang.groovy.DeploymentTest

// Make sure they have the correct type
Vertx vertx = (Vertx) vertx;
String deploymentID = (String) deploymentID
Map<String, Object> config = (Map<String, Object>) config
DeploymentTest.started.set(vertx != null && deploymentID != null && config != null);
