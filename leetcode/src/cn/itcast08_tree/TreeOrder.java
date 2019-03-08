package cn.itcast08_tree;

import java.util.Stack;

/**
 * ¶þ²æÊ÷µÄ±éÀú 
 * @author baifeng
 *
 */
public class TreeOrder {
	public class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int value) {
			this.value = value;
		}
	}
	public void preOrderRecur(Node head) {
		if(head ==null)
			return ;
			System.out.print(head.value+" ");
			
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	public void InOrderRecur(Node head) {
		if(head == null)
			return ;
		preOrderRecur(head.left);
		
		System.out.print(head.value+" ");
			
		
		preOrderRecur(head.right);
	}
	public void posOrderRecur(Node head) {
		if(head ==null)
			return;
		
		preOrderRecur(head.left);
		preOrderRecur(head.right);
		System.out.print(head.value+" ");
	}
	public void preOrderUnrecur(Node head ) {
		if(head ==null) {
			return ;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(head);
		while(!stack.isEmpty()) {
			head = stack.pop();
			System.out.print(head.value+" ");
			if (head.right!=null) {
				stack.push(head.right);
			}
			if(head.left!=null) {
				stack.push(head.left);
			}
		}
		
		System.out.println();
	}
	
	public void InOrderUnrecur(Node head) {
		if(head == null)
			return ;
		Stack<Node> stack = new Stack<>();
		while(!stack.isEmpty()||head!=null) {
			if(head!=null) {
				stack.push(head);
				head = head.left;
			}else {
				head = stack.pop();
				System.out.print(head.value+" ");
				head = head.right;
			}
		}
		System.out.println();
	}
	
	public void posOrderUnrecur(Node head) {
		if(head == null)
			return ;
		
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> help = new Stack<Node>();
		stack.push(head);
		while(!stack.isEmpty()) {
			head = stack.pop();
			help.push(head);
			if(head.left!=null) {
				stack.push(head.left);
			}
			if(head.right!=null) {
				stack.push(head.right);
			}
		}
		while(!help.isEmpty()) {
			System.out.print(help.pop().value+" ");
		}
		
		System.out.println();
	}
	public static void posOrderUnRecur2(Node h) {
		System.out.print("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	
}
