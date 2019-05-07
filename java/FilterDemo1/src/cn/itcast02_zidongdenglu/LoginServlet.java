package cn.itcast02_zidongdenglu;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String auto_login = request.getParameter("auto-login");
			System.out.println(auto_login);
			UserDao dao = new UserDaoImpl();
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			User newUser =  dao.login(user);
			if(newUser!=null) {
				//表明登录成功 设置cookies
				if("on".equals(auto_login)) {
					Cookie cookie = new Cookie("login", username+"#"+password);
					//以s为单位
					cookie.setMaxAge(60);
					//这个是当前项目路径
					cookie.setPath(request.getContextPath());
					//System.out.println(request.getContextPath());
					//cookie.setPath("/FilterDemo1");
					response.addCookie(cookie);
				}
				request.getSession().setAttribute("user", newUser);
				response.sendRedirect("sss.jsp");
				
			}else {
				//表明登录失败
				request.getRequestDispatcher("login.jsp");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
