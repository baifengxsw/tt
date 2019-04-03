package cn.itcast.store.service.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.dao.OrderDao;
import cn.itcast.store.dao.DaoImpl.OrderDaoImpl;
import cn.itcast.store.domain.Order;
import cn.itcast.store.domain.OrderItem;
import cn.itcast.store.domain.PageBean;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.OrderService;
import cn.itcast.store.utils.BeanFactory;
import cn.itcast.store.utils.JDBCUtils;

public class OrderServiceImpl implements OrderService {
	private OrderDao dao = (OrderDao) BeanFactory.createObject("OrderDao");
	public void saveOrder(Order order) throws SQLException {
//		try {
//			JDBCUtils.startTransaction();
//			OrderDao dao = new OrderDaoImpl();
//			dao.saveOrder(order);
//			for(OrderItem item:order.getList()) {
//				dao.saveOrderItem(item);
//			}
//			JDBCUtils.commitAndClose();
//		} catch (Exception e) {
//			JDBCUtils.rollbackAndClose();
//		}
		//c3p0 �������ӳص����ӾͲ��ù���  
		Connection conn = null;
		try {
			//��ȡ����
			conn = JDBCUtils.getConnection();
			//��������
			conn.setAutoCommit(false);
			//���涩��
			
			dao.saveOrder(conn,order);
			for(OrderItem item:order.getList()) {
				dao.saveOrderItem(conn,item);
			}
		}catch(Exception e) {
			//
			conn.rollback();
		}
		
	}

	public PageBean<Order> findMyOrdersWithPage(User user, int curNum) throws SQLException {
		//1 ����pageModel����Ŀ�ģ����㲢��Я����ҳ����
		//2��������
		//3����url
		int totalRecords = dao.getTotalRecords(user);
		PageBean<Order> pb = new PageBean<Order>(curNum, totalRecords, 4);
		List<Order> orderList= dao.findMyOrdersWithPage(user,pb.getStartIndex(),pb.getPageSize());
		pb.setData(orderList);
		//������Ӧ��url
		pb.setUrl("OrderServlet?method=findMyOrdersWithPage");
		return pb;
	}

	public Order findOrderByOid(String oid) throws SQLException {
		Order order = dao.finOrderByOid(oid);
		
		return order;
	}

	public void updateOrder(Order order) throws SQLException {
		dao.updateOrder(order);
		return ;
	}

	public PageBean<Order> findAllOrders(int num) throws SQLException {
		int totalRecords = dao.findTotalOrders();
		PageBean<Order> pb = new PageBean<Order>(num, totalRecords, 5);
		List<Order> list =  dao.findAllOrders(pb.getStartPage(),pb.getPageSize());
		pb.setData(list);
		pb.setUrl("AdminOrderServlet?method=findOrders");
		return pb;
	}

	public PageBean<Order> findAllOrders(int num, int st) throws SQLException {
		int totalRecords = dao.findTotalOrders(st);
		PageBean<Order> pb = new PageBean<Order>(num, totalRecords, 5);
		List<Order> list =  dao.findAllOrders(pb.getStartPage(),pb.getPageSize(),st);
		pb.setData(list);
		pb.setUrl("AdminOrderServlet?method=findOrders");
		return pb;
	}

}
