package cn.itcast.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class CreateOrderxls {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//工作簿
		HSSFWorkbook wc = new HSSFWorkbook();
		//获取工作表
		HSSFSheet sheet = wc.createSheet("采购订单");
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
	 

	    //根據导出的订单样本创建10行4列
	    for(int i = 2;i<12;i++) {
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
	    sheet.createRow(0).createCell(0).setCellValue("采购订单");
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
	    sheet.getRow(7).getCell(0).setCellValue("订单明细");
	    sheet.getRow(8).getCell(0).setCellValue("商品名称");
	    sheet.getRow(8).getCell(1).setCellValue("数量");
	    sheet.getRow(8).getCell(2).setCellValue("价格");
	    sheet.getRow(8).getCell(3).setCellValue("金额");
	    
	    /**设置行高和列宽**/
	    sheet.getRow(0).setHeight((short)1000);
	    //设置内容部分的高
	    for(int i = 2;i<12;i++) {
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
	    
	    
	    
	    wc.write(new FileOutputStream(new File("e:/ceshi.xls")));
	    wc.close();
	}
}
