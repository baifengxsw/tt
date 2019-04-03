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
 * QBC��ѯ
 * @author baifeng
 *
 */
public class Demo2 {
	@Test
	//�򵥲�ѯ
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		//list ��uniqueresult  �������ǳ�����
		List<Customer> list = criteria.list();
		for(Customer customer :list) {
			System.out.println(customer);
		}
		
		tx.commit();
		//����Ҫclose
	}
	@Test
	//�����ѯ
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
		//����Ҫclose
	}
	@Test
	//��ҳ��ѯ
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
		//����Ҫclose
	}
	
	@Test
	//������ѯ
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		//�������� 
		criteria.add(Restrictions.eq("cust_name","wu"));
		List<Customer> list = criteria.list();
		for(Customer customer:list) {
			System.out.println(customer);
		}
		
		tx.commit();
		//����Ҫclose
	}
	
	@Test
	//ͳ�Ʋ�ѯ
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		
		
		tx.commit();
		//����Ҫclose
	}
	@Test
	//����������ѯ
	public void demo6() {
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.like("cust_name", "%wu%"));
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//����õ�session  �͵�ǰ������criteria ���й���
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		List<Customer> list = criteria.list();
		for(Customer customer :list) {
			System.out.println(customer);
		}
		
		
		tx.commit();
		//����Ҫclose
	}
	
}
