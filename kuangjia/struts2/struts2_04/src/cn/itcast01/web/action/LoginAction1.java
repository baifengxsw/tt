package cn.itcast01.web.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ֻ�м̳������ ���Ż�����Ӧ������У�飬���ʻ�,���ô�����Ϣ
 * @author baifeng
 *
 */
public class LoginAction1 extends ActionSupport{
	private String username;
	private String password;
	/**
	 * ��������У�����Ҫ��д�������
	 */
	@Override
	public void validate() {
		//�ж��û�������Ϊ��
		if(username==null||username.trim().length()==0) {
			this.addFieldError("username", "�û�������Ϊ��");
		}
		//��ֹexcute����ִ��
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO �Զ����ɵķ������
		
		
		return SUCCESS;
	}
}
