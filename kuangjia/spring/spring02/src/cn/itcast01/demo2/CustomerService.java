package cn.itcast01.demo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("customerService")//相当于<id= class 等于当前 设置 init方法， 和destroy方法
@Scope("prototype")
public class CustomerService {
	@PostConstruct
	public void init() {
		System.out.println("被初始化了");
	}
	
	public void save() {
		System.out.println("被执行了");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("被销毁啦");
	}
}
