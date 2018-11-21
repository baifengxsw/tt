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
		//这里只是简化了CRUD的代码 ,但是连接的创建和获取工作,不在考虑范围
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		QueryRunner queryRunner = new QueryRunner(dataSource);
		
		try {
			//queryRunner.update("insert into mount1 values(null,?,?)","wushuang",100);
			//查询单个记录 ,由我们自己用来封装的一个数据
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
		//这里增加删除修改都是差不多  就不演示了
		
		//一共就两种方法 ,一个是查询,一个是更新
//		queryRunner.update(sql)
//		queryRunner.query(sql, rsh)

		
	}
}
