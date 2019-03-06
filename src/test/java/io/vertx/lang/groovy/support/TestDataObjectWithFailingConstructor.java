package io.vertx.lang.groovy.support;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class TestDataObjectWithFailingConstructor {

  public static final Exception cause = new Exception();

  public TestDataObjectWithFailingConstructor(JsonObject json) throws Exception {
    throw cause;
  }
}
