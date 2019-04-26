package cn.itcast.erp.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.erp.dao.IReportDao;

public class ReportDao extends HibernateDaoSupport implements IReportDao {

	public List ordersReport(Date start,Date end) {
		String hql = "select new Map( gt.name as name,sum(od.money) as y) from Goodstype gt ,Goods g,Orders o,Orderdetail od where g.goodstype=gt and od.orders=o and od.goodsuuid=g.uuid " 
					+ "and type='2' ";
		// 传参
		List<Date> list = new ArrayList<>();
		if(start!=null) {
			hql += "and o.createtime>=? ";
			list.add(start);
		}
		if(end!=null) {
			hql += "and o.createtime<=? ";
			list.add(end);
		}
		hql += "group by gt.name";
		Date [] param = new Date [list.size()];
		Date [] params = list.toArray(param);
		return getHibernateTemplate().find(hql,params);
	}

	@Override
	public List getSumMoney(int year) {
		String hql = "select new Map( month(o.createtime) as name,sum(od.money) as y ) "
				+ "from Orderdetail od,Orders o "
				+ "where od.orders= o "
				+ "and o.type='2' and year(o.createtime)= ? "
				+ "group by month(o.createtime)";
		return getHibernateTemplate().find(hql, year);
	}
	

}
