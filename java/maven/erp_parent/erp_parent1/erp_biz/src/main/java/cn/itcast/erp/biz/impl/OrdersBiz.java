package cn.itcast.erp.biz.impl;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import cn.itcast.erp.biz.IOrdersBiz;
import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.dao.IOrdersDao;
import cn.itcast.erp.dao.ISupplierDao;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.entity.Orders;
import cn.itcast.erp.exception.ErpException;
/**
 * 订单业务逻辑类
 * @author Administrator
 *
 */
public class OrdersBiz extends BaseBiz<Orders> implements IOrdersBiz {

	private IOrdersDao ordersDao;
	//对每个员工进行查询 注入emp 的dao
	private IEmpDao empDao;
	//还需要查供应商的 ，我们也要将它注入进来
	private ISupplierDao supplierDao;
	
	public void setSupplierDao(ISupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public IEmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}

	public void setOrdersDao(IOrdersDao ordersDao) {
		this.ordersDao = ordersDao;
		super.setBaseDao(this.ordersDao);
	}
	
	public void add(Orders orders) {
		if(orders.getType()==null)
			return ;
		if(orders.getType().equals("1")) {
			//设置订单状态
			orders.setState(Orders.STATE_CREATE);
			//设置订单类型  这里页面传过来
			//orders.setType(Orders.TYPE_IN);
			//下单时间
			orders.setCreatetime(new Date());
			//合计金额
			double total = 0;
			for(Orderdetail detail:orders.getOrderDetails()) {
				//进行金额的统计
				total +=detail.getMoney();
				//明细的状态
				detail.setState(Orderdetail.STATE_IN);
				//设置与订单的关系
				detail.setOrders(orders);
			}
			//设置订单的总金额
			orders.setTotalmoney(total);
			//保存到数据库
			ordersDao.add(orders);
		}
		if(orders.getType().equals("2")) {
			//设置订单状态
			orders.setState(Orders.STATE_NOT_OUT);
			//设置订单类型  这里页面传过来
			//orders.setType(Orders.TYPE_IN);
			//下单时间
			orders.setCreatetime(new Date());
			//合计金额
			double total = 0;
			for(Orderdetail detail:orders.getOrderDetails()) {
				//进行金额的统计
				total +=detail.getMoney();
				//明细的状态
				detail.setState(Orderdetail.STATE_NOT_OUT);
				//设置与订单的关系
				detail.setOrders(orders);
			}
			//设置订单的总金额
			orders.setTotalmoney(total);
			//保存到数据库
			ordersDao.add(orders);
		}
		
	}
	
	public List<Orders> getListByPage(Orders t1, Orders t2, Object param, int firstResult, int maxResults) {
		//获取分页后的订单列表
		// TODO 自动生成的方法存根
		List<Orders> ordersList =  super.getListByPage(t1, t2, param, firstResult, maxResults);
		//缓存员工编号与员工名称 ，key 等于员工编号 ，value 等于员工名称
		Map<Long,String> empNameMap = new HashMap<>();
		Map<Long,String> supplierNameMap = new HashMap<>();
		//循环 ，获取员工的名称
		for(Orders order : ordersList) {
			//添加员工的名称
			order.setCreaterName(getEmpName(order.getCreater(), empNameMap,empDao));
			order.setCheckerName(getEmpName(order.getChecker(),empNameMap,empDao));
			order.setStarterName(getEmpName(order.getStarter(), empNameMap,empDao));
			order.setEnderName(getEmpName(order.getEnder(),empNameMap,empDao));
			//添加供应商的编号
			order.setSupplierName(getSupplierName(order.getSupplieruuid(), supplierNameMap,supplierDao));
		}
		return ordersList;
	}
	
	/**
	 * 导出订单为excel文件
	 * 
	 */
	@Override
	public void exportById(OutputStream os, Long uuid) throws Exception {
		//工作簿
				HSSFWorkbook wc = new HSSFWorkbook();
				Orders orders = ordersDao.get(uuid);
				  String sheetName = "";
				    if(orders.getType().equals("1")) {
				    	sheetName="采购订单";
				    }
				    if(orders.getType().equals("2")) {
				    	sheetName="销售订单";
				    }
				//获取工作表
				HSSFSheet sheet = wc.createSheet(sheetName);
				//内容样式
				HSSFCellStyle style_content = wc.createCellStyle();
				style_content.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
				
			    style_content.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
			    style_content.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
			    style_content.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
			    /**内容部分的对齐设置**/
			    style_content.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置水平居中
			    style_content.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//水平居中
			    //设置内容部分的字体
			    HSSFFont font_content = wc.createFont();//创建字体
			    font_content.setFontName("宋体");
			    font_content.setFontHeightInPoints((short)11); //设置字体大小
			    style_content.setFont(font_content);
			    
			    //设置标题的样式
			    HSSFCellStyle style_title = wc.createCellStyle();
			    //设置水平和垂直居中
			    style_title.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			    style_title.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			    //创建字体格式
			    HSSFFont font_title = wc.createFont();
			    font_title.setFontName("黑体");//设置字体名称
			    font_title.setBold(true);//加粗
			    font_title.setFontHeightInPoints((short)18);//设置字体大小
			    style_title.setFont(font_title);
			    
			    //** 设置 日期格式**//
			    HSSFCellStyle style_date = wc.createCellStyle();
			    style_date.cloneStyleFrom(style_content);//格式基本和内容格式相似
			    HSSFDataFormat dataFormat = wc.createDataFormat();
			    style_date.setDataFormat(dataFormat.getFormat("yyyy-MM-ss hh:mm"));
			 

			 
			    
			    int size = orders.getOrderDetails() == null?0:orders.getOrderDetails().size();
			    int rowCnt = 10 + size;
			    //根據导出的订单样本创建10行4列
			    for(int i = 2;i<rowCnt;i++) {
			    	HSSFRow row = sheet.createRow(i);//创建相应的行
			    	for(int j = 0;j<4;j++) {
			    		HSSFCell cell = row.createCell(j);
			    		cell.setCellStyle(style_content);
			    	}
			    }
			    //对第一行进行合并 形成标题
			    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
			    //对于第三行的后三列 形成标题
			    sheet.addMergedRegion(new CellRangeAddress(2,2,1,3));
			    //第8行 ，需要合并成一个单元格  用来作为订单详情
			    sheet.addMergedRegion(new CellRangeAddress(7, 7, 0, 3));
			    /**设置固定的文本内容**/
			    //这里没有创建过
			  
			    sheet.createRow(0).createCell(0).setCellValue(sheetName);
			    //已经创建过的row/cell 则通过sheet，get
			    sheet.getRow(2).getCell(0).setCellValue("供应商");
			    sheet.getRow(3).getCell(0).setCellValue("下单日期");
			    sheet.getRow(3).getCell(2).setCellValue("经办人");
			    sheet.getRow(4).getCell(0).setCellValue("审核日期");
			    sheet.getRow(4).getCell(2).setCellValue("经办人");
			    sheet.getRow(5).getCell(0).setCellValue("采购日期");
			    sheet.getRow(5).getCell(2).setCellValue("经办人");
			    sheet.getRow(6).getCell(0).setCellValue("入库日期");
			    sheet.getRow(6).getCell(2).setCellValue("经办人");
			    //**设置供应商**//
			    if(null!= orders.getSupplieruuid()) {
			    	sheet.getRow(2).getCell(1).setCellValue(supplierDao.get(orders.getSupplieruuid()).getName());
			    }
			  //****** 设置日期内容 ******//
			    if(null != orders.getCreatetime()){
			    	sheet.getRow(3).getCell(1).setCellValue(orders.getCreatetime());
			    }
			    if(null != orders.getChecktime()){
			    	sheet.getRow(4).getCell(1).setCellValue(orders.getChecktime());
			    }
			    if(null != orders.getStarttime()){
			    	sheet.getRow(5).getCell(1).setCellValue(orders.getStarttime());
			    }
			    if(null != orders.getEndtime()){
			    	sheet.getRow(6).getCell(1).setCellValue(orders.getEndtime());
			    }
			    //****** 设置经办人的值 ******//
			    if(null != orders.getCreater()){//下单员
			    	sheet.getRow(3).getCell(3).setCellValue(empDao.get(orders.getCreater()).getName());
			    }
			    if(null != orders.getChecker()){//审核员
			    	sheet.getRow(4).getCell(3).setCellValue(empDao.get(orders.getChecker()).getName());
			    }
			    if(null != orders.getStarter()){//采购员
			    	sheet.getRow(5).getCell(3).setCellValue(empDao.get(orders.getStarter()).getName());
			    }
			    if(null != orders.getEnder()){  //库管员
			    	sheet.getRow(6).getCell(3).setCellValue(empDao.get(orders.getEnder()).getName());
			    }

			    sheet.getRow(7).getCell(0).setCellValue("订单明细");
			    sheet.getRow(8).getCell(0).setCellValue("商品名称");
			    sheet.getRow(8).getCell(1).setCellValue("数量");
			    sheet.getRow(8).getCell(2).setCellValue("价格");
			    sheet.getRow(8).getCell(3).setCellValue("金额");
			  //****** 订单明细 ******//
			    int rowIndex = 9;
			    HSSFRow row = null;
			    for(Orderdetail od : orders.getOrderDetails()){
			    	row = sheet.getRow(rowIndex);
			    	row.getCell(0).setCellValue(od.getGoodsname());
			    	row.getCell(1).setCellValue(od.getNum());
			    	row.getCell(2).setCellValue(od.getPrice());
			    	row.getCell(3).setCellValue(od.getMoney());
			    	rowIndex++;
			    }
			    //** 合计**//
			    sheet.getRow(rowIndex).getCell(0).setCellValue("合计");
			    sheet.getRow(rowIndex).getCell(3).setCellValue(orders.getTotalmoney());

			    
			    /**设置行高和列宽**/
			    sheet.getRow(0).setHeight((short)1000);
			    //设置内容部分的高
			    for(int i = 2;i<rowCnt;i++) {
			    	sheet.getRow(i).setHeight((short)500);
			    }
			    //设置列宽
			    for(int i = 0;i<4;i++) {
			    	sheet.setColumnWidth(i, 5000);
			    }
			    //**设置对齐方式和字体**/
			    //标题部分的对齐设置
			    sheet.getRow(0).getCell(0).setCellStyle(style_title);
			    
			    //对日期格式进行设置
			    for(int i = 3;i<7;i++) {
			    	sheet.getRow(i).getCell(1).setCellStyle(style_date);
			    }
			    
			    
			    
			    wc.write(os);
			    wc.close();
		
	}

	/**
	 * 实现订单的审核
	 */
	@Override
	public void doCheck(Long uuid, Long empUuid) {
		//1修改订单状态
		//2修改审核的时间
		//3审核人
		//获取订单并进入持久化 对象进行自动的更新
		Orders orders = ordersDao.get(uuid);
		//如果不是未审核的 直接抛出相应的异常
		if(!Orders.STATE_CREATE.equals(orders.getState())) {
			throw new ErpException("亲，该订单已经审核过");
			
		}
		orders.setState(Orders.STATE_CHECK);
		orders.setChecktime(new Date());
		//设置审核人
		orders.setChecker(empUuid);
		
	}

	@Override
	public void doStart(Long uuid, Long empUuid) {
		//1修改订单状态
		//2修改审核的时间
		//3审核人
		//获取订单并进入持久化 对象进行自动的更新
		Orders orders = ordersDao.get(uuid);
		//如果不是未审核的 直接抛出相应的异常
		if(!Orders.STATE_CHECK.equals(orders.getState())) {
			throw new ErpException("亲，该订单已经确认过过");
			
		}
		orders.setState(Orders.STATE_START);
		orders.setStarttime(new Date());
		orders.setStarter(empUuid);
		
		
	}
	

	
}
