package cn.itcast01.demo;



import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * hibernate ����
 * @author baifeng
 *
 */
public class Demo1 {
	@Test
	//����ͻ�����
	public void demo1() {
		//1 ���غ������� �ļ� 
		Configuration conf = new Configuration().configure();
		//2����SessionFactory ����������JDBC�е����ӳ�
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 ͨ��SessionFactory ��ȡSession ���� ����Connection
		Session  session = sessionFactory.openSession();
		//4�ֶ�������;
		Transaction transaction = session.beginTransaction();
		//5��д����
		Customer customer = new Customer();
		customer.setCust_id(1233);
		customer.setCust_name("wang");
		session.save(customer);
		//6 �����ύ
			transaction.commit();
		//7 �ͷ���Դ
		session.close();
			
	}
	@Test
	public void demo2() {
		//1 ���غ������� �ļ� 
		Configuration conf = new Configuration().configure();
		//2����SessionFactory ����������JDBC�е����ӳ�
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 ͨ��SessionFactory ��ȡSession ���� ����Connection
		Session  session = sessionFactory.openSession();
		//4�ֶ�������;
		Transaction transaction = session.beginTransaction();
		//5��д����
		Customer ret = session.get(Customer.class, 1l);
		System.out.println(ret);
		
		//6 �����ύ
			transaction.commit();
		//7 �ͷ���Դ
			
	}
	//saveorupdate ����
	@Test
	public void demo3() {
		//1 ���غ������� �ļ� 
		Configuration conf = new Configuration().configure();
		//2����SessionFactory ����������JDBC�е����ӳ�
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 ͨ��SessionFactory ��ȡSession ���� ����Connection
		Session  session = sessionFactory.openSession();
		//4�ֶ�������;
		Transaction transaction = session.beginTransaction();
		//5��д����
		Customer customer = new Customer();
		
		customer.setCust_name("xia");
		session.saveOrUpdate(customer);
		
		//6 �����ύ
			transaction.commit();
		//7 �ͷ���Դ
			
	}
	//��ѯ��������
	@Test
	public void demo4() {
		//1 ���غ������� �ļ� 
		Configuration conf = new Configuration().configure();
		//2����SessionFactory ����������JDBC�е����ӳ�
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 ͨ��SessionFactory ��ȡSession ���� ����Connection
		Session  session = sessionFactory.openSession();
		//4�ֶ�������;
		Transaction transaction = session.beginTransaction();
		//5��д���� �������de hql
		/*
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for(Customer customer:list) {
			System.out.println(customer);
		}*/
		SQLQuery query = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list = query.list();
		for(Object[] objects:list) {
			System.out.println(Arrays.toString(objects));
		}
		
		//6 �����ύ
			transaction.commit();
		//7 �ͷ���Դ
			session.close();
			
	}
}
