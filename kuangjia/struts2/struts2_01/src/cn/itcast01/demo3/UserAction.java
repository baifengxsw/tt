package cn.itcast01.demo3;

import com.opensymphony.xwork2.ActionSupport;

/**
 * struts�����Ų���
 * @author baifeng
 *
 */
public class UserAction extends ActionSupport{
	public String find () {
		System.out.println("�����û�");
		return NONE;
	}
	public String delete () {
		System.out.println("ɾ���û�");
		return NONE;
	}
	public String save () {
		System.out.println("�����û�");
		return NONE;
	}
	public String update () {
		System.out.println("�����û�");
		return NONE;
	}
}
