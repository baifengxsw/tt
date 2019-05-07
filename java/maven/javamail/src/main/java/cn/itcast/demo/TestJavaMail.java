package cn.itcast.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJavaMail {
	@Test
	public void testMail() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext_mail.xml");
		TestSend ts = (TestSend)ac.getBean("testSend");
		ts.sendMail();
		
	}
}
