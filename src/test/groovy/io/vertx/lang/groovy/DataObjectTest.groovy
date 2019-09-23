package io.vertx.lang.groovy

import io.vertx.core.json.JsonObject
import io.vertx.lang.groovy.support.TestDataObject
import io.vertx.lang.groovy.support.TestDataObjectWithFailingConstructor
import io.vertx.lang.groovy.support.TestDataObjectWithNoJsonObjectConstructor
import org.codehaus.groovy.runtime.typehandling.GroovyCastException
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class DataObjectTest {
  @Test
  void testMapAsDataObject() {
    def map = ["foo": "bar"]
    def dataObject = map as TestDataObject
    assertEquals(dataObject.class, TestDataObject.class)
    def json = dataObject.json
    assertEquals(json.class, JsonObject.class)
    assertEquals("bar", json.getString("foo"))
  }

  @Test
  void testMapAsDataObjectWithNoJsonObjectConstructor() {
    def map = ["foo": "bar"]
    try {
      map as TestDataObjectWithNoJsonObjectConstructor
      fail()
    } catch (GroovyCastException ignore) {
    }
  }

  @Test
  void testMapAsDataObjectWithFailingConstructor() {
    def map = ["foo": "bar"]
    try {
      map as TestDataObjectWithFailingConstructor
      fail();
    } catch (Exception t) {
      assertSame(t, TestDataObjectWithFailingConstructor.cause)
    }
  }
}
