package cn.itcast.erp.biz.impl;

import java.util.List;
import java.util.Map;

import cn.itcast.erp.biz.IBaseBiz;
import cn.itcast.erp.dao.IBaseDao;
import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.dao.IGoodsDao;
import cn.itcast.erp.dao.IStoreDao;
import cn.itcast.erp.dao.ISupplierDao;
/**
 * 通用业务逻辑实现类
 * @author Administrator
 *
 * @param <T>
 */
public class BaseBiz<T> implements IBaseBiz<T> {

	/** 数据访问注入*/
	private IBaseDao<T> baseDao;

	public void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	/**
	 * 条件查询
	 * @param t1
	 * @return
	 */
	public List<T> getList(T t1,T t2,Object param){
		return baseDao.getList(t1,t2,param);
	}
	
	/**
	 * 条件查询
	 * @param t1
	 * @return
	 */
	public List<T> getListByPage(T t1,T t2,Object param,int firstResult, int maxResults){
		return baseDao.getListByPage(t1,t2,param,firstResult, maxResults);
	}

	@Override
	public long getCount(T t1,T t2,Object param) {
		return baseDao.getCount(t1,t2,param);
	}

	@Override
	public void add(T t) {
		baseDao.add(t);
	}

	/**
	 * 删除
	 */
	public void delete(Long uuid){
		baseDao.delete(uuid);
	}
	
	/**
	 * 通过编号查询对象
	 * @param uuid
	 * @return
	 */
	public T get(Long uuid){
		return baseDao.get(uuid);
	}
	
	/**
	 * 通过字符串编号查询对象
	 * @param uuid
	 * @return
	 */
	public T get(String uuid){
		return baseDao.get(uuid);
	}
	
	/**
	 * 更新
	 */
	public void update(T t){
		baseDao.update(t);
	}
	
	/**
	 * 获取商品名称
	 * @param uuid
	 * @param goodsNameMap
	 * @param goodsDao
	 * @return
	 */
	public String getGoodsName(Long uuid,Map<Long,String>goodsNameMap,IGoodsDao goodsDao) {
		if(uuid==null) {
			return null;
		}
		//从缓存中根据员工编号取出员工名称
		String goodsName = goodsNameMap.get(uuid);
		if(null==goodsName) {
			//如果没有找到 进行数据库查询
			goodsName = goodsDao.get(uuid).getName();
			//存入相应的缓存中
			goodsNameMap.put(uuid, goodsName);
		}
		return goodsName;
	}
	/**
	 * 获取仓库名称
	 * @param uuid
	 * @param StoreNameMap
	 * @param storeDao
	 * @return
	 */
	public String getStoreName(Long uuid,Map<Long,String>StoreNameMap,IStoreDao storeDao) {
		if(uuid==null) {
			return null;
		}
		
		String storeName = StoreNameMap.get(uuid);
		if(null==storeName) {
		
			storeName = storeDao.get(uuid).getName();
			//存入相应的缓存中
			StoreNameMap.put(uuid,storeName);
		}
		return storeName;
	}
	/**
	 * 获取用户名称
	 * 
	 * @param uuid 用户编号
	 * @param empNameMap 用户的缓存集合 <uuid ,name>
	 * @return 返回用户
	 */
	public String getEmpName(Long uuid ,Map<Long,String>empNameMap,IEmpDao empDao) {
		if(uuid ==null)
			return null;
		if(!empNameMap.containsKey(uuid)) {
			String empName = empDao.get(uuid).getName();
			empNameMap.put(uuid, empName);
			return empName;
		}else {
		return empNameMap.get(uuid);
		}
	}
	
	/**
	 * 获取供应商名称
	 * 
	 * @param uuid 供应商编号
	 * @param empNameMap 供应商的的缓存集合 <uuid ,name>
	 * @return 返回用户
	 */
	public String getSupplierName(Long uuid ,Map<Long,String>supplierNameMap,ISupplierDao supplierDao) {
		if(uuid==null)
			return null;
		if(!supplierNameMap.containsKey(uuid)) {
			String empName = supplierDao.get(uuid).getName();
			supplierNameMap.put(uuid, empName);
			return empName;
		}else {
			return supplierNameMap.get(uuid);
		}
	}

}

