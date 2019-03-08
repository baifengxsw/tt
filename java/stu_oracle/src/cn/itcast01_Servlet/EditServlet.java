package cn.itcast01_Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast03_bin.Student;
import cn.itcast06_Service.StudentService;
import cn.itcast06_Service.StudentServiceImpl;

/**
 * ���¶�Ӧ�ļ�¼
 */
public class EditServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//2��ѯѧ������
			int sid = Integer.parseInt(request.getParameter("sid"));
			Student stu = new Student();; 
			StudentService service = new StudentServiceImpl();
			//3��ҳ������ʾĬ������
			System.out.println(stu.getSid());
			stu = service.findDataBySid(sid);
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("editList.jsp").forward(request, response);
			 
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
