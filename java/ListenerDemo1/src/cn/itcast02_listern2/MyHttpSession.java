package cn.itcast02_listern2;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * �����Ự�����Ա仯 ���ɾ���滻
 * @author baifeng
 *
 */
public class MyHttpSession implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�����Ա���ӽ�����");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("��һ�����Ա������ȥ��");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("��һ�����Ա��滻 ��");
	}

}
