package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction  extends ActionSupport{

	@Override
	public String execute() throws Exception {
		System.out.println("������Ӧ��HelloAction..����Ĭ�ϵ�jspҳ��");
		return super.execute();
	}
	

}
