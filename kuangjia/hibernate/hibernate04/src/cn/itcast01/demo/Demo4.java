package cn.itcast01.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast02.utils.HibernateUtils;

//在set上的fetch 和lazy
public class Demo4 {
	@Test
	//测试 默认情况
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1l);
		//这边只会发送一条查询此客户的sql
		//查询1号客户每个联系人的信息
		System.out.println(customer.getCust_name());
		for(LinkMan linkMan :customer.getLinkMans()) { //这里又会根据id 查询联系人
			System.out.println(linkMan.getLkm_name());
		}
		tx.commit();
	}
	@Test
	//fetch = select lazy = true;
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1l);
		//这边只会发送一条查询此客户的sql
		//查询1号客户每个联系人的信息
		System.out.println(customer.getCust_name());
		for(LinkMan linkMan :customer.getLinkMans()) { //这里又会根据id 查询联系人
			System.out.println(linkMan.getLkm_name());
		}
		tx.commit();
	}
	@Test
	//fetch = select lazy = false;
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1l);
		//这边只会发送一条查询此客户的sql 并且发送查询相应联系人的sql
		//查询1号客户每个联系人的信息
		System.out.println(customer.getCust_name());
		for(LinkMan linkMan :customer.getLinkMans()) { 
			System.out.println(linkMan.getLkm_name());
		}
		System.out.println(customer.getLinkMans().size());
		tx.commit();
	}
	@Test
	//fetch = select lazy = extra 极其懒惰;
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1l);
		//这边只会发送一条查询此客户的sql 并且发送查询相应联系人的sql
		//查询1号客户每个联系人的信息
		System.out.println(customer.getCust_name());
		for(LinkMan linkMan :customer.getLinkMans()) { 
			System.out.println(linkMan.getLkm_name());
		}
		System.out.println(customer.getLinkMans().size());
		tx.commit();
	}
	@Test
	//测试不用批量抓取的情况
	//获取客户的时候，批量去抓取联系人
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//先查询所有的客户
		
		List<Customer> list = session.createQuery("from Customer").list();
		for(Customer customer:list) {
			System.out.println(customer.getCust_name());
			for(LinkMan linkMan :customer.getLinkMans()) {
				System.out.println(linkMan);
			}
		}
		tx.commit();
	}
	@Test
	//测试批量抓取
	//获取客户的时候，批量去抓取联系人
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//先查询所有的客户 设置 主对象的 batch-size
		
		List<Customer> list = session.createQuery("from Customer").list();
		for(Customer customer:list) {
			System.out.println(customer.getCust_name());
			for(LinkMan linkMan :customer.getLinkMans()) {
				System.out.println(linkMan);
			}
		}
		tx.commit();
	}
}
