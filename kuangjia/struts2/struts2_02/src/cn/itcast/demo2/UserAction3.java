package cn.itcast.demo2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;

public class UserAction3 extends ActionSupport implements ModelDriven<User>{
	//��Ҫ�ֶ�ʵ�л����User
	private User user = new User();

	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}

	@Override
	public User getModel() {
		// TODO �Զ����ɵķ������
		return user;
	}
}
