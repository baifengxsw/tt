package cn.itcast08_tree;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
在输入的时候不仅要考虑当前节点 和
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
	//利用中序遍历做
	
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