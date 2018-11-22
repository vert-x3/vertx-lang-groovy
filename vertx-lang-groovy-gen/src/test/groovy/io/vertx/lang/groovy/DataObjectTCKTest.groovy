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

import io.vertx.codegen.testmodel.DataObjectTCKImpl
import io.vertx.codegen.testmodel.DataObjectWithNestedBuffer
import io.vertx.codegen.testmodel.DataObjectWithOnlyJsonObjectConstructor
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.DataObjectTCK
import io.vertx.core.buffer.Buffer
import org.junit.Test

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class DataObjectTCKTest {

  final DataObjectTCK dataObjectTCK = new DataObjectTCKImpl()

  @Test
  void testMethodWithOnlyJsonObjectConstructor() {
    dataObjectTCK.methodWithOnlyJsonObjectConstructorDataObject(new DataObjectWithOnlyJsonObjectConstructor(new JsonObject().put("foo","bar")))
  }

  @Test
  void testDataObjectWithBuffer() {
    dataObjectTCK.setDataObjectWithBuffer([
        buffer: Buffer.buffer("Hello World"),
        buffers: [Buffer.buffer("one"), Buffer.buffer("two")],
        nested: [
            buffer: Buffer.buffer("Bye World")
        ]
    ] as DataObjectWithNestedBuffer)
  }
}
