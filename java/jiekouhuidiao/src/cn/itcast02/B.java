package cn.itcast02;

public class B  implements PrintValue{
	public void  printFive(){
		System.out.println("A已经循环到了5,所以我的这个方法将会被循环调用");
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("A 已经循环到5 了 ,所以我这个方法 将会被调用 ");
		
	}
}
