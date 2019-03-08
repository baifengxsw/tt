package cn.itcast01_Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast03_bin.User;
import cn.itcast06_Service.UserService;
import cn.itcast06_Service.UserServiceImpl;

/**
 * 管理员用户注册
 */
public class USerRegistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				request.setCharacterEncoding("utf-8");
				User user = new User();
				String username = request.getParameter("name");
				String passwordl = request.getParameter("pass");
				user.setUsername(username);
				user.setPassword1(passwordl);
				UserService us = new UserServiceImpl();
				int ret = us.insert(user);
				if(ret>0) {
					request.getRequestDispatcher("SuccessChange.jsp").forward(request, response);;
				}else {
					request.getRequestDispatcher("forbid.jsp").forward(request, response);
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
