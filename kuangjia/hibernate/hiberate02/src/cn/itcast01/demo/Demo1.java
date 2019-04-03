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
 * hibernate主键生成策略
 * @author baifeng
 *
 */
public class Demo1 {
	@Test
	//保存客户案例  测试为create  increment测试hibernate 内部单线程增长机制
	public void demo1() {
		//1 加载核心配置 文件 
		Configuration conf = new Configuration().configure();
		//2创建SessionFactory 对象，类似于JDBC中的连接池
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 通过SessionFactory 获取Session 对象 类似Connection
		Session  session = sessionFactory.openSession();
		//4手动开事务;
		Transaction transaction = session.beginTransaction();
		//5编写代码
		Customer customer = new Customer();
	
		customer.setCust_name("wang");
		session.save(customer);
		//6 事务提交
			transaction.commit();
		//7 释放资源
		session.close();
			
	}
	@Test
	//
	public void demo2() {
		//1 加载核心配置 文件 
		Configuration conf = new Configuration().configure();
		//2创建SessionFactory 对象，类似于JDBC中的连接池
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 通过SessionFactory 获取Session 对象 类似Connection
		Session  session = sessionFactory.openSession();
		//4手动开事务;
		Transaction transaction = session.beginTransaction();
		//5编写代码
		Customer customer = new Customer();
		
		customer.setCust_name("wang xi");
		session.save(customer);
		//6 事务提交
		transaction.commit();
		//7 释放资源
		session.close();
		
	}
	@Test
	//演示 identity
	public void demo3() {
		//1 加载核心配置 文件 
		Configuration conf = new Configuration().configure();
		//2创建SessionFactory 对象，类似于JDBC中的连接池
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 通过SessionFactory 获取Session 对象 类似Connection
		Session  session = sessionFactory.openSession();
		//4手动开事务;
		Transaction transaction = session.beginTransaction();
		//5编写代码
		Customer customer = new Customer();
		
		customer.setCust_name("wang xi");
		session.save(customer);
		//6 事务提交
		transaction.commit();
		//7 释放资源
		session.close();
		
	}
	@Test
	//演示assigned
	public void demo4() {
		//1 加载核心配置 文件 
		Configuration conf = new Configuration().configure();
		//2创建SessionFactory 对象，类似于JDBC中的连接池
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 通过SessionFactory 获取Session 对象 类似Connection
		Session  session = sessionFactory.openSession();
		//4手动开事务;
		Transaction transaction = session.beginTransaction();
		//5编写代码
		Customer customer = new Customer();
		customer.setCust_id(100l);
		customer.setCust_name("wang xi");
		session.save(customer);
		//6 事务提交
		transaction.commit();
		//7 释放资源
		session.close();
		
	}
	@Test
	//演示持久类的持久态自动更新数据
	public void demo5() {
		//1 加载核心配置 文件 
		Configuration conf = new Configuration().configure();
		//2创建SessionFactory 对象，类似于JDBC中的连接池
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 通过SessionFactory 获取Session 对象 类似Connection
		Session  session = sessionFactory.openSession();
		//4手动开事务;
		Transaction transaction = session.beginTransaction();
		//5编写代码
		Customer customer = new Customer();
		customer.setCust_id(2l);
		customer.setCust_name("wang xi");
		session.save(customer);
		customer.setCust_name("wang");
		//6 事务提交
		transaction.commit();
		//7 释放资源
		session.close();
		
	}
	@Test
	//演示一级缓存的存在
	public void demo6() {
		//1 加载核心配置 文件 
		Configuration conf = new Configuration().configure();
		//2创建SessionFactory 对象，类似于JDBC中的连接池
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 通过SessionFactory 获取Session 对象 类似Connection
		Session  session = sessionFactory.openSession();
		//4手动开事务;
		Transaction transaction = session.beginTransaction();
		//5编写代码
		Customer customer = session.get(Customer.class, 2l);
		customer.setCust_phone("12313");
		Customer customer1 = session.get(Customer.class, 2L);
		System.out.println(customer);
		System.out.println(customer1);
		System.out.println(customer==customer1);
		//6 事务提交
		transaction.commit();
		//7 释放资源
		session.close();
		
	}
	
}
