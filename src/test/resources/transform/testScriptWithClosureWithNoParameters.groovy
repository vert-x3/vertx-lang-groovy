package transform;

def closure = { /* Closure with no parameters */ ->
  vertx.eventBus().send("the-address", true)
}

closure()
