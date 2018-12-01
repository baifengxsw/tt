package cn.itcast01_test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义一个新的注解
 * @author baifeng
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test01 {
	//默认加一个括号,作为定义属性
	public long timeout() default -1;

}
