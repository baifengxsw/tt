package cn.itcast.erp.dao.impl;
import java.util.Calendar;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.dao.IStoreoperDao;
import cn.itcast.erp.entity.Storeoper;
/**
 * 仓库操作记录数据访问类
 * @author Administrator
 *
 */
public class StoreoperDao extends BaseDao<Storeoper> implements IStoreoperDao {

	/**
	 * 构建查询条件
	 * @param dep1
	 * @param dep2
	 * @param param
	 * @return
	 */
	public DetachedCriteria getDetachedCriteria(Storeoper storeoper1,Storeoper storeoper2,Object param){
		DetachedCriteria dc=DetachedCriteria.forClass(Storeoper.class);
		if(storeoper1!=null){
			if(null != storeoper1.getType() && storeoper1.getType().trim().length()>0){
				dc.add(Restrictions.eq("type", storeoper1.getType()));
			}
			//根据商品进行查询
			if(null!=storeoper1.getGoodsuuid()) {
				dc.add(Restrictions.eq("goodsuuid", storeoper1.getGoodsuuid()));
			}
			//根据操作人进行查询
			if(null!=storeoper1.getEmpuuid()) {
				dc.add(Restrictions.eq("empuuid",storeoper1.getEmpuuid()));
			}
			//仓库
			if(null!=storeoper1.getStoreuuid()) {
				dc.add(Restrictions.eq("storeuuid",storeoper1.getStoreuuid()));
			}
			//操作时间
			if(null!=storeoper1.getOpertime()) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(storeoper1.getOpertime());
				cal.set(Calendar.HOUR, 0);
				cal.set(Calendar.MINUTE,0);
				cal.set(Calendar.SECOND,0);
				cal.set(Calendar.MILLISECOND, 0);
				dc.add(Restrictions.ge("opertime", cal.getTime()));
			}

		}
		if(storeoper2!=null) {
			if(null!=storeoper2.getOpertime()) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(storeoper1.getOpertime());
				cal.set(Calendar.HOUR,23);
				cal.set(Calendar.MINUTE,59);
				cal.set(Calendar.SECOND,59);
				cal.set(Calendar.MILLISECOND, 999);
				dc.add(Restrictions.le("opertime",cal.getTime()));
			}
		}
		//操作时间
		return dc;
	}

}
