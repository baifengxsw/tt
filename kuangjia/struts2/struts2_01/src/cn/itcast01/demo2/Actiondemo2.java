package cn.itcast01.demo2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * action ʵ�ּ̳�
 * @author baifeng
 *
 */
public class Actiondemo2 extends ActionSupport{
	/**
	 * �ṩһ������ ���ҷ���String �����Ҳ��ܴ��� ��Ϊ������ô֪��������
	 */
	public String execute() {
		System.out.println("Actiondemo3ִ����");
		return NONE;
	}
}
