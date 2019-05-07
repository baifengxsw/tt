package cn.itcast.erp.biz.impl;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.itcast.erp.biz.ISupplierBiz;
import cn.itcast.erp.dao.ISupplierDao;
import cn.itcast.erp.entity.Supplier;
import cn.itcast.erp.exception.ErpException;
/**
 * 供应商业务逻辑类
 * @author Administrator
 *
 */
public class SupplierBiz extends BaseBiz<Supplier> implements ISupplierBiz {

	private ISupplierDao supplierDao;
	
	public void setSupplierDao(ISupplierDao supplierDao) {
		this.supplierDao = supplierDao;
		super.setBaseDao(this.supplierDao);
	}

	@Override
	public void export(OutputStream os, Supplier t1) {
		//根据查询条件获取供应商 客户列表
		List<Supplier> supplierList = super.getList(t1, null, null);
		//创建Excel工作簿
		HSSFWorkbook wk = new HSSFWorkbook();
		HSSFSheet sheet = null;
		//根据查询条件中的类型 来创建相应的名称
		if("1".equals(t1.getType())) {
			sheet = wk.createSheet("供应商");
			
		}
		if("2".equals(t1.getType())) {
			sheet = wk.createSheet("客户");
		}
		//写入表头
		HSSFRow row = sheet.createRow(0);
		//定义每一列的标题
		String [] headerNames = {"名称" ,"地址","联系人","电话","Email"};
		//指定每一列的宽度
		int [] columnWidths = {4000,8000,2000,3000,8000};
		HSSFCell cell = null;
		for(int i = 0 ; i<headerNames.length;i++) {
			cell = row.createCell(i);
			cell.setCellValue(headerNames[i]);
			sheet.setColumnWidth(i, columnWidths[i]);
			
		}
		//标题设置完毕 进行内容的写入
		
		int i = 1;
		for(Supplier supplier:supplierList) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(supplier.getName());
			row.createCell(1).setCellValue(supplier.getAddress());
			row.createCell(2).setCellValue(supplier.getContact());
			row.createCell(3).setCellValue(supplier.getTele());
			row.createCell(4).setCellValue(supplier.getEmail());
			i++;
		}
		
		try {
			wk.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				wk.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 实现数据的导入
	 */
	@Override
	public void doImport(InputStream io) throws IOException {
		HSSFWorkbook wc = null;
		try {
			wc = new HSSFWorkbook(io);
			HSSFSheet sheet  = wc.getSheetAt(0);
			String type = "";
			if("供应商".equals(sheet.getSheetName())) {
				type= Supplier.TYPE_SUPPLIER;
			}else if("客户".equals(sheet.getSheetName())) {
				type = Supplier.TYPE_CUSTOMER;
			}else {
				throw new ErpException("工作表名称不正确");
			}
			//开始读取数据
			//取得最后一行的行号
			int lastRow = sheet.getLastRowNum();
			Supplier supplier = null;
			for(int i = 1;i<=lastRow;i++) {
				supplier = new Supplier();
				supplier.setName(sheet.getRow(i).getCell(0).getStringCellValue());
				//通过相应的查询条件判断是否存在
				List<Supplier> list = supplierDao.getList(null,supplier,null);
				//这里拿到持久化对象
				if(list.size()>0) {
					supplier = list.get(0);
				}
				supplier.setAddress(sheet.getRow(i).getCell(1).getStringCellValue());
				supplier.setContact(sheet.getRow(i).getCell(2).getStringCellValue());
				supplier.setTele(sheet.getRow(i).getCell(3).getStringCellValue());
				supplier.setEmail(sheet.getRow(i).getCell(4).getStringCellValue());
				//如果没有这个数据 ，我们就进行添加 并且设置相应的
				if(list.size() == 0) {
					//新增
					supplier.setType(type);
					supplierDao.add(supplier);
				}
				
				
			}

		}finally {
			if(null !=wc) {
				try {
					wc.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}
