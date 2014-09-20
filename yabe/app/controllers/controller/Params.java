package controllers.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import models.user.User;
import play.data.binding.As;
import play.mvc.Controller;
import binder.MyCustomStringBinder;

/**
 * <pre>
 * 
 * 1、请求的参数是 基础类型时，
 * int, long, boolean, char, byte, float, double, Integer, Long, Boolean, Char, String, Byte, Float, Double.
 * 数组、List、Set 都可以 接受相同name的参数
 * </pre>
 * 
 * @author songjz
 *
 */
public class Params extends Controller {

  public static void show() {
    Long id = params.get("id", Long.class);
    System.out.println(id);
    String[] names = params.getAll("name");
    System.out.println();
    for (String n : names) {
      System.out.print("-" + n);
    }
    System.out.println();
    ok();
  }

  /**
   * <pre>
   * 若请求 id=2&name=我时谁&name=事实上
   * 则：Params.detail的id 为 2
   * name = 我时谁,事实上
   * 中间以","进行分割
   * </pre>
   * 
   * @param id
   * @param name
   */
  public static void detail(Long id, String name) {
    System.out.println("id = " + id);
    System.out.println("name = " + name);
    ok();
  }

  /**
   * <pre>
   * 请求：http://localhost:9000/params/list?ids=1&ids=2&names=我时谁&names=事实上&sets=set1&sets=set2
   * </pre>
   */
  public static void list(List<Long> ids, String[] names, Set<String> sets) {
    System.out.println("-------打印ids------");
    for (Long id : ids) {
      System.out.print("--" + id);
    }
    System.out.println();
    System.out.println("-------打印names------");
    for (String name : names) {
      System.out.print("--" + name);
    }
    System.out.println();
    System.out.println("-------打印sets------");
    for (String s : sets) {
      System.out.print("--" + s);
    }
    ok();
  }

  /**
   * <pre>
   * 请求：http://localhost:9000/params/map?client.name=John&client.phone=111-1111&client.phone=222-2222
   * </pre>
   * 
   * @param client
   */
  public static void map(Map<String, String> client) {
    for (Entry<String, String> entry : client.entrySet()) {
      System.out.println("key=" + entry.getKey() + ";value=" + entry.getValue());
    }
    System.out.println();
    ok();
  }

  public static void date(@As("yyyy-MM-dd") Date date) {
    System.out.println(date);
    ok();
  }

  /**
   * <pre>
   * 1、form ： multipart/form-data 
   * 2、
   * </pre>
   */
  public static void file(File attachment) {
  }

  /**
   * <pre>
   * 请求：http://localhost:9000/params/object?user.name=张三
   * </pre>
   * 
   * @param user
   */
  public static void object(User user) {
    System.out.println(user.name);
    ok();
  }

  /**
   * <pre>
   * 请求：http://localhost:9000/params/object?users[0].name=张三&users[1].name=李四
   * </pre>
   * 
   * @param users
   */
  public static void objectList(List<User> users) {
    for (User u : users) {
      System.out.println(u.name);
    }
    ok();
  }

  /**
   * 请求：http://localhost:9000/params/as?items=1,2,3,4
   * 
   * @param items
   */
  public static void as(@As(",") List<String> items) {
    System.out.println(items);
    ok();
  }

  /**
   * 请求：
   * 
   * @param name
   */
  public static void asCustomBind(@As(binder = MyCustomStringBinder.class) String name) {
    System.out.println(name);
  }

  /**
   * 请求：
   * 
   * @param name
   */
  public static void asCustomUnBind(@As(unbinder = MyCustomStringBinder.class) String name) {
    System.out.println(name);
  }

}
