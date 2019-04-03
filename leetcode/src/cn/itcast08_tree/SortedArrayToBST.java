package cn.itcast08_tree;
/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 * @author baifeng
 *
 */
public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums ==null)
			return null;
		int left = 0;
		int right = nums.length-1;
		return process(nums,left ,right );
    }

	public TreeNode process(int[] nums, int left, int right) {
		if(left>right)
			return null;
		int mid = left+(right-left)/2;
		TreeNode head = new TreeNode(nums[mid]);
		head.left = process(nums, left, mid-1);
		head.right = process(nums, mid+1,right);
		return head;
	}
}
