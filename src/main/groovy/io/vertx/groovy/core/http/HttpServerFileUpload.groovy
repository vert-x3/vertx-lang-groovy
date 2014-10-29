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
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.Handler
/**
 * Represents an upload from an HTML form.<p>
 *
 * @author <a href="mailto:nmaurer@redhat.com">Norman Maurer</a>
 */
@CompileStatic
public class HttpServerFileUpload implements ReadStream<Buffer> {
  final def io.vertx.core.http.HttpServerFileUpload delegate;
  public HttpServerFileUpload(io.vertx.core.http.HttpServerFileUpload delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public HttpServerFileUpload exceptionHandler(Handler<Throwable> handler) {
    this.delegate.exceptionHandler(handler);
    return this;
  }
  public HttpServerFileUpload handler(Handler<Buffer> handler) {
    this.delegate.handler(new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        handler.handle(Buffer.FACTORY.apply(event));
      }
    });
    return this;
  }
  public HttpServerFileUpload endHandler(Handler<Void> endHandler) {
    this.delegate.endHandler(endHandler);
    return this;
  }
  public HttpServerFileUpload pause() {
    this.delegate.pause();
    return this;
  }
  public HttpServerFileUpload resume() {
    this.delegate.resume();
    return this;
  }
  /**
   * Stream the content of this upload to the given filename.
   */
  public HttpServerFileUpload streamToFileSystem(String filename) {
    this.delegate.streamToFileSystem(filename);
    return this;
  }
  /**
   * Returns the filename which was used when upload the file.
   */
  public String filename() {
    def ret = this.delegate.filename();
    return ret;
  }
  /**
   * Returns the name of the attribute
   */
  public String name() {
    def ret = this.delegate.name();
    return ret;
  }
  /**
   * Returns the contentType for the upload
   */
  public String contentType() {
    def ret = this.delegate.contentType();
    return ret;
  }
  /**
   * Returns the contentTransferEncoding for the upload
   */
  public String contentTransferEncoding() {
    def ret = this.delegate.contentTransferEncoding();
    return ret;
  }
  /**
   * Returns the charset for the upload
   */
  public String charset() {
    def ret = this.delegate.charset();
    return ret;
  }
  /**
   * Returns the size of the upload (in bytes)
   */
  public long size() {
    def ret = this.delegate.size();
    return ret;
  }
  /**
   * Returns {@code true} if the size of the upload can be retrieved via {@link #size()}.
   */
  public boolean isSizeAvailable() {
    def ret = this.delegate.isSizeAvailable();
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.http.HttpServerFileUpload, HttpServerFileUpload> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.http.HttpServerFileUpload arg -> new HttpServerFileUpload(arg);
  };
}
