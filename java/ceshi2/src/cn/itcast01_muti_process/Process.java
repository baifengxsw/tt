package cn.itcast01_muti_process;
import cn.itcast01_muti_process.SetThread;
public class Process {
	public static void main(String[] args) {
		Student s  = new Student();
		SetThread t1 = new SetThread(s);
		Thread pro = new Thread(t1);
		GetThread t2 = new GetThread(s);
		Thread con = new Thread(t2);
		pro.start();
		con.start();
		
	}
}
