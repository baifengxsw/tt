package cn.itcast08_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����һ�����������ҳ��������ȡ�

�����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

ʾ����
���������� [3,9,20,null,null,15,7]��

    3
   / \
  9  20
    /  \
   15   7
�������������� 3 ��
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
	
	//ÿһ�ν�����һ�е�����ֱ�Ӽӽ���  Ȼ��ͳ�������ͺ���
	public int maxDepth(TreeNode root) {
		//���в�α���
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
