package cn.itcast01.demo4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 * @author baifeng
 *
 */
public class MyAspectXML {
	public void checkPri(JoinPoint join) {
		System.out.println("权限校验"+join);
	}
	
	/**
	 * 后置通知
	 */
	
	public void writeLogs(Object result) {
		System.out.println("写入日志"+result);
	}
	
	/**
	 * 环绕 性能监控
	 * @throws Throwable 
	 */
	public Object around(ProceedingJoinPoint join) throws Throwable {
		System.out.println("环绕前的通知");
		Object obj = join.proceed();
		System.out.println("环绕后进行通知");
		return obj;
		
	}
}
