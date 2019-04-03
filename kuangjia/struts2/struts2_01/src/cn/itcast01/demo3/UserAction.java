package cn.itcast01.demo3;

import com.opensymphony.xwork2.ActionSupport;

/**
 * struts的入门测试
 * @author baifeng
 *
 */
public class UserAction extends ActionSupport{
	public String find () {
		System.out.println("发现用户");
		return NONE;
	}
	public String delete () {
		System.out.println("删除用户");
		return NONE;
	}
	public String save () {
		System.out.println("保存用户");
		return NONE;
	}
	public String update () {
		System.out.println("更新用户");
		return NONE;
	}
}
