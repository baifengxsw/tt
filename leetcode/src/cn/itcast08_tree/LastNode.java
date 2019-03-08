package cn.itcast08_tree;



/**
 * 寻找二叉树中序遍历的上一个节点  ，与寻找后继节点相似 ，如果该节点有左子树 ，那么左子树的最右节点 就是它的前一个节点，如果相反 ，没有左子树 就一直向上找 知道
 * 找到一个节点的右儿子 是它的孩子节点
 * @author baifeng
 *
 */
public class LastNode {
	public class Node{
		public int value;
		public Node left;
		public Node right;
		public Node parent;
	}
	public Node findLastNode(Node node) {
		if(node==null) {
			return null;
		}
		if(node.left!=null) {
			//寻找左子树的最右节点  ；
			Node rightNode = node.left;
			while(rightNode.right!=null) {
				rightNode= rightNode.right;
			}
			return rightNode;
		}else {
			Node parent = node.parent;
			while(parent!=null &&node!=parent.right) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}

}
