package cn.itcast01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//httpServlet �Ѿ�ʵ������Ӧ�Ľӿ�,����Ӧ�ö�����м̳� 
public class HelloServlet3  extends HttpServlet{
	//@Override
	//һ�㲻д������� 
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("hello servlet 02");
	//}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		System.out.println("do get");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("do post");
	}
}
