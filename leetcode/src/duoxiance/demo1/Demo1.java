package duoxiance.demo1;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	
	private static List<User> init() {
		List<User> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(new User("xia"+i,"dsf"+i));
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<User> list = init();
		List<List<User>> retList  = Utils.splitList(list, 3);
		for(List<User>perList:retList) {
			Thread t1  = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					for(User user:perList) {
						System.out.println(Thread.currentThread().getName()+user);
			}
				}
			});
			t1.start();
			System.out.println();
		}
	}
}
