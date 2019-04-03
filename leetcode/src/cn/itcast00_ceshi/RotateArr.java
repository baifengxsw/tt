package cn.itcast00_ceshi;
/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
要求空间为O（1）
//还可以翻转
 * @author baifeng
 *
 */

public class RotateArr {
	
	 public void rotate(int[] nums, int k) {
		if(nums==null ||nums.length<2||k%nums.length == 0)
			return ;
		 
		int start = 0,len = nums.length;//结束相应的循环 
		int pre ,cur = nums[0];
		int x ;//定位
		for(int i = 0;i<len;i++) {
			pre = cur ;
			x = (i+k)%len;
			cur = nums[x];
			nums[x] = pre;
			if(x ==start) {
				x = ++start;
				cur = nums[x];
			}
			
		}
	}
}
