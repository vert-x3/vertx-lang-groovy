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

package io.vertx.groovy.core.parsetools;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.core.Handler
/**
 * A helper class which allows you to easily parse protocols which are delimited by a sequence of bytes, or fixed
 * size records.
 * <p>
 * Instances of this class take as input {@link io.vertx.groovy.core.buffer.Buffer} instances containing raw bytes,
 * and output records.
 * <p>
 * For example, if I had a simple ASCII text protocol delimited by '\n' and the input was the following:
 * <p>
 * <pre>
 * buffer1:HELLO\nHOW ARE Y
 * buffer2:OU?\nI AM
 * buffer3: DOING OK
 * buffer4:\n
 * </pre>
 * Then the output would be:<p>
 * <pre>
 * buffer1:HELLO
 * buffer2:HOW ARE YOU?
 * buffer3:I AM DOING OK
 * </pre>
 * Instances of this class can be changed between delimited mode and fixed size record mode on the fly as
 * individual records are read, this allows you to parse protocols where, for example, the first 5 records might
 * all be fixed size (of potentially different sizes), followed by some delimited records, followed by more fixed
 * size records.
 * <p>
 * Instances of this class can't currently be used for protocols where the text is encoded with something other than
 * a 1-1 byte-char mapping.
 * <p>
 * Please see the documentation for more information.
*/
@CompileStatic
public class RecordParser implements Handler<Buffer> {
  private final def io.vertx.core.parsetools.RecordParser delegate;
  public RecordParser(Object delegate) {
    this.delegate = (io.vertx.core.parsetools.RecordParser) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public void setOutput(Handler<Buffer> output) {
    this.delegate.setOutput(new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        output.handle(new io.vertx.groovy.core.buffer.Buffer(event));
      }
    });
  }
  /**
   * Create a new <code>RecordParser</code> instance, initially in delimited mode, and where the delimiter can be represented
   * by the String <code></code> delim endcoded in latin-1 . Don't use this if your String contains other than latin-1 characters.
   * <p>
   * <code>output</code> Will receive whole records which have been parsed.
   * @param delim the initial delimiter string
   * @param output handler that will receive the output
   * @return 
   */
  public static RecordParser newDelimited(String delim, Handler<Buffer> output) {
    def ret= InternalHelper.safeCreate(io.vertx.core.parsetools.RecordParser.newDelimited(delim, new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        output.handle(new io.vertx.groovy.core.buffer.Buffer(event));
      }
    }), io.vertx.groovy.core.parsetools.RecordParser.class);
    return ret;
  }
  /**
   * Create a new <code>RecordParser</code> instance, initially in delimited mode, and where the delimiter can be represented
   * by the <code>Buffer</code> delim.
   * <p>
   * <code>output</code> Will receive whole records which have been parsed.
   * @param delim the initial delimiter buffer
   * @param output handler that will receive the output
   * @return 
   */
  public static RecordParser newDelimited(Buffer delim, Handler<Buffer> output) {
    def ret= InternalHelper.safeCreate(io.vertx.core.parsetools.RecordParser.newDelimited((io.vertx.core.buffer.Buffer)delim.getDelegate(), new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        output.handle(new io.vertx.groovy.core.buffer.Buffer(event));
      }
    }), io.vertx.groovy.core.parsetools.RecordParser.class);
    return ret;
  }
  /**
   * Create a new <code>RecordParser</code> instance, initially in fixed size mode, and where the record size is specified
   * by the <code>size</code> parameter.
   * <p>
   * <code>output</code> Will receive whole records which have been parsed.
   * @param size the initial record size
   * @param output handler that will receive the output
   * @return 
   */
  public static RecordParser newFixed(int size, Handler<Buffer> output) {
    def ret= InternalHelper.safeCreate(io.vertx.core.parsetools.RecordParser.newFixed(size, new Handler<io.vertx.core.buffer.Buffer>() {
      public void handle(io.vertx.core.buffer.Buffer event) {
        output.handle(new io.vertx.groovy.core.buffer.Buffer(event));
      }
    }), io.vertx.groovy.core.parsetools.RecordParser.class);
    return ret;
  }
  /**
   * Flip the parser into delimited mode, and where the delimiter can be represented
   * by the String <code>delim</code> encoded in latin-1 . Don't use this if your String contains other than latin-1 characters.
   * <p>
   * This method can be called multiple times with different values of delim while data is being parsed.
   * @param delim the new delimeter
   */
  public void delimitedMode(String delim) {
    this.delegate.delimitedMode(delim);
  }
  /**
   * Flip the parser into delimited mode, and where the delimiter can be represented
   * by the delimiter <code>delim</code>.
   * <p>
   * This method can be called multiple times with different values of delim while data is being parsed.
   * @param delim the new delimiter
   */
  public void delimitedMode(Buffer delim) {
    this.delegate.delimitedMode((io.vertx.core.buffer.Buffer)delim.getDelegate());
  }
  /**
   * Flip the parser into fixed size mode, where the record size is specified by <code>size</code> in bytes.
   * <p>
   * This method can be called multiple times with different values of size while data is being parsed.
   * @param size the new record size
   */
  public void fixedSizeMode(int size) {
    this.delegate.fixedSizeMode(size);
  }
  /**
   * This method is called to provide the parser with data.
   * @param buffer a chunk of data
   */
  public void handle(Buffer buffer) {
    this.delegate.handle((io.vertx.core.buffer.Buffer)buffer.getDelegate());
  }
}
