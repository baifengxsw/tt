package cn.itcast01.web.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport {
		private String username;
		private String password;
		private String repassword;
		private int age;
		private String phone;
		private Date birthday;
		
	public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

		public String getRepassword() {
			return repassword;
		}

		public int getAge() {
			return age;
		}

		public String getPhone() {
			return phone;
		}

		public Date getBirthday() {
			return birthday;
		}

	

	public void setUsername(String username) {
			this.username = username;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

	@Override
	public String execute() throws Exception {
		return NONE;
	}
}
