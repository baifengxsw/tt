package cn.itcast02_Dao;

import java.sql.SQLException;

import cn.itcast03_bin.User;

public interface UserDao {
  /**
   * 这里简单返回boolean类型 ,成功或者失败 即可,正常登录成功就返回用户所有信息 
   *@return 用户信息 登录成功  false 登录失败
 * @throws SQLException 
   */
		User login(String username, String password) throws SQLException;
	/**
	 * 用于检测用户名是否存在
	 * @param username
	 * @return
	 */
	boolean checkUserName(String username) throws SQLException;
	/**
	 * 插入一个管理员用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int insert(User user) throws SQLException;
}
