package jVm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DuoxianchengInit {
	static class Hello {
		static {
			System.out.println(Thread.currentThread().getName()+"init");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		int i = 0;
		while(i++<10) {
		service.execute( new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"start");
					Hello hello = new Hello();
				System.out.println(Thread.currentThread().getName()+"end");
				
			}
		});
		}
	}
}
