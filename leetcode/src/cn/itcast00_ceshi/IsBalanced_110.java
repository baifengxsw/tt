package cn.itcast00_ceshi;

import cn.itcast00_ceshi.AverageOfLevels_637.TreeNode;

/**
 * ����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������

�����У�һ�ø߶�ƽ�����������Ϊ��

һ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������1��

ʾ�� 1:

���������� [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
 * @author baifeng
 *
 */
public class IsBalanced_110 {
	public static class TreeNode{
		public int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	public boolean isBalanced1(TreeNode root) {
	        if(root==null)
	        	return true;
	        int res = Math.abs(getDepth(root.left)-getDepth(root.right));
	        if(res >1)
	        	return false;
	        return isBalanced(root.left)&&isBalanced(root.right);
	        
	    }
	private int getDepth(TreeNode root) {
		 if(root ==null)
			 return 0;
		 return Math.max(getDepth(root.left), getDepth(root.right))+1;
	}
	
	public boolean  isBalanced(TreeNode root) {
		if(root == null)
			return true;
		int res = process(root);
		return res!=-1;
		
	}
	private int process(TreeNode root) {
		if(root ==null)
			return 0;
		int left = process(root.left);
		if(left == -1)
			return -1;
		int right = process(root.right);
		if(right==-1)
			return -1;
		int res = Math.abs(right -left);
		if(res>1) 
			return -1;
		else 
			
		return Math.max(left, right)+1;
		
	}
}	
