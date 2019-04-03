package cn.itcast08_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����һ����������������Ƿ��Ǿ���ԳƵġ�

���磬������ [1,2,2,3,4,4,3] �ǶԳƵġ�

    1
   / \
  2   2
 / \ / \
3  4 4  3
 * @author baifeng
 *
 */
public class IsSymmetric {
	 public boolean isSymmetric1(TreeNode root) {
		 	if(root==null)
		 		return true;
	        return process(root.left,root.right);
	}

	private boolean process(TreeNode left, TreeNode right) {
			if(left==null&&right==null) 
				return true;
			
			if(left!=null&&right==null||left==null&&right!=null||left.val!=right.val)
				return false;
			return process(left.left,right.right)&&process(left.right,right.left);
			
		
		
	}
	//�ǵݹ�д�� ������������
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		Queue<TreeNode> queue1  = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		
		TreeNode leftNode = null;
		TreeNode rightNode = null;
		queue1.add(root.left);
		queue2.add(root.right);
		while(!queue1.isEmpty()&&!queue2.isEmpty()) {
			leftNode = queue1.poll();
			rightNode = queue2.poll();
			if(leftNode==null&&rightNode==null)
				continue;
			if(leftNode!=null&&rightNode==null||leftNode==null&&rightNode!=null||leftNode.val!=rightNode.val)
				return false;
			queue1.add(leftNode.left);
			queue2.add(rightNode.right);
			queue1.add(leftNode.right);
			queue2.add(rightNode.left);
		}
		return true;
	}
}
