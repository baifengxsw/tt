package duoxiance;
/**
 * 实现资源的争用
 * @author baifeng
 *
 */

import java.util.concurrent.Semaphore;

class ppp implements Runnable{
	private Semaphore semaphore;
	ppp(Semaphore semaphore){
		this.semaphore = semaphore;
	}
	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+"我开始干活了");
			Thread.sleep(10000);//模拟占用时间
			System.out.println(Thread.currentThread().getName()+"我结束了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}
}
public class Semaphore1 {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		ppp p = new ppp(semaphore);
		for(int i = 0 ;i<10;i++) {
			new Thread(p).start();
		}
		System.out.println("main:over");
	}
}
