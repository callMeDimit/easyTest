package com.dimit.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Dimit 2015年1月18日
 * 测试方法标识注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	/**默认按给出的输入数据个数进行测试*/
	String value() default "INPUT_TIME";
}

