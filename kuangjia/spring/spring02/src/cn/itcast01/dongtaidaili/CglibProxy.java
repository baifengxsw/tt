package cn.itcast01.dongtaidaili;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 首先将被增强的对象传过来  通过继承的方式设置动态代理
 * @author baifeng
 *
 */
public class CglibProxy  implements MethodInterceptor{
	private CustomerDao customerDao;

	public CglibProxy(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public CustomerDao createProxy() {
		//创建cglib的核心类
		Enhancer enhancer = new Enhancer();
		//2设置相关的父类
		enhancer.setSuperclass(customerDao.getClass());
		//设置回调 (类似InvocationHandler)
		enhancer.setCallback(this);
		CustomerDao proxy = (CustomerDao) enhancer.create();
		return proxy;
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		//判断方法是否为save
		if("save".equals(method.getName())) {
			//增强
			System.out.println("权限的校验");
			return methodProxy.invokeSuper(proxy, args);
		}
		return methodProxy.invokeSuper(proxy, args);
	}
	
}
