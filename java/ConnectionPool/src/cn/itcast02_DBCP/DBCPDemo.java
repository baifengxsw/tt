package cn.itcast02_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;


/**
 * ���DBCP�����õĺ��� 
 * @author baifeng
 *
 */


public class DBCPDemo {
	public static void main(String[] args) {
		testDBCP();
	}
	@Test
	public static void testDBCP(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1��������Դ����
			BasicDataSource dataSource = new BasicDataSource();
			//���ݿ���ز������� 
			dataSource.setUsername("root");
			dataSource.setPassword("123321");
			dataSource.setUrl("jdbc:mysql://localhost:3306/bank?useUnicode="
					+ "true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
			
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			//2�õ����Ӷ���
			conn = dataSource.getConnection();
			
			String sql = "select * from mount1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+"   "+rs.getString("name")+"   "+rs.getString("money"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//���ﲢ������Ĺر�  ��һ����װ�����ڲ�
			JDBCUtils.closeConn(conn);
			JDBCUtils.closeRs(rs);
			JDBCUtils.closeSt(ps);
		}
		
	}
}
