package cn.itcast01.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("userDao")//相当于在xml中配置了<bean id ="userDao" class="当前类">
public class UserDaoImpl implements UserDao {
	private String name;
	@Value("杨永信")
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void save() {
		
		System.out.println("dao中保存用户的方法执行了"+name);
	}

}
