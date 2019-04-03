package cn.itcast01.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast02.utils.HibernateUtils;

//��set�ϵ�fetch ��lazy
public class Demo4 {
	@Test
	//���� Ĭ�����
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1l);
		//���ֻ�ᷢ��һ����ѯ�˿ͻ���sql
		//��ѯ1�ſͻ�ÿ����ϵ�˵���Ϣ
		System.out.println(customer.getCust_name());
		for(LinkMan linkMan :customer.getLinkMans()) { //�����ֻ����id ��ѯ��ϵ��
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
		//���ֻ�ᷢ��һ����ѯ�˿ͻ���sql
		//��ѯ1�ſͻ�ÿ����ϵ�˵���Ϣ
		System.out.println(customer.getCust_name());
		for(LinkMan linkMan :customer.getLinkMans()) { //�����ֻ����id ��ѯ��ϵ��
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
		//���ֻ�ᷢ��һ����ѯ�˿ͻ���sql ���ҷ��Ͳ�ѯ��Ӧ��ϵ�˵�sql
		//��ѯ1�ſͻ�ÿ����ϵ�˵���Ϣ
		System.out.println(customer.getCust_name());
		for(LinkMan linkMan :customer.getLinkMans()) { 
			System.out.println(linkMan.getLkm_name());
		}
		System.out.println(customer.getLinkMans().size());
		tx.commit();
	}
	@Test
	//fetch = select lazy = extra ��������;
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1l);
		//���ֻ�ᷢ��һ����ѯ�˿ͻ���sql ���ҷ��Ͳ�ѯ��Ӧ��ϵ�˵�sql
		//��ѯ1�ſͻ�ÿ����ϵ�˵���Ϣ
		System.out.println(customer.getCust_name());
		for(LinkMan linkMan :customer.getLinkMans()) { 
			System.out.println(linkMan.getLkm_name());
		}
		System.out.println(customer.getLinkMans().size());
		tx.commit();
	}
	@Test
	//���Բ�������ץȡ�����
	//��ȡ�ͻ���ʱ������ȥץȡ��ϵ��
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//�Ȳ�ѯ���еĿͻ�
		
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
	//��������ץȡ
	//��ȡ�ͻ���ʱ������ȥץȡ��ϵ��
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//�Ȳ�ѯ���еĿͻ� ���� ������� batch-size
		
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
