package cn.itcast.mapper;

import java.util.List;

import cn.itcast.Order;
import cn.itcast.OrderUser;

/**
 * 订单的持久化接口
 * @author baifeng
 *
 */
public interface OrderMapper {
	/**
	 * 获取订单列表
	 * @return
	 */
	List<Order> getOrderList();	
	/**
	 * 获取订单列表
	 * @return
	 */
	List<Order> getOrderListMap();	
	List<Order> getOrderUserList();	
	
	
}
