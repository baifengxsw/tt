package cn.itcast02_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 对于装饰类 是为了解决 不能继承 且继承容易破坏结构的问题  
 * 但是当装饰类继承的接口过多时 ,我们可以通过 动态代理 对我们需要的方法进行修改
 * 而不需要的方法按原先被装饰的类进行运行
 * @author baifeng
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		/**
		 * @parm1 固定值,告诉虚拟机用哪个字节码加载器加载内存中创建出的字节码
		 * @parm2 告诉虚拟机内存中正在被创建的字节码文件中应该具有哪些方法
		 * @param3 告诉虚拟机正在被创建的字节码上的各个方法如何调用
		 *
		 */
		ICar car = (ICar)Proxy.newProxyInstance(Demo1.class.getClassLoader(), GugeCar.class.getInterfaces(), new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO 自动生成的方法存根
				//System.out.println(method.getName()); 这时生成的文件都是空文件
				//下面只有在调用的时候才会运行
				if(method.getName().equalsIgnoreCase("start")) {
					System.out.println("风雪天气检测");
					System.out.println("路面状况检测");
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
