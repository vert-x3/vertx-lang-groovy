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
package io.vertx.lang.groovy

import io.vertx.codegen.extra.Converter
import org.junit.Assert
import org.junit.Test

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class ConversionTest {

  @Test
  public void testAcceptNullJsonValues() {
    def nullJson = [:]
    nullJson.put("nullkey", null)
    Assert.assertTrue(Converter.acceptNullJsonObjectValue(nullJson);
    Assert.assertTrue(Converter.acceptNullJsonArrayValue([]));
  }

  @Test
  public void testJsonWithNullValues() {
    Map<String, Object> map = Converter.returnJsonObjectWithNullValue()
    Assert.assertEquals(1, map.size())
    Assert.assertTrue(map.containsKey("nullKey"))
    Assert.assertNull(map["nullKey"])
    Assert.assertEquals(Converter.returnJsonArrayWithNullValue(), [null]);
  }
}
