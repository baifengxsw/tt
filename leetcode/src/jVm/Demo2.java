package jVm;
/**
 * finalize 和GC的关系
 * @author baifeng
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		//初始化堆，设置小作用
		Ceshi1 ceshi1 = new Ceshi1();
		ceshi1=null;
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 只是去通知gc去回收 ，并不是百分百的去回收 如果想要概率比较大点 直接设置为null 方便回收
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
			
	}
}
