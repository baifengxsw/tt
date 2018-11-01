package cn.itcast_03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class TestDaoImpl implements TestDao {

	@Override
	public void findALL() {
		// TODO 自动生成的方法存根
		Connection conn = null;
		Statement st  = null;
		ResultSet rs = null;
		try {
			conn = Utils.getConn();
			
			st = conn.createStatement();
			st.execute("use test");  //调整到数据库
			String sql = "select * from books";
		    rs  = st.executeQuery(sql);
		    while(rs.next()) {
		    	int b_id = rs.getInt("b_id");
		    	int b_copies = rs.getInt("b_copies");
		    	int b_storage = rs.getInt("b_storage");
		    	System.out.println("b_id:"+b_id+"b_copies:"+b_copies+"b_storage:"+b_storage);
		    }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Utils.closeConn(conn);
			Utils.closeRs(rs);
			Utils.closeSt(st);
		}
		
	}

	@Override
	public void login() {
		// TODO 自动生成的方法存根
		Connection conn = null;
		Statement st  = null;
		ResultSet rs = null;
		try {
			conn = Utils.getConn();
			
			st = conn.createStatement();
			st.execute("use test");  //调整到数据库
			String sql = "select * from users where user='xia' and password='123' or '1=1'";
		    rs  = st.executeQuery(sql);
		    if(rs.next()) {
		    	String user = rs.getString("user");
		    	String password = rs.getString("password");
		    	System.out.println("user:"+user+"password:"+password);
		    }else {
		    	System.out.println("登陆失败");
		    }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Utils.closeConn(conn);
			Utils.closeRs(rs);
			Utils.closeSt(st);
		}
	}

	/**
	 * 采用预编译statement
	 */
	@Override
	public void login2(String user ,String password) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		Statement st  = null;
		ResultSet rs = null;
		PreparedStatement ps =null;
		try {
			conn = Utils.getConn();
			//先进行预处理 ,如果等会传进来就直接当做字符串,再也不是关键字了
			String sql = "select * from users where user=? and password=?";
			ps = conn.prepareStatement(sql);
			//对于问号的处理
			ps.setString(1, user);
			ps.setString(2, password);
			ps.execute("use test");  //调整到数据库
		    String sql2 = "select * from users where user='xia' and password='123'";
		    
		    rs  = ps.executeQuery();
		    if(rs.next()) {
		    	System.out.println("登陆成功");
		    	String user1 = rs.getString("user");
		    	String password1 = rs.getString("password");
		    	System.out.println("user:"+user1+"password:"+password1);
		    }else {
		    	System.out.println("登陆失败");
		    }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Utils.closeConn(conn);
			Utils.closeRs(rs);
			Utils.closeSt(st);
		}
	}

	@Override
	public void insert(String user, String password) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn=Utils.getConn(); //作为提交数据 ,而不会作为sql语句
		String sql = "insert into books values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1005);
			ps.setInt(2, 4);
			ps.setInt(3, 5);
			int ret = ps.executeUpdate();
			if(ret>0) {
				System.out.println("插入成功");
				
			}else {
				System.out.println("插入失败");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Utils.closeConn(conn);
			Utils.closeRs(rs);
			Utils.closeSt(ps);
		}
		
		
	}

	

}
