package cn.itcast01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet  implements Servlet {

	public void destroy() {
		// TODO �Զ����ɵķ������
		
	}

	public ServletConfig getServletConfig() {
		// TODO �Զ����ɵķ������
		return null;
	}

	public String getServletInfo() {
		// TODO �Զ����ɵķ������
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		// TODO �Զ����ɵķ������
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		System.out.println("hello servlet");
	}

}
