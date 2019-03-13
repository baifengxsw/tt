package cn.itcast02_simple_basic;
/**
 * 实现int数字的逆序
 * @author baifeng
 *
 */
public class ReverseInt {
	public static int reverse(int x) {
		int low = 0;
		long res = 0;
		while(x!=0) {
			low = x%10;
			x = x/10;
			res = res*10+low;
			if(res >=Integer.MAX_VALUE||res<=Integer.MIN_VALUE)
				return 0;
		}
		return (int)res;
	}
	
	public static void main(String[] args) {
		int i = 560;
		int ret  =reverse(i);
		System.out.println("ret:"+ret);
		
	}
}
