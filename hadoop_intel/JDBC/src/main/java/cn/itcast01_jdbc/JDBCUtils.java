package cn.itcast01_jdbc;

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
		//����ؾͿ�ʼ����
		Properties pro = new Properties();
		try {
			//������ص�ʱ����ԴҲ����һͬ�ļ���
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("objc.ini");
			pro.load( is);
			driverclass = pro.getProperty("driverclass");
			URL = pro.getProperty("URL");
			USER = pro.getProperty("USER");
			PASS = pro.getProperty("PASS");
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	public static Connection getConn( ) {
		//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 //�����ﲻע��Ҳ����
	//2�������ݿ�Ҫ�Ƚ������� Э�� �ӷ��ʵ����ݿ�
		Connection conn = null;
	    try {
	    	Class.forName(driverclass);
			conn = DriverManager.getConnection(URL, USER,PASS);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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

