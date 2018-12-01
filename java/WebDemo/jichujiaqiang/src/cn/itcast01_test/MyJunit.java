package cn.itcast01_test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

public class MyJunit {
		public static void main(String[] args) {
			//����UserDao.class �ֽ����ļ��еķ���  ������������Զ���Test01 ִ�� �õ��ֽ������ڴ��еĶ���
			try {
				Class clazz = Class.forName("cn.itcast01_test.UserDao");
				//һ���ص�ʱ��ͻ�ִ�о�̬�����
				//�õ����еķ���
				Method [] methods = clazz.getMethods();
				for(Method method : methods) {
					//System.out.println(method.getName());//���������еķ������ᱻ��ӡ
					//�жϵ�ǰ�ķ����Ƿ���@Test01 ��ע����Ϣ �������ִ�и÷���
					if(method.isAnnotationPresent(Test01.class)) {
						System.out.println(method.getName()); //ע�ͱ���Ҫ������ȫ������  ,����ʲôʱ�� ,ʲô����
						Constructor con = clazz.getConstructor();
						
						Object obj = con.newInstance();
						method.invoke(obj);
					}
				}
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

}
