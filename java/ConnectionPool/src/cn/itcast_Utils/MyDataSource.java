package cn.itcast_Utils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 数据库连接池
 * 一开始向池子里面放10个连接
 * 1;初始化创建10个连接 ,并且维护一个列表 
 * 2; 来的程序 通过getConnection 获取连接 
 * 3; 连接使用结束返回连接
 * 4; 扩容
 * @author baifeng
 *
 */
public class MyDataSource implements DataSource{
	 private List<Connection> list = new ArrayList<>();
	public MyDataSource() {
		for(int i =0;i<10;i++){
			Connection conn = JDBCUtils.getConn();
			list.add(conn);
		}
	}
	
	//这个方法去拿到连接 
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		//list.get方法有问题  要维护一个变量
		if(list.size()==0){
			//如果连接没有了 每次增加5个
			for(int i = 0 ;i<5 ;i++){
				Connection conn = JDBCUtils.getConn();
				list.add(conn);
			}
		}
		//永远移除集合的第一个 
		Connection conn = list.remove(0);
		System.out.println("一个连接对象已经被使用");
		Connection retCon = new ConnectionWrap(conn, list);
		return retCon;
	}
	

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
