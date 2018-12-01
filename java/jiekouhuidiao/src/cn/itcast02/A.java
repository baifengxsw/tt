package cn.itcast02;

public class A {
	/**
	 * 假设这是以前的java基础使用的代码 
	 * 但是进行假设 ,这个A的这个类是早早写好的 A
	 * 就会出现下面2个问题 
	 * 1; 不能直接new  B
	 * 2; 不能直接传递B的实列进来 
	 * 因为它根本不知道B
	 * A定义一个接口 ,相应的B传递一个对应的接口实列过来 
	 * 所以在定义这个方法的时候,不管未来写的是B类,还是C类,还是D类
	 * 所以定义了一种接口,只要让未来的那些类来实现这个接口 ,然后这个方法参数类型写接口类型就可以了
	 */
	private PrintValue pv ;
	public A(PrintValue pv){
		this .pv = pv;
	}
	public void print( ){
		for ( int i = 0; i<10;i++){
			System.out.println("循环到了--"+i);
			if( 5==i){
				System.out.println("循环到了5,该通知B了--");
				//按以前的操作 ,new 一个 或者 调用静态方法 
				pv.print();
			}
		}
	}
}
