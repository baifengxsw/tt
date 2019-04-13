package cn.itcast01.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast01.demo2.Car;

public class Demo1 {
	@Test
	//≤‚ ‘
	public void demo1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionBean list = (CollectionBean)applicationContext.getBean("collectionBean");
		System.out.println(list);
	}
}
