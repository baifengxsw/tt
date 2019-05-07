package cn.itcast01.demo4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * ������
 * @author baifeng
 *
 */
public class MyAspectXML {
	public void checkPri(JoinPoint join) {
		System.out.println("Ȩ��У��"+join);
	}
	
	/**
	 * ����֪ͨ
	 */
	
	public void writeLogs(Object result) {
		System.out.println("dsfdsf"+result);
	}
	
	/**
	 * ���� ���ܼ��
	 * @throws Throwable 
	 */
	public Object around(ProceedingJoinPoint join) throws Throwable {
		System.out.println("����ǰ��֪ͨ");
		Object obj = join.proceed();
		System.out.println("���ƺ����֪ͨ");
		return obj;
		
	}
}
