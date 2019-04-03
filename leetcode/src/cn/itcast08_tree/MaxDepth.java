package cn.itcast08_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 * @author baifeng
 *
 */
public class MaxDepth {
	public int maxDepth1(TreeNode root) {
        if(root==null) {
        	return 0;
        }
        return process(root);
    }

	private int process(TreeNode root) {
		if(root ==null)
			return 0;
		int left  = process(root.left);
		int right = process(root.right);
		return Math.max(left, right)+1;
	}
	
	//每一次将整个一行的数据直接加进来  然后统计行数就好了
	public int maxDepth(TreeNode root) {
		//进行层次遍历
		if(root==null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int ret =0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			ret++;
			for(int i = 0;i<size;i++) {
			TreeNode cur = queue.poll();
			if(cur.left!=null)
				queue.add(cur.left);
			if(cur.right!=null)
				queue.add(cur.right);
			}
		}
		return ret;
	}
}
