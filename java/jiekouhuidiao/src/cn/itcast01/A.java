package cn.itcast01;

public class A {
	
	public void print(){
		for ( int i = 0; i<10;i++){
			System.out.println("循环到了--"+i);
			if( 5==i){
				System.out.println("循环到了5,该通知B了--");
				//按以前的操作 ,new 一个 或者 调用静态方法 
			}
		}
	}
}
