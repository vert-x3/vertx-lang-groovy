import io.vertx.core.json.JsonObject
import io.vertx.core.Vertx

// Make sure they have the correct type
Vertx vertx = (Vertx) vertx;
String deploymentID = vertx.getOrCreateContext.deploymentID()
JsonObject config = vertx.getOrCreateContext().config()
System.setProperty("started", "${vertx != null && deploymentID != null && config != null}");
