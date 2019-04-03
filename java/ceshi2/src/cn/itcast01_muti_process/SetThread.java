package cn.itcast01_muti_process;

public class SetThread implements Runnable{
	private Student s ;
	private int x;
	public SetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (s) {
				if(s.flag) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				if(x%2==0) {
				s.age = 10;
				s.name = "xia";
				}else {
				s.age = 100;
				s.name = "shuang";
				}
				s.flag = true;
				s.notify();
				x++;
			}
		}
		
	}
	
	
}
