package transform;

import io.vertx.groovy.core.Vertx;

Vertx vertx_ = vertx;

vertx_.eventBus().send("the-address", true);
