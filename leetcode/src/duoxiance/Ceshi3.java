package duoxiance;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomicInteger ԭ����
 * @author baifeng
 *
 */
public class Ceshi3 implements Runnable{
	private  AtomicInteger count = new AtomicInteger(0);
	//����ȡ��static ���Ǹ����̵߳�ֵ
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		for(int i=0;i<1000;i++) {
			count.incrementAndGet();
		}
		System.out.println(Thread.currentThread().getName()+"count:"+count.get());
	}
	
	public static void main(String[] args) {
		/*Ceshi3 list[]  = new Ceshi3[10];
		
		for(int i = 0;i<10;i++) {
			list[i] = new Ceshi3();
		}*/
		Ceshi3 ceshi3 = new Ceshi3();
		for(int i = 0; i<10;i++) {
			new Thread(ceshi3).start();
		}
	}
	
	
}
