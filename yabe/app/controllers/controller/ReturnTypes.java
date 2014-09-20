package controllers.controller;

import java.util.HashMap;
import java.util.Map;

import models.user.User;
import play.mvc.Controller;

public class ReturnTypes extends Controller {

  public static void return_text() {
    renderText("There are %s unread messages", 10);
  }

  public static void return_json() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("name", "我是谁");
    renderJSON(map);
  }

  public static void return_xml() {
    renderXml("<name>我是谁</name>");
  }

  public static void return_template() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("name", "我是谁");
    renderTemplate("ReturnTypes/template_test.html", map);
  }

  public static void return_redirect() {
    redirect("/returntypes/return_template");
    // redirect("http://www.baidu.com");
  }

  public static void return_chaining() {
    return_template();
  }

  public static void return_render() {
    User user = new User();
    user.id = 1l;
    user.name = "我是谁";
    render(user);
  }
}
