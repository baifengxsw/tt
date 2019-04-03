package cn.itcast.store.dao.DaoImpl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.codegen.bean.BeangenUtils;

import cn.itcast.store.dao.OrderDao;
import cn.itcast.store.domain.Order;
import cn.itcast.store.domain.OrderItem;
import cn.itcast.store.domain.Product;
import cn.itcast.store.domain.User;
import cn.itcast.store.utils.JDBCUtils;

public class OrderDaoImpl implements OrderDao {



	public void saveOrder(Connection conn, Order order) throws SQLException {
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object [] params = {order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid()};
		qr.update(sql,params);
	}

	public void saveOrderItem(Connection conn, OrderItem item) throws SQLException {
		String sql = "insert into orderitem values(?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object [] params = {item.getItemid(),item.getQuantity(),item.getTotal(),item.getProduct().getPid(),item.getOrder().getOid()};
		qr.update(sql,params);
	}

	public int getTotalRecords(User user) throws SQLException {
		String sql = "select count(*) from orders where uid = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		Long ret = (Long)qr.query(sql, new ScalarHandler(),user.getUid());
		return ret.intValue();
	}

	public List<Order> findMyOrdersWithPage(User user, int startIndex, int pageSize) throws SQLException {
		String sql = "select * from orders where uid = ? limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Order> list = qr.query(sql, new BeanListHandler<Order>(Order.class),user.getUid(),startIndex,pageSize);
		//遍历所有的订单
		//由于返回的数据是来自多个表 ，多行数据MapListHandle人封装返回的数据
		for(Order order:list) {
			sql = "select * from orderItem o ,product p where o.pid = p.pid and oid=?";
			List<Map<String,Object>> list01 = qr.query(sql, new MapListHandler(),order.getOid());
			//遍历每一行数据
			for(Map<String,Object> map :list01) {
				OrderItem orderItem = new OrderItem();
				Product product = new Product();
				//创建时间类型的转换器
				DateConverter dt = new DateConverter();
				//设置转换的格式
				dt.setPattern("yyyy-MM-dd");
				//注册转换器
				ConvertUtils.register(dt, java.util.Date.class);
				try {
					BeanUtils.populate(orderItem, map);
					BeanUtils.populate(product, map);
				} catch (IllegalAccessException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				orderItem.setProduct(product);
				order.getList().add(orderItem);
			}
		}
		
		return list;
		
	}

	public Order finOrderByOid(String oid) throws SQLException {
		String sql = "select * from orders where oid = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		Order order =  qr.query(sql, new BeanHandler<Order>(Order.class),oid);
		sql = "select * from orderItem o ,product p where o.pid = p.pid and oid=?";
		List<Map<String,Object>> list01 = qr.query(sql, new MapListHandler(),order.getOid());
		//遍历每一行数据
		for(Map<String,Object> map :list01) {
			OrderItem orderItem = new OrderItem();
			Product product = new Product();
			//创建时间类型的转换器
			DateConverter dt = new DateConverter();
			//设置转换的格式
			dt.setPattern("yyyy-MM-dd");
			//注册转换器
			ConvertUtils.register(dt, java.util.Date.class);
			try {
				BeanUtils.populate(orderItem, map);
				BeanUtils.populate(product, map);
			} catch (IllegalAccessException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			orderItem.setProduct(product);
			order.getList().add(orderItem);
		}
		return order;
	}

	public void updateOrder(Order order) throws SQLException {
		String sql = "update orders set ordertime=?,total=?,state=?,address=?,name=?,telephone=? where oid = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object [] params = {order.getOrdertime(),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getOid()};
		qr.update(sql ,params);
		
		
	}

	public List<Order> findAllOrders(int startNum,int pageSize) throws SQLException {
		String sql = "select * from orders limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Order>(Order.class),startNum,pageSize);
		
	}

	public int findTotalOrders() throws SQLException {
		String sql = "select count(*) from orders";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long ret = (Long)qr.query(sql, new ScalarHandler());
		return ret.intValue();
	
	}

	public int findTotalOrders(int st) throws SQLException {
		String sql = "select count(*) from orders where state=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long ret = (Long)qr.query(sql, new ScalarHandler(),st);
		return ret.intValue();
	}

	public List<Order> findAllOrders(int startPage, int pageSize, int st) throws SQLException {
		String sql = "select * from orders where state=? limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Order>(Order.class),st,startPage,pageSize);
		
	}
	}


