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

package io.vertx.groovy.core.metrics;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
/**
*/
@CompileStatic
public interface Measured {
  public Object getDelegate();
  boolean isMetricsEnabled();
}

@CompileStatic
class MeasuredImpl implements Measured {
  private final def io.vertx.core.metrics.Measured delegate;
  public MeasuredImpl(Object delegate) {
    this.delegate = (io.vertx.core.metrics.Measured) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Whether the metrics are enabled for this measured object
   * @return true if the metrics are enabled
   */
  public boolean isMetricsEnabled() {
    def ret = ((io.vertx.core.metrics.Measured) delegate).isMetricsEnabled();
    return ret;
  }
}
