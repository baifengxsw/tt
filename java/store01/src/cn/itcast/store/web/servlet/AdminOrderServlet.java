package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Order;
import cn.itcast.store.domain.PageBean;
import cn.itcast.store.service.OrderService;
import cn.itcast.store.service.serviceImpl.OrderServiceImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class AdminOrderServlet
 */
public class AdminOrderServlet extends BaseServlet {
	public String findOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//让会话消息失效
		//获取到全部订单 
		//将全部订单放入request
		//转发到相应页面
		String st = request.getParameter("state");
		int num = Integer.parseInt(request.getParameter("num"));
		OrderService orderService = new OrderServiceImpl();
		PageBean<Order> pb = null;
		if(null==st||"".equals(st)) {
			try {
				 pb = orderService.findAllOrders(num);
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}else {
			try {
				int stNum = Integer.parseInt(st);
				 pb  = orderService.findAllOrders(num,stNum);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		request.setAttribute("page", pb);
		return "/admin/order/list.jsp";
	}
	public String findOrderByOidWithAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//服务端获取到订单id
		//查询这个订单所有的订单以及订单项对应的
		String oid = request.getParameter("id");
		OrderService orderService = new OrderServiceImpl();
		try {
			Order order = orderService.findOrderByOid(oid);
			//返回相应的JSon字符串
			String jsonStr = JSONArray.fromObject(order.getList()).toString();
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().println(jsonStr);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

}
