package cn.itcast01_demo2;

public class CustomerDaoImpl implements CustomerDao {
	
	public void init() {
		System.out.println("customerDaoImpl��ʼ��");
	}
	@Override
	public void save() {
		System.out.println("customerDaoImpl��������");
		
	}
	
	public void destroy() {
		System.out.println("customerDaoImpl����");
	}

}
