import io.vertx.groovy.core.Vertx

// Make sure they have the correct type
Vertx vertx = (Vertx) vertx;
String deploymentID = vertx.currentContext().deploymentID()
Map<String, Object> config = vertx.currentContext().config()
System.setProperty("started", "${vertx != null && deploymentID != null && config != null}");
