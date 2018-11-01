package cn.itcast_01;
import java.sql.*;
public class Ceshi {
	public static void main(String[] args) {
		//1对驱动管理器进行注册
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			//获取连接
			conn = Utils.getConn();
			//数据库操作必须要这个对象
		    st = conn.createStatement();
			String sql ="select * from Employees";
			//得到结果集
			rs = st.executeQuery(sql);
			//循环结果集
			while(rs.next()) {
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");
				System.out.println("id:"+id+"age:"+age+"first:"+first+"last:"+last);
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			//在这里写一个工具类来进行资源的关闭
			Utils.closeConn(conn);
			Utils.closeRs(rs);
			Utils.closeSt(st);
			
		}
	}
}
