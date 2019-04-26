package cn.itcast.erp.biz.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.itcast.erp.biz.IStoredetailBiz;
import cn.itcast.erp.dao.IGoodsDao;
import cn.itcast.erp.dao.IStoreDao;
import cn.itcast.erp.dao.IStoredetailDao;
import cn.itcast.erp.entity.Storedetail;
/**
 * 仓库库存业务逻辑类
 * @author Administrator
 *
 */
public class StoredetailBiz extends BaseBiz<Storedetail> implements IStoredetailBiz {

	private IStoredetailDao storedetailDao;
	private IGoodsDao goodsDao;
	private IStoreDao storeDao;
	
	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	public void setStoreDao(IStoreDao storeDao) {
		this.storeDao = storeDao;
	}
	public void setStoredetailDao(IStoredetailDao storedetailDao) {
		this.storedetailDao = storedetailDao;
		super.setBaseDao(this.storedetailDao);
	}
	/**
	 * 重写分页
	 */
	@Override
	public List<Storedetail> getListByPage(Storedetail t1, Storedetail t2, Object param, int firstResult,
			int maxResults) {
		List<Storedetail> list =  super.getListByPage(t1, t2, param, firstResult, maxResults);
		Map<Long,String> goodsNameMap  = new HashMap<>();
		Map<Long,String> storeNameMap = new HashMap<>();
		for(Storedetail storedetail:list) {
			storedetail.setGoodName(getGoodsName(storedetail.getGoodsuuid(), goodsNameMap,goodsDao));
			storedetail.setStoreName(getStoreName(storedetail.getStoreuuid(), storeNameMap,storeDao));
		}
		
		return list;
		
	}

	
	
}
