package duoxiance;
/**
 * 生产者消费者模型
 * @author baifeng
 *
 */
class Resouce{
	public int value=0;
	boolean flag = false;
}


class Produce implements Runnable{
	private Resouce res ;
	public Produce(Resouce res) {
		this.res = res;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (res) {
			
				if(res.flag) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				if(res.value<100) {
				System.out.println(Thread.currentThread().getName()+":"+(++res.value));
				}
				res.flag=true;
				res.notify();
			}
		}
		
	}
	
}
class Comsumer implements Runnable{
	private Resouce res ;
	public Comsumer(Resouce res) {
		this.res = res;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (res) {
				
				
				if(!res.flag) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				if(res.value>0) {
				System.out.println(Thread.currentThread().getName()+":"+(--res.value));
				}
				res.flag=false;
				res.notify();
			}
		}
	}
	
}
public class Comsumer_produce{
	public static void main(String[] args) {
		Resouce res = new Resouce();
		Comsumer comsumer = new Comsumer(res);
		Produce produce = new Produce(res);
		Thread t1 = new Thread(comsumer);
		t1.setName("c1");
		Thread t2 = new Thread(comsumer);
		t2.setName("c2");
		Thread t3 = new Thread(produce);
		t3.setName("p1");

		Thread t4 = new Thread(produce);
		t4.setName("p2");
		Thread t5 = new Thread(produce);
		t5.setName("p3");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}
}
