package cn.itcast.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.Impl.UserServiceImpl;

/**
 * �����û�����
 * @author baifeng
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	@Override
	public User getModel() {
		// TODO �Զ����ɵķ������
		return user;
	}
	/**
	 * ʵ���û���¼
	 */
	public String login() {
		UserService userService = new UserServiceImpl();
		User newUser = userService.login(user);
		//���ݽ������ҳ����ת
		if(newUser!=null) {
			//��¼�ɹ� 
			ActionContext.getContext().getSession().put("login", newUser);
			//ServletActionContext.getRequest().getSession().setAttribute("login",newUser);
			return SUCCESS;
		}else {
			//��¼ʧ�� ActionError,FieldError,ActionMessage
			this.addActionError("�û������������");
			return LOGIN;
			
		}
		
	}
}
