package cn.itcast01.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.ordering.antlr.OrderByFragmentRenderer;
import org.junit.Test;

import cn.itcast02.utils.HibernateUtils;

/**
 * QBC查询
 * @author baifeng
 *
 */
public class Demo2 {
	@Test
	//简单查询
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		//list 和uniqueresult  两个都非常常用
		List<Customer> list = criteria.list();
		for(Customer customer :list) {
			System.out.println(customer);
		}
		
		tx.commit();
		//不需要close
	}
	@Test
	//排序查询
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.addOrder(Order.desc("cust_name"));
		List<Customer> list = criteria.list();
		for(Customer customer:list) {
			System.out.println(customer);
		}
		
		tx.commit();
		//不需要close
	}
	@Test
	//分页查询
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(2);
		List<Customer > list =criteria.list();
		for(Customer customer :list) {
			System.out.println(customer);
		}
		
		tx.commit();
		//不需要close
	}
	
	@Test
	//条件查询
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		//设置条件 
		criteria.add(Restrictions.eq("cust_name","wu"));
		List<Customer> list = criteria.list();
		for(Customer customer:list) {
			System.out.println(customer);
		}
		
		tx.commit();
		//不需要close
	}
	
	@Test
	//统计查询
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		
		
		tx.commit();
		//不需要close
	}
	@Test
	//离线条件查询
	public void demo6() {
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.like("cust_name", "%wu%"));
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//这里得到session  和当前的离线criteria 进行关联
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		List<Customer> list = criteria.list();
		for(Customer customer :list) {
			System.out.println(customer);
		}
		
		
		tx.commit();
		//不需要close
	}
	
}
