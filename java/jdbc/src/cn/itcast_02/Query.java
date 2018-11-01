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
	 * ���ݲ�ѯ
	 */
	
	public static void Query1() {
		//1��ȡ���Ӷ���
		Connection conn = Utils.getConn();
		//2�������Ӷ��� ,�õ� statement
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			Utils.closeRs(rs);
			Utils.closeConn(conn);
			Utils.closeSt(st);
		}
		
		
	}
	public static void Insert1() {
		//1��ȡ���Ӷ���
		Connection conn = Utils.getConn();
		//2�������Ӷ��� ,�õ� statement
		Statement st = null;
		try {
		st = conn.createStatement();
		String sql = "insert into Employees values(111,56,'wang','qian')";
		int ret = st.executeUpdate(sql);//ִ�к󷵻��м��б��ı���
		if(ret>0) {
			System.out.println("��ӳɹ�,�ɹ��ı���"+ret+"��");
			
		}else {
			System.out.println("���ʧ��");
		}
		
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			Utils.closeConn(conn);
			Utils.closeSt(st);
		}
		
	}
	public static void delete1() {
		//1��ȡ���Ӷ���
		Connection conn = Utils.getConn();
		//2�������Ӷ��� ,�õ� statement
		Statement st = null;
		try {
		st = conn.createStatement();
		String sql = "delete from Employees where id =111";
		int ret = st.executeUpdate(sql);
		if(ret>0) {
			System.out.println("ɾ���ɹ�,ɾ����"+ret+"��");
		}else {
			System.out.println("ɾ��ʧ��");
		}
		
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			Utils.closeConn(conn);
			Utils.closeSt(st);
		}
		
	}
	public static void update1() {
		//1��ȡ���Ӷ���
				Connection conn = Utils.getConn();
				//2�������Ӷ��� ,�õ� statement
				Statement st = null;
				try {
				st = conn.createStatement();
				String sql = "update Employees set first ='red' where id=104";
				int ret = st.executeUpdate(sql);
				if(ret>0) {
					System.out.println("�޸ĳɹ�,�ɹ��޸���"+ret+"��");
				}else {
					System.out.println("����ʧ��");
				}
				
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}finally {
					Utils.closeConn(conn);
					Utils.closeSt(st);
				}
				
	}
}
