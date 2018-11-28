package cn.itcast05_ShengShi_xml;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1��ȡ����
			int id = Integer.parseInt(request.getParameter("id"));
			CityDao dao = new CityDaoImpl();
			//2�ҳ����г���
			List <Citys> list = dao.queryCity(id);
			//3��������,��xml��ʽ  ʹ��xStream ����ת��
			XStream xStream = new XStream();
			//���ñ���
			xStream.alias("city", Citys.class);
			
			//��id��������
			//xStream.useAttributeFor(Citys.class, "id");
			String xml = xStream.toXML(list);
			System.out.println("xml:"+xml);
			//��ע������ط��� text/xml
			System.out.println("dsfsd");
			response.setContentType("text/xml;charset=UTF-8");
			response.getWriter().write(xml);
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
