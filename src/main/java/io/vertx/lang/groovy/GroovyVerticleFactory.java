package io.vertx.lang.groovy;

import groovy.lang.Binding;
import groovy.lang.Closure;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.MetaMethod;
import groovy.lang.MissingMethodException;
import groovy.lang.Script;
import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.impl.LoggerFactory;
import io.vertx.core.spi.VerticleFactory;
import io.vertx.groovy.core.Context;
import io.vertx.groovy.core.GroovyVerticle;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

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

  // Just here to see if it compiles
  private Context context = null;
  private Vertx vertx;
  CompilerConfiguration compilerCfg;

  @Override
  public void init(Vertx vertx) {
    this.vertx = vertx;
    this.compilerCfg = createCompilerConfiguration(GroovyVerticleFactory.class.getClassLoader());
  }

  @Override
  public String prefix() {
    return "groovy";
  }

  @Override
  public Verticle createVerticle(String verticleName, ClassLoader classLoader) throws Exception {



    Object instance;

    if (verticleName.endsWith(".groovy")) {
      URL url = classLoader.getResource(verticleName);
      if (url == null) {
        throw new IllegalStateException("Cannot find verticle script: " + verticleName + " on classpath");
      }
      GroovyClassLoader gcl = new GroovyClassLoader();
      GroovyCodeSource gcs = new GroovyCodeSource(url);
      Class clazz = gcl.parseClass(gcs);

/*
      Method stop;
      try {
        stop = clazz.getMethod("vertxStop", (Class<?>[])null);
      } catch (NoSuchMethodException e) {
        stop = null;
      }
      final Method mstop = stop;

      Method mrun;
      try {
        mrun = clazz.getMethod("run", (Class<?>[])null);
      } catch (NoSuchMethodException e) {
        throw new IllegalStateException("Groovy script must have run() method [whether implicit or not]");
      }
*/

      instance = clazz.newInstance();
/*
      if (o instanceof Script) {
        Script script = (Script) o;
        // script.setBinding(null);
      } else {

      }
*/
      // script.setBinding(createBinding());

/*
      verticle = new JVerticle() {
        public void start() {
          // The throwables need to be thrown up to the PlatformManager so the deployment can fail
          try {
            mrun.invoke(script, (Object[]) null)
          } catch (RuntimeException e) {
            throw e;
          } catch (Exception e) {
            throw new RuntimeException(e);
          } catch (Error e) {
            throw e;
          }
        }

        public void stop() {
          if (mstop != null) {
            // The throwables need to be thrown up to the PlatformManager so the stop can fail
            try {
              mstop.invoke(script, (Object[]) null)
            } catch (RuntimeException e) {
              throw e;
            } catch (Exception e) {
              throw new RuntimeException(e);
            } catch (Error e) {
              throw e;
            }
          }
        }
      }
*/
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
      Binding binding = new Binding();
      script.setBinding(binding);
      verticle = new AbstractVerticle() {
        @Override
        public void start() throws Exception {
          script.run();
        }

        @Override
        public void stop() throws Exception {
          try {
            script.invokeMethod("vertxStop", null);
          } catch (MissingMethodException ignore) {
          }
        }
      };
    } else {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    //
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
          InputStream in = url.openStream();
          properties.load(in);
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
