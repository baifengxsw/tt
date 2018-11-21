package cn.itcast03_c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.itcast02_DBCP.JDBCUtils;

/**
 * 这里是不适用配置文件的方式
 * @author baifeng
 *
 */
public class C3p0Demo2 {
	@Test
	public void textC3p0(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//如果文件名不同 ,直接new这个对象会直接卡主
		try {
			//1.创建datasource  因为可以代码直接加载 项目中的配置文件
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle");
			

			//2得到连接对象
			conn = C3P0Utils.getConn();
			
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

