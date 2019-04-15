package cn.itcast.erp.dao;

import java.util.List;

import cn.itcast.erp.entity.Dep;

public interface IDepDao {
	public List<Dep> findList();
	public List<Dep> findList(Dep dep1 , Dep dep2, Object param,int firstResult,int maxResult);
	//得到相关数据的长度
	long getCount(Dep dep1,Dep dep2,Object param);
	/**
	 * 新增用户
	 * @param dep
	 */
	public void add(Dep dep);
	/**
	 * 删除用户
	 */
	public void delete(Long uuid);
	/**
	 * 查询用户
	 * @param uuid
	 * @return
	 */
	public Dep getDep(Long uuid);
	
	public void update(Dep dep);
	
}
