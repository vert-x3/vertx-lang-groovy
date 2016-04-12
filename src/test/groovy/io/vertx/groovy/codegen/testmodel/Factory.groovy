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
import io.vertx.core.Handler
/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
*/
@CompileStatic
public class Factory {
  private final def io.vertx.codegen.testmodel.Factory delegate;
  public Factory(Object delegate) {
    this.delegate = (io.vertx.codegen.testmodel.Factory) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public static ConcreteHandlerUserType createConcreteHandlerUserType(Handler<RefedInterface1> handler) {
    def ret = InternalHelper.safeCreate(io.vertx.codegen.testmodel.Factory.createConcreteHandlerUserType(handler != null ? new Handler<io.vertx.codegen.testmodel.RefedInterface1>(){
      public void handle(io.vertx.codegen.testmodel.RefedInterface1 event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.codegen.testmodel.RefedInterface1.class));
      }
    } : null), io.vertx.groovy.codegen.testmodel.ConcreteHandlerUserType.class);
    return ret;
  }
  public static AbstractHandlerUserType createAbstractHandlerUserType(Handler<RefedInterface1> handler) {
    def ret = InternalHelper.safeCreate(io.vertx.codegen.testmodel.Factory.createAbstractHandlerUserType(handler != null ? new Handler<io.vertx.codegen.testmodel.RefedInterface1>(){
      public void handle(io.vertx.codegen.testmodel.RefedInterface1 event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.codegen.testmodel.RefedInterface1.class));
      }
    } : null), io.vertx.groovy.codegen.testmodel.AbstractHandlerUserTypeImpl.class);
    return ret;
  }
  public static ConcreteHandlerUserTypeExtension createConcreteHandlerUserTypeExtension(Handler<RefedInterface1> handler) {
    def ret = InternalHelper.safeCreate(io.vertx.codegen.testmodel.Factory.createConcreteHandlerUserTypeExtension(handler != null ? new Handler<io.vertx.codegen.testmodel.RefedInterface1>(){
      public void handle(io.vertx.codegen.testmodel.RefedInterface1 event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.codegen.testmodel.RefedInterface1.class));
      }
    } : null), io.vertx.groovy.codegen.testmodel.ConcreteHandlerUserTypeExtension.class);
    return ret;
  }
}
