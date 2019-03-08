package cn.itcast04_dongtaiguihua;

public class HannuoTa {
	
	public static void printHanoi(int n ) {
	
		if(n<1)
			return ;
		
		print(n,"a","b","c");
	}

	private static void print(int n, String a, String b, String c) {
		if( n == 1) {
		   System.out.println("´Ó"+a+"ÒÆ¶¯µ½"+c);
		  return ;
		}
		print(n-1,a,c,b);
		print(1,a,b,c);
		print(n-1,b,a,c);
	}
	
	public static void main(String[] args) {
		printHanoi(2);
	}
	
}
