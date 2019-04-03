package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Cart;
import cn.itcast.store.domain.CartItem;
import cn.itcast.store.domain.Order;
import cn.itcast.store.domain.OrderItem;
import cn.itcast.store.domain.PageBean;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.OrderService;
import cn.itcast.store.service.serviceImpl.OrderServiceImpl;
import cn.itcast.store.utils.PaymentUtil;
import cn.itcast.store.utils.UUIDUtils;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends BaseServlet {
//saveOrder
	//�����ﳵ�е���Ϣ�Զ�������ʽ���б���
	public String saveOrder (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȷ���û���¼����
		User user = (User)request.getSession().getAttribute("login");
		if(null==user) {
			request.setAttribute("msg", "���¼�����µ�");
			return "/jsp/info.jsp";
		}
		
		//������������Ϊ��������ֵ
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		Order order = new Order();
		order.setOid(UUIDUtils.getCode());
		order.setOrdertime(new Date());
		order.setTotal(cart.getTotal());
		order.setState(1);
		order.setUser(user);
		
		//����������  �����������ͬʱ �����������Ϊ�����ֵ
		for(CartItem item:cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItemid(UUIDUtils.getCode());
			orderItem.setQuantity(item.getNum());
			orderItem.setTotal(item.getSubTotal());
			orderItem.setProduct(item.getProduct());
			orderItem.setOrder(order);
			order.getList().add(orderItem);
		}
		
		//����ҵ��㹦�ܣ����涩���������ݣ��û����ݣ����������еĶ���
		OrderService orderService = new OrderServiceImpl();
		try {
			orderService.saveOrder(order);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		//��չ��ﳵ
		cart.clearCart();
		//request 
		request.setAttribute("order", order);
		return "/jsp/order_info.jsp";
		//ת��
	}
	//findMyOrdersWithPage
	public String findMyOrdersWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�û���Ϣ
		//����ҵ��㹦��:��ѯ��ǰ�û�������Ϣ ������pageModel
		//��pageModel ����request
		//ת����/jsp/order_list.jsp
		User user = (User) request.getSession().getAttribute("login");
		//��ȡ��ǰҳ
		int curNum = Integer.parseInt(request.getParameter("num"));
		OrderService orderService = new OrderServiceImpl();
		PageBean<Order> pm = null;
		try {
			pm = orderService.findMyOrdersWithPage(user,curNum);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//�ڶ���Լ��
		request.setAttribute("page", pm);
		
		return "/jsp/order_list.jsp";
	}
//findOrderByOid
	public String findOrderByOid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ������oid
		//����ҵ��㹦�ܣ����ݶ�����Ų�ѯ������Ϣ
		//����������request
		//ת����/jsp/order_info.jsp;
		String oid = request.getParameter("oid");
		OrderService orderService = new OrderServiceImpl();
		Order order = null;
		try {
			order = orderService.findOrderByOid(oid);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		request.setAttribute("order", order);
		return "/jsp/order_info.jsp";
		
	}
	public String payOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����oid ���ջ��˵�ַ���������绰������
		//���¶������ջ��˵ĵ�ַ�����绰
		//���ױ�֧�����Ͳ���
		String oid = request.getParameter("oid");
		String address = request.getParameter("address");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String pd_FrpId = request.getParameter("pd_FrpId");
		
		OrderService orderService = new OrderServiceImpl();
		
		try {
			Order order = orderService.findOrderByOid(oid);
			order.setName(name);
			order.setTelephone(telephone);
			order.setAddress(address);
			orderService.updateOrder(order);
			// �Ѹ�������Ҫ�Ĳ���׼����:
			String p0_Cmd = "Buy";
			//�̻����
			String p1_MerId = "10001126856";
			//�������
			String p2_Order = oid;
			//���
			String p3_Amt = "0.01";
			String p4_Cur = "CNY";
			String p5_Pid = "";
			String p6_Pcat = "";
			String p7_Pdesc = "";
			//������Ӧ������Servlet
			String p8_Url = "http://localhost:8080/store01/OrderServlet?method=callBack";
			String p9_SAF = "";
			String pa_MP = "";
			String pr_NeedResponse = "1";
			//��˾����Կ
			String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
				
			//�����ױ��ļ����㷨,���������ݽ��м���,���ص���ǩ��
			String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
					
			StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
			sb.append("p0_Cmd=").append(p0_Cmd).append("&");
			sb.append("p1_MerId=").append(p1_MerId).append("&");
			sb.append("p2_Order=").append(p2_Order).append("&");
			sb.append("p3_Amt=").append(p3_Amt).append("&");
			sb.append("p4_Cur=").append(p4_Cur).append("&");
			sb.append("p5_Pid=").append(p5_Pid).append("&");
			sb.append("p6_Pcat=").append(p6_Pcat).append("&");
			sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
			sb.append("p8_Url=").append(p8_Url).append("&");
			sb.append("p9_SAF=").append(p9_SAF).append("&");
			sb.append("pa_MP=").append(pa_MP).append("&");
			sb.append("pd_FrpId=").append(pd_FrpId).append("&");
			sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
			sb.append("hmac=").append(hmac);

			System.out.println(sb.toString());
			// ʹ���ض���
			response.sendRedirect(sb.toString());
			return null;
			//response.sendRedirect("https://www.yeepay.com/app-merchant-proxy/node?p0_cmd=Buy&p1_MerId=111111&k1=v1&k2=v2");
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;

		
		
	}
	public String callBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ױ�֧��������
		//��֤���ݵĺϷ���
		//���֧���ɹ������¶���״̬
		//��request������ʾ��Ϣ
		//ת����/jsp/info.jsp;
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");
		String rb_BankId = request.getParameter("rb_BankId");
		String ro_BankOrderId = request.getParameter("ro_BankOrderId");
		String rp_PayDate = request.getParameter("rp_PayDate");
		String rq_CardNo = request.getParameter("rq_CardNo");
		String ru_Trxtime = request.getParameter("ru_Trxtime");

		// hmac
		String hmac = request.getParameter("hmac");
		// ���ñ�����Կ�ͼ����㷨 ��������
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
				r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
				r8_MP, r9_BType, keyValue);
		if (isValid) {
			// ��Ч
			if (r9_BType.equals("1")) {
				// ������ض���
				//֧���ɹ� �����¶���״̬
				OrderService orderService = new OrderServiceImpl();
				try {
					Order order = orderService.findOrderByOid(r6_Order);
					order.setState(2);
					orderService.updateOrder(order);
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				request.setAttribute("msg","֧���ɹ��������ţ�" + r6_Order + "��" + r3_Amt);
				return "/jsp/info.jsp";
			} else if (r9_BType.equals("2")) {
				// �޸Ķ���״̬:
				// ��������Ե㣬�������ױ���֪ͨ
				System.out.println("�յ��ױ�֪ͨ���޸Ķ���״̬��");//
				// �ظ����ױ�success��������ظ����ױ���һֱ֪ͨ
				response.getWriter().print("success");
			}

		} else {
			throw new RuntimeException("���ݱ��۸ģ�");
		}
		return null;
		
	}



}
