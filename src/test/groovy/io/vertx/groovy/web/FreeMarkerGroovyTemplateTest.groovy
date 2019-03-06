/*
 * Copyright 2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the 'License')' you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.groovy.web

import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.WebTestBase
import io.vertx.ext.web.handler.TemplateHandler
import io.vertx.ext.web.templ.freemarker.FreeMarkerTemplateEngine
import org.junit.Assume
import org.junit.Test

/**
 * @author Thomas Segismont
 */
class FreeMarkerGroovyTemplateTest extends WebTestBase {

  @Test
  void testTemplateHandler() throws Exception {
    Assume.assumeFalse(System.getProperty("java.version").startsWith("9"));
    def engine = FreeMarkerTemplateEngine.create(vertx)
    router.route().handler({ context ->
      def ctx = [:]
      ctx.put('foo', 'badger')
      ctx.put('bar', ['pipo', 'molo'])
      ctx.put('baz', [top: 'pipo', bottom: 'molo'])
      ctx.put('team', [
        'grenoble' : ['Clément'],
        'lyon'     : ['Julien'],
        'amsterdam': ['Paulo'],
        'marseille': ['Julien', 'Thomas']
      ])
      context.put('context', ctx)
      context.next()
    })
    router.route().handler(TemplateHandler.create(engine, 'somedir', 'text/plain'))
    def expected = """Hello badger
There is a pipo
There is a molo
top
bottom
pipo
molo
Julien loves Olympique de Marseille
Thomas loves Olympique de Marseille
"""
    testRequest(HttpMethod.GET, '/altlang.ftl', 200, 'OK', expected)
  }

}
