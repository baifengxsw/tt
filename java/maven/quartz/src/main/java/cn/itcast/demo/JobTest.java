package cn.itcast.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JobTest {
	
	public void doJob() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("现在是北京时间:"+sdf.format(new Date()));
		
	}
}
