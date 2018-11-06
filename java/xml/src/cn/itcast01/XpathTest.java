package cn.itcast01;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathTest {
	public static void main(String[] args) {
		
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("D:\\tt\\java\\xml\\src\\cn\\itcast01\\demo.xml"));
			Element rootElement = document.getRootElement();
			//得到name元素 这里只返回一个
			Element nameElement = (Element)rootElement.selectSingleNode("//name");
			System.out.println(nameElement.getText());
			System.out.println("******************************************");
			//在这里会出现namespace 错误
			//要使用xpath,还得添加支持的jar包,添加完jar包结果显示正确
//			List<Element> list = rootElement.selectNodes("/stus/stu");//从根节点开始计算
//			for (Element element: list) {
//				System.out.println(element.element("age").getText());
//			}
			List<Element> list = rootElement.selectNodes("//name");
			for(Element element: list) {
				System.out.println(element.getText());
			}
		} catch (DocumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
