package cn.itcast01.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ��ע�ⷽʽ�γɵ�������
 * @author baifeng
 *
 */
@Aspect
public class MyAspectAnno {
	@Before("execution(* cn.itcast01.demo1.OrderDao.save(..))")
	public void before() {
		System.out.println("ǰ�õ���ǿ");
	}
	
	//����֪ͨ
	@AfterReturning(value="execution(* cn.itcast01.demo1.OrderDao.delete(..))",returning="result")
	public void afterReturning(Object result) {
		System.out.println("������ǿ"+result);
		
	}
	
	//����֪ͨ
	@Around(value="execution(* cn.itcast01.demo1.OrderDao.update(..))")
		public Object around(ProceedingJoinPoint point) throws Throwable {
			System.out.println("����ǰ");
			Object obj = point.proceed();
			System.out.println("���ƺ�");
			return obj;
			
		}

	//�쳣�׳�
	@AfterThrowing(value="MyAspectAnno.pointcut1()" ,throwing="ex" )
	public void afterThrowing(Throwable ex) {
		System.out.println("�쳣�׳�"+ex.getMessage());
	}
	
	@Pointcut(value="execution(* cn.itcast01.demo1.OrderDao.find(..))")
	private void pointcut1() {}
}
	

 