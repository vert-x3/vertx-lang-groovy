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

package io.vertx.lang.verticles

import io.vertx.core.AbstractVerticle;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class HelloWorldHttpVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    def server = vertx.createHttpServer([port:8080]);
    server.requestHandler({ request ->
      println("Got request $request");
      def response = request.response();
      response.putHeader("Content-Type", "text/html");
      response.setChunked(true);
      response.writeString("<html><body>Hello World</body></html>");
      response.end();
    });
    server.listen();
  }
}
