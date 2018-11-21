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
	 * ������Ϊ����ʹ��
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
			//Ĭ�ϵ������������Զ��ύ�� 
			conn = JDBCUtils.getConn();
			String sql = "update mount1 set money = money - ? where id = ?";
			
			ps = conn.prepareStatement(sql);
			//��Ǯ
			ps.setInt(1,100);
			ps.setInt(2, 1);
		
		    ps.executeUpdate(); //�����ִ�������ǲ�һ���� 
			int a = 10/0;
			//��Ǯ
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
	 * ��ȫ�޸İ汾 
	 */
	public static void testTransaction2(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//Ĭ�ϵ������������Զ��ύ�� 
			
			conn = JDBCUtils.getConn();
			conn.setAutoCommit(false);
			String sql = "update mount1 set money = money - ? where id = ?";
			
			ps = conn.prepareStatement(sql);
			//��Ǯ
			ps.setInt(1,100);
			ps.setInt(2, 1);
			
			ps.executeUpdate(); //�����ִ�������ǲ�һ���� 
			int a = 10/0;
			//��Ǯ
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
			
			//����Ϸ��Ĵ��� û������Ļ����������������ύ 
			conn.commit();
		} catch(Exception e){
			//����Ϸ�����ʧ�� ,��������Ļع����� 
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
