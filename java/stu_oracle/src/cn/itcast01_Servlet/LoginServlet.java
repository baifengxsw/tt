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
 * �������ڴ����¼��servlet
 */
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�ύ�����ݿ��ܻ������� ,��ô���д��� �������post���� ,��Ϊ get���� ��������
		User user;
		try {
			request.setCharacterEncoding("UTF-8");
			//������������ݿ��ܴ������� 
			response.setContentType("text/html;charset=UTF-8");
			
			//��ȡ�ύ����Ϣ
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String auto_login = request.getParameter("auto_login"); //��ѡ��ť ѡ�л᷵��on
			
			//���ݲ�ѯ
			UserService us = new UserServiceImpl();
			user = null;
			 user = us.login(username, password);
			 if(user == null){
				 response.getWriter().write("��¼ʧ��,�������µ�¼");
				 response.getWriter().write("<a href = 'index.jsp'>���µ�¼</a>");
			 }else{
				 //�����¼�ɹ�
				 response.getWriter().write("��¼�ɹ�");
				 //���������cookie ���� 
				 System.out.println(auto_login);
				 if(auto_login != null &&auto_login.equals("on")) {
					 
					 System.out.println("���ڵ�¼��ʱ������cookie");
					 Cookie cookie = new Cookie("login",username+"#"+password);
					 cookie.setMaxAge(5*60+8*60*60);//������50s
					 cookie.setPath(request.getContextPath());//����Ϊ��ǰ��Ŀ·��
					 response.addCookie(cookie);
				 }
				 //���ûỰ������ 
				 request.getSession().setAttribute("user", user);
				 
				 //2;����ҳ��ת��
				 response.sendRedirect("ListServlet");
			 }
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
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
