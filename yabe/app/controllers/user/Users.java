package controllers.user;

import java.util.List;

import models.user.User;
import play.data.binding.As;
import play.data.validation.Required;
import controllers.BaseController;

public class Users extends BaseController {

  public static void index() {
    User user = User.find("order by name").first();
    render(user);
  }

  public static void show(@Required Long id) {
    User user = User.find("order by name").first();
    render(user);
  }

  public static void test() {
    System.out.println("-----------test-------");
  }

  public static void save(List<User> users) {
    for (User user : users) {
      user.save();
    }
    ok();
  }
}
