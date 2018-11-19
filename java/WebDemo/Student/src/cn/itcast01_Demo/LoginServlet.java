package cn.itcast01_Demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast02_dao.StuDao;
import cn.itcast02_dao.UserDao;
import cn.itcast03_bin.Student;
import cn.itcast04_Impl.StuDaoImpl;
import cn.itcast04_Impl.UserDaoImpl;

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
		request.setCharacterEncoding("UTF-8");
		//������������ݿ��ܴ������� 
		response.setContentType("text/html;charset=UTF-8");
		
		//��ȡ�ύ����Ϣ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//���ݲ�ѯ
		UserDao ud = new UserDaoImpl();
		boolean flag = ud.login(username, password);
		if(!flag){
			response.getWriter().write("��¼ʧ��,�������·��ص�¼ҳ��");
		}else{
			//�����¼�ɹ�
			response.getWriter().write("��¼�ɹ�");
			//1 �Ƚ������ݲ�ѯ 
			StuDao sdao = new StuDaoImpl();
			List <Student>list = sdao.findAll();  //������ݴ��߷ǳ��鷳 ���Կ��Ǵ�����������
			//ʹ��session �洢
			request.getSession().setAttribute("list", list);
			//2;����ҳ��ת��
			response.sendRedirect("list.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("1123");
		doGet(request, response);
	}

}
