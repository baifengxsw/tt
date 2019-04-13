package cn.itcast01.demo2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
	@Test
	//demo1
	public void demo1() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService1 = (CustomerService) context.getBean("customerService");
		customerService1.save();
		CustomerService customerService2 = (CustomerService) context.getBean("customerService");
		customerService2.save();
		System.out.println("ÊÇ·ñµ¥Àý"+(customerService1==customerService2));
		context.close();
	}
}
