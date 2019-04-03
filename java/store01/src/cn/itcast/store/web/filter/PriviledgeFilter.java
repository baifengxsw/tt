package cn.itcast.store.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.itcast.store.domain.User;

/**
 * Servlet Filter implementation class PriviledgeFilter
 */
public class PriviledgeFilter implements Filter {

    public PriviledgeFilter() {
    }

	
	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//判断当前的session 是否存在已经登录成功的用户
		//如果存在就放行
		//如果不存在，就过滤 转入相应的提示页面
		HttpServletRequest myReq = (HttpServletRequest)request;
		User user = (User)myReq.getSession().getAttribute("login");
		if(null!=user) {
		chain.doFilter(request, response);
		}else {
			myReq.setAttribute("msg", "请先登录");
			myReq.getRequestDispatcher("/jsp/info.jsp").forward(request, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
