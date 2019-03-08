package cn.itcast01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo
 */
public class ServletDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		String retAddress = null;
		if("addStu".equals(method)) {
			retAddress =addStu(request,response);
		}else if("checkStu".equals(method)) {
			retAddress = checkStu(request,response);
		}else if("delStu".equals(method)) {
			retAddress = delStu(request,response);
		}
		System.out.println("retAddress:"+retAddress);
		System.out.println("path:"+request.getContextPath());
		if(retAddress!=null) {
			request.getRequestDispatcher(retAddress).forward(request, response);;
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	protected String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("添加学生");
		return "text.html";
	}
	protected String checkStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("检查学生");
		return null;
	}
	protected String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("删除学生");
		return "text.html";
	}
		
	


}
