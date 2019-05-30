package cn.itcast.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.CustomerDao;
import cn.itcast.entity.Customer;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试
@ContextConfiguration(locations="classpath:applicationContext.xml")

public class demo1 {
		@Autowired
		private CustomerDao customerDao;
		
		@Test
		public void testFindOne() {
			Customer cust = customerDao.findOne(1l);
			System.out.println(cust);
		}
		
		@Test
		public void testSave() {
			Customer customer = new Customer();
			//customer.setCustId(1l);
			customer.setCustAddress("dsfdsf");
			customer.setCustName("xia1");
			customerDao.save(customer);
		}
		@Test
		public void testJpql() {
			List<Customer> list = customerDao.findAll();
			for(Customer cus:list) {
				System.out.println(cus);
			}
		}
		
}
