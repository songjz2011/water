package custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD })
public @interface FruitConfig {

  /**
   * 颜色属性
   */
  Color color() default Color.GREEN;

  int size() default 5;

  String type() default "";

  /**
   * 默认注解的配置（若不写该方法，则使用枚举时，必须指定参数）
   * @return
   */
  String value() default "";

  /**
   * 颜色枚举
   */
  public enum Color {
    BULE, RED, GREEN
  };

}
