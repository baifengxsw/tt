package cn.itcast.demo2;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.User;

public class UserAction2 extends ActionSupport{
	//这里提供私有的user对象 ，并且提供get set方法 必须要提供get方法
	private User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
}
