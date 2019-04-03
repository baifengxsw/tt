package cn.itcast.demo2;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction1 extends ActionSupport{
	//提供对应的属性 并且提供相应的set方法
	private String username;
	private String password;
	private Integer age;
	private Date birthday;
	private Double salary;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(username);
		System.out.println(password);
		System.out.println(birthday);
		System.out.println(age);
		System.out.println(salary);
		
		return NONE;
	}
}
