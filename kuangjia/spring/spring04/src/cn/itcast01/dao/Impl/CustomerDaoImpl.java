package cn.itcast01.dao.Impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast01.dao.CustomerDao;
import cn.itcast01.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	
	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
		System.out.println("dao中的save方法执行了");
	}

}
