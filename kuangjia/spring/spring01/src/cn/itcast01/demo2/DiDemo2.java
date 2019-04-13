package cn.itcast01.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiDemo2 {
	@Test
	//≤‚ ‘
	public void demo1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car2 car = (Car2)applicationContext.getBean("car2");
		System.out.println(car);
	}
}
