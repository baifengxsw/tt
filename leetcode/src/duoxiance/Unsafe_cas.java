package duoxiance;

import java.lang.reflect.Field;

import cn.itcast02_simple_basic.ceshi;
import sun.misc.Unsafe;

public class Unsafe_cas {
	//获取unsafe的实例
	static final Unsafe unsafe ;
	//记录变量state在类TestUnsafe的偏移值CAS有三个操作数：内存值V、旧的预期值A、要修改的值B，当且仅当预期值A和内存值V相同时，将内存值修改为B并返回true，否则什么都不做并返回false。
	static final long stateOffset;
	
	//变量
	private volatile long state = 0;
	static {
		try {
			//使用反射获取unsafe的成员变量theUnsafe
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			//设置为可存取
			field.setAccessible(true);
			//获取该变量的值
			unsafe = (Unsafe)field.get(null);
			//获取state变量在类TestUnSafe中的偏移值
			stateOffset = unsafe.objectFieldOffset(Unsafe_cas.class.getDeclaredField("state"));
			
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new Error(e);
		}
	}
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Unsafe_cas test = new Unsafe_cas();
		boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
		System.out.println(success);

		System.out.println(test.state);
	}
}
