package cn.itcast01;

import java.sql.SQLException;

public interface UserDao {
	/**
	 * ���ڼ���û����Ƿ����
	 * @param username
	 * @return
	 */
	boolean checkUserName(String username) throws SQLException;
}
