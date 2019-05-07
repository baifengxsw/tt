package cn.itcast01.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("userDao")//�൱����xml��������<bean id ="userDao" class="��ǰ��">
public class UserDaoImpl implements UserDao {
	private String name;
	@Value("王")
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void save() {
		
		System.out.println("dao"+name);
	}

}
