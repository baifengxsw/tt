package cn.itcast.demo2;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.User;

public class UserAction2 extends ActionSupport{
	//�����ṩ˽�е�user���� �������ṩget set���� ����Ҫ�ṩget����
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
