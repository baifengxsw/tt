package cn.itcast01.demo;



import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast02.utils.HibernateUtils;

/**
 * HQL��ѯ��ʽ������
 * @author baifeng
 *
 */
public class Demo1 {
	
	/**
	 * ��ʼ������
	 */
	@Test
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//����һ���û�
		Customer customer = new Customer();
		customer.setCust_name("����");
		for(int i =0;i<10;i++) {
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("ghfsf"+i);
			customer.getLinkMans().add(linkMan);
			linkMan.setCustomer(customer);
			session.save(linkMan);
		}
		session.save(customer);
		tx.commit();
		//session�󶨵�ǰ�̵߳Ļ� ����close
		//session.close();
		
	}
	/**
	 * �򵥲�ѯ
	 */
	@Test
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//����һ���û�
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for(Customer  customer: list) {
			System.out.println(customer);
		}
		tx.commit();
		//session�󶨵�ǰ�̵߳Ļ� ����close
		//session.close();
		
	}
	/**
	 * ������ѯ
	 */
	@Test
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//����һ���û�
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for(Customer  customer: list) {
			System.out.println(customer);
		}
		tx.commit();
		//session�󶨵�ǰ�̵߳Ļ� ����close
		//session.close();
		
	}
	/**
	 * �����ѯ
	 */
	@Test
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//����һ���û�
		Query query = session.createQuery("from Customer order by cust_id desc");
		List<Customer> list = query.list();
		for(Customer  customer: list) {
			System.out.println(customer);
		}
		tx.commit();
		//session�󶨵�ǰ�̵߳Ļ� ����close
		//session.close();
		
	}
	/**
	 * ������ѯ
	 */
	@Test
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//����һ���û� 1 ��λ�ð�
		/*Query query = session.createQuery("from Customer  where cust_name = ?");
		query.setParameter(0, "xia");*/
		//�����û�ʹ�����ƽ��а�
		Query query = session.createQuery("from Customer where cust_name = :name");
		query.setParameter("name","xia"	);
		List<Customer> list = query.list();
		for(Customer  customer: list) {
			System.out.println(customer);
		}
		tx.commit();
		//session�󶨵�ǰ�̵߳Ļ� ����close
		//session.close();
		
	}
	/**
	 * ͶӰ��ѯ
	 */
	@Test
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		/*Query query = session.createQuery("select c.cust_name from Customer c");
		List<String> list = query.list();*/
		//��Զ������ 
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
		//session�󶨵�ǰ�̵߳Ļ� ����close
		//session.close();
		
	}
	/**
	 * ��ҳ��ѯ
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
		//session�󶨵�ǰ�̵߳Ļ� ����close
		//session.close();
		
	}
	/**
	 * ����ͳ�Ʋ�ѯ
	 */
	@Test
	public void demo8() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//ͳ���������������
		/*Long ret =  (Long) session.createQuery("select count(*) from Customer").uniqueResult();
		System.out.println(ret);*/
		//����ͳ��
		Query query = session.createQuery("select cust_name,count(*) from Customer group by cust_name having count(*) >1"); 
		List<Object[] > list =query.list();
		for(Object[] obj:list) {
			System.out.println(Arrays.toString(obj));
		}
		tx.commit();
		//session�󶨵�ǰ�̵߳Ļ� ����close
		//session.close();
		
	}
}
