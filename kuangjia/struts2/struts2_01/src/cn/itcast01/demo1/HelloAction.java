package cn.itcast01.demo1;
/**
 * struts�����Ų���
 * @author baifeng
 *
 */
public class HelloAction {
	/**
	 * �ṩһ������ ���ҷ���String �����Ҳ��ܴ��� ��Ϊ������ô֪��������
	 */
	public String execute() {
		System.out.println("HelloActionִ����");
		return "success";
	}
}
