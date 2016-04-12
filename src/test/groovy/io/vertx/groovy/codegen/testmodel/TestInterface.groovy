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
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.TestEnum
import java.util.Map
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.codegen.testmodel.TestGenEnum
import java.util.Set
import io.vertx.core.json.JsonArray
import java.util.List
import io.vertx.core.Handler
/**
 * @author <a href="http://tfox.org">Tim Fox</a>
*/
@CompileStatic
public class TestInterface extends SuperInterface1 implements SuperInterface2 {
  private final def io.vertx.codegen.testmodel.TestInterface delegate;
  public TestInterface(Object delegate) {
    super((io.vertx.codegen.testmodel.TestInterface) delegate);
    this.delegate = (io.vertx.codegen.testmodel.TestInterface) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public void otherSuperMethodWithBasicParams(byte b, short s, int i, long l, float f, double d, boolean bool, char ch, String str) {
    ((io.vertx.codegen.testmodel.SuperInterface2) delegate).otherSuperMethodWithBasicParams(b, s, i, l, f, d, bool, ch, str);
  }
  public void methodWithBasicParams(byte b, short s, int i, long l, float f, double d, boolean bool, char ch, String str) {
    delegate.methodWithBasicParams(b, s, i, l, f, d, bool, ch, str);
  }
  public void methodWithBasicBoxedParams(Byte b, Short s, Integer i, Long l, Float f, Double d, Boolean bool, Character ch) {
    delegate.methodWithBasicBoxedParams(b, s, i, l, f, d, bool, ch);
  }
  public void methodWithHandlerBasicTypes(Handler<Byte> byteHandler, Handler<Short> shortHandler, Handler<Integer> intHandler, Handler<Long> longHandler, Handler<Float> floatHandler, Handler<Double> doubleHandler, Handler<Boolean> booleanHandler, Handler<Character> charHandler, Handler<String> stringHandler) {
    delegate.methodWithHandlerBasicTypes(byteHandler, shortHandler, intHandler, longHandler, floatHandler, doubleHandler, booleanHandler, charHandler, stringHandler);
  }
  public Handler<String> methodWithHandlerStringReturn(String expected) {
    def ret = delegate.methodWithHandlerStringReturn(expected);
    return ret;
  }
  public <T> Handler<T> methodWithHandlerGenericReturn(Handler<T> handler) {
    def ret = new Handler<Object>() {
      public void handle(Object event_) {
        delegate.methodWithHandlerGenericReturn(handler != null ? new Handler<java.lang.Object>(){
      public void handle(java.lang.Object event) {
        handler.handle((Object) InternalHelper.wrapObject(event));
      }
    } : null).handle(InternalHelper.unwrapObject(event_));
      }
    };
    return ret;
  }
  public Handler<RefedInterface1> methodWithHandlerVertxGenReturn(String expected) {
    def ret = new Handler<RefedInterface1>() {
      public void handle(RefedInterface1 event_) {
        delegate.methodWithHandlerVertxGenReturn(expected).handle((io.vertx.codegen.testmodel.RefedInterface1)event_.getDelegate());
      }
    };
    return ret;
  }
  public void methodWithHandlerAsyncResultByte(boolean sendFailure, Handler<AsyncResult<Byte>> handler) {
    delegate.methodWithHandlerAsyncResultByte(sendFailure, handler);
  }
  public void methodWithHandlerAsyncResultShort(boolean sendFailure, Handler<AsyncResult<Short>> handler) {
    delegate.methodWithHandlerAsyncResultShort(sendFailure, handler);
  }
  public void methodWithHandlerAsyncResultInteger(boolean sendFailure, Handler<AsyncResult<Integer>> handler) {
    delegate.methodWithHandlerAsyncResultInteger(sendFailure, handler);
  }
  public void methodWithHandlerAsyncResultLong(boolean sendFailure, Handler<AsyncResult<Long>> handler) {
    delegate.methodWithHandlerAsyncResultLong(sendFailure, handler);
  }
  public void methodWithHandlerAsyncResultFloat(boolean sendFailure, Handler<AsyncResult<Float>> handler) {
    delegate.methodWithHandlerAsyncResultFloat(sendFailure, handler);
  }
  public void methodWithHandlerAsyncResultDouble(boolean sendFailure, Handler<AsyncResult<Double>> handler) {
    delegate.methodWithHandlerAsyncResultDouble(sendFailure, handler);
  }
  public void methodWithHandlerAsyncResultBoolean(boolean sendFailure, Handler<AsyncResult<Boolean>> handler) {
    delegate.methodWithHandlerAsyncResultBoolean(sendFailure, handler);
  }
  public void methodWithHandlerAsyncResultCharacter(boolean sendFailure, Handler<AsyncResult<Character>> handler) {
    delegate.methodWithHandlerAsyncResultCharacter(sendFailure, handler);
  }
  public void methodWithHandlerAsyncResultString(boolean sendFailure, Handler<AsyncResult<String>> handler) {
    delegate.methodWithHandlerAsyncResultString(sendFailure, handler);
  }
  public void methodWithHandlerAsyncResultDataObject(boolean sendFailure, Handler<AsyncResult<Map<String, Object>>> handler) {
    delegate.methodWithHandlerAsyncResultDataObject(sendFailure, handler != null ? new Handler<AsyncResult<io.vertx.codegen.testmodel.TestDataObject>>() {
      public void handle(AsyncResult<io.vertx.codegen.testmodel.TestDataObject> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Handler<AsyncResult<String>> methodWithHandlerAsyncResultStringReturn(String expected, boolean fail) {
    def ret = delegate.methodWithHandlerAsyncResultStringReturn(expected, fail);
    return ret;
  }
  public <T> Handler<AsyncResult<T>> methodWithHandlerAsyncResultGenericReturn(Handler<AsyncResult<T>> handler) {
    def ret = new Handler<AsyncResult<Object>>() {
      public void handle(AsyncResult<Object> ar_) {
        if (ar_.succeeded()) {
          delegate.methodWithHandlerAsyncResultGenericReturn(handler != null ? new Handler<AsyncResult<java.lang.Object>>() {
      public void handle(AsyncResult<java.lang.Object> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Object) InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null).handle(io.vertx.core.Future.succeededFuture(InternalHelper.unwrapObject(ar_.result())));
        } else  {
          delegate.methodWithHandlerAsyncResultGenericReturn(handler != null ? new Handler<AsyncResult<java.lang.Object>>() {
      public void handle(AsyncResult<java.lang.Object> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Object) InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null).handle(io.vertx.core.Future.failedFuture(ar_.cause()));
        }
      }
    };
    return ret;
  }
  public Handler<AsyncResult<RefedInterface1>> methodWithHandlerAsyncResultVertxGenReturn(String expected, boolean fail) {
    def ret = new Handler<AsyncResult<RefedInterface1>>() {
      public void handle(AsyncResult<RefedInterface1> ar_) {
        if (ar_.succeeded()) {
          delegate.methodWithHandlerAsyncResultVertxGenReturn(expected, fail).handle(io.vertx.core.Future.succeededFuture((io.vertx.codegen.testmodel.RefedInterface1)ar_.result().getDelegate()));
        } else  {
          delegate.methodWithHandlerAsyncResultVertxGenReturn(expected, fail).handle(io.vertx.core.Future.failedFuture(ar_.cause()));
        }
      }
    };
    return ret;
  }
  public void methodWithUserTypes(RefedInterface1 refed) {
    delegate.methodWithUserTypes(refed != null ? (io.vertx.codegen.testmodel.RefedInterface1)refed.getDelegate() : null);
  }
  public void methodWithObjectParam(String str, Object obj) {
    delegate.methodWithObjectParam(str, obj != null ? InternalHelper.unwrapObject(obj) : null);
  }
  public void methodWithDataObjectParam(Map<String, Object> dataObject = [:]) {
    delegate.methodWithDataObjectParam(dataObject != null ? new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(dataObject)) : null);
  }
  public void methodWithListOfDataObjectsParam(List<Map<String, Object>> dataObjects) {
    delegate.methodWithListOfDataObjectsParam(dataObjects != null ? (List)dataObjects.collect({new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(it))}) : null);
  }
  public void methodWithSetOfDataObjectsParam(Set<Map<String, Object>> dataObjects) {
    delegate.methodWithSetOfDataObjectsParam(dataObjects != null ? (Set)dataObjects.collect({new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(it))}) as Set : null);
  }
  public void methodWithNullDataObjectParam(Map<String, Object> dataObject = [:]) {
    delegate.methodWithNullDataObjectParam(dataObject != null ? new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(dataObject)) : null);
  }
  public void methodWithListParams(List<String> listString, List<Byte> listByte, List<Short> listShort, List<Integer> listInt, List<Long> listLong, List<Map<String, Object>> listJsonObject, List<List<Object>> listJsonArray, List<RefedInterface1> listVertxGen, List<Map<String, Object>> listDataObject, List<TestEnum> listEnum) {
    delegate.methodWithListParams(listString != null ? (List)listString.collect({it}) : null, listByte != null ? (List)listByte.collect({it}) : null, listShort != null ? (List)listShort.collect({it}) : null, listInt != null ? (List)listInt.collect({it}) : null, listLong != null ? (List)listLong.collect({it}) : null, listJsonObject != null ? (List)listJsonObject.collect({new io.vertx.core.json.JsonObject(it)}) : null, listJsonArray != null ? (List)listJsonArray.collect({new io.vertx.core.json.JsonArray(it)}) : null, listVertxGen != null ? (List)listVertxGen.collect({(io.vertx.codegen.testmodel.RefedInterface1)it.getDelegate()}) : null, listDataObject != null ? (List)listDataObject.collect({new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(it))}) : null, listEnum != null ? (List)listEnum.collect({it}) : null);
  }
  public void methodWithSetParams(Set<String> setString, Set<Byte> setByte, Set<Short> setShort, Set<Integer> setInt, Set<Long> setLong, Set<Map<String, Object>> setJsonObject, Set<List<Object>> setJsonArray, Set<RefedInterface1> setVertxGen, Set<Map<String, Object>> setDataObject, Set<TestEnum> setEnum) {
    delegate.methodWithSetParams(setString != null ? (Set)setString.collect({it}) as Set : null, setByte != null ? (Set)setByte.collect({it}) as Set : null, setShort != null ? (Set)setShort.collect({it}) as Set : null, setInt != null ? (Set)setInt.collect({it}) as Set : null, setLong != null ? (Set)setLong.collect({it}) as Set : null, setJsonObject != null ? (Set)setJsonObject.collect({new io.vertx.core.json.JsonObject(it)}) as Set : null, setJsonArray != null ? (Set)setJsonArray.collect({new io.vertx.core.json.JsonArray(it)}) as Set : null, setVertxGen != null ? (Set)setVertxGen.collect({(io.vertx.codegen.testmodel.RefedInterface1)it.getDelegate()}) as Set : null, setDataObject != null ? (Set)setDataObject.collect({new io.vertx.codegen.testmodel.TestDataObject(new io.vertx.core.json.JsonObject(it))}) as Set : null, setEnum != null ? (Set)setEnum.collect({it}) as Set : null);
  }
  public void methodWithMapParams(Map<String, String> mapString, Map<String, Byte> mapByte, Map<String, Short> mapShort, Map<String, Integer> mapInt, Map<String, Long> mapLong, Map<String, Map<String, Object>> mapJsonObject, Map<String, List<Object>> mapJsonArray, Map<String, RefedInterface1> mapVertxGen) {
    delegate.methodWithMapParams(mapString != null ? (Map)mapString.collectEntries({[it.key,it.value]}) : null, mapByte != null ? (Map)mapByte.collectEntries({[it.key,it.value]}) : null, mapShort != null ? (Map)mapShort.collectEntries({[it.key,it.value]}) : null, mapInt != null ? (Map)mapInt.collectEntries({[it.key,it.value]}) : null, mapLong != null ? (Map)mapLong.collectEntries({[it.key,it.value]}) : null, mapJsonObject != null ? (Map)mapJsonObject.collectEntries({[it.key,new io.vertx.core.json.JsonObject(it.value)]}) : null, mapJsonArray != null ? (Map)mapJsonArray.collectEntries({[it.key,new io.vertx.core.json.JsonArray(it.value)]}) : null, mapVertxGen != null ? (Map)mapVertxGen.collectEntries({[it.key,(io.vertx.codegen.testmodel.RefedInterface1)it.value.getDelegate()]}) : null);
  }
  public void methodWithHandlerListAndSet(Handler<List<String>> listStringHandler, Handler<List<Integer>> listIntHandler, Handler<Set<String>> setStringHandler, Handler<Set<Integer>> setIntHandler) {
    delegate.methodWithHandlerListAndSet(listStringHandler != null ? new Handler<java.util.List<java.lang.String>>(){
      public void handle(java.util.List<java.lang.String> event) {
        listStringHandler.handle(event);
      }
    } : null, listIntHandler != null ? new Handler<java.util.List<java.lang.Integer>>(){
      public void handle(java.util.List<java.lang.Integer> event) {
        listIntHandler.handle(event);
      }
    } : null, setStringHandler != null ? new Handler<java.util.Set<java.lang.String>>(){
      public void handle(java.util.Set<java.lang.String> event) {
        setStringHandler.handle(event);
      }
    } : null, setIntHandler != null ? new Handler<java.util.Set<java.lang.Integer>>(){
      public void handle(java.util.Set<java.lang.Integer> event) {
        setIntHandler.handle(event);
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListString(Handler<AsyncResult<List<String>>> handler) {
    delegate.methodWithHandlerAsyncResultListString(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListInteger(Handler<AsyncResult<List<Integer>>> handler) {
    delegate.methodWithHandlerAsyncResultListInteger(handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetString(Handler<AsyncResult<Set<String>>> handler) {
    delegate.methodWithHandlerAsyncResultSetString(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetInteger(Handler<AsyncResult<Set<Integer>>> handler) {
    delegate.methodWithHandlerAsyncResultSetInteger(handler != null ? new Handler<AsyncResult<java.util.Set<java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.Set<java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerListVertxGen(Handler<List<RefedInterface1>> listHandler) {
    delegate.methodWithHandlerListVertxGen(listHandler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.RefedInterface1>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.RefedInterface1> event) {
        listHandler.handle((List)event?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}));
      }
    } : null);
  }
  public void methodWithHandlerSetVertxGen(Handler<Set<RefedInterface1>> listHandler) {
    delegate.methodWithHandlerSetVertxGen(listHandler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.RefedInterface1>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.RefedInterface1> event) {
        listHandler.handle((Set)event?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}) as Set);
      }
    } : null);
  }
  public void methodWithHandlerListAbstractVertxGen(Handler<List<RefedInterface2>> listHandler) {
    delegate.methodWithHandlerListAbstractVertxGen(listHandler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.RefedInterface2>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.RefedInterface2> event) {
        listHandler.handle((List)event?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface2Impl.class)}));
      }
    } : null);
  }
  public void methodWithHandlerSetAbstractVertxGen(Handler<Set<RefedInterface2>> listHandler) {
    delegate.methodWithHandlerSetAbstractVertxGen(listHandler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.RefedInterface2>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.RefedInterface2> event) {
        listHandler.handle((Set)event?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface2Impl.class)}) as Set);
      }
    } : null);
  }
  public void methodWithHandlerListJsonObject(Handler<List<Map<String, Object>>> listHandler) {
    delegate.methodWithHandlerListJsonObject(listHandler != null ? new Handler<java.util.List<io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.List<io.vertx.core.json.JsonObject> event) {
        listHandler.handle((List)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}));
      }
    } : null);
  }
  public void methodWithHandlerListNullJsonObject(Handler<List<Map<String, Object>>> listHandler) {
    delegate.methodWithHandlerListNullJsonObject(listHandler != null ? new Handler<java.util.List<io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.List<io.vertx.core.json.JsonObject> event) {
        listHandler.handle((List)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}));
      }
    } : null);
  }
  public void methodWithHandlerListComplexJsonObject(Handler<List<Map<String, Object>>> listHandler) {
    delegate.methodWithHandlerListComplexJsonObject(listHandler != null ? new Handler<java.util.List<io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.List<io.vertx.core.json.JsonObject> event) {
        listHandler.handle((List)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}));
      }
    } : null);
  }
  public void methodWithHandlerSetJsonObject(Handler<Set<Map<String, Object>>> listHandler) {
    delegate.methodWithHandlerSetJsonObject(listHandler != null ? new Handler<java.util.Set<io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.Set<io.vertx.core.json.JsonObject> event) {
        listHandler.handle((Set)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set);
      }
    } : null);
  }
  public void methodWithHandlerSetNullJsonObject(Handler<Set<Map<String, Object>>> listHandler) {
    delegate.methodWithHandlerSetNullJsonObject(listHandler != null ? new Handler<java.util.Set<io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.Set<io.vertx.core.json.JsonObject> event) {
        listHandler.handle((Set)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set);
      }
    } : null);
  }
  public void methodWithHandlerSetComplexJsonObject(Handler<Set<Map<String, Object>>> listHandler) {
    delegate.methodWithHandlerSetComplexJsonObject(listHandler != null ? new Handler<java.util.Set<io.vertx.core.json.JsonObject>>(){
      public void handle(java.util.Set<io.vertx.core.json.JsonObject> event) {
        listHandler.handle((Set)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set);
      }
    } : null);
  }
  public void methodWithHandlerListJsonArray(Handler<List<List<Object>>> listHandler) {
    delegate.methodWithHandlerListJsonArray(listHandler != null ? new Handler<java.util.List<io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.List<io.vertx.core.json.JsonArray> event) {
        listHandler.handle((List)event?.collect({(List<Object>)InternalHelper.wrapObject(it)}));
      }
    } : null);
  }
  public void methodWithHandlerListNullJsonArray(Handler<List<List<Object>>> listHandler) {
    delegate.methodWithHandlerListNullJsonArray(listHandler != null ? new Handler<java.util.List<io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.List<io.vertx.core.json.JsonArray> event) {
        listHandler.handle((List)event?.collect({(List<Object>)InternalHelper.wrapObject(it)}));
      }
    } : null);
  }
  public void methodWithHandlerListComplexJsonArray(Handler<List<List<Object>>> listHandler) {
    delegate.methodWithHandlerListComplexJsonArray(listHandler != null ? new Handler<java.util.List<io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.List<io.vertx.core.json.JsonArray> event) {
        listHandler.handle((List)event?.collect({(List<Object>)InternalHelper.wrapObject(it)}));
      }
    } : null);
  }
  public void methodWithHandlerSetJsonArray(Handler<Set<List<Object>>> listHandler) {
    delegate.methodWithHandlerSetJsonArray(listHandler != null ? new Handler<java.util.Set<io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.Set<io.vertx.core.json.JsonArray> event) {
        listHandler.handle((Set)event?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set);
      }
    } : null);
  }
  public void methodWithHandlerSetNullJsonArray(Handler<Set<List<Object>>> listHandler) {
    delegate.methodWithHandlerSetNullJsonArray(listHandler != null ? new Handler<java.util.Set<io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.Set<io.vertx.core.json.JsonArray> event) {
        listHandler.handle((Set)event?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set);
      }
    } : null);
  }
  public void methodWithHandlerSetComplexJsonArray(Handler<Set<List<Object>>> setHandler) {
    delegate.methodWithHandlerSetComplexJsonArray(setHandler != null ? new Handler<java.util.Set<io.vertx.core.json.JsonArray>>(){
      public void handle(java.util.Set<io.vertx.core.json.JsonArray> event) {
        setHandler.handle((Set)event?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set);
      }
    } : null);
  }
  public void methodWithHandlerListDataObject(Handler<List<Map<String, Object>>> listHandler) {
    delegate.methodWithHandlerListDataObject(listHandler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.TestDataObject>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.TestDataObject> event) {
        listHandler.handle((List)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}));
      }
    } : null);
  }
  public void methodWithHandlerListNullDataObject(Handler<List<Map<String, Object>>> listHandler) {
    delegate.methodWithHandlerListNullDataObject(listHandler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.TestDataObject>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.TestDataObject> event) {
        listHandler.handle((List)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}));
      }
    } : null);
  }
  public void methodWithHandlerSetDataObject(Handler<Set<Map<String, Object>>> setHandler) {
    delegate.methodWithHandlerSetDataObject(setHandler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.TestDataObject> event) {
        setHandler.handle((Set)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set);
      }
    } : null);
  }
  public void methodWithHandlerSetNullDataObject(Handler<Set<Map<String, Object>>> setHandler) {
    delegate.methodWithHandlerSetNullDataObject(setHandler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.TestDataObject> event) {
        setHandler.handle((Set)event?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set);
      }
    } : null);
  }
  public void methodWithHandlerListEnum(Handler<List<TestEnum>> listHandler) {
    delegate.methodWithHandlerListEnum(listHandler != null ? new Handler<java.util.List<io.vertx.codegen.testmodel.TestEnum>>(){
      public void handle(java.util.List<io.vertx.codegen.testmodel.TestEnum> event) {
        listHandler.handle(event);
      }
    } : null);
  }
  public void methodWithHandlerSetEnum(Handler<Set<TestEnum>> setHandler) {
    delegate.methodWithHandlerSetEnum(setHandler != null ? new Handler<java.util.Set<io.vertx.codegen.testmodel.TestEnum>>(){
      public void handle(java.util.Set<io.vertx.codegen.testmodel.TestEnum> event) {
        setHandler.handle(event);
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListVertxGen(Handler<AsyncResult<List<RefedInterface1>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListVertxGen(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.RefedInterface1>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.RefedInterface1>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)})));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetVertxGen(Handler<AsyncResult<Set<RefedInterface1>>> listHandler) {
    delegate.methodWithHandlerAsyncResultSetVertxGen(listHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.RefedInterface1>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.RefedInterface1>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}) as Set));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListAbstractVertxGen(Handler<AsyncResult<List<RefedInterface2>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListAbstractVertxGen(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.RefedInterface2>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.RefedInterface2>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface2Impl.class)})));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetAbstractVertxGen(Handler<AsyncResult<Set<RefedInterface2>>> listHandler) {
    delegate.methodWithHandlerAsyncResultSetAbstractVertxGen(listHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.RefedInterface2>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.RefedInterface2>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface2Impl.class)}) as Set));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListJsonObject(Handler<AsyncResult<List<Map<String, Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListJsonObject(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)})));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListNullJsonObject(Handler<AsyncResult<List<Map<String, Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListNullJsonObject(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)})));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListComplexJsonObject(Handler<AsyncResult<List<Map<String, Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListComplexJsonObject(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)})));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetJsonObject(Handler<AsyncResult<Set<Map<String, Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultSetJsonObject(listHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetNullJsonObject(Handler<AsyncResult<Set<Map<String, Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultSetNullJsonObject(listHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetComplexJsonObject(Handler<AsyncResult<Set<Map<String, Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultSetComplexJsonObject(listHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.core.json.JsonObject>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.core.json.JsonObject>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListJsonArray(Handler<AsyncResult<List<List<Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListJsonArray(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(List<Object>)InternalHelper.wrapObject(it)})));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListNullJsonArray(Handler<AsyncResult<List<List<Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListNullJsonArray(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(List<Object>)InternalHelper.wrapObject(it)})));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListComplexJsonArray(Handler<AsyncResult<List<List<Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListComplexJsonArray(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(List<Object>)InternalHelper.wrapObject(it)})));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetJsonArray(Handler<AsyncResult<Set<List<Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultSetJsonArray(listHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetNullJsonArray(Handler<AsyncResult<Set<List<Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultSetNullJsonArray(listHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetComplexJsonArray(Handler<AsyncResult<Set<List<Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultSetComplexJsonArray(listHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.core.json.JsonArray>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.core.json.JsonArray>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListDataObject(Handler<AsyncResult<List<Map<String, Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListDataObject(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestDataObject>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestDataObject>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListNullDataObject(Handler<AsyncResult<List<Map<String, Object>>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListNullDataObject(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestDataObject>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestDataObject>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetDataObject(Handler<AsyncResult<Set<Map<String, Object>>>> setHandler) {
    delegate.methodWithHandlerAsyncResultSetDataObject(setHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>> ar) {
        if (ar.succeeded()) {
          setHandler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set));
        } else {
          setHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetNullDataObject(Handler<AsyncResult<Set<Map<String, Object>>>> setHandler) {
    delegate.methodWithHandlerAsyncResultSetNullDataObject(setHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestDataObject>> ar) {
        if (ar.succeeded()) {
          setHandler.handle(io.vertx.core.Future.succeededFuture((Set)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set));
        } else {
          setHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultListEnum(Handler<AsyncResult<List<TestEnum>>> listHandler) {
    delegate.methodWithHandlerAsyncResultListEnum(listHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestEnum>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.codegen.testmodel.TestEnum>> ar) {
        if (ar.succeeded()) {
          listHandler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          listHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultSetEnum(Handler<AsyncResult<Set<TestEnum>>> setHandler) {
    delegate.methodWithHandlerAsyncResultSetEnum(setHandler != null ? new Handler<AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestEnum>>>() {
      public void handle(AsyncResult<java.util.Set<io.vertx.codegen.testmodel.TestEnum>> ar) {
        if (ar.succeeded()) {
          setHandler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          setHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerUserTypes(Handler<RefedInterface1> handler) {
    delegate.methodWithHandlerUserTypes(handler != null ? new Handler<io.vertx.codegen.testmodel.RefedInterface1>(){
      public void handle(io.vertx.codegen.testmodel.RefedInterface1 event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.codegen.testmodel.RefedInterface1.class));
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultUserTypes(Handler<AsyncResult<RefedInterface1>> handler) {
    delegate.methodWithHandlerAsyncResultUserTypes(handler != null ? new Handler<AsyncResult<io.vertx.codegen.testmodel.RefedInterface1>>() {
      public void handle(AsyncResult<io.vertx.codegen.testmodel.RefedInterface1> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.codegen.testmodel.RefedInterface1.class)));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithConcreteHandlerUserTypeSubtype(ConcreteHandlerUserType handler) {
    delegate.methodWithConcreteHandlerUserTypeSubtype(handler != null ? (io.vertx.codegen.testmodel.ConcreteHandlerUserType)handler.getDelegate() : null);
  }
  public void methodWithAbstractHandlerUserTypeSubtype(AbstractHandlerUserType handler) {
    delegate.methodWithAbstractHandlerUserTypeSubtype(handler != null ? (io.vertx.codegen.testmodel.AbstractHandlerUserType)handler.getDelegate() : null);
  }
  public void methodWithConcreteHandlerUserTypeSubtypeExtension(ConcreteHandlerUserTypeExtension handler) {
    delegate.methodWithConcreteHandlerUserTypeSubtypeExtension(handler != null ? (io.vertx.codegen.testmodel.ConcreteHandlerUserTypeExtension)handler.getDelegate() : null);
  }
  public void methodWithHandlerVoid(Handler<Void> handler) {
    delegate.methodWithHandlerVoid(handler);
  }
  public void methodWithHandlerAsyncResultVoid(boolean sendFailure, Handler<AsyncResult<Void>> handler) {
    delegate.methodWithHandlerAsyncResultVoid(sendFailure, handler);
  }
  public void methodWithHandlerThrowable(Handler<Throwable> handler) {
    delegate.methodWithHandlerThrowable(handler);
  }
  public void methodWithHandlerDataObject(Handler<Map<String, Object>> handler) {
    delegate.methodWithHandlerDataObject(handler != null ? new Handler<io.vertx.codegen.testmodel.TestDataObject>(){
      public void handle(io.vertx.codegen.testmodel.TestDataObject event) {
        handler.handle((Map<String, Object>)InternalHelper.wrapObject(event?.toJson()));
      }
    } : null);
  }
  public <U> void methodWithHandlerGenericUserType(U value, Handler<GenericRefedInterface<U>> handler) {
    delegate.methodWithHandlerGenericUserType(value != null ? InternalHelper.unwrapObject(value) : null, handler != null ? new Handler<io.vertx.codegen.testmodel.GenericRefedInterface<java.lang.Object>>(){
      public void handle(io.vertx.codegen.testmodel.GenericRefedInterface<java.lang.Object> event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.codegen.testmodel.GenericRefedInterface.class));
      }
    } : null);
  }
  public <U> void methodWithHandlerAsyncResultGenericUserType(U value, Handler<AsyncResult<GenericRefedInterface<U>>> handler) {
    delegate.methodWithHandlerAsyncResultGenericUserType(value != null ? InternalHelper.unwrapObject(value) : null, handler != null ? new Handler<AsyncResult<io.vertx.codegen.testmodel.GenericRefedInterface<java.lang.Object>>>() {
      public void handle(AsyncResult<io.vertx.codegen.testmodel.GenericRefedInterface<java.lang.Object>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.codegen.testmodel.GenericRefedInterface.class)));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public byte methodWithByteReturn() {
    def ret = delegate.methodWithByteReturn();
    return ret;
  }
  public short methodWithShortReturn() {
    def ret = delegate.methodWithShortReturn();
    return ret;
  }
  public int methodWithIntReturn() {
    def ret = delegate.methodWithIntReturn();
    return ret;
  }
  public long methodWithLongReturn() {
    def ret = delegate.methodWithLongReturn();
    return ret;
  }
  public float methodWithFloatReturn() {
    def ret = delegate.methodWithFloatReturn();
    return ret;
  }
  public double methodWithDoubleReturn() {
    def ret = delegate.methodWithDoubleReturn();
    return ret;
  }
  public boolean methodWithBooleanReturn() {
    def ret = delegate.methodWithBooleanReturn();
    return ret;
  }
  public char methodWithCharReturn() {
    def ret = delegate.methodWithCharReturn();
    return ret;
  }
  public String methodWithStringReturn() {
    def ret = delegate.methodWithStringReturn();
    return ret;
  }
  public RefedInterface1 methodWithVertxGenReturn() {
    def ret = InternalHelper.safeCreate(delegate.methodWithVertxGenReturn(), io.vertx.groovy.codegen.testmodel.RefedInterface1.class);
    return ret;
  }
  public RefedInterface1 methodWithVertxGenNullReturn() {
    def ret = InternalHelper.safeCreate(delegate.methodWithVertxGenNullReturn(), io.vertx.groovy.codegen.testmodel.RefedInterface1.class);
    return ret;
  }
  public RefedInterface2 methodWithAbstractVertxGenReturn() {
    def ret = InternalHelper.safeCreate(delegate.methodWithAbstractVertxGenReturn(), io.vertx.groovy.codegen.testmodel.RefedInterface2Impl.class);
    return ret;
  }
  public Map<String, Object> methodWithDataObjectReturn() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.methodWithDataObjectReturn()?.toJson());
    return ret;
  }
  public Map<String, Object> methodWithDataObjectNullReturn() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.methodWithDataObjectNullReturn()?.toJson());
    return ret;
  }
  public String overloadedMethod(String str, Handler<String> handler) {
    def ret = delegate.overloadedMethod(str, handler);
    return ret;
  }
  public String overloadedMethod(String str, RefedInterface1 refed) {
    def ret = delegate.overloadedMethod(str, refed != null ? (io.vertx.codegen.testmodel.RefedInterface1)refed.getDelegate() : null);
    return ret;
  }
  public String overloadedMethod(String str, RefedInterface1 refed, Handler<String> handler) {
    def ret = delegate.overloadedMethod(str, refed != null ? (io.vertx.codegen.testmodel.RefedInterface1)refed.getDelegate() : null, handler);
    return ret;
  }
  public String overloadedMethod(String str, RefedInterface1 refed, long period, Handler<String> handler) {
    def ret = delegate.overloadedMethod(str, refed != null ? (io.vertx.codegen.testmodel.RefedInterface1)refed.getDelegate() : null, period, handler);
    return ret;
  }
  public <U> U methodWithGenericReturn(String type) {
    def ret = (U) InternalHelper.wrapObject(delegate.methodWithGenericReturn(type));
    return ret;
  }
  public <U> void methodWithGenericParam(String type, U u) {
    delegate.methodWithGenericParam(type, u != null ? InternalHelper.unwrapObject(u) : null);
  }
  public <U> void methodWithGenericHandler(String type, Handler<U> handler) {
    delegate.methodWithGenericHandler(type, handler != null ? new Handler<java.lang.Object>(){
      public void handle(java.lang.Object event) {
        handler.handle((Object) InternalHelper.wrapObject(event));
      }
    } : null);
  }
  public <U> void methodWithGenericHandlerAsyncResult(String type, Handler<AsyncResult<U>> asyncResultHandler) {
    delegate.methodWithGenericHandlerAsyncResult(type, asyncResultHandler != null ? new Handler<AsyncResult<java.lang.Object>>() {
      public void handle(AsyncResult<java.lang.Object> ar) {
        if (ar.succeeded()) {
          asyncResultHandler.handle(io.vertx.core.Future.succeededFuture((Object) InternalHelper.wrapObject(ar.result())));
        } else {
          asyncResultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public TestInterface fluentMethod(String str) {
    delegate.fluentMethod(str);
    return this;
  }
  public static RefedInterface1 staticFactoryMethod(String foo) {
    def ret = InternalHelper.safeCreate(io.vertx.codegen.testmodel.TestInterface.staticFactoryMethod(foo), io.vertx.groovy.codegen.testmodel.RefedInterface1.class);
    return ret;
  }
  public RefedInterface1 methodWithCachedReturn(String foo) {
    if (cached_0 != null) {
      return cached_0;
    }
    def ret = InternalHelper.safeCreate(delegate.methodWithCachedReturn(foo), io.vertx.groovy.codegen.testmodel.RefedInterface1.class);
    cached_0 = ret;
    return ret;
  }
  public int methodWithCachedReturnPrimitive(int arg) {
    if (cached_1 != null) {
      return cached_1;
    }
    def ret = delegate.methodWithCachedReturnPrimitive(arg);
    cached_1 = ret;
    return ret;
  }
  public List<RefedInterface1> methodWithCachedListReturn() {
    if (cached_2 != null) {
      return cached_2;
    }
    def ret = (List)delegate.methodWithCachedListReturn()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)});
    cached_2 = ret;
    return ret;
  }
  public Map<String, Object> methodWithJsonObjectReturn() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.methodWithJsonObjectReturn());
    return ret;
  }
  public Map<String, Object> methodWithNullJsonObjectReturn() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.methodWithNullJsonObjectReturn());
    return ret;
  }
  public Map<String, Object> methodWithComplexJsonObjectReturn() {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.methodWithComplexJsonObjectReturn());
    return ret;
  }
  public List<Object> methodWithJsonArrayReturn() {
    def ret = (List<Object>)InternalHelper.wrapObject(delegate.methodWithJsonArrayReturn());
    return ret;
  }
  public List<Object> methodWithNullJsonArrayReturn() {
    def ret = (List<Object>)InternalHelper.wrapObject(delegate.methodWithNullJsonArrayReturn());
    return ret;
  }
  public List<Object> methodWithComplexJsonArrayReturn() {
    def ret = (List<Object>)InternalHelper.wrapObject(delegate.methodWithComplexJsonArrayReturn());
    return ret;
  }
  public void methodWithJsonParams(Map<String, Object> jsonObject, List<Object> jsonArray) {
    delegate.methodWithJsonParams(jsonObject != null ? new io.vertx.core.json.JsonObject(jsonObject) : null, jsonArray != null ? new io.vertx.core.json.JsonArray(jsonArray) : null);
  }
  public void methodWithNullJsonParams(Map<String, Object> jsonObject, List<Object> jsonArray) {
    delegate.methodWithNullJsonParams(jsonObject != null ? new io.vertx.core.json.JsonObject(jsonObject) : null, jsonArray != null ? new io.vertx.core.json.JsonArray(jsonArray) : null);
  }
  public void methodWithHandlerJson(Handler<Map<String, Object>> jsonObjectHandler, Handler<List<Object>> jsonArrayHandler) {
    delegate.methodWithHandlerJson(jsonObjectHandler != null ? new Handler<io.vertx.core.json.JsonObject>(){
      public void handle(io.vertx.core.json.JsonObject event) {
        jsonObjectHandler.handle((Map<String, Object>)InternalHelper.wrapObject(event));
      }
    } : null, jsonArrayHandler != null ? new Handler<io.vertx.core.json.JsonArray>(){
      public void handle(io.vertx.core.json.JsonArray event) {
        jsonArrayHandler.handle((List<Object>)InternalHelper.wrapObject(event));
      }
    } : null);
  }
  public void methodWithHandlerNullJson(Handler<Map<String, Object>> jsonObjectHandler, Handler<List<Object>> jsonArrayHandler) {
    delegate.methodWithHandlerNullJson(jsonObjectHandler != null ? new Handler<io.vertx.core.json.JsonObject>(){
      public void handle(io.vertx.core.json.JsonObject event) {
        jsonObjectHandler.handle((Map<String, Object>)InternalHelper.wrapObject(event));
      }
    } : null, jsonArrayHandler != null ? new Handler<io.vertx.core.json.JsonArray>(){
      public void handle(io.vertx.core.json.JsonArray event) {
        jsonArrayHandler.handle((List<Object>)InternalHelper.wrapObject(event));
      }
    } : null);
  }
  public void methodWithHandlerComplexJson(Handler<Map<String, Object>> jsonObjectHandler, Handler<List<Object>> jsonArrayHandler) {
    delegate.methodWithHandlerComplexJson(jsonObjectHandler != null ? new Handler<io.vertx.core.json.JsonObject>(){
      public void handle(io.vertx.core.json.JsonObject event) {
        jsonObjectHandler.handle((Map<String, Object>)InternalHelper.wrapObject(event));
      }
    } : null, jsonArrayHandler != null ? new Handler<io.vertx.core.json.JsonArray>(){
      public void handle(io.vertx.core.json.JsonArray event) {
        jsonArrayHandler.handle((List<Object>)InternalHelper.wrapObject(event));
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultJsonObject(Handler<AsyncResult<Map<String, Object>>> handler) {
    delegate.methodWithHandlerAsyncResultJsonObject(handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonObject>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonObject> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultNullJsonObject(Handler<AsyncResult<Map<String, Object>>> handler) {
    delegate.methodWithHandlerAsyncResultNullJsonObject(handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonObject>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonObject> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultComplexJsonObject(Handler<AsyncResult<Map<String, Object>>> handler) {
    delegate.methodWithHandlerAsyncResultComplexJsonObject(handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonObject>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonObject> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultJsonArray(Handler<AsyncResult<List<Object>>> handler) {
    delegate.methodWithHandlerAsyncResultJsonArray(handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultNullJsonArray(Handler<AsyncResult<List<Object>>> handler) {
    delegate.methodWithHandlerAsyncResultNullJsonArray(handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public void methodWithHandlerAsyncResultComplexJsonArray(Handler<AsyncResult<List<Object>>> handler) {
    delegate.methodWithHandlerAsyncResultComplexJsonArray(handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  public Map<String, List<String>> methodWithMapReturn(Handler<String> handler) {
    def ret = delegate.methodWithMapReturn(handler);
    return ret;
  }
  public Map<String, List<String>> methodWithMapStringReturn(Handler<String> handler) {
    def ret = delegate.methodWithMapStringReturn(handler);
    return ret;
  }
  public Map<String, List<Long>> methodWithMapLongReturn(Handler<String> handler) {
    def ret = delegate.methodWithMapLongReturn(handler);
    return ret;
  }
  public Map<String, List<Integer>> methodWithMapIntegerReturn(Handler<String> handler) {
    def ret = delegate.methodWithMapIntegerReturn(handler);
    return ret;
  }
  public Map<String, List<Short>> methodWithMapShortReturn(Handler<String> handler) {
    def ret = delegate.methodWithMapShortReturn(handler);
    return ret;
  }
  public Map<String, List<Byte>> methodWithMapByteReturn(Handler<String> handler) {
    def ret = delegate.methodWithMapByteReturn(handler);
    return ret;
  }
  public Map<String, List<Character>> methodWithMapCharacterReturn(Handler<String> handler) {
    def ret = delegate.methodWithMapCharacterReturn(handler);
    return ret;
  }
  public Map<String, List<Boolean>> methodWithMapBooleanReturn(Handler<String> handler) {
    def ret = delegate.methodWithMapBooleanReturn(handler);
    return ret;
  }
  public Map<String, List<Float>> methodWithMapFloatReturn(Handler<String> handler) {
    def ret = delegate.methodWithMapFloatReturn(handler);
    return ret;
  }
  public Map<String, List<Double>> methodWithMapDoubleReturn(Handler<String> handler) {
    def ret = delegate.methodWithMapDoubleReturn(handler);
    return ret;
  }
  public Map<String, List<Map<String, Object>>> methodWithMapJsonObjectReturn(Handler<String> handler) {
    def ret = (Map)delegate.methodWithMapJsonObjectReturn(handler)?.collectEntries({[it.key,(Map<String, Object>)InternalHelper.wrapObject(it.value)]});
    return ret;
  }
  public Map<String, List<Map<String, Object>>> methodWithMapComplexJsonObjectReturn(Handler<String> handler) {
    def ret = (Map)delegate.methodWithMapComplexJsonObjectReturn(handler)?.collectEntries({[it.key,(Map<String, Object>)InternalHelper.wrapObject(it.value)]});
    return ret;
  }
  public Map<String, List<List<Object>>> methodWithMapJsonArrayReturn(Handler<String> handler) {
    def ret = (Map)delegate.methodWithMapJsonArrayReturn(handler)?.collectEntries({[it.key,(List<Object>)InternalHelper.wrapObject(it.value)]});
    return ret;
  }
  public Map<String, List<List<Object>>> methodWithMapComplexJsonArrayReturn(Handler<String> handler) {
    def ret = (Map)delegate.methodWithMapComplexJsonArrayReturn(handler)?.collectEntries({[it.key,(List<Object>)InternalHelper.wrapObject(it.value)]});
    return ret;
  }
  public Map<String, List<String>> methodWithNullMapReturn() {
    def ret = delegate.methodWithNullMapReturn();
    return ret;
  }
  public List<String> methodWithListStringReturn() {
    def ret = delegate.methodWithListStringReturn();
    return ret;
  }
  public List<Long> methodWithListLongReturn() {
    def ret = delegate.methodWithListLongReturn();
    return ret;
  }
  public List<RefedInterface1> methodWithListVertxGenReturn() {
    def ret = (List)delegate.methodWithListVertxGenReturn()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)});
    return ret;
  }
  public List<Map<String, Object>> methodWithListJsonObjectReturn() {
    def ret = (List)delegate.methodWithListJsonObjectReturn()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)});
    return ret;
  }
  public List<Map<String, Object>> methodWithListComplexJsonObjectReturn() {
    def ret = (List)delegate.methodWithListComplexJsonObjectReturn()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)});
    return ret;
  }
  public List<List<Object>> methodWithListJsonArrayReturn() {
    def ret = (List)delegate.methodWithListJsonArrayReturn()?.collect({(List<Object>)InternalHelper.wrapObject(it)});
    return ret;
  }
  public List<List<Object>> methodWithListComplexJsonArrayReturn() {
    def ret = (List)delegate.methodWithListComplexJsonArrayReturn()?.collect({(List<Object>)InternalHelper.wrapObject(it)});
    return ret;
  }
  public List<Map<String, Object>> methodWithListDataObjectReturn() {
    def ret = (List)delegate.methodWithListDataObjectReturn()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())});
    return ret;
  }
  public List<TestEnum> methodWithListEnumReturn() {
    def ret = delegate.methodWithListEnumReturn();
    return ret;
  }
  public List<String> methodWithNullListReturn() {
    def ret = delegate.methodWithNullListReturn();
    return ret;
  }
  public Set<String> methodWithSetStringReturn() {
    def ret = delegate.methodWithSetStringReturn();
    return ret;
  }
  public Set<Long> methodWithSetLongReturn() {
    def ret = delegate.methodWithSetLongReturn();
    return ret;
  }
  public Set<RefedInterface1> methodWithSetVertxGenReturn() {
    def ret = (Set)delegate.methodWithSetVertxGenReturn()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.codegen.testmodel.RefedInterface1.class)}) as Set;
    return ret;
  }
  public Set<Map<String, Object>> methodWithSetJsonObjectReturn() {
    def ret = (Set)delegate.methodWithSetJsonObjectReturn()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set;
    return ret;
  }
  public Set<Map<String, Object>> methodWithSetComplexJsonObjectReturn() {
    def ret = (Set)delegate.methodWithSetComplexJsonObjectReturn()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it)}) as Set;
    return ret;
  }
  public Set<List<Object>> methodWithSetJsonArrayReturn() {
    def ret = (Set)delegate.methodWithSetJsonArrayReturn()?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set;
    return ret;
  }
  public Set<List<Object>> methodWithSetComplexJsonArrayReturn() {
    def ret = (Set)delegate.methodWithSetComplexJsonArrayReturn()?.collect({(List<Object>)InternalHelper.wrapObject(it)}) as Set;
    return ret;
  }
  public Set<Map<String, Object>> methodWithSetDataObjectReturn() {
    def ret = (Set)delegate.methodWithSetDataObjectReturn()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())}) as Set;
    return ret;
  }
  public Set<TestEnum> methodWithSetEnumReturn() {
    def ret = delegate.methodWithSetEnumReturn();
    return ret;
  }
  public Set<String> methodWithNullSetReturn() {
    def ret = delegate.methodWithNullSetReturn();
    return ret;
  }
  public String methodWithEnumParam(String strVal, TestEnum weirdo) {
    def ret = delegate.methodWithEnumParam(strVal, weirdo);
    return ret;
  }
  public TestEnum methodWithEnumReturn(String strVal) {
    def ret = delegate.methodWithEnumReturn(strVal);
    return ret;
  }
  public String methodWithGenEnumParam(String strVal, TestGenEnum weirdo) {
    def ret = delegate.methodWithGenEnumParam(strVal, weirdo);
    return ret;
  }
  public TestGenEnum methodWithGenEnumReturn(String strVal) {
    def ret = delegate.methodWithGenEnumReturn(strVal);
    return ret;
  }
  public Throwable methodWithThrowableReturn(String strVal) {
    def ret = delegate.methodWithThrowableReturn(strVal);
    return ret;
  }
  public String methodWithThrowableParam(Throwable t) {
    def ret = delegate.methodWithThrowableParam(t);
    return ret;
  }
  private RefedInterface1 cached_0;
  private int cached_1;
  private List<RefedInterface1> cached_2;
}
