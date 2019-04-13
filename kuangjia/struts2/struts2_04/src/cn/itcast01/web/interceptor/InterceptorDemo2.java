package cn.itcast01.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器1
 * @author baifeng
 *
 */
public class InterceptorDemo2 extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("InterceptorDemo2执行了");
		//如果有下一个拦截器那就执行下一个拦截器
		String str = invocation.invoke();
		System.out.println("Intercptordemo2结束了");
		return str;
	}

}
