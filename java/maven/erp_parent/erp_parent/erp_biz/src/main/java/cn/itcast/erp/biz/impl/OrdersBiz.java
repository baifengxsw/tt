package cn.itcast.erp.biz.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.itcast.erp.biz.IOrdersBiz;
import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.dao.IOrdersDao;
import cn.itcast.erp.dao.ISupplierDao;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.entity.Orders;
import cn.itcast.erp.exception.ErpException;
/**
 * 订单业务逻辑类
 * @author Administrator
 *
 */
public class OrdersBiz extends BaseBiz<Orders> implements IOrdersBiz {

	private IOrdersDao ordersDao;
	//对每个员工进行查询 注入emp 的dao
	private IEmpDao empDao;
	//还需要查供应商的 ，我们也要将它注入进来
	private ISupplierDao supplierDao;
	
	public void setSupplierDao(ISupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public IEmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}

	public void setOrdersDao(IOrdersDao ordersDao) {
		this.ordersDao = ordersDao;
		super.setBaseDao(this.ordersDao);
	}
	
	public void add(Orders orders) {
		if(orders.getType()==null)
			return ;
		if(orders.getType().equals("1")) {
			//设置订单状态
			orders.setState(Orders.STATE_CREATE);
			//设置订单类型  这里页面传过来
			//orders.setType(Orders.TYPE_IN);
			//下单时间
			orders.setCreatetime(new Date());
			//合计金额
			double total = 0;
			for(Orderdetail detail:orders.getOrderDetails()) {
				//进行金额的统计
				total +=detail.getMoney();
				//明细的状态
				detail.setState(Orderdetail.STATE_IN);
				//设置与订单的关系
				detail.setOrders(orders);
			}
			//设置订单的总金额
			orders.setTotalmoney(total);
			//保存到数据库
			ordersDao.add(orders);
		}
		if(orders.getType().equals("2")) {
			//设置订单状态
			orders.setState(Orders.STATE_NOT_OUT);
			//设置订单类型  这里页面传过来
			//orders.setType(Orders.TYPE_IN);
			//下单时间
			orders.setCreatetime(new Date());
			//合计金额
			double total = 0;
			for(Orderdetail detail:orders.getOrderDetails()) {
				//进行金额的统计
				total +=detail.getMoney();
				//明细的状态
				detail.setState(Orderdetail.STATE_NOT_OUT);
				//设置与订单的关系
				detail.setOrders(orders);
			}
			//设置订单的总金额
			orders.setTotalmoney(total);
			//保存到数据库
			ordersDao.add(orders);
		}
		
	}
	
	public List<Orders> getListByPage(Orders t1, Orders t2, Object param, int firstResult, int maxResults) {
		//获取分页后的订单列表
		// TODO 自动生成的方法存根
		List<Orders> ordersList =  super.getListByPage(t1, t2, param, firstResult, maxResults);
		//缓存员工编号与员工名称 ，key 等于员工编号 ，value 等于员工名称
		Map<Long,String> empNameMap = new HashMap<>();
		Map<Long,String> supplierNameMap = new HashMap<>();
		//循环 ，获取员工的名称
		for(Orders order : ordersList) {
			//添加员工的名称
			order.setCreaterName(getEmpName(order.getCreater(), empNameMap,empDao));
			order.setCheckerName(getEmpName(order.getChecker(),empNameMap,empDao));
			order.setStarterName(getEmpName(order.getStarter(), empNameMap,empDao));
			order.setEnderName(getEmpName(order.getEnder(),empNameMap,empDao));
			//添加供应商的编号
			order.setSupplierName(getSupplierName(order.getSupplieruuid(), supplierNameMap,supplierDao));
		}
		return ordersList;
	}
	

	/**
	 * 实现订单的审核
	 */
	@Override
	public void doCheck(Long uuid, Long empUuid) {
		//1修改订单状态
		//2修改审核的时间
		//3审核人
		//获取订单并进入持久化 对象进行自动的更新
		Orders orders = ordersDao.get(uuid);
		//如果不是未审核的 直接抛出相应的异常
		if(!Orders.STATE_CREATE.equals(orders.getState())) {
			throw new ErpException("亲，该订单已经审核过");
			
		}
		orders.setState(Orders.STATE_CHECK);
		orders.setChecktime(new Date());
		//设置审核人
		orders.setChecker(empUuid);
		
	}

	@Override
	public void doStart(Long uuid, Long empUuid) {
		//1修改订单状态
		//2修改审核的时间
		//3审核人
		//获取订单并进入持久化 对象进行自动的更新
		Orders orders = ordersDao.get(uuid);
		//如果不是未审核的 直接抛出相应的异常
		if(!Orders.STATE_CHECK.equals(orders.getState())) {
			throw new ErpException("亲，该订单已经确认过过");
			
		}
		orders.setState(Orders.STATE_START);
		orders.setStarttime(new Date());
		orders.setStarter(empUuid);
		
		
	}
	

	
}
