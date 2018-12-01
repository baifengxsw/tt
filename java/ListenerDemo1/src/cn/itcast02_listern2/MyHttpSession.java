package cn.itcast02_listern2;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 监听会话的属性变化 添加删除替换
 * @author baifeng
 *
 */
public class MyHttpSession implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("有属性被添加进来啦");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("有一个属性被清除出去了");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("有一个属性被替换 了");
	}

}
