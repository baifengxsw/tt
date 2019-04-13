package cn.itcast01.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
//ʹ��JDK��̬�����UserDao��������
public class JDKDemo1 {
	/**
	 * ����userDao�Ĵ�����
	 */
	private UserDao userDao;
	
	public JDKDemo1(UserDao userDao) {
		
		this.userDao = userDao;
	}

	public UserDao createProxy() {
		//��Ҫ����dao 
		UserDao userDaoProxy = (UserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//�жϷ������ǲ���save
				if("save".equals(method.getName())){
					//��ǿ
					System.out.println("Ȩ��У��-----------------------------------------");
					return method.invoke(userDao, args);
				}
				return method.invoke(userDao, args);
			}
		} );
		
		return userDaoProxy;
	}
}
