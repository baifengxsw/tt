package cn.itcast01.dongtaidaili;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * ���Ƚ�����ǿ�Ķ��󴫹���  ͨ���̳еķ�ʽ���ö�̬����
 * @author baifeng
 *
 */
public class CglibProxy  implements MethodInterceptor{
	private CustomerDao customerDao;

	public CglibProxy(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public CustomerDao createProxy() {
		//����cglib�ĺ�����
		Enhancer enhancer = new Enhancer();
		//2������صĸ���
		enhancer.setSuperclass(customerDao.getClass());
		//���ûص� (����InvocationHandler)
		enhancer.setCallback(this);
		CustomerDao proxy = (CustomerDao) enhancer.create();
		return proxy;
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		//�жϷ����Ƿ�Ϊsave
		if("save".equals(method.getName())) {
			//��ǿ
			System.out.println("Ȩ�޵�У��");
			return methodProxy.invokeSuper(proxy, args);
		}
		return methodProxy.invokeSuper(proxy, args);
	}
	
}
