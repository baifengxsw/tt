package cn.itcast00_ceshi;

public class ArrangeCoins {
	public static int arrangeCoins(int n) {
		  if(n == 0)
				return 0;
			int i = 0 ;
	        while(n>=(i+1)){
	            i++;
	            n = n-i;
	        }
	        return i;
	}
	public static void main(String[] args) {
		int n = 8;
		int res = arrangeCoins(n);
		System.out.println(res);
	}
}
