package cn.itcast01.demo3;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {
	public String find() {
		
		System.out.println("������Ʒ");
		return NONE;
	}
	public String delete() {
		
		System.out.println("ɾ����Ʒ");
		return NONE;
	}
	public String save() {
		
		System.out.println("������Ʒ");
		return NONE;
	}
	public String update() {
		
		System.out.println("�޸���Ʒ");
		return NONE;
	}
}
