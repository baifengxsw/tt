package cn.itcast01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	static ComboPooledDataSource dataSource = null;
	static {
		dataSource=new ComboPooledDataSource();
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
	public static String getHobbies(String [] hobbies){
		StringBuffer str = new StringBuffer();
		for(int i = 0;i<hobbies.length;i++){
			str.append(hobbies[i]).append(" ");
		}
		return str.toString();
	}
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str==null||str.length()==0;
	}
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConn() {
		Connection conn =null;
		try {
			conn = dataSource.getConnection();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeRs(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			rs=null;
			
		}
	}
		public static void closeSt(Statement st) {
			try {
				if(st != null) {
					st.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				st=null;
				
			}
		}
		public static void closeConn(Connection conn) {
			try {
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				conn=null;
				
			}
		}
	}

