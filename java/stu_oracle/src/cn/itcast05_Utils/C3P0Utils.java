package cn.itcast05_Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;

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
	/**
	 * 字符串转Date
	 * @param ss
	 * @return
	 */
	public static Date getDate( String ss) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		try {
			return (Date) sdf.parse(ss);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * Date 转String
	 * @param date
	 * @return
	 */
	public static String getDateString( Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		return  sdf.format(date);

		
	}
	public static Cookie getCookie (Cookie [] cookies ,String c) {
		if (cookies == null)
			return null;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(c)) {
				return cookie;
			}
		}
		return null;
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

