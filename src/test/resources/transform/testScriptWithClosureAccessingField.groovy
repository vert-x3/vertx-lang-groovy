package transform;

import io.vertx.groovy.core.Vertx

def Vertx vertx_ = vertx;

def closure = {
  def v = vertx;
  vertx = v;
  vertx_.eventBus().send("the-address", true)
}

closure()
