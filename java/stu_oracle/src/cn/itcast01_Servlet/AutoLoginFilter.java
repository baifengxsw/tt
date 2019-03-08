package cn.itcast01_Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.itcast03_bin.Student;
import cn.itcast03_bin.User;
import cn.itcast05_Utils.C3P0Utils;
import cn.itcast06_Service.StudentService;
import cn.itcast06_Service.StudentServiceImpl;
import cn.itcast06_Service.UserService;
import cn.itcast06_Service.UserServiceImpl;

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
			//先对request 进行转换
			HttpServletRequest request = (HttpServletRequest)res;
			User userSession = (User)request.getSession().getAttribute("user");
			if(userSession==null) {
				//接下来要判定是否退出浏览器
				Cookie [] cookies = request.getCookies();
				Cookie loginCookie = C3P0Utils.getCookie(cookies, "login");


				if(loginCookie!=null) {
					//浏览器Cookie是否为空 

					String cookieValue = loginCookie.getValue();
					String  username = cookieValue.split("#")[0];
					String  password = cookieValue.split("#")[1];
					UserService dao = new UserServiceImpl();
					User retUser = dao.login(username,password);
					//保存当前管理员的信息 
					if(retUser!=null) {
						//这里是如果查询正确的情况下
					request.getSession().setAttribute("user", retUser);
					//将相应的值存储到session中 
					StudentService service = new StudentServiceImpl();
					List<Student>list = service.findAll();
					//存储数据并跳转页面
					request.getSession().setAttribute("list", list);
					}
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
