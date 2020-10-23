package verticle

import io.vertx.core.Promise
import io.vertx.ext.unit.TestSuite

def vertxStart(Promise promise) {
  def suite = TestSuite.create("my_suite").test "timer_test", { context ->
    def async = context.async()
    vertx.setTimer 50, {
      context.fail(new Exception("the_failure"))
    }
  }
  suite.run().resolve((Promise)promise)
}
