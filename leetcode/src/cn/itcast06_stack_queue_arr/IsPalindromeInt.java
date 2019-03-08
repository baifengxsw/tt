package cn.itcast06_stack_queue_arr;
/**
 * 传入一个int 值 如何判断是否是回文数  ，要求常数项尽可能少
 * @author baifeng
 *
 */
public class IsPalindromeInt {
	public static boolean isPalindromeInt(int n) {
		if(n <0) 
		return false;
		int help = 1;
		while(n/help>=10) {
			help*=10;
		}
		while(n>0) {
			if(n/help != n%10) {
				return false;
			}
			n = (n%help)/10;
			help /=100;
		}
		return true;
		
	}
	public static void main(String[] args) {
		int n = 12321;
		System.out.println("res:"+isPalindromeInt(n));
		
	}
}
