package duoxiance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;



/**
 * ���Զ�д��
 * @author baifeng
 *
 */
public class Read_Write {
	private volatile static Map<String,Object> map = new HashMap<>();
	private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	static ReadLock r = rwl.readLock();
	static WriteLock w = rwl.writeLock();
	
	public static void write(String key ,String value) {
		w.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"��ʼд��");
			Thread.sleep(100);
			map.put(key,value);
			System.out.println(Thread.currentThread().getName()+"д�����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			w.unlock();
		}

	}
	public static void read(String key) {
		r.lock();
		try {
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName()+":key:"+map.get(key));
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			r.unlock();
		}
	}
	public static void main(String[] args) {
		//д�߳�
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0;i<10;i++) {
					Read_Write.write(i+"", i+"");
				}
			}
		}).start();
		//���߳�
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0;i<10 ;i++) {
					Read_Write.read(i+"");
				}
			}
		}).start();
	}
}
