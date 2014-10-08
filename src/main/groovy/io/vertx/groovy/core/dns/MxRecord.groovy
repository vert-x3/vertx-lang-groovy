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

package io.vertx.groovy.core.dns;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
/**
 * Represent a Mail-Exchange-Record (MX) which was resolved for a domain.
 *
 * @author <a href="mailto:nmaurer@redhat.com">Norman Maurer</a>
 */
@CompileStatic
public class MxRecord {
  final def io.vertx.core.dns.MxRecord delegate;
  public MxRecord(io.vertx.core.dns.MxRecord delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * The priority of the MX record.
   */
  public int priority() {
    def ret = this.delegate.priority();
    return ret;
  }
  /**
   * The name of the MX record
   */
  public String name() {
    def ret = this.delegate.name();
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.dns.MxRecord, MxRecord> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.dns.MxRecord arg -> new MxRecord(arg);
  };
}
