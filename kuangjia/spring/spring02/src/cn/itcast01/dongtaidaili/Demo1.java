package cn.itcast01.dongtaidaili;

import org.junit.Test;

public class Demo1 {
	@Test
	//JDK��̬����
	public void demo1() {
		UserDao dao = new UserDaoImpl();
		UserDao proxy = (UserDao)new JDKDemo1(dao).createProxy();
		proxy.save();
		proxy.delete();
		proxy.find();
		proxy.update();
	}
	@Test
	//cglib��̬����
	public void demo2() {
		CustomerDao  customerDao= new CustomerDao();
		CustomerDao proxy = new CglibProxy(customerDao).createProxy();
		
		proxy.save();
		proxy.delete();
		proxy.find();
		proxy.update();
	}
}
