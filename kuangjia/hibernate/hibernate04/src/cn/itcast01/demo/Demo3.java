package cn.itcast01.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast02.utils.HibernateUtils;

//HQL ����ѯ
public class Demo3 {
	@Test
	//�����Ӳ�ѯ
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//���������Ӳ�ѯ  //linkMans ��customer ���ж�LinkMan �ļ���
		/*Query query   = session.createQuery("from Customer c inner join c.linkMans");
		List<Customer> list = query.list();
		for(Customer obj:list) {
			System.out.println(obj);
		}
		*/
		//��������ʾ����������
		Query query = session.createQuery("select distinct c from Customer c inner join fetch c.linkMans");
		List<Customer> list = query.list();
		for(Customer customer :list) {
			System.out.println(customer );
		}
		tx.commit();
		//����Ҫclose
	}
	@Test
	//SQL ��ѯ
	public void demo7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//��ÿ�����Եķ�װ
	/*	SQLQuery sqlQuery = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list = sqlQuery.list();
		for(Object[] obj : list) {
			System.out.println(obj[1]);
		}*/
		//�����Ƿ�װ��������
		SQLQuery sqlQuery = session.createSQLQuery("select * from cst_customer");
		sqlQuery.addEntity(Customer.class);
		List<Customer> list = sqlQuery.list();
		for(Customer customer: list) {
			System.out.println(customer);
		}
		tx.commit();
		//����Ҫclose
	}
	
	@Test
	//�ӳ� ����
	public void demo8() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.load(Customer.class, 1l);
		System.out.println(customer);
		tx.commit();
		//����Ҫclose
	}
	
}
