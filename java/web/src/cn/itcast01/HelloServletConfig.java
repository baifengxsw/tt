package cn.itcast01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServletConfig extends HttpServlet{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//ServeletCon  ��ȡservlet�����õ�һЩ��Ϣ
			ServletConfig con = getServletConfig();
			//��ȡservletz�����ı��е�servlet-name ���ı�����
			String servletname = con.getServletName();
			System.out.println("servletname:"+servletname);
			//�õ���Ӧ��ʼ��������ֵ
			String address = con.getInitParameter("address");
			System.out.println("address:"+address);
			//�õ���Ӧ��ʼ����������ö��
			Enumeration<String> em = con.getInitParameterNames();
			while (em.hasMoreElements()) {
				String string = (String) em.nextElement();
			
				System.out.println(string);
				
			}
			System.out.println("***************");
			System.out.println(con.getServletContext());
			ServletContext sf = con.getServletContext();
			
			
					
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
		}
}
