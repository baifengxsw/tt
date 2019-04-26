package duoxiance;
/**
 * 进行 threadlocal 的测试
 * @author baifeng
 *
 */
class res1{
	ThreadLocal<Integer> count  = new ThreadLocal<Integer>() {

		@Override
		protected Integer initialValue() {
			// TODO 自动生成的方法存根
			return 0;
		}
		
	};
	public int get() {
		count.set(count.get()+1);
		return count.get();
	}
}
class son1 implements Runnable{
	private res1 r;
	public son1(res1 r) {
		this.r = r;
	}
	@Override
	public void run() {
		for(int i = 0;i<3;i++) {
			System.out.println(Thread.currentThread().getName()+":"+r.get());
		}
		
	}
	
}
public class ThreadLocal1 {
	public static void main(String[] args) {
		res1 r = new res1();
		son1 s = new son1(r);
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s);
		Thread t3 = new Thread(s);
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}
