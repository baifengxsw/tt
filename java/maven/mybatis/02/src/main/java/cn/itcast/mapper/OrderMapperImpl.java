package cn.itcast.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.itcast.Order;
import cn.itcast.OrderUser;
import cn.itcast.utils.SqlSessionUtils;

public class OrderMapperImpl {
	/**
	 * 获取所有列表
	 * 
	 */
	@Test
	public void demo1() {
		SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession();
		OrderMapper orderMapper= session.getMapper(OrderMapper.class);
		List<Order> list = orderMapper.getOrderListMap();
		for(Order order:list) {
			System.out.println(order);
		}
		session.close();
	}
	/**测试1 对1 **/
	@Test
	public void demo2() {
		SqlSession session = SqlSessionUtils.getSqlSessionFactory().openSession();
		OrderMapper orderMapper= session.getMapper(OrderMapper.class);
		List<Order> list = orderMapper.getOrderUserList();
		for(Order order:list) {
			System.out.println(order);
		}
		session.close();
	}
	
	
}
