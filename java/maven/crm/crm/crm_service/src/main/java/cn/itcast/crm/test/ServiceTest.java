package cn.itcast.crm.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.CustomerService;

public class ServiceTest {
	@Test
	public void demo1() {
		ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-service.xml");
		CustomerService customerService = (CustomerService) cc.getBean("customerService");
		for(Customer customer:customerService.findAll()) {
			System.out.println(customer);
		}
	}
	
}
