package cn.itcast.store.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	/**
	 * 浠庣嚎绋嬩腑鑾峰彇杩炴帴
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		//浠庣嚎绋嬩腑鑾峰彇conneciton
		Connection conn = tl.get();
		if(conn==null){
			conn=ds.getConnection();
			//鍜屽綋鍓嶇嚎绋嬬粦瀹�
			tl.set(conn);
		}
		return conn;
	}

	// 鑾峰彇鏁版嵁婧�
	public static DataSource getDataSource() {
		return ds;
	}

	// 閲婃斁璧勬簮
	public static void closeResource( Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
	}
	
	// 閲婃斁璧勬簮
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResource(st, rs);
		closeConn(conn);
	}

	// 閲婃斁 connection
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				//鍜岀嚎绋嬭В缁�
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	// 閲婃斁 statement ctrl + shift + f 鏍煎紡鍖栦唬鐮�
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}
	}

	// 閲婃斁缁撴灉闆�
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
	
	
	//寮�鍚簨鍔�
	public static void startTransaction() throws SQLException{
		getConnection().setAutoCommit(false);
	}
	
	/**
	 * 浜嬪姟鎻愪氦涓旈噴鏀捐繛鎺�
	 */
	public static void commitAndClose(){
		Connection conn = null;
		try {
			conn=getConnection();
			//浜嬪姟鎻愪氦
			conn.commit();
			//鍏抽棴璧勬簮
			conn.close();
			//瑙ｉ櫎鐗堝畾
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 浜嬪姟鍥炴粴涓旈噴鏀捐祫婧�
	 */
	public static void rollbackAndClose(){
		Connection conn = null;
		try {
			conn=getConnection();
			//浜嬪姟鍥炴粴
			conn.rollback();
			//鍏抽棴璧勬簮
			conn.close();
			//瑙ｉ櫎鐗堝畾
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
