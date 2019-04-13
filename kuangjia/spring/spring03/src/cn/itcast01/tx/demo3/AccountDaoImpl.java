package cn.itcast01.tx.demo3;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 转账的dao的实现类
 * @author baifeng
 *
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao  {


	@Override
	public void outMoney(String from, Double money) {
		String sql = "update account set money = money-? where name=?";
		this.getJdbcTemplate().update(sql,money,from);

	}

	@Override
	public void inMoney(String in, Double money) {
		String sql = "update account set money = money+? where name=?";
		this.getJdbcTemplate().update(sql,money,in);
		
	}

}
