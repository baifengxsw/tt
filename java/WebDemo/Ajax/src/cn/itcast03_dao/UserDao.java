package cn.itcast03_dao;

import java.sql.SQLException;

public interface UserDao {
	/**
	 * ���ڼ���û����Ƿ����
	 * @param username
	 * @return
	 */
	boolean checkUserName(String username) throws SQLException;
}
