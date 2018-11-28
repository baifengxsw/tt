package cn.itcast04_Impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast02_Utils.C3P0Utils;
import cn.itcast03_dao.UserDao;

public class UserDaoImpl implements UserDao{

	public boolean checkUserName(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select count(*) from m_user where username = ?";
		Long ret = (Long)runner.query(sql,new ScalarHandler(),username);
		return ret >0;
	}

}
