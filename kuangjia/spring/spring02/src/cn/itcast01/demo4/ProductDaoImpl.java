package cn.itcast01.demo4;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void save() {
		System.out.println("����");
		
	}

	@Override
	public void update() {
		System.out.println("����");
		
	}

	@Override
	public void find() {
		System.out.println("����");
		
	}

	@Override
	public int  delete() {
		System.out.println("删除");
		return 1;
	}

}
