package cn.itcast01_demo1;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring ������
 * @author baifeng
 *
 */
public class Demo1 {
	@Test
	//��ͳ�����ĵ��� ȱ�㲻̫��� �������Ҫ����jDBC�汾��ʵ��  �������Ҫ����hibernate��ʵ����
	public void demo1() {
		UserService userService = new UserServiceImpl();
		userService.save();
	}
	@Test
	//spring��ʽ�ĵ���
	public void demo2() {
		//��������
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService= (UserService) applicationContext.getBean("userService");
		userService.save();
	}
}	
