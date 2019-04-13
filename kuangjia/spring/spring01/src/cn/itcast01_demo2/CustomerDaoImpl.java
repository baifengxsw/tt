package cn.itcast01_demo2;

public class CustomerDaoImpl implements CustomerDao {
	
	public void init() {
		System.out.println("customerDaoImpl初始化");
	}
	@Override
	public void save() {
		System.out.println("customerDaoImpl被调用了");
		
	}
	
	public void destroy() {
		System.out.println("customerDaoImpl销毁");
	}

}
