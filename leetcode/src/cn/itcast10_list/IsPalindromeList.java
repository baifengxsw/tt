package cn.itcast10_list;

import java.util.Stack;

import cn.itcast10_list.IsPalindromeList.Node;

/**
 * �ж������Ƿ��ǻ�������  ��ͷ�ڵ�
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
	//����һ��Ҫn���ȵ�ջ
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
	//��������Ҫn/2���ȵ�ջ 
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
	
	//���������� ֻ��O��1���Ŀռ� 
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
		//���м�ƫ�󲿷ֽ�������
		while(right!=null) {
			temp = right.next;
			right.next= cur;
			cur=right;
			right = temp;
		}
		temp = cur;//�������һ���ڵ� 
		right  = head;
		while(cur!=null&&right!=null) {
			if(cur.value!=right.value) {
				return false;
			}
			cur=cur.next;
			right = right.next;
		}
		
		//��ԭ������и�λ 
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
