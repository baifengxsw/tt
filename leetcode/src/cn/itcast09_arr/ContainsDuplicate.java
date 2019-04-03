package cn.itcast09_arr;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:

输入: [1,2,3,1]
输出: true
 * @author baifeng
 *
 */
public class ContainsDuplicate {
	 public boolean containsDuplicate1(int[] nums) {
		 HashMap<Integer,Integer> map = new HashMap<>();
	        for(int i = 0;i<nums.length;i++) {
	        	if(!map.containsKey(nums[i])) {
	        		map.put(nums[i], 1);
	        	}else {
	        		map.put(nums[i],map.get(nums[i])+1);
	        	}
	        }
	        for(Integer key:map.keySet()) {
	        	Integer value = map.get(key);
	        	if(value >= 2)
	        		return true;
	        }
	        return false;
	    }
	 
	 //比哈希表快了4倍
	 public boolean containsDuplicate(int[] nums) {
		//先进行排序 ，看与相邻位置是否相等
		 Arrays.sort(nums);
		 for(int i = 1 ;i<nums.length;i++) {
			 if(nums[i]==nums[i-1])
				 return true;
			 
		 }
		 return false;
	 }
}
