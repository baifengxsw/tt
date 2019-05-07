package cn.itcast.erp.biz;

import java.util.Date;
import java.util.List;

/**
 * 销售统计的业务实现
 * @author baifeng
 *
 */
public interface IReportBiz {
	/**
	 * 销售统计报表
	 */
	List ordersReport(Date start,Date end);
	
	/**
	 * 销售趋势图
	 * @param year
	 * @return
	 */
	List getSumMoney(int year);
}
