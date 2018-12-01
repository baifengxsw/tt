package cn.itcast01_test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

public class MyJunit {
		public static void main(String[] args) {
			//加载UserDao.class 字节码文件中的方法  如果方法上有自定义Test01 执行 拿到字节码在内存中的对象
			try {
				Class clazz = Class.forName("cn.itcast01_test.UserDao");
				//一加载的时候就会执行静态代码段
				//拿到所有的方法
				Method [] methods = clazz.getMethods();
				for(Method method : methods) {
					//System.out.println(method.getName());//在这里所有的方法都会被打印
					//判断当前的方法是否有@Test01 的注解信息 如果有则执行该方法
					if(method.isAnnotationPresent(Test01.class)) {
						System.out.println(method.getName()); //注释必须要进行完全的配置  ,比如什么时候 ,什么对象
						Constructor con = clazz.getConstructor();
						
						Object obj = con.newInstance();
						method.invoke(obj);
					}
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

}
