package cn.itcast01.demo;



import java.util.Arrays;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itcast02.utils.HibernateUtils;


/**
 * hibernateһ�Զ��ϵ�Ĳ���
 * @author baifeng
 *
 */
public class Demo1 {
	
	@Test
	//����2���ͻ�����3����ϵ��
	public void demo1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//���������ͻ�
		Customer customer1 = new Customer();
		customer1.setCust_name("����");
		Customer customer2 = new Customer();
		customer2.setCust_name("����");
		
		//����3����ϵ��
		LinkMan linkMan1 = new LinkMan();
		linkMan1.setLkm_name("1��");
		LinkMan linkMan2 = new LinkMan();
		linkMan2.setLkm_name("2��");
		LinkMan linkMan3 = new LinkMan();
		linkMan3.setLkm_name("3��");
		
		linkMan1.setCustomer(customer1);
		linkMan2.setCustomer(customer1);
		linkMan3.setCustomer(customer2);
		customer1.getLinkMans().add(linkMan1);
		customer1.getLinkMans().add(linkMan2);
		customer2.getLinkMans().add(linkMan3);
		session.save(linkMan3);
		session.save(linkMan2);
		session.save(linkMan1);
		session.save(customer1);
		session.save(customer2);
		tx.commit();
		session.close();
	}
	
	@Test
	//һ�Զ��ϵ ֻ����һ���Ƿ���� (������)
	public void demo2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//���������ͻ�
		Customer customer1 = new Customer();
		customer1.setCust_name("����");
		Customer customer2 = new Customer();
		customer2.setCust_name("����");
		
		//����3����ϵ��
		LinkMan linkMan1 = new LinkMan();
		linkMan1.setLkm_name("1��");
		LinkMan linkMan2 = new LinkMan();
		linkMan2.setLkm_name("2��");
		LinkMan linkMan3 = new LinkMan();
		linkMan3.setLkm_name("3��");
		
		linkMan1.setCustomer(customer1);
		linkMan2.setCustomer(customer1);
		linkMan3.setCustomer(customer2);
		customer1.getLinkMans().add(linkMan1);
		customer1.getLinkMans().add(linkMan2);
		customer2.getLinkMans().add(linkMan3);
		session.save(linkMan3);
		session.save(linkMan2);
		session.save(linkMan1);
		/*session.save(customer1);
		session.save(customer2);*/
		tx.commit();
		session.close();
	}
	@Test
	//һ�Զ��ϵ ���м��������ı���
	public void demo3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//���������ͻ�
		Customer customer1 = new Customer();
		customer1.setCust_name("����");
		Customer customer2 = new Customer();
		customer2.setCust_name("����");
		
		//����3����ϵ��
		LinkMan linkMan1 = new LinkMan();
		linkMan1.setLkm_name("1��");
		LinkMan linkMan2 = new LinkMan();
		linkMan2.setLkm_name("2��");
		LinkMan linkMan3 = new LinkMan();
		linkMan3.setLkm_name("3��");
		
		linkMan1.setCustomer(customer1);
		linkMan2.setCustomer(customer1);
		linkMan3.setCustomer(customer2);
		customer1.getLinkMans().add(linkMan1);
		customer1.getLinkMans().add(linkMan2);
		customer2.getLinkMans().add(linkMan3);
		session.save(linkMan3);
		session.save(linkMan2);
		session.save(linkMan1);
		/*session.save(customer1);
		session.save(customer2);*/
		tx.commit();
		session.close();
	}
	@Test
	//һ�Զ��ϵ ���м���������ɾ��  �ڿͻ�ӳ���ļ��н�������ca ..  delete
	public void demo4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//���ݿ��Ѿ���֮ǰ�Ĳ����� 
		Customer customer1  = session.get(Customer.class, 1l);
		Customer customer2  = session.get(Customer.class, 2l);
		session.delete(customer1);
		session.delete(customer2);
		tx.commit();
		session.close();
	}
	@Test
	//������ϵ�˶�Ӧ�Ŀͻ�
	public void demo5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//���ݿ��Ѿ���֮ǰ�Ĳ����� 
		Customer customer1  = session.get(Customer.class, 1l);
		
		LinkMan linkMan = session.get(LinkMan.class, 2l);
		
		linkMan.setCustomer(customer1);
		customer1.getLinkMans().add(linkMan);
		tx.commit();
		session.close();
	}
	
}
