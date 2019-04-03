package cn.itcast01.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast02.utils.HibernateUtils;

/**
 * ����hibernate ��Զ�����
 * @author baifeng
 *
 */
public class Demo2 {
	@Test
	//���������¼
	public void demo1() {
		Session session = HibernateUtils.openSession(); 
		Transaction tx = session.beginTransaction();
		
		//���������û�
		User user1 = new User();
		user1.setUser_name("aaa");
		User user2 = new User();
		user2.setUser_name("bbb");
		
		//����3����ɫ
		Role role1 = new Role();
		role1.setRole_name("�з���");
		Role role2 = new Role();
		role2.setRole_name("������");
		Role role3 = new Role();
		role3.setRole_name("�ͼ첿");
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role2);
		user2.getRoles().add(role3);
		role1.getUsers().add(user1);
		role2.getUsers().add(user1);
		role2.getUsers().add(user2);
		role3.getUsers().add(user2);
		//�������
		session.save(user1);
		session.save(user2);
		session.save(role1);
		session.save(role2);
		session.save(role3);
		tx.commit();
		session.close();
		
	}
}
