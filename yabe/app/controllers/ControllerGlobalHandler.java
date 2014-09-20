package controllers;

import play.Logger;
import play.mvc.After;
import play.mvc.Before;
import play.mvc.Catch;
import play.mvc.Controller;
import play.mvc.Finally;
import utils.ResponseResult;

public class ControllerGlobalHandler extends Controller {

  @Catch(value = Exception.class)
  public static void handleException(final Exception e) {
    Logger.info(e, "Controller Exception............");
    renderJSON(ResponseResult.fail(e.getMessage()));
  }

  /**
   * before 执行每一个的 url 都会运行的
   */
  @Before
  protected static void checkAuthentification() {
    Logger.info("-----now excute url is %s -------", request.url);
  }

  /**
   * after 执行每一个的 url 都会运行的，若 具体方法体 抛出异常，则不会执行
   */
  @After
  protected static void log_after() {
    Logger.info("-------------@after----------");
  }

  /**
   * Finally 执行每一个的 url 都会运行的，若 具体方法体 抛出异常，照常执行
   */
  @Finally
  protected static void log_finally() {
    Logger.info("-------------@Finally----------");
  }

}
