package io.vertx.lang.groovy;

import io.vertx.core.AsyncResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class AsyncResultChecker {

  int count = 0;

  void assertAsyncResult(Object expected, AsyncResult<?> result) {
    assertTrue(result.succeeded());
    assertFalse(result.failed());
    assertEquals(expected, result.result());
    assertNull(result.cause());
    count++;
  }

  void assertAsyncFailure(String expectedMsg, AsyncResult<?> result) {
    assertNull(result.result());
    assertFalse(result.succeeded());
    assertTrue(result.failed());
    assertEquals(expectedMsg, result.cause().getMessage());
    count++;
  }
}
