package cn.itcast.store.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Order;
import cn.itcast.store.domain.OrderItem;
import cn.itcast.store.domain.User;

public interface OrderDao {

	

	void saveOrder(Connection conn, Order order)throws SQLException;

	void saveOrderItem(Connection conn, OrderItem item)throws SQLException;

	int getTotalRecords(User user)throws SQLException;

	List<Order> findMyOrdersWithPage(User user, int startIndex, int pageSize) throws SQLException;

	Order finOrderByOid(String oid) throws SQLException;

	void updateOrder(Order order) throws SQLException;

	List<Order> findAllOrders(int startNum,int pageSize) throws SQLException;

	int findTotalOrders()throws SQLException;

	int findTotalOrders(int st) throws SQLException;

	List<Order> findAllOrders(int startPage, int pageSize, int st)throws SQLException;

}
