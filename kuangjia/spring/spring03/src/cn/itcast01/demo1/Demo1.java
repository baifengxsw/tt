package cn.itcast01.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class Demo1 {
	@Resource(name="orderDao")
	private OrderDao dao;
	@Test
	//测试Aop的注解方式  cglib
	public void demo1() {
		
		dao.save();
		dao.update();
		dao.delete();
		dao.find();
	}
}
