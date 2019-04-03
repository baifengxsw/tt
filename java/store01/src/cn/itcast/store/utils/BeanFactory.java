package cn.itcast.store.utils;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
	public static Object createObject(String name) {
	//通过传递过来的name 获取application.xml中name对应的class值
		//获取到Document对象
		try {
			SAXReader reader = new SAXReader();
			//application.xml 必须
			InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("application.xml");
			Document dao = reader.read(is);
			//获取到根节点
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
		
				
	}
}
