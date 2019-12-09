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

import groovy.lang.*;
import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.spi.VerticleFactory;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.Callable;

/**
 * Placeholder
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 * @author Alexander Klein
 * @author Danny Kirchmeier
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class GroovyVerticleFactory implements VerticleFactory {

  private static final String CONFIGURATION_PROPERTY = "vertx.groovy.compilerConfiguration";
  private static Logger log = LoggerFactory.getLogger(GroovyVerticleFactory.class);

  private Vertx vertx;

  public GroovyVerticleFactory() {
  }

  @Override
  public void init(Vertx vertx) {
    this.vertx = vertx;
  }

  @Override
  public String prefix() {
    return "groovy";
  }

  @Override
  public void createVerticle(String verticleName, ClassLoader classLoader, Promise<Callable<Verticle>> promise) {
    String name = VerticleFactory.removePrefix(verticleName);
    Future<Class<?>> fut = vertx.executeBlocking(p -> {
      Class clazz;
      try {
        CompilerConfiguration compilerConfig = createCompilerConfiguration(classLoader);
        if (name.endsWith(".groovy")) {
          URL url = classLoader.getResource(name);
          if (url == null) {
            File f = new File(name);
            if (!f.isAbsolute()) {
              f = new File(System.getProperty("user.dir"), name);
            }
            if (f.exists() && f.isFile()) {
              url = f.toURI().toURL();
            }
          }
          if (url == null) {
            throw new IllegalStateException("Cannot find verticle script: " + name + " on classpath");
          }
          GroovyClassLoader gcl = new GroovyClassLoader(classLoader, compilerConfig);
          GroovyCodeSource gcs = new GroovyCodeSource(url);
          clazz = gcl.parseClass(gcs);
        } else {
          clazz = classLoader.loadClass(name);
        }
      } catch (Exception e) {
        p.fail(e);
        return;
      }
      p.complete(clazz);
    });
    fut.map(clazz -> (Callable<Verticle>) () -> {
      Object instance = clazz.getDeclaredConstructor().newInstance();
      if (instance instanceof Script) {
        return new ScriptVerticle((Script) instance);
      } else if (instance instanceof Verticle) {
        return (Verticle) instance;
      } else {
        throw new Exception("Class " + instance.getClass().getName() + " is not a Verticle");
      }
    }).onComplete(promise);
  }

  @Override
  public void close() {
    vertx = null;
  }

  private CompilerConfiguration createCompilerConfiguration(ClassLoader cl) {
    Closure customizer = null;
    Properties properties = new Properties();
    URL url = findConfigurationResource(cl);
    if(url != null) {
      log.trace("Configuring groovy compiler with ${url}");
      try {
        if(url.getFile().toLowerCase().endsWith(".groovy")) {
          ConfigSlurper slurper = new ConfigSlurper();
          slurper.setClassLoader(new GroovyClassLoader(cl));
          ConfigObject cObject = slurper.parse(url);
          Object c = cObject.remove("customizer");
          if (c instanceof Closure<?>) {
            customizer = (Closure) c;
          }
          properties.putAll(cObject.toProperties());
        } else {
          InputStream stream = url.openStream();
          properties.load(stream);
        }
      } catch(Exception e) {
        log.error("Error loading Groovy CompilerConfiguration properties from $url", e);
      }
    } else {
      log.trace("No groovy configuration file found.");
    }

    CompilerConfiguration compilerCfg = new CompilerConfiguration(CompilerConfiguration.DEFAULT);
    if(properties.size() != 0){
      compilerCfg.configure(properties);
    }

    if (customizer != null) {
      Object result = customizer.call(compilerCfg);
      // Expectation: If result isn't a CompilerConfiguration, the original one has been modified
      if(result instanceof CompilerConfiguration)
        compilerCfg = (CompilerConfiguration) result;
    }
    return compilerCfg;
  }

  private URL findConfigurationResource(ClassLoader cl) {
    try{
      String prop = System.getProperty(CONFIGURATION_PROPERTY);
      if(prop != null) {
        return cl.getResource(prop);
      }
    } catch(SecurityException ignored){
    }
    URL url = cl.getResource("compilerConfiguration.groovy");
    if(url == null) {
      url = cl.getResource("compilerConfiguration.properties");
    }
    return url;
  }
}
