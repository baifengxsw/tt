package cn.itcast.dao.Impl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> find() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> list = session.createQuery("from Customer").list();
		tx.commit();
		return list;
	}

	@Override
	public void save(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		
	}

}
