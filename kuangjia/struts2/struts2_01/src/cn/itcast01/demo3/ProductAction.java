package cn.itcast01.demo3;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {
	public String find() {
		
		System.out.println("查找商品");
		return NONE;
	}
	public String delete() {
		
		System.out.println("删除商品");
		return NONE;
	}
	public String save() {
		
		System.out.println("保存商品");
		return NONE;
	}
	public String update() {
		
		System.out.println("修改商品");
		return NONE;
	}
}
