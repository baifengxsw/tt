package jVm;
/**
 * finalize ��GC�Ĺ�ϵ
 * @author baifeng
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		//��ʼ���ѣ�����С����
		Ceshi1 ceshi1 = new Ceshi1();
		ceshi1=null;
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	/**
	 * ֻ��ȥ֪ͨgcȥ���� �������ǰٷְٵ�ȥ���� �����Ҫ���ʱȽϴ�� ֱ������Ϊnull �������
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
			
	}
}
