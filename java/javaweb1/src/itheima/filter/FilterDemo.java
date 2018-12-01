package itheima.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet Filter implementation class FilterDemo
 */
public class FilterDemo implements Filter {

	public void destroy() {
		System.out.println("过滤器销毁了...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("来到过虑器了。。。");
		//chain.doFilter(request, response);
		System.out.println("来到过虑器了。。。");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器创建了...");
	}

}
