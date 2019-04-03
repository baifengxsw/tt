package cn.itcast09_arr;
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
}
