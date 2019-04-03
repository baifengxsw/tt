package cn.itcast.store.utils;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
	public static Object createObject(String name) {
	//ͨ�����ݹ�����name ��ȡapplication.xml��name��Ӧ��classֵ
		//��ȡ��Document����
		try {
			SAXReader reader = new SAXReader();
			//application.xml ����
			InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("application.xml");
			Document dao = reader.read(is);
			//��ȡ�����ڵ�
			Element root = dao.getRootElement();
			List<Element>list = root.elements();
			for(Element ele:list) {
				String id = ele.attributeValue("id");
				if(id.equals(name)) {
					String str = ele.attributeValue("class");
					Class clazz = Class.forName(str);
					return clazz.newInstance();
				}
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
		
				
	}
}
