package cn.itcast01;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test01 {
	public static void main(String[] args) {
		//1 创建sax读取对象
		try{SAXReader reader = new SAXReader();
		//2 指定解析的xml源
		
		Document document = reader.read(new File("D:\\tt\\java\\xml\\src\\cn\\itcast01\\stus.xml"));
		//3得到根节点元素
		Element rootElement = document.getRootElement();
		System.out.println(rootElement.getName());
		//4得到单个元素
		String name = rootElement.element("stu").element("name").getText();
		//5获取多个元素
		List<Element> list = rootElement.elements();
		for(Element element : list) {
			String name1 = element.element("name").getText();
			String age = element.element("age").getText();
			String address = element.element("address").getText();
			System.out.println("name:"+name1+"age:"+age+"address"+address);
		}
		
		System.out.println(name);
		} catch (DocumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
