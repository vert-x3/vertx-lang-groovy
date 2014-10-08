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
 * Represent a Service-Record (SRV) which was resolved for a domain.
 *
 * @author <a href="mailto:nmaurer@redhat.com">Norman Maurer</a>
 */
@CompileStatic
public class SrvRecord {
  final def io.vertx.core.dns.SrvRecord delegate;
  public SrvRecord(io.vertx.core.dns.SrvRecord delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Returns the priority for this service record.
   */
  public int priority() {
    def ret = this.delegate.priority();
    return ret;
  }
  /**
   * Returns the weight of this service record.
   */
  public int weight() {
    def ret = this.delegate.weight();
    return ret;
  }
  /**
   * Returns the port the service is running on.
   */
  public int port() {
    def ret = this.delegate.port();
    return ret;
  }
  /**
   * Returns the name for the server being queried.
   */
  public String name() {
    def ret = this.delegate.name();
    return ret;
  }
  /**
   * Returns the protocol for the service being queried (i.e. "_tcp").
   */
  public String protocol() {
    def ret = this.delegate.protocol();
    return ret;
  }
  /**
   * Returns the service's name (i.e. "_http").
   */
  public String service() {
    def ret = this.delegate.service();
    return ret;
  }
  /**
   * Returns the name of the host for the service.
   */
  public String target() {
    def ret = this.delegate.target();
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.dns.SrvRecord, SrvRecord> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.dns.SrvRecord arg -> new SrvRecord(arg);
  };
}
