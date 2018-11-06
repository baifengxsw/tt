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
			//�õ�nameԪ�� ����ֻ����һ��
			Element nameElement = (Element)rootElement.selectSingleNode("//name");
			System.out.println(nameElement.getText());
			System.out.println("******************************************");
			//����������namespace ����
			//Ҫʹ��xpath,�������֧�ֵ�jar��,�����jar�������ʾ��ȷ
//			List<Element> list = rootElement.selectNodes("/stus/stu");//�Ӹ��ڵ㿪ʼ����
//			for (Element element: list) {
//				System.out.println(element.element("age").getText());
//			}
			List<Element> list = rootElement.selectNodes("//name");
			for(Element element: list) {
				System.out.println(element.getText());
			}
		} catch (DocumentException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
