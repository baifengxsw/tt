package cn.itcast08_tree;



/**
 * Ѱ�Ҷ����������������һ���ڵ�  ����Ѱ�Һ�̽ڵ����� ������ýڵ��������� ����ô�����������ҽڵ� ��������ǰһ���ڵ㣬����෴ ��û�������� ��һֱ������ ֪��
 * �ҵ�һ���ڵ���Ҷ��� �����ĺ��ӽڵ�
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
			//Ѱ�������������ҽڵ�  ��
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
