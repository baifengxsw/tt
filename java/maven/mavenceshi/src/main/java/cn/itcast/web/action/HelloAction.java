package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction  extends ActionSupport{

	@Override
	public String execute() throws Exception {
		System.out.println("进入相应的HelloAction..返回默认的jsp页面");
		return super.execute();
	}
	

}
