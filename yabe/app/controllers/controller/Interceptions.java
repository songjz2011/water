package controllers.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.user.User;
import play.Logger;
import play.cache.Cache;
import play.mvc.After;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Finally;
import play.mvc.With;
import controllers.ControllerGlobalHandler;

@With(value = { ControllerGlobalHandler.class })
public class Interceptions extends Controller {

  public static void index() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("aa", "tt");
    Logger.info("Interceptions.index ....");
    Cache.add("", "");
    renderJSON(map);
  }

  /**
   * 
   */
  public static void catchExceptionAction() {
    List<User> users = User.findAll();
    if (users.size() == 0) {
      throw new RuntimeException("Invalid database - 0 users");
    }
    render(users);
  }

}
