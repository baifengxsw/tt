package cn.itcast01.demo1;

public class OrderDao {
	public void save() {
		System.out.println("���涩��");
	}
	public void update() {
		System.out.println("���¶���");
	}
	public String delete() {
		System.out.println("ɾ������");
		return "xia";
		
	}
	public void find() {
		int a = 10/0;
		System.out.println("���Ҷ���");
	}
}
