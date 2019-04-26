package duoxiance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ������������
 * @author baifeng
 *
 */
class Producer implements Runnable{
	private BlockingQueue<Integer>queue;
	private AtomicInteger incre = new AtomicInteger(0);
	private boolean flag = true;
	public Producer(BlockingQueue<Integer>queue) {
		this.queue  = queue;
	}
	@Override
	public void run() {
		System.out.println("�������߳̿�ʼ����");
		try {
			while(flag) {
				int  data = incre.incrementAndGet();
				boolean ret = queue.offer(data);
				if(ret) {
					System.out.println("�����̳߳ɹ�����һ������");
				}else {
					
					System.out.println("�����̲߳���ʧ��");
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			System.out.println("�������˳��߳�");
		}
		
		
	}
	public void stopP() {
		flag =false;
	}
	
}
class Comsumer2 implements Runnable{
	private BlockingQueue<Integer>queue;
	private boolean flag = true;
	public Comsumer2(BlockingQueue<Integer>queue) {
		this.queue  = queue;
	}
	@Override
	public void run() {
		try {
			while(flag) {
				Integer data = queue.poll(2, TimeUnit.SECONDS);
				if(data!=null) {
					System.out.println("������ ������"+data);
				}else {
					System.out.println("�������߳�û��ȡ������");
				}
				Thread.sleep(100);
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			System.out.println("�������߳���ֹ");
		}
		
	}
	public void stopP() {
		flag =false;
	}
	
}

public class BlockingQueue1 {
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(4);
		Producer p = new Producer(queue);
		Comsumer2 c = new Comsumer2(queue);
		Thread p1 = new Thread(p);
		Thread p2= new Thread(p);
		Thread c1 = new Thread(c);
		p1.start();
		p2.start();
		c1.start();
		Thread.sleep(10000);
		p.stopP();
		c.stopP();
	}
	
}
