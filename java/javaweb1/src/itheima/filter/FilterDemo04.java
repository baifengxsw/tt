package itheima.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo04 implements Filter {

	//初始化的时候调用
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("来到了 过滤器 filter04 before");
		chain.doFilter(request, response);
		System.out.println("来到了 过滤器 filter04 after");
	}

	@Override
	public void destroy() {
		
	}

}
