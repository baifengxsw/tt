package cn.itcast01.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 以注解方式形成的切面类
 * @author baifeng
 *
 */
@Aspect
public class MyAspectAnno {
	@Before("execution(* cn.itcast01.demo1.OrderDao.save(..))")
	public void before() {
		System.out.println("前置的增强");
	}
	
	//后置通知
	@AfterReturning(value="execution(* cn.itcast01.demo1.OrderDao.delete(..))",returning="result")
	public void afterReturning(Object result) {
		System.out.println("后置增强"+result);
		
	}
	
	//环绕通知
	@Around(value="execution(* cn.itcast01.demo1.OrderDao.update(..))")
		public Object around(ProceedingJoinPoint point) throws Throwable {
			System.out.println("环绕前");
			Object obj = point.proceed();
			System.out.println("环绕后");
			return obj;
			
		}

	//异常抛出
	@AfterThrowing(value="MyAspectAnno.pointcut1()" ,throwing="ex" )
	public void afterThrowing(Throwable ex) {
		System.out.println("异常抛出"+ex.getMessage());
	}
	
	@Pointcut(value="execution(* cn.itcast01.demo1.OrderDao.find(..))")
	private void pointcut1() {}
}
	

 