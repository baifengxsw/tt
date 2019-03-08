package cn.itcast01_Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast03_bin.User;
import cn.itcast06_Service.UserService;
import cn.itcast06_Service.UserServiceImpl;


/**
 * 这是用于处理登录的servlet
 */
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//提交的数据可能会有中文 ,怎么进行处理 下面针对post方法 ,因为 get方法 无请求体
		User user;
		try {
			request.setCharacterEncoding("UTF-8");
			//对于输出的数据可能存在中文 
			response.setContentType("text/html;charset=UTF-8");
			
			//获取提交的信息
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String auto_login = request.getParameter("auto_login"); //单选按钮 选中会返回on
			
			//数据查询
			UserService us = new UserServiceImpl();
			user = null;
			 user = us.login(username, password);
			 if(user == null){
				 response.getWriter().write("登录失败,请点击重新登录");
				 response.getWriter().write("<a href = 'index.jsp'>重新登录</a>");
			 }else{
				 //这里登录成功
				 response.getWriter().write("登录成功");
				 //在这里进行cookie 设置 
				 System.out.println(auto_login);
				 if(auto_login != null &&auto_login.equals("on")) {
					 
					 System.out.println("我在登录的时候设置cookie");
					 Cookie cookie = new Cookie("login",username+"#"+password);
					 cookie.setMaxAge(5*60+8*60*60);//设置了50s
					 cookie.setPath(request.getContextPath());//设置为当前项目路径
					 response.addCookie(cookie);
				 }
				 //设置会话的属性 
				 request.getSession().setAttribute("user", user);
				 
				 //2;进行页面转换
				 response.sendRedirect("ListServlet");
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
