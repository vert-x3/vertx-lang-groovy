package io.vertx.lang.groovy;

import io.vertx.codegen.testmodel.TestInterfaceImpl;
import io.vertx.groovy.codegen.testmodel.TestInterface;
import org.junit.Test;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ApiTest {

  final TestInterface obj = new TestInterface(new TestInterfaceImpl());

  @Test
  public void methodWithBasicParams() {
    obj.methodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X', "foobar");
  }

  @Test
  public void methodWithBasicBoxedParams() {
    obj.methodWithBasicBoxedParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X');
  }

//  @Test
//  public void methodWithHandlerBasicTypes() {
    // obj.methodWithHandlerBasicTypes();
//  }
}
