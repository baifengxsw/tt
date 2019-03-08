package cn.itcast10_list;

public class Ceshi {
	public static class Node{
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	//估计是类似 c++ 中&的形式
	public static void  setValue(Node head) {
		int i = 0 ;
		while (head!=null) {
			head.value = i;
			head = head.next;
			i++;
		}
		
	}
	
	
	
	public static Node setValue1(Node head) {
		int i = 0;
		Node cur = head;
		while(cur !=null) {
			cur.value = i;
			cur = cur.next;
			i++;
		}
		return head;
	}
	
	public static void printNode(Node head) {
		Node cur = head;
		System.out.print("list :");
		while(cur!=null) {
			System.out.print(cur.value);
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = null;
		
		printNode(head);
		
		System.out.println("-------------------------------");
		Node res = setValue1(head);
		
		printNode(res);
		
	}
}
