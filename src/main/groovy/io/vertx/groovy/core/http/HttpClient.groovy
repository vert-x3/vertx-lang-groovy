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

package io.vertx.groovy.core.http;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.http.WebSocketConnectOptions
import io.vertx.core.http.RequestOptions
import io.vertx.core.Handler
/**
 * An HTTP client that maintains a pool of connections to a specific host, at a specific port. The client supports
 * pipelining of requests.<p>
 * As well as HTTP requests, the client can act as a factory for {@code WebSocket websockets}.<p>
 * If an instance is instantiated from an event loop then the handlers
 * of the instance will always be called on that same event loop.
 * If an instance is instantiated from some other arbitrary Java thread (i.e. when running embedded) then
 * and event loop will be assigned to the instance and used when any of its handlers
 * are called.<p>
 * Instances of HttpClient are thread-safe.<p>
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class HttpClient {
  final def io.vertx.core.http.HttpClient delegate;
  public HttpClient(io.vertx.core.http.HttpClient delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Set an exception handler
   *
   * @return A reference to this, so multiple invocations can be chained together.
   */
  public HttpClient exceptionHandler(Handler<Throwable> handler) {
    def ret= HttpClient.FACTORY.apply(this.delegate.exceptionHandler(handler));
    return ret;
  }
  public HttpClient connectWebsocket(Map<String, Object> options = [:], Handler<WebSocket> wsConnect) {
    def ret= HttpClient.FACTORY.apply(this.delegate.connectWebsocket(options != null ? new io.vertx.core.http.WebSocketConnectOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.WebSocket>() {
      public void handle(io.vertx.core.http.WebSocket event) {
        wsConnect.handle(WebSocket.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClient getNow(Map<String, Object> options = [:], Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClient.FACTORY.apply(this.delegate.getNow(options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClientRequest options(Map<String, Object> options = [:], Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClientRequest.FACTORY.apply(this.delegate.options(options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClientRequest get(Map<String, Object> options = [:], Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClientRequest.FACTORY.apply(this.delegate.get(options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClientRequest head(Map<String, Object> options = [:], Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClientRequest.FACTORY.apply(this.delegate.head(options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClientRequest post(Map<String, Object> options = [:], Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClientRequest.FACTORY.apply(this.delegate.post(options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClientRequest put(Map<String, Object> options = [:], Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClientRequest.FACTORY.apply(this.delegate.put(options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClientRequest delete(Map<String, Object> options = [:], Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClientRequest.FACTORY.apply(this.delegate.delete(options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClientRequest trace(Map<String, Object> options = [:], Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClientRequest.FACTORY.apply(this.delegate.trace(options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClientRequest connect(Map<String, Object> options = [:], Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClientRequest.FACTORY.apply(this.delegate.connect(options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClientRequest patch(Map<String, Object> options = [:], Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClientRequest.FACTORY.apply(this.delegate.patch(options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  public HttpClientRequest request(String method, Map<String, Object> options, Handler<HttpClientResponse> responseHandler) {
    def ret= HttpClientRequest.FACTORY.apply(this.delegate.request(method, options != null ? new io.vertx.core.http.RequestOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<io.vertx.core.http.HttpClientResponse>() {
      public void handle(io.vertx.core.http.HttpClientResponse event) {
        responseHandler.handle(HttpClientResponse.FACTORY.apply(event));
      }
    }));
    return ret;
  }
  /**
   * Close the HTTP client. This will cause any pooled HTTP connections to be closed.
   */
  public void close() {
    this.delegate.close();
  }

  static final java.util.function.Function<io.vertx.core.http.HttpClient, HttpClient> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.http.HttpClient arg -> new HttpClient(arg);
  };
}
