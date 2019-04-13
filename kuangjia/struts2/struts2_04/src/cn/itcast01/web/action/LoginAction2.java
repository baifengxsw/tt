package cn.itcast01.web.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 只有继承这个类 ，才会有相应的数据校验，国际化,设置错误信息
 * @author baifeng
 *
 */
public class LoginAction2 extends ActionSupport{
	private String username;
	private String password;
	/**
	 * 进行数据校验必须要重写这个方法
	 */
	

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		System.out.println(username);
		System.out.println(password);
		
		return NONE;
	}
}
