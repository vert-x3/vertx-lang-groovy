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
package io.vertx.lang.groovy;

import groovy.lang.GroovyShell;
import io.vertx.codegen.extra.ListMethods;
import io.vertx.core.json.JsonObject;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class IntegrationTest {

  @Test
  public void testInvokeRawMethod() throws Exception {
    ListMethods itf = list -> {
      JsonObject combined = new JsonObject();
      list.forEach(combined::mergeIn);
      return combined;
    };
    CompilerConfiguration config = new CompilerConfiguration();
    Properties props = new Properties();
    props.setProperty("groovy.disabled.global.ast.transformations", "io.vertx.lang.groovy.VertxTransformation");
    config.configure(props);
    GroovyShell shell = new GroovyShell(config);
    shell.setProperty("itf", itf);
    Object o = shell.evaluate("return itf.jsonList([new io.vertx.core.json.JsonObject().put('foo', 'foo_value'), new io.vertx.core.json.JsonObject().put('bar', 'bar_value')])");
    JsonObject result = (JsonObject) o;
    assertEquals(result, new JsonObject().put("foo", "foo_value").put("bar", "bar_value"));
  }
}
