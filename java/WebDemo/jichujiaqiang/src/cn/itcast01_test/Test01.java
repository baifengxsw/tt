package cn.itcast01_test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����һ���µ�ע��
 * @author baifeng
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test01 {
	//Ĭ�ϼ�һ������,��Ϊ��������
	public long timeout() default -1;

}
