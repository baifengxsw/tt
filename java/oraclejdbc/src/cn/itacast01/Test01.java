package cn.itacast01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import oracle.jdbc.driver.OracleTypes;


public class Test01 {
	
	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "select * from test1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String name2 = rs.getString("name2");
				int age = rs.getInt("age");
				System.out.println("name2"+name2+"----"+age);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * ���ǶԴ洢���̽��е���
	 */
	
	public void test02 () {
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement cs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "{call ss1(?,?,?) }";
			cs  = conn.prepareCall(sql);
			cs.setInt(1, 1);
			cs.setInt(2, 7);
			cs.registerOutParameter(3,OracleTypes.NUMBER);
		    cs.execute();
		    System.out.println("ss1�õ��ĽY����"+cs.getInt(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ���ǶԺ����ĵ���
	 */
	@Test
	public void test03 () {
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement cs = null;
		try {
			conn = JDBCUtils.getConn();
			//������Ҫע���{}��
			String sql = " {? = call ss3(?,?)}";
			cs  = conn.prepareCall(sql);
			cs.setInt(2, 14);
			cs.setInt(3, 67);
			cs.registerOutParameter(1,OracleTypes.NUMBER);
			cs.execute();
			System.out.println("ss1�õ��ĽY����"+cs.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
