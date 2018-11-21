package cn.itcast01_ceshi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class TestDemo {
	public static void main(String[] args) {
	   testTransaction2();
	}
	/**
	 * 仅仅作为测试使用
	 */
	public static void testTransaction(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			String sql = "select * from mount1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+"   "+rs.getString("name")+"   "+rs.getInt("money"));
		      }	
			} catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCUtils.closeConn(conn);
				JDBCUtils.closeRs(rs);
				JDBCUtils.closeSt(ps);
			}
			
		
	}
	public static void testTransaction1(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//默认的连接事务是自动提交的 
			conn = JDBCUtils.getConn();
			String sql = "update mount1 set money = money - ? where id = ?";
			
			ps = conn.prepareStatement(sql);
			//扣钱
			ps.setInt(1,100);
			ps.setInt(2, 1);
		
		    ps.executeUpdate(); //这里和执行请求是不一样的 
			int a = 10/0;
			//加钱
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConn(conn);
			JDBCUtils.closeRs(rs);
			JDBCUtils.closeSt(ps);
		}
		
		
	}
	/**
	 * 完全修改版本 
	 */
	public static void testTransaction2(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//默认的连接事务是自动提交的 
			
			conn = JDBCUtils.getConn();
			conn.setAutoCommit(false);
			String sql = "update mount1 set money = money - ? where id = ?";
			
			ps = conn.prepareStatement(sql);
			//扣钱
			ps.setInt(1,100);
			ps.setInt(2, 1);
			
			ps.executeUpdate(); //这里和执行请求是不一样的 
			int a = 10/0;
			//加钱
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
			
			//如果上方的代码 没有问题的话在这里进行事务的提交 
			conn.commit();
		} catch(Exception e){
			//如果上方代码失败 ,进行任务的回滚操作 
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConn(conn);
			JDBCUtils.closeRs(rs);
			JDBCUtils.closeSt(ps);
		}
		
		
	}
}
