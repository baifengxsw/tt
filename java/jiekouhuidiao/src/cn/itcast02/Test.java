package cn.itcast02;

public class Test {
	public static void main(String[] args) {
		B b = new B();
		A a = new A(b);
		a.print();
	}
}
