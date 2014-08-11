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

package io.vertx.lang.groovy.examples;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class Runner {

  private static Vertx vertx = Vertx.vertx();

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      throw new IllegalArgumentException("Need at last one argument");
    }
    try {
      Method m = Runner.class.getDeclaredMethod(args[0]);
      m.invoke(null);
    } catch (NoSuchMethodException e) {
      throw new IllegalArgumentException("Test " + args[0] + " does not exist");
    }
    Thread.sleep(10000000);
  }

  public static void echo() {
    deploySequentially("groovy:echo/EchoServer.groovy", "groovy:echo/EchoClient.groovy");
  }

  public static void eventbus_pointtopoint() {
    deploySequentially("groovy:eventbus_pointtopoint/Receiver.groovy");
    deploySequentially("groovy:eventbus_pointtopoint/Sender.groovy");
  }

  public static void eventbus_pubsub() {
    deploySequentially("groovy:eventbus_pubsub/Receiver.groovy");
    deploySequentially("groovy:eventbus_pubsub/Sender.groovy");
  }

  public static void http() {
    deploySequentially("groovy:http/Server.groovy", "groovy:http/Client.groovy");
  }

  public static void deploySequentially(String... verticles) {
    deploySequentially(Arrays.asList(verticles));
  }

  /**
   * Deploy the provided verticles sequentially.
   *
   * @param verticles the verticles to deploy
   */
  public static void deploySequentially(List<String> verticles) {
    if (verticles.size() > 0) {
      String verticle = verticles.get(0);
      vertx.deployVerticle(verticle, DeploymentOptions.options(), result -> {
        if (result.succeeded()) {
          System.out.println("Deployed " + verticle);
          deploySequentially(verticles.subList(1, verticles.size()));
        } else {
          System.out.println("Verticle " + verticle + " failed to deploy");
          result.cause().printStackTrace();
        }
      });
    } else {
      System.out.println("Everything deployed");
    }
  }
}
