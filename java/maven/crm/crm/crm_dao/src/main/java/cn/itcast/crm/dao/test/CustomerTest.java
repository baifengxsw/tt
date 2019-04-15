package cn.itcast.crm.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.domain.Customer;

public class CustomerTest {
	@Test
	public void demo1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		CustomerDao  customerDao = (CustomerDao)ac.getBean("customerDao");
		List<Customer> list = customerDao.findAll();
		for(Customer customer :list) {
			System.out.println(customer);
		}
		
	}
}
