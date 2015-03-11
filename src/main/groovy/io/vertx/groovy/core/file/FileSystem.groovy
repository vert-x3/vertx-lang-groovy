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
 * Contains a broad set of operations for manipulating files on the file system.
 * <p>
 * A (potential) blocking and non blocking version of each operation is provided.
 * <p>
 * The non blocking versions take a handler which is called when the operation completes or an error occurs.
 * <p>
 * The blocking versions are named <code>xxxBlocking</code> and return the results, or throw exceptions directly.
 * In many cases, depending on the operating system and file system some of the potentially blocking operations
 * can return quickly, which is why we provide them, but it's highly recommended that you test how long they take to
 * return in your particular application before using them on an event loop.
 * <p>
 * Please consult the documentation for more information on file system support.
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
   * Copy a file from the path <code>from</code> to path <code>to</code>, asynchronously.
   * <p>
   * The copy will fail if the destination already exists.
   * @param from the path to copy from
   * @param to the path to copy to
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem copy(String from, String to, Handler<AsyncResult<Void>> handler) {
    this.delegate.copy(from, to, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param from 
   * @param to 
   * @return 
   */
  public FileSystem copyBlocking(String from, String to) {
    this.delegate.copyBlocking(from, to);
    return this;
  }
  /**
   * Copy a file from the path <code>from</code> to path <code>to</code>, asynchronously.
   * <p>
   * If <code>recursive</code> is <code>true</code> and <code>from</code> represents a directory, then the directory and its contents
   * will be copied recursively to the destination <code>to</code>.
   * <p>
   * The copy will fail if the destination if the destination already exists.
   * @param from the path to copy from
   * @param to the path to copy to
   * @param recursive 
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem copyRecursive(String from, String to, boolean recursive, Handler<AsyncResult<Void>> handler) {
    this.delegate.copyRecursive(from, to, recursive, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param from 
   * @param to 
   * @param recursive 
   * @return 
   */
  public FileSystem copyRecursiveBlocking(String from, String to, boolean recursive) {
    this.delegate.copyRecursiveBlocking(from, to, recursive);
    return this;
  }
  /**
   * Move a file from the path <code>from</code> to path <code>to</code>, asynchronously.
   * <p>
   * The move will fail if the destination already exists.
   * @param from the path to copy from
   * @param to the path to copy to
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem move(String from, String to, Handler<AsyncResult<Void>> handler) {
    this.delegate.move(from, to, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param from 
   * @param to 
   * @return 
   */
  public FileSystem moveBlocking(String from, String to) {
    this.delegate.moveBlocking(from, to);
    return this;
  }
  /**
   * Truncate the file represented by <code>path</code> to length <code>len</code> in bytes, asynchronously.
   * <p>
   * The operation will fail if the file does not exist or <code>len</code> is less than <code>zero</code>.
   * @param path the path to the file
   * @param len the length to truncate it to
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem truncate(String path, long len, Handler<AsyncResult<Void>> handler) {
    this.delegate.truncate(path, len, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @param len 
   * @return 
   */
  public FileSystem truncateBlocking(String path, long len) {
    this.delegate.truncateBlocking(path, len);
    return this;
  }
  /**
   * Change the permissions on the file represented by <code>path</code> to <code>perms</code>, asynchronously.
   * <p>
   * The permission String takes the form rwxr-x--- as
   * specified <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
   * @param path the path to the file
   * @param perms the permissions string
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem chmod(String path, String perms, Handler<AsyncResult<Void>> handler) {
    this.delegate.chmod(path, perms, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @param perms 
   * @return 
   */
  public FileSystem chmodBlocking(String path, String perms) {
    this.delegate.chmodBlocking(path, perms);
    return this;
  }
  /**
   * Change the permissions on the file represented by <code>path</code> to <code>perms</code>, asynchronously.<p>
   * The permission String takes the form rwxr-x--- as
   * specified in {<a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>}.
   * <p>
   * If the file is directory then all contents will also have their permissions changed recursively. Any directory permissions will
   * be set to <code>dirPerms</code>, whilst any normal file permissions will be set to <code>perms</code>.
   * @param path the path to the file
   * @param perms the permissions string
   * @param dirPerms the directory permissions
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem chmodRecursive(String path, String perms, String dirPerms, Handler<AsyncResult<Void>> handler) {
    this.delegate.chmodRecursive(path, perms, dirPerms, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @param perms 
   * @param dirPerms 
   * @return 
   */
  public FileSystem chmodRecursiveBlocking(String path, String perms, String dirPerms) {
    this.delegate.chmodRecursiveBlocking(path, perms, dirPerms);
    return this;
  }
  /**
   * Change the ownership on the file represented by <code>path</code> to <code>user</code> and {code group}, asynchronously.
   * @param path the path to the file
   * @param user the user name
   * @param group the user group
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem chown(String path, String user, String group, Handler<AsyncResult<Void>> handler) {
    this.delegate.chown(path, user, group, handler);
    return this;
  }
  /**
   * Blocking version of link
   *
   * @param path 
   * @param user 
   * @param group 
   * @return 
   */
  public FileSystem chownBlocking(String path, String user, String group) {
    this.delegate.chownBlocking(path, user, group);
    return this;
  }
  /**
   * Obtain properties for the file represented by <code>path</code>, asynchronously.
   * <p>
   * If the file is a link, the link will be followed.
   * @param path the path to the file
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem props(String path, Handler<AsyncResult<FileProps>> handler) {
    this.delegate.props(path, new Handler<AsyncResult<io.vertx.core.file.FileProps>>() {
      public void handle(AsyncResult<io.vertx.core.file.FileProps> event) {
        AsyncResult<FileProps> f
        if (event.succeeded()) {
          f = InternalHelper.<FileProps>result(new FileProps(event.result()))
        } else {
          f = InternalHelper.<FileProps>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @return 
   */
  public FileProps propsBlocking(String path) {
    def ret= FileProps.FACTORY.apply(this.delegate.propsBlocking(path));
    return ret;
  }
  /**
   * Obtain properties for the link represented by <code>path</code>, asynchronously.
   * <p>
   * The link will not be followed.
   * @param path the path to the file
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem lprops(String path, Handler<AsyncResult<FileProps>> handler) {
    this.delegate.lprops(path, new Handler<AsyncResult<io.vertx.core.file.FileProps>>() {
      public void handle(AsyncResult<io.vertx.core.file.FileProps> event) {
        AsyncResult<FileProps> f
        if (event.succeeded()) {
          f = InternalHelper.<FileProps>result(new FileProps(event.result()))
        } else {
          f = InternalHelper.<FileProps>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @return 
   */
  public FileProps lpropsBlocking(String path) {
    def ret= FileProps.FACTORY.apply(this.delegate.lpropsBlocking(path));
    return ret;
  }
  /**
   * Create a hard link on the file system from <code>link</code> to <code>existing</code>, asynchronously.
   * @param link the link
   * @param existing the link destination
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem link(String link, String existing, Handler<AsyncResult<Void>> handler) {
    this.delegate.link(link, existing, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param link 
   * @param existing 
   * @return 
   */
  public FileSystem linkBlocking(String link, String existing) {
    this.delegate.linkBlocking(link, existing);
    return this;
  }
  /**
   * Create a symbolic link on the file system from <code>link</code> to <code>existing</code>, asynchronously.
   * @param link the link
   * @param existing the link destination
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem symlink(String link, String existing, Handler<AsyncResult<Void>> handler) {
    this.delegate.symlink(link, existing, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param link 
   * @param existing 
   * @return 
   */
  public FileSystem symlinkBlocking(String link, String existing) {
    this.delegate.symlinkBlocking(link, existing);
    return this;
  }
  /**
   * Unlinks the link on the file system represented by the path <code>link</code>, asynchronously.
   * @param link the link
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem unlink(String link, Handler<AsyncResult<Void>> handler) {
    this.delegate.unlink(link, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param link 
   * @return 
   */
  public FileSystem unlinkBlocking(String link) {
    this.delegate.unlinkBlocking(link);
    return this;
  }
  /**
   * Returns the path representing the file that the symbolic link specified by <code>link</code> points to, asynchronously.
   * @param link the link
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem readSymlink(String link, Handler<AsyncResult<String>> handler) {
    this.delegate.readSymlink(link, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param link 
   * @return 
   */
  public String readSymlinkBlocking(String link) {
    def ret = this.delegate.readSymlinkBlocking(link);
    return ret;
  }
  /**
   * Deletes the file represented by the specified <code>path</code>, asynchronously.
   * @param path path to the file
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem delete(String path, Handler<AsyncResult<Void>> handler) {
    this.delegate.delete(path, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @return 
   */
  public FileSystem deleteBlocking(String path) {
    this.delegate.deleteBlocking(path);
    return this;
  }
  /**
   * Deletes the file represented by the specified <code>path</code>, asynchronously.
   * <p>
   * If the path represents a directory and <code>recursive = true</code> then the directory and its contents will be
   * deleted recursively.
   * @param path path to the file
   * @param recursive delete recursively?
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem deleteRecursive(String path, boolean recursive, Handler<AsyncResult<Void>> handler) {
    this.delegate.deleteRecursive(path, recursive, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @param recursive 
   * @return 
   */
  public FileSystem deleteRecursiveBlocking(String path, boolean recursive) {
    this.delegate.deleteRecursiveBlocking(path, recursive);
    return this;
  }
  /**
   * Create the directory represented by <code>path</code>, asynchronously.
   * <p>
   * The operation will fail if the directory already exists.
   * @param path path to the file
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem mkdir(String path, Handler<AsyncResult<Void>> handler) {
    this.delegate.mkdir(path, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @return 
   */
  public FileSystem mkdirBlocking(String path) {
    this.delegate.mkdirBlocking(path);
    return this;
  }
  /**
   * Create the directory represented by <code>path</code>, asynchronously.
   * <p>
   * The new directory will be created with permissions as specified by <code>perms</code>.
   * <p>
   * The permission String takes the form rwxr-x--- as specified
   * in <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
   * <p>
   * The operation will fail if the directory already exists.
   * @param path path to the file
   * @param perms the permissions string
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem mkdir(String path, String perms, Handler<AsyncResult<Void>> handler) {
    this.delegate.mkdir(path, perms, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @param perms 
   * @return 
   */
  public FileSystem mkdirBlocking(String path, String perms) {
    this.delegate.mkdirBlocking(path, perms);
    return this;
  }
  /**
   * Create the directory represented by <code>path</code> and any non existent parents, asynchronously.
   * <p>
   * The operation will fail if the directory already exists.
   * @param path path to the file
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem mkdirs(String path, Handler<AsyncResult<Void>> handler) {
    this.delegate.mkdirs(path, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @return 
   */
  public FileSystem mkdirsBlocking(String path) {
    this.delegate.mkdirsBlocking(path);
    return this;
  }
  /**
   * Create the directory represented by <code>path</code> and any non existent parents, asynchronously.
   * <p>
   * The new directory will be created with permissions as specified by <code>perms</code>.
   * <p>
   * The permission String takes the form rwxr-x--- as specified
   * in <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
   * <p>
   * The operation will fail if the directory already exists.<p>
   * @param path path to the file
   * @param perms the permissions string
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem mkdirs(String path, String perms, Handler<AsyncResult<Void>> handler) {
    this.delegate.mkdirs(path, perms, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @param perms 
   * @return 
   */
  public FileSystem mkdirsBlocking(String path, String perms) {
    this.delegate.mkdirsBlocking(path, perms);
    return this;
  }
  /**
   * Read the contents of the directory specified by <code>path</code>, asynchronously.
   * <p>
   * The result is an array of String representing the paths of the files inside the directory.
   * @param path path to the file
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem readDir(String path, Handler<AsyncResult<List<String>>> handler) {
    this.delegate.readDir(path, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @return 
   */
  public List<String> readDirBlocking(String path) {
    def ret = this.delegate.readDirBlocking(path);
    return ret;
  }
  /**
   * Read the contents of the directory specified by <code>path</code>, asynchronously.
   * <p>
   * The parameter <code>filter</code> is a regular expression. If <code>filter</code> is specified then only the paths that
   * match  @{filter}will be returned.
   * <p>
   * The result is an array of String representing the paths of the files inside the directory.
   * @param path path to the directory
   * @param filter the filter expression
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem readDir(String path, String filter, Handler<AsyncResult<List<String>>> handler) {
    this.delegate.readDir(path, filter, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @param filter 
   * @return 
   */
  public List<String> readDirBlocking(String path, String filter) {
    def ret = this.delegate.readDirBlocking(path, filter);
    return ret;
  }
  /**
   * Reads the entire file as represented by the path <code>path</code> as a , asynchronously.
   * <p>
   * Do not user this method to read very large files or you risk running out of available RAM.
   * @param path path to the file
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem readFile(String path, Handler<AsyncResult<Buffer>> handler) {
    this.delegate.readFile(path, new Handler<AsyncResult<io.vertx.core.buffer.Buffer>>() {
      public void handle(AsyncResult<io.vertx.core.buffer.Buffer> event) {
        AsyncResult<Buffer> f
        if (event.succeeded()) {
          f = InternalHelper.<Buffer>result(new Buffer(event.result()))
        } else {
          f = InternalHelper.<Buffer>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @return 
   */
  public Buffer readFileBlocking(String path) {
    def ret= Buffer.FACTORY.apply(this.delegate.readFileBlocking(path));
    return ret;
  }
  /**
   * Creates the file, and writes the specified <code>Buffer data</code> to the file represented by the path <code>path</code>,
   * asynchronously.
   * @param path path to the file
   * @param data 
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem writeFile(String path, Buffer data, Handler<AsyncResult<Void>> handler) {
    this.delegate.writeFile(path, (io.vertx.core.buffer.Buffer)data.getDelegate(), handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @param data 
   * @return 
   */
  public FileSystem writeFileBlocking(String path, Buffer data) {
    this.delegate.writeFileBlocking(path, (io.vertx.core.buffer.Buffer)data.getDelegate());
    return this;
  }
  /**
   * Open the file represented by <code>path</code>, asynchronously.
   * <p>
   * The file is opened for both reading and writing. If the file does not already exist it will be created.
   * @param path path to the file
   * @param options options describing how the file should be opened (see <a href="../../../../../../../cheatsheet/OpenOptions.html">OpenOptions</a>)
   * @param handler 
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem open(String path, Map<String, Object> options, Handler<AsyncResult<AsyncFile>> handler) {
    this.delegate.open(path, options != null ? new io.vertx.core.file.OpenOptions(new io.vertx.core.json.JsonObject(options)) : null, new Handler<AsyncResult<io.vertx.core.file.AsyncFile>>() {
      public void handle(AsyncResult<io.vertx.core.file.AsyncFile> event) {
        AsyncResult<AsyncFile> f
        if (event.succeeded()) {
          f = InternalHelper.<AsyncFile>result(new AsyncFile(event.result()))
        } else {
          f = InternalHelper.<AsyncFile>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @param options  (see <a href="../../../../../../../cheatsheet/OpenOptions.html">OpenOptions</a>)
   * @return 
   */
  public AsyncFile openBlocking(String path, Map<String, Object> options) {
    def ret= AsyncFile.FACTORY.apply(this.delegate.openBlocking(path, options != null ? new io.vertx.core.file.OpenOptions(new io.vertx.core.json.JsonObject(options)) : null));
    return ret;
  }
  /**
   * Creates an empty file with the specified <code>path</code>, asynchronously.
   * @param path path to the file
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem createFile(String path, Handler<AsyncResult<Void>> handler) {
    this.delegate.createFile(path, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @return 
   */
  public FileSystem createFileBlocking(String path) {
    this.delegate.createFileBlocking(path);
    return this;
  }
  /**
   * Creates an empty file with the specified <code>path</code> and permissions <code>perms</code>, asynchronously.
   * @param path path to the file
   * @param perms the permissions string
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem createFile(String path, String perms, Handler<AsyncResult<Void>> handler) {
    this.delegate.createFile(path, perms, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @param perms 
   * @return 
   */
  public FileSystem createFileBlocking(String path, String perms) {
    this.delegate.createFileBlocking(path, perms);
    return this;
  }
  /**
   * Determines whether the file as specified by the path <code>path</code> exists, asynchronously.
   * @param path path to the file
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem exists(String path, Handler<AsyncResult<Boolean>> handler) {
    this.delegate.exists(path, handler);
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @return 
   */
  public boolean existsBlocking(String path) {
    def ret = this.delegate.existsBlocking(path);
    return ret;
  }
  /**
   * Returns properties of the file-system being used by the specified <code>path</code>, asynchronously.
   * @param path path to anywhere on the filesystem
   * @param handler the handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  public FileSystem fsProps(String path, Handler<AsyncResult<FileSystemProps>> handler) {
    this.delegate.fsProps(path, new Handler<AsyncResult<io.vertx.core.file.FileSystemProps>>() {
      public void handle(AsyncResult<io.vertx.core.file.FileSystemProps> event) {
        AsyncResult<FileSystemProps> f
        if (event.succeeded()) {
          f = InternalHelper.<FileSystemProps>result(new FileSystemProps(event.result()))
        } else {
          f = InternalHelper.<FileSystemProps>failure(event.cause())
        }
        handler.handle(f)
      }
    });
    return this;
  }
  /**
   * Blocking version of link
   * @param path 
   * @return 
   */
  public FileSystemProps fsPropsBlocking(String path) {
    def ret= FileSystemProps.FACTORY.apply(this.delegate.fsPropsBlocking(path));
    return ret;
  }

  static final java.util.function.Function<io.vertx.core.file.FileSystem, FileSystem> FACTORY = io.vertx.lang.groovy.Factories.createFactory() {
    io.vertx.core.file.FileSystem arg -> new FileSystem(arg);
  };
}
