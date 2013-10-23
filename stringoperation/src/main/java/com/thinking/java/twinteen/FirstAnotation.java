package com.thinking.java.twinteen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see target:定义注解应用与什么地方（例如：一个方法or一个域）
 * @see Retention:定义哪一级别可用，在源代码中(SOURCE)、类文件中（CLASS）、运行时（RUNTIME）
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnotation {

}
