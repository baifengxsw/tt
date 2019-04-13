package cn.itcast01_demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
	@Test
	//������صĲ���
	public void demo1() {
		ClassPathXmlApplicationContext applicationContext = new  ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao dao = (CustomerDao)applicationContext.getBean("customerDao");
		dao.save();
		applicationContext.close();
	
	}
	@Test
	//���е���ģʽ�Ĳ���
	public void demo2() {
		ClassPathXmlApplicationContext applicationContext = new  ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao dao1 = (CustomerDao)applicationContext.getBean("customerDao");
		CustomerDao dao2 = (CustomerDao)applicationContext.getBean("customerDao");
		System.out.println(dao1==dao2);
		applicationContext.close();
		
	}
}
