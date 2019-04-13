package cn.itcast01.demo3;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
	@Test
	public void demo1() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) context.getBean("userService");
		service.save();
		context.close();
		
	}
}
