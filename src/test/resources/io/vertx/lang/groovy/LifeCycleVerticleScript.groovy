package io.vertx.lang.groovy

start = { it ->
  System.setProperty("started", "true");
}

stop = { ->
  System.setProperty("stopped", "true");
}

void vertxStart() {
  start()
}

void vertxStop() {
  stop()
}
