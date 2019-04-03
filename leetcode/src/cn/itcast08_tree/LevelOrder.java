package cn.itcast08_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ���ķ��ض������Ĳ�α����ڵ�
 * @author baifeng
 *����һ���������������䰴��α����Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��

����:
����������: [3,9,20,null,null,15,7],

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
	        	List<Integer> list = new ArrayList<>(); //����ÿһ������нڵ�
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
