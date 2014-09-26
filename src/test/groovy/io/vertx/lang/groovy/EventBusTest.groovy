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

import io.vertx.groovy.core.Vertx
import io.vertx.groovy.core.buffer.Buffer
import org.junit.Test

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class EventBusTest {

  @Test
  public void testBuffer() {

    def vertx = Vertx.vertx();
    try {
      def latch = new CountDownLatch(1)
      def eventBus = vertx.eventBus();
      eventBus.consumer("the_address").handler { message ->
        def body = message.body()
        if (body instanceof Buffer && body.toString("UTF-8").equals("the_message")) {
          latch.countDown()
        }
      }
      eventBus.send("the_address", Buffer.buffer("the_message"))
      assertTrue(latch.await(10, TimeUnit.SECONDS))
    } finally {
      vertx.close();
    }

  }

}
