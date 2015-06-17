package io.vertx.lang.groovy

void vertxStart() {
  System.setProperty("started", "true");
}

void vertxStop() {
  System.setProperty("stopped", "true");
}