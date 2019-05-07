package cn.itcast.erp.biz.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.itcast.erp.biz.IStoreoperBiz;
import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.dao.IGoodsDao;
import cn.itcast.erp.dao.IStoreDao;
import cn.itcast.erp.dao.IStoreoperDao;
import cn.itcast.erp.entity.Storeoper;
/**
 * 仓库操作记录业务逻辑类
 * @author Administrator
 *
 */
public class StoreoperBiz extends BaseBiz<Storeoper> implements IStoreoperBiz {

	private IStoreoperDao storeoperDao;
	private IEmpDao empDao;
	private IStoreDao storeDao;
	private IGoodsDao goodsDao;
	
	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}

	public void setStoreDao(IStoreDao storeDao) {
		this.storeDao = storeDao;
	}

	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public void setStoreoperDao(IStoreoperDao storeoperDao) {
		this.storeoperDao = storeoperDao;
		super.setBaseDao(this.storeoperDao);
	}

	@Override
	public List<Storeoper> getListByPage(Storeoper t1, Storeoper t2, Object param, int firstResult, int maxResults) {
		
		List<Storeoper> list =  super.getListByPage(t1, t2, param, firstResult, maxResults);
		Map<Long,String> empNameMap  = new HashMap<>();
		Map<Long,String> goodsNameMap  = new HashMap<>();
		Map<Long,String> storeNameMap  = new HashMap<>();
		
		for(Storeoper so:list) {
			so.setEmpName(getEmpName(so.getEmpuuid(), empNameMap, empDao));
			so.setGoodsName(getGoodsName(so.getGoodsuuid(), goodsNameMap, goodsDao));
			so.setStoreName(getStoreName(so.getStoreuuid(), storeNameMap, storeDao));
		}
		return list;
	}
	
	
	
}
