package cn.itcast05_commoncrud;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CommonUtil {
	
	public static void main(String[] args) {
		String sql= "insert into mount1 values(null,?,?) ";
		//update(sql,"xiashuangwu",100000);
		String sql2 = "select * from mount1 where id = ?";
//		testQuery(sql2,new ResultSetHandler<Account>() {
//			
//			@Override
//			public void handle(ResultSet rs) {
//				// TODO Auto-generated method stub
//				try {
//					while(rs.next()){
//						System.out.println(rs.getInt("id")+"  "+rs.getString("name")+"  "+rs.getInt("money"));
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		},8);
		
		 Account account = new CommonUtil().testQuery(sql2, new ResultSetHandlerimpl(), 8);
		 System.out.println(account);
	}
	/**
	 * 增删改查
	 * @param sql  操作的sql语句
	 * @param args 可变参数 是占位符
	 */
	public  static void update(String sql ,Object ...args){
		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			//对可变参数args 进行遍历
			for(int i = 0 ;i<args.length;i++){
				ps.setObject(i+1, args[i]);
			}
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConn(conn);
			JDBCUtils.closeSt(ps);
		}
	}
	/**
	 * 以问号个数为准
	 * @param sql
	 * @param args
	 */
	public  static void update2(String sql ,Object ...args){
		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			//拿到元参数数据
			ParameterMetaData metaData = ps.getParameterMetaData();
			int count = metaData.getParameterCount();
			//对可变参数args 进行遍历
			if(count>args.length)
				return ;
			for(int i = 0 ;i<count;i++){
				ps.setObject(i+1, args[i]);
			}
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConn(conn);
			JDBCUtils.closeSt(ps);
		}
	}
	public   <T> T testQuery(String sql ,ResultSetHandler<T> handler, Object ...args){
		
		Connection conn = null ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ParameterMetaData metaData = ps.getParameterMetaData();
			int count =  metaData.getParameterCount();
			if(count > args.length)
				return null;
				
			for(int i =0 ;i<count;i++){
				ps.setObject(i+1, args[i]);
			}
			rs = ps.executeQuery();
			//將結果集進行封裝
			//让用的人传进来 ,然后传出去什么形式
			T  t= (T) handler.handle(rs);
			return t ;
//			while (rs.next()){
//				System.out.println(rs.getInt("id")+"  "+rs.getString("name")+"  "+rs.getInt("money"));
//				
//			}
			//在这里参数应该是不同的  ,传入一个外部的对象 .用来 返回结果  ,让调用者自己去处理
		}catch( Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConn(conn);
			JDBCUtils.closeRs(rs);
			JDBCUtils.closeSt(ps);
			}
		return null;
		
	}
}
