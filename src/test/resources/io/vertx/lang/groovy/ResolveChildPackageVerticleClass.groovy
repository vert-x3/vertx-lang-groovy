package io.vertx.lang.groovy

import io.vertx.lang.groovy.sub.InChildPackage

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ResolveChildPackageVerticleClass extends GroovyVerticle {

    @Override
    void start() throws Exception {
        InChildPackage o = new InChildPackage()
        DeploymentTest.started.set(true)
    }

    @Override
    void stop() throws Exception {
        DeploymentTest.stopped.set(true)
    }
}
