package cn.itcast01.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiDemo1 {
	@Test
	//≤‚ ‘
	public void demo1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car)applicationContext.getBean("car");
		System.out.println(car);
	}
}
