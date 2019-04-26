package cn.itcast.erp.biz.impl;
import java.util.Date;
import java.util.List;

import cn.itcast.erp.biz.IOrderdetailBiz;
import cn.itcast.erp.dao.IOrderdetailDao;
import cn.itcast.erp.dao.IStoredetailDao;
import cn.itcast.erp.dao.IStoreoperDao;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.entity.Orders;
import cn.itcast.erp.entity.Storedetail;
import cn.itcast.erp.entity.Storeoper;
import cn.itcast.erp.exception.ErpException;
/**
 * 订单明细业务逻辑类
 * @author Administrator
 *
 */
public class OrderdetailBiz extends BaseBiz<Orderdetail> implements IOrderdetailBiz {

	private IOrderdetailDao orderdetailDao;
	//仓库明细表
	private IStoredetailDao storedetailDao;
	public void setStoredetailDao(IStoredetailDao storedetailDao) {
		this.storedetailDao = storedetailDao;
	}
	public void setStoreoperDao(IStoreoperDao storeoperDao) {
		this.storeoperDao = storeoperDao;
	}
	//仓库记录表
	private IStoreoperDao storeoperDao;
	
	public void setOrderdetailDao(IOrderdetailDao orderdetailDao) {
		this.orderdetailDao = orderdetailDao;
		super.setBaseDao(this.orderdetailDao);
	}
	/**
	 * 进行相应的入库操作
	 * @param uuid  订单明细id
	 * @param storeuuid 仓库编号
	 * @param empuuid 操作人
	 */
	public void doInStore(Long uuid,Long storeuuid,Long empuuid) {
		//1；获取相应的明细信息
		Orderdetail detail = orderdetailDao.get(uuid);
		//判断明细的状态，一定是未入库的 考虑并发条件
		if(!Orderdetail.STATE_NOT_IN.equals(detail.getState())) {
			throw new ErpException("不能重复的入库");
			
		}
		//3；修改状态为已入库
		detail.setState(Orderdetail.STATE_IN);
		//4.入库时间
		detail.setEnder(empuuid);
		//5设置库管员
		detail.setEndtime(new Date());
		//6 入到哪个仓库
		detail.setStoreuuid(storeuuid);
		
		// 更新库存信息
		//查询条件 这里订单
		Storedetail storedetail = new Storedetail();
		storedetail.setGoodsuuid(detail.getGoodsuuid());
		storedetail.setStoreuuid(storeuuid);
		List<Storedetail>storeList = storedetailDao.getList(storedetail, null, null);
		if(storeList.size()>0) {
			long num = 0;  
			//防止num为空的情况
			if(storeList.get(0).getNum()!=null) {
				num = storeList.get(0).getNum().longValue();
			}
			storeList.get(0).setNum(num+detail.getNum());
		}else {
			//这边没有找到 肯定会是游离态
			storedetail.setNum(detail.getNum());
			storedetailDao.add(storedetail);
		}
		
		//3增加操作记录
		Storeoper log = new Storeoper();
		log.setEmpuuid(empuuid);
		log.setNum(detail.getNum());
		log.setGoodsuuid(detail.getGoodsuuid());
		log.setOpertime(detail.getEndtime());
		log.setStoreuuid(storeuuid);
		log.setType(Storeoper.TYPE_IN);
		storeoperDao.add(log);
		
		//4 判断当前所有的订单下面的商品信息 是否都已经入库了  如果入库 取消 相应
		//查询订单下是否存在状态为0的明细
		//count(1) where state =0 and orderuuid= 查询明细表
		//通过BaseDao 中的getCount 查询所有的记录数 ，如果没有记录表示都已经入完库了
		
		//建立查询条件
		Orderdetail orderdetail = new Orderdetail();
		Orders orders = detail.getOrders();
		orderdetail.setOrders(orders);
		orderdetail.setState(Orderdetail.STATE_NOT_IN);
		long count= orderdetailDao.getCount(orderdetail, null, null);
		if(count == 0) {
			//代表所有的明细已经入库
			//之前的getdetail 然后再 得到相应的 订单 ，那么订单也进入持久化状态
			orders.setState(Orders.STATE_END);
			orders.setEndtime(detail.getEndtime());
			orders.setEnder(empuuid);
		}
		
		
	}
	/**
	 * 实现相应的出库操作
	 */
	@Override
	public void doOutStore(Long uuid, Long storeuuid, Long empuuid) {
		//1；获取相应的明细信息
		Orderdetail detail = orderdetailDao.get(uuid);
		//判断明细的状态，一定是未入库的 考虑并发条件
		if(!Orderdetail.STATE_NOT_OUT.equals(detail.getState())) {
			throw new ErpException("不能重复的出库");
			
		}
		//3；修改状态为已出库库
		detail.setState(Orderdetail.STATE_OUT);
		//4.入库时间
		detail.setEnder(empuuid);
		//5设置库管员
		detail.setEndtime(new Date());
		//6 入到哪个仓库
		detail.setStoreuuid(storeuuid);
		
		// 更新库存信息
		//查询条件 这里订单
		Storedetail storedetail = new Storedetail();
		storedetail.setGoodsuuid(detail.getGoodsuuid());
		storedetail.setStoreuuid(storeuuid);
		List<Storedetail>storeList = storedetailDao.getList(storedetail, null, null);
		if(storeList.size()>0) {
			//如果存在，则减少它的数量
			Storedetail sd = storeList.get(0);
			sd.setNum(sd.getNum()-detail.getNum());
			//爆出异常 事务发生回滚
			if(sd.getNum()<0) {
				throw new ErpException("库存不足");
			}
		}else {
			throw new ErpException("库存中不存在该商品");
		}
		
		//3增加操作记录
		Storeoper log = new Storeoper();
		log.setEmpuuid(empuuid);
		log.setNum(detail.getNum());
		log.setGoodsuuid(detail.getGoodsuuid());
		log.setOpertime(detail.getEndtime());
		log.setStoreuuid(storeuuid);
		log.setType(Storeoper.TYPE_OUT);
		storeoperDao.add(log);
		
		//4 判断当前所有的订单下面的商品信息 是否都已经入库了  如果入库 取消 相应
		//查询订单下是否存在状态为0的明细
		//count(1) where state =0 and orderuuid= 查询明细表
		//通过BaseDao 中的getCount 查询所有的记录数 ，如果没有记录表示都已经入完库了
		
		//建立查询条件
		Orderdetail orderdetail = new Orderdetail();
		Orders orders = detail.getOrders();
		orderdetail.setOrders(orders);
		orderdetail.setState(Orderdetail.STATE_NOT_OUT);
		long count= orderdetailDao.getCount(orderdetail, null, null);
		if(count == 0) {
			//代表所有的明细已经入库
			//之前的getdetail 然后再 得到相应的 订单 ，那么订单也进入持久化状态
			orders.setState(Orders.STATE_OUT);
			orders.setEndtime(detail.getEndtime());
			orders.setEnder(empuuid);
		}
		
	}
	
}
