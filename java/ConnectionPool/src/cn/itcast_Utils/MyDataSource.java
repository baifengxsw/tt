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
 * ���ݿ����ӳ�
 * һ��ʼ����������10������
 * 1;��ʼ������10������ ,����ά��һ���б� 
 * 2; ���ĳ��� ͨ��getConnection ��ȡ���� 
 * 3; ����ʹ�ý�����������
 * 4; ����
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
	
	//�������ȥ�õ����� 
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		//list.get����������  Ҫά��һ������
		if(list.size()==0){
			//�������û���� ÿ������5��
			for(int i = 0 ;i<5 ;i++){
				Connection conn = JDBCUtils.getConn();
				list.add(conn);
			}
		}
		//��Զ�Ƴ����ϵĵ�һ�� 
		Connection conn = list.remove(0);
		System.out.println("һ�����Ӷ����Ѿ���ʹ��");
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
