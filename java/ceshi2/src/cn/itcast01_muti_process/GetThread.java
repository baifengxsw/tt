package cn.itcast01_muti_process;

public class GetThread implements Runnable {
	private Student s ;
	public GetThread(Student s) {
		this.s = s;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (s) {
				if(!s.flag) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				System.out.println(s.name+"----"+s.age);
				s.flag = false;
				s.notify();
			}
		}
	}
	
}
