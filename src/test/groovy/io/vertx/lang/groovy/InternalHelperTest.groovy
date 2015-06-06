package io.vertx.lang.groovy

import static org.junit.Assert.*;

import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import org.junit.Test;

/**
 * @author <a href="mailto:smfitts@gmail.com">Sean Fitts</a>
 */
class InternalHelperTest {
  /**
   * Confirm that when we convert to map/list form we do so recursively.
   */
  @Test
  void testWrapObject() {
    // Create a JsonObject with nested JsonObject and JsonArray values
    def obj = new JsonObject()
      .put('nestedObj', new JsonObject().put('key', 'value'))
      .put('nestedList', new JsonArray().add(new JsonObject().put('key', 'value')))
      
    // Get the wrapped form and confirm that it acted recursively
    Map<String, Object> wrapped = InternalHelper.wrapObject(obj)
    assertTrue(wrapped.get('nestedObj') instanceof Map)
    List<Object> theList = wrapped.get('nestedList')
    assertTrue(theList instanceof List)
    assertTrue(theList.getAt(0) instanceof Map)
  }
}
