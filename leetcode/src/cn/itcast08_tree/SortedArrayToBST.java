package cn.itcast08_tree;
/**
 * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������

�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��

ʾ��:

������������: [-10,-3,0,5,9],

һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������

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
