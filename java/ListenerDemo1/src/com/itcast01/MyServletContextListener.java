package com.itcast01;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 对于监听事件 ,通常都是定义一个对象继承相应的接口 ,并且注册该事件
 * @author baifeng
 *
 */
public class MyServletContextListener implements ServletContextListener{
	//初始化的时候调用  //启动tomcat服务器时候
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ServletContextListener 销毁了");
	}
	
	//销毁的时候调用  从服务器移除项目的时候
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ServletContextListener 初始化");
	}

}
