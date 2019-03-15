package cn.itcast00_ceshi;

import java.util.LinkedList;
import java.util.List;
/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

示例 1:

输入:
    3
   / \
  9  20
    /  \
   15   7
输出: [3, 14.5, 11]
 * @author baifeng
 *
 */
public class AverageOfLevels_637 {
	public static class TreeNode{
		public int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	public static List<Double> averageOfLevels(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		double sum ;
		int i ;
		TreeNode node =null;
		LinkedList<Double> res = new LinkedList<>();
		while(!queue.isEmpty()) {
			sum =0;
			int size = queue.size();
			for( i = 0;i<size;i++) {
				node = queue.poll();
				sum = sum +node.val;
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
			}
			res.add(sum /i );
		}
	    
		return res;
	
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.left.left =null;
		root.left.right = null;
		root.right.left =null;
		root.right.right = null;
		averageOfLevels(root);
	}
}
