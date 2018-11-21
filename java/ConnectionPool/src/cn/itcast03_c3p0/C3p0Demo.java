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
 * �����ǲ����������ļ��ķ�ʽ
 * @author baifeng
 *
 */
public class C3p0Demo {
	@Test
	public void textC3p0(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1.����datasource
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			
			//���ݿ���ز������� 
			dataSource.setUser("root");
			dataSource.setPassword("123321");
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
			//2�õ����Ӷ���
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
			//���ﲢ������Ĺر�  ��һ����װ�����ڲ�
			JDBCUtils.closeConn(conn);
			JDBCUtils.closeRs(rs);
			JDBCUtils.closeSt(ps);
		}
		
	}
	}

