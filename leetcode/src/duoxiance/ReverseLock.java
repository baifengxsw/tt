package duoxiance;

import java.util.concurrent.atomic.AtomicReference;

public class ReverseLock {
	 private AtomicReference<Thread> cas = new AtomicReference<Thread>();
	    public void lock() {
	    
	        Thread current = Thread.currentThread();
	        // 利用CAS
	        //线程1 进出 发现当前对象引用为null  所以 将 cas 引用设置为current线程
	        //如果没释放锁 ，线程2 进来 ，发现当前引用已经不为null 修改失败 ，进入while循环等待
	        //线程1释放锁，判断是否是当前线程 ，如果是 则置空
	        while (!cas.compareAndSet(null, current)) {
	            // DO nothing
	        }
	    }
	    public void unlock() {
	        Thread current = Thread.currentThread();
	        cas.compareAndSet(current, null);
	    }
}
