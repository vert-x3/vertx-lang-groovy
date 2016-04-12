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
import io.vertx.core.json.JsonObject
import java.util.List
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Provides a way to asynchronously lookup information from DNS servers.
 * <p>
 * Please consult the documentation for more information on DNS clients.
*/
@CompileStatic
public class DnsClient {
  private final def io.vertx.core.dns.DnsClient delegate;
  public DnsClient(Object delegate) {
    this.delegate = (io.vertx.core.dns.DnsClient) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Try to lookup the A (ipv4) or AAAA (ipv6) record for the given name. The first found will be used.
   * @param name the name to resolve
   * @param handler the {@link io.vertx.groovy.core.Handler} to notify with the {@link io.vertx.groovy.core.AsyncResult}. The handler will get notified with the resolved address if a record was found. If non was found it will get notifed with <code>null</code>. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently
   */
  public DnsClient lookup(String name, Handler<AsyncResult<String>> handler) {
    delegate.lookup(name, handler);
    return this;
  }
  /**
   * Try to lookup the A (ipv4) record for the given name. The first found will be used.
   * @param name the name to resolve
   * @param handler the  to notify with the {@link io.vertx.groovy.core.AsyncResult}. The handler will get notified with the resolved {@link java.net.Inet4Address} if a record was found. If non was found it will get notifed with <code>null</code>. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently
   */
  public DnsClient lookup4(String name, Handler<AsyncResult<String>> handler) {
    delegate.lookup4(name, handler);
    return this;
  }
  /**
   * Try to lookup the AAAA (ipv6) record for the given name. The first found will be used.
   * @param name the name to resolve
   * @param handler the  to notify with the . The handler will get notified with the resolved {@link java.net.Inet6Address} if a record was found. If non was found it will get notifed with <code>null</code>. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently
   */
  public DnsClient lookup6(String name, Handler<AsyncResult<String>> handler) {
    delegate.lookup6(name, handler);
    return this;
  }
  /**
   * Try to resolve all A (ipv4) records for the given name.
   * @param name the name to resolve
   * @param handler the {@link io.vertx.groovy.core.Handler} to notify with the {@link io.vertx.groovy.core.AsyncResult}. The handler will get notified with a {@link java.util.List} that contains all the resolved {@link java.net.Inet4Address}es. If none was found an empty {@link java.util.List} will be used. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently
   */
  public DnsClient resolveA(String name, Handler<AsyncResult<List<String>>> handler) {
    delegate.resolveA(name, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Try to resolve all AAAA (ipv6) records for the given name.
   * @param name the name to resolve
   * @param handler the {@link io.vertx.groovy.core.Handler} to notify with the {@link io.vertx.groovy.core.AsyncResult}. The handler will get notified with a {@link java.util.List} that contains all the resolved {@link java.net.Inet6Address}es. If none was found an empty {@link java.util.List} will be used. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently
   */
  public DnsClient resolveAAAA(String name, Handler<AsyncResult<List<String>>> handler) {
    delegate.resolveAAAA(name, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Try to resolve the CNAME record for the given name.
   * @param name the name to resolve the CNAME for
   * @param handler the  to notify with the . The handler will get notified with the resolved {@link java.lang.String} if a record was found. If none was found it will get notified with <code>null</code>. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  public DnsClient resolveCNAME(String name, Handler<AsyncResult<List<String>>> handler) {
    delegate.resolveCNAME(name, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Try to resolve the MX records for the given name.
   * @param name the name for which the MX records should be resolved
   * @param handler the {@link io.vertx.groovy.core.Handler} to notify with the {@link io.vertx.groovy.core.AsyncResult}. The handler will get notified with a List that contains all resolved {@link io.vertx.groovy.core.dns.MxRecord}s, sorted by their {@link io.vertx.groovy.core.dns.MxRecord#priority}. If non was found it will get notified with an empty {@link java.util.List}. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  public DnsClient resolveMX(String name, Handler<AsyncResult<List<MxRecord>>> handler) {
    delegate.resolveMX(name, handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.dns.MxRecord>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.dns.MxRecord>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.core.dns.MxRecord.class)})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Try to resolve the TXT records for the given name.
   * @param name the name for which the TXT records should be resolved
   * @param handler the  to notify with the . The handler will get notified with a List that contains all resolved {@link java.lang.String}s. If none was found it will get notified with an empty {@link java.util.List}. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  public DnsClient resolveTXT(String name, Handler<AsyncResult<List<String>>> handler) {
    delegate.resolveTXT(name, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Try to resolve the PTR record for the given name.
   * @param name the name to resolve the PTR for
   * @param handler the  to notify with the . The handler will get notified with the resolved {@link java.lang.String} if a record was found. If none was found it will get notified with <code>null</code>. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  public DnsClient resolvePTR(String name, Handler<AsyncResult<String>> handler) {
    delegate.resolvePTR(name, handler);
    return this;
  }
  /**
   * Try to resolve the NS records for the given name.
   * @param name the name for which the NS records should be resolved
   * @param handler the  to notify with the . The handler will get notified with a List that contains all resolved {@link java.lang.String}s. If none was found it will get notified with an empty {@link java.util.List}. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  public DnsClient resolveNS(String name, Handler<AsyncResult<List<String>>> handler) {
    delegate.resolveNS(name, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Try to resolve the SRV records for the given name.
   * @param name the name for which the SRV records should be resolved
   * @param handler the  to notify with the . The handler will get notified with a List that contains all resolved {@link io.vertx.groovy.core.dns.SrvRecord}s. If none was found it will get notified with an empty {@link java.util.List}. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  public DnsClient resolveSRV(String name, Handler<AsyncResult<List<SrvRecord>>> handler) {
    delegate.resolveSRV(name, handler != null ? new Handler<AsyncResult<java.util.List<io.vertx.core.dns.SrvRecord>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.core.dns.SrvRecord>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({InternalHelper.safeCreate(it, io.vertx.groovy.core.dns.SrvRecord.class)})));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Try to do a reverse lookup of an IP address. This is basically the same as doing trying to resolve a PTR record
   * but allows you to just pass in the IP address and not a valid ptr query string.
   * @param ipaddress the IP address to resolve the PTR for
   * @param handler the  to notify with the . The handler will get notified with the resolved {@link java.lang.String} if a record was found. If none was found it will get notified with <code>null</code>. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  public DnsClient reverseLookup(String ipaddress, Handler<AsyncResult<String>> handler) {
    delegate.reverseLookup(ipaddress, handler);
    return this;
  }
}
