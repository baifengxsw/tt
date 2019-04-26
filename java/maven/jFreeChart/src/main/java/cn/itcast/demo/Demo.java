package cn.itcast.demo;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Demo {
	public static void main (String[] args) {
		//设置一个数据集
		DefaultPieDataset dataSet = new DefaultPieDataset();
		dataSet.setValue("家电",1313);
		dataSet.setValue("百货",534);
		dataSet.setValue("玩具",1768);
		/**
		 * 1 标题 
		 * 2 数据集 
		 * 3 是否显示下方的区域指示 比例
		 * 4 tooltip 提示 鼠标移到提示
		 * 5 url 是否为超链接
		 * 6
		 */
		JFreeChart chart = ChartFactory.createPieChart("数据统计", dataSet,true, false,false);
		//保存到本地目录下
		//1保存到本地目录
		//2 图表对象
		//3图表的宽度
		//4 图表的高度
		try {
			ChartUtilities.saveChartAsJPEG(new File("e:\\s.png"), chart, 500, 500);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
