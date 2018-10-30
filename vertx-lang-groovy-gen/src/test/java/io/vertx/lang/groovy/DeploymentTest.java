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
import io.vertx.core.*;
import io.vertx.core.json.JsonObject;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class DeploymentTest{

  // TODO - needs some tests to ensure config, deploymentID etc are populated correctly in Verticle

  boolean isStarted() {
    return System.getProperty("started").equals("true");
  }

  boolean isStopped() {
    return System.getProperty("stopped").equals("true");
  }

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

  private String getRelativePath(String classpathResource) throws Exception {
    URL url = Thread.currentThread().getContextClassLoader().getResource(classpathResource);
    assertNotNull(url);
    URI verticleURI = url.toURI();
    URI userDir = new File(System.getProperty("user.dir")).toURI();
    URI relativeURI = userDir.relativize(verticleURI);
    assertTrue(!relativeURI.isAbsolute());
    return relativeURI.toString();
  }

  private String getAbsolutePath(String classpathResource) throws Exception {
    URL url = Thread.currentThread().getContextClassLoader().getResource("io.vertx.lang.groovy.LifeCycleVerticleClass");
    assertNotNull(url);
    return new File(url.toURI()).getAbsolutePath();
  }

  @After
  public void after() {
    System.clearProperty("started");
    System.clearProperty("stopped");
  }

  @Test
  public void testDeployVerticleClass() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "io.vertx.lang.groovy.LifeCycleVerticleClass",
            onDeploy));
    assertTrue(isStarted());
    assertTrue(isStopped());
  }

  @Test
  public void testAsyncDeployVerticleClass() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "io.vertx.lang.groovy.LifeCycleAsyncVerticleClass",
            onDeploy));
    assertTrue(isStarted());
    assertTrue(isStopped());
  }

  @Test
  public void testDeployVerticleClassInstance() throws Exception {
    Class clazz = assertScript("LifeCycleVerticleClass");
    Verticle verticle = (AbstractVerticle) clazz.newInstance();
    //GroovyVerticle verticle = (GroovyVerticle) clazz.newInstance();
    //Verticle verticle = new AbstractVerticle() {
    //  @Override
    //  public void start(Future<Void> startFuture) {
        /*this.vertx = super.vertx;
        this.context = super.context;
        this.start(startFuture);*/
    //  }

    //  @Override
    //  public void stop(Future<Void> stopFuture) {
    //    //this.stop(stopFuture);
    //  }
    //};

    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            verticle,
            onDeploy));
    assertTrue(isStarted());
    assertTrue(isStopped());
  }

  @Test
  public void testDeployVerticleScript() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "io.vertx.lang.groovy.LifeCycleVerticleScript",
            onDeploy));
    assertTrue(isStarted());
    assertTrue(isStopped());
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
    assertTrue(isStarted());
    assertTrue(isStopped());
  }

  @Test
  public void testAsyncDeployVerticleScript() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "io.vertx.lang.groovy.LifeCycleAsyncVerticleScript",
            onDeploy));
    assertTrue(isStarted());
    assertTrue(isStopped());
  }

  @Test
  public void testDeployVerticleClassFromRelativeFile() throws Exception {
    String relativePath = getRelativePath("io.vertx.lang.groovy.LifeCycleVerticleClass");
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(relativePath, onDeploy));
    assertTrue(isStarted());
    assertTrue(isStopped());
  }

  @Test
  public void testDeployVerticleClassFromAbsoluteFile() throws Exception {
    String verticlePath = getAbsolutePath("io.vertx.lang.groovy.LifeCycleVerticleClass");
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            verticlePath,
            onDeploy));
    assertTrue(isStarted());
    assertTrue(isStopped());
  }

  @Test
  public void testResolveSamePackageFromClassPath() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "io.vertx.lang.groovy.ResolveSamePackageVerticleClass",
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(isStarted());
  }

  @Test
  public void testResolveSamePackageFromRelativeFile() throws Exception {
    String relativePath = getRelativePath("io.vertx.lang.groovy.ResolveSamePackageVerticleClass");
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            relativePath,
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(isStarted());
  }

  @Test
  public void testResolveSamePackageFromAbsoluteFile() throws Exception {
    String relativePath = getAbsolutePath("io.vertx.lang.groovy.ResolveSamePackageVerticleClass");
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            relativePath,
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(isStarted());
  }

  @Test
  public void testResolveChildPackageFromClassPath() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "io.vertx.lang.groovy.ResolveChildPackageVerticleClass",
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(isStarted());
  }

  @Test
  public void testResolveChildPackageFromRelativeFile() throws Exception {
    String relativePath = getRelativePath("io.vertx.lang.groovy.ResolveChildPackageVerticleClass");
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            relativePath,
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(isStarted());
  }

  @Test
  public void testResolveChildPackageFromAbsoluteFile() throws Exception {
    String relativePath = getAbsolutePath("io.vertx.lang.groovy.ResolveChildPackageVerticleClass");
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            relativePath,
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(isStarted());
  }

  @Test
  public void testResolveVertxInJavaVerticleClass() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "io.vertx.lang.groovy.ResolveVertxJavaVerticleClass",
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(isStarted());
  }

  @Test
  public void testResolveVertxInGroovyVerticleClass() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "io.vertx.lang.groovy.ResolveVertxGroovyVerticleClass",
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(isStarted());
  }

  @Test
  public void testResolveVertxInVerticleScript() throws Exception {
    assertDeploy((vertx, onDeploy) ->
        vertx.deployVerticle(
            "io.vertx.lang.groovy.ResolveVertxVerticleScript",
            new DeploymentOptions().setConfig(new JsonObject()),
            onDeploy));
    assertTrue(isStarted());
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
    assertTrue(isStarted());
  }

  @Test
  public void testDeployVerticleGroovyScriptNoStop() throws Exception {
    Vertx vertx = Vertx.vertx();
    try {
      BlockingQueue<AsyncResult<String>> deployed = new ArrayBlockingQueue<>(1);
      vertx.deployVerticle("io.vertx.lang.groovy.NoStopVerticleScript", deployed::add);
      AsyncResult<String> deployment = deployed.poll(10, TimeUnit.SECONDS);
      String deploymentId = assertResult(deployment);
      BlockingQueue<AsyncResult<Void>> undeployed = new ArrayBlockingQueue<>(1);
      vertx.undeploy(deploymentId, undeployed::add);
      AsyncResult<?> undeployment = undeployed.poll(10, TimeUnit.SECONDS);
      assertResult(undeployment);
    } finally {
      vertx.close();
    }
  }

  private void assertDeploy(BiConsumer<Vertx, Handler<AsyncResult<String>>> deployer) throws Exception {
    Vertx vertx = Vertx.vertx();
    try {
      BlockingQueue<AsyncResult<String>> deployed = new ArrayBlockingQueue<>(1);
      deployer.accept(vertx, deployed::add);
      AsyncResult<String> deployment = deployed.poll(10, TimeUnit.SECONDS);
      String deploymentId = assertResult(deployment);
      BlockingQueue<AsyncResult<Void>> undeployed = new ArrayBlockingQueue<>(1);
      vertx.undeploy(deploymentId, undeployed::add);
      AsyncResult<?> undeployment = undeployed.poll(10, TimeUnit.SECONDS);
      assertResult(undeployment);
    } finally {
      vertx.close();
    }
  }
}
