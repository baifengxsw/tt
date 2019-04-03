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
 * hibernate�������ɲ���
 * @author baifeng
 *
 */
public class Demo1 {
	@Test
	//����ͻ�����  ����Ϊcreate  increment����hibernate �ڲ����߳���������
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
	
		customer.setCust_name("wang");
		session.save(customer);
		//6 �����ύ
			transaction.commit();
		//7 �ͷ���Դ
		session.close();
			
	}
	@Test
	//
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
		Customer customer = new Customer();
		
		customer.setCust_name("wang xi");
		session.save(customer);
		//6 �����ύ
		transaction.commit();
		//7 �ͷ���Դ
		session.close();
		
	}
	@Test
	//��ʾ identity
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
		
		customer.setCust_name("wang xi");
		session.save(customer);
		//6 �����ύ
		transaction.commit();
		//7 �ͷ���Դ
		session.close();
		
	}
	@Test
	//��ʾassigned
	public void demo4() {
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
		customer.setCust_id(100l);
		customer.setCust_name("wang xi");
		session.save(customer);
		//6 �����ύ
		transaction.commit();
		//7 �ͷ���Դ
		session.close();
		
	}
	@Test
	//��ʾ�־���ĳ־�̬�Զ���������
	public void demo5() {
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
		customer.setCust_id(2l);
		customer.setCust_name("wang xi");
		session.save(customer);
		customer.setCust_name("wang");
		//6 �����ύ
		transaction.commit();
		//7 �ͷ���Դ
		session.close();
		
	}
	@Test
	//��ʾһ������Ĵ���
	public void demo6() {
		//1 ���غ������� �ļ� 
		Configuration conf = new Configuration().configure();
		//2����SessionFactory ����������JDBC�е����ӳ�
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 ͨ��SessionFactory ��ȡSession ���� ����Connection
		Session  session = sessionFactory.openSession();
		//4�ֶ�������;
		Transaction transaction = session.beginTransaction();
		//5��д����
		Customer customer = session.get(Customer.class, 2l);
		customer.setCust_phone("12313");
		Customer customer1 = session.get(Customer.class, 2L);
		System.out.println(customer);
		System.out.println(customer1);
		System.out.println(customer==customer1);
		//6 �����ύ
		transaction.commit();
		//7 �ͷ���Դ
		session.close();
		
	}
	
}
