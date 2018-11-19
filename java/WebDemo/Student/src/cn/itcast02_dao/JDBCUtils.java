package cn.itcast02_dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
	static String driverclass = null;
	static String URL = null;
	static String USER = null;
	static String PASS = null;
	static {
		//类加载就开始运行
		Properties pro = new Properties();
		try {
			//当类加载的时候将资源也进行一同的加载
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("objc.ini");
			pro.load( is);
			driverclass = pro.getProperty("driverclass");
			URL = pro.getProperty("URL");
			USER = pro.getProperty("USER");
			PASS = pro.getProperty("PASS");
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public static Connection getConn( ) {
		//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 //在这里不注册也可以
	//2访问数据库要先建立连接 协议 加访问的数据库
		Connection conn = null;
	    try {
	    	Class.forName(driverclass);
			conn = DriverManager.getConnection(URL, USER,PASS);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
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

