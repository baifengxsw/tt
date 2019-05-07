package cn.itcast02_zidongdenglu;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class UserDaoImpl implements UserDao {

	public User login(User user) throws SQLException {
		
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
			String sql = "select * from m_user where username = ? and password = ?";

			return runner.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPassword());
			

		
	}



}
