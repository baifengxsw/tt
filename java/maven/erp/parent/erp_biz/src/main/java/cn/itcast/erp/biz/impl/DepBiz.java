package cn.itcast.erp.biz.impl;

import java.util.List;

import cn.itcast.erp.biz.IDepBiz;
import cn.itcast.erp.dao.IDepDao;

import cn.itcast.erp.entity.Dep;

public class DepBiz implements IDepBiz {
	private IDepDao depDao;

	public void setDepDao(IDepDao depDao) {
		this.depDao = depDao;
	}

	@Override
	public List<Dep> findList() {
		return depDao.findList();
	
	}
	/**
	 * 实现条件查询
	 */
	@Override
	public List<Dep> findList(Dep dep1,Dep dep2,Object param ,int firstResult,int maxResult) {
		
		return depDao.findList(dep1,dep2,param,firstResult,maxResult);
	}

	@Override
	public Long getCount(Dep dep1 ,Dep dep2,Object param) {
		return depDao.getCount(dep1 ,dep2,param);
	}

	@Override
	public void add(Dep dep) {
		 depDao.add(dep);
		
	}

	@Override
	public void delete(Long uuid) {
		depDao.delete(uuid);
		
	}

	@Override
	public Dep getDep(long uuid) {
		return depDao.getDep(uuid);
	}

	@Override
	public void update(Dep dep) {
		depDao.update(dep);
		
	}
	
	
	

}
