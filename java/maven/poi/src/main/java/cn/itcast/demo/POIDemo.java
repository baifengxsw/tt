package cn.itcast.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIDemo {
	
	public static void main(String[] args) throws FileNotFoundException, Exception {
		//创建excel工作bu
		HSSFWorkbook wk = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wk.createSheet("我的工作表");
		sheet.setColumnWidth(0, 5000);
		//创建第一行
		HSSFRow row = sheet.createRow(0);
		//创建第一行的第一个单元格
		HSSFCell cell = row.createCell(0);
		//向单元格进行写值
		cell.setCellValue("测试");
		wk.write(new FileOutputStream(new File("e:/ceshi.xls")));
		wk.close();
	}
}
