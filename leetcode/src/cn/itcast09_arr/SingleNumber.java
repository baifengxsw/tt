package cn.itcast09_arr;

import java.util.Arrays;

/**
 * 只出现一次的数字
 * @author baifeng
 *
 */
public class SingleNumber {
	 public int singleNumber(int[] nums) {
	      int ret = nums[0];
	      for(int i = 1;i<nums.length;i++) {
	    	  ret = ret ^nums[i];
	      }
	      return ret;
	   }
	 
	 public static void main(String[] args) {
		int [] arr = new int [] {1,2,3,4,2,3,4};
		int [] result = Arrays.copyOfRange(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(result));
	}
}
