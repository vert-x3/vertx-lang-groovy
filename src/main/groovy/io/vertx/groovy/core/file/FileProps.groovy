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
/**
 * Represents properties of a file on the file system.
 * <p>
*/
@CompileStatic
public class FileProps {
  private final def io.vertx.core.file.FileProps delegate;
  public FileProps(Object delegate) {
    this.delegate = (io.vertx.core.file.FileProps) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * The date the file was created
   * @return 
   */
  public long creationTime() {
    def ret = this.delegate.creationTime();
    return ret;
  }
  /**
   * The date the file was last accessed
   * @return 
   */
  public long lastAccessTime() {
    def ret = this.delegate.lastAccessTime();
    return ret;
  }
  /**
   * The date the file was last modified
   * @return 
   */
  public long lastModifiedTime() {
    def ret = this.delegate.lastModifiedTime();
    return ret;
  }
  /**
   * Is the file a directory?
   * @return 
   */
  public boolean isDirectory() {
    def ret = this.delegate.isDirectory();
    return ret;
  }
  /**
   * Is the file some other type? (I.e. not a directory, regular file or symbolic link)
   * @return 
   */
  public boolean isOther() {
    def ret = this.delegate.isOther();
    return ret;
  }
  /**
   * Is the file a regular file?
   * @return 
   */
  public boolean isRegularFile() {
    def ret = this.delegate.isRegularFile();
    return ret;
  }
  /**
   * Is the file a symbolic link?
   * @return 
   */
  public boolean isSymbolicLink() {
    def ret = this.delegate.isSymbolicLink();
    return ret;
  }
  /**
   * The size of the file, in bytes
   * @return 
   */
  public long size() {
    def ret = this.delegate.size();
    return ret;
  }
}
