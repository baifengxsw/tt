package cn.itcast09_arr;
/**
 * ֻ����һ�ε�����
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
