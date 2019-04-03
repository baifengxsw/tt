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
 * hibernate 入门
 * @author baifeng
 *
 */
public class Demo1 {
	@Test
	//保存客户案例
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
		customer.setCust_id(1233);
		customer.setCust_name("wang");
		session.save(customer);
		//6 事务提交
			transaction.commit();
		//7 释放资源
		session.close();
			
	}
	@Test
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
		Customer ret = session.get(Customer.class, 1l);
		System.out.println(ret);
		
		//6 事务提交
			transaction.commit();
		//7 释放资源
			
	}
	//saveorupdate 测试
	@Test
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
		
		customer.setCust_name("xia");
		session.saveOrUpdate(customer);
		
		//6 事务提交
			transaction.commit();
		//7 释放资源
			
	}
	//查询所有数据
	@Test
	public void demo4() {
		//1 加载核心配置 文件 
		Configuration conf = new Configuration().configure();
		//2创建SessionFactory 对象，类似于JDBC中的连接池
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3 通过SessionFactory 获取Session 对象 类似Connection
		Session  session = sessionFactory.openSession();
		//4手动开事务;
		Transaction transaction = session.beginTransaction();
		//5编写代码 面向对象de hql
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
		
		//6 事务提交
			transaction.commit();
		//7 释放资源
			session.close();
			
	}
}
