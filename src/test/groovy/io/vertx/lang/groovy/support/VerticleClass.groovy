package io.vertx.lang.groovy.support;

import io.vertx.groovy.core.GroovyVerticle
import io.vertx.lang.groovy.DeploymentTest;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class VerticleClass extends GroovyVerticle {

    @Override
    void start() throws Exception {
        DeploymentTest.started.await()
    }

    @Override
    void stop() throws Exception {
        DeploymentTest.stopped.await()
    }
}
