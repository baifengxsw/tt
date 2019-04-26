package cn.itcast.erp.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;

import cn.itcast.erp.biz.IReportBiz;

public class ReportAction {
	private IReportBiz reportBiz;

	public void setReportBiz(IReportBiz reportBiz) {
		this.reportBiz = reportBiz;
	}
	private Date start;
	private Date end;
	
	private int year;
	
	
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public void orderReport() {
		List list = reportBiz.ordersReport(start,end);
		write(JSON.toJSONString(list));
	}
	
	/**
	 * 输出字符串到前端
	 * @param jsonString
	 */
	private void write(String jsonString){
		try {
			//响应对象
			HttpServletResponse response = ServletActionContext.getResponse();
			//设置编码
			response.setContentType("text/html;charset=utf-8"); 
			//输出给页面
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 实现趋势图
	 */
	public void trendReport() {
		List list = reportBiz.getSumMoney(year);
		write(JSON.toJSONString(list));
	}
}
