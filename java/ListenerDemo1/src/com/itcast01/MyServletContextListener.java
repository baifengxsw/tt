package com.itcast01;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ���ڼ����¼� ,ͨ�����Ƕ���һ������̳���Ӧ�Ľӿ� ,����ע����¼�
 * @author baifeng
 *
 */
public class MyServletContextListener implements ServletContextListener{
	//��ʼ����ʱ�����  //����tomcat������ʱ��
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ServletContextListener ������");
	}
	
	//���ٵ�ʱ�����  �ӷ������Ƴ���Ŀ��ʱ��
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ServletContextListener ��ʼ��");
	}

}
