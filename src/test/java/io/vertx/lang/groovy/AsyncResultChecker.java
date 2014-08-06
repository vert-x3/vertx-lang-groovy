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

import io.vertx.core.AsyncResult;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class AsyncResultChecker {

  int count = 0;

  void assertResult(Object expected, Object result) {
    assertEquals(expected, result);
    count++;
  }

  void assertAsyncResult(Object expected, AsyncResult<?> result) {
    assertAsyncResult(expected, result, e -> e);
  }

  <R, E> void assertAsyncResult(E expected, AsyncResult<R> result, Function<R, E> unwrapper) {
    assertTrue(result.succeeded());
    assertFalse(result.failed());
    R r = result.result();
    E unwrapped = unwrapper.apply(r);
    assertEquals(expected, unwrapped);
    assertNull(result.cause());
    count++;
  }

  void assertAsyncFailure(String expectedMsg, AsyncResult<?> result) {
    assertNull(result.result());
    assertFalse(result.succeeded());
    assertTrue(result.failed());
    assertEquals(expectedMsg, result.cause().getMessage());
    count++;
  }
}
