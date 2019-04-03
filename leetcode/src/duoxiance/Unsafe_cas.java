package duoxiance;

import java.lang.reflect.Field;

import cn.itcast02_simple_basic.ceshi;
import sun.misc.Unsafe;

public class Unsafe_cas {
	//��ȡunsafe��ʵ��
	static final Unsafe unsafe ;
	//��¼����state����TestUnsafe��ƫ��ֵCAS���������������ڴ�ֵV���ɵ�Ԥ��ֵA��Ҫ�޸ĵ�ֵB�����ҽ���Ԥ��ֵA���ڴ�ֵV��ͬʱ�����ڴ�ֵ�޸�ΪB������true������ʲô������������false��
	static final long stateOffset;
	
	//����
	private volatile long state = 0;
	static {
		try {
			//ʹ�÷����ȡunsafe�ĳ�Ա����theUnsafe
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			//����Ϊ�ɴ�ȡ
			field.setAccessible(true);
			//��ȡ�ñ�����ֵ
			unsafe = (Unsafe)field.get(null);
			//��ȡstate��������TestUnSafe�е�ƫ��ֵ
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
