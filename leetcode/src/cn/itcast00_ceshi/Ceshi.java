package cn.itcast00_ceshi;

public class Ceshi {
	public static void main(String[] args) {
		String s1 ="hello";
		String s2 = "world";
		String s3 = "helloworldl";
		String s4 = "hello"+"world";
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		
		
		
		
		
		System.out.println(s3 == s1+s2);
		System.out.println(s3.equals((s1+s2)));
		System.out.println(s3 =="hello"+"world");
		System.out.println(s3.equals("hello"+"world"));
		
	}
	
}
