package cn.itcast01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo03
 */
public class ServletDemo03 extends BaseServlet {
	public String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���ѧ��");
		return "text.html";
	}
	public String checkStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���ѧ��");
		return null;
	}
	public String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ɾ��ѧ��");
		return "text.html";
	}
}
