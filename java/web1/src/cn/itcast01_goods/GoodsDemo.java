package cn.itcast01_goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoodsDemo
 */
public class GoodsDemo extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Cookie [] cookies = request.getCookies();
		Cookie  cookie = CookieUtil.findCookie(cookies, "history");
		//��һ�ο���û��
		if(cookie == null){
			//1 ��Ӧ����cookie
			Cookie c = new Cookie("history",id);
			response.addCookie(c);
			//2 ��ת������Ľ���
			
		}else{
			//1��ȡ��ǰ��cookie  ��������ؼ�¼
			
			String ids = cookie.getValue();
			//2;�������������Ʒ,����ǰ�������Ʒ,�γ��µ�cookie��ֵ
			cookie.setValue(id+"#"+ids);
			response.addCookie(cookie);
			//3��ת
		}
		response.sendRedirect("product_info.htm");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
