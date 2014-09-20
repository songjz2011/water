package controllers.validate;

import play.data.validation.Required;
import controllers.BaseController;

public class ValidateController extends BaseController {

  /**
   * <pre>
   * 验证自定义验证信息
   * 请求：POST http://localhost:9000/validateController/customValidationMessages
   * </pre>
   */
  public static void customValidationMessages(@Required Long id) {
    validateRequestParams();
    ok();
  }

}
