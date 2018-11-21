package cn.itcast04_DBUtils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestUtils {
	@Test
	public void testInsert(){
		//����ֻ�Ǽ���CRUD�Ĵ��� ,�������ӵĴ����ͻ�ȡ����,���ڿ��Ƿ�Χ
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		QueryRunner queryRunner = new QueryRunner(dataSource);
		
		try {
			//queryRunner.update("insert into mount1 values(null,?,?)","wushuang",100);
			//��ѯ������¼ ,�������Լ�������װ��һ������
//			Account accout = queryRunner.query("select * from mount1 where id =?",new ResultSetHandler<Account>() {
//
//				@Override
//				public Account handle(ResultSet rs) throws SQLException {
//					// TODO Auto-generated method stub
//					Account accout = new Account();
//					while(rs.next()){
//						accout.setId(rs.getInt("id"));
//						accout.setName(rs.getString("name"));
//						accout.setMoney(rs.getInt("money"));
//					}
//					return accout;
//				}
//				
//			},2);
//			
//			System.out.println(accout.toString());
			//***********************************************************************************
//			Account account = queryRunner.query("select * from mount1 where id = ?",new BeanHandler<Account>(Account.class),2);
//			System.out.println(account);
			List<Account> accounts = queryRunner.query("select * from mount1 ",new BeanListHandler<Account>(Account.class));
			for(Account account: accounts){
				System.out.println(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��������ɾ���޸Ķ��ǲ��  �Ͳ���ʾ��
		
		//һ�������ַ��� ,һ���ǲ�ѯ,һ���Ǹ���
//		queryRunner.update(sql)
//		queryRunner.query(sql, rsh)

		
	}
}
