package exceptions;

import play.mvc.Catch;
import play.mvc.Controller;
import play.mvc.With;


public class GlobalException extends Controller{

  @Catch(value = {Exception.class})
  public static void handlerException(Exception e) {
    System.out.println("------------------throw exception------------");
  }
  
}
