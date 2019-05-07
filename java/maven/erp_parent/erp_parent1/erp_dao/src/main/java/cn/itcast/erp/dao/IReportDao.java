package cn.itcast.erp.dao;

import java.util.Date;
import java.util.List;

/**
 * 作为报表数据的统计
 * @author baifeng
 *
 */
public interface IReportDao {
	//销售统计报表
	List ordersReport(Date start,Date end);
	/**
	 * 销售趋势图
	 * @param year
	 * @return
	 */
	List getSumMoney(int year);
}
