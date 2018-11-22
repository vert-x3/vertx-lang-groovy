/*
 * Copyright (c) 2011-2016 The original author or authors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *      The Eclipse Public License is available at
 *      http://www.eclipse.org/legal/epl-v10.html
 *
 *      The Apache License v2.0 is available at
 *      http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */
package verticles

import io.vertx.core.json.JsonObject
import io.vertx.groovy.discovery.ServiceProxiesTest
import io.vertx.groovy.discovery.service.HelloService
import io.vertx.servicediscovery.ServiceDiscovery
import io.vertx.servicediscovery.types.EventBusService
import io.vertx.core.Vertx

def vertx = Vertx.vertx()
def discovery = ServiceDiscovery.create(vertx, ServiceProxiesTest.DISCOVERY_OPTIONS)
EventBusService.<HelloService> getServiceProxyWithJsonFilter(
        discovery,
        ["service.interface" : HelloService.class.getName()],
        HelloService.class, // service interface
        { ar ->
          if (ar.failed()) {
            result.cause().printStackTrace()
            vertx.eventBus().send("result", [
                    "status" : "ko",
                    "message": ar.cause().getMessage()
            ])
          } else {
            HelloService hello = ar.result()
            hello.hello(new JsonObject().put('name', "vert.x"), { result ->
              if (result.failed()) {
                result.cause().printStackTrace()
                vertx.eventBus().send("result", [
                        "status" : "ko",
                        "message": result.cause().getMessage()
                ])
              } else {
                vertx.eventBus().send("result", [
                        "status" : "ok",
                        "message": result.result()
                ])
                ServiceDiscovery.releaseServiceObject(discovery, hello)
              }
            })
          }
        }
)
