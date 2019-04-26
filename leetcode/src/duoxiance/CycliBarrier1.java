package duoxiance;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * cyclibarrier 测试
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
		System.out.println(Thread.currentThread().getName()+"线程开始执行 ");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"线程结束");
		try {
			cBarrier.await();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"线程终止");
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
