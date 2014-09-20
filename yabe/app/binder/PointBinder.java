package binder;

import java.awt.Point;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import play.data.binding.Global;
import play.data.binding.TypeBinder;

@Global
public class PointBinder implements TypeBinder<Point> {

  public Object bind(String name, Annotation[] annotations, String value, Class actualClass,
      Type genericType) throws Exception {
    String[] values = value.split(",");
    return new Point(
        Integer.parseInt(values[0]),
        Integer.parseInt(values[1]));
  }
}
