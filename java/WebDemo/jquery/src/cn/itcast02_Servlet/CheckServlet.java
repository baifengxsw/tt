package cn.itcast02_Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast01.UserDao;
import cn.itcast01.UserDaoImpl;


/**
 * Servlet implementation class CheckUsernameServlet
 */
public class CheckServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			
			UserDao dao = new UserDaoImpl();
			boolean isExit = false;
			try {
				isExit = dao.checkUserName(name);
				if(isExit){
					//写入字符串1  response.getWriter().Writer("1");
					//写入数字
					response.getWriter().println(1);
				}else{
					response.getWriter().println(0); //代表不存在该用户
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
