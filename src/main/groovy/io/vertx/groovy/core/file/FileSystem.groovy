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
import java.util.List
import io.vertx.groovy.core.buffer.Buffer
import io.vertx.core.file.OpenOptions
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Contains a broad set of operations for manipulating files.<p>
 * An asynchronous and a synchronous version of each operation is provided.<p>
 * The asynchronous versions take a handler which is called when the operation completes or an error occurs.<p>
 * The synchronous versions return the results, or throw exceptions directly.<p>
 * It is highly recommended the asynchronous versions are used unless you are sure the operation
 * will not block for a significant period of time.<p>
 * Instances of FileSystem are thread-safe.<p>
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@CompileStatic
public class FileSystem {
  final def io.vertx.core.file.FileSystem delegate;
  public FileSystem(io.vertx.core.file.FileSystem delegate) {
    this.delegate = delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Copy a file from the path {@code from} to path {@code to}, asynchronously.<p>
   * The copy will fail if the destination already exists.<p>
   */
  public FileSystem copy(String from, String to, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.copy(from, to, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #copy(String, String, Handler)}
   */
  public FileSystem copySync(String from, String to) {
    def ret= FileSystem.FACTORY.apply(this.delegate.copySync(from, to));
    return ret;
  }
  /**
   * Copy a file from the path {@code from} to path {@code to}, asynchronously.<p>
   * If {@code recursive} is {@code true} and {@code from} represents a directory, then the directory and its contents
   * will be copied recursively to the destination {@code to}.<p>
   * The copy will fail if the destination if the destination already exists.<p>
   */
  public FileSystem copyRecursive(String from, String to, boolean recursive, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.copyRecursive(from, to, recursive, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #copyRecursive(String, String, boolean, Handler)}
   */
  public FileSystem copyRecursiveSync(String from, String to, boolean recursive) {
    def ret= FileSystem.FACTORY.apply(this.delegate.copyRecursiveSync(from, to, recursive));
    return ret;
  }
  /**
   * Move a file from the path {@code from} to path {@code to}, asynchronously.<p>
   * The move will fail if the destination already exists.<p>
   */
  public FileSystem move(String from, String to, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.move(from, to, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #move(String, String, Handler)}
   */
  public FileSystem moveSync(String from, String to) {
    def ret= FileSystem.FACTORY.apply(this.delegate.moveSync(from, to));
    return ret;
  }
  /**
   * Truncate the file represented by {@code path} to length {@code len} in bytes, asynchronously.<p>
   * The operation will fail if the file does not exist or {@code len} is less than {@code zero}.
   */
  public FileSystem truncate(String path, long len, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.truncate(path, len, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #truncate(String, long, Handler)}
   */
  public FileSystem truncateSync(String path, long len) {
    def ret= FileSystem.FACTORY.apply(this.delegate.truncateSync(path, len));
    return ret;
  }
  /**
   * Change the permissions on the file represented by {@code path} to {@code perms}, asynchronously.
   * The permission String takes the form rwxr-x--- as
   * specified <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.<p>
   */
  public FileSystem chmod(String path, String perms, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.chmod(path, perms, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #chmod(String, String, Handler) }
   */
  public FileSystem chmodSync(String path, String perms) {
    def ret= FileSystem.FACTORY.apply(this.delegate.chmodSync(path, perms));
    return ret;
  }
  /**
   * Change the permissions on the file represented by {@code path} to {@code perms}, asynchronously.
   * The permission String takes the form rwxr-x--- as
   * specified in {<a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>}.<p>
   * If the file is directory then all contents will also have their permissions changed recursively. Any directory permissions will
   * be set to {@code dirPerms}, whilst any normal file permissions will be set to {@code perms}.<p>
   */
  public FileSystem chmodRecursive(String path, String perms, String dirPerms, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.chmodRecursive(path, perms, dirPerms, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #chmodRecursive(String, String, String, Handler)}
   */
  public FileSystem chmodRecursiveSync(String path, String perms, String dirPerms) {
    def ret= FileSystem.FACTORY.apply(this.delegate.chmodRecursiveSync(path, perms, dirPerms));
    return ret;
  }
  /**
   * Change the ownership on the file represented by {@code path} to {@code user} and {code group}, asynchronously.

   */
  public FileSystem chown(String path, String user, String group, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.chown(path, user, group, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #chown(String, String, String, Handler)}

   */
  public FileSystem chownSync(String path, String user, String group) {
    def ret= FileSystem.FACTORY.apply(this.delegate.chownSync(path, user, group));
    return ret;
  }
  /**
   * Obtain properties for the file represented by {@code path}, asynchronously.
   * If the file is a link, the link will be followed.
   */
  public FileSystem props(String path, Handler<AsyncResult<FileProps>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.props(path, new Handler<AsyncResult<io.vertx.core.file.FileProps>>() {
      public void handle(AsyncResult<io.vertx.core.file.FileProps> event) {
        AsyncResult<FileProps> f
        if (event.succeeded()) {
          f = InternalHelper.<FileProps>result(new FileProps(event.result()))
        } else {
          f = InternalHelper.<FileProps>failure(event.cause())
        }
        handler.handle(f)
      }
    }));
    return ret;
  }
  /**
   * Synchronous version of {@link #props(String, Handler)}
   */
  public FileProps propsSync(String path) {
    def ret= FileProps.FACTORY.apply(this.delegate.propsSync(path));
    return ret;
  }
  /**
   * Obtain properties for the link represented by {@code path}, asynchronously.
   * The link will not be followed.
   */
  public FileSystem lprops(String path, Handler<AsyncResult<FileProps>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.lprops(path, new Handler<AsyncResult<io.vertx.core.file.FileProps>>() {
      public void handle(AsyncResult<io.vertx.core.file.FileProps> event) {
        AsyncResult<FileProps> f
        if (event.succeeded()) {
          f = InternalHelper.<FileProps>result(new FileProps(event.result()))
        } else {
          f = InternalHelper.<FileProps>failure(event.cause())
        }
        handler.handle(f)
      }
    }));
    return ret;
  }
  /**
   * Synchronous version of {@link #lprops(String, Handler)}
   */
  public FileProps lpropsSync(String path) {
    def ret= FileProps.FACTORY.apply(this.delegate.lpropsSync(path));
    return ret;
  }
  /**
   * Create a hard link on the file system from {@code link} to {@code existing}, asynchronously.
   */
  public FileSystem link(String link, String existing, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.link(link, existing, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #link(String, String, Handler)}
   */
  public FileSystem linkSync(String link, String existing) {
    def ret= FileSystem.FACTORY.apply(this.delegate.linkSync(link, existing));
    return ret;
  }
  /**
   * Create a symbolic link on the file system from {@code link} to {@code existing}, asynchronously.
   */
  public FileSystem symlink(String link, String existing, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.symlink(link, existing, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #link(String, String, Handler)}
   */
  public FileSystem symlinkSync(String link, String existing) {
    def ret= FileSystem.FACTORY.apply(this.delegate.symlinkSync(link, existing));
    return ret;
  }
  /**
   * Unlinks the link on the file system represented by the path {@code link}, asynchronously.
   */
  public FileSystem unlink(String link, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.unlink(link, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #unlink(String, Handler)}
   */
  public FileSystem unlinkSync(String link) {
    def ret= FileSystem.FACTORY.apply(this.delegate.unlinkSync(link));
    return ret;
  }
  /**
   * Returns the path representing the file that the symbolic link specified by {@code link} points to, asynchronously.
   */
  public FileSystem readSymlink(String link, Handler<AsyncResult<String>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.readSymlink(link, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #readSymlink(String, Handler)}
   */
  public String readSymlinkSync(String link) {
    def ret = this.delegate.readSymlinkSync(link);
    return ret;
  }
  /**
   * Deletes the file represented by the specified {@code path}, asynchronously.
   */
  public FileSystem delete(String path, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.delete(path, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #delete(String, Handler)}
   */
  public FileSystem deleteSync(String path) {
    def ret= FileSystem.FACTORY.apply(this.delegate.deleteSync(path));
    return ret;
  }
  /**
   * Deletes the file represented by the specified {@code path}, asynchronously.<p>
   * If the path represents a directory and {@code recursive = true} then the directory and its contents will be
   * deleted recursively.
   */
  public FileSystem deleteRecursive(String path, boolean recursive, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.deleteRecursive(path, recursive, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #deleteRecursive(String, boolean, Handler)}
   */
  public FileSystem deleteSyncRecursive(String path, boolean recursive) {
    def ret= FileSystem.FACTORY.apply(this.delegate.deleteSyncRecursive(path, recursive));
    return ret;
  }
  /**
   * Create the directory represented by {@code path}, asynchronously.<p>
   * The operation will fail if the directory already exists.
   */
  public FileSystem mkdir(String path, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.mkdir(path, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #mkdir(String, Handler)}
   */
  public FileSystem mkdirSync(String path) {
    def ret= FileSystem.FACTORY.apply(this.delegate.mkdirSync(path));
    return ret;
  }
  /**
   * Create the directory represented by {@code path}, asynchronously.<p>
   * The new directory will be created with permissions as specified by {@code perms}.
   * The permission String takes the form rwxr-x--- as specified
   * in <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.<p>
   * The operation will fail if the directory already exists.
   */
  public FileSystem mkdir(String path, String perms, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.mkdir(path, perms, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #mkdir(String, String, Handler)}
   */
  public FileSystem mkdirSync(String path, String perms) {
    def ret= FileSystem.FACTORY.apply(this.delegate.mkdirSync(path, perms));
    return ret;
  }
  /**
   * Create the directory represented by {@code path}, asynchronously.<p>
   * If {@code createParents} is set to {@code true} then any non-existent parent directories of the directory
   * will also be created.<p>
   * The operation will fail if the directory already exists.
   */
  public FileSystem mkdirs(String path, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.mkdirs(path, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #mkdirs(String, Handler)}
   */
  public FileSystem mkdirsSync(String path) {
    def ret= FileSystem.FACTORY.apply(this.delegate.mkdirsSync(path));
    return ret;
  }
  /**
   * Create the directory represented by {@code path}, asynchronously.<p>
   * The new directory will be created with permissions as specified by {@code perms}.
   * The permission String takes the form rwxr-x--- as specified
   * in <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.<p>
   * If {@code createParents} is set to {@code true} then any non-existent parent directories of the directory
   * will also be created.<p>
   * The operation will fail if the directory already exists.<p>
   */
  public FileSystem mkdirs(String path, String perms, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.mkdirs(path, perms, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #mkdirs(String, String, Handler)}
   */
  public FileSystem mkdirsSync(String path, String perms) {
    def ret= FileSystem.FACTORY.apply(this.delegate.mkdirsSync(path, perms));
    return ret;
  }
  /**
   * Read the contents of the directory specified by {@code path}, asynchronously.<p>
   * The result is an array of String representing the paths of the files inside the directory.
   */
  public FileSystem readDir(String path, Handler<AsyncResult<List<String>>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.readDir(path, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #readDir(String, Handler)}
   */
  public List<String> readDirSync(String path) {
    def ret = this.delegate.readDirSync(path);
    return ret;
  }
  /**
   * Read the contents of the directory specified by {@code path}, asynchronously.<p>
   * The parameter {@code filter} is a regular expression. If {@code filter} is specified then only the paths that
   * match  @{filter}will be returned.<p>
   * The result is an array of String representing the paths of the files inside the directory.
   */
  public FileSystem readDir(String path, String filter, Handler<AsyncResult<List<String>>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.readDir(path, filter, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #readDir(String, String, Handler)}
   */
  public List<String> readDirSync(String path, String filter) {
    def ret = this.delegate.readDirSync(path, filter);
    return ret;
  }
  /**
   * Reads the entire file as represented by the path {@code path} as a {@link Buffer}, asynchronously.<p>
   * Do not user this method to read very large files or you risk running out of available RAM.
   */
  public FileSystem readFile(String path, Handler<AsyncResult<Buffer>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.readFile(path, new Handler<AsyncResult<io.vertx.core.buffer.Buffer>>() {
      public void handle(AsyncResult<io.vertx.core.buffer.Buffer> event) {
        AsyncResult<Buffer> f
        if (event.succeeded()) {
          f = InternalHelper.<Buffer>result(new Buffer(event.result()))
        } else {
          f = InternalHelper.<Buffer>failure(event.cause())
        }
        handler.handle(f)
      }
    }));
    return ret;
  }
  /**
   * Synchronous version of {@link #readFile(String, Handler)}
   */
  public Buffer readFileSync(String path) {
    def ret= Buffer.FACTORY.apply(this.delegate.readFileSync(path));
    return ret;
  }
  /**
   * Creates the file, and writes the specified {@code Buffer data} to the file represented by the path {@code path},
   * asynchronously.
   */
  public FileSystem writeFile(String path, Buffer data, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.writeFile(path, (io.vertx.core.buffer.Buffer)data.getDelegate(), handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #writeFile(String, Buffer, Handler)}
   */
  public FileSystem writeFileSync(String path, Buffer data) {
    def ret= FileSystem.FACTORY.apply(this.delegate.writeFileSync(path, (io.vertx.core.buffer.Buffer)data.getDelegate()));
    return ret;
  }
  /**
   * Open the file represented by {@code path}, asynchronously.<p>
   * The file is opened for both reading and writing. If the file does not already exist it will be created.
   * Write operations will not automatically flush to storage.
   */
  public FileSystem open(String path, Map<String, Object> options, Handler<AsyncResult<AsyncFile>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.open(path, options != null ? new io.vertx.core.file.OpenOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<AsyncResult<io.vertx.core.file.AsyncFile>>() {
      public void handle(AsyncResult<io.vertx.core.file.AsyncFile> event) {
        AsyncResult<AsyncFile> f
        if (event.succeeded()) {
          f = InternalHelper.<AsyncFile>result(new AsyncFile(event.result()))
        } else {
          f = InternalHelper.<AsyncFile>failure(event.cause())
        }
        handler.handle(f)
      }
    }));
    return ret;
  }
  /**
   * Synchronous version of {@link #open(String, io.vertx.core.file.OpenOptions, Handler)}
   */
  public AsyncFile openSync(String path, Map<String, Object> options) {
    def ret= AsyncFile.FACTORY.apply(this.delegate.openSync(path, options != null ? new io.vertx.core.file.OpenOptions(new io.vertx.core.json.JsonObject(options)) : null));
    return ret;
  }
  /**
   * Creates an empty file with the specified {@code path}, asynchronously.
   */
  public FileSystem createFile(String path, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.createFile(path, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #createFile(String, Handler)}
   */
  public FileSystem createFileSync(String path) {
    def ret= FileSystem.FACTORY.apply(this.delegate.createFileSync(path));
    return ret;
  }
  /**
   * Creates an empty file with the specified {@code path} and permissions {@code perms}, asynchronously.
   */
  public FileSystem createFile(String path, String perms, Handler<AsyncResult<Void>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.createFile(path, perms, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #createFile(String, String, Handler)}
   */
  public FileSystem createFileSync(String path, String perms) {
    def ret= FileSystem.FACTORY.apply(this.delegate.createFileSync(path, perms));
    return ret;
  }
  /**
   * Determines whether the file as specified by the path {@code path} exists, asynchronously.
   */
  public FileSystem exists(String path, Handler<AsyncResult<Boolean>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.exists(path, handler));
    return ret;
  }
  /**
   * Synchronous version of {@link #exists(String, Handler)}
   */
  public boolean existsSync(String path) {
    def ret = this.delegate.existsSync(path);
    return ret;
  }
  /**
   * Returns properties of the file-system being used by the specified {@code path}, asynchronously.
   */
  public FileSystem fsProps(String path, Handler<AsyncResult<FileSystemProps>> handler) {
    def ret= FileSystem.FACTORY.apply(this.delegate.fsProps(path, new Handler<AsyncResult<io.vertx.core.file.FileSystemProps>>() {
      public void handle(AsyncResult<io.vertx.core.file.FileSystemProps> event) {
        AsyncResult<FileSystemProps> f
        if (event.succeeded()) {
          f = InternalHelper.<FileSystemProps>result(new FileSystemProps(event.result()))
        } else {
          f = InternalHelper.<FileSystemProps>failure(event.cause())
        }
        handler.handle(f)
      }
    }));
    return ret;
  }
  /**
   * Synchronous version of {@link #fsProps(String, Handler)}
   */
  public FileSystemProps fsPropsSync(String path) {
    def ret= FileSystemProps.FACTORY.apply(this.delegate.fsPropsSync(path));
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.file.FileSystem, FileSystem> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.file.FileSystem arg -> new FileSystem(arg);
  };
}
