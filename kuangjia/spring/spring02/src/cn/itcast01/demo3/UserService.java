package cn.itcast01.demo3;

import javax.annotation.Resource;

public class UserService {
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="orderDao")
	private OrderDao orderDao;
	

	public void save() {
		System.out.println("userService 中的方法被执行了");
		userDao.save();
		orderDao.save();
	}
}
