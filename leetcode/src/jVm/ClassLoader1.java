package jVm;

import java.io.IOException;
import java.io.InputStream;

/**
 * 进行不同类加载器的测试加载对象是否相同
 * @author baifeng
 *
 */
public class ClassLoader1 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ClassLoader mycl = new ClassLoader(){

			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				//cn.itacast.sfsfd.
				String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
				InputStream ins =getClass().getResourceAsStream(fileName);
				if(ins==null) {
					return super.loadClass(name);
				}
				try {
					byte[] buf = new byte[ins.available()];
					ins.read(buf);
					return defineClass(name, buf, 0,buf.length);
				} catch (IOException e) {
					throw new ClassNotFoundException();
				}
			
			}
			
		};
		
		Object c = mycl.loadClass("jVm.ClassLoader1").newInstance();
		
		System.out.println(c.getClass());
		System.out.println(c instanceof ClassLoader1);
	}
}
