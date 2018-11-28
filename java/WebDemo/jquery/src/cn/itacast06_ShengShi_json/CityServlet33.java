package cn.itacast06_ShengShi_json;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.thoughtworks.xstream.XStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet33 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			//1. ��ȡ����
			int pid = Integer.parseInt(request.getParameter("id"));
			
			//2 �ҳ����еĳ���
			CityDao dao = new CityDaoImpl();
			List<Citys> list = dao.queryCity(pid);
			
			//3. ��list ---> json����
			//JSONArray ---> ������� �� ����  []
			//JSONObject ---> ��ɼ򵥵�����  { name : zhangsan , age:18}
			
			JSONArray jsonArray = JSONArray.fromObject(list);
			String json = jsonArray.toString();
			
			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
