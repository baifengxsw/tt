package cn.itcast_01;
import java.sql.*;
public class Ceshi {
	public static void main(String[] args) {
		//1����������������ע��
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			//��ȡ����
			conn = Utils.getConn();
			//���ݿ��������Ҫ�������
		    st = conn.createStatement();
			String sql ="select * from Employees";
			//�õ������
			rs = st.executeQuery(sql);
			//ѭ�������
			while(rs.next()) {
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");
				System.out.println("id:"+id+"age:"+age+"first:"+first+"last:"+last);
			}
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			//������дһ����������������Դ�Ĺر�
			Utils.closeConn(conn);
			Utils.closeRs(rs);
			Utils.closeSt(st);
			
		}
	}
}
