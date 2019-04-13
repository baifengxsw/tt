package cn.itcast01.web.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 只有继承这个类 ，才会有相应的数据校验，国际化,设置错误信息
 * @author baifeng
 *
 */
public class LoginAction1 extends ActionSupport{
	private String username;
	private String password;
	/**
	 * 进行数据校验必须要重写这个方法
	 */
	@Override
	public void validate() {
		//判断用户名不能为空
		if(username==null||username.trim().length()==0) {
			this.addFieldError("username", "用户名不能为空");
		}
		//阻止excute方法执行
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		
		
		return SUCCESS;
	}
}
