package duoxiance;
/**
 * ʵ����Դ������
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
			System.out.println(Thread.currentThread().getName()+"�ҿ�ʼ�ɻ���");
			Thread.sleep(10000);//ģ��ռ��ʱ��
			System.out.println(Thread.currentThread().getName()+"�ҽ�����");
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
