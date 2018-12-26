package transform

import io.vertx.core.eventbus.Message

vertx.eventBus().consumer("foo", {
  Message<String> msg = it
  vertx.eventBus().send("the-address", true)
})

vertx.eventBus().send("foo", "bar")
