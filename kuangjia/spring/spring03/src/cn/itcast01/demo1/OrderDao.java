package cn.itcast01.demo1;

public class OrderDao {
	public void save() {
		System.out.println("保存订单");
	}
	public void update() {
		System.out.println("更新订单");
	}
	public String delete() {
		System.out.println("删除订单");
		return "xia";
		
	}
	public void find() {
		int a = 10/0;
		System.out.println("查找订单");
	}
}
