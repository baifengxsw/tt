package cn.itcast02_DBCP;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;


/**
 * 这个DBCP整体用的很少 
 * @author baifeng
 *
 */


public class DBCPDemo2 {
	public static void main(String[] args) {
		testDBCP();
	}
	@Test
	public static void testDBCP(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream is = null;
		try {
			//数据库相关操作设置 
			Properties pro = new Properties();
			is = new FileInputStream("src\\dbcpconfig.properties");
			pro.load(is);
			new BasicDataSourceFactory();
			DataSource dataSource = BasicDataSourceFactory.createDataSource(pro);
			//2得到连接对象
			conn = dataSource.getConnection();
			
			String sql = "select * from mount1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+"   "+rs.getString("name")+"   "+rs.getString("money"));
				
			}
			
		} catch (Exception e) {
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
