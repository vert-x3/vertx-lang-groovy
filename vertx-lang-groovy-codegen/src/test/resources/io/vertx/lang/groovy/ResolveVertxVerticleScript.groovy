import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.Vertx

// Make sure they have the correct type
Vertx vertx = (Vertx) vertx;
String deploymentID = vertx.currentContext().deploymentID()
JsonObject config = vertx.currentContext().config()
System.setProperty("started", "${vertx != null && deploymentID != null && config != null}");
