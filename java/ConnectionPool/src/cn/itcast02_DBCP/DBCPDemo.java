package cn.itcast02_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;


/**
 * 这个DBCP整体用的很少 
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
			//1构建数据源对象
			BasicDataSource dataSource = new BasicDataSource();
			//数据库相关操作设置 
			dataSource.setUsername("root");
			dataSource.setPassword("123321");
			dataSource.setUrl("jdbc:mysql://localhost:3306/bank?useUnicode="
					+ "true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
			
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			//2得到连接对象
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
			//这里并不是真的关闭  有一个包装类在内部
			JDBCUtils.closeConn(conn);
			JDBCUtils.closeRs(rs);
			JDBCUtils.closeSt(ps);
		}
		
	}
}
