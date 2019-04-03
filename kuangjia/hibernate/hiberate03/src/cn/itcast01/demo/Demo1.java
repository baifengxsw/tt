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
 * hibernate一对多关系的测试
 * @author baifeng
 *
 */
public class Demo1 {
	
	@Test
	//保存2个客户，和3个联系人
	public void demo1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建两个客户
		Customer customer1 = new Customer();
		customer1.setCust_name("王东");
		Customer customer2 = new Customer();
		customer2.setCust_name("王西");
		
		//创建3个联系人
		LinkMan linkMan1 = new LinkMan();
		linkMan1.setLkm_name("1号");
		LinkMan linkMan2 = new LinkMan();
		linkMan2.setLkm_name("2号");
		LinkMan linkMan3 = new LinkMan();
		linkMan3.setLkm_name("3号");
		
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
	//一对多关系 只保存一边是否可以 (不可以)
	public void demo2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建两个客户
		Customer customer1 = new Customer();
		customer1.setCust_name("王东");
		Customer customer2 = new Customer();
		customer2.setCust_name("王西");
		
		//创建3个联系人
		LinkMan linkMan1 = new LinkMan();
		linkMan1.setLkm_name("1号");
		LinkMan linkMan2 = new LinkMan();
		linkMan2.setLkm_name("2号");
		LinkMan linkMan3 = new LinkMan();
		linkMan3.setLkm_name("3号");
		
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
	//一对多关系 进行级联操作的保存
	public void demo3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建两个客户
		Customer customer1 = new Customer();
		customer1.setCust_name("王东");
		Customer customer2 = new Customer();
		customer2.setCust_name("王西");
		
		//创建3个联系人
		LinkMan linkMan1 = new LinkMan();
		linkMan1.setLkm_name("1号");
		LinkMan linkMan2 = new LinkMan();
		linkMan2.setLkm_name("2号");
		LinkMan linkMan3 = new LinkMan();
		linkMan3.setLkm_name("3号");
		
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
	//一对多关系 进行级联操作的删除  在客户映射文件中进行配置ca ..  delete
	public void demo4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//数据库已经有之前的操作了 
		Customer customer1  = session.get(Customer.class, 1l);
		Customer customer2  = session.get(Customer.class, 2l);
		session.delete(customer1);
		session.delete(customer2);
		tx.commit();
		session.close();
	}
	@Test
	//更改联系人对应的客户
	public void demo5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//数据库已经有之前的操作了 
		Customer customer1  = session.get(Customer.class, 1l);
		
		LinkMan linkMan = session.get(LinkMan.class, 2l);
		
		linkMan.setCustomer(customer1);
		customer1.getLinkMans().add(linkMan);
		tx.commit();
		session.close();
	}
	
}
