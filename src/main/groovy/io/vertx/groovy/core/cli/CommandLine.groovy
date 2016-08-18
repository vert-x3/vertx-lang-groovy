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
 * The parser transforms a CLI (a model) into an {@link io.vertx.groovy.core.cli.CommandLine}. This {@link io.vertx.groovy.core.cli.CommandLine}
 * has stored the argument and option values. Only  instance of parser should create
 * objects of this type.
*/
@CompileStatic
public class CommandLine {
  private final def io.vertx.core.cli.CommandLine delegate;
  public CommandLine(Object delegate) {
    this.delegate = (io.vertx.core.cli.CommandLine) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Creates a command line object from the {@link io.vertx.groovy.core.cli.CLI}. This object is intended to be used by
   * the parser to set the argument and option values.
   * @param cli the CLI definition
   * @return the command line object
   */
  public static CommandLine create(CLI cli) {
    def ret = InternalHelper.safeCreate(io.vertx.core.cli.CommandLine.create(cli != null ? (io.vertx.core.cli.CLI)cli.getDelegate() : null), io.vertx.groovy.core.cli.CommandLine.class);
    return ret;
  }
  /**
   * @return the model of this command line object.
   */
  public CLI cli() {
    def ret = InternalHelper.safeCreate(delegate.cli(), io.vertx.groovy.core.cli.CLI.class);
    return ret;
  }
  /**
   * @return the ordered list of arguments. Arguments are command line arguments not matching an option.
   */
  public List<String> allArguments() {
    def ret = delegate.allArguments();
    return ret;
  }
  /**
   * Gets the value of an option with the matching name (can be the long name, short name or arg name).
   * @param name the name
   * @return the value, <code>null</code> if not set
   */
  public <T> T getOptionValue(String name) {
    def ret = (T) InternalHelper.wrapObject(delegate.getOptionValue(name));
    return ret;
  }
  /**
   * Gets the value of an argument with the matching name (arg name).
   * @param name the name
   * @return the value, <code>null</code> if not set
   */
  public <T> T getArgumentValue(String name) {
    def ret = (T) InternalHelper.wrapObject(delegate.getArgumentValue(name));
    return ret;
  }
  /**
   * Gets the value of an argument with the given index.
   * @param index the index
   * @return the value, <code>null</code> if not set
   */
  public <T> T getArgumentValue(int index) {
    def ret = (T) InternalHelper.wrapObject(delegate.getArgumentValue(index));
    return ret;
  }
  /**
   * Gets the value of an option marked as a flag.
   * <p/>
   * Calling this method an a non-flag option throws an {@link java.lang.IllegalStateException}.
   * @param name the option name
   * @return <code>true</code> if the flag has been set in the command line, <code>false</code> otherwise.
   */
  public boolean isFlagEnabled(String name) {
    def ret = delegate.isFlagEnabled(name);
    return ret;
  }
  /**
   * Checks whether or not the given option has been assigned in the command line.
   * @param option the option (see <a href="../../../../../../../cheatsheet/Option.html">Option</a>)
   * @return <code>true</code> if the option has received a value,  otherwise.
   */
  public boolean isOptionAssigned(Map<String, Object> option = [:]) {
    def ret = delegate.isOptionAssigned(option != null ? new io.vertx.core.cli.Option(io.vertx.lang.groovy.InternalHelper.toJsonObject(option)) : null);
    return ret;
  }
  /**
   * Gets the raw values of the given option. Raw values are simple "String", not converted to the option type.
   * @param option the option (see <a href="../../../../../../../cheatsheet/Option.html">Option</a>)
   * @return the list of values, empty if none
   */
  public List<String> getRawValues(Map<String, Object> option = [:]) {
    def ret = delegate.getRawValues(option != null ? new io.vertx.core.cli.Option(io.vertx.lang.groovy.InternalHelper.toJsonObject(option)) : null);
    return ret;
  }
  /**
   * Gets the raw values of the given option. Raw values are simple "String", not converted to the option type.
   * @param option the option (see <a href="../../../../../../../cheatsheet/Option.html">Option</a>)
   * @return the list of values, empty if none
   */
  public List<String> getRawValuesForOption(Map<String, Object> option = [:]) {
    def ret = delegate.getRawValuesForOption(option != null ? new io.vertx.core.cli.Option(io.vertx.lang.groovy.InternalHelper.toJsonObject(option)) : null);
    return ret;
  }
  /**
   * Gets the raw values of the given argument. Raw values are simple "String", not converted to the argument type.
   * @param argument the argument (see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>)
   * @return the list of values, empty if none
   */
  public List<String> getRawValuesForArgument(Map<String, Object> argument = [:]) {
    def ret = delegate.getRawValuesForArgument(argument != null ? new io.vertx.core.cli.Argument(io.vertx.lang.groovy.InternalHelper.toJsonObject(argument)) : null);
    return ret;
  }
  /**
   * Gets the raw value of the given option. Raw values are the values as given in the user command line.
   * @param option the option (see <a href="../../../../../../../cheatsheet/Option.html">Option</a>)
   * @return the value, <code>null</code> if none.
   */
  public String getRawValueForOption(Map<String, Object> option = [:]) {
    def ret = delegate.getRawValueForOption(option != null ? new io.vertx.core.cli.Option(io.vertx.lang.groovy.InternalHelper.toJsonObject(option)) : null);
    return ret;
  }
  /**
   * Checks whether or not the given option accept more values.
   * @param option the option (see <a href="../../../../../../../cheatsheet/Option.html">Option</a>)
   * @return  if the option accepts more values,  otherwise.
   */
  public boolean acceptMoreValues(Map<String, Object> option = [:]) {
    def ret = delegate.acceptMoreValues(option != null ? new io.vertx.core.cli.Option(io.vertx.lang.groovy.InternalHelper.toJsonObject(option)) : null);
    return ret;
  }
  /**
   * Gets the raw value of the given argument. Raw values are the values as given in the user command line.
   * @param arg the argument (see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>)
   * @return the value, <code>null</code> if none.
   */
  public String getRawValueForArgument(Map<String, Object> arg = [:]) {
    def ret = delegate.getRawValueForArgument(arg != null ? new io.vertx.core.cli.Argument(io.vertx.lang.groovy.InternalHelper.toJsonObject(arg)) : null);
    return ret;
  }
  /**
   * Checks whether or not the given argument has been assigned in the command line.
   * @param arg the argument (see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>)
   * @return <code>true</code> if the argument has received a value,  otherwise.
   */
  public boolean isArgumentAssigned(Map<String, Object> arg = [:]) {
    def ret = delegate.isArgumentAssigned(arg != null ? new io.vertx.core.cli.Argument(io.vertx.lang.groovy.InternalHelper.toJsonObject(arg)) : null);
    return ret;
  }
  /**
   * Checks whether or not the given option has been seen in the user command line.
   * @param option the option (see <a href="../../../../../../../cheatsheet/Option.html">Option</a>)
   * @return <code>true</code> if the user command line has used the option
   */
  public boolean isSeenInCommandLine(Map<String, Object> option = [:]) {
    def ret = delegate.isSeenInCommandLine(option != null ? new io.vertx.core.cli.Option(io.vertx.lang.groovy.InternalHelper.toJsonObject(option)) : null);
    return ret;
  }
  /**
   * Checks whether or not the command line is valid, i.e. all constraints from arguments and options have been
   * satisfied. This method is used when the parser validation is disabled.
   * @return <code>true</code> if the current {@link io.vertx.groovy.core.cli.CommandLine} object is valid.  otherwise.
   */
  public boolean isValid() {
    def ret = delegate.isValid();
    return ret;
  }
  /**
   * Checks whether or not the user has passed a "help" option and is asking for help.
   * @return <code>true</code> if the user command line has enabled a "Help" option,  otherwise.
   */
  public boolean isAskingForHelp() {
    def ret = delegate.isAskingForHelp();
    return ret;
  }
}
