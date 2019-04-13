package cn.itcast01_demo1;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring 的入门
 * @author baifeng
 *
 */
public class Demo1 {
	@Test
	//传统方法的调用 缺点不太灵活 ，如果我要调用jDBC版本的实现  ，如果我要调用hibernate的实现了
	public void demo1() {
		UserService userService = new UserServiceImpl();
		userService.save();
	}
	@Test
	//spring方式的调用
	public void demo2() {
		//创建工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService= (UserService) applicationContext.getBean("userService");
		userService.save();
	}
}	
