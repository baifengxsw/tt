package cn.itcast08_tree;

import java.util.Stack;

/**
 * ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������

����һ��������������������������

�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
�ڵ��������ֻ�������ڵ�ǰ�ڵ������
�������������������������Ҳ�Ƕ�����������
ʾ�� 1:

����:
    2
   / \
  1   3
���: true
�������ʱ�򲻽�Ҫ���ǵ�ǰ�ڵ� ��
 * @author baifeng
 *
 */
public class IsValidBST {
	 public boolean isValidBST1(TreeNode root) {
	        if(root ==null)
	        	return true;
	        
	        return process(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}

	public boolean process(TreeNode root ,long low ,long high) {
		if(root == null)
			return true;
		if(root.val<=low||root.val>=high)
			return false;
		return process(root.left,low,root.val)&&process(root.right,root.val,high);
}
	//�������������
	
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode p = root, pre = null;
		while(p!=null||!s.empty()) {
			while(p!=null) {
				s.push(p);
				p=p.left;
			}
			p = s.pop();
			if(pre!=null&&p.val<=pre.val) {
				return false;
			}
			pre = p;
			p = p.right;
		}
		return true;
	}
	
}