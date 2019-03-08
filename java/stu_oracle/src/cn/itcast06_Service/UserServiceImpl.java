package cn.itcast06_Service;

import java.sql.SQLException;

import cn.itcast02_Dao.UserDao;
import cn.itcast03_bin.User;
import cn.itcast04_DaoImpl.UserDaoImpl;

public class UserServiceImpl implements UserService {

	public User login(String username, String password) throws SQLException {
		UserDao ud = new UserDaoImpl();
		return ud.login(username, password);
	}

	public boolean checkUserName(String username) throws SQLException {
		UserDao ud = new UserDaoImpl();
		return ud.checkUserName(username);
	}

	public int insert(User user) throws SQLException {
		UserDao ud = new UserDaoImpl();
		return ud.insert(user);
		
	}

}
