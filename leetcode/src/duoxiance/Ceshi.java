package duoxiance;

/**
 * 设置锁
 * @author baifeng
 *
 */
public class Ceshi implements Runnable{
	private static Object obj1 = new Object();
	private static Object obj2 = new Object();
	boolean flag ;
	public Ceshi(boolean flag) {
		this.flag = flag;
	}
	@Override
	public void run() {
		if(flag) {
			synchronized (obj1) {
				System.out.println(Thread.currentThread().getName()+"进入1锁");
				synchronized (obj2) {
					System.out.println(Thread.currentThread().getName()+"进入2锁");
				}
				
			}
		}else {
			synchronized (obj2) {
				System.out.println(Thread.currentThread().getName()+"进入2锁");
				synchronized (obj1) {
					System.out.println(Thread.currentThread().getName()+"进入1锁");
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Ceshi ceshi1 = new Ceshi(true);
		Ceshi ceshi2 = new Ceshi(false);
		new Thread(ceshi1).start();
		new Thread(ceshi2).start();
	
	}

}
