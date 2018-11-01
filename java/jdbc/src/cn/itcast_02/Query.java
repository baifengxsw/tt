package cn.itcast_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Query {
	
	public static void main(String[] args) {
	
//		Query1();
//		Insert1();
//		delete1();
		update1();
		
	}
	/**
	 * 数据查询
	 */
	
	public static void Query1() {
		//1获取连接对象
		Connection conn = Utils.getConn();
		//2根据连接对象 ,得到 statement
		Statement st = null;
		ResultSet rs = null;
		try {
		st = conn.createStatement();
		String sql = "select * from Employees";
		rs = st.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String first = rs.getString("first");
			String last = rs.getString("last");
			System.out.println("id:"+id+"age:"+age+"first:"+first+"last:"+last);
		}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Utils.closeRs(rs);
			Utils.closeConn(conn);
			Utils.closeSt(st);
		}
		
		
	}
	public static void Insert1() {
		//1获取连接对象
		Connection conn = Utils.getConn();
		//2根据连接对象 ,得到 statement
		Statement st = null;
		try {
		st = conn.createStatement();
		String sql = "insert into Employees values(111,56,'wang','qian')";
		int ret = st.executeUpdate(sql);//执行后返回有几行被改变了
		if(ret>0) {
			System.out.println("添加成功,成功改变了"+ret+"行");
			
		}else {
			System.out.println("添加失败");
		}
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Utils.closeConn(conn);
			Utils.closeSt(st);
		}
		
	}
	public static void delete1() {
		//1获取连接对象
		Connection conn = Utils.getConn();
		//2根据连接对象 ,得到 statement
		Statement st = null;
		try {
		st = conn.createStatement();
		String sql = "delete from Employees where id =111";
		int ret = st.executeUpdate(sql);
		if(ret>0) {
			System.out.println("删除成功,删除了"+ret+"行");
		}else {
			System.out.println("删除失败");
		}
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Utils.closeConn(conn);
			Utils.closeSt(st);
		}
		
	}
	public static void update1() {
		//1获取连接对象
				Connection conn = Utils.getConn();
				//2根据连接对象 ,得到 statement
				Statement st = null;
				try {
				st = conn.createStatement();
				String sql = "update Employees set first ='red' where id=104";
				int ret = st.executeUpdate(sql);
				if(ret>0) {
					System.out.println("修改成功,成功修改了"+ret+"行");
				}else {
					System.out.println("更新失败");
				}
				
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}finally {
					Utils.closeConn(conn);
					Utils.closeSt(st);
				}
				
	}
}
