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
public interface AbstractHandlerUserType extends Handler<RefedInterface1> {
  public Object getDelegate();
  void handle(RefedInterface1 arg0);
}

@CompileStatic
class AbstractHandlerUserTypeImpl implements AbstractHandlerUserType {
  private final def io.vertx.codegen.testmodel.AbstractHandlerUserType delegate;
  public AbstractHandlerUserTypeImpl(Object delegate) {
    this.delegate = (io.vertx.codegen.testmodel.AbstractHandlerUserType) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public void handle(RefedInterface1 arg0) {
    ((io.vertx.core.Handler) delegate).handle(arg0 != null ? (io.vertx.codegen.testmodel.RefedInterface1)arg0.getDelegate() : null);
  }
}
