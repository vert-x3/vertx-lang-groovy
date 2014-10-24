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

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.Script;
import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class DeploymentTest {

  // TODO - needs some tests to ensure config, deploymentID etc are populated correctly in Verticle

  public static final AtomicBoolean started = new AtomicBoolean();
  public static final AtomicBoolean stopped = new AtomicBoolean();

  private static <T>  T assertResult(AsyncResult<T> asyncResult) {
    if (asyncResult.succeeded()) {
      return asyncResult.result();
    } else {
      AssertionFailedError afe = new AssertionFailedError();
      afe.initCause(asyncResult.cause());
      throw afe;
    }
  }

  private Class assertScript(String script) {
    GroovyClassLoader loader = new GroovyClassLoader(getClass().getClassLoader());
    try {
      return loader.loadClass(getClass().getPackage().getName() + "." + script);
    } catch (ClassNotFoundException e) {
      AssertionFailedError afe = new AssertionFailedError();
      afe.initCause(e);
      throw afe;
    }
  }

  @Before
  public void before() {
    started.set(false);
    stopped.set(false);
  }

  @Test
  public void testDeployVerticleClass() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "groovy:io/vertx/lang/groovy/LifeCycleVerticleClass.groovy",
            onDeploy));
    assertTrue(started.get());
    assertTrue(stopped.get());
  }

  @Test
  public void testAsyncDeployVerticleClass() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "groovy:io/vertx/lang/groovy/LifeCycleAsyncVerticleClass.groovy",
            onDeploy));
    assertTrue(started.get());
    assertTrue(stopped.get());
  }

  @Test
  public void testDeployVerticleClassInstance() throws Exception {
    Class clazz = assertScript("LifeCycleVerticleClass");
    GroovyVerticle verticle = (GroovyVerticle) clazz.newInstance();
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            verticle.asJavaVerticle(),
            onDeploy));
    assertTrue(started.get());
    assertTrue(stopped.get());
  }

  @Test
  public void testDeployVerticleScript() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "groovy:io/vertx/lang/groovy/LifeCycleVerticleScript.groovy",
            onDeploy));
    assertTrue(started.get());
    assertTrue(stopped.get());
  }

  @Test
  public void testDeployVerticleScriptInstance() throws Exception {
    Class clazz = assertScript("LifeCycleVerticleScript");
    Script script = (Script) clazz.newInstance();
    ScriptVerticle verticle = new ScriptVerticle(script);
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            verticle,
            onDeploy));
    assertTrue(started.get());
    assertTrue(stopped.get());
  }

  @Test
  public void testResolveVertxInClass() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "groovy:io/vertx/lang/groovy/ResolveVertxVerticleClass.groovy",
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(started.get());
  }

  @Test
  public void testResolveVertxInScript() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "groovy:io/vertx/lang/groovy/ResolveVertxVerticleScript.groovy",
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(started.get());
  }

  @Test
  public void testReuseBindingInScript() throws Exception {
    Class clazz = assertScript("ReuseBindingVerticleScript");
    Script script = (Script) clazz.newInstance();
    Binding binding = new Binding();
    binding.setVariable("myobject", new Object());
    script.setBinding(binding);
    ScriptVerticle verticle = new ScriptVerticle(script);
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(verticle, onDeploy));
    assertTrue(started.get());
  }

  @Test
  public void testDeployVerticleGroovyScriptNoStop() throws Exception {
    Vertx vertx = Vertx.vertx();
    try {
      BlockingQueue<AsyncResult<String>> deployed = new ArrayBlockingQueue<>(1);
      vertx.deployVerticle("groovy:io/vertx/lang/groovy//NoStopVerticleScript.groovy", deployed::add);
      AsyncResult<String> deployment = deployed.poll(10, TimeUnit.SECONDS);
      String deploymentId = assertResult(deployment);
      BlockingQueue<AsyncResult<Void>> undeployed = new ArrayBlockingQueue<>(1);
      vertx.undeployVerticle(deploymentId, undeployed::add);
      AsyncResult<?> undeployment = undeployed.poll(10, TimeUnit.SECONDS);
      assertResult(undeployment);
    } finally {
      vertx.close();
    }
  }

  @FunctionalInterface
  static interface Deployer {
    void deploy(Vertx vertx, Handler<AsyncResult<String>> onDeploy);
  }

  private void assertDeploy(Deployer deployer) throws Exception {
    Vertx vertx = Vertx.vertx();
    try {
      BlockingQueue<AsyncResult<String>> deployed = new ArrayBlockingQueue<>(1);
      deployer.deploy(vertx, deployed::add);
      AsyncResult<String> deployment = deployed.poll(10, TimeUnit.SECONDS);
      String deploymentId = assertResult(deployment);
      BlockingQueue<AsyncResult<Void>> undeployed = new ArrayBlockingQueue<>(1);
      vertx.undeployVerticle(deploymentId, undeployed::add);
      AsyncResult<?> undeployment = undeployed.poll(10, TimeUnit.SECONDS);
      assertResult(undeployment);
    } finally {
      vertx.close();
    }
  }
}
