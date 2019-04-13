package cn.itcast01.demo1;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")//相当于<bean id ="userService" class="">
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;
	@Override
	public void save() {
		System.out.println("userServiceImpl中的save方法被调用了");
		userDao.save();

	}

}
