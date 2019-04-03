package cn.itcast.store.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Order;
import cn.itcast.store.domain.PageBean;
import cn.itcast.store.domain.User;

public interface OrderService {

	void saveOrder(Order order) throws SQLException;

	PageBean<Order> findMyOrdersWithPage(User user, int curNum)throws SQLException;

	Order findOrderByOid(String oid)throws SQLException;

	void updateOrder(Order order) throws SQLException;

	PageBean<Order> findAllOrders(int num)throws SQLException;

	PageBean<Order> findAllOrders(int num, int st) throws SQLException;

}
