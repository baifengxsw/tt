package cn.itcast03_code_error;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class DemoFilter
 */
public class DemoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public DemoFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		final HttpServletRequest req = (HttpServletRequest)request;
		//增强req的对象的getParamter
			HttpServletRequest rep = (HttpServletRequest)Proxy.newProxyInstance(DemoFilter.class.getClassLoader(),req.getClass().getInterfaces() , new InvocationHandler() {
				
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					// TODO 自动生成的方法存根
					Object obj = null;
					if(method.getName().equalsIgnoreCase("getParameter")) {
					
						if(req.getMethod().equalsIgnoreCase("get")) {
							//get 方法提交过来的
							obj = method.invoke(req, args);
							String value = (String)obj;
							System.out.println("String:"+value);
							String retvalue = new String(value.getBytes("iso-8859-1"),"UTF-8");
							return retvalue;
							
						}else {
							//post 方法提交过来的
							req.setCharacterEncoding("UTF-8");
							obj = method.invoke(req, args);
						}
					}else {
						
						obj = method.invoke(req, args);
					}
						
					return obj;
				}
			});
		// pass the request along the filter chain
		chain.doFilter(rep, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
