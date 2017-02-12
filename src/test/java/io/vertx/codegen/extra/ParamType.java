package io.vertx.codegen.extra;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Here to check we handle a compilable extension (no need to test behavior per se).
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@VertxGen
public interface ParamType<T> {

  void in(T t);

  T out1();

  void out2(Handler<T> handler);

  void out3(Handler<AsyncResult<T>> handler);

}
