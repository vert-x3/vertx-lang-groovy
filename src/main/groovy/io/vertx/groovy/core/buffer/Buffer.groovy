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

package io.vertx.groovy.core.buffer;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.shareddata.impl.ClusterSerializable
/**
 * Most data is shuffled around inside Vert.x using buffers.
 * <p>
 * A buffer is a sequence of zero or more bytes that can read from or written to and which expands automatically as
 * necessary to accommodate any bytes written to it. You can perhaps think of a buffer as smart byte array.
 * <p>
 * Please consult the documentation for more information on buffers.
*/
@CompileStatic
public class Buffer {
  private final def io.vertx.core.buffer.Buffer delegate;
  public Buffer(Object delegate) {
    this.delegate = (io.vertx.core.buffer.Buffer) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Create a new, empty buffer.
   * @return the buffer
   */
  public static Buffer buffer() {
    def ret= InternalHelper.safeCreate(io.vertx.core.buffer.Buffer.buffer(), io.vertx.groovy.core.buffer.Buffer.class);
    return ret;
  }
  /**
   * Create a new buffer given the initial size hint.
   * <p>
   * If you know the buffer will require a certain size, providing the hint can prevent unnecessary re-allocations
   * as the buffer is written to and resized.
   * @param initialSizeHint the hint, in bytes
   * @return the buffer
   */
  public static Buffer buffer(int initialSizeHint) {
    def ret= InternalHelper.safeCreate(io.vertx.core.buffer.Buffer.buffer(initialSizeHint), io.vertx.groovy.core.buffer.Buffer.class);
    return ret;
  }
  /**
   * Create a new buffer from a string. The string will be UTF-8 encoded into the buffer.
   * @param string the string
   * @return the buffer
   */
  public static Buffer buffer(String string) {
    def ret= InternalHelper.safeCreate(io.vertx.core.buffer.Buffer.buffer(string), io.vertx.groovy.core.buffer.Buffer.class);
    return ret;
  }
  /**
   * Create a new buffer from a string and using the specified encoding.
   * The string will be encoded into the buffer using the specified encoding.
   * @param string the string
   * @param enc 
   * @return the buffer
   */
  public static Buffer buffer(String string, String enc) {
    def ret= InternalHelper.safeCreate(io.vertx.core.buffer.Buffer.buffer(string, enc), io.vertx.groovy.core.buffer.Buffer.class);
    return ret;
  }
  /**
   * Returns a <code>String</code> representation of the Buffer with the encoding specified by <code>enc</code>
   * @param enc 
   * @return 
   */
  public String toString(String enc) {
    def ret = this.delegate.toString(enc);
    return ret;
  }
  /**
   * Returns the <code>byte</code> at position <code>pos</code> in the Buffer.
   * @param pos 
   * @return 
   */
  public byte getByte(int pos) {
    def ret = this.delegate.getByte(pos);
    return ret;
  }
  /**
   * Returns the <code>int</code> at position <code>pos</code> in the Buffer.
   * @param pos 
   * @return 
   */
  public int getInt(int pos) {
    def ret = this.delegate.getInt(pos);
    return ret;
  }
  /**
   * Returns the <code>long</code> at position <code>pos</code> in the Buffer.
   * @param pos 
   * @return 
   */
  public long getLong(int pos) {
    def ret = this.delegate.getLong(pos);
    return ret;
  }
  /**
   * Returns the <code>double</code> at position <code>pos</code> in the Buffer.
   * @param pos 
   * @return 
   */
  public double getDouble(int pos) {
    def ret = this.delegate.getDouble(pos);
    return ret;
  }
  /**
   * Returns the <code>float</code> at position <code>pos</code> in the Buffer.
   * @param pos 
   * @return 
   */
  public float getFloat(int pos) {
    def ret = this.delegate.getFloat(pos);
    return ret;
  }
  /**
   * Returns the <code>short</code> at position <code>pos</code> in the Buffer.
   * @param pos 
   * @return 
   */
  public short getShort(int pos) {
    def ret = this.delegate.getShort(pos);
    return ret;
  }
  /**
   * Returns a copy of a sub-sequence the Buffer as a {@link io.vertx.groovy.core.buffer.Buffer} starting at position <code>start</code>
   * and ending at position <code>end - 1</code>
   * @param start 
   * @param end 
   * @return 
   */
  public Buffer getBuffer(int start, int end) {
    def ret= InternalHelper.safeCreate(this.delegate.getBuffer(start, end), io.vertx.groovy.core.buffer.Buffer.class);
    return ret;
  }
  /**
   * Returns a copy of a sub-sequence the Buffer as a <code>String</code> starting at position <code>start</code>
   * and ending at position <code>end - 1</code> interpreted as a String in the specified encoding
   * @param start 
   * @param end 
   * @param enc 
   * @return 
   */
  public String getString(int start, int end, String enc) {
    def ret = this.delegate.getString(start, end, enc);
    return ret;
  }
  /**
   * Returns a copy of a sub-sequence the Buffer as a <code>String</code> starting at position <code>start</code>
   * and ending at position <code>end - 1</code> interpreted as a String in UTF-8 encoding
   * @param start 
   * @param end 
   * @return 
   */
  public String getString(int start, int end) {
    def ret = this.delegate.getString(start, end);
    return ret;
  }
  /**
   * Appends the specified <code>Buffer</code> to the end of this Buffer. The buffer will expand as necessary to accommodate
   * any bytes written.<p>
   * Returns a reference to <code>this</code> so multiple operations can be appended together.
   * @param buff 
   * @return 
   */
  public Buffer appendBuffer(Buffer buff) {
    this.delegate.appendBuffer((io.vertx.core.buffer.Buffer)buff.getDelegate());
    return this;
  }
  /**
   * Appends the specified <code>Buffer</code> starting at the <code>offset</code> using <code>len</code> to the end of this Buffer. The buffer will expand as necessary to accommodate
   * any bytes written.<p>
   * Returns a reference to <code>this</code> so multiple operations can be appended together.
   * @param buff 
   * @param offset 
   * @param len 
   * @return 
   */
  public Buffer appendBuffer(Buffer buff, int offset, int len) {
    this.delegate.appendBuffer((io.vertx.core.buffer.Buffer)buff.getDelegate(), offset, len);
    return this;
  }
  /**
   * Appends the specified <code>byte</code> to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.<p>
   * Returns a reference to <code>this</code> so multiple operations can be appended together.
   * @param b 
   * @return 
   */
  public Buffer appendByte(byte b) {
    this.delegate.appendByte(b);
    return this;
  }
  /**
   * Appends the specified <code>int</code> to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.<p>
   * Returns a reference to <code>this</code> so multiple operations can be appended together.
   * @param i 
   * @return 
   */
  public Buffer appendInt(int i) {
    this.delegate.appendInt(i);
    return this;
  }
  /**
   * Appends the specified <code>long</code> to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.<p>
   * Returns a reference to <code>this</code> so multiple operations can be appended together.
   * @param l 
   * @return 
   */
  public Buffer appendLong(long l) {
    this.delegate.appendLong(l);
    return this;
  }
  /**
   * Appends the specified <code>short</code> to the end of the Buffer.The buffer will expand as necessary to accommodate any bytes written.<p>
   * Returns a reference to <code>this</code> so multiple operations can be appended together.
   * @param s 
   * @return 
   */
  public Buffer appendShort(short s) {
    this.delegate.appendShort(s);
    return this;
  }
  /**
   * Appends the specified <code>float</code> to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.<p>
   * Returns a reference to <code>this</code> so multiple operations can be appended together.
   * @param f 
   * @return 
   */
  public Buffer appendFloat(float f) {
    this.delegate.appendFloat(f);
    return this;
  }
  /**
   * Appends the specified <code>double</code> to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.<p>
   * Returns a reference to <code>this</code> so multiple operations can be appended together.
   * @param d 
   * @return 
   */
  public Buffer appendDouble(double d) {
    this.delegate.appendDouble(d);
    return this;
  }
  /**
   * Appends the specified <code>String</code> to the end of the Buffer with the encoding as specified by <code>enc</code>.<p>
   * The buffer will expand as necessary to accommodate any bytes written.<p>
   * Returns a reference to <code>this</code> so multiple operations can be appended together.<p>
   * @param str 
   * @param enc 
   * @return 
   */
  public Buffer appendString(String str, String enc) {
    this.delegate.appendString(str, enc);
    return this;
  }
  /**
   * Appends the specified <code>String str</code> to the end of the Buffer with UTF-8 encoding.<p>
   * The buffer will expand as necessary to accommodate any bytes written.<p>
   * Returns a reference to <code>this</code> so multiple operations can be appended together<p>
   * @param str 
   * @return 
   */
  public Buffer appendString(String str) {
    this.delegate.appendString(str);
    return this;
  }
  /**
   * Sets the <code>byte</code> at position <code>pos</code> in the Buffer to the value <code>b</code>.<p>
   * The buffer will expand as necessary to accommodate any value written.
   * @param pos 
   * @param b 
   * @return 
   */
  public Buffer setByte(int pos, byte b) {
    this.delegate.setByte(pos, b);
    return this;
  }
  /**
   * Sets the <code>int</code> at position <code>pos</code> in the Buffer to the value <code>i</code>.<p>
   * The buffer will expand as necessary to accommodate any value written.
   * @param pos 
   * @param i 
   * @return 
   */
  public Buffer setInt(int pos, int i) {
    this.delegate.setInt(pos, i);
    return this;
  }
  /**
   * Sets the <code>long</code> at position <code>pos</code> in the Buffer to the value <code>l</code>.<p>
   * The buffer will expand as necessary to accommodate any value written.
   * @param pos 
   * @param l 
   * @return 
   */
  public Buffer setLong(int pos, long l) {
    this.delegate.setLong(pos, l);
    return this;
  }
  /**
   * Sets the <code>double</code> at position <code>pos</code> in the Buffer to the value <code>d</code>.<p>
   * The buffer will expand as necessary to accommodate any value written.
   * @param pos 
   * @param d 
   * @return 
   */
  public Buffer setDouble(int pos, double d) {
    this.delegate.setDouble(pos, d);
    return this;
  }
  /**
   * Sets the <code>float</code> at position <code>pos</code> in the Buffer to the value <code>f</code>.<p>
   * The buffer will expand as necessary to accommodate any value written.
   * @param pos 
   * @param f 
   * @return 
   */
  public Buffer setFloat(int pos, float f) {
    this.delegate.setFloat(pos, f);
    return this;
  }
  /**
   * Sets the <code>short</code> at position <code>pos</code> in the Buffer to the value <code>s</code>.<p>
   * The buffer will expand as necessary to accommodate any value written.
   * @param pos 
   * @param s 
   * @return 
   */
  public Buffer setShort(int pos, short s) {
    this.delegate.setShort(pos, s);
    return this;
  }
  /**
   * Sets the bytes at position <code>pos</code> in the Buffer to the bytes represented by the <code>Buffer b</code>.<p>
   * The buffer will expand as necessary to accommodate any value written.
   * @param pos 
   * @param b 
   * @return 
   */
  public Buffer setBuffer(int pos, Buffer b) {
    this.delegate.setBuffer(pos, (io.vertx.core.buffer.Buffer)b.getDelegate());
    return this;
  }
  /**
   * Sets the bytes at position <code>pos</code> in the Buffer to the bytes represented by the <code>Buffer b</code> on the given <code>offset</code> and <code>len</code>.<p>
   * The buffer will expand as necessary to accommodate any value written.
   * @param pos 
   * @param b 
   * @param offset 
   * @param len 
   * @return 
   */
  public Buffer setBuffer(int pos, Buffer b, int offset, int len) {
    this.delegate.setBuffer(pos, (io.vertx.core.buffer.Buffer)b.getDelegate(), offset, len);
    return this;
  }
  /**
   * Sets the bytes at position <code>pos</code> in the Buffer to the value of <code>str</code> encoded in UTF-8.<p>
   * The buffer will expand as necessary to accommodate any value written.
   * @param pos 
   * @param str 
   * @return 
   */
  public Buffer setString(int pos, String str) {
    this.delegate.setString(pos, str);
    return this;
  }
  /**
   * Sets the bytes at position <code>pos</code> in the Buffer to the value of <code>str</code> encoded in encoding <code>enc</code>.<p>
   * The buffer will expand as necessary to accommodate any value written.
   * @param pos 
   * @param str 
   * @param enc 
   * @return 
   */
  public Buffer setString(int pos, String str, String enc) {
    this.delegate.setString(pos, str, enc);
    return this;
  }
  /**
   * Returns the length of the buffer, measured in bytes.
   * All positions are indexed from zero.
   * @return 
   */
  public int length() {
    def ret = this.delegate.length();
    return ret;
  }
  /**
   * Returns a copy of the entire Buffer.
   * @return 
   */
  public Buffer copy() {
    def ret= InternalHelper.safeCreate(this.delegate.copy(), io.vertx.groovy.core.buffer.Buffer.class);
    return ret;
  }
  /**
   * Returns a slice of this buffer. Modifying the content
   * of the returned buffer or this buffer affects each other's content
   * while they maintain separate indexes and marks.
   * @return 
   */
  public Buffer slice() {
    def ret= InternalHelper.safeCreate(this.delegate.slice(), io.vertx.groovy.core.buffer.Buffer.class);
    return ret;
  }
  /**
   * Returns a slice of this buffer. Modifying the content
   * of the returned buffer or this buffer affects each other's content
   * while they maintain separate indexes and marks.
   * @param start 
   * @param end 
   * @return 
   */
  public Buffer slice(int start, int end) {
    def ret= InternalHelper.safeCreate(this.delegate.slice(start, end), io.vertx.groovy.core.buffer.Buffer.class);
    return ret;
  }
}
