package duoxiance;

class Res {
	public volatile int num =0;
}
class Son implements Runnable{
	private Res res;
	private boolean flag =true;
	Son(Res res){
		this.res = res;
	}
	@Override
	public void run() {
		System.out.println("���߳̿�ʼ�ȴ�");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//where(Thread.currentThread.isinterupt //sleep �����������
		try {
			while(!Thread.currentThread().isInterrupted()) {
				Thread.sleep(100);
				System.out.println("son"+res.num++);
			}
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	public void stopProcess() {
		flag = false;
	}
}

public class StopProcess {
	
	public static void main(String[] args) throws InterruptedException {
		Res res = new Res();
		Son son = new Son(res);
		Thread t1 = new Thread(son);
		t1.start();
		Thread.sleep(2000);
			System.out.println("main"+res.num);
			t1.interrupt();//�жϽ��еȴ��Ľ��� �����쳣
		

	}

}
