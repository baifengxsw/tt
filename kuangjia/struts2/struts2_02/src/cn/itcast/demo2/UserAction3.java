package cn.itcast.demo2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;

public class UserAction3 extends ActionSupport implements ModelDriven<User>{
	//需要手动实列化这个User
	private User user = new User();

	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}

	@Override
	public User getModel() {
		// TODO 自动生成的方法存根
		return user;
	}
}
