package cn.itcast01.web.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ֻ�м̳������ ���Ż�����Ӧ������У�飬���ʻ�,���ô�����Ϣ
 * @author baifeng
 *
 */
public class LoginAction2 extends ActionSupport{
	private String username;
	private String password;
	/**
	 * ��������У�����Ҫ��д�������
	 */
	

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO �Զ����ɵķ������
		System.out.println(username);
		System.out.println(password);
		
		return NONE;
	}
}
