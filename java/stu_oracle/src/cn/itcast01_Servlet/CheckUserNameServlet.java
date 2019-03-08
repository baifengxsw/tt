package cn.itcast01_Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.itcast06_Service.UserService;
import cn.itcast06_Service.UserServiceImpl;

/**
 * Servlet implementation class CheckUsernameServlet
 */
public class CheckUserNameServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			
			UserService dao = new UserServiceImpl();
			boolean isExit = false;
			System.out.println("�ұ�������");
			try {
				isExit = dao.checkUserName(name);
				if(isExit){
					//д���ַ���1  response.getWriter().Writer("1");
					//д������
					response.getWriter().println(1);
				}else{
					response.getWriter().println(0); //�������ڸ��û�
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
