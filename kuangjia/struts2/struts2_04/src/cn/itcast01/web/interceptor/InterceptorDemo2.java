package cn.itcast01.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * �Զ���������1
 * @author baifeng
 *
 */
public class InterceptorDemo2 extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("InterceptorDemo2ִ����");
		//�������һ���������Ǿ�ִ����һ��������
		String str = invocation.invoke();
		System.out.println("Intercptordemo2������");
		return str;
	}

}
