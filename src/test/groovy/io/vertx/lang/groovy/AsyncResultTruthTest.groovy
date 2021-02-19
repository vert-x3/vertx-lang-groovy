package io.vertx.lang.groovy

import io.vertx.core.Future
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author <a href="mailto:injecteer@gmail.com">Konstantin Smirnov</a>
 */
class AsyncResultTruthTest {

  @Test
  void testTrue() {
    def fut = Future.succeededFuture() 
    assertTrue fut
    assertEquals fut, fut.succeeded()
  }
  
  @Test
  void testFalse() {
    def fut = Future.failedFuture( 'fail' ) 
    assertFalse fut
    assertEquals fut, fut.failed()
  }
  
}
