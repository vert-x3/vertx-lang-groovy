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
package io.vertx.lang.groovy;

import io.vertx.codetrans.CodeTranslator;
import io.vertx.codetrans.lang.groovy.GroovyLang;
import io.vertx.docgen.Coordinate;
import io.vertx.docgen.DocGenerator;
import io.vertx.docgen.JavaDocGenerator;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class GroovyDocGenerator implements DocGenerator {

  private CodeTranslator translator;
  private JavaDocGenerator javaGen = new JavaDocGenerator();

  public GroovyDocGenerator() {
  }

  @Override
  public void init(ProcessingEnvironment env) {
    translator = new CodeTranslator(env);
    javaGen.init(env);
  }

  @Override
  public String renderSource(ExecutableElement elt, String source) {
    GroovyLang lang = new GroovyLang();
    try {
      return translator.translate(elt, lang);
    } catch (Exception e) {
      System.out.println("Cannot generate " + elt.getEnclosingElement().getSimpleName() + "#" + elt.getSimpleName() + " : " + e.getMessage());
      return "Code not translatable";
    }
  }

  @Override
  public String getName() {
    return "groovy";
  }

  @Override
  public String resolveTypeLink(TypeElement elt, Coordinate coordinate) {
    return javaGen.resolveTypeLink(elt, coordinate);
  }

  @Override
  public String resolveConstructorLink(ExecutableElement elt, Coordinate coordinate) {
    return javaGen.resolveConstructorLink(elt, coordinate);
  }

  @Override
  public String resolveMethodLink(ExecutableElement elt, Coordinate coordinate) {
    return javaGen.resolveMethodLink(elt, coordinate);
  }

  @Override
  public String resolveLabel(Element elt, String defaultLabel) {
    return javaGen.resolveLabel(elt, defaultLabel);
  }

  @Override
  public String resolveFieldLink(VariableElement elt, Coordinate coordinate) {
    return javaGen.resolveFieldLink(elt, coordinate);
  }
}
