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

package io.vertx.groovy.core.cli;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.core.cli.Option
import java.util.List
import io.vertx.core.cli.Argument
/**
 * Interface defining a command-line interface (in other words a command such as 'run', 'ls'...).
 * This interface is polyglot to ease reuse such as in Vert.x Shell.
 * <p/>
 * A command line interface has a name, and defines a set of options and arguments. Options are key-value pair such
 * as <code>-foo=bar</code> or <code>-flag</code>. The supported formats depend on the used parser. Arguments are unlike
 * options raw values. Options are defined using
 * <a href="../../../../../../../cheatsheet/Option.html">Option</a>, while argument are defined using <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>.
 * <p/>
 * Command line interfaces also define a summary and a description. These attributes are used in the usage generation
 * . To disable the help generation, set the <code>hidden</code> attribute to <code>true</code>.
 * <p/>
 * Command Line Interface object does not contains "value", it's a model. It must be evaluated by a
 * parser that returns a {@link io.vertx.groovy.core.cli.CommandLine} object containing the argument and option values.
*/
@CompileStatic
public class CLI {
  private final def io.vertx.core.cli.CLI delegate;
  public CLI(Object delegate) {
    this.delegate = (io.vertx.core.cli.CLI) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Creates an instance of {@link io.vertx.groovy.core.cli.CLI} using the default implementation.
   * @param name the name of the CLI (must not be <code>null</code>)
   * @return the created instance of {@link io.vertx.groovy.core.cli.CLI}
   */
  public static CLI create(String name) {
    def ret = InternalHelper.safeCreate(io.vertx.core.cli.CLI.create(name), io.vertx.groovy.core.cli.CLI.class);
    return ret;
  }
  /**
   * Parses the user command line interface and create a new {@link io.vertx.groovy.core.cli.CommandLine} containing extracting values.
   * @param arguments the arguments
   * @return the creates command line
   */
  public CommandLine parse(List<String> arguments) {
    def ret = InternalHelper.safeCreate(delegate.parse(arguments != null ? (List)arguments.collect({it}) : null), io.vertx.groovy.core.cli.CommandLine.class);
    return ret;
  }
  /**
   * Parses the user command line interface and create a new {@link io.vertx.groovy.core.cli.CommandLine} containing extracting values.
   * @param arguments the arguments
   * @param validate enable / disable parsing validation
   * @return the creates command line
   */
  public CommandLine parse(List<String> arguments, boolean validate) {
    def ret = InternalHelper.safeCreate(delegate.parse(arguments != null ? (List)arguments.collect({it}) : null, validate), io.vertx.groovy.core.cli.CommandLine.class);
    return ret;
  }
  /**
   * @return the CLI name.
   * @return 
   */
  public String getName() {
    def ret = delegate.getName();
    return ret;
  }
  /**
   * Sets the name of the CLI.
   * @param name the name
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI setName(String name) {
    delegate.setName(name);
    return this;
  }
  /**
   * @return the CLI description.
   * @return 
   */
  public String getDescription() {
    def ret = delegate.getDescription();
    return ret;
  }
  public CLI setDescription(String desc) {
    delegate.setDescription(desc);
    return this;
  }
  /**
   * @return the CLI summary.
   * @return 
   */
  public String getSummary() {
    def ret = delegate.getSummary();
    return ret;
  }
  /**
   * Sets the summary of the CLI.
   * @param summary the summary
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI setSummary(String summary) {
    delegate.setSummary(summary);
    return this;
  }
  /**
   * Checks whether or not the current {@link io.vertx.groovy.core.cli.CLI} instance is hidden.
   * @return <code>true</code> if the current {@link io.vertx.groovy.core.cli.CLI} is hidden,  otherwise
   */
  public boolean isHidden() {
    def ret = delegate.isHidden();
    return ret;
  }
  /**
   * Sets whether or not the current instance of {@link io.vertx.groovy.core.cli.CLI} must be hidden. Hidden CLI are not listed when
   * displaying usages / help messages. In other words, hidden commands are for power user.
   * @param hidden enables or disables the hidden aspect of the CI
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI setHidden(boolean hidden) {
    delegate.setHidden(hidden);
    return this;
  }
  /**
   * Gets the list of options.
   * @return the list of options, empty if none.
   */
  public List<Map<String, Object>> getOptions() {
    def ret = (List)delegate.getOptions()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())});
    return ret;
  }
  /**
   * Adds an option.
   * @param option the option, must not be <code>null</code>. (see <a href="../../../../../../../cheatsheet/Option.html">Option</a>)
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI addOption(Map<String, Object> option = [:]) {
    delegate.addOption(option != null ? new io.vertx.core.cli.Option(io.vertx.lang.groovy.InternalHelper.toJsonObject(option)) : null);
    return this;
  }
  /**
   * Adds a set of options. Unlike {@link io.vertx.groovy.core.cli.CLI#setOptions}}, this method does not remove the existing options.
   * The given list is appended to the existing list.
   * @param options the options, must not be <code>null</code>
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI addOptions(List<Map<String, Object>> options) {
    delegate.addOptions(options != null ? (List)options.collect({new io.vertx.core.cli.Option(io.vertx.lang.groovy.InternalHelper.toJsonObject(it))}) : null);
    return this;
  }
  /**
   * Sets the list of arguments.
   * @param options the list of options, must not be <code>null</code>
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI setOptions(List<Map<String, Object>> options) {
    delegate.setOptions(options != null ? (List)options.collect({new io.vertx.core.cli.Option(io.vertx.lang.groovy.InternalHelper.toJsonObject(it))}) : null);
    return this;
  }
  /**
   * Gets the list of defined arguments.
   * @return the list of argument, empty if none.
   */
  public List<Map<String, Object>> getArguments() {
    def ret = (List)delegate.getArguments()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())});
    return ret;
  }
  /**
   * Adds an argument.
   * @param arg the argument, must not be <code>null</code> (see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>)
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI addArgument(Map<String, Object> arg = [:]) {
    delegate.addArgument(arg != null ? new io.vertx.core.cli.Argument(io.vertx.lang.groovy.InternalHelper.toJsonObject(arg)) : null);
    return this;
  }
  /**
   * Adds a set of arguments. Unlike {@link io.vertx.groovy.core.cli.CLI#setArguments}, this method does not remove the existing arguments.
   * The given list is appended to the existing list.
   * @param args the arguments, must not be <code>null</code>
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI addArguments(List<Map<String, Object>> args) {
    delegate.addArguments(args != null ? (List)args.collect({new io.vertx.core.cli.Argument(io.vertx.lang.groovy.InternalHelper.toJsonObject(it))}) : null);
    return this;
  }
  /**
   * Sets the list of arguments.
   * @param args the list of arguments, must not be <code>null</code>
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI setArguments(List<Map<String, Object>> args) {
    delegate.setArguments(args != null ? (List)args.collect({new io.vertx.core.cli.Argument(io.vertx.lang.groovy.InternalHelper.toJsonObject(it))}) : null);
    return this;
  }
  /**
   * Gets an <a href="../../../../../../../cheatsheet/Option.html">Option</a> based on its name (short name, long name or argument name).
   * @param name the name, must not be <code>null</code>
   * @return the <a href="../../../../../../../cheatsheet/Option.html">Option</a>, <code>null</code> if not found (see <a href="../../../../../../../cheatsheet/Option.html">Option</a>)
   */
  public Map<String, Object> getOption(String name) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.getOption(name)?.toJson());
    return ret;
  }
  /**
   * Gets an <a href="../../../../../../../cheatsheet/Argument.html">Argument</a> based on its name (argument name).
   * @param name the name of the argument, must not be <code>null</code>
   * @return the <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>, <code>null</code> if not found. (see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>)
   */
  public Map<String, Object> getArgument(String name) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.getArgument(name)?.toJson());
    return ret;
  }
  /**
   * Gets an <a href="../../../../../../../cheatsheet/Argument.html">Argument</a> based on its index.
   * @param index the index, must be positive or zero.
   * @return the <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>, <code>null</code> if not found. (see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>)
   */
  public Map<String, Object> getArgument(int index) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(delegate.getArgument(index)?.toJson());
    return ret;
  }
  /**
   * Removes an option identified by its name. This method does nothing if the option cannot be found.
   * @param name the option name
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI removeOption(String name) {
    delegate.removeOption(name);
    return this;
  }
  /**
   * Removes an argument identified by its index. This method does nothing if the argument cannot be found.
   * @param index the argument index
   * @return the current {@link io.vertx.groovy.core.cli.CLI} instance
   */
  public CLI removeArgument(int index) {
    delegate.removeArgument(index);
    return this;
  }
}
