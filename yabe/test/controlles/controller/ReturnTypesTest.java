package controlles.controller;

import java.util.Map;

import org.junit.Test;

import play.mvc.Http.Response;
import play.test.FunctionalTest;

import com.google.gson.Gson;

public class ReturnTypesTest extends FunctionalTest {

  @Test
  public void return_text() {
    Response response = GET("/returntypes/return_text");
    assertEquals("There are 10 unread messages", response.out.toString());
  }

  @Test
  public void return_json() {
    Response response = POST("/returntypes/return_json");
    Map<String, String> map = new Gson().fromJson(response.out.toString(), Map.class);
    assertEquals("我是谁", map.get("name"));
  }

  @Test
  public void return_xml() {
    Response response = POST("/returntypes/return_xml");
    assertEquals("<name>我是谁</name>", response.out.toString());
  }
  
  @Test
  public void return_template() {
    Response response = POST("/returntypes/return_template");
    System.out.println("-----return_template-----" + response.out.toString());
  }
  
  @Test
  public void return_render() {
    Response response = POST("/returntypes/return_render");
    System.out.println("----return_render------" + response.out.toString());
  }

}
