package cn.itcast04_Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast02_dao.JDBCUtils;
import cn.itcast02_dao.UserDao;


public class UserDaoImpl implements UserDao {

	public boolean login(String username,String password) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1��ִ�����ݿ��ѯ
			con =JDBCUtils.getConn();
			String sql = "select * from m_user where username=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			//�ж��������Ƿ�Ϊ��,��¼�Ƿ�Ϊ��
			return rs.next();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConn(con);
			JDBCUtils.closeRs(rs);
			JDBCUtils.closeSt(ps);
		}
		return false;
	}

}
