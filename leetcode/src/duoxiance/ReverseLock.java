package duoxiance;

import java.util.concurrent.atomic.AtomicReference;

public class ReverseLock {
	 private AtomicReference<Thread> cas = new AtomicReference<Thread>();
	    public void lock() {
	    
	        Thread current = Thread.currentThread();
	        // ����CAS
	        //�߳�1 ���� ���ֵ�ǰ��������Ϊnull  ���� �� cas ��������Ϊcurrent�߳�
	        //���û�ͷ��� ���߳�2 ���� �����ֵ�ǰ�����Ѿ���Ϊnull �޸�ʧ�� ������whileѭ���ȴ�
	        //�߳�1�ͷ������ж��Ƿ��ǵ�ǰ�߳� ������� ���ÿ�
	        while (!cas.compareAndSet(null, current)) {
	            // DO nothing
	        }
	    }
	    public void unlock() {
	        Thread current = Thread.currentThread();
	        cas.compareAndSet(current, null);
	    }
}
