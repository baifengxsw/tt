package cn.itcast.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.domain.User;

/**
 * Ȩ��������
 * @author baifeng
 *
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//�ж�session�Ƿ��������
		User user = (User)ActionContext.getContext().getSession().get("login");
		if(user!=null) {
			//�Ѿ���¼����
			return invocation.invoke();
		}else {
			//û�е�¼
			//�����û�м̳�actionsupport ����û����Ӧ�� this.addActionerror
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			actionSupport.addActionError("���ȵ�¼");
			return actionSupport.LOGIN;
		}
		
	}

}
