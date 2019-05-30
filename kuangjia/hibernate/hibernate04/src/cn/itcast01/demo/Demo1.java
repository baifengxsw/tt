package cn.itcast01.demo;



import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast02.utils.HibernateUtils;

/**
 * HQL查询方式测试类
 * @author baifeng
 *
 */
public class Demo1 {
	
	/**
	 * 初始化数据
	 */
	@Test
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//创建一个用户
		Customer customer = new Customer();
		customer.setCust_name("吕布");
		for(int i =0;i<10;i++) {
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("ghfsf"+i);
			customer.getLinkMans().add(linkMan);
			linkMan.setCustomer(customer);
			session.save(linkMan);
		}
		session.save(customer);
		tx.commit();
		//session绑定当前线程的话 不用close
		//session.close();
		
	}
	/**
	 * 简单查询
	 */
	@Test
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//创建一个用户
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for(Customer  customer: list) {
			System.out.println(customer);
		}
		tx.commit();
		//session绑定当前线程的话 不用close
		//session.close();
		
	}
	/**
	 * 别名查询
	 */
	@Test
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//创建一个用户
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for(Customer  customer: list) {
			System.out.println(customer);
		}
		tx.commit();
		//session绑定当前线程的话 不用close
		//session.close();
		
	}
	/**
	 * 排序查询
	 */
	@Test
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//创建一个用户
		Query query = session.createQuery("from Customer order by cust_id desc");
		List<Customer> list = query.list();
		for(Customer  customer: list) {
			System.out.println(customer);
		}
		tx.commit();
		//session绑定当前线程的话 不用close
		//session.close();
		
	}
	/**
	 * 条件查询
	 */
	@Test
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//创建一个用户 1 按位置绑定
		/*Query query = session.createQuery("from Customer  where cust_name = ?");
		query.setParameter(0, "xia");*/
		//创建用户使用名称进行绑定
		Query query = session.createQuery("from Customer where cust_name = :name");
		query.setParameter("name","xia"	);
		List<Customer> list = query.list();
		for(Customer  customer: list) {
			System.out.println(customer);
		}
		tx.commit();
		//session绑定当前线程的话 不用close
		//session.close();
		
	}
	/**
	 * 投影查询
	 */
	@Test
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		/*Query query = session.createQuery("select c.cust_name from Customer c");
		List<String> list = query.list();*/
		//针对多个属性 
/*		Query query = session.createQuery("select c.cust_name ,c.cust_id from Customer c");
		List<Object[]> list = query.list();
		for(Object[] obj :list) {
			System.out.println((String)obj[0]+(Long)obj[1]);
		}
		tx.commit();*/
		
		Query query = session.createQuery("select new Customer(c.cust_id,c.cust_name) from Customer c");
		List<Customer> list = query.list();
		for(Customer customer :list) {
			System.out.println(customer);
		}
		//session绑定当前线程的话 不用close
		//session.close();
		
	}
	/**
	 * 分页查询
	 */
	@Test
	public void demo7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from LinkMan");
		query.setFirstResult(0);
		query.setMaxResults(10);
		List<LinkMan> list = query.list();
		for(LinkMan linkMan :list) {
			System.out.println(linkMan);
		}
		tx.commit();
		//session绑定当前线程的话 不用close
		//session.close();
		
	}
	/**
	 * 分组统计查询
	 */
	@Test
	public void demo8() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//统计总体的数据总数
		/*Long ret =  (Long) session.createQuery("select count(*) from Customer").uniqueResult();
		System.out.println(ret);*/
		//分组统计
		Query query = session.createQuery("select cust_name,count(*) from Customer group by cust_name having count(*) >1"); 
		List<Object[] > list =query.list();
		for(Object[] obj:list) {
			System.out.println(Arrays.toString(obj));
		}
		tx.commit();
		//session绑定当前线程的话 不用close
		//session.close();
		
	}
}
