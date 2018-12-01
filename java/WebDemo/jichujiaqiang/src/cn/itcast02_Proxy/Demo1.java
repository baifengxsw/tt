package cn.itcast02_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ����װ���� ��Ϊ�˽�� ���ܼ̳� �Ҽ̳������ƻ��ṹ������  
 * ���ǵ�װ����̳еĽӿڹ���ʱ ,���ǿ���ͨ�� ��̬���� ��������Ҫ�ķ��������޸�
 * ������Ҫ�ķ�����ԭ�ȱ�װ�ε����������
 * @author baifeng
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		/**
		 * @parm1 �̶�ֵ,������������ĸ��ֽ�������������ڴ��д��������ֽ���
		 * @parm2 ����������ڴ������ڱ��������ֽ����ļ���Ӧ�þ�����Щ����
		 * @param3 ������������ڱ��������ֽ����ϵĸ���������ε���
		 *
		 */
		ICar car = (ICar)Proxy.newProxyInstance(Demo1.class.getClassLoader(), GugeCar.class.getInterfaces(), new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO �Զ����ɵķ������
				//System.out.println(method.getName()); ��ʱ���ɵ��ļ����ǿ��ļ�
				//����ֻ���ڵ��õ�ʱ��Ż�����
				if(method.getName().equalsIgnoreCase("start")) {
					System.out.println("��ѩ�������");
					System.out.println("·��״�����");
					method.invoke(new GugeCar(), args);
				}else{
					method.invoke(new GugeCar(), args);
				}
				return null;
			}
		});
		car.start();
		car.run();
		car.stop();

	}
}
