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
    ((io.vertx.core.streams.WriteStream) delegate).end(t != null ? (io.vertx.core.buffer.Buffer)t.getDelegate() : null);
  }
  /**
   * This will return <code>true</code> if there are more bytes in the write queue than the value set using {@link io.vertx.groovy.core.file.AsyncFile#setWriteQueueMaxSize}
   * @return true if write queue is full
   */
  public boolean writeQueueFull() {
    def ret = ((io.vertx.core.streams.WriteStream) delegate).writeQueueFull();
    return ret;
  }
  public AsyncFile handler(Handler<Buffer> handler) {
    ((io.vertx.core.file.AsyncFile) delegate).handler(handler != null ? new Handler<io.vertx.core.buffer.Buffer>(){
      public void handle(io.vertx.core.buffer.Buffer event) {
        handler.handle(InternalHelper.safeCreate(event, io.vertx.groovy.core.buffer.Buffer.class));
      }
    } : null);
    return this;
  }
  public AsyncFile pause() {
    ((io.vertx.core.file.AsyncFile) delegate).pause();
    return this;
  }
  public AsyncFile resume() {
    ((io.vertx.core.file.AsyncFile) delegate).resume();
    return this;
  }
  public AsyncFile endHandler(Handler<Void> endHandler) {
    ((io.vertx.core.file.AsyncFile) delegate).endHandler(endHandler != null ? new Handler<java.lang.Void>(){
      public void handle(java.lang.Void event) {
        endHandler.handle(event);
      }
    } : null);
    return this;
  }
  public AsyncFile write(Buffer data) {
    ((io.vertx.core.file.AsyncFile) delegate).write(data != null ? (io.vertx.core.buffer.Buffer)data.getDelegate() : null);
    return this;
  }
  public AsyncFile setWriteQueueMaxSize(int maxSize) {
    ((io.vertx.core.file.AsyncFile) delegate).setWriteQueueMaxSize(maxSize);
    return this;
  }
  public AsyncFile drainHandler(Handler<Void> handler) {
    ((io.vertx.core.file.AsyncFile) delegate).drainHandler(handler != null ? new Handler<java.lang.Void>(){
      public void handle(java.lang.Void event) {
        handler.handle(event);
      }
    } : null);
    return this;
  }
  public AsyncFile exceptionHandler(Handler<Throwable> handler) {
    ((io.vertx.core.file.AsyncFile) delegate).exceptionHandler(handler != null ? new Handler<java.lang.Throwable>(){
      public void handle(java.lang.Throwable event) {
        handler.handle(event);
      }
    } : null);
    return this;
  }
  /**
   * Close the file, see {@link io.vertx.groovy.core.file.AsyncFile#close}.
   */
  public void end() {
    ((io.vertx.core.file.AsyncFile) delegate).end();
  }
  /**
   * Close the file. The actual close happens asynchronously.
   */
  public void close() {
    delegate.close();
  }
  /**
   * Close the file. The actual close happens asynchronously.
   * The handler will be called when the close is complete, or an error occurs.
   * @param handler the handler
   */
  public void close(Handler<AsyncResult<Void>> handler) {
    delegate.close(handler != null ? new Handler<AsyncResult<java.lang.Void>>() {
      public void handle(AsyncResult<java.lang.Void> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
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
    delegate.write(buffer != null ? (io.vertx.core.buffer.Buffer)buffer.getDelegate() : null, position, handler != null ? new Handler<AsyncResult<java.lang.Void>>() {
      public void handle(AsyncResult<java.lang.Void> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
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
    delegate.read(buffer != null ? (io.vertx.core.buffer.Buffer)buffer.getDelegate() : null, offset, position, length, handler != null ? new Handler<AsyncResult<io.vertx.core.buffer.Buffer>>() {
      public void handle(AsyncResult<io.vertx.core.buffer.Buffer> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.buffer.Buffer.class)));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
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
    delegate.flush();
    return this;
  }
  /**
   * Same as {@link io.vertx.groovy.core.file.AsyncFile#flush} but the handler will be called when the flush is complete or if an error occurs
   * @param handler 
   * @return 
   */
  public AsyncFile flush(Handler<AsyncResult<Void>> handler) {
    delegate.flush(handler != null ? new Handler<AsyncResult<java.lang.Void>>() {
      public void handle(AsyncResult<java.lang.Void> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Sets the position from which data will be read from when using the file as a {@link io.vertx.groovy.core.streams.ReadStream}.
   * @param readPos the position in the file
   * @return a reference to this, so the API can be used fluently
   */
  public AsyncFile setReadPos(long readPos) {
    delegate.setReadPos(readPos);
    return this;
  }
  /**
   * Sets the position from which data will be written when using the file as a {@link io.vertx.groovy.core.streams.WriteStream}.
   * @param writePos the position in the file
   * @return a reference to this, so the API can be used fluently
   */
  public AsyncFile setWritePos(long writePos) {
    delegate.setWritePos(writePos);
    return this;
  }
  /**
   * Sets the buffer size that will be used to read the data from the file. Changing this value will impact how much
   * the data will be read at a time from the file system.
   * @param readBufferSize the buffer size
   * @return a reference to this, so the API can be used fluently
   */
  public AsyncFile setReadBufferSize(int readBufferSize) {
    delegate.setReadBufferSize(readBufferSize);
    return this;
  }
}
