package cn.itcast10_list;

import java.util.Stack;

import cn.itcast10_list.IsPalindromeList.Node;

/**
 * 判断链表是否是回文链表  无头节点
 * @author baifeng
 *
 */
public class IsPalindromeList {
	public static class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	//方法一需要n长度的栈
	public static boolean isPalindrome1(Node head) {
		if(head==null||head.next==null)
			return true ;
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur!=null) {
			stack.push(cur);
			cur=cur.next;
		}
		cur = head;
		while(cur!= null) {
			if(cur.value!=stack.pop().value) {
				return false;
			}
			cur = cur.next;
		}
		return true;
	}
	//方法二需要n/2长度的栈 
	public static boolean isPalindrome2(Node head) {
		if(head ==null ||head.next == null)
			return true;
		Node right =  head;
		Node cur = head;
		while(right.next!=null && right.next.next!=null) {
			cur =cur.next;
			right=right.next.next;
		}
		Stack <Node> stack = new Stack<Node>();
		cur= cur.next;
		while(cur!=null) {
			stack.push(cur);
			cur = cur.next;
		}
		cur = head;
		while(cur!=null&&!stack.isEmpty()) {
			if(cur.value != stack.pop().value)
				return false;
			cur= cur.next;
		}
		return true;
	}
	
	//方法三可以 只用O（1）的空间 
	public static boolean isPalindrome3(Node head) {
		if(head ==null ||head.next == null)
			return true;
		Node right =  head;
		Node cur = head;
		while(right.next!=null && right.next.next!=null) {
			cur =cur.next;
			right=right.next.next;
		}
		
		right = cur.next;
		cur.next = null;
		Node temp = null ;
		//将中间偏后部分进行逆序
		while(right!=null) {
			temp = right.next;
			right.next= cur;
			cur=right;
			right = temp;
		}
		temp = cur;//保存最后一个节点 
		right  = head;
		while(cur!=null&&right!=null) {
			if(cur.value!=right.value) {
				return false;
			}
			cur=cur.next;
			right = right.next;
		}
		
		//将原链表进行复位 
		cur = temp;
		right = cur.next;
		cur.next = null;
		while(right!=null) {
			temp = right.next;
			right.next = cur;
			cur= right;
			right = temp;
		}
		return true ;
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(2);
		Node node5 = new Node(3);
		node1.next = node2;
		node2.next = node3;
		node3.next  = node4;
		node4.next = node5 ;
		node5.next = null;
		boolean ret = isPalindrome1(node1);
		System.out.println(ret);
		
	}
}
