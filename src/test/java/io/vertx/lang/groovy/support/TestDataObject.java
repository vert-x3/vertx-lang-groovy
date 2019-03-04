package io.vertx.lang.groovy.support;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class TestDataObject {

  private JsonObject json;

  public TestDataObject() {
    json = new JsonObject();
  }

  public TestDataObject(JsonObject json) {
    this.json = json;
  }

  public JsonObject getJson() {
    return json;
  }

  public void setJson(JsonObject json) {
    this.json = json;
  }
}
