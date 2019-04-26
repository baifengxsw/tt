package duoxiance;

import java.util.concurrent.CountDownLatch;

/**
 * ��������ʹ��
 * @author baifeng
 *
 */
public class CountDawnlatch {
	public static void main(String[] args) {
		CountDownLatch count = new CountDownLatch(3);
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("���߳�1ִ��");
				count.countDown();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("���߳�2ִ��");
				count.countDown();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("���߳�3ִ��");
				count.countDown();
			}
		});
		t1.start();
		t2.start();
		t3.start();
		try {
			count.await();
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println("main�߳�ִ��");
	}
}
