package cn.itcast01.demo2;

import com.opensymphony.xwork2.Action;

/**
 * action ʵ�ֽӿ�
 * @author baifeng
 *
 */
public class Actiondemo3 implements Action {
	/**
	 * �ṩһ������ ���ҷ���String �����Ҳ��ܴ��� ��Ϊ������ô֪��������
	 */
	public String execute() {
		System.out.println("Actiondemo3ִ����");
		return null;
	}
}
