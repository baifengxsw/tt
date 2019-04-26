package duoxiance;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * jdk 1.5  lock 的使用
 * @author baifeng
 *
 */
class Resouce1{
	public int value=0;
	boolean flag = false;
	Lock lock  = new ReentrantLock();
}


class Produce1 implements Runnable{
	private Resouce1 res ;
	private Condition condition;
	public Produce1(Resouce1 res,Condition condition) {
		this.res = res;
		this.condition=condition;
	}
	@Override
	public void run() {
		while(true) {
			
				//Condition condition = res.lock.newCondition();每次都是一个新的condition
				try {
					res.lock.lock();
					if(res.flag) {
						condition.await();
					}
					if(res.value<100) {
					System.out.println(Thread.currentThread().getName()+":"+(++res.value));
					}
					res.flag=true;
					condition.signal();
				} catch (Exception e) {
					res.lock.unlock();
				}
			}
		}
		
	}
	

class Comsumer1 implements Runnable{
	private Resouce1 res ;
	private Condition condition;
	public Comsumer1(Resouce1 res,Condition condition) {
		this.res = res;
		this.condition = condition;
	}
	@Override
	public void run() {
		while(true) {
				
				try {
					res.lock.lock();
					if(!res.flag) {
						condition.await();
					}
					if(res.value>0) {
					System.out.println(Thread.currentThread().getName()+":"+(--res.value));
					}
					res.flag=false;
					condition.signal();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
					res.lock.unlock();
				}
			}
		}
	}
	


public class Lock1 {
	public static void main(String[] args) {
		Resouce1 res1 = new Resouce1();
		Condition condition = res1.lock.newCondition();
		Comsumer1 comsumer = new Comsumer1(res1,condition);
		Produce1 produce = new Produce1(res1,condition);
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
