package cn.itcast10_list;

import cn.itcast10_list.Ceshi.Node;

public class ListPaixu {
	public static class Node{
		public int value;
		public Node next;
		public Node pre;
		
		public Node(int value) {
			this.value = value;
		}
	}
	//默认无头结点
	public static  void selectSort(Node head ) {
		if(head ==null||head.next==null)
			return ;
		Node min = null;
		Node p = null;
		Node q = null;
		for(p = head;p.next!=null;p=p.next) {
			    min = p;
			for(q =p.next;q!=null;q=q.next ) {
				if(q.value<min.value) {
					min = q;
				}
			}
			if(min!=p) {
				int temp = min.value;
				min.value = p.value;
				p.value = temp;
			}
		}
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
		Node head = new Node (2);
		head.next = new Node(7);
		head.next.next = new Node(4);
		head.next.next.next = new Node(3);
		head.next.next.next.next = null;
		printNode(head);
		System.out.println("------------------------------");
		selectSort(head);
		printNode(head);
	}
}
