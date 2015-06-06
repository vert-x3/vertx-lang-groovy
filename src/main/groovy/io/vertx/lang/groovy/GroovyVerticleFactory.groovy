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

package io.vertx.lang.groovy

import groovy.transform.CompileStatic
import io.vertx.core.Verticle
import io.vertx.core.Vertx
import io.vertx.core.logging.Logger
import io.vertx.core.logging.LoggerFactory
import io.vertx.core.spi.VerticleFactory
import org.codehaus.groovy.control.CompilerConfiguration
/**
 * Placeholder
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 * @author Alexander Klein
 * @author Danny Kirchmeier
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@CompileStatic
public class GroovyVerticleFactory implements VerticleFactory {

  private static final String CONFIGURATION_PROPERTY = "vertx.groovy.compilerConfiguration";
  private static Logger log = LoggerFactory.getLogger(GroovyVerticleFactory.class);

  private Vertx vertx;

  @Override
  public void init(Vertx vertx) {
    this.vertx = vertx;
  }

  @Override
  public String prefix() {
    return "groovy";
  }

  @Override
  public Verticle createVerticle(String verticleName, ClassLoader classLoader) throws Exception {
    verticleName = VerticleFactory.removePrefix(verticleName);
    Object instance;
    CompilerConfiguration compilerConfig = createCompilerConfiguration(classLoader);
    if (verticleName.endsWith(".groovy")) {
      URL url = classLoader.getResource(verticleName);
      if (url == null) {
        File f = new File(verticleName);
        if (!f.isAbsolute()) {
          f = new File(System.getProperty('user.dir'), verticleName);
        }
        if (f.exists() && f.isFile()) {
          url = f.toURI().toURL();
        }
      }
      if (url == null) {
        throw new IllegalStateException("Cannot find verticle script: " + verticleName + " on classpath");
      }
      GroovyClassLoader gcl = new GroovyClassLoader(classLoader, compilerConfig);
      GroovyCodeSource gcs = new GroovyCodeSource(url);
      Class clazz = gcl.parseClass(gcs);
      instance = clazz.newInstance();
    } else {
      Class clazz = classLoader.loadClass(verticleName);
      instance = clazz.newInstance();
    }

    Verticle verticle;
    if (instance instanceof GroovyVerticle) {
      GroovyVerticle groovyVerticle = (GroovyVerticle) instance;
      verticle = groovyVerticle.asJavaVerticle();
    } else if (instance instanceof Script) {
      Script script = (Script) instance;
      verticle = new ScriptVerticle(script);
    } else {
      throw new UnsupportedOperationException("Not yet implemented");
    }
    return verticle;
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
    compilerCfg.configure(properties);
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
