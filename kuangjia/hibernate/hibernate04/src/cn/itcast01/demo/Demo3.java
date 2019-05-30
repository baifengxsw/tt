package cn.itcast01.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast02.utils.HibernateUtils;

//HQL 多表查询
public class Demo3 {
	@Test
	//内连接查询
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//进行内连接查询  //linkMans 是customer 内中对LinkMan 的集合
		/*Query query   = session.createQuery("from Customer c inner join c.linkMans");
		List<Customer> list = query.list();
		for(Customer obj:list) {
			System.out.println(obj);
		}
		*/
		//接下来演示迫切内连接
		Query query = session.createQuery("select distinct c from Customer c inner join fetch c.linkMans");
		List<Customer> list = query.list();
		for(Customer customer :list) {
			System.out.println(customer );
		}
		tx.commit();
		//不需要close
	}
	@Test
	//SQL 查询
	public void demo7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//是每个属性的封装
	/*	SQLQuery sqlQuery = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list = sqlQuery.list();
		for(Object[] obj : list) {
			System.out.println(obj[1]);
		}*/
		//下面是封装到对象中
		SQLQuery sqlQuery = session.createSQLQuery("select * from cst_customer");
		sqlQuery.addEntity(Customer.class);
		List<Customer> list = sqlQuery.list();
		for(Customer customer: list) {
			System.out.println(customer);
		}
		tx.commit();
		//不需要close
	}
	
	@Test
	//延迟 加载
	public void demo8() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.load(Customer.class, 1l);
		System.out.println(customer);
		tx.commit();
		//不需要close
	}
	
}
