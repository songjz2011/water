package binder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;

import play.data.binding.TypeBinder;
import play.data.binding.TypeUnbinder;

public class MyCustomStringBinder implements TypeBinder<String>, TypeUnbinder<String> {

  @Override
  public boolean unBind(Map<String, Object> result, Object src, Class<?> srcClazz, String name,
      Annotation[] annotations) throws Exception {
    return false;
  }

  /**
   * name : 
   */
  @Override
  public Object bind(String name, Annotation[] annotations, String value, Class actualClass,
      Type genericType) throws Exception {
    return "!!" + value + "!!";
  }

}
