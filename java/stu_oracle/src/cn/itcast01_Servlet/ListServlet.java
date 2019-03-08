package cn.itcast01_Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast02_Dao.StudentDao;
import cn.itcast03_bin.Student;
import cn.itcast04_DaoImpl.StudentDaoImpl;
import cn.itcast06_Service.StudentService;
import cn.itcast06_Service.StudentServiceImpl;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	

	/**
	 * ��ѯ���е�ҳ����Ϣ ���ֵ��µ�ҳ����
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			StudentService service = new StudentServiceImpl();
			List<Student>list = service.findAll();
			//�洢���ݲ���תҳ��
			request.getSession().setAttribute("list", list);
			response.sendRedirect("list.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
