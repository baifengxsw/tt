package cn.itcast_Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;



public class TestPool {
	@Test
	public void testPool(){
		Connection conn = null;
		PreparedStatement ps = null;
		MyDataSource dataSource = null;
		try {
			dataSource = new MyDataSource();
			conn =dataSource.getConnection();
			String sql = "insert into mount1 values(null,'xia',10)";
			ps = conn.prepareStatement(sql);
		    int ret = ps.executeUpdate();
		    System.out.println(ret);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//这里connection不直接关闭 回收该对象
			JDBCUtils.closeSt(ps);
			JDBCUtils.closeConn(conn);
		}
	}
}
