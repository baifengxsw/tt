package duoxiance;

import java.util.concurrent.CountDownLatch;

/**
 * 计数器的使用
 * @author baifeng
 *
 */
public class CountDawnlatch {
	public static void main(String[] args) {
		CountDownLatch count = new CountDownLatch(3);
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("子线程1执行");
				count.countDown();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("子线程2执行");
				count.countDown();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("子线程3执行");
				count.countDown();
			}
		});
		t1.start();
		t2.start();
		t3.start();
		try {
			count.await();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("main线程执行");
	}
}
