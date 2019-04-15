package cn.itacast.erp.test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.erp.dao.impl.DepDao;
import cn.itcast.erp.entity.Dep;

public class Demo {
	@Test
	public void demo1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext_*.xml");
		DepDao  depDao = (DepDao) ac.getBean("depDao");
		for(Dep dep : depDao.findList()) {
			System.out.println(dep);
		}
	}
}
