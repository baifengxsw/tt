package cn.itcast.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.Impl.UserServiceImpl;

/**
 * 处理用户的类
 * @author baifeng
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	@Override
	public User getModel() {
		// TODO 自动生成的方法存根
		return user;
	}
	/**
	 * 实现用户登录
	 */
	public String login() {
		UserService userService = new UserServiceImpl();
		User newUser = userService.login(user);
		//根据结果进行页面跳转
		if(newUser!=null) {
			//登录成功 
			ActionContext.getContext().getSession().put("login", newUser);
			//ServletActionContext.getRequest().getSession().setAttribute("login",newUser);
			return SUCCESS;
		}else {
			//登录失败 ActionError,FieldError,ActionMessage
			this.addActionError("用户名或密码错误");
			return LOGIN;
			
		}
		
	}
}
