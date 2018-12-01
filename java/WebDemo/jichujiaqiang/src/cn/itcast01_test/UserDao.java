package cn.itcast01_test;

public class UserDao {
	static {
		System.out.println("UserDao类被加载");
	}
	@Test01
	public void addUSer() {
		System.out.println("增加用户");
		
	}
	@Test01
	public void deleteUSer() {
		System.out.println("删除用户");
		
	}
	@Test01
	public void upUSer() {
		System.out.println("更新用户");
		
	}
	public void getUSer() {
		System.out.println("得到用户");
		
	}
}
