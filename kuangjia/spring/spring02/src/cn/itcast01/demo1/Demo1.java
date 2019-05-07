package cn.itcast01.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ע����Ӧ�Ĳ�����
 * @author baifeng
 *
 */
public class Demo1 {
	@Test
	//����1 ��ͳ��ʽ
	public void demo1() {
		UserDao dao = new UserDaoImpl();
		dao.save();
	}
	@Test
	//spring ioc ע��ķ�ʽ
	public void demo2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
		UserDao dao = (UserDao) applicationContext.getBean("userDao");
		dao.save();
	}
	@Test
	//spring ioc ע��ķ�ʽ
	public void demo3() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
		UserService service = (UserService) applicationContext.getBean("userService");
		service.save();
	}
}
