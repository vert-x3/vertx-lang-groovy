package io.vertx.lang.groovy.verticles;

import io.vertx.groovy.core.GroovyVerticle;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class HelloWorldHttpVerticle extends GroovyVerticle {

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
