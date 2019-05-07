package cn.itcast01.demo4;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AOP����
 * @author baifeng
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo1 {
	@Resource(name="productDao")
	private ProductDao productDao;
	@Test
	public void demo1() {
		productDao.save();
		productDao.update();
		productDao.delete();
		productDao.find();
	}
}
