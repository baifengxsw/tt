package cn.itcast01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet  implements Servlet {

	public void destroy() {
		// TODO 自动生成的方法存根
		
	}

	public ServletConfig getServletConfig() {
		// TODO 自动生成的方法存根
		return null;
	}

	public String getServletInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		// TODO 自动生成的方法存根
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		System.out.println("hello servlet");
	}

}
