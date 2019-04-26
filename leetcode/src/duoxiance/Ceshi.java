package duoxiance;

/**
 * ������
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
				System.out.println(Thread.currentThread().getName()+"����1��");
				synchronized (obj2) {
					System.out.println(Thread.currentThread().getName()+"����2��");
				}
				
			}
		}else {
			synchronized (obj2) {
				System.out.println(Thread.currentThread().getName()+"����2��");
				synchronized (obj1) {
					System.out.println(Thread.currentThread().getName()+"����1��");
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
