package cn.itcast.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.domain.User;

/**
 * 权限拦截器
 * @author baifeng
 *
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断session是否存在数据
		User user = (User)ActionContext.getContext().getSession().get("login");
		if(user!=null) {
			//已经登录放行
			return invocation.invoke();
		}else {
			//没有登录
			//这个类没有继承actionsupport 所以没有相应的 this.addActionerror
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			actionSupport.addActionError("请先登录");
			return actionSupport.LOGIN;
		}
		
	}

}
