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
		//�ûỰ��ϢʧЧ
		//��ȡ��ȫ������ 
		//��ȫ����������request
		//ת������Ӧҳ��
		String st = request.getParameter("state");
		int num = Integer.parseInt(request.getParameter("num"));
		OrderService orderService = new OrderServiceImpl();
		PageBean<Order> pb = null;
		if(null==st||"".equals(st)) {
			try {
				 pb = orderService.findAllOrders(num);
				
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
		}else {
			try {
				int stNum = Integer.parseInt(st);
				 pb  = orderService.findAllOrders(num,stNum);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		request.setAttribute("page", pb);
		return "/admin/order/list.jsp";
	}
	public String findOrderByOidWithAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����˻�ȡ������id
		//��ѯ����������еĶ����Լ��������Ӧ��
		String oid = request.getParameter("id");
		OrderService orderService = new OrderServiceImpl();
		try {
			Order order = orderService.findOrderByOid(oid);
			//������Ӧ��JSon�ַ���
			String jsonStr = JSONArray.fromObject(order.getList()).toString();
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().println(jsonStr);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}

}
