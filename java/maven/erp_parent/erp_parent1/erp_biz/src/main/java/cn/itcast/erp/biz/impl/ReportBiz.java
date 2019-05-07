package cn.itcast.erp.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.itcast.erp.biz.IReportBiz;
import cn.itcast.erp.dao.IReportDao;

public class ReportBiz implements IReportBiz {
	private IReportDao reportDao;
	
	public void setReportDao(IReportDao reportDao) {
		this.reportDao = reportDao;
	}

	@Override
	public List ordersReport(Date start,Date end) {
		
		return reportDao.ordersReport( start, end);
	}

	@Override
	public List getSumMoney(int year) {
		List<Map<String,Object>> yearData = reportDao.getSumMoney(year);
		//这个是最终返回的数据
		List<Map<String,Object>> rtnData = new ArrayList<>();
		//key=月份 ，值等于={"name":4,"y":906.4}
		Map<String,Map<String,Object>> yearDataMap = new HashMap<>();
		
		for(Map<String,Object> month:yearData) {
			yearDataMap.put( month.get("name")+"", month);
		}
		Map<String,Object> monthData = null;
		for(int i= 1;i<=12;i++) {
			monthData = yearDataMap.get(i+"");
			if(monthData == null) {
				monthData = new HashMap<String,Object>();
				monthData.put("name", i+"月");
				monthData.put("y", 0);
			}else {
				monthData.put("name", i+"月");
			}
			rtnData.add(monthData);
			
		}
		return rtnData;
	}

}
