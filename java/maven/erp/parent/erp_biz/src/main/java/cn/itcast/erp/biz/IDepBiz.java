package cn.itcast.erp.biz;

import java.util.List;

import cn.itcast.erp.entity.Dep;

public interface IDepBiz {
	public List<Dep> findList();
	public List<Dep> findList(Dep dep1,Dep dep2,Object param,int firstResult,int maxResult);
	public Long getCount(Dep dep1,Dep dep2,Object param);
	/**
	 * 新增用户
	 * @param dep
	 */
	public void add(Dep dep);
	/**
	 * 删除用户
	 * @param dep
	 */
	public void delete(Long uuid);
	/**
	 * 得到某个用户
	 * @param uuid
	 * @return
	 */
	public Dep getDep(long uuid);
	/**
	 * 保存某个用户
	 * @param dep
	 */
	public void update(Dep dep);

}
