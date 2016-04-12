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
import java.util.Set
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.core.json.JsonArray
import java.util.List
import io.vertx.codegen.testmodel.TestEnum
import java.util.Map
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.TestGenEnum
/**
 * The TCK for @Nullable.
*/
@CompileStatic
public class NullableTCK {
  private final def io.vertx.codegen.testmodel.NullableTCK delegate;
  public NullableTCK(Object delegate) {
    this.delegate = (io.vertx.codegen.testmodel.NullableTCK) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public boolean methodWithNonNullableByteParam(Byte param) {
    def ret = delegate.methodWithNonNullableByteParam(param);
    return ret;
  }
  public void methodWithNullableByteParam(boolean expectNull, Byte param) {
    delegate.methodWithNullableByteParam(expectNull, param);
  }
  public void methodWithNullableByteHandler(boolean notNull, Handler<Byte> handler) {
    delegate.methodWithNullableByteHandler(notNull, handler);
  }
  public void methodWithNullableByteHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Byte>> handler) {
    delegate.methodWithNullableByteHandlerAsyncResult(notNull, handler);
  }
  public Byte methodWithNullableByteReturn(boolean notNull) {
    def ret = delegate.methodWithNullableByteReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableShortParam(Short param) {
    def ret = delegate.methodWithNonNullableShortParam(param);
    return ret;
  }
  public void methodWithNullableShortParam(boolean expectNull, Short param) {
    delegate.methodWithNullableShortParam(expectNull, param);
  }
  public void methodWithNullableShortHandler(boolean notNull, Handler<Short> handler) {
    delegate.methodWithNullableShortHandler(notNull, handler);
  }
  public void methodWithNullableShortHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Short>> handler) {
    delegate.methodWithNullableShortHandlerAsyncResult(notNull, handler);
  }
  public Short methodWithNullableShortReturn(boolean notNull) {
    def ret = delegate.methodWithNullableShortReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableIntegerParam(Integer param) {
    def ret = delegate.methodWithNonNullableIntegerParam(param);
    return ret;
  }
  public void methodWithNullableIntegerParam(boolean expectNull, Integer param) {
    delegate.methodWithNullableIntegerParam(expectNull, param);
  }
  public void methodWithNullableIntegerHandler(boolean notNull, Handler<Integer> handler) {
    delegate.methodWithNullableIntegerHandler(notNull, handler);
  }
  public void methodWithNullableIntegerHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Integer>> handler) {
    delegate.methodWithNullableIntegerHandlerAsyncResult(notNull, handler);
  }
  public Integer methodWithNullableIntegerReturn(boolean notNull) {
    def ret = delegate.methodWithNullableIntegerReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableLongParam(Long param) {
    def ret = delegate.methodWithNonNullableLongParam(param);
    return ret;
  }
  public void methodWithNullableLongParam(boolean expectNull, Long param) {
    delegate.methodWithNullableLongParam(expectNull, param);
  }
  public void methodWithNullableLongHandler(boolean notNull, Handler<Long> handler) {
    delegate.methodWithNullableLongHandler(notNull, handler);
  }
  public void methodWithNullableLongHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Long>> handler) {
    delegate.methodWithNullableLongHandlerAsyncResult(notNull, handler);
  }
  public Long methodWithNullableLongReturn(boolean notNull) {
    def ret = delegate.methodWithNullableLongReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableFloatParam(Float param) {
    def ret = delegate.methodWithNonNullableFloatParam(param);
    return ret;
  }
  public void methodWithNullableFloatParam(boolean expectNull, Float param) {
    delegate.methodWithNullableFloatParam(expectNull, param);
  }
  public void methodWithNullableFloatHandler(boolean notNull, Handler<Float> handler) {
    delegate.methodWithNullableFloatHandler(notNull, handler);
  }
  public void methodWithNullableFloatHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Float>> handler) {
    delegate.methodWithNullableFloatHandlerAsyncResult(notNull, handler);
  }
  public Float methodWithNullableFloatReturn(boolean notNull) {
    def ret = delegate.methodWithNullableFloatReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableDoubleParam(Double param) {
    def ret = delegate.methodWithNonNullableDoubleParam(param);
    return ret;
  }
  public void methodWithNullableDoubleParam(boolean expectNull, Double param) {
    delegate.methodWithNullableDoubleParam(expectNull, param);
  }
  public void methodWithNullableDoubleHandler(boolean notNull, Handler<Double> handler) {
    delegate.methodWithNullableDoubleHandler(notNull, handler);
  }
  public void methodWithNullableDoubleHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Double>> handler) {
    delegate.methodWithNullableDoubleHandlerAsyncResult(notNull, handler);
  }
  public Double methodWithNullableDoubleReturn(boolean notNull) {
    def ret = delegate.methodWithNullableDoubleReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableBooleanParam(Boolean param) {
    def ret = delegate.methodWithNonNullableBooleanParam(param);
    return ret;
  }
  public void methodWithNullableBooleanParam(boolean expectNull, Boolean param) {
    delegate.methodWithNullableBooleanParam(expectNull, param);
  }
  public void methodWithNullableBooleanHandler(boolean notNull, Handler<Boolean> handler) {
    delegate.methodWithNullableBooleanHandler(notNull, handler);
  }
  public void methodWithNullableBooleanHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Boolean>> handler) {
    delegate.methodWithNullableBooleanHandlerAsyncResult(notNull, handler);
  }
  public Boolean methodWithNullableBooleanReturn(boolean notNull) {
    def ret = delegate.methodWithNullableBooleanReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableStringParam(String param) {
    def ret = delegate.methodWithNonNullableStringParam(param);
    return ret;
  }
  public void methodWithNullableStringParam(boolean expectNull, String param) {
    delegate.methodWithNullableStringParam(expectNull, param);
  }
  public void methodWithNullableStringHandler(boolean notNull, Handler<String> handler) {
    delegate.methodWithNullableStringHandler(notNull, handler);
  }
  public void methodWithNullableStringHandlerAsyncResult(boolean notNull, Handler<AsyncResult<String>> handler) {
    delegate.methodWithNullableStringHandlerAsyncResult(notNull, handler);
  }
  public String methodWithNullableStringReturn(boolean notNull) {
    def ret = delegate.methodWithNullableStringReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableCharParam(Character param) {
    def ret = delegate.methodWithNonNullableCharParam(param);
    return ret;
  }
  public void methodWithNullableCharParam(boolean expectNull, Character param) {
    delegate.methodWithNullableCharParam(expectNull, param);
  }
  public void methodWithNullableCharHandler(boolean notNull, Handler<Character> handler) {
    delegate.methodWithNullableCharHandler(notNull, handler);
  }
  public void methodWithNullableCharHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Character>> handler) {
    delegate.methodWithNullableCharHandlerAsyncResult(notNull, handler);
  }
  public Character methodWithNullableCharReturn(boolean notNull) {
    def ret = delegate.methodWithNullableCharReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableJsonObjectParam(Map<String, Object> param) {
    def ret = delegate.methodWithNonNullableJsonObjectParam(param != null ? new io.vertx.core.json.JsonObject(param) : null);
    return ret;
  }
  public void methodWithNullableJsonObjectParam(boolean expectNull, Map<String, Object> param) {
    delegate.methodWithNullableJsonObjectParam(expectNull, param != null ? new io.vertx.core.json.JsonObject(param) : null);
  }
  public void methodWithNullableJsonObjectHandler(boolean notNull, Handler<Map<String, Object>> handler) {
    delegate.methodWithNullableJsonObjectHandler(notNull, handler != null ? new Handler<io.vertx.core.json.JsonObject>(){
      public void handle(io.vertx.core.json.JsonObject event) {
        handler.handle((Map<String, Object>)InternalHelper.wrapObject(event));
      }
    } : null);
  }
  public void methodWithNullableJsonObjectHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Object>>> handler) {
    delegate.methodWithNullableJsonObjectHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonObject>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonObject> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, Object> methodWithNullableJsonObjectReturn(boolean notNull) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.methodWithNullableJsonObjectReturn(notNull));
    return ret;
  }
  public boolean methodWithNonNullableJsonArrayParam(List<Object> param) {
    def ret = delegate.methodWithNonNullableJsonArrayParam(param != null ? new io.vertx.core.json.JsonArray(param) : null);
    return ret;
  }
  public void methodWithNullableJsonArrayParam(boolean expectNull, List<Object> param) {
    delegate.methodWithNullableJsonArrayParam(expectNull, param != null ? new io.vertx.core.json.JsonArray(param) : null);
  }
  public void methodWithNullableJsonArrayHandler(boolean notNull, Handler<List<Object>> handler) {
    delegate.methodWithNullableJsonArrayHandler(notNull, handler != null ? new Handler<io.vertx.core.json.JsonArray>(){
      public void handle(io.vertx.core.json.JsonArray event) {
        handler.handle((List<Object>)InternalHelper.wrapObject(event));
      }
    } : null);
  }
  public void methodWithNullableJsonArrayHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Object>>> handler) {
    delegate.methodWithNullableJsonArrayHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Object> methodWithNullableJsonArrayReturn(boolean notNull) {
    def ret = (List<Object>)InternalHelper.wrapObject(delegate.methodWithNullableJsonArrayReturn(notNull));
    return ret;
  }
  public boolean methodWithNonNullableApiParam(RefedInterface1 param) {
    def ret = delegate.methodWithNonNullableApiParam(param != null ? (io.vertx.codegen.testmodel.RefedInterface1)param.getDelegate() : null);
    return ret;
  }
  public void methodWithNullableApiParam(boolean expectNull, RefedInterface1 param) {
    delegate.methodWithNullableApiParam(expectNull, param != null ? (io.vertx.codegen.testmodel.RefedInterface1)param.getDelegate() : null);
  }
  public void methodWithNullableApiHandler(boolean notNull, Handler<RefedInterface1> handler) {
    delegate.methodWithNullableApiHandler(notNull, handler != null ? new Handler<io.vertx.codegen.testmodel.RefedInterface1>(){
      public void handle(io.vertx.codegen.testmodel.RefedInterface1 event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.codegen.testmodel.RefedInterface1.class));
      }
    } : null);
  }
  public void methodWithNullableApiHandlerAsyncResult(boolean notNull, Handler<AsyncResult<RefedInterface1>> handler) {
    delegate.methodWithNullableApiHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<io.vertx.codegen.testmodel.RefedInterface1>>() {
      public void handle(AsyncResult<io.vertx.codegen.testmodel.RefedInterface1> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.codegen.testmodel.RefedInterface1.class)));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public RefedInterface1 methodWithNullableApiReturn(boolean notNull) {
    def ret = InternalHelper.safeCreate(delegate.methodWithNullableApiReturn(notNull), io.vertx.groovy.codegen.testmodel.RefedInterface1.class);
    return ret;
  }
  public boolean methodWithNonNullableDataObjectParam(Map<String, Object> param = [:]) {
    def ret = delegate.methodWithNonNullableDataObjectParam(param != null ? new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(param)) : null);
    return ret;
  }
  public void methodWithNullableDataObjectParam(boolean expectNull, Map<String, Object> param) {
    delegate.methodWithNullableDataObjectParam(expectNull, param != null ? new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(param)) : null);
  }
  public void methodWithNullableDataObjectHandler(boolean notNull, Handler<Map<String, Object>> handler) {
    delegate.methodWithNullableDataObjectHandler(notNull, handler != null ? new Handler<io.vertx.codegen.testmodel.TestDataObject>(){
      public void handle(io.vertx.codegen.testmodel.TestDataObject event) {
        handler.handle((Map<String, Object>)InternalHelper.wrapObject(event?.toJson()));
      }
    } : null);
  }
  public void methodWithNullableDataObjectHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Object>>> handler) {
    delegate.methodWithNullableDataObjectHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<io.vertx.codegen.testmodel.TestDataObject>>() {
      public void handle(AsyncResult<io.vertx.codegen.testmodel.TestDataObject> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, Object> methodWithNullableDataObjectReturn(boolean notNull) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.methodWithNullableDataObjectReturn(notNull)?.toJson());
    return ret;
  }
  public boolean methodWithNonNullableEnumParam(TestEnum param) {
    def ret = delegate.methodWithNonNullableEnumParam(param);
    return ret;
  }
  public void methodWithNullableEnumParam(boolean expectNull, TestEnum param) {
    delegate.methodWithNullableEnumParam(expectNull, param);
  }
  public void methodWithNullableEnumHandler(boolean notNull, Handler<TestEnum> handler) {
    delegate.methodWithNullableEnumHandler(notNull, handler);
  }
  public void methodWithNullableEnumHandlerAsyncResult(boolean notNull, Handler<AsyncResult<TestEnum>> handler) {
    delegate.methodWithNullableEnumHandlerAsyncResult(notNull, handler);
  }
  public TestEnum methodWithNullableEnumReturn(boolean notNull) {
    def ret = delegate.methodWithNullableEnumReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableGenEnumParam(TestGenEnum param) {
    def ret = delegate.methodWithNonNullableGenEnumParam(param);
    return ret;
  }
  public void methodWithNullableGenEnumParam(boolean expectNull, TestGenEnum param) {
    delegate.methodWithNullableGenEnumParam(expectNull, param);
  }
  public void methodWithNullableGenEnumHandler(boolean notNull, Handler<TestGenEnum> handler) {
    delegate.methodWithNullableGenEnumHandler(notNull, handler);
  }
  public void methodWithNullableGenEnumHandlerAsyncResult(boolean notNull, Handler<AsyncResult<TestGenEnum>> handler) {
    delegate.methodWithNullableGenEnumHandlerAsyncResult(notNull, handler);
  }
  public TestGenEnum methodWithNullableGenEnumReturn(boolean notNull) {
    def ret = delegate.methodWithNullableGenEnumReturn(notNull);
    return ret;
  }
  public <T> void methodWithNullableTypeVariableParam(boolean expectNull, T param) {
    delegate.methodWithNullableTypeVariableParam(expectNull, param != null ? InternalHelper.unwrapObject(param) : null);
  }
  public <T> void methodWithNullableTypeVariableHandler(boolean notNull, T value, Handler<T> handler) {
    delegate.methodWithNullableTypeVariableHandler(notNull, value != null ? InternalHelper.unwrapObject(value) : null, handler != null ? new Handler<java.lang.Object>(){
      public void handle(java.lang.Object event) {
        handler.handle((Object) InternalHelper.wrapObject(event));
      }
    } : null);
  }
  public <T> void methodWithNullableTypeVariableHandlerAsyncResult(boolean notNull, T value, Handler<AsyncResult<T>> handler) {
    delegate.methodWithNullableTypeVariableHandlerAsyncResult(notNull, value != null ? InternalHelper.unwrapObject(value) : null, handler != null ? new Handler<AsyncResult<java.lang.Object>>() {
      public void handle(AsyncResult<java.lang.Object> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Object) InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public <T> T methodWithNullableTypeVariableReturn(boolean notNull, T value) {
    def ret = (T) InternalHelper.wrapObject(delegate.methodWithNullableTypeVariableReturn(notNull, value != null ? InternalHelper.unwrapObject(value) : null));
    return ret;
  }
  public void methodWithNullableObjectParam(boolean expectNull, Object param) {
    delegate.methodWithNullableObjectParam(expectNull, param != null ? InternalHelper.unwrapObject(param) : null);
  }
  public boolean methodWithNonNullableListByteParam(List<Byte> param) {
    def ret = delegate.methodWithNonNullableListByteParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListByteParam(boolean expectNull, List<Byte> param) {
    delegate.methodWithNullableListByteParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListByteHandler(boolean notNull, Handler<List<Byte>> handler) {
    delegate.methodWithNullableListByteHandler(notNull, handler != null ? new Handler<java.util.List<java.lang.Byte>>(){
      public void handle(java.util.List<java.lang.Byte> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListByteHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Byte>>> handler) {
    delegate.methodWithNullableListByteHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Byte>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Byte>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Byte> methodWithNullableListByteReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListByteReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableListShortParam(List<Short> param) {
    def ret = delegate.methodWithNonNullableListShortParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListShortParam(boolean expectNull, List<Short> param) {
    delegate.methodWithNullableListShortParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListShortHandler(boolean notNull, Handler<List<Short>> handler) {
    delegate.methodWithNullableListShortHandler(notNull, handler != null ? new Handler<java.util.List<java.lang.Short>>(){
      public void handle(java.util.List<java.lang.Short> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListShortHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Short>>> handler) {
    delegate.methodWithNullableListShortHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Short>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Short>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Short> methodWithNullableListShortReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListShortReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableListIntegerParam(List<Integer> param) {
    def ret = delegate.methodWithNonNullableListIntegerParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListIntegerParam(boolean expectNull, List<Integer> param) {
    delegate.methodWithNullableListIntegerParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListIntegerHandler(boolean notNull, Handler<List<Integer>> handler) {
    delegate.methodWithNullableListIntegerHandler(notNull, handler != null ? new Handler<java.util.List<java.lang.Integer>>(){
      public void handle(java.util.List<java.lang.Integer> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListIntegerHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Integer>>> handler) {
    delegate.methodWithNullableListIntegerHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Integer> methodWithNullableListIntegerReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListIntegerReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableListLongParam(List<Long> param) {
    def ret = delegate.methodWithNonNullableListLongParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListLongParam(boolean expectNull, List<Long> param) {
    delegate.methodWithNullableListLongParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListLongHandler(boolean notNull, Handler<List<Long>> handler) {
    delegate.methodWithNullableListLongHandler(notNull, handler != null ? new Handler<java.util.List<java.lang.Long>>(){
      public void handle(java.util.List<java.lang.Long> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListLongHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Long>>> handler) {
    delegate.methodWithNullableListLongHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Long>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Long>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Long> methodWithNullableListLongReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListLongReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableListFloatParam(List<Float> param) {
    def ret = delegate.methodWithNonNullableListFloatParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListFloatParam(boolean expectNull, List<Float> param) {
    delegate.methodWithNullableListFloatParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListFloatHandler(boolean notNull, Handler<List<Float>> handler) {
    delegate.methodWithNullableListFloatHandler(notNull, handler != null ? new Handler<java.util.List<java.lang.Float>>(){
      public void handle(java.util.List<java.lang.Float> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListFloatHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Float>>> handler) {
    delegate.methodWithNullableListFloatHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Float>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Float>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Float> methodWithNullableListFloatReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListFloatReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableListDoubleParam(List<Double> param) {
    def ret = delegate.methodWithNonNullableListDoubleParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListDoubleParam(boolean expectNull, List<Double> param) {
    delegate.methodWithNullableListDoubleParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListDoubleHandler(boolean notNull, Handler<List<Double>> handler) {
    delegate.methodWithNullableListDoubleHandler(notNull, handler != null ? new Handler<java.util.List<java.lang.Double>>(){
      public void handle(java.util.List<java.lang.Double> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListDoubleHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Double>>> handler) {
    delegate.methodWithNullableListDoubleHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Double>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Double>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Double> methodWithNullableListDoubleReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListDoubleReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableListBooleanParam(List<Boolean> param) {
    def ret = delegate.methodWithNonNullableListBooleanParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListBooleanParam(boolean expectNull, List<Boolean> param) {
    delegate.methodWithNullableListBooleanParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListBooleanHandler(boolean notNull, Handler<List<Boolean>> handler) {
    delegate.methodWithNullableListBooleanHandler(notNull, handler != null ? new Handler<java.util.List<java.lang.Boolean>>(){
      public void handle(java.util.List<java.lang.Boolean> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListBooleanHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Boolean>>> handler) {
    delegate.methodWithNullableListBooleanHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Boolean>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Boolean>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Boolean> methodWithNullableListBooleanReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListBooleanReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableListStringParam(List<String> param) {
    def ret = delegate.methodWithNonNullableListStringParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListStringParam(boolean expectNull, List<String> param) {
    delegate.methodWithNullableListStringParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListStringHandler(boolean notNull, Handler<List<String>> handler) {
    delegate.methodWithNullableListStringHandler(notNull, handler != null ? new Handler<java.util.List<java.lang.String>>(){
      public void handle(java.util.List<java.lang.String> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListStringHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<String>>> handler) {
    delegate.methodWithNullableListStringHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<String> methodWithNullableListStringReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListStringReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableListCharParam(List<Character> param) {
    def ret = delegate.methodWithNonNullableListCharParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListCharParam(boolean expectNull, List<Character> param) {
    delegate.methodWithNullableListCharParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListCharHandler(boolean notNull, Handler<List<Character>> handler) {
    delegate.methodWithNullableListCharHandler(notNull, handler != null ? new Handler<java.util.List<java.lang.Character>>(){
      public void handle(java.util.List<java.lang.Character> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListCharHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Character>>> handler) {
    delegate.methodWithNullableListCharHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Character>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Character>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Character> methodWithNullableListCharReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListCharReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableListJsonObjectParam(List<Map<String, Object>> param) {
    def ret = delegate.methodWithNonNullableListJsonObjectParam(param != null ? (List)param.collect({new io.vertx.core.json.JsonObject(it)}) : null);
    return ret;
  }
  public void methodWithNullableListJsonObjectParam(boolean expectNull, List<Map<String, Object>> param) {
    delegate.methodWithNullableListJsonObjectParam(expectNull, param != null ? (List)param.collect({new io.vertx.core.json.JsonObject(it)}) : null);
  }
  public void methodWithNullableListJsonObjectHandler(boolean notNull, Handler<List<Map<String, Object>>> handler) {
    delegate.methodWithNullableListJsonObjectHandler(notNull, handler != null ? new Handler<java.util.List<io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.List<io.vertx.core.json.JsonObject> event) {
        handler.handle((List)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}));
      }
    } : null);
  }
  public void methodWithNullableListJsonObjectHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Map<String, Object>>>> handler) {
    delegate.methodWithNullableListJsonObjectHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Map<String, Object>> methodWithNullableListJsonObjectReturn(boolean notNull) {
    def ret = (List)delegate.methodWithNullableListJsonObjectReturn(notNull)?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)});
    return ret;
  }
  public boolean methodWithNonNullableListJsonArrayParam(List<List<Object>> param) {
    def ret = delegate.methodWithNonNullableListJsonArrayParam(param != null ? (List)param.collect({new io.vertx.core.json.JsonArray(it)}) : null);
    return ret;
  }
  public void methodWithNullableListJsonArrayParam(boolean expectNull, List<List<Object>> param) {
    delegate.methodWithNullableListJsonArrayParam(expectNull, param != null ? (List)param.collect({new io.vertx.core.json.JsonArray(it)}) : null);
  }
  public void methodWithNullableListJsonArrayHandler(boolean notNull, Handler<List<List<Object>>> handler) {
    delegate.methodWithNullableListJsonArrayHandler(notNull, handler != null ? new Handler<java.util.List<io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.List<io.vertx.core.json.JsonArray> event) {
        handler.handle((List)event?.collect({(List<Object>)InternalHelper.wrapObject(it)}));
      }
    } : null);
  }
  public void methodWithNullableListJsonArrayHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<List<Object>>>> handler) {
    delegate.methodWithNullableListJsonArrayHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(List<Object>)InternalHelper.wrapObject(it)})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<List<Object>> methodWithNullableListJsonArrayReturn(boolean notNull) {
    def ret = (List)delegate.methodWithNullableListJsonArrayReturn(notNull)?.collect({(List<Object>)InternalHelper.wrapObject(it)});
    return ret;
  }
  public boolean methodWithNonNullableListApiParam(List<RefedInterface1> param) {
    def ret = delegate.methodWithNonNullableListApiParam(param != null ? (List)param.collect({(io.vertx.codegen.testmodel.RefedInterface1)it.getDelegate()}) : null);
    return ret;
  }
  public void methodWithNullableListApiParam(boolean expectNull, List<RefedInterface1> param) {
    delegate.methodWithNullableListApiParam(expectNull, param != null ? (List)param.collect({(io.vertx.codegen.testmodel.RefedInterface1)it.getDelegate()}) : null);
  }
  public void methodWithNullableListApiHandler(boolean notNull, Handler<List<RefedInterface1>> handler) {
    delegate.methodWithNullableListApiHandler(notNull, handler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.RefedInterface1>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.RefedInterface1> event) {
        handler.handle((List)event?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}));
      }
    } : null);
  }
  public void methodWithNullableListApiHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<RefedInterface1>>> handler) {
    delegate.methodWithNullableListApiHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.RefedInterface1>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.RefedInterface1>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<RefedInterface1> methodWithNullableListApiReturn(boolean notNull) {
    def ret = (List)delegate.methodWithNullableListApiReturn(notNull)?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)});
    return ret;
  }
  public boolean methodWithNonNullableListDataObjectParam(List<Map<String, Object>> param) {
    def ret = delegate.methodWithNonNullableListDataObjectParam(param != null ? (List)param.collect({new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(it))}) : null);
    return ret;
  }
  public void methodWithNullableListDataObjectParam(boolean expectNull, List<Map<String, Object>> param) {
    delegate.methodWithNullableListDataObjectParam(expectNull, param != null ? (List)param.collect({new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(it))}) : null);
  }
  public void methodWithNullableListDataObjectHandler(boolean notNull, Handler<List<Map<String, Object>>> handler) {
    delegate.methodWithNullableListDataObjectHandler(notNull, handler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.TestDataObject>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.TestDataObject> event) {
        handler.handle((List)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}));
      }
    } : null);
  }
  public void methodWithNullableListDataObjectHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<Map<String, Object>>>> handler) {
    delegate.methodWithNullableListDataObjectHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestDataObject>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestDataObject>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Map<String, Object>> methodWithNullableListDataObjectReturn(boolean notNull) {
    def ret = (List)delegate.methodWithNullableListDataObjectReturn(notNull)?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())});
    return ret;
  }
  public boolean methodWithNonNullableListEnumParam(List<TestEnum> param) {
    def ret = delegate.methodWithNonNullableListEnumParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListEnumParam(boolean expectNull, List<TestEnum> param) {
    delegate.methodWithNullableListEnumParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListEnumHandler(boolean notNull, Handler<List<TestEnum>> handler) {
    delegate.methodWithNullableListEnumHandler(notNull, handler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.TestEnum>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.TestEnum> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListEnumHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<TestEnum>>> handler) {
    delegate.methodWithNullableListEnumHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestEnum>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestEnum>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<TestEnum> methodWithNullableListEnumReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListEnumReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableListGenEnumParam(List<TestGenEnum> param) {
    def ret = delegate.methodWithNonNullableListGenEnumParam(param != null ? (List)param.collect({it}) : null);
    return ret;
  }
  public void methodWithNullableListGenEnumParam(boolean expectNull, List<TestGenEnum> param) {
    delegate.methodWithNullableListGenEnumParam(expectNull, param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithNullableListGenEnumHandler(boolean notNull, Handler<List<TestGenEnum>> handler) {
    delegate.methodWithNullableListGenEnumHandler(notNull, handler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.TestGenEnum>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.TestGenEnum> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableListGenEnumHandlerAsyncResult(boolean notNull, Handler<AsyncResult<List<TestGenEnum>>> handler) {
    delegate.methodWithNullableListGenEnumHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestGenEnum>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestGenEnum>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<TestGenEnum> methodWithNullableListGenEnumReturn(boolean notNull) {
    def ret = delegate.methodWithNullableListGenEnumReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetByteParam(Set<Byte> param) {
    def ret = delegate.methodWithNonNullableSetByteParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetByteParam(boolean expectNull, Set<Byte> param) {
    delegate.methodWithNullableSetByteParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetByteHandler(boolean notNull, Handler<Set<Byte>> handler) {
    delegate.methodWithNullableSetByteHandler(notNull, handler != null ? new Handler<java.util.Set<java.lang.Byte>>(){
      public void handle(java.util.Set<java.lang.Byte> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetByteHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<Byte>>> handler) {
    delegate.methodWithNullableSetByteHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Byte>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Byte>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Byte> methodWithNullableSetByteReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetByteReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetShortParam(Set<Short> param) {
    def ret = delegate.methodWithNonNullableSetShortParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetShortParam(boolean expectNull, Set<Short> param) {
    delegate.methodWithNullableSetShortParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetShortHandler(boolean notNull, Handler<Set<Short>> handler) {
    delegate.methodWithNullableSetShortHandler(notNull, handler != null ? new Handler<java.util.Set<java.lang.Short>>(){
      public void handle(java.util.Set<java.lang.Short> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetShortHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<Short>>> handler) {
    delegate.methodWithNullableSetShortHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Short>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Short>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Short> methodWithNullableSetShortReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetShortReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetIntegerParam(Set<Integer> param) {
    def ret = delegate.methodWithNonNullableSetIntegerParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetIntegerParam(boolean expectNull, Set<Integer> param) {
    delegate.methodWithNullableSetIntegerParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetIntegerHandler(boolean notNull, Handler<Set<Integer>> handler) {
    delegate.methodWithNullableSetIntegerHandler(notNull, handler != null ? new Handler<java.util.Set<java.lang.Integer>>(){
      public void handle(java.util.Set<java.lang.Integer> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetIntegerHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<Integer>>> handler) {
    delegate.methodWithNullableSetIntegerHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Integer> methodWithNullableSetIntegerReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetIntegerReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetLongParam(Set<Long> param) {
    def ret = delegate.methodWithNonNullableSetLongParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetLongParam(boolean expectNull, Set<Long> param) {
    delegate.methodWithNullableSetLongParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetLongHandler(boolean notNull, Handler<Set<Long>> handler) {
    delegate.methodWithNullableSetLongHandler(notNull, handler != null ? new Handler<java.util.Set<java.lang.Long>>(){
      public void handle(java.util.Set<java.lang.Long> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetLongHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<Long>>> handler) {
    delegate.methodWithNullableSetLongHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Long>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Long>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Long> methodWithNullableSetLongReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetLongReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetFloatParam(Set<Float> param) {
    def ret = delegate.methodWithNonNullableSetFloatParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetFloatParam(boolean expectNull, Set<Float> param) {
    delegate.methodWithNullableSetFloatParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetFloatHandler(boolean notNull, Handler<Set<Float>> handler) {
    delegate.methodWithNullableSetFloatHandler(notNull, handler != null ? new Handler<java.util.Set<java.lang.Float>>(){
      public void handle(java.util.Set<java.lang.Float> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetFloatHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<Float>>> handler) {
    delegate.methodWithNullableSetFloatHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Float>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Float>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Float> methodWithNullableSetFloatReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetFloatReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetDoubleParam(Set<Double> param) {
    def ret = delegate.methodWithNonNullableSetDoubleParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetDoubleParam(boolean expectNull, Set<Double> param) {
    delegate.methodWithNullableSetDoubleParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetDoubleHandler(boolean notNull, Handler<Set<Double>> handler) {
    delegate.methodWithNullableSetDoubleHandler(notNull, handler != null ? new Handler<java.util.Set<java.lang.Double>>(){
      public void handle(java.util.Set<java.lang.Double> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetDoubleHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<Double>>> handler) {
    delegate.methodWithNullableSetDoubleHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Double>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Double>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Double> methodWithNullableSetDoubleReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetDoubleReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetBooleanParam(Set<Boolean> param) {
    def ret = delegate.methodWithNonNullableSetBooleanParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetBooleanParam(boolean expectNull, Set<Boolean> param) {
    delegate.methodWithNullableSetBooleanParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetBooleanHandler(boolean notNull, Handler<Set<Boolean>> handler) {
    delegate.methodWithNullableSetBooleanHandler(notNull, handler != null ? new Handler<java.util.Set<java.lang.Boolean>>(){
      public void handle(java.util.Set<java.lang.Boolean> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetBooleanHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<Boolean>>> handler) {
    delegate.methodWithNullableSetBooleanHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Boolean>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Boolean>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Boolean> methodWithNullableSetBooleanReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetBooleanReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetStringParam(Set<String> param) {
    def ret = delegate.methodWithNonNullableSetStringParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetStringParam(boolean expectNull, Set<String> param) {
    delegate.methodWithNullableSetStringParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetStringHandler(boolean notNull, Handler<Set<String>> handler) {
    delegate.methodWithNullableSetStringHandler(notNull, handler != null ? new Handler<java.util.Set<java.lang.String>>(){
      public void handle(java.util.Set<java.lang.String> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetStringHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<String>>> handler) {
    delegate.methodWithNullableSetStringHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<String> methodWithNullableSetStringReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetStringReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetCharParam(Set<Character> param) {
    def ret = delegate.methodWithNonNullableSetCharParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetCharParam(boolean expectNull, Set<Character> param) {
    delegate.methodWithNullableSetCharParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetCharHandler(boolean notNull, Handler<Set<Character>> handler) {
    delegate.methodWithNullableSetCharHandler(notNull, handler != null ? new Handler<java.util.Set<java.lang.Character>>(){
      public void handle(java.util.Set<java.lang.Character> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetCharHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<Character>>> handler) {
    delegate.methodWithNullableSetCharHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Character>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Character>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Character> methodWithNullableSetCharReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetCharReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetJsonObjectParam(Set<Map<String, Object>> param) {
    def ret = delegate.methodWithNonNullableSetJsonObjectParam(param != null ? (Set)param.collect({new io.vertx.core.json.JsonObject(it)}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetJsonObjectParam(boolean expectNull, Set<Map<String, Object>> param) {
    delegate.methodWithNullableSetJsonObjectParam(expectNull, param != null ? (Set)param.collect({new io.vertx.core.json.JsonObject(it)}) as Set : null);
  }
  public void methodWithNullableSetJsonObjectHandler(boolean notNull, Handler<Set<Map<String, Object>>> handler) {
    delegate.methodWithNullableSetJsonObjectHandler(notNull, handler != null ? new Handler<java.util.Set<io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.Set<io.vertx.core.json.JsonObject> event) {
        handler.handle((Set)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set);
      }
    } : null);
  }
  public void methodWithNullableSetJsonObjectHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<Map<String, Object>>>> handler) {
    delegate.methodWithNullableSetJsonObjectHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Map<String, Object>> methodWithNullableSetJsonObjectReturn(boolean notNull) {
    def ret = (Set)delegate.methodWithNullableSetJsonObjectReturn(notNull)?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set;
    return ret;
  }
  public boolean methodWithNonNullableSetJsonArrayParam(Set<List<Object>> param) {
    def ret = delegate.methodWithNonNullableSetJsonArrayParam(param != null ? (Set)param.collect({new io.vertx.core.json.JsonArray(it)}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetJsonArrayParam(boolean expectNull, Set<List<Object>> param) {
    delegate.methodWithNullableSetJsonArrayParam(expectNull, param != null ? (Set)param.collect({new io.vertx.core.json.JsonArray(it)}) as Set : null);
  }
  public void methodWithNullableSetJsonArrayHandler(boolean notNull, Handler<Set<List<Object>>> handler) {
    delegate.methodWithNullableSetJsonArrayHandler(notNull, handler != null ? new Handler<java.util.Set<io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.Set<io.vertx.core.json.JsonArray> event) {
        handler.handle((Set)event?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set);
      }
    } : null);
  }
  public void methodWithNullableSetJsonArrayHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<List<Object>>>> handler) {
    delegate.methodWithNullableSetJsonArrayHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<List<Object>> methodWithNullableSetJsonArrayReturn(boolean notNull) {
    def ret = (Set)delegate.methodWithNullableSetJsonArrayReturn(notNull)?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set;
    return ret;
  }
  public boolean methodWithNonNullableSetApiParam(Set<RefedInterface1> param) {
    def ret = delegate.methodWithNonNullableSetApiParam(param != null ? (Set)param.collect({(io.vertx.codegen.testmodel.RefedInterface1)it.getDelegate()}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetApiParam(boolean expectNull, Set<RefedInterface1> param) {
    delegate.methodWithNullableSetApiParam(expectNull, param != null ? (Set)param.collect({(io.vertx.codegen.testmodel.RefedInterface1)it.getDelegate()}) as Set : null);
  }
  public void methodWithNullableSetApiHandler(boolean notNull, Handler<Set<RefedInterface1>> handler) {
    delegate.methodWithNullableSetApiHandler(notNull, handler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.RefedInterface1>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.RefedInterface1> event) {
        handler.handle((Set)event?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}) as Set);
      }
    } : null);
  }
  public void methodWithNullableSetApiHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<RefedInterface1>>> handler) {
    delegate.methodWithNullableSetApiHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.RefedInterface1>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.RefedInterface1>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}) as Set));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<RefedInterface1> methodWithNullableSetApiReturn(boolean notNull) {
    def ret = (Set)delegate.methodWithNullableSetApiReturn(notNull)?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}) as Set;
    return ret;
  }
  public boolean methodWithNonNullableSetDataObjectParam(Set<Map<String, Object>> param) {
    def ret = delegate.methodWithNonNullableSetDataObjectParam(param != null ? (Set)param.collect({new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(it))}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetDataObjectParam(boolean expectNull, Set<Map<String, Object>> param) {
    delegate.methodWithNullableSetDataObjectParam(expectNull, param != null ? (Set)param.collect({new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(it))}) as Set : null);
  }
  public void methodWithNullableSetDataObjectHandler(boolean notNull, Handler<Set<Map<String, Object>>> handler) {
    delegate.methodWithNullableSetDataObjectHandler(notNull, handler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.TestDataObject> event) {
        handler.handle((Set)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set);
      }
    } : null);
  }
  public void methodWithNullableSetDataObjectHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<Map<String, Object>>>> handler) {
    delegate.methodWithNullableSetDataObjectHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Map<String, Object>> methodWithNullableSetDataObjectReturn(boolean notNull) {
    def ret = (Set)delegate.methodWithNullableSetDataObjectReturn(notNull)?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set;
    return ret;
  }
  public boolean methodWithNonNullableSetEnumParam(Set<TestEnum> param) {
    def ret = delegate.methodWithNonNullableSetEnumParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetEnumParam(boolean expectNull, Set<TestEnum> param) {
    delegate.methodWithNullableSetEnumParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetEnumHandler(boolean notNull, Handler<Set<TestEnum>> handler) {
    delegate.methodWithNullableSetEnumHandler(notNull, handler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.TestEnum>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.TestEnum> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetEnumHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<TestEnum>>> handler) {
    delegate.methodWithNullableSetEnumHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestEnum>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestEnum>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<TestEnum> methodWithNullableSetEnumReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetEnumReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableSetGenEnumParam(Set<TestGenEnum> param) {
    def ret = delegate.methodWithNonNullableSetGenEnumParam(param != null ? (Set)param.collect({it}) as Set : null);
    return ret;
  }
  public void methodWithNullableSetGenEnumParam(boolean expectNull, Set<TestGenEnum> param) {
    delegate.methodWithNullableSetGenEnumParam(expectNull, param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithNullableSetGenEnumHandler(boolean notNull, Handler<Set<TestGenEnum>> handler) {
    delegate.methodWithNullableSetGenEnumHandler(notNull, handler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.TestGenEnum>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.TestGenEnum> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableSetGenEnumHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Set<TestGenEnum>>> handler) {
    delegate.methodWithNullableSetGenEnumHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestGenEnum>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestGenEnum>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<TestGenEnum> methodWithNullableSetGenEnumReturn(boolean notNull) {
    def ret = delegate.methodWithNullableSetGenEnumReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableMapByteParam(Map<String, Byte> param) {
    def ret = delegate.methodWithNonNullableMapByteParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
    return ret;
  }
  public void methodWithNullableMapByteParam(boolean expectNull, Map<String, Byte> param) {
    delegate.methodWithNullableMapByteParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithNullableMapByteHandler(boolean notNull, Handler<Map<String, Byte>> handler) {
    delegate.methodWithNullableMapByteHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Byte>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Byte> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableMapByteHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Byte>>> handler) {
    delegate.methodWithNullableMapByteHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Byte>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Byte>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Byte>> methodWithNullableMapByteReturn(boolean notNull) {
    def ret = delegate.methodWithNullableMapByteReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableMapShortParam(Map<String, Short> param) {
    def ret = delegate.methodWithNonNullableMapShortParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
    return ret;
  }
  public void methodWithNullableMapShortParam(boolean expectNull, Map<String, Short> param) {
    delegate.methodWithNullableMapShortParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithNullableMapShortHandler(boolean notNull, Handler<Map<String, Short>> handler) {
    delegate.methodWithNullableMapShortHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Short>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Short> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableMapShortHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Short>>> handler) {
    delegate.methodWithNullableMapShortHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Short>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Short>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Short>> methodWithNullableMapShortReturn(boolean notNull) {
    def ret = delegate.methodWithNullableMapShortReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableMapIntegerParam(Map<String, Integer> param) {
    def ret = delegate.methodWithNonNullableMapIntegerParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
    return ret;
  }
  public void methodWithNullableMapIntegerParam(boolean expectNull, Map<String, Integer> param) {
    delegate.methodWithNullableMapIntegerParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithNullableMapIntegerHandler(boolean notNull, Handler<Map<String, Integer>> handler) {
    delegate.methodWithNullableMapIntegerHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Integer>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Integer> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableMapIntegerHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Integer>>> handler) {
    delegate.methodWithNullableMapIntegerHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Integer>> methodWithNullableMapIntegerReturn(boolean notNull) {
    def ret = delegate.methodWithNullableMapIntegerReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableMapLongParam(Map<String, Long> param) {
    def ret = delegate.methodWithNonNullableMapLongParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
    return ret;
  }
  public void methodWithNullableMapLongParam(boolean expectNull, Map<String, Long> param) {
    delegate.methodWithNullableMapLongParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithNullableMapLongHandler(boolean notNull, Handler<Map<String, Long>> handler) {
    delegate.methodWithNullableMapLongHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Long>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Long> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableMapLongHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Long>>> handler) {
    delegate.methodWithNullableMapLongHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Long>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Long>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Long>> methodWithNullableMapLongReturn(boolean notNull) {
    def ret = delegate.methodWithNullableMapLongReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableMapFloatParam(Map<String, Float> param) {
    def ret = delegate.methodWithNonNullableMapFloatParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
    return ret;
  }
  public void methodWithNullableMapFloatParam(boolean expectNull, Map<String, Float> param) {
    delegate.methodWithNullableMapFloatParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithNullableMapFloatHandler(boolean notNull, Handler<Map<String, Float>> handler) {
    delegate.methodWithNullableMapFloatHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Float>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Float> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableMapFloatHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Float>>> handler) {
    delegate.methodWithNullableMapFloatHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Float>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Float>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Float>> methodWithNullableMapFloatReturn(boolean notNull) {
    def ret = delegate.methodWithNullableMapFloatReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableMapDoubleParam(Map<String, Double> param) {
    def ret = delegate.methodWithNonNullableMapDoubleParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
    return ret;
  }
  public void methodWithNullableMapDoubleParam(boolean expectNull, Map<String, Double> param) {
    delegate.methodWithNullableMapDoubleParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithNullableMapDoubleHandler(boolean notNull, Handler<Map<String, Double>> handler) {
    delegate.methodWithNullableMapDoubleHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Double>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Double> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableMapDoubleHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Double>>> handler) {
    delegate.methodWithNullableMapDoubleHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Double>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Double>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Double>> methodWithNullableMapDoubleReturn(boolean notNull) {
    def ret = delegate.methodWithNullableMapDoubleReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableMapBooleanParam(Map<String, Boolean> param) {
    def ret = delegate.methodWithNonNullableMapBooleanParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
    return ret;
  }
  public void methodWithNullableMapBooleanParam(boolean expectNull, Map<String, Boolean> param) {
    delegate.methodWithNullableMapBooleanParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithNullableMapBooleanHandler(boolean notNull, Handler<Map<String, Boolean>> handler) {
    delegate.methodWithNullableMapBooleanHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Boolean>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Boolean> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableMapBooleanHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Boolean>>> handler) {
    delegate.methodWithNullableMapBooleanHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Boolean>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Boolean>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Boolean>> methodWithNullableMapBooleanReturn(boolean notNull) {
    def ret = delegate.methodWithNullableMapBooleanReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableMapStringParam(Map<String, String> param) {
    def ret = delegate.methodWithNonNullableMapStringParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
    return ret;
  }
  public void methodWithNullableMapStringParam(boolean expectNull, Map<String, String> param) {
    delegate.methodWithNullableMapStringParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithNullableMapStringHandler(boolean notNull, Handler<Map<String, String>> handler) {
    delegate.methodWithNullableMapStringHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.String>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.String> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableMapStringHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, String>>> handler) {
    delegate.methodWithNullableMapStringHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.String>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<String>> methodWithNullableMapStringReturn(boolean notNull) {
    def ret = delegate.methodWithNullableMapStringReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableMapCharParam(Map<String, Character> param) {
    def ret = delegate.methodWithNonNullableMapCharParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
    return ret;
  }
  public void methodWithNullableMapCharParam(boolean expectNull, Map<String, Character> param) {
    delegate.methodWithNullableMapCharParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithNullableMapCharHandler(boolean notNull, Handler<Map<String, Character>> handler) {
    delegate.methodWithNullableMapCharHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Character>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Character> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithNullableMapCharHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Character>>> handler) {
    delegate.methodWithNullableMapCharHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Character>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Character>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Character>> methodWithNullableMapCharReturn(boolean notNull) {
    def ret = delegate.methodWithNullableMapCharReturn(notNull);
    return ret;
  }
  public boolean methodWithNonNullableMapJsonObjectParam(Map<String, Map<String, Object>> param) {
    def ret = delegate.methodWithNonNullableMapJsonObjectParam(param != null ? (Map)param.collectEntries({[it.key,new io.vertx.core.json.JsonObject(it.value)]}) : null);
    return ret;
  }
  public void methodWithNullableMapJsonObjectParam(boolean expectNull, Map<String, Map<String, Object>> param) {
    delegate.methodWithNullableMapJsonObjectParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,new io.vertx.core.json.JsonObject(it.value)]}) : null);
  }
  public void methodWithNullableMapJsonObjectHandler(boolean notNull, Handler<Map<String, Map<String, Object>>> handler) {
    delegate.methodWithNullableMapJsonObjectHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.Map<java.lang.String,io.vertx.core.json.JsonObject> event) {
        handler.handle((Map)event?.collectEntries({[it.key,(Map<String, Object>)InternalHelper.wrapObject(it.value)]}));
      }
    } : null);
  }
  public void methodWithNullableMapJsonObjectHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, Map<String, Object>>>> handler) {
    delegate.methodWithNullableMapJsonObjectHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Map)ar.result()?.collectEntries({[it.key,(Map<String, Object>)InternalHelper.wrapObject(it.value)]})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Map<String, Object>>> methodWithNullableMapJsonObjectReturn(boolean notNull) {
    def ret = (Map)delegate.methodWithNullableMapJsonObjectReturn(notNull)?.collectEntries({[it.key,(Map<String, Object>)InternalHelper.wrapObject(it.value)]});
    return ret;
  }
  public boolean methodWithNonNullableMapJsonArrayParam(Map<String, List<Object>> param) {
    def ret = delegate.methodWithNonNullableMapJsonArrayParam(param != null ? (Map)param.collectEntries({[it.key,new io.vertx.core.json.JsonArray(it.value)]}) : null);
    return ret;
  }
  public void methodWithNullableMapJsonArrayParam(boolean expectNull, Map<String, List<Object>> param) {
    delegate.methodWithNullableMapJsonArrayParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,new io.vertx.core.json.JsonArray(it.value)]}) : null);
  }
  public void methodWithNullableMapJsonArrayHandler(boolean notNull, Handler<Map<String, List<Object>>> handler) {
    delegate.methodWithNullableMapJsonArrayHandler(notNull, handler != null ? new Handler<java.util.Map<java.lang.String,io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.Map<java.lang.String,io.vertx.core.json.JsonArray> event) {
        handler.handle((Map)event?.collectEntries({[it.key,(List<Object>)InternalHelper.wrapObject(it.value)]}));
      }
    } : null);
  }
  public void methodWithNullableMapJsonArrayHandlerAsyncResult(boolean notNull, Handler<AsyncResult<Map<String, List<Object>>>> handler) {
    delegate.methodWithNullableMapJsonArrayHandlerAsyncResult(notNull, handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Map)ar.result()?.collectEntries({[it.key,(List<Object>)InternalHelper.wrapObject(it.value)]})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<List<Object>>> methodWithNullableMapJsonArrayReturn(boolean notNull) {
    def ret = (Map)delegate.methodWithNullableMapJsonArrayReturn(notNull)?.collectEntries({[it.key,(List<Object>)InternalHelper.wrapObject(it.value)]});
    return ret;
  }
  public boolean methodWithNonNullableMapApiParam(Map<String, RefedInterface1> param) {
    def ret = delegate.methodWithNonNullableMapApiParam(param != null ? (Map)param.collectEntries({[it.key,(io.vertx.codegen.testmodel.RefedInterface1)it.value.getDelegate()]}) : null);
    return ret;
  }
  public void methodWithNullableMapApiParam(boolean expectNull, Map<String, RefedInterface1> param) {
    delegate.methodWithNullableMapApiParam(expectNull, param != null ? (Map)param.collectEntries({[it.key,(io.vertx.codegen.testmodel.RefedInterface1)it.value.getDelegate()]}) : null);
  }
  public void methodWithListNullableByteParam(List<Byte> param) {
    delegate.methodWithListNullableByteParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableByteHandler(Handler<List<Byte>> handler) {
    delegate.methodWithListNullableByteHandler(handler != null ? new Handler<java.util.List<java.lang.Byte>>(){
      public void handle(java.util.List<java.lang.Byte> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableByteHandlerAsyncResult(Handler<AsyncResult<List<Byte>>> handler) {
    delegate.methodWithListNullableByteHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Byte>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Byte>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Byte> methodWithListNullableByteReturn() {
    def ret = delegate.methodWithListNullableByteReturn();
    return ret;
  }
  public void methodWithListNullableShortParam(List<Short> param) {
    delegate.methodWithListNullableShortParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableShortHandler(Handler<List<Short>> handler) {
    delegate.methodWithListNullableShortHandler(handler != null ? new Handler<java.util.List<java.lang.Short>>(){
      public void handle(java.util.List<java.lang.Short> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableShortHandlerAsyncResult(Handler<AsyncResult<List<Short>>> handler) {
    delegate.methodWithListNullableShortHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Short>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Short>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Short> methodWithListNullableShortReturn() {
    def ret = delegate.methodWithListNullableShortReturn();
    return ret;
  }
  public void methodWithListNullableIntegerParam(List<Integer> param) {
    delegate.methodWithListNullableIntegerParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableIntegerHandler(Handler<List<Integer>> handler) {
    delegate.methodWithListNullableIntegerHandler(handler != null ? new Handler<java.util.List<java.lang.Integer>>(){
      public void handle(java.util.List<java.lang.Integer> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableIntegerHandlerAsyncResult(Handler<AsyncResult<List<Integer>>> handler) {
    delegate.methodWithListNullableIntegerHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Integer> methodWithListNullableIntegerReturn() {
    def ret = delegate.methodWithListNullableIntegerReturn();
    return ret;
  }
  public void methodWithListNullableLongParam(List<Long> param) {
    delegate.methodWithListNullableLongParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableLongHandler(Handler<List<Long>> handler) {
    delegate.methodWithListNullableLongHandler(handler != null ? new Handler<java.util.List<java.lang.Long>>(){
      public void handle(java.util.List<java.lang.Long> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableLongHandlerAsyncResult(Handler<AsyncResult<List<Long>>> handler) {
    delegate.methodWithListNullableLongHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Long>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Long>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Long> methodWithListNullableLongReturn() {
    def ret = delegate.methodWithListNullableLongReturn();
    return ret;
  }
  public void methodWithListNullableBooleanParam(List<Boolean> param) {
    delegate.methodWithListNullableBooleanParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableBooleanHandler(Handler<List<Boolean>> handler) {
    delegate.methodWithListNullableBooleanHandler(handler != null ? new Handler<java.util.List<java.lang.Boolean>>(){
      public void handle(java.util.List<java.lang.Boolean> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableBooleanHandlerAsyncResult(Handler<AsyncResult<List<Boolean>>> handler) {
    delegate.methodWithListNullableBooleanHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Boolean>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Boolean>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Boolean> methodWithListNullableBooleanReturn() {
    def ret = delegate.methodWithListNullableBooleanReturn();
    return ret;
  }
  public void methodWithListNullableFloatParam(List<Float> param) {
    delegate.methodWithListNullableFloatParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableFloatHandler(Handler<List<Float>> handler) {
    delegate.methodWithListNullableFloatHandler(handler != null ? new Handler<java.util.List<java.lang.Float>>(){
      public void handle(java.util.List<java.lang.Float> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableFloatHandlerAsyncResult(Handler<AsyncResult<List<Float>>> handler) {
    delegate.methodWithListNullableFloatHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Float>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Float>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Float> methodWithListNullableFloatReturn() {
    def ret = delegate.methodWithListNullableFloatReturn();
    return ret;
  }
  public void methodWithListNullableDoubleParam(List<Double> param) {
    delegate.methodWithListNullableDoubleParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableDoubleHandler(Handler<List<Double>> handler) {
    delegate.methodWithListNullableDoubleHandler(handler != null ? new Handler<java.util.List<java.lang.Double>>(){
      public void handle(java.util.List<java.lang.Double> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableDoubleHandlerAsyncResult(Handler<AsyncResult<List<Double>>> handler) {
    delegate.methodWithListNullableDoubleHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Double>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Double>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Double> methodWithListNullableDoubleReturn() {
    def ret = delegate.methodWithListNullableDoubleReturn();
    return ret;
  }
  public void methodWithListNullableStringParam(List<String> param) {
    delegate.methodWithListNullableStringParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableStringHandler(Handler<List<String>> handler) {
    delegate.methodWithListNullableStringHandler(handler != null ? new Handler<java.util.List<java.lang.String>>(){
      public void handle(java.util.List<java.lang.String> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableStringHandlerAsyncResult(Handler<AsyncResult<List<String>>> handler) {
    delegate.methodWithListNullableStringHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<String> methodWithListNullableStringReturn() {
    def ret = delegate.methodWithListNullableStringReturn();
    return ret;
  }
  public void methodWithListNullableCharParam(List<Character> param) {
    delegate.methodWithListNullableCharParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableCharHandler(Handler<List<Character>> handler) {
    delegate.methodWithListNullableCharHandler(handler != null ? new Handler<java.util.List<java.lang.Character>>(){
      public void handle(java.util.List<java.lang.Character> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableCharHandlerAsyncResult(Handler<AsyncResult<List<Character>>> handler) {
    delegate.methodWithListNullableCharHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Character>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Character>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Character> methodWithListNullableCharReturn() {
    def ret = delegate.methodWithListNullableCharReturn();
    return ret;
  }
  public void methodWithListNullableJsonObjectParam(List<Map<String, Object>> param) {
    delegate.methodWithListNullableJsonObjectParam(param != null ? (List)param.collect({new io.vertx.core.json.JsonObject(it)}) : null);
  }
  public void methodWithListNullableJsonObjectHandler(Handler<List<Map<String, Object>>> handler) {
    delegate.methodWithListNullableJsonObjectHandler(handler != null ? new Handler<java.util.List<io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.List<io.vertx.core.json.JsonObject> event) {
        handler.handle((List)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}));
      }
    } : null);
  }
  public void methodWithListNullableJsonObjectHandlerAsyncResult(Handler<AsyncResult<List<Map<String, Object>>>> handler) {
    delegate.methodWithListNullableJsonObjectHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Map<String, Object>> methodWithListNullableJsonObjectReturn() {
    def ret = (List)delegate.methodWithListNullableJsonObjectReturn()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)});
    return ret;
  }
  public void methodWithListNullableJsonArrayParam(List<List<Object>> param) {
    delegate.methodWithListNullableJsonArrayParam(param != null ? (List)param.collect({new io.vertx.core.json.JsonArray(it)}) : null);
  }
  public void methodWithListNullableJsonArrayHandler(Handler<List<List<Object>>> handler) {
    delegate.methodWithListNullableJsonArrayHandler(handler != null ? new Handler<java.util.List<io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.List<io.vertx.core.json.JsonArray> event) {
        handler.handle((List)event?.collect({(List<Object>)InternalHelper.wrapObject(it)}));
      }
    } : null);
  }
  public void methodWithListNullableJsonArrayHandlerAsyncResult(Handler<AsyncResult<List<List<Object>>>> handler) {
    delegate.methodWithListNullableJsonArrayHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(List<Object>)InternalHelper.wrapObject(it)})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<List<Object>> methodWithListNullableJsonArrayReturn() {
    def ret = (List)delegate.methodWithListNullableJsonArrayReturn()?.collect({(List<Object>)InternalHelper.wrapObject(it)});
    return ret;
  }
  public void methodWithListNullableApiParam(List<RefedInterface1> param) {
    delegate.methodWithListNullableApiParam(param != null ? (List)param.collect({(io.vertx.codegen.testmodel.RefedInterface1)it.getDelegate()}) : null);
  }
  public void methodWithListNullableApiHandler(Handler<List<RefedInterface1>> handler) {
    delegate.methodWithListNullableApiHandler(handler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.RefedInterface1>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.RefedInterface1> event) {
        handler.handle((List)event?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}));
      }
    } : null);
  }
  public void methodWithListNullableApiHandlerAsyncResult(Handler<AsyncResult<List<RefedInterface1>>> handler) {
    delegate.methodWithListNullableApiHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.RefedInterface1>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.RefedInterface1>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<RefedInterface1> methodWithListNullableApiReturn() {
    def ret = (List)delegate.methodWithListNullableApiReturn()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)});
    return ret;
  }
  public void methodWithListNullableDataObjectParam(List<Map<String, Object>> param) {
    delegate.methodWithListNullableDataObjectParam(param != null ? (List)param.collect({new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(it))}) : null);
  }
  public void methodWithListNullableDataObjectHandler(Handler<List<Map<String, Object>>> handler) {
    delegate.methodWithListNullableDataObjectHandler(handler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.TestDataObject>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.TestDataObject> event) {
        handler.handle((List)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}));
      }
    } : null);
  }
  public void methodWithListNullableDataObjectHandlerAsyncResult(Handler<AsyncResult<List<Map<String, Object>>>> handler) {
    delegate.methodWithListNullableDataObjectHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestDataObject>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestDataObject>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<Map<String, Object>> methodWithListNullableDataObjectReturn() {
    def ret = (List)delegate.methodWithListNullableDataObjectReturn()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())});
    return ret;
  }
  public void methodWithListNullableEnumParam(List<TestEnum> param) {
    delegate.methodWithListNullableEnumParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableEnumHandler(Handler<List<TestEnum>> handler) {
    delegate.methodWithListNullableEnumHandler(handler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.TestEnum>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.TestEnum> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableEnumHandlerAsyncResult(Handler<AsyncResult<List<TestEnum>>> handler) {
    delegate.methodWithListNullableEnumHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestEnum>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestEnum>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<TestEnum> methodWithListNullableEnumReturn() {
    def ret = delegate.methodWithListNullableEnumReturn();
    return ret;
  }
  public void methodWithListNullableGenEnumParam(List<TestGenEnum> param) {
    delegate.methodWithListNullableGenEnumParam(param != null ? (List)param.collect({it}) : null);
  }
  public void methodWithListNullableGenEnumHandler(Handler<List<TestGenEnum>> handler) {
    delegate.methodWithListNullableGenEnumHandler(handler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.TestGenEnum>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.TestGenEnum> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithListNullableGenEnumHandlerAsyncResult(Handler<AsyncResult<List<TestGenEnum>>> handler) {
    delegate.methodWithListNullableGenEnumHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestGenEnum>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestGenEnum>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public List<TestGenEnum> methodWithListNullableGenEnumReturn() {
    def ret = delegate.methodWithListNullableGenEnumReturn();
    return ret;
  }
  public void methodWithSetNullableByteParam(Set<Byte> param) {
    delegate.methodWithSetNullableByteParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableByteHandler(Handler<Set<Byte>> handler) {
    delegate.methodWithSetNullableByteHandler(handler != null ? new Handler<java.util.Set<java.lang.Byte>>(){
      public void handle(java.util.Set<java.lang.Byte> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableByteHandlerAsyncResult(Handler<AsyncResult<Set<Byte>>> handler) {
    delegate.methodWithSetNullableByteHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Byte>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Byte>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Byte> methodWithSetNullableByteReturn() {
    def ret = delegate.methodWithSetNullableByteReturn();
    return ret;
  }
  public void methodWithSetNullableShortParam(Set<Short> param) {
    delegate.methodWithSetNullableShortParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableShortHandler(Handler<Set<Short>> handler) {
    delegate.methodWithSetNullableShortHandler(handler != null ? new Handler<java.util.Set<java.lang.Short>>(){
      public void handle(java.util.Set<java.lang.Short> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableShortHandlerAsyncResult(Handler<AsyncResult<Set<Short>>> handler) {
    delegate.methodWithSetNullableShortHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Short>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Short>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Short> methodWithSetNullableShortReturn() {
    def ret = delegate.methodWithSetNullableShortReturn();
    return ret;
  }
  public void methodWithSetNullableIntegerParam(Set<Integer> param) {
    delegate.methodWithSetNullableIntegerParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableIntegerHandler(Handler<Set<Integer>> handler) {
    delegate.methodWithSetNullableIntegerHandler(handler != null ? new Handler<java.util.Set<java.lang.Integer>>(){
      public void handle(java.util.Set<java.lang.Integer> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableIntegerHandlerAsyncResult(Handler<AsyncResult<Set<Integer>>> handler) {
    delegate.methodWithSetNullableIntegerHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Integer> methodWithSetNullableIntegerReturn() {
    def ret = delegate.methodWithSetNullableIntegerReturn();
    return ret;
  }
  public void methodWithSetNullableLongParam(Set<Long> param) {
    delegate.methodWithSetNullableLongParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableLongHandler(Handler<Set<Long>> handler) {
    delegate.methodWithSetNullableLongHandler(handler != null ? new Handler<java.util.Set<java.lang.Long>>(){
      public void handle(java.util.Set<java.lang.Long> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableLongHandlerAsyncResult(Handler<AsyncResult<Set<Long>>> handler) {
    delegate.methodWithSetNullableLongHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Long>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Long>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Long> methodWithSetNullableLongReturn() {
    def ret = delegate.methodWithSetNullableLongReturn();
    return ret;
  }
  public void methodWithSetNullableBooleanParam(Set<Boolean> param) {
    delegate.methodWithSetNullableBooleanParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableBooleanHandler(Handler<Set<Boolean>> handler) {
    delegate.methodWithSetNullableBooleanHandler(handler != null ? new Handler<java.util.Set<java.lang.Boolean>>(){
      public void handle(java.util.Set<java.lang.Boolean> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableBooleanHandlerAsyncResult(Handler<AsyncResult<Set<Boolean>>> handler) {
    delegate.methodWithSetNullableBooleanHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Boolean>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Boolean>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Boolean> methodWithSetNullableBooleanReturn() {
    def ret = delegate.methodWithSetNullableBooleanReturn();
    return ret;
  }
  public void methodWithSetNullableFloatParam(Set<Float> param) {
    delegate.methodWithSetNullableFloatParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableFloatHandler(Handler<Set<Float>> handler) {
    delegate.methodWithSetNullableFloatHandler(handler != null ? new Handler<java.util.Set<java.lang.Float>>(){
      public void handle(java.util.Set<java.lang.Float> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableFloatHandlerAsyncResult(Handler<AsyncResult<Set<Float>>> handler) {
    delegate.methodWithSetNullableFloatHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Float>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Float>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Float> methodWithSetNullableFloatReturn() {
    def ret = delegate.methodWithSetNullableFloatReturn();
    return ret;
  }
  public void methodWithSetNullableDoubleParam(Set<Double> param) {
    delegate.methodWithSetNullableDoubleParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableDoubleHandler(Handler<Set<Double>> handler) {
    delegate.methodWithSetNullableDoubleHandler(handler != null ? new Handler<java.util.Set<java.lang.Double>>(){
      public void handle(java.util.Set<java.lang.Double> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableDoubleHandlerAsyncResult(Handler<AsyncResult<Set<Double>>> handler) {
    delegate.methodWithSetNullableDoubleHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Double>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Double>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Double> methodWithSetNullableDoubleReturn() {
    def ret = delegate.methodWithSetNullableDoubleReturn();
    return ret;
  }
  public void methodWithSetNullableStringParam(Set<String> param) {
    delegate.methodWithSetNullableStringParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableStringHandler(Handler<Set<String>> handler) {
    delegate.methodWithSetNullableStringHandler(handler != null ? new Handler<java.util.Set<java.lang.String>>(){
      public void handle(java.util.Set<java.lang.String> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableStringHandlerAsyncResult(Handler<AsyncResult<Set<String>>> handler) {
    delegate.methodWithSetNullableStringHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<String> methodWithSetNullableStringReturn() {
    def ret = delegate.methodWithSetNullableStringReturn();
    return ret;
  }
  public void methodWithSetNullableCharParam(Set<Character> param) {
    delegate.methodWithSetNullableCharParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableCharHandler(Handler<Set<Character>> handler) {
    delegate.methodWithSetNullableCharHandler(handler != null ? new Handler<java.util.Set<java.lang.Character>>(){
      public void handle(java.util.Set<java.lang.Character> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableCharHandlerAsyncResult(Handler<AsyncResult<Set<Character>>> handler) {
    delegate.methodWithSetNullableCharHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Character>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Character>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Character> methodWithSetNullableCharReturn() {
    def ret = delegate.methodWithSetNullableCharReturn();
    return ret;
  }
  public void methodWithSetNullableJsonObjectParam(Set<Map<String, Object>> param) {
    delegate.methodWithSetNullableJsonObjectParam(param != null ? (Set)param.collect({new io.vertx.core.json.JsonObject(it)}) as Set : null);
  }
  public void methodWithSetNullableJsonObjectHandler(Handler<Set<Map<String, Object>>> handler) {
    delegate.methodWithSetNullableJsonObjectHandler(handler != null ? new Handler<java.util.Set<io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.Set<io.vertx.core.json.JsonObject> event) {
        handler.handle((Set)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set);
      }
    } : null);
  }
  public void methodWithSetNullableJsonObjectHandlerAsyncResult(Handler<AsyncResult<Set<Map<String, Object>>>> handler) {
    delegate.methodWithSetNullableJsonObjectHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Map<String, Object>> methodWithSetNullableJsonObjectReturn() {
    def ret = (Set)delegate.methodWithSetNullableJsonObjectReturn()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set;
    return ret;
  }
  public void methodWithSetNullableJsonArrayParam(Set<List<Object>> param) {
    delegate.methodWithSetNullableJsonArrayParam(param != null ? (Set)param.collect({new io.vertx.core.json.JsonArray(it)}) as Set : null);
  }
  public void methodWithSetNullableJsonArrayHandler(Handler<Set<List<Object>>> handler) {
    delegate.methodWithSetNullableJsonArrayHandler(handler != null ? new Handler<java.util.Set<io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.Set<io.vertx.core.json.JsonArray> event) {
        handler.handle((Set)event?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set);
      }
    } : null);
  }
  public void methodWithSetNullableJsonArrayHandlerAsyncResult(Handler<AsyncResult<Set<List<Object>>>> handler) {
    delegate.methodWithSetNullableJsonArrayHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<List<Object>> methodWithSetNullableJsonArrayReturn() {
    def ret = (Set)delegate.methodWithSetNullableJsonArrayReturn()?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set;
    return ret;
  }
  public void methodWithSetNullableApiParam(Set<RefedInterface1> param) {
    delegate.methodWithSetNullableApiParam(param != null ? (Set)param.collect({(io.vertx.codegen.testmodel.RefedInterface1)it.getDelegate()}) as Set : null);
  }
  public void methodWithSetNullableApiHandler(Handler<Set<RefedInterface1>> handler) {
    delegate.methodWithSetNullableApiHandler(handler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.RefedInterface1>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.RefedInterface1> event) {
        handler.handle((Set)event?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}) as Set);
      }
    } : null);
  }
  public void methodWithSetNullableApiHandlerAsyncResult(Handler<AsyncResult<Set<RefedInterface1>>> handler) {
    delegate.methodWithSetNullableApiHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.RefedInterface1>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.RefedInterface1>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}) as Set));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<RefedInterface1> methodWithSetNullableApiReturn() {
    def ret = (Set)delegate.methodWithSetNullableApiReturn()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}) as Set;
    return ret;
  }
  public void methodWithSetNullableDataObjectParam(Set<Map<String, Object>> param) {
    delegate.methodWithSetNullableDataObjectParam(param != null ? (Set)param.collect({new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(it))}) as Set : null);
  }
  public void methodWithSetNullableDataObjectHandler(Handler<Set<Map<String, Object>>> handler) {
    delegate.methodWithSetNullableDataObjectHandler(handler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.TestDataObject> event) {
        handler.handle((Set)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set);
      }
    } : null);
  }
  public void methodWithSetNullableDataObjectHandlerAsyncResult(Handler<AsyncResult<Set<Map<String, Object>>>> handler) {
    delegate.methodWithSetNullableDataObjectHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<Map<String, Object>> methodWithSetNullableDataObjectReturn() {
    def ret = (Set)delegate.methodWithSetNullableDataObjectReturn()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set;
    return ret;
  }
  public void methodWithSetNullableEnumParam(Set<TestEnum> param) {
    delegate.methodWithSetNullableEnumParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableEnumHandler(Handler<Set<TestEnum>> handler) {
    delegate.methodWithSetNullableEnumHandler(handler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.TestEnum>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.TestEnum> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableEnumHandlerAsyncResult(Handler<AsyncResult<Set<TestEnum>>> handler) {
    delegate.methodWithSetNullableEnumHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestEnum>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestEnum>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<TestEnum> methodWithSetNullableEnumReturn() {
    def ret = delegate.methodWithSetNullableEnumReturn();
    return ret;
  }
  public void methodWithSetNullableGenEnumParam(Set<TestGenEnum> param) {
    delegate.methodWithSetNullableGenEnumParam(param != null ? (Set)param.collect({it}) as Set : null);
  }
  public void methodWithSetNullableGenEnumHandler(Handler<Set<TestGenEnum>> handler) {
    delegate.methodWithSetNullableGenEnumHandler(handler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.TestGenEnum>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.TestGenEnum> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithSetNullableGenEnumHandlerAsyncResult(Handler<AsyncResult<Set<TestGenEnum>>> handler) {
    delegate.methodWithSetNullableGenEnumHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestGenEnum>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestGenEnum>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Set<TestGenEnum> methodWithSetNullableGenEnumReturn() {
    def ret = delegate.methodWithSetNullableGenEnumReturn();
    return ret;
  }
  public void methodWithMapNullableByteParam(Map<String, Byte> param) {
    delegate.methodWithMapNullableByteParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithMapNullableByteHandler(Handler<Map<String, Byte>> handler) {
    delegate.methodWithMapNullableByteHandler(handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Byte>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Byte> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithMapNullableByteHandlerAsyncResult(Handler<AsyncResult<Map<String, Byte>>> handler) {
    delegate.methodWithMapNullableByteHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Byte>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Byte>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Byte>> methodWithMapNullableByteReturn() {
    def ret = delegate.methodWithMapNullableByteReturn();
    return ret;
  }
  public void methodWithMapNullableShortParam(Map<String, Short> param) {
    delegate.methodWithMapNullableShortParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithMapNullableShortHandler(Handler<Map<String, Short>> handler) {
    delegate.methodWithMapNullableShortHandler(handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Short>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Short> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithMapNullableShortHandlerAsyncResult(Handler<AsyncResult<Map<String, Short>>> handler) {
    delegate.methodWithMapNullableShortHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Short>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Short>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Short>> methodWithMapNullableShortReturn() {
    def ret = delegate.methodWithMapNullableShortReturn();
    return ret;
  }
  public void methodWithMapNullableIntegerParam(Map<String, Integer> param) {
    delegate.methodWithMapNullableIntegerParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithMapNullableIntegerHandler(Handler<Map<String, Integer>> handler) {
    delegate.methodWithMapNullableIntegerHandler(handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Integer>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Integer> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithMapNullableIntegerHandlerAsyncResult(Handler<AsyncResult<Map<String, Integer>>> handler) {
    delegate.methodWithMapNullableIntegerHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Integer>> methodWithMapNullableIntegerReturn() {
    def ret = delegate.methodWithMapNullableIntegerReturn();
    return ret;
  }
  public void methodWithMapNullableLongParam(Map<String, Long> param) {
    delegate.methodWithMapNullableLongParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithMapNullableLongHandler(Handler<Map<String, Long>> handler) {
    delegate.methodWithMapNullableLongHandler(handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Long>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Long> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithMapNullableLongHandlerAsyncResult(Handler<AsyncResult<Map<String, Long>>> handler) {
    delegate.methodWithMapNullableLongHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Long>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Long>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Long>> methodWithMapNullableLongReturn() {
    def ret = delegate.methodWithMapNullableLongReturn();
    return ret;
  }
  public void methodWithMapNullableBooleanParam(Map<String, Boolean> param) {
    delegate.methodWithMapNullableBooleanParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithMapNullableBooleanHandler(Handler<Map<String, Boolean>> handler) {
    delegate.methodWithMapNullableBooleanHandler(handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Boolean>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Boolean> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithMapNullableBooleanHandlerAsyncResult(Handler<AsyncResult<Map<String, Boolean>>> handler) {
    delegate.methodWithMapNullableBooleanHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Boolean>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Boolean>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Boolean>> methodWithMapNullableBooleanReturn() {
    def ret = delegate.methodWithMapNullableBooleanReturn();
    return ret;
  }
  public void methodWithMapNullableFloatParam(Map<String, Float> param) {
    delegate.methodWithMapNullableFloatParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithMapNullableFloatHandler(Handler<Map<String, Float>> handler) {
    delegate.methodWithMapNullableFloatHandler(handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Float>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Float> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithMapNullableFloatHandlerAsyncResult(Handler<AsyncResult<Map<String, Float>>> handler) {
    delegate.methodWithMapNullableFloatHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Float>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Float>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Float>> methodWithMapNullableFloatReturn() {
    def ret = delegate.methodWithMapNullableFloatReturn();
    return ret;
  }
  public void methodWithMapNullableDoubleParam(Map<String, Double> param) {
    delegate.methodWithMapNullableDoubleParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithMapNullableDoubleHandler(Handler<Map<String, Double>> handler) {
    delegate.methodWithMapNullableDoubleHandler(handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Double>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Double> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithMapNullableDoubleHandlerAsyncResult(Handler<AsyncResult<Map<String, Double>>> handler) {
    delegate.methodWithMapNullableDoubleHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Double>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Double>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Double>> methodWithMapNullableDoubleReturn() {
    def ret = delegate.methodWithMapNullableDoubleReturn();
    return ret;
  }
  public void methodWithMapNullableStringParam(Map<String, String> param) {
    delegate.methodWithMapNullableStringParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithMapNullableStringHandler(Handler<Map<String, String>> handler) {
    delegate.methodWithMapNullableStringHandler(handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.String>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.String> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithMapNullableStringHandlerAsyncResult(Handler<AsyncResult<Map<String, String>>> handler) {
    delegate.methodWithMapNullableStringHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.String>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<String>> methodWithMapNullableStringReturn() {
    def ret = delegate.methodWithMapNullableStringReturn();
    return ret;
  }
  public void methodWithMapNullableCharParam(Map<String, Character> param) {
    delegate.methodWithMapNullableCharParam(param != null ? (Map)param.collectEntries({[it.key,it.value]}) : null);
  }
  public void methodWithMapNullableCharHandler(Handler<Map<String, Character>> handler) {
    delegate.methodWithMapNullableCharHandler(handler != null ? new Handler<java.util.Map<java.lang.String,java.lang.Character>>(){
      public void handle(java.util.Map<java.lang.String,java.lang.Character> event) {
        handler.handle(event);
      }
    } : null);
  }
  public void methodWithMapNullableCharHandlerAsyncResult(Handler<AsyncResult<Map<String, Character>>> handler) {
    delegate.methodWithMapNullableCharHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,java.lang.Character>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,java.lang.Character>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Character>> methodWithMapNullableCharReturn() {
    def ret = delegate.methodWithMapNullableCharReturn();
    return ret;
  }
  public void methodWithMapNullableJsonObjectParam(Map<String, Map<String, Object>> param) {
    delegate.methodWithMapNullableJsonObjectParam(param != null ? (Map)param.collectEntries({[it.key,new io.vertx.core.json.JsonObject(it.value)]}) : null);
  }
  public void methodWithMapNullableJsonObjectHandler(Handler<Map<String, Map<String, Object>>> handler) {
    delegate.methodWithMapNullableJsonObjectHandler(handler != null ? new Handler<java.util.Map<java.lang.String,io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.Map<java.lang.String,io.vertx.core.json.JsonObject> event) {
        handler.handle((Map)event?.collectEntries({[it.key,(Map<String, Object>)InternalHelper.wrapObject(it.value)]}));
      }
    } : null);
  }
  public void methodWithMapNullableJsonObjectHandlerAsyncResult(Handler<AsyncResult<Map<String, Map<String, Object>>>> handler) {
    delegate.methodWithMapNullableJsonObjectHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Map)ar.result()?.collectEntries({[it.key,(Map<String, Object>)InternalHelper.wrapObject(it.value)]})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<Map<String, Object>>> methodWithMapNullableJsonObjectReturn() {
    def ret = (Map)delegate.methodWithMapNullableJsonObjectReturn()?.collectEntries({[it.key,(Map<String, Object>)InternalHelper.wrapObject(it.value)]});
    return ret;
  }
  public void methodWithMapNullableJsonArrayParam(Map<String, List<Object>> param) {
    delegate.methodWithMapNullableJsonArrayParam(param != null ? (Map)param.collectEntries({[it.key,new io.vertx.core.json.JsonArray(it.value)]}) : null);
  }
  public void methodWithMapNullableJsonArrayHandler(Handler<Map<String, List<Object>>> handler) {
    delegate.methodWithMapNullableJsonArrayHandler(handler != null ? new Handler<java.util.Map<java.lang.String,io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.Map<java.lang.String,io.vertx.core.json.JsonArray> event) {
        handler.handle((Map)event?.collectEntries({[it.key,(List<Object>)InternalHelper.wrapObject(it.value)]}));
      }
    } : null);
  }
  public void methodWithMapNullableJsonArrayHandlerAsyncResult(Handler<AsyncResult<Map<String, List<Object>>>> handler) {
    delegate.methodWithMapNullableJsonArrayHandlerAsyncResult(handler != null ? new Handler<AsyncResult<java.util.Map<java.lang.String,io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.Map<java.lang.String,io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Map)ar.result()?.collectEntries({[it.key,(List<Object>)InternalHelper.wrapObject(it.value)]})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<List<Object>>> methodWithMapNullableJsonArrayReturn() {
    def ret = (Map)delegate.methodWithMapNullableJsonArrayReturn()?.collectEntries({[it.key,(List<Object>)InternalHelper.wrapObject(it.value)]});
    return ret;
  }
  public void methodWithMapNullableApiParam(Map<String, RefedInterface1> param) {
    delegate.methodWithMapNullableApiParam(param != null ? (Map)param.collectEntries({[it.key,(io.vertx.codegen.testmodel.RefedInterface1)it.value.getDelegate()]}) : null);
  }
  public void methodWithNullableHandler(boolean expectNull, Handler<String> handler) {
    delegate.methodWithNullableHandler(expectNull, handler);
  }
  public void methodWithNullableHandlerAsyncResult(boolean expectNull, Handler<AsyncResult<String>> handler) {
    delegate.methodWithNullableHandlerAsyncResult(expectNull, handler);
  }
}
