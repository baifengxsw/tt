package cn.itcast02_simple_basic;
/**
 * 寻找对应的丑数 ，如果有多个相同值达到某一位置  都++
 * @author baifeng
 *
 */
public class UglyNum {
	public static int getUglyNum(int n) {
		if(n < 1) 
			return -1;
		
		int count2 =0;
		int count3 =0;
		int count5 =0;
		int []arr = new int [n];
		arr[0] =1 ;
		int temp;
		for(int i = 1;i< n;i++) {
			int ret1 = arr[count2]*2;
			int ret2 = arr[count3]*3;
			int ret3 = arr[count5]*5;
			temp = Math.min(Math.min(ret2, ret1), ret3);
			arr[i] = temp;
			if(temp == ret1) {
				count2++;
			}
			if(temp == ret2) {
				count3++;
			}
			if(temp == ret3) {
				count5++;
			}
		}
		return arr[n-1];
	}
	public static void main(String[] args) {
		int res = getUglyNum(7);
		System.out.println(res);
	}
}
