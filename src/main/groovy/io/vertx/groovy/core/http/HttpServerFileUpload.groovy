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
 * Represents an file upload from an HTML FORM.
*/
@CompileStatic
public class HttpServerFileUpload implements ReadStream<Buffer> {
  private final def io.vertx.core.http.HttpServerFileUpload delegate;
  public HttpServerFileUpload(Object delegate) {
    this.delegate = (io.vertx.core.http.HttpServerFileUpload) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public HttpServerFileUpload exceptionHandler(Handler<Throwable> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.HttpServerFileUpload) this.delegate).exceptionHandler(handler);
    return this;
  }
  public HttpServerFileUpload handler(Handler<Buffer> handler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.HttpServerFileUpload) this.delegate).handler(new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        handler.handle(new io.vertx.groovy.core.buffer.Buffer(event));
      }
    });
    return this;
  }
  public HttpServerFileUpload endHandler(Handler<Void> endHandler) {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.HttpServerFileUpload) this.delegate).endHandler(endHandler);
    return this;
  }
  public HttpServerFileUpload pause() {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.HttpServerFileUpload) this.delegate).pause();
    return this;
  }
  public HttpServerFileUpload resume() {
    ( /* Work around for https://jira.codehaus.org/browse/GROOVY-6970 */ (io.vertx.core.http.HttpServerFileUpload) this.delegate).resume();
    return this;
  }
  /**
   * Stream the content of this upload to the given file on storage.
   * @param filename the name of the file
   * @return 
   */
  public HttpServerFileUpload streamToFileSystem(String filename) {
    this.delegate.streamToFileSystem(filename);
    return this;
  }
  /**
   * @return the filename which was used when upload the file.
   * @return 
   */
  public String filename() {
    def ret = this.delegate.filename();
    return ret;
  }
  /**
   * @return the name of the attribute
   * @return 
   */
  public String name() {
    def ret = this.delegate.name();
    return ret;
  }
  /**
   * @return  the content type for the upload
   * @return 
   */
  public String contentType() {
    def ret = this.delegate.contentType();
    return ret;
  }
  /**
   * @return the contentTransferEncoding for the upload
   * @return 
   */
  public String contentTransferEncoding() {
    def ret = this.delegate.contentTransferEncoding();
    return ret;
  }
  /**
   * @return the charset for the upload
   * @return 
   */
  public String charset() {
    def ret = this.delegate.charset();
    return ret;
  }
  /**
   * The size of the upload may not be available until it is all read.
   * Check {@link io.vertx.groovy.core.http.HttpServerFileUpload#isSizeAvailable} to determine this
   * @return the size of the upload (in bytes)
   */
  public long size() {
    def ret = this.delegate.size();
    return ret;
  }
  /**
   * @return true if the size of the upload can be retrieved via {@link io.vertx.groovy.core.http.HttpServerFileUpload#size}.
   * @return 
   */
  public boolean isSizeAvailable() {
    def ret = this.delegate.isSizeAvailable();
    return ret;
  }
}
