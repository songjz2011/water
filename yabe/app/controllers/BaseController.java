package controllers;

import java.util.List;

import exceptions.GlobalException;
import play.Play;
import play.data.validation.Error;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(value = { GlobalException.class })
public class BaseController extends Controller {

  @Before
  static void addDefaults() {
    renderArgs.put("blogBaseline", Play.configuration.getProperty("blog.baseline"));
  }

  protected static void validateRequestParams() {
    if (validation.hasErrors()) {
      List<Error> erros = validation.errors();
      System.out.println(erros);
      forbidden();
    }
  }

}
