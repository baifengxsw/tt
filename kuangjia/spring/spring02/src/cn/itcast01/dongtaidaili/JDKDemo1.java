package cn.itcast01.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
//使用JDK动态代理对UserDao产生代理
public class JDKDemo1 {
	/**
	 * 产生userDao的代理方法
	 */
	private UserDao userDao;
	
	public JDKDemo1(UserDao userDao) {
		
		this.userDao = userDao;
	}

	public UserDao createProxy() {
		//需要传入dao 
		UserDao userDaoProxy = (UserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//判断方法名是不是save
				if("save".equals(method.getName())){
					//增强
					System.out.println("权限校验-----------------------------------------");
					return method.invoke(userDao, args);
				}
				return method.invoke(userDao, args);
			}
		} );
		
		return userDaoProxy;
	}
}
