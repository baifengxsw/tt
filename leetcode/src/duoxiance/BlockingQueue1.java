package duoxiance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试阻塞队列
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
		System.out.println("生产者线程开始启动");
		try {
			while(flag) {
				int  data = incre.incrementAndGet();
				boolean ret = queue.offer(data);
				if(ret) {
					System.out.println("生产线程成功插入一条数据");
				}else {
					
					System.out.println("生产线程插入失败");
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			System.out.println("生产者退出线程");
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
					System.out.println("消费者 消费了"+data);
				}else {
					System.out.println("消费者线程没有取到数据");
				}
				Thread.sleep(100);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			System.out.println("消费者线程终止");
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
