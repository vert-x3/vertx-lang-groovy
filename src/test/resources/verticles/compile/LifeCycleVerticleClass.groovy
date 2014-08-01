package verticles.compile;

import io.vertx.groovy.core.GroovyVerticle
import io.vertx.lang.groovy.DeploymentTest;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class VerticleClass extends GroovyVerticle {

    @Override
    void start() throws Exception {
        DeploymentTest.started.set(true)
    }

    @Override
    void stop() throws Exception {
        DeploymentTest.stopped.set(true)
    }
}
