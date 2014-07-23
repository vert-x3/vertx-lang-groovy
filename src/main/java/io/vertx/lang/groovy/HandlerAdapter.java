package io.vertx.lang.groovy;

import io.vertx.core.Handler;

import java.lang.reflect.Constructor;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class HandlerAdapter<J, G> implements Handler<J> {

  final Handler<G> groovyHandler;
  final Class<J> javaType;
  final Class<G> groovyType;

  public HandlerAdapter(Handler<G> groovyHandler, Class<J> javaType, Class<G> groovyType) {
    this.groovyHandler = groovyHandler;
    this.javaType = javaType;
    this.groovyType = groovyType;
  }

  @Override
  public void handle(J event) {
    G s;
    if (javaType.getName().startsWith("io.vertx.core")) {
      try {
        Constructor<G> constructor = groovyType.getConstructor(javaType);
        s = constructor.newInstance(event);
      } catch (Exception e) {
        throw new UndeclaredThrowableException(e);
      }
    } else {
      throw new UnsupportedOperationException();
    }
    groovyHandler.handle(s);
  }
}
