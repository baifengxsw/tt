package cn.itcast01_demo1;

public class UserServiceImpl2 implements UserService {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void save() {
		System.out.println("userService2÷¥––¡À"+name);
		
	}

}
