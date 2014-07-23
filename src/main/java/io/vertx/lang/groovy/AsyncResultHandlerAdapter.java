package io.vertx.lang.groovy;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class AsyncResultHandlerAdapter<T> implements Handler<AsyncResult<T>> {

  public <A> AsyncResultHandlerAdapter(Handler<AsyncResult<A>> adapted) {
  }

  @Override
  public void handle(AsyncResult<T> event) {
    throw new UnsupportedOperationException();
  }
}
