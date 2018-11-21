package cn.itcast01_ceshi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class TestDemo {
	public void testTransaction(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			String sql = "select * from mount";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id"+"   "+rs.getString("name")+"   "+rs.getInt("money")));
		      }	
			} catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCUtils.closeConn(conn);
				JDBCUtils.closeRs(rs);
				JDBCUtils.closeSt(ps);
			}
			
		
	}
}
