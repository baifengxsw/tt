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
			//�ȶ�request ����ת��
			HttpServletRequest request = (HttpServletRequest)res;
			User userSession = (User)request.getSession().getAttribute("user");
			if(userSession==null) {
				//������Ҫ�ж��Ƿ��˳������
				Cookie [] cookies = request.getCookies();
				Cookie loginCookie = C3P0Utils.getCookie(cookies, "login");


				if(loginCookie!=null) {
					//�����Cookie�Ƿ�Ϊ�� 

					String cookieValue = loginCookie.getValue();
					String  username = cookieValue.split("#")[0];
					String  password = cookieValue.split("#")[1];
					UserService dao = new UserServiceImpl();
					User retUser = dao.login(username,password);
					//���浱ǰ����Ա����Ϣ 
					if(retUser!=null) {
						//�����������ѯ��ȷ�������
					request.getSession().setAttribute("user", retUser);
					//����Ӧ��ֵ�洢��session�� 
					StudentService service = new StudentServiceImpl();
					List<Student>list = service.findAll();
					//�洢���ݲ���תҳ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			//�����������쳣��������
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
