import io.vertx.lang.groovy.CompilerConfigurationTest

CompilerConfigurationTest.config = getClass().classLoader.delegate.config;
