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

import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.test.core.VertxTestBase
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class EventBusTest extends VertxTestBase {

  Vertx _vertx

  @Override
  void setUp() throws Exception {
    super.setUp()
    _vertx = vertx
  }

  @Test
  void testBuffer() {
    def eventBus = _vertx.eventBus()
    eventBus.consumer("the_address").handler { message ->
      def body = message.body()
      if (body instanceof Buffer && body.toString("UTF-8").equals("the_message")) {
        testComplete()
      } else {
        fail()
      }
    }
    eventBus.send("the_address", Buffer.buffer("the_message"))
    await()
  }

  @Test
  void testGroovyString() {
    def eventBus = _vertx.eventBus()
    eventBus.consumer("the_address").handler { message ->
      def body = message.body()
      if (body instanceof String && body.equals("the_message")) {
        testComplete()
      } else {
        fail()
      }
    }
    def val = "the_message"
    eventBus.send("the_address", "${val}")
    await()
  }

  @Test
  void testComplexJson() {
    def val = [outer: [inner: 'value'], list: ['v1', 'v2', 'v3']]
    def eventBus = _vertx.eventBus()
    eventBus.consumer("the_address").handler { message ->
      def body = message.body()
      if (body instanceof Map && body.equals(val)) {
        testComplete()
      } else {
        fail()
      }
    }
    eventBus.send("the_address", val)
    await()
  }
}
