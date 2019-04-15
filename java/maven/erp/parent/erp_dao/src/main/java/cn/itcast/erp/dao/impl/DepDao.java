package cn.itcast.erp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.erp.dao.IDepDao;
import cn.itcast.erp.entity.Dep;
/**
 * 部门的数据访问层
 * @author baifeng
 *
 */
public class DepDao  extends HibernateDaoSupport implements IDepDao {
	
	/**
	 * 查询所有的配置信息
	 */
	@Override
	public List<Dep> findList() {
		List<Dep> list = (List<Dep>) this.getHibernateTemplate().find("from Dep");
		return list; 
	}

	@Override
	public List<Dep> findList(Dep dep1 , Dep dep2,Object param,int firstResult, int maxResult) {
		DetachedCriteria dc  = getDetachedCriteria(dep1);
		
		return (List<Dep>) this.getHibernateTemplate().findByCriteria(dc ,firstResult,maxResult);
	}

	@Override
	public long getCount(Dep dep1,Dep dep2,Object param) {
		DetachedCriteria dc = getDetachedCriteria(dep1);
		dc.setProjection(Projections.rowCount());
		return (Long)this.getHibernateTemplate().findByCriteria(dc).get(0);
	}
	
	private DetachedCriteria getDetachedCriteria(Dep dep1) {
		DetachedCriteria dc  = DetachedCriteria.forClass(Dep.class);
		if(dep1!=null) {
			if(dep1.getName()!=null&&dep1.getName().trim().length()>0){
				/**anywhere %name%
				 * end %name
				 * start name%
				 */
				dc.add(Restrictions.like("name", dep1.getName(), MatchMode.ANYWHERE));
			}
			if(dep1.getTele()!=null&&dep1.getTele().trim().length()>0) {
				dc.add(Restrictions.like("tele", dep1.getTele(), MatchMode.ANYWHERE));
			}
		}
		return dc;
	}
	/**
	 * 新增用户
	 */
	@Override
	public void add(Dep dep) {
		this.getHibernateTemplate().save(dep);
		
	}
	/**
	 * 删除相应的用户
	 */
	@Override
	public void delete(Long uuid) {
		//让对象进入持久化
		Dep dep = this.getHibernateTemplate().get(Dep.class, uuid);
		this.getHibernateTemplate().delete(dep);
		
	}

	@Override
	public Dep getDep(Long uuid) {
		return this.getHibernateTemplate().get(Dep.class, uuid);
	}

	@Override
	public void update(Dep dep) {
		this.getHibernateTemplate().update(dep);
		
	}
	
	

}
