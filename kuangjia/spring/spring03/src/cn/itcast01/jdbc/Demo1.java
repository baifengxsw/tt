package cn.itcast01.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JDBC模板的使用
 * @author baifeng
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo1 {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Test
	public void demo1() {
		String sql = "insert into account values(null,?,?)";
		jdbcTemplate.update(sql,"xia",3000d);
		
	}
	@Test
	public void demo2() {
		String sql = "select name from account where id= ?";
		String name = jdbcTemplate.queryForObject(sql, String.class,1);
		System.out.println(name);
		
	}
	@Test
	public void demo3() {
		String sql = "select count(*) from account";
		Long count = jdbcTemplate.queryForObject(sql,Long.class);
		System.out.println(count);
		
	}
	@Test
	public void demo4() {
		String sql = "select * from account where id =?";
		Account account = jdbcTemplate.queryForObject(sql, new MyRowMapper(), 1);
		System.out.println(account);
		
	}
	public class MyRowMapper implements RowMapper<Account>{

		@Override
		public Account mapRow(ResultSet result, int row) throws SQLException {
			Account account = new Account();
			account.setId(result.getInt("id"));
			account.setName(result.getString("name"));
			account.setMoney(result.getDouble("money"));
			return account;
		}
		
	}
}
