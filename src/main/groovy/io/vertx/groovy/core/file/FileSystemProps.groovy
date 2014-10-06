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
 * Represents properties of the file system.<p>
 * Instances of FileSystemProps are thread-safe.<p>
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class FileSystemProps {
  final def io.vertx.core.file.FileSystemProps delegate;
  public FileSystemProps(io.vertx.core.file.FileSystemProps delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * The total space on the file system, in bytes
   */
  public long totalSpace() {
    def ret = this.delegate.totalSpace();
    return ret;
  }
  /**
   * The total un-allocated space on the file system, in bytes
   */
  public long unallocatedSpace() {
    def ret = this.delegate.unallocatedSpace();
    return ret;
  }
  /**
   * The total usable space on the file system, in bytes
   */
  public long usableSpace() {
    def ret = this.delegate.usableSpace();
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.file.FileSystemProps, FileSystemProps> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.file.FileSystemProps arg -> new FileSystemProps(arg);
  };
}
