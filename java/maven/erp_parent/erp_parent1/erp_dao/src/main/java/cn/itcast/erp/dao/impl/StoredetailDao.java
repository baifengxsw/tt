package cn.itcast.erp.dao.impl;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.dao.IStoredetailDao;
import cn.itcast.erp.entity.Storealert;
import cn.itcast.erp.entity.Storedetail;
/**
 * 仓库库存数据访问类
 * @author Administrator
 *
 */
public class StoredetailDao extends BaseDao<Storedetail> implements IStoredetailDao {

	/**
	 * 构建查询条件
	 * @param dep1
	 * @param dep2
	 * @param param
	 * @return
	 */
	public DetachedCriteria getDetachedCriteria(Storedetail storedetail1,Storedetail storedetail2,Object param){
		DetachedCriteria dc=DetachedCriteria.forClass(Storedetail.class);
		if(storedetail1!=null){
			//根据商品编号进行插叙
			if(null!= storedetail1.getGoodsuuid()) {
				dc.add(Restrictions.eq("goodsuuid", storedetail1.getGoodsuuid()));
			}
			
			//根据仓库编号进行查询
			if(null != storedetail1.getStoreuuid()) {
				dc.add(Restrictions.eq("storeuuid",storedetail1.getStoreuuid()));
			}
		}
		return dc;
	}

	@Override
	public List<Storealert> getStorealertList() {
		return (List<Storealert>)getHibernateTemplate().find("from Storealert where storenum<outnum");
	}

}
