package duoxiance;
/**
 * �ڴ�ģ�͵Ŀɼ���
 * @author baifeng
 *
 */
public class Ceshi2 implements Runnable {
	public  boolean flag = true;
	@Override
	public void run() {
		System.out.println("���߳̿�ʼ����");
		while(flag) {
			
		}
		System.out.println("���߳����н���");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Ceshi2 ceshi2 = new Ceshi2();
		Thread t1 = new Thread(ceshi2);
		Thread.sleep(1000);
		t1.start();
		Thread.sleep(2000);
		ceshi2.flag=false;
	}

}
