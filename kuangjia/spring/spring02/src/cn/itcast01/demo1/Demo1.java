package cn.itcast01.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解相应的测试类
 * @author baifeng
 *
 */
public class Demo1 {
	@Test
	//测试1 传统方式
	public void demo1() {
		UserDao dao = new UserDaoImpl();
		dao.save();
	}
	@Test
	//spring ioc 注解的方式
	public void demo2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao = (UserDao) applicationContext.getBean("userDao");
		dao.save();
	}
	@Test
	//spring ioc 注解的方式
	public void demo3() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) applicationContext.getBean("userService");
		service.save();
	}
}
