package cn.itcast08_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 逐层的返回二叉树的层次遍历节点
 * @author baifeng
 *给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
 */
public class LevelOrder {
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> retList = new ArrayList<>();
	        Queue<TreeNode> queue = new LinkedList<>();
	        if(root ==null)
	        	return retList;
	        TreeNode p = null;
	        queue.add(root);
	        int size = 0;
	        while(!queue.isEmpty()) {
	        	size = queue.size();
	        	List<Integer> list = new ArrayList<>(); //保存每一层的所有节点
	        	for(int i = 0;i<size ;i++) {
	        		p = queue.poll();
	        		list.add(p.val);
	        		if(p.left!=null)
	        			queue.add(p.left);
	        		if(p.right!=null)
	        			queue.add(p.right);
	        	}
	        	retList.add(list);
	        	
	        		
	        }
	        return retList;
	 }
}
