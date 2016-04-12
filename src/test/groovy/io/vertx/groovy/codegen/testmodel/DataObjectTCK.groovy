/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.groovy.codegen.testmodel;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.DataObjectWithMaps
import io.vertx.codegen.testmodel.DataObjectWithLists
import io.vertx.codegen.testmodel.DataObjectWithValues
/**
 * todo:
 * - Buffer support
*/
@CompileStatic
public class DataObjectTCK {
  private final def io.vertx.codegen.testmodel.DataObjectTCK delegate;
  public DataObjectTCK(Object delegate) {
    this.delegate = (io.vertx.codegen.testmodel.DataObjectTCK) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public Map<String, Object> getDataObjectWithValues() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.getDataObjectWithValues()?.toJson());
    return ret;
  }
  public void setDataObjectWithValues(Map<String, Object> dataObject = [:]) {
    delegate.setDataObjectWithValues(dataObject != null ? new io.vertx.codegen.testmodel.DataObjectWithValues(new io.vertx.core.json.JsonObject(dataObject)) : null);
  }
  public Map<String, Object> getDataObjectWithLists() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.getDataObjectWithLists()?.toJson());
    return ret;
  }
  public void setDataObjectWithLists(Map<String, Object> dataObject = [:]) {
    delegate.setDataObjectWithLists(dataObject != null ? new io.vertx.codegen.testmodel.DataObjectWithLists(new io.vertx.core.json.JsonObject(dataObject)) : null);
  }
  public Map<String, Object> getDataObjectWithMaps() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.getDataObjectWithMaps()?.toJson());
    return ret;
  }
  public void setDataObjectWithMaps(Map<String, Object> dataObject = [:]) {
    delegate.setDataObjectWithMaps(dataObject != null ? new io.vertx.codegen.testmodel.DataObjectWithMaps(new io.vertx.core.json.JsonObject(dataObject)) : null);
  }
}
