package cn.itcast.demo1;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 访问servlet的API  完全解耦合的方式
 * @author baifeng
 *
 */
public class RequestDemo2 extends ActionSupport implements ServletRequestAware ,ServletContextAware {
	private HttpServletRequest request;
	private ServletContext context;
	public String execute() throws Exception{
		
		//通过接口注入的方式来获得request对象
		Map<String,String[]> map = request.getParameterMap();
		for(String key :map.keySet()) {
			String[] value = map.get(key);
			System.out.println(key+":"+Arrays.toString(value));
		}
		
		request.setAttribute("reqname", "reqname");
		request.getSession().setAttribute("session", "session");
		context.setAttribute("appname","appname");
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context =context;
		
	}
	
}
