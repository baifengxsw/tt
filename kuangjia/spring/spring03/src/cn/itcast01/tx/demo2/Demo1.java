package cn.itcast01.tx.demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试转账的环境
 * @author baifeng
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx2.xml")
public class Demo1 {
	@Resource(name="accountService")
	private AccountService accountService;
	@Test
	public void demo1() {
		accountService.transfer("xia", "shuang", 1000d);
	}
}
