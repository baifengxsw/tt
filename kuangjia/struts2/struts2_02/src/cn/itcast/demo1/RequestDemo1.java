package cn.itcast.demo1;

import java.util.Arrays;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 访问servlet的API  完全解耦合的方式
 * @author baifeng
 *
 */
public class RequestDemo1 extends ActionSupport {
	public String execute() throws Exception{
		//利用Struts2的对象ActionContext对象
		ActionContext context = ActionContext.getContext();
		Map<String,Object> map = context.getParameters();
		for(String key:map.keySet()) {
			String [] value = (String [])map.get(key);
			System.out.println(key+":"+Arrays.toString(value));
		}
		
		//向域对象中存入数据
		context.put("reqname", "reqvalue"); //相当于request。setAttribute():
		//这边注意它拿到的是一个map
		context.getSession().put("session", "sessionff");
		//相当于application.setAttribute():
		context.getApplication().put("appname", "appname");
		
		return SUCCESS;
	}
}
