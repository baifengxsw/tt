package duoxiance;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * cyclibarrier ����
 * @author baifeng
 *
 */
class fff implements Runnable{
	private CyclicBarrier cBarrier;
	
	fff(CyclicBarrier cBarrier){
		this.cBarrier = cBarrier;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"�߳̿�ʼִ�� ");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"�߳̽���");
		try {
			cBarrier.await();
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"�߳���ֹ");
	}
	
}
public class CycliBarrier1 {
	
	public static void main(String[] args) {
		CyclicBarrier cBarrier = new CyclicBarrier(3);
		fff f = new fff(cBarrier);
		Thread t1 = new Thread(f);
		Thread t2 = new Thread(f);
		Thread t3 = new Thread(f);
		t1.start();
		t2.start();
		t3.start();
		
		
	}
	
}
