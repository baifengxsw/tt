package duoxiance;
/**
 * 线程池的复用
 * @author baifeng
 *
 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool1 {
	public static void main(String[] args) {
//		ExecutorService service = Executors.newCachedThreadPool();
//		for(int i = 0 ;i<10;i++) {
//			int temp = i;
//			service.execute(new Runnable() {
//				
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName()+":"+temp);
//					
//				}
//			});
//		}
//		ExecutorService service = Executors.newFixedThreadPool(4);
//		for(int i = 0 ;i<10;i++) {
//			int temp = i;
//			service.execute(new Runnable() {
//				
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName()+":"+temp);
//					
//				}
//			});
//		}
		ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
		for(int i = 0;i<10;i++) {
			int temp = i;
			service.schedule(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+":"+temp);
				}
			}, 4, TimeUnit.SECONDS);
		}
		service.shutdown();
	}
}
