package cn.itcast06_stack_queue_arr;
/**
 * 打印数组中 多个数的加和等于给定值的 
 * @author baifeng
 *
 */
public class PrintUniquePairAndTriad {
	public static void printUniquePair(int [] arr, int k) {
		if(arr ==null||arr.length<2) {
			return ;
		}
		int less = 0;
		int more = arr.length-1;
		while(less < more) {
			if(arr[less]+arr[more]<k) {
				less++;
			}else if(arr[less]+arr[more]>k) {
				more --;
			}else {
				if(less==0||arr[less]!=arr[less-1]) {
					System.out.println(arr[less]+"----"+arr[more]);
					
				}
				less++;
				more--;
			}
		}
	}
	/**
	 * 下面是求三个的
	 * @param args
	 */
	public static void printUniquePair1(int [] arr,int k) {
		if(arr==null || arr.length<3) {
			return ;
		}
		for(int i = 0; i<arr.length-2 ;i++) {
			if(i==0 ||arr[i]!=arr[i-1]) {
				int end = k-arr[i];
				int less = i+1;
				int more = arr.length-1;
				while(less<more) {
					if(arr[less]+arr[more]<end) {
						less++;
					}else if (arr[less]+arr[more]>end) {
						more --;
					}else {
						if(less == i+1 || arr[less]!=arr[less-1]) {
							System.out.println(arr[i]+"----"+arr[less]+"---"+arr[more]);
						}
						less++;
						more--;
					}
				}
				
			}
		
		}
	}
	public static void main(String[] args) {
		int [] arr = {1,2,2,2,3,3,3,3,5,5,5,5,5,6,6,7};
		int [] arr1 = {1,2,2,2,3,3,3,3,4,5,5,5,5,5,6,6,7};
//		printUniquePair(arr, 8);
		printUniquePair1(arr1, 11);
	}
}
