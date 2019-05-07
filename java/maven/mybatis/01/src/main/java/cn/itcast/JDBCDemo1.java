package cn.itcast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * 进行jdbc的测试
 * @author baifeng
 *
 */
public class JDBCDemo1 {
	public static void main(String[] args) {
		Connection conn  = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		//加载数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//通过驱动管理类获取连接
			conn = DriverManager.getConnection("jdbc:mysql:///mybatis?characterEncoding-utf-8","root"	, "123321");
			//定义sql 语句? 表示占位符
			String sql = "select * from user where username=?";
			//获取预处理statement
			ps = conn.prepareStatement(sql);
			//设置参数，第一个参数是从1 开始
			ps.setString(1, "王五");
			resultSet = ps.executeQuery();

			while(resultSet.next()) {
				System.out.println(resultSet.getString("id")+"----"+resultSet.getString("username"));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
