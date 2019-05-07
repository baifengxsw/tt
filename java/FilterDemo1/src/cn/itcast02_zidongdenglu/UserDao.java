package cn.itcast02_zidongdenglu;

import java.sql.SQLException;

/**
 * 定义用户的操作
 * 
 */
public interface UserDao {
	/**
	 * 判断登录是否成功 在实际的开发过程中 登录成功通常返回用户的信息
	 * @param username
	 * @param password
	 * @return
	 */
	 User login(User user) throws SQLException;
}
