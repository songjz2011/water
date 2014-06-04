package javax.persistence;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * 注解 - 列名
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月4日
 */
@Target(value = { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	/**
	 * 列名
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 长度
	 * 
	 * @return
	 */
	int length() default 255;

}
