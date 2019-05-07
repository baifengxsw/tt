package cn.itcast02_zidongdenglu;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
public class AutoLoginFilter implements Filter {



	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest res, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest request = (HttpServletRequest)res;
			User userSession = (User)request.getSession().getAttribute("user");
			if(userSession==null) {
				//接下来要判定是否退出浏览器
				Cookie [] cookies = request.getCookies();
				Cookie loginCookie = Utils.getCookie(cookies, "login");
				if(loginCookie!=null) {
					//浏览器是否为空 
					String cookieValue = loginCookie.getValue();
					String  username = cookieValue.split("#")[0];
					String  password = cookieValue.split("#")[1];
					User newUser = new User();
					newUser.setUsername(username);
					newUser.setPassword(password);
					UserDao dao = new UserDaoImpl();
					User retUser = dao.login(newUser);
					//将相应的值存储到session中 
					request.getSession().setAttribute("user", retUser);
					chain.doFilter(request, response);
					
				}else {
				chain.doFilter(request, response);
				}
				
			}else {
				chain.doFilter(request, response);
			}
	
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			//过滤器出现异常继续放行
			chain.doFilter(res,response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
