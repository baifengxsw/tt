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
		//第一次可能没有
		if(cookie == null){
			//1 相应返回cookie
			Cookie c = new Cookie("history",id);
			response.addCookie(c);
			//2 跳转到具体的界面
			
		}else{
			//1获取以前的cookie  包含了相关记录
			
			String ids = cookie.getValue();
			//2;让现在浏览的商品,和以前浏览的商品,形成新的cookie的值
			cookie.setValue(id+"#"+ids);
			response.addCookie(cookie);
			//3跳转
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
