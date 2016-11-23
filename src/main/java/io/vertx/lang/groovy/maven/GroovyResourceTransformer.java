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
package io.vertx.lang.groovy.maven;

import org.apache.maven.plugins.shade.relocation.Relocator;
import org.apache.maven.plugins.shade.resource.ResourceTransformer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class GroovyResourceTransformer implements ResourceTransformer {

  private static final String NAME = "META-INF/services/org.codehaus.groovy.runtime.ExtensionModule";
  private List<String> extensionClasses = new ArrayList<>();
  private List<String> staticExtensionClasses = new ArrayList<>();

  @Override
  public boolean canTransformResource(String resource) {
    return NAME.equals(resource);
  }

  @Override
  public void processResource(String resource, InputStream is, List<Relocator> relocators) throws IOException {
    Properties out = new Properties();
    try {
      out.load(is);
    } finally {
      is.close();
    }
    append(out.getProperty("extensionClasses"), extensionClasses);
    append(out.getProperty("staticExtensionClasses"), staticExtensionClasses);
  }

  private void append(String entry, List<String> list) {
    if (entry != null) {
      Collections.addAll(list, entry.split("\\s*,\\s*"));
    }
  }

  @Override
  public boolean hasTransformedResource() {
    return extensionClasses.size() > 0 && staticExtensionClasses.size() > 0;
  }

  @Override
  public void modifyOutputStream(JarOutputStream os) throws IOException {
    os.putNextEntry( new JarEntry(NAME) );
    Properties desc = new Properties();
    desc.put("moduleName", "vertx-module");
    desc.put("moduleVersion", "1.0");
    if (extensionClasses.size() > 0) {
      desc.put("extensionClasses", extensionClasses.stream().collect(Collectors.joining(",")));
    }
    if (staticExtensionClasses.size() > 0) {
      desc.put("staticExtensionClasses", staticExtensionClasses.stream().collect(Collectors.joining(",")));
    }
    desc.store(os, null);
  }
}
