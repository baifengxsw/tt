package cn.itcast04_DaoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast02_Dao.UserDao;
import cn.itcast03_bin.User;
import cn.itcast05_Utils.C3P0Utils;


public class UserDaoImpl implements UserDao{

	public User login(String username, String password) throws SQLException {
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
			
			String sql = "select * from m_user where username=? and passwordl=?";
			return  (User)runner.query( sql, new BeanHandler<User>(User.class),username ,password );
	
		}

	public boolean checkUserName(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select count(*) from m_user where username = ?";
		Object ret = runner.query(sql,new ScalarHandler(),username);
		return Long.parseLong(ret.toString())>0;
	}

	public int insert(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into m_user values(?,?)";
		int ret = runner.update(sql, user.getUsername(),user.getPassword1());
		return ret ;
		
	}
		
	}

	
	

