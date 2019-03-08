package cn.itcast.store.service.serviceImpl;

import java.sql.SQLException;

import cn.itcast.store.dao.UserDao;
import cn.itcast.store.dao.DaoImpl.UserDaoImpl;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.UserService;

public class UserServiceImpl implements UserService {

	public void userRegist(User user) throws SQLException {
		UserDao ud = new UserDaoImpl();
		ud.userRegist(user);
		
	}

}
