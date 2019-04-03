package cn.itcast01.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast02.utils.HibernateUtils;

/**
 * 测试hibernate 多对多的情况
 * @author baifeng
 *
 */
public class Demo2 {
	@Test
	//保存多条记录
	public void demo1() {
		Session session = HibernateUtils.openSession(); 
		Transaction tx = session.beginTransaction();
		
		//创建两个用户
		User user1 = new User();
		user1.setUser_name("aaa");
		User user2 = new User();
		user2.setUser_name("bbb");
		
		//创建3个角色
		Role role1 = new Role();
		role1.setRole_name("研发部");
		Role role2 = new Role();
		role2.setRole_name("生产部");
		Role role3 = new Role();
		role3.setRole_name("纪检部");
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role2);
		user2.getRoles().add(role3);
		role1.getUsers().add(user1);
		role2.getUsers().add(user1);
		role2.getUsers().add(user2);
		role3.getUsers().add(user2);
		//保存操作
		session.save(user1);
		session.save(user2);
		session.save(role1);
		session.save(role2);
		session.save(role3);
		tx.commit();
		session.close();
		
	}
}
