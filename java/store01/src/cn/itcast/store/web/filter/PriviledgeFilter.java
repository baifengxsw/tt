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
		
		//�жϵ�ǰ��session �Ƿ�����Ѿ���¼�ɹ����û�
		//������ھͷ���
		//��������ڣ��͹��� ת����Ӧ����ʾҳ��
		HttpServletRequest myReq = (HttpServletRequest)request;
		User user = (User)myReq.getSession().getAttribute("login");
		if(null!=user) {
		chain.doFilter(request, response);
		}else {
			myReq.setAttribute("msg", "���ȵ�¼");
			myReq.getRequestDispatcher("/jsp/info.jsp").forward(request, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
