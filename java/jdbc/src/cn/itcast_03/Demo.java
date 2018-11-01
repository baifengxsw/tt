package cn.itcast_03;

public class Demo {
	public static void main(String[] args) {
		TestDao td = new TestDaoImpl();
		//≤‚ ‘ 
//		td.login();
//		System.out.println("*****************************");
//		
//		td.login2("xia","123");
		td.insert("xia", "123");
	}
}
