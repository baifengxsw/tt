package cn.itcast01_Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast03_bin.Student;
import cn.itcast05_Utils.C3P0Utils;
import cn.itcast06_Service.StudentService;
import cn.itcast06_Service.StudentServiceImpl;

/**
 * 更新一条数据记录
 */
public class UpdateServlet extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//这边必须要传一个id过来 
		int sid =  Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String [] hobbys = request.getParameterValues("hobby");
		String hobby = C3P0Utils.getHobbies(hobbys);
		
		String info = request.getParameter("info");
		// 添加到数据库
		Date date =null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sid,sname,gender,phone,hobby,info,date);
			StudentService service = new StudentServiceImpl();
			int ret = service.update(student);
		
			request.getRequestDispatcher("ListServlet").forward(request, response);;
		} catch (Exception e) {
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
