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

package io.vertx.groovy.core.file;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.groovy.core.streams.WriteStream
import io.vertx.groovy.core.streams.ReadStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents a file on the file-system which can be read from, or written to asynchronously.
 * <p>
 * This class also implements {@link io.vertx.groovy.core.streams.ReadStream} and
 * {@link io.vertx.groovy.core.streams.WriteStream}. This allows the data to be pumped to and from
 * other streams, e.g. an {@link io.vertx.groovy.core.http.HttpClientRequest} instance,
 * using the {@link io.vertx.groovy.core.streams.Pump} class
*/
@CompileStatic
public class AsyncFile implements ReadStream<Buffer>,  WriteStream<Buffer> {
  private final def io.vertx.core.file.AsyncFile delegate;
  public AsyncFile(Object delegate) {
    this.delegate = (io.vertx.core.file.AsyncFile) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Same as {@link io.vertx.groovy.core.file.AsyncFile#end} but writes some data to the stream before ending.
   * @param t 
   */
  public void end(Buffer t) {
    ((io.vertx.core.streams.WriteStream) this.delegate).end(t != null ? (io.vertx.core.buffer.Buffer)t.getDelegate() : null);
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.file.AsyncFile#setWriteQueueMaxSize}
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) this.delegate).writeQueueFull();
    return ret;
  }
  public AsyncFile handler(Handler<Buffer> handler) {
    ((io.vertx.core.file.AsyncFile) this.delegate).handler(handler != null ? new Handler<io.vertx.core.buffer.Buffer>(){
    public void handle(io.vertx.core.buffer.Buffer event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  public AsyncFile pause() {
    ((io.vertx.core.file.AsyncFile) this.delegate).pause();
    return this;
  }
  public AsyncFile resume() {
    ((io.vertx.core.file.AsyncFile) this.delegate).resume();
    return this;
  }
  public AsyncFile endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.file.AsyncFile) this.delegate).endHandler(endHandler != null ? new Handler<java.lang.Void>(){
    public void handle(java.lang.Void event) {
      endHandler.handle(null);
    }
  }
 : null);
    return this;
  }
  public AsyncFile write(Buffer data) {
    ((io.vertx.core.file.AsyncFile) this.delegate).write(data != null ? (io.vertx.core.buffer.Buffer)data.getDelegate() : null);
    return this;
  }
  public AsyncFile setWriteQueueMaxSize(int maxSize) {
    ((io.vertx.core.file.AsyncFile) this.delegate).setWriteQueueMaxSize(maxSize != null ? maxSize : null);
    return this;
  }
  public AsyncFile drainHandler(Handler<Void> handler) {
    ((io.vertx.core.file.AsyncFile) this.delegate).drainHandler(handler != null ? new Handler<java.lang.Void>(){
    public void handle(java.lang.Void event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  public AsyncFile exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.file.AsyncFile) this.delegate).exceptionHandler(handler != null ? new Handler<java.lang.Throwable>(){
    public void handle(java.lang.Throwable event) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Close the file, see {@link io.vertx.groovy.core.file.AsyncFile#close}.
   */
  public void end() {
    ((io.vertx.core.file.AsyncFile) this.delegate).end();
  }
  /**
   * Close the file. The actual close happens asynchronously.
   */
  public void close() {
    this.delegate.close();
  }
  /**
   * Close the file. The actual close happens asynchronously.
   * The handler will be called when the close is complete, or an error occurs.
   * @param handler the handler
   */
  public void close(Handler<AsyncResult<Void>> handler) {
    this.delegate.close(handler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      handler.handle(null);
    }
  }
 : null);
  }
  /**
   * Write a {@link io.vertx.groovy.core.buffer.Buffer} to the file at position <code>position</code> in the file, asynchronously.
   * <p>
   * If <code>position</code> lies outside of the current size
   * of the file, the file will be enlarged to encompass it.
   * <p>
   * When multiple writes are invoked on the same file
   * there are no guarantees as to order in which those writes actually occur
   * <p>
   * The handler will be called when the write is complete, or if an error occurs.
   * @param buffer the buffer to write
   * @param position the position in the file to write it at
   * @param handler the handler to call when the write is complete
   * @return a reference to this, so the API can be used fluently
   */
  public AsyncFile write(Buffer buffer, long position, Handler<AsyncResult<Void>> handler) {
    this.delegate.write(buffer != null ? (io.vertx.core.buffer.Buffer)buffer.getDelegate() : null, position != null ? position : null, handler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Reads <code>length</code> bytes of data from the file at position <code>position</code> in the file, asynchronously.
   * <p>
   * The read data will be written into the specified <code>Buffer buffer</code> at position <code>offset</code>.
   * <p>
   * If data is read past the end of the file then zero bytes will be read.<p>
   * When multiple reads are invoked on the same file there are no guarantees as to order in which those reads actually occur.
   * <p>
   * The handler will be called when the close is complete, or if an error occurs.
   * @param buffer the buffer to read into
   * @param offset the offset into the buffer where the data will be read
   * @param position the position in the file where to start reading
   * @param length the number of bytes to read
   * @param handler the handler to call when the write is complete
   * @return a reference to this, so the API can be used fluently
   */
  public AsyncFile read(Buffer buffer, int offset, long position, int length, Handler<AsyncResult<Buffer>> handler) {
    this.delegate.read(buffer != null ? (io.vertx.core.buffer.Buffer)buffer.getDelegate() : null, offset != null ? offset : null, position != null ? position : null, length != null ? length : null, handler != null ? new Handler<AsyncResult<io.vertx.core.buffer.Buffer>>(){
    public void handle(AsyncResult<io.vertx.core.buffer.Buffer> ar) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Flush any writes made to this file to underlying persistent storage.
   * <p>
   * If the file was opened with <code>flush</code> set to <code>true</code> then calling this method will have no effect.
   * <p>
   * The actual flush will happen asynchronously.
   * @return a reference to this, so the API can be used fluently
   */
  public AsyncFile flush() {
    this.delegate.flush();
    return this;
  }
  /**
   * Same as {@link io.vertx.groovy.core.file.AsyncFile#flush} but the handler will be called when the flush is complete or if an error occurs
   * @param handler 
   * @return 
   */
  public AsyncFile flush(Handler<AsyncResult<Void>> handler) {
    this.delegate.flush(handler != null ? new Handler<AsyncResult<java.lang.Void>>(){
    public void handle(AsyncResult<java.lang.Void> ar) {
      handler.handle(null);
    }
  }
 : null);
    return this;
  }
  /**
   * Sets the position from which data will be read from when using the file as a {@link io.vertx.groovy.core.streams.ReadStream}.
   * @param readPos the position in the file
   * @return a reference to this, so the API can be used fluently
   */
  public AsyncFile setReadPos(long readPos) {
    this.delegate.setReadPos(readPos != null ? readPos : null);
    return this;
  }
  /**
   * Sets the position from which data will be written when using the file as a {@link io.vertx.groovy.core.streams.WriteStream}.
   * @param writePos the position in the file
   * @return a reference to this, so the API can be used fluently
   */
  public AsyncFile setWritePos(long writePos) {
    this.delegate.setWritePos(writePos != null ? writePos : null);
    return this;
  }
  /**
   * Sets the buffer size that will be used to read the data from the file. Changing this value will impact how much
   * the data will be read at a time from the file system.
   * @param readBufferSize the buffer size
   * @return a reference to this, so the API can be used fluently
   */
  public AsyncFile setReadBufferSize(int readBufferSize) {
    this.delegate.setReadBufferSize(readBufferSize != null ? readBufferSize : null);
    return this;
  }
}
