package cn.itcast01.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast01.dao.CustomerDao;
import cn.itcast01.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	
	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
		System.out.println("dao中的save方法执行了");
	}

	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	@Override
	public Customer findById(Long cust_id) {
		return this.getHibernateTemplate().get(Customer.class, cust_id);
	}

	

	@Override
	public List<Customer> findAllByHQL() {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
		
	}

	@Override
	public List<Customer> findAllByQBC() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
	}

}
