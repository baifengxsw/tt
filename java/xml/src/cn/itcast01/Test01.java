package cn.itcast01;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test01 {
	public static void main(String[] args) {
		//1 ����sax��ȡ����
		try{SAXReader reader = new SAXReader();
		//2 ָ��������xmlԴ
		
		Document document = reader.read(new File("D:\\tt\\java\\xml\\src\\cn\\itcast01\\stus.xml"));
		//3�õ����ڵ�Ԫ��
		Element rootElement = document.getRootElement();
		System.out.println(rootElement.getName());
		//4�õ�����Ԫ��
		String name = rootElement.element("stu").element("name").getText();
		//5��ȡ���Ԫ��
		List<Element> list = rootElement.elements();
		for(Element element : list) {
			String name1 = element.element("name").getText();
			String age = element.element("age").getText();
			String address = element.element("address").getText();
			System.out.println("name:"+name1+"age:"+age+"address"+address);
		}
		
		System.out.println(name);
		} catch (DocumentException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
