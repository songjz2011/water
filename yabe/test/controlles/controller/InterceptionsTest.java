package controlles.controller;

import org.junit.Test;

import play.mvc.Http.Response;
import play.test.FunctionalTest;

public class InterceptionsTest extends FunctionalTest {

  @Test
  public void test_index() {
    Response response = GET("/interceptions/index");
    System.out.println("----test_index------" + response.out.toString());
  }

  @Test
  public void test_catchExceptionAction() {
    Response response = GET("/interceptions/catchExceptionAction");
    System.out.println("-----test_catchExceptionAction-----" + response.out.toString());
  }

}
