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

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.lang.groovy.basescripts.FooScript;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.junit.Test;

import java.net.URL;
import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class CompilerConfigurationTest {

  public static CompilerConfiguration config;

  @Test
  public void testDefaultPropertiesGroovy() throws Exception {
    deployVerticle("groovy:io/vertx/lang/groovy/CompilerConfigVerticleScript.groovy",
        new AbstractMap.SimpleEntry<>("compilerConfiguration.groovy", "configs/compilerConfiguration.groovy"));
    assertEquals("groovy.lang.Script", config.getScriptBaseClass());
    assertEquals("UTF-8", config.getSourceEncoding());
    assertEquals(1, config.getCompilationCustomizers().size());
    assertTrue(config.getCompilationCustomizers().get(0) instanceof ImportCustomizer);
  }

  @Test
  public void testDefaultPropertiesFile() throws Exception {
    deployVerticle("groovy:io/vertx/lang/groovy/CompilerConfigVerticleScript.groovy",
        new AbstractMap.SimpleEntry<>("compilerConfiguration.properties", "configs/compilerConfiguration.properties"));
    assertEquals(FooScript.class.getName(), config.getScriptBaseClass());
  }

  @Test
  public void tesSystemPropertytMissingConfiguration() throws Exception {
    System.setProperty("vertx.groovy.compilerConfiguration", "no.properties");
    try {
      deployVerticle("groovy:io/vertx/lang/groovy/CompilerConfigVerticleScript.groovy");
      assertEquals(null, config.getScriptBaseClass());
    } finally {
      System.clearProperty("vertx.groovy.compilerConfiguration");
    }
  }

  @Test
  public void testSystemPropertyFile() throws Exception {
    System.setProperty("vertx.groovy.compilerConfiguration", "configs/compilerConfiguration.properties");
    try {
      deployVerticle("groovy:io/vertx/lang/groovy/CompilerConfigVerticleScript.groovy");
      assertEquals(FooScript.class.getName(), config.getScriptBaseClass());
    } finally {
      System.clearProperty("vertx.groovy.compilerConfiguration");
    }
  }

  @Test
  public void testSystemPropertyGroovy() throws Exception {
    System.setProperty("vertx.groovy.compilerConfiguration", "configs/compilerConfiguration.groovy");
    try {
      deployVerticle("groovy:io/vertx/lang/groovy/CompilerConfigVerticleScript.groovy");
      assertEquals("groovy.lang.Script", config.getScriptBaseClass());
      assertEquals("UTF-8", config.getSourceEncoding());
      assertEquals(1, config.getCompilationCustomizers().size());
      assertTrue(config.getCompilationCustomizers().get(0) instanceof ImportCustomizer);
    } finally {
      System.clearProperty("vertx.groovy.compilerConfiguration");
    }
  }

  public void deployVerticle(String verticleName, Map.Entry<String, String>... aliases) throws Exception {
    Vertx vertx = Vertx.vertx();
    ClassLoader prevLoader = Thread.currentThread().getContextClassLoader();
    ClassLoader nextLoader = new ClassLoader(prevLoader) {
      @Override
      public URL getResource(String name) {
        for (Map.Entry<String, String> alias : aliases) {
          if (alias.getKey().equals(name)) {
            name = alias.getValue();
            break;
          }
        }
        return super.getResource(name);
      }
    };
    Thread.currentThread().setContextClassLoader(nextLoader);
    try {
      CountDownLatch latch = new CountDownLatch(1);
      vertx.deployVerticle(verticleName, ar -> latch.countDown());
      latch.await(10, TimeUnit.SECONDS);
    } finally {
      Thread.currentThread().setContextClassLoader(prevLoader);
    }
  }
}
